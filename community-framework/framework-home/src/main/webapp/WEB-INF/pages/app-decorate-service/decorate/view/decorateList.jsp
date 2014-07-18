<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="decorate" id="current_nav">
<div id="decorateApp" ng-app="decorateApp">
	<div ng-controller="decorateController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Decorate管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDecorate(decorate)">新增</span>
		    </span>
	
			<paging url="/web/a/decorate">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>NOTICEID</td>
			        				                    <td>装修序列号</td>
			        				                    <td>客户ID</td>
			        				                    <td>客户姓名</td>
			        				                    <td>客户手机号</td>
			        				                    <td>客户微信ID</td>
			        				                    <td>客户微信名称</td>
			        				                    <td>房间ID</td>
			        				                    <td>房间名称</td>
			        				                    <td>楼栋ID</td>
			        				                    <td>装修公司ID</td>
			        				                    <td>装修公司名称</td>
			        				                    <td>现场责任人ID</td>
			        				                    <td>现场责任人名称</td>
			        				                    <td>公众号ID</td>
			        				                    <td>公众号名称</td>
			        				                    <td>图纸数量</td>
			        				                    <td>审核状态</td>
			        				                    <td>预计开工日期</td>
			        				                    <td>预计验收日期</td>
			        				                    <td></td>
			        				                    <td>更新时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="decorate in data">				
									                    <td ng-bind="decorate.id" ></td>
			        				                    <td ng-bind="decorate.serialId" ></td>
			        				                    <td ng-bind="decorate.userId" ></td>
			        				                    <td ng-bind="decorate.userName" ></td>
			        				                    <td ng-bind="decorate.userMobile" ></td>
			        				                    <td ng-bind="decorate.userWxId" ></td>
			        				                    <td ng-bind="decorate.userWxName" ></td>
			        				                    <td ng-bind="decorate.roomId" ></td>
			        				                    <td ng-bind="decorate.roomName" ></td>
			        				                    <td ng-bind="decorate.buildingId" ></td>
			        				                    <td ng-bind="decorate.venderId" ></td>
			        				                    <td ng-bind="decorate.venderName" ></td>
			        				                    <td ng-bind="decorate.chargerId" ></td>
			        				                    <td ng-bind="decorate.chargerName" ></td>
			        				                    <td ng-bind="decorate.chargerMobile" ></td>
			        				                    <td ng-bind="decorate.publicsId" ></td>
			        				                    <td ng-bind="decorate.publicsName" ></td>
			        				                    <td ng-bind="decorate.drawingCount" ></td>
			        				                    <td ng-bind="decorate.status" ></td>
			        				                    <td ng-bind="decorate.expectStartDate" ></td>
			        				                    <td ng-bind="decorate.expectCheckDate" ></td>
			        				                    <td ng-bind="decorate.updateAt" ></td>
			        				                    <td ng-bind="decorate.createAt" ></td>
			        				                    <td ng-bind="decorate.updateBy" ></td>
			        				                    <td ng-bind="decorate.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDecorate(decorate.id)" /> 
							<input type="button" value="删除" ng-click="deleteDecorate(decorate.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/app-decorate-service/decorate/decorateList.js"></script>
