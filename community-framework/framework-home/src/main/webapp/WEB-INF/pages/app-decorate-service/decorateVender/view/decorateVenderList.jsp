<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="decorateVender" id="current_nav">
<div id="decorateVenderApp" ng-app="decorateVenderApp">
	<div ng-controller="decorateVenderController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>DecorateVender管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDecorateVender(decorateVender)">新增</span>
		    </span>
	
			<paging url="/web/a/decorateVender">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td></td>
			        				                    <td>供方ID</td>
			        				                    <td>供方名称</td>
			        				                    <td>是否有营业执照( 0：无，1：有)，默认为0</td>
			        				                    <td>法人姓名</td>
			        				                    <td>法人身份证号</td>
			        				                    <td>法人手机号</td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="decorateVender in data">				
									                    <td ng-bind="decorateVender.id" ></td>
			        				                    <td ng-bind="decorateVender.venderId" ></td>
			        				                    <td ng-bind="decorateVender.venderName" ></td>
			        				                    <td ng-bind="decorateVender.isHveLcense" ></td>
			        				                    <td ng-bind="decorateVender.legalName" ></td>
			        				                    <td ng-bind="decorateVender.legalIdNumber" ></td>
			        				                    <td ng-bind="decorateVender.legalMobile" ></td>
			        				                    <td ng-bind="decorateVender.contactName" ></td>
			        				                    <td ng-bind="decorateVender.contactIdNumber" ></td>
			        				                    <td ng-bind="decorateVender.contactMobile" ></td>
			        				                    <td ng-bind="decorateVender.updateAt" ></td>
			        				                    <td ng-bind="decorateVender.createAt" ></td>
			        				                    <td ng-bind="decorateVender.updateBy" ></td>
			        				                    <td ng-bind="decorateVender.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDecorateVender(decorateVender.id)" /> 
							<input type="button" value="删除" ng-click="deleteDecorateVender(decorateVender.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/app-decorate-service/decorateVender/decorateVenderList.js"></script>
