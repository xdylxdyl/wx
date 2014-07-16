package com.qding.community.common.weixin.util;

import java.util.concurrent.*;

public class WeiXinCallable implements Callable<String> {
	private String url;
	private String content;
	public WeiXinCallable(String url, String content) {      
        this.url = url;
        this.content = content;
	}
    public String call() throws Exception {
    	return com.qding.common.util.HttpClientUtil.sendPostRequestByJava(url, content);
    }
}
