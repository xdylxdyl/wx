<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="decorateVenderUser" id="current_nav">
<div id="decorateVenderUserApp" ng-app="decorateVenderUserApp">
	<div ng-controller="decorateVenderUserController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>DecorateVenderUser管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDecorateVenderUser(decorateVenderUser)">新增</span>
		    </span>
	
			<paging url="/web/a/decorateVenderUser">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td></td>
			        				                    <td>供方ID</td>
			        				                    <td>供方名称</td>
			        				                    <td>责任人姓名</td>
			        				                    <td>责任人身份证号</td>
			        				                    <td>责任人手机号</td>
			        				                    <td>责任人手机号1</td>
			        				                    <td>责任人手机号2</td>
			        				                    <td>责任人Email</td>
			        				                    <td>责任人QQ</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="decorateVenderUser in data">				
									                    <td ng-bind="decorateVenderUser.id" ></td>
			        				                    <td ng-bind="decorateVenderUser.venderId" ></td>
			        				                    <td ng-bind="decorateVenderUser.venderName" ></td>
			        				                    <td ng-bind="decorateVenderUser.userName" ></td>
			        				                    <td ng-bind="decorateVenderUser.userIdNumber" ></td>
			        				                    <td ng-bind="decorateVenderUser.userMobile" ></td>
			        				                    <td ng-bind="decorateVenderUser.userMobile1" ></td>
			        				                    <td ng-bind="decorateVenderUser.userMobile2" ></td>
			        				                    <td ng-bind="decorateVenderUser.userEmail" ></td>
			        				                    <td ng-bind="decorateVenderUser.userQq" ></td>
			        				                    <td ng-bind="decorateVenderUser.updateAt" ></td>
			        				                    <td ng-bind="decorateVenderUser.createAt" ></td>
			        				                    <td ng-bind="decorateVenderUser.updateBy" ></td>
			        				                    <td ng-bind="decorateVenderUser.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDecorateVenderUser(decorateVenderUser.id)" /> 
							<input type="button" value="删除" ng-click="deleteDecorateVenderUser(decorateVenderUser.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/app-decorate-service/decorateVenderUser/decorateVenderUserList.js"></script>
