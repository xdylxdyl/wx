<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="building" id="current_nav">
<div id="buildingApp" ng-app="buildingApp">
	<div ng-controller="buildingController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Building管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addBuilding(building)">新增</span>
		    </span>
	
			<paging url="/web/a/building">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id</td>
			        				                    <td>楼栋名称</td>
			        				                    <td>楼栋编码</td>
			        				                    <td>楼栋状态 1：启用 0：停用</td>
			        				                    <td>所属项目ID</td>
			        				                    <td>所属项目名称</td>
			        				                    <td>是否虚拟 1：是 0：否</td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="building in data">				
									                    <td ng-bind="building.id" ></td>
			        				                    <td ng-bind="building.name" ></td>
			        				                    <td ng-bind="building.code" ></td>
			        				                    <td ng-bind="building.status" ></td>
			        				                    <td ng-bind="building.projectId" ></td>
			        				                    <td ng-bind="building.projectName" ></td>
			        				                    <td ng-bind="building.isVirtual" ></td>
			        				                    <td ng-bind="building.createAt" ></td>
			        				                    <td ng-bind="building.updateBy" ></td>
			        				                    <td ng-bind="building.updateAt" ></td>
			        				                    <td ng-bind="building.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateBuilding(building.id)" /> 
							<input type="button" value="删除" ng-click="deleteBuilding(building.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/framework-building-service/building/buildingList.js"></script>
