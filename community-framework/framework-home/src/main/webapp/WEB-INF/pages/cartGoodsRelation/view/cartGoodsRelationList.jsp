<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="cartGoodsRelation" id="current_nav">
<div id="cartGoodsRelationApp" ng-app="cartGoodsRelationApp">
	<div ng-controller="cartGoodsRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>CartGoodsRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addCartGoodsRelation(cartGoodsRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/cartGoodsRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>购物车ID</td>
			        				                    <td>商品ID</td>
			        				                    <td>数量</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="cartGoodsRelation in data">				
									                    <td ng-cloak>{{cartGoodsRelation.id}}</td>
			        				                    <td ng-cloak>{{cartGoodsRelation.cartID}}</td>
			        				                    <td ng-cloak>{{cartGoodsRelation.goodsID}}</td>
			        				                    <td ng-cloak>{{cartGoodsRelation.count}}</td>
			        				                    <td ng-cloak>{{cartGoodsRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{cartGoodsRelation.updateBy}}</td>
			        				                    <td ng-cloak>{{cartGoodsRelation.createAt}}</td>
			        				                    <td ng-cloak>{{cartGoodsRelation.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateCartGoodsRelation(cartGoodsRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteCartGoodsRelation(cartGoodsRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/cartGoodsRelation/cartGoodsRelationList.js"></script>
