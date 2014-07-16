package com.gemantic.memcached.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gemantic.dal.cache.client.CacheClient;
import com.gemantic.memcached.channel.MemcachedChannel;
import com.gemantic.memcached.channel.source.MemcachedSource;
import com.gemantic.memcached.exception.NestedIOException;
import com.gemantic.memcached.handler.ErrorHandler;
import com.gemantic.memcached.handler.NativeHandler;
import com.gemantic.memcached.io.GetInputStreamWrapper;
import com.gemantic.memcached.io.IncrOrDecrInputStreamWrapper;
import com.gemantic.memcached.io.SetInputStreamWrapper;
import com.gemantic.memcached.stream.ContextObjectInputStream;
import com.gemantic.memcached.util.MemcachedUtils;

public class MemCachedClientImpl implements CacheClient {
	// return codes
	public static final String VALUE = "VALUE"; // start of value line from
	// server
	public static final String STATS = "STAT"; // start of stats line from
	// server
	public static final String ITEM = "ITEM"; // start of item line from
	// server
	public static final String DELETED = "DELETED"; // successful deletion
	public static final String NOTFOUND = "NOT_FOUND"; // record not found for
	// delete or incr/decr
	public static final String STORED = "STORED"; // successful store of data
	public static final String NOTSTORED = "NOT_STORED"; // data not stored
	public static final String OK = "OK"; // success
	public static final String END = "END"; // end of data from server

	public static final String ERROR = "ERROR"; // invalid command name from
	// client
	public static final String CLIENT_ERROR = "CLIENT_ERROR"; // client error
	// in input line
	// - invalid
	// protocol
	public static final String SERVER_ERROR = "SERVER_ERROR"; // server error

	public static final byte[] B_END = "END\r\n".getBytes();
	public static final byte[] B_NOTFOUND = "NOT_FOUND\r\n".getBytes();
	public static final byte[] B_DELETED = "DELETED\r\r".getBytes();
	public static final byte[] B_STORED = "STORED\r\r".getBytes();
	// values for cache flags
	public static final int MARKER_BYTE = 1;
	public static final int MARKER_BOOLEAN = 8192;
	public static final int MARKER_INTEGER = 4;
	public static final int MARKER_LONG = 16384;
	public static final int MARKER_CHARACTER = 16;
	public static final int MARKER_STRING = 32;
	public static final int MARKER_STRINGBUFFER = 64;
	public static final int MARKER_FLOAT = 128;
	public static final int MARKER_SHORT = 256;
	public static final int MARKER_DOUBLE = 512;
	public static final int MARKER_DATE = 1024;
	public static final int MARKER_STRINGBUILDER = 2048;
	public static final int MARKER_BYTEARR = 4096;
	public static final int F_COMPRESSED = 2;
	public static final int F_SERIALIZED = 8;
	private static Logger log = Logger.getLogger(MemCachedClientImpl.class);
	private MemcachedSource source;
	private ErrorHandler errorHandler;

	// flags
	private boolean sanitizeKeys;
	private boolean primitiveAsString;
	private boolean compressEnable = false;
	private long compressThreshold = 128;
	private String defaultEncoding;

	private ClassLoader classLoader = null;

	public MemCachedClientImpl() {
		// TODO Auto-generated constructor stub
	}

	public MemCachedClientImpl(MemcachedSource source) {
		this.source = source;
	}

	public void setSource(MemcachedSource source) {
		this.source = source;
	}

	public boolean remove(String key) {
		return this.delete(key, null);
	}

	public boolean delete(String key) {

		return this.delete(key, null);
	}

