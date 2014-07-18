<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="area" id="current_nav">
<div id="areaApp" ng-app="areaApp">
	<div ng-controller="areaController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Area管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addArea(area)">新增</span>
		    </span>
	
			<paging url="/web/a/area">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td></td>
			        				                    <td></td>
			        				                    <td>名称</td>
			        				                    <td></td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="area in data">				
									                    <td ng-bind="area.id" ></td>
			        				                    <td ng-bind="area.code" ></td>
			        				                    <td ng-bind="area.name" ></td>
			        				                    <td ng-bind="area.parentId" ></td>
			        				                    <td ng-bind="area.updateAt" ></td>
			        				                    <td ng-bind="area.createAt" ></td>
			        				                    <td ng-bind="area.updateBy" ></td>
			        				                    <td ng-bind="area.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateArea(area.id)" /> 
							<input type="button" value="删除" ng-click="deleteArea(area.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/framework-building-service/area/areaList.js"></script>
