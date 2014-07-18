<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="publicsProjectRelation" id="current_nav">
<div id="publicsProjectRelationApp" ng-app="publicsProjectRelationApp">
	<div ng-controller="publicsProjectRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>PublicsProjectRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addPublicsProjectRelation(publicsProjectRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/publicsProjectRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>公众号ID</td>
			        				                    <td>项目ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>数据更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="publicsProjectRelation in data">				
									                    <td ng-cloak>{{publicsProjectRelation.id}}</td>
			        				                    <td ng-cloak>{{publicsProjectRelation.publicsID}}</td>
			        				                    <td ng-cloak>{{publicsProjectRelation.projectID}}</td>
			        				                    <td ng-cloak>{{publicsProjectRelation.createAt}}</td>
			        				                    <td ng-cloak>{{publicsProjectRelation.updateBy}}</td>
			        				                    <td ng-cloak>{{publicsProjectRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{publicsProjectRelation.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updatePublicsProjectRelation(publicsProjectRelation.id)" /> 
							<input type="button" value="删除" ng-click="deletePublicsProjectRelation(publicsProjectRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/publicsProjectRelation/publicsProjectRelationList.js"></script>
