<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="potential" id="current_nav">
<div id="potentialApp" ng-app="potentialApp">
	<div ng-controller="potentialController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Potential管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addPotential(potential)">新增</span>
		    </span>
	
			<paging url="/web/a/potential">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>昵称</td>
			        				                    <td>性别</td>
			        				                    <td>头像</td>
			        				                    <td>公众号ID值</td>
			        				                    <td>微信OpenID</td>
			        				                    <td>微信FakeID</td>
			        				                    <td>用户当前登录时间</td>
			        				                    <td>用户上次登录时间</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="potential in data">				
									                    <td ng-cloak>{{potential.id}}</td>
			        				                    <td ng-cloak>{{potential.nick}}</td>
			        				                    <td ng-cloak>{{potential.sex}}</td>
			        				                    <td ng-cloak>{{potential.img}}</td>
			        				                    <td ng-cloak>{{potential.publicsID}}</td>
			        				                    <td ng-cloak>{{potential.openID}}</td>
			        				                    <td ng-cloak>{{potential.fakeID}}</td>
			        				                    <td ng-cloak>{{potential.loginAt}}</td>
			        				                    <td ng-cloak>{{potential.lastLoginAt}}</td>
			        				                    <td ng-cloak>{{potential.updateAt}}</td>
			        				                    <td ng-cloak>{{potential.createAt}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updatePotential(potential.id)" /> 
							<input type="button" value="删除" ng-click="deletePotential(potential.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/potential/potentialList.js"></script>
