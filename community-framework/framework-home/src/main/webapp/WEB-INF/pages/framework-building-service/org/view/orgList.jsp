<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="org" id="current_nav">
<div id="orgApp" ng-app="orgApp">
	<div ng-controller="orgController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Org管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addOrg(org)">新增</span>
		    </span>
	
			<paging url="/web/a/org">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td></td>
			        				                    <td></td>
			        				                    <td>组织名称</td>
			        				                    <td></td>
			        				                    <td>地区(省直辖市)id</td>
			        				                    <td></td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="org in data">				
									                    <td ng-bind="org.id" ></td>
			        				                    <td ng-bind="org.code" ></td>
			        				                    <td ng-bind="org.name" ></td>
			        				                    <td ng-bind="org.status" ></td>
			        				                    <td ng-bind="org.provinceId" ></td>
			        				                    <td ng-bind="org.parentId" ></td>
			        				                    <td ng-bind="org.updateAt" ></td>
			        				                    <td ng-bind="org.createAt" ></td>
			        				                    <td ng-bind="org.updateBy" ></td>
			        				                    <td ng-bind="org.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateOrg(org.id)" /> 
							<input type="button" value="删除" ng-click="deleteOrg(org.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/framework-building-service/org/orgList.js"></script>
