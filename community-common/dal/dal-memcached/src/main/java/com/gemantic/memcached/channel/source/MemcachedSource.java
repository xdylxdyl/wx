package com.gemantic.memcached.channel.source;

import com.gemantic.memcached.channel.MemcachedChannel;

public interface MemcachedSource {
    public MemcachedChannel getMemcachedChannel() throws Exception;
    public boolean isDynamic();
}
