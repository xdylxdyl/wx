<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="images" id="current_nav">
<div id="imagesApp" ng-app="imagesApp">
	<div ng-controller="imagesController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Images管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addImages(images)">新增</span>
		    </span>
	
			<paging url="/web/a/images">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td></td>
			        				                    <td>图片名称</td>
			        				                    <td>原图路径</td>
			        				                    <td>大图路径</td>
			        				                    <td>中图路径</td>
			        				                    <td>小图路径</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="images in data">				
									                    <td ng-bind="images.id" ></td>
			        				                    <td ng-bind="images.name" ></td>
			        				                    <td ng-bind="images.originalPath" ></td>
			        				                    <td ng-bind="images.bigPath" ></td>
			        				                    <td ng-bind="images.middlePath" ></td>
			        				                    <td ng-bind="images.smallPath" ></td>
			        				                    <td ng-bind="images.updateAt" ></td>
			        				                    <td ng-bind="images.createAt" ></td>
			        				                    <td ng-bind="images.updateBy" ></td>
			        				                    <td ng-bind="images.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateImages(images.id)" /> 
							<input type="button" value="删除" ng-click="deleteImages(images.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/app-decorate-service/images/imagesList.js"></script>
