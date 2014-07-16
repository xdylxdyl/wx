/**
 * MemCached Java client
 * Copyright (c) 2007 Greg Whalin
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the BSD license
 *
 * This library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.
 *
 * You should have received a copy of the BSD License along with this
 * library.
 *
 * @author greg whalin <greg@meetup.com> 
 * @version 2.0
 */
package com.gemantic.memcached.stream;

import java.io.IOException;

public interface LineInputStream {
    //public static long READLONETIME=2 * 60 * 1000l; //20091120 deleted
    public static long READLONETIME=1 * 10 * 1000l;
    
	/**
	 * Read everything up to the next end-of-line.  Does
	 * not include the end of line, though it is consumed
	 * from the input.
	 * @return  All next up to the next end of line.
	 */
	public String readLine() throws IOException;
	
	
    /**
     * 
     * allenshen add method
     * @return  All next up to the next end of line.
     */
    public String readKeys(String keys) throws IOException;	
	
	/**
	 * Read everything up to and including the end of line.
	 */
	public void clearEOL() throws IOException;
	
	
    /**
     * 
     * allenshen add method
     * @return  All next up to the next end of line.
     */
    public void clearEnd() throws IOException; 
	
	/**
	 * Read some bytes.
	 * @param buf   The buffer into which read. 
	 * @return      The number of bytes actually read, or -1 if none could be read.
	 */
	public int read( byte[] buf ) throws IOException;
}