	public boolean delete(String key, Date expiry) {
		if (key == null) {
			log.error("null value for key passed to delete()");
			return false;
		}

		try {
			key = MemcachedUtils.sanitizeKey(sanitizeKeys, key);
		} catch (UnsupportedEncodingException e) {

			// if we have an errorHandler, use its hook
			if (errorHandler != null)
				errorHandler.handleErrorOnGet(this, e, key);

			log.error("failed to sanitize your key!", e);
			return false;
		}

		// get SockIO obj using cache key
		MemcachedChannel channel = null;
		try {
			channel = source.getMemcachedChannel();
		} catch (Exception e1) {
			log.error("error : " + e1.getMessage());
			e1.printStackTrace();
		}

		if (channel == null) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, new IOException("no channel to server available"), key);
			return false;
		}

		// build command
		StringBuilder command = new StringBuilder("delete ").append(key);
		if (expiry != null) {
			command.append(" " + expiry.getTime() / 1000);
		}

		command.append("\r\n");

		try {
			channel.write(command.toString().getBytes());
			channel.flush();

			// if we get appropriate response back, then we return true
			String line = channel.readLine();
			if (DELETED.equals(line)) {
				if (log.isDebugEnabled()) {
					log.info("deletion of key: " + key + " from cache was a success");
				}
				return true;
			} else if (NOTFOUND.equals(line)) {
				if (log.isDebugEnabled()) {
					log.info("deletion of key: " + key + " from cache failed as the key was not found");
				}
			} else {
				log.error("error deleting key: " + key);
				log.error("server response: " + line);
			}
		} catch (IOException e) {
			// if we have an errorHandler, use its hook
			if (errorHandler != null)
				errorHandler.handleErrorOnDelete(this, e, key);

			// exception thrown
			log.error("exception thrown while writing bytes to server on delete");
			log.error(e.getMessage(), e);
		} finally {
			closeMemcachedChannel(channel, key);
		}
		return false;
	}

	public boolean flushAll() {
		return false;
	}

	public Object get(String key) {
		boolean asString = false;
		if (StringUtils.isBlank(key)) {
			log.error("key is null for get()");
			return null;
		}

		try {
			key = MemcachedUtils.sanitizeKey(sanitizeKeys, key);
		} catch (UnsupportedEncodingException e) {

			// if we have an errorHandler, use its hook
			if (errorHandler != null)
				errorHandler.handleErrorOnGet(this, e, key);

			log.error("failed to sanitize your key!", e);
			return null;
		}

		// get SockIO obj using cache key
		MemcachedChannel channel = null;
		try {
			channel = source.getMemcachedChannel();
		} catch (Exception e1) {
			log.error("error : " + e1.getMessage());
			e1.printStackTrace();
		}

		if (channel == null) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, new IOException("no channel to server available"), key);
			return null;
		}

		try {
			StringBuffer sb = new StringBuffer();
			sb.append("get ").append(key).append("\r\n");
			channel.write(sb.toString().getBytes());
			channel.flush();

			// ready object
			Object o = null;
			GetInputStreamWrapper getInputStreamWrapper = new GetInputStreamWrapper(channel);
			while (true) {
				String line = getInputStreamWrapper.readKeys(key);

				if (line.startsWith(VALUE)) {
					String[] info = line.split(" ");
					// info[1] 就是Key
					int flag = Integer.parseInt(info[2]);
					int length = Integer.parseInt(info[3]);

					// if (log.isDebugEnabled()) {
					// log.debug("key: " + key);
					// log.debug("flags: " + flag);
					// log.debug("length: " + length);
					// }

					// read obj into buffer
					byte[] buf = new byte[length];
					getInputStreamWrapper.read(buf);
					getInputStreamWrapper.clearEOL();

					if ((flag & F_COMPRESSED) == F_COMPRESSED) {
						try {
							GZIPInputStream gzi = new GZIPInputStream(new ByteArrayInputStream(buf));
							ByteArrayOutputStream bos = new ByteArrayOutputStream(buf.length);

							int count;
							byte[] tmp = new byte[2048];
							while ((count = gzi.read(tmp)) != -1) {
								bos.write(tmp, 0, count);
							}

							// store uncompressed back to buffer
							buf = bos.toByteArray();
							gzi.close();
						} catch (IOException e) {

							// if we have an errorHandler, use its hook
							if (errorHandler != null)
								errorHandler.handleErrorOnGet(this, e, key);

							log.error("IOException thrown while trying to uncompress input stream for key: " + key);
							log.error(e.getMessage(), e);
							throw new NestedIOException("IOException thrown while trying to uncompress input stream for key: " + key, e);
						}
					}

					// we can only take out serialized objects
					if ((flag & F_SERIALIZED) != F_SERIALIZED) {
						if (primitiveAsString || asString) {
							// pulling out string value
							log.info("retrieving object and stuffing into a string.");
							o = new String(buf, defaultEncoding);
						} else {
							// decoding object
							try {
								o = NativeHandler.decode(buf, flag);
							} catch (Exception e) {

								// if we have an errorHandler, use its hook
								if (errorHandler != null)
									errorHandler.handleErrorOnGet(this, e, key);

								log.error("++++ Exception thrown while trying to deserialize for key: " + key, e);
								throw new NestedIOException(e);
							}
						}
					} else {
						// deserialize if the data is serialized

						ContextObjectInputStream ois = new ContextObjectInputStream(new ByteArrayInputStream(buf), classLoader);
						try {
							o = ois.readObject();
							// if (log.isDebugEnabled()) {
							// log.info("deserializing " + o.getClass());
							// }
						} catch (ClassNotFoundException e) {

							// if we have an errorHandler, use its hook
							if (errorHandler != null)
								errorHandler.handleErrorOnGet(this, e, key);

							log.error("ClassNotFoundException thrown while trying to deserialize for key: " + key, e);
							throw new NestedIOException("+++ failed while trying to deserialize for key: " + key, e);
						}
					}
				} else if (END.equals(line)) {
					// if (log.isDebugEnabled())
					// log.debug("finished reading from cache server");
					break;
				} else { // 2009 - 07 -20 死循环
					log.error("server error: " + StringUtils.defaultIfEmpty(line, ""));
					channel.setHealth(true);
					break;
				}
			}
			return o;
		} catch (IOException e) {

			if (errorHandler != null)
				errorHandler.handleErrorOnGet(this, e, key);

			log.error("++++ exception thrown while trying to get object from cache for key: " + key);
			log.error(e.getMessage(), e);
		} finally {
			closeMemcachedChannel(channel, key);
		}
		return null;
	}

	public boolean replace(String key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean replace(String key, Object value, Date expiry) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean set(String key, Object value) {
		return this.set(key, value, null);
	}

	public boolean set(String key, Object value, Long seconds) {
		if (seconds == null)
			seconds = 0l;
		String cmdName = "set";
		try {
			key = MemcachedUtils.sanitizeKey(sanitizeKeys, key);
		} catch (UnsupportedEncodingException e) {

			// if we have an errorHandler, use its hook
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, e, key);

			log.error("failed to sanitize your key!", e);
			return false;
		}

		if (value == null) {
			log.error("trying to store a null value to cache");
			return false;
		}



		boolean asString = false;
		// store flags
		int flags = 0;

		// byte array to hold data
		byte[] val;

		if (NativeHandler.isHandled(value)) {

			if (asString) {
				try {
					log.info("storing data as a string for key: " + key + " for class: " + value.getClass().getName());
					val = value.toString().getBytes(defaultEncoding);
				} catch (UnsupportedEncodingException ue) {
					if (errorHandler != null)
						errorHandler.handleErrorOnSet(this, ue, key);
					log.error("invalid encoding type used: " + defaultEncoding, ue);
					return false;
				}
			} else {
				try {
					// log.info("Storing with native handler...");
					flags |= NativeHandler.getMarkerFlag(value);
					val = NativeHandler.encode(value);
				} catch (Exception e) {

					// if we have an errorHandler, use its hook
					if (errorHandler != null)
						errorHandler.handleErrorOnSet(this, e, key);

					log.error("Failed to native handle obj", e);
					return false;
				}
			}
		} else {
			// always serialize for non-primitive types
			try {
				if (log.isDebugEnabled()) {
					log.debug("serializing for key: " + key + " for class: " + value.getClass().getName());
				}
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				(new ObjectOutputStream(bos)).writeObject(value);
				val = bos.toByteArray();
				flags |= F_SERIALIZED;
			} catch (IOException e) {

				// if we have an errorHandler, use its hook
				if (errorHandler != null)
					errorHandler.handleErrorOnSet(this, e, key);

				// if we fail to serialize, then
				// we bail
				log.error("failed to serialize obj", e);
				log.error(value.toString());

				return false;
			}
		}

	
		
		
		
		
		// now try to compress if we want to
		// and if the length is over the threshold
		if (compressEnable && val.length > compressThreshold) {

			try {
				if (log.isDebugEnabled()) {
					log.debug("trying to compress data");
					log.debug("++++ size prior to compression: " + val.length);
				}
				ByteArrayOutputStream bos = new ByteArrayOutputStream(val.length);
				GZIPOutputStream gos = new GZIPOutputStream(bos);
				gos.write(val, 0, val.length);
				gos.finish();

				// store it and set compression flag
				val = bos.toByteArray();
				flags |= F_COMPRESSED;
				if (log.isDebugEnabled()) {
					log.info("compression succeeded, size after: " + val.length);
				}
			} catch (IOException e) {
				// if we have an errorHandler, use its hook
				if (errorHandler != null)
					errorHandler.handleErrorOnSet(this, e, key);

				log.error("IOException while compressing stream: " + e.getMessage());
				log.error("storing data uncompressed");
			}
		}

		
		
		// get SockIO obj
		MemcachedChannel channel = null;
		try {
			channel = source.getMemcachedChannel();
		} catch (Exception e1) {
			log.error("error : " + e1.getMessage());
			e1.printStackTrace();
		}

		if (channel == null) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, new IOException("no channel to server available"), key);
			return false;
		}	
		
		// now write the data to the cache server
		try {
			String cmd = String.format("%s %s %d %d %d\r\n", cmdName, key, flags, seconds, val.length);
			channel.write(cmd.getBytes());
			channel.write(val);
			channel.write("\r\n".getBytes());
			channel.flush();

			// get result code
			SetInputStreamWrapper setInputStreamWrapper = new SetInputStreamWrapper(channel);
			String line = setInputStreamWrapper.readLine();

			if (log.isDebugEnabled()) {
				log.debug("memcache cmd (result code): " + cmd + " (" + line + ")");
			}

			if (STORED.equals(line)) {
				if (log.isDebugEnabled()) {
					log.debug("data successfully stored for key: " + key);
				}
				return true;
			} else if (NOTSTORED.equals(line)) {
				log.info("data not stored in cache for key: " + key);
			} else {
				log.error("error storing data in cache for key: " + key + " -- length: " + val.length);
				log.error("server response: " + line);
			}
		} catch (Exception e) {
			// if we have an errorHandler, use its hook
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, e, key);

			// exception thrown
			log.error("exception thrown while writing bytes to server on set");
			log.error(e.getMessage(), e);
		} finally {
			closeMemcachedChannel(channel, key);
		}
		return false;
	}

	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;

	}

	private void closeMemcachedChannel(MemcachedChannel channel, String key) {
		if (channel != null) {
			try {
				channel.close();
			} catch (IOException e) {
				if (errorHandler != null)
					errorHandler.handleErrorOnSet(this, e, key);
				if (log.isDebugEnabled()) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	public boolean isDynamic() {
		return this.source.isDynamic();
	}

	public Object[] getMultiArray(String[] keys) {

		if (keys == null || keys.length == 0) {
			log.error("missing keys for getMulti()");
			return null;
		}
		Object[] rets = new Object[keys.length];
		boolean asString = false;
		StringBuilder cmdString = new StringBuilder().append("get");
		for (int i = 0; i < keys.length; ++i) {
			String key = keys[i];
			if (key == null) {
				log.error("null key, so skipping");
				continue;
			}
			String cleanKey = key;
			try {
				cleanKey = MemcachedUtils.sanitizeKey(sanitizeKeys, key);
			} catch (UnsupportedEncodingException e) {

				// if we have an errorHandler, use its hook
				if (errorHandler != null)
					errorHandler.handleErrorOnGet(this, e, key);

				log.error("failed to sanitize your key!", e);
				continue;
			}
			cmdString.append(" ").append(cleanKey);

		}

		// log.info("multi " + cmdString);

		// now query memcache
		Map<String, Object> ret = new HashMap<String, Object>(keys.length);

		// now use new NIO implementation
		doMulti(asString, cmdString, ret);

		// fix the return array in case we had to rewrite any of the keys
		for (int i = 0; i < keys.length; i++) {
			String cleanKey = keys[i];
			try {
				cleanKey = MemcachedUtils.sanitizeKey(sanitizeKeys, keys[i]);
			} catch (UnsupportedEncodingException e) {

				// if we have an errorHandler, use its hook
				if (errorHandler != null)
					errorHandler.handleErrorOnGet(this, e, keys[i]);

				log.error("failed to sanitize your key!", e);
				continue;
			}

			if (ret.containsKey(cleanKey)) {
				rets[i] = ret.get(cleanKey);
			}

		}

		// if (log.isDebugEnabled())
		// log.debug("++++ memcache: got back " + ret.size() + " results");
		return rets;
	}

	private void doMulti(boolean asString, StringBuilder cmdString, Map<String, Object> ret) {
		if (cmdString == null || cmdString.toString().length() == 0 || ret == null) {
			return;
		}
		// get SockIO obj using cache key
		MemcachedChannel channel = null;
		try {
			channel = source.getMemcachedChannel();
		} catch (Exception e1) {
			log.error("error : " + e1.getMessage());
			e1.printStackTrace();
		}

		if (channel == null) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, new IOException("no channel to server available"), cmdString.toString());
			return;
		}

		try {
			channel.write(cmdString.append("\r\n").toString().getBytes());
			channel.flush();

			// ready object
			GetInputStreamWrapper getInputStreamWrapper = new GetInputStreamWrapper(channel);
			while (true) {

				// String line = channel.readLine();
				String line = getInputStreamWrapper.readKeys("");

				if (line.startsWith(VALUE)) {
					Object o = null;
					String[] info = line.split(" ");
					// info[1] 就是Key
					String key = info[1];
					int flag = Integer.parseInt(info[2]);
					int length = Integer.parseInt(info[3]);

					// read obj into buffer
					byte[] buf = new byte[length];
					getInputStreamWrapper.read(buf);
					getInputStreamWrapper.clearEOL();

					if ((flag & F_COMPRESSED) == F_COMPRESSED) {
						try {
							// read the input stream, and write to a byte array
							// output stream since
							// we have to read into a byte array, but we don't
							// know how large it
							// will need to be, and we don't want to resize it a
							// bunch
							GZIPInputStream gzi = new GZIPInputStream(new ByteArrayInputStream(buf));
							ByteArrayOutputStream bos = new ByteArrayOutputStream(buf.length);

							int count;
							byte[] tmp = new byte[2048];
							while ((count = gzi.read(tmp)) != -1) {
								bos.write(tmp, 0, count);
							}

							// store uncompressed back to buffer
							buf = bos.toByteArray();
							gzi.close();
						} catch (IOException e) {

							// if we have an errorHandler, use its hook
							if (errorHandler != null)
								errorHandler.handleErrorOnGet(this, e, key);

							log.error("IOException thrown while trying to uncompress input stream for key: " + key);
							log.error(e.getMessage(), e);
							throw new NestedIOException("IOException thrown while trying to uncompress input stream for key: " + key, e);
						}
					}

					// we can only take out serialized objects
					if ((flag & F_SERIALIZED) != F_SERIALIZED) {
						if (primitiveAsString || asString) {
							// pulling out string value
							log.info("retrieving object and stuffing into a string.");
							o = new String(buf, defaultEncoding);
						} else {
							// decoding object
							try {
								o = NativeHandler.decode(buf, flag);
							} catch (Exception e) {

								// if we have an errorHandler, use its hook
								if (errorHandler != null)
									errorHandler.handleErrorOnGet(this, e, key);

								log.error("++++ Exception thrown while trying to deserialize for key: " + key, e);
								throw new NestedIOException(e);
							}
						}
					} else {
						// deserialize if the data is serialized

						ContextObjectInputStream ois = new ContextObjectInputStream(new ByteArrayInputStream(buf), classLoader);
						try {
							o = ois.readObject();
							// if (log.isDebugEnabled()) {
							// log.info("deserializing " + o.getClass());
							// }
						} catch (ClassNotFoundException e) {

							// if we have an errorHandler, use its hook
							if (errorHandler != null)
								errorHandler.handleErrorOnGet(this, e, key);

							log.error("ClassNotFoundException thrown while trying to deserialize for key: " + key, e);
							throw new NestedIOException("+++ failed while trying to deserialize for key: " + key, e);
						}
					}
					ret.put(key, o);
				} else if (END.equals(line)) {
					// if (log.isDebugEnabled())
					// log.debug("finished reading from cache server");
					break;
				} else {
					log.error("server error: " + StringUtils.defaultIfEmpty(line, ""));
					channel.setHealth(true);
					break;
				}

			}
			return;
		} catch (IOException e) {

			// if we have an errorHandler, use its hook
			if (errorHandler != null)
				errorHandler.handleErrorOnGet(this, e, cmdString.toString());

			// exception thrown
			log.error("++++ exception thrown while trying to get object from cache for key: " + cmdString.toString());
			log.error(e.getMessage(), e);
		} finally {
			closeMemcachedChannel(channel, cmdString.toString());	
		}
		
	}

	@Override
	public long decr(String key, long inc) {
		long lresult = -1;
		String cmdName = "decr";
		try {
			key = MemcachedUtils.sanitizeKey(sanitizeKeys, key);
		} catch (UnsupportedEncodingException e) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, e, key);

			log.error("failed to sanitize your key!", e);
			return lresult;
		}

		// get SockIO obj
		MemcachedChannel channel = null;
		try {
			channel = source.getMemcachedChannel();
		} catch (Exception e1) {
			log.error("error : " + e1.getMessage());
			e1.printStackTrace();
		}

		if (channel == null) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, new IOException("no channel to server available"), key);
			return lresult;
		}
		String cmd = String.format("%s %s %d\r\n", cmdName, key, inc);
		try {
			if (log.isDebugEnabled())
				log.debug("memcache incr/decr command: " + cmd);

			channel.write(cmd.getBytes());
			channel.flush();

			// get result back
			IncrOrDecrInputStreamWrapper inputStreamWrapper = new IncrOrDecrInputStreamWrapper(channel);
			String line = inputStreamWrapper.readLine();
			if (line.matches("\\d+")) {
				try {
					lresult = Long.parseLong(line);
				} catch (Exception ex) {
					if (errorHandler != null)
						errorHandler.handleErrorOnGet(this, ex, key);
					log.error(String.format("Failed to parse Long value for key: %s", key));
				}
			} else if (NOTFOUND.equals(line)) {
				if (log.isDebugEnabled()) {
					log.debug("key not found to incr/decr for key: " + key);
				}
			} else {
				log.error("error incr/decr key: " + key);
				log.error("server response: " + line);
			}

		} catch (Exception e) {
			if (errorHandler != null)
				errorHandler.handleErrorOnGet(this, e, key);
			log.error("++++ exception thrown while writing bytes to server on incr/decr");
			e.printStackTrace(System.err);
		} finally {
			closeMemcachedChannel(channel, cmd.toString());
		}

		return lresult;
	}

	@Override
	public long incr(String key, long inc) {
		long lresult = -1;
		String cmdName = "incr";
		try {
			key = MemcachedUtils.sanitizeKey(sanitizeKeys, key);
		} catch (UnsupportedEncodingException e) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, e, key);

			log.error("failed to sanitize your key!", e);
			return lresult;
		}

		// get SockIO obj
		MemcachedChannel channel = null;
		try {
			channel = source.getMemcachedChannel();
		} catch (Exception e1) {
			log.error("error : " + e1.getMessage());
			e1.printStackTrace();
		}

		if (channel == null) {
			if (errorHandler != null)
				errorHandler.handleErrorOnSet(this, new IOException("no channel to server available"), key);
			return lresult;
		}
		String cmd = String.format("%s %s %d\r\n", cmdName, key, inc);
		try {
			if (log.isDebugEnabled())
				log.debug("memcache incr/decr command: " + cmd);

			channel.write(cmd.getBytes());
			channel.flush();

			// get result back
			IncrOrDecrInputStreamWrapper inputStreamWrapper = new IncrOrDecrInputStreamWrapper(channel);
			String line = inputStreamWrapper.readLine();
			if (line.matches("\\d+")) {
				try {
					lresult = Long.parseLong(line);
				} catch (Exception ex) {
					if (errorHandler != null)
						errorHandler.handleErrorOnGet(this, ex, key);
					log.error(String.format("Failed to parse Long value for key: %s", key));
				}
			} else if (NOTFOUND.equals(line)) {
				if (log.isDebugEnabled()) {
					log.debug("key not found to incr/decr for key: " + key);
				}
			} else {
				log.error("error incr/decr key: " + key);
				log.error("server response: " + line);
			}

		} catch (Exception e) {
			if (errorHandler != null)
				errorHandler.handleErrorOnGet(this, e, key);
			log.error("++++ exception thrown while writing bytes to server on incr/decr");
			log.error(e.getMessage(), e);
			e.printStackTrace(System.err);
		} finally {
			closeMemcachedChannel(channel, cmd.toString());
		}
		return lresult;
	}
}
