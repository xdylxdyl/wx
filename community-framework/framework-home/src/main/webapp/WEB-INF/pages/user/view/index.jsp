<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>	
		
		<div>
		  <img src="${user.img}" />
		  <span>${user.nick}</span>
		 </div>
		 <ul>
          <li>
		  <span>姓名</span><span>${user.name}</span><span>${user.sex}</span>
		 </li>
		  <li>
		   <span><mobile name="${user.mobile}"></mobile></span>
		 </li>
		 <li>
		  <span>收货人</span><span><a href="/p/u/address">${user.name}</a></span>
		 </li>
          </ul>
          
          
          <a href="/p/u/user/edit" class="button">编辑</a>
