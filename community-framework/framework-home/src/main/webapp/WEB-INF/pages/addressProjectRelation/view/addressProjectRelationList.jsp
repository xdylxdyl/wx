<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="addressProjectRelation" id="current_nav">
<div id="addressProjectRelationApp" ng-app="addressProjectRelationApp">
	<div ng-controller="addressProjectRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>AddressProjectRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAddressProjectRelation(addressProjectRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/addressProjectRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>地址ID</td>
			        				                    <td>项目ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>数据更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="addressProjectRelation in data">				
									                    <td ng-cloak>{{addressProjectRelation.id}}</td>
			        				                    <td ng-cloak>{{addressProjectRelation.addressID}}</td>
			        				                    <td ng-cloak>{{addressProjectRelation.userID}}</td>
			        				                    <td ng-cloak>{{addressProjectRelation.createAt}}</td>
			        				                    <td ng-cloak>{{addressProjectRelation.updateBy}}</td>
			        				                    <td ng-cloak>{{addressProjectRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{addressProjectRelation.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAddressProjectRelation(addressProjectRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteAddressProjectRelation(addressProjectRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/addressProjectRelation/addressProjectRelationList.js"></script>
