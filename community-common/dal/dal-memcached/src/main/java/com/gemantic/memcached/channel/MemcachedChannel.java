package com.gemantic.memcached.channel;

import java.io.DataInputStream;
import java.io.IOException;

import com.gemantic.memcached.stream.LineInputStream;

public interface MemcachedChannel extends LineInputStream {
    /**
     * 关闭
     */
    public void close() throws IOException;

    /**
     * 打开
     * 
     * @return
     */
    public boolean isConnected();

    /**
     * 是否能用
     * 
     * @return
     */
    public boolean isAlive();

    /**
     * 刷新
     * 
     * @throws IOException
     */
    public void flush() throws IOException;

    /**
     * 
     * @param b
     * @throws IOException
     */
    public void write(byte[] b) throws IOException;

    public DataInputStream getIn();

    public void setHealth(boolean health);
}
