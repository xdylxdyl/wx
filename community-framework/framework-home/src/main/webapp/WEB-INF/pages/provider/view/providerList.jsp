<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="provider" id="current_nav">
<div id="providerApp" ng-app="providerApp">
	<div ng-controller="providerController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Provider管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProvider(provider)">新增</span>
		    </span>
	
			<paging url="/web/a/provider">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>名称</td>
			        				                    <td>联系人</td>
			        				                    <td>电话</td>
			        				                    <td>类型</td>
			        				                    <td>状态</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="provider in data">				
									                    <td ng-cloak>{{provider.id}}</td>
			        				                    <td ng-cloak>{{provider.name}}</td>
			        				                    <td ng-cloak>{{provider.contact}}</td>
			        				                    <td ng-cloak>{{provider.phone}}</td>
			        				                    <td ng-cloak>{{provider.type}}</td>
			        				                    <td ng-cloak>{{provider.status}}</td>
			        				                    <td ng-cloak>{{provider.createBy}}</td>
			        				                    <td ng-cloak>{{provider.updateBy}}</td>
			        				                    <td ng-cloak>{{provider.updateAt}}</td>
			        				                    <td ng-cloak>{{provider.createAt}}</td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProvider(provider.id)" /> 
							<input type="button" value="删除" ng-click="deleteProvider(provider.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/provider/providerList.js"></script>
