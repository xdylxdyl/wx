<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="tagsPublicsRelation" id="current_nav">
<div id="tagsPublicsRelationApp" ng-app="tagsPublicsRelationApp">
	<div ng-controller="tagsPublicsRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>TagsPublicsRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addTagsPublicsRelation(tagsPublicsRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/tagsPublicsRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>标签ID</td>
			        				                    <td>公众号ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="tagsPublicsRelation in data">				
									                    <td ng-cloak>{{tagsPublicsRelation.id}}</td>
			        				                    <td ng-cloak>{{tagsPublicsRelation.tagsID}}</td>
			        				                    <td ng-cloak>{{tagsPublicsRelation.publicsID}}</td>
			        				                    <td ng-cloak>{{tagsPublicsRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{tagsPublicsRelation.updateBy}}</td>
			        				                    <td ng-cloak>{{tagsPublicsRelation.createAt}}</td>
			        				                    <td ng-cloak>{{tagsPublicsRelation.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateTagsPublicsRelation(tagsPublicsRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteTagsPublicsRelation(tagsPublicsRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/tagsPublicsRelation/tagsPublicsRelationList.js"></script>
