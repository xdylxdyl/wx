<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="gorderGoodsRelation" id="current_nav">
<div id="gorderGoodsRelationApp" ng-app="gorderGoodsRelationApp">
	<div ng-controller="gorderGoodsRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>GorderGoodsRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addGorderGoodsRelation(gorderGoodsRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/gorderGoodsRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>订单ID</td>
			        				                    <td>商品ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="gorderGoodsRelation in data">				
									                    <td ng-cloak>{{gorderGoodsRelation.id}}</td>
			        				                    <td ng-cloak>{{gorderGoodsRelation.gorderID}}</td>
			        				                    <td ng-cloak>{{gorderGoodsRelation.goodsID}}</td>
			        				                    <td ng-cloak>{{gorderGoodsRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{gorderGoodsRelation.updateBy}}</td>
			        				                    <td ng-cloak>{{gorderGoodsRelation.createAt}}</td>
			        				                    <td ng-cloak>{{gorderGoodsRelation.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateGorderGoodsRelation(gorderGoodsRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteGorderGoodsRelation(gorderGoodsRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/gorderGoodsRelation/gorderGoodsRelationList.js"></script>
