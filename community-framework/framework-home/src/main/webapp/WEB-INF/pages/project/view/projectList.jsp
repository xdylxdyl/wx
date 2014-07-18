<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="project" id="current_nav">
<div id="projectApp" ng-app="projectApp">
	<div ng-controller="projectController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Project管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProject(project)">新增</span>
		    </span>
	
			<paging url="/web/a/project">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>名称</td>
			        				                    <td>状态</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据更新人ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>数据创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="project in data">				
									                    <td ng-cloak>{{project.id}}</td>
			        				                    <td ng-cloak>{{project.name}}</td>
			        				                    <td ng-cloak>{{project.status}}</td>
			        				                    <td ng-cloak>{{project.updateAt}}</td>
			        				                    <td ng-cloak>{{project.updateBy}}</td>
			        				                    <td ng-cloak>{{project.createAt}}</td>
			        				                    <td ng-cloak>{{project.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProject(project.id)" /> 
							<input type="button" value="删除" ng-click="deleteProject(project.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/project/projectList.js"></script>
