<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="user" id="current_nav">
<div id="userApp" ng-app="userApp">
	<div ng-controller="userController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>User管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUser(user)">新增</span>
		    </span>
	
			<paging url="/web/a/user">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>名称</td>
			        				                    <td>hash</td>
			        				                    <td>token</td>
			        				                    <td>性别</td>
			        				                    <td>头像</td>
			        				                    <td>用户当前登录时间</td>
			        				                    <td>用户上次登录时间</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="user in data">				
									                    <td ng-cloak>{{user.id}}</td>
			        				                    <td ng-cloak>{{user.nick}}</td>
			        				                    <td ng-cloak>{{user.mobile}}</td>
			        				                    <td ng-cloak>{{user.pwd}}</td>
			        				                    <td ng-cloak>{{user.sex}}</td>
			        				                    <td ng-cloak>{{user.img}}</td>
			        				                    <td ng-cloak>{{user.loginAt}}</td>
			        				                    <td ng-cloak>{{user.lastLoginAt}}</td>
			        				                    <td ng-cloak>{{user.updateAt}}</td>
			        				                    <td ng-cloak>{{user.createAt}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUser(user.id)" /> 
							<input type="button" value="删除" ng-click="deleteUser(user.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/user/userList.js"></script>
