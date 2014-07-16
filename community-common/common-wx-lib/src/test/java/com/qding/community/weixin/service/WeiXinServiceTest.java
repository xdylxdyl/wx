/**
 * 
 */
/** 
 * @PackageName:com.qding.community.weixin.service
 * @ClassName:package-info
 * @Description:TODO
 * @author limengjie@tlan.com.cn (改成自己的）
 * @date 2014年4月23日 下午7:22:56 
 *  
 */
package com.qding.community.weixin.service;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;

import com.qding.commnunity.common.weixin.service.impl.WeiXinServiceImpl;
import com.qding.community.common.weixin.util.CustomMessageUtil;
import com.qding.community.weixin.util.ParseJsonUtilTest;
@Ignore
public class WeiXinServiceTest {
	private static final Log log = LogFactory.getLog(ParseJsonUtilTest.class);
	
	public static void main(String[] args) throws Exception {
/*		log.info("Start");
		WeiXinServiceImpl weixinserviceimpl=new WeiXinServiceImpl();
		String logurl=weixinserviceimpl.createCodeRequestUrl("wxfc7d1fed47862585", "311a6832a57965276ffe4f46566fd20a", "http://dev.quanjiali.com/p/web/news?pid=145");
		log.info("logurl is:       logurl="+logurl);
		log.info("End");
*/		log.info("Start");
		WeiXinServiceImpl weixinserviceimpl=new WeiXinServiceImpl();
		
		String appid = "wxfc7d1fed47862585";
		String secret = "311a6832a57965276ffe4f46566fd20a";
		String msg="欢迎登陆哦~~~~~~~~~（测试信息）";
		String[] l = new String[]{
		"ovK7Ijin_EVYjwsrADa4OupVKlUU",
		"ovK7Ijj0_dkEgNzQbfSgFoZGkyjQ",
		"ovK7IjuunF5AhqX0z7uVO226Kyaw",
		"ovK7IjqOYN_hYSp2Jks4nIRTksPI",
		"ovK7IjioYvSbHpQvvZgWYfFhA5xs",
		"ovK7IjoHZnYDmOgsRlZqIMu6QkrQ",
		"ovK7Iju2E7URLdlLK0U8TwBZl8vw",
		"ovK7Ijp8zE7yqoVzufH-h5DEGwG4",
		"ovK7Ijqp638lP9EelkG57wyWPtLA",
		"ovK7Ijrw-yzJMkXMyDQD0X_SG_Nw",
		"ovK7IjvsKS0lb2R4Hof-6LGGQXH8",
		"ovK7IjpNFHq10NRa5a450YrjyXWU",
		"ovK7Ijlccv0NQy6zWP-cFjgNax9g",
		"ovK7Ijo7AbAZHeDoNnchvokTRNdw",
		"ovK7IjjBCUC956FzbjdALndYcyio",
		"ovK7Ijr7zEch89HsaNDfhBxaluts",
		"ovK7IjgNI8-0cEUzJ0SEePa-T7x4",
		"ovK7IjqZ86r8nNFjjYYYVYq5sxBA",
		"ovK7IjnfsccWugWyOaXStcaeozQ8",
		"ovK7Ijkl8kb1sZQ_4GgJxKDeSlQE",
		"ovK7IjmhPgEZx0LBq2uOoz1FouWc",
		"ovK7IjpU1x1hXEVd57DpTfYSPBqM",
		"ovK7IjldcdjI8fhaEDqopEeEd1k0"};

		
		
		for (String OPENID : l) {
			String res = sendcustom(weixinserviceimpl, appid, secret, msg,OPENID);
			log.info("res is:      "+res);
		}
		
		log.info("End");
		
	}
	/*@Test
	public void testWeixinService() throws IOException {

		WeiXinServiceImpl weixinserviceimpl=new WeiXinServiceImpl();
		String logurl=weixinserviceimpl.createCodeRequestUrl("wxfc7d1fed47862585", "311a6832a57965276ffe4f46566fd20a", "http://dev.quanjiali.com/p/web/news");
		log.info("logurl is:       logurl="+logurl);

	}*/

	private static String sendcustom(WeiXinServiceImpl weixinserviceimpl,
			String appid, String secret, String msg,String OPENID) {
		
		String content=CustomMessageUtil.getCustomTextMessageContent(OPENID, msg);
		 
		String res = weixinserviceimpl.sendCustomMessage(appid, secret, content,true);
		return res;
	}
	
	
}