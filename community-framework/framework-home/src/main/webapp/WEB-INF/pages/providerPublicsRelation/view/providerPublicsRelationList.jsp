<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="providerPublicsRelation" id="current_nav">
<div id="providerPublicsRelationApp" ng-app="providerPublicsRelationApp">
	<div ng-controller="providerPublicsRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>ProviderPublicsRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProviderPublicsRelation(providerPublicsRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/providerPublicsRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>供方ID</td>
			        				                    <td>公众号ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="providerPublicsRelation in data">				
									                    <td ng-cloak>{{providerPublicsRelation.id}}</td>
			        				                    <td ng-cloak>{{providerPublicsRelation.providerID}}</td>
			        				                    <td ng-cloak>{{providerPublicsRelation.publicsID}}</td>
			        				                    <td ng-cloak>{{providerPublicsRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{providerPublicsRelation.updateBy}}</td>
			        				                    <td ng-cloak>{{providerPublicsRelation.createAt}}</td>
			        				                    <td ng-cloak>{{providerPublicsRelation.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProviderPublicsRelation(providerPublicsRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteProviderPublicsRelation(providerPublicsRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/providerPublicsRelation/providerPublicsRelationList.js"></script>
