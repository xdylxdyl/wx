package com.qding.framework.user.util;

import com.qding.framework.user.model.Potential;
import com.qding.framework.user.model.User;

public class UserUtil {

	public static User convertPotentail2User(Potential potentail,String from,User userinfo) {
		User user=new User();		
		user.setImg(potentail.getImg());
		user.setLastLoginAt(System.currentTimeMillis());
		user.setLoginAt(System.currentTimeMillis());
		user.setMobile(userinfo.getMobile().toString());
		user.setName(userinfo.getName().toString());
		user.setNick(potentail.getNick());
		//user.setSex(potentail.getSex());//在微信获取
		user.setSex(userinfo.getSex().toString());//注册时，页面选择
	
		return user;
	}

}
