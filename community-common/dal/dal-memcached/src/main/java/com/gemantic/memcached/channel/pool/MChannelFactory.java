package com.gemantic.memcached.channel.pool;

import java.io.IOException;
import java.net.Socket;

import com.gemantic.memcached.channel.MemcachedChannel;

public interface MChannelFactory {
    public MemcachedChannel createMemcachedChannel() throws IOException;
}
