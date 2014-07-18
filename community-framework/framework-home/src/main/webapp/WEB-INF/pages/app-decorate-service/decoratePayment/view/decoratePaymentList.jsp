<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="decoratePayment" id="current_nav">
<div id="decoratePaymentApp" ng-app="decoratePaymentApp">
	<div ng-controller="decoratePaymentController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>DecoratePayment管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDecoratePayment(decoratePayment)">新增</span>
		    </span>
	
			<paging url="/web/a/decoratePayment">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>NOTICEID</td>
			        				                    <td>款项名称</td>
			        				                    <td>款项金额</td>
			        				                    <td>款项状态</td>
			        				                    <td>款项类型</td>
			        				                    <td>款项备注</td>
			        				                    <td>装修手续ID</td>
			        				                    <td>装修手续序列号</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="decoratePayment in data">				
									                    <td ng-bind="decoratePayment.id" ></td>
			        				                    <td ng-bind="decoratePayment.name" ></td>
			        				                    <td ng-bind="decoratePayment.amount" ></td>
			        				                    <td ng-bind="decoratePayment.status" ></td>
			        				                    <td ng-bind="decoratePayment.type" ></td>
			        				                    <td ng-bind="decoratePayment.remark" ></td>
			        				                    <td ng-bind="decoratePayment.decorateId" ></td>
			        				                    <td ng-bind="decoratePayment.decorateSerialId" ></td>
			        				                    <td ng-bind="decoratePayment.updateAt" ></td>
			        				                    <td ng-bind="decoratePayment.createAt" ></td>
			        				                    <td ng-bind="decoratePayment.updateBy" ></td>
			        				                    <td ng-bind="decoratePayment.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDecoratePayment(decoratePayment.id)" /> 
							<input type="button" value="删除" ng-click="deleteDecoratePayment(decoratePayment.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/app-decorate-service/decoratePayment/decoratePaymentList.js"></script>
