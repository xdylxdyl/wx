<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="owner" id="current_nav">
<div id="ownerApp" ng-app="ownerApp">
	<div ng-controller="ownerController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Owner管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addOwner(owner)">新增</span>
		    </span>
	
			<paging url="/web/a/owner">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>业主姓名</td>
			        				                    <td>固定电话</td>
			        				                    <td>手机（多个以逗号分隔）</td>
			        				                    <td>生日</td>
			        				                    <td>性别</td>
			        				                    <td>邮件</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新者ID</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建者ID</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="owner in data">				
									                    <td ng-bind="owner.id" ></td>
			        				                    <td ng-bind="owner.name" ></td>
			        				                    <td ng-bind="owner.phone" ></td>
			        				                    <td ng-bind="owner.mobile" ></td>
			        				                    <td ng-bind="owner.birthday" ></td>
			        				                    <td ng-bind="owner.sex" ></td>
			        				                    <td ng-bind="owner.email" ></td>
			        				                    <td ng-bind="owner.createAt" ></td>
			        				                    <td ng-bind="owner.updateBy" ></td>
			        				                    <td ng-bind="owner.updateAt" ></td>
			        				                    <td ng-bind="owner.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateOwner(owner.id)" /> 
							<input type="button" value="删除" ng-click="deleteOwner(owner.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/framework-building-service/owner/ownerList.js"></script>
