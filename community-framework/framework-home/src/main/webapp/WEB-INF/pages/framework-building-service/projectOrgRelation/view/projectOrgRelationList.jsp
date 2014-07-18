<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="projectOrgRelation" id="current_nav">
<div id="projectOrgRelationApp" ng-app="projectOrgRelationApp">
	<div ng-controller="projectOrgRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ProjectOrgRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProjectOrgRelation(projectOrgRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/projectOrgRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="projectOrgRelation in data">				
									                    <td ng-bind="projectOrgRelation.id" ></td>
			        				                    <td ng-bind="projectOrgRelation.projectId" ></td>
			        				                    <td ng-bind="projectOrgRelation.orgId" ></td>
			        				                    <td ng-bind="projectOrgRelation.updateAt" ></td>
			        				                    <td ng-bind="projectOrgRelation.createAt" ></td>
			        				                    <td ng-bind="projectOrgRelation.updateBy" ></td>
			        				                    <td ng-bind="projectOrgRelation.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProjectOrgRelation(projectOrgRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteProjectOrgRelation(projectOrgRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/framework-building-service/projectOrgRelation/projectOrgRelationList.js"></script>
