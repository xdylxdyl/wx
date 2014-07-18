<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="tags" id="current_nav">
<div id="tagsApp" ng-app="tagsApp">
	<div ng-controller="tagsController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Tags管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addTags(tags)">新增</span>
		    </span>
	
			<paging url="/web/a/tags">
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
					<tr ng-repeat="tags in data">				
									                    <td ng-cloak>{{tags.id}}</td>
			        				                    <td ng-cloak>{{tags.name}}</td>
			        				                    <td ng-cloak>{{tags.status}}</td>
			        				                    <td ng-cloak>{{tags.createBy}}</td>
			        				                    <td ng-cloak>{{tags.updateBy}}</td>
			        				                    <td ng-cloak>{{tags.updateAt}}</td>
			        				                    <td ng-cloak>{{tags.createAt}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateTags(tags.id)" /> 
							<input type="button" value="删除" ng-click="deleteTags(tags.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/tags/tagsList.js"></script>
