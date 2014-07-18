<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="tagsGoodsRelation" id="current_nav">
<div id="tagsGoodsRelationApp" ng-app="tagsGoodsRelationApp">
	<div ng-controller="tagsGoodsRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>TagsGoodsRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addTagsGoodsRelation(tagsGoodsRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/tagsGoodsRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>标签ID</td>
			        				                    <td>商品ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据创建时间</td>
			        				                    <td>创建人ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="tagsGoodsRelation in data">				
									                    <td ng-cloak>{{tagsGoodsRelation.id}}</td>
			        				                    <td ng-cloak>{{tagsGoodsRelation.tagsID}}</td>
			        				                    <td ng-cloak>{{tagsGoodsRelation.goodsID}}</td>
			        				                    <td ng-cloak>{{tagsGoodsRelation.updateAt}}</td>
			        				                    <td ng-cloak>{{tagsGoodsRelation.updateBy}}</td>
			        				                    <td ng-cloak>{{tagsGoodsRelation.createAt}}</td>
			        				                    <td ng-cloak>{{tagsGoodsRelation.createBy}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateTagsGoodsRelation(tagsGoodsRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteTagsGoodsRelation(tagsGoodsRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/tagsGoodsRelation/tagsGoodsRelationList.js"></script>
