<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="category" id="current_nav">
<div id="categoryApp" ng-app="categoryApp">
	<div ng-controller="categoryController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Category管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addCategory(category)">新增</span>
		    </span>
	
			<paging url="/web/a/category">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>名称</td>
			        				                    <td>状态</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="category in data">				
									                    <td ng-cloak>{{category.id}}</td>
			        				                    <td ng-cloak>{{category.name}}</td>
			        				                    <td ng-cloak>{{category.status}}</td>
			        				                    <td ng-cloak>{{category.createBy}}</td>
			        				                    <td ng-cloak>{{category.updateBy}}</td>
			        				                    <td ng-cloak>{{category.updateAt}}</td>
			        				                    <td ng-cloak>{{category.createAt}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateCategory(category.id)" /> 
							<input type="button" value="删除" ng-click="deleteCategory(category.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/category/categoryList.js"></script>
