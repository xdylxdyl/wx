<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="addressUserRelation" id="current_nav">
<div id="addressUserRelationApp" ng-app="addressUserRelationApp">
	<div ng-controller="addressUserRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>AddressUserRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAddressUserRelation(addressUserRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/addressUserRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>收货人ID</td>
			        				                    <td>用户人ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>数据更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="addressUserRelation in data">				
									                    <td ng-cloak>{{addressUserRelation.id}}</td>
			        				                    <td ng-cloak>{{addressUserRelation.addressID}}</td>
			        				                    <td ng-cloak>{{addressUserRelation.userID}}</td>
			        				                    <td ng-cloak>{{addressUserRelation.createAt}}</td>
			        				                    <td ng-cloak>{{addressUserRelation.updateAt}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAddressUserRelation(addressUserRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteAddressUserRelation(addressUserRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/addressUserRelation/addressUserRelationList.js"></script>
