<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="room" id="current_nav">
<div id="roomApp" ng-app="roomApp">
	<div ng-controller="roomController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Room管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addRoom(room)">新增</span>
		    </span>
	
			<paging url="/web/a/room">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id</td>
			        				                    <td>房房间名称</td>
			        				                    <td>房房间编码</td>
			        				                    <td>房房间状态 1：启用 0：停用</td>
			        				                    <td>房房间面积</td>
			        				                    <td>房房间单元</td>
			        				                    <td>房房间楼层</td>
			        				                    <td>房房间门牌号</td>
			        				                    <td>房楼栋ID</td>
			        				                    <td>房楼栋名称</td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        				                    <td></td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="room in data">				
									                    <td ng-bind="room.id" ></td>
			        				                    <td ng-bind="room.name" ></td>
			        				                    <td ng-bind="room.code" ></td>
			        				                    <td ng-bind="room.status" ></td>
			        				                    <td ng-bind="room.roomArea" ></td>
			        				                    <td ng-bind="room.roomUnit" ></td>
			        				                    <td ng-bind="room.roomFloor" ></td>
			        				                    <td ng-bind="room.roomNum" ></td>
			        				                    <td ng-bind="room.buildingId" ></td>
			        				                    <td ng-bind="room.buildingName" ></td>
			        				                    <td ng-bind="room.createAt" ></td>
			        				                    <td ng-bind="room.updateBy" ></td>
			        				                    <td ng-bind="room.updateAt" ></td>
			        				                    <td ng-bind="room.createBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateRoom(room.id)" /> 
							<input type="button" value="删除" ng-click="deleteRoom(room.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/framework-building-service/room/roomList.js"></script>
