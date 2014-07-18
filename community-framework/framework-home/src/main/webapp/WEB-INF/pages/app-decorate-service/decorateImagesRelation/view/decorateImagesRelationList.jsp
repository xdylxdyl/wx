<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="decorateImagesRelation" id="current_nav">
<div id="decorateImagesRelationApp" ng-app="decorateImagesRelationApp">
	<div ng-controller="decorateImagesRelationController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>DecorateImagesRelation管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDecorateImagesRelation(decorateImagesRelation)">新增</span>
		    </span>
	
			<paging url="/web/a/decorateImagesRelation">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="decorateImagesRelation in data">				
									                    <td ng-bind="decorateImagesRelation.id" ></td>
			        				                    <td ng-bind="decorateImagesRelation.decorateId" ></td>
			        				                    <td ng-bind="decorateImagesRelation.imageId" ></td>
			        				                    <td ng-bind="decorateImagesRelation.updateAt" ></td>
			        				                    <td ng-bind="decorateImagesRelation.createAt" ></td>
			        				                    <td ng-bind="decorateImagesRelation.updateBy" ></td>
			        				                    <td ng-bind="decorateImagesRelation.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDecorateImagesRelation(decorateImagesRelation.id)" /> 
							<input type="button" value="删除" ng-click="deleteDecorateImagesRelation(decorateImagesRelation.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/app-decorate-service/decorateImagesRelation/decorateImagesRelationList.js"></script>
