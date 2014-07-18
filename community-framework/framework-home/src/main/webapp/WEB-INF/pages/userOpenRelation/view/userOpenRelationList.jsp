<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="userOpenRelation" id="current_nav">
<div id="userOpenRelationApp" ng-app="userOpenRelationApp">
	<div ng-controller="userOpenRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>UserOpenRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUserOpenRelation(userOpenRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/userOpenRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>用户ID</td>
			        				                    <td>OPENID</td>
			        				                    <td>类型 wx_openID,mobile,wx_fakeID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="userOpenRelation in data">				
									                    <td ng-cloak>{{userOpenRelation.id}}</td>
			        				                    <td ng-cloak>{{userOpenRelation.uid}}</td>
			        				                    <td ng-cloak>{{userOpenRelation.openID}}</td>
			        				                    <td ng-cloak>{{userOpenRelation.type}}</td>
			        				                    <td ng-cloak>{{userOpenRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{userOpenRelation.createAt}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUserOpenRelation(userOpenRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteUserOpenRelation(userOpenRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/userOpenRelation/userOpenRelationList.js"></script>
