<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="decorateLog" id="current_nav">
<div id="decorateLogApp" ng-app="decorateLogApp">
	<div ng-controller="decorateLogController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>DecorateLog管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDecorateLog(decorateLog)">新增</span>
		    </span>
	
			<paging url="/web/a/decorateLog">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>NOTICEID</td>
			        				                    <td>装修手续ID</td>
			        				                    <td>状态</td>
			        				                    <td>描述</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="decorateLog in data">				
									                    <td ng-bind="decorateLog.id" ></td>
			        				                    <td ng-bind="decorateLog.decorateId" ></td>
			        				                    <td ng-bind="decorateLog.status" ></td>
			        				                    <td ng-bind="decorateLog.description" ></td>
			        				                    <td ng-bind="decorateLog.updateAt" ></td>
			        				                    <td ng-bind="decorateLog.createAt" ></td>
			        				                    <td ng-bind="decorateLog.updateBy" ></td>
			        				                    <td ng-bind="decorateLog.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDecorateLog(decorateLog.id)" /> 
							<input type="button" value="删除" ng-click="deleteDecorateLog(decorateLog.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/app-decorate-service/decorateLog/decorateLogList.js"></script>
