<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="room" id="current_nav">
	<div id="roomDetailApp" ng-app="roomDetailApp">
		<div ng-controller="roomDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="roomForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="roomId" ng-model="room.id" ng-bind="room.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">房房间名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="room.name" ng-bind="room.name" placeholder="请输入房房间名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="code" class="col-sm-2 control-label">房房间编码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="code" ng-model="room.code" ng-bind="room.code" placeholder="请输入房房间编码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">房房间状态 1：启用 0：停用</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="room.status" ng-bind="room.status" placeholder="请输入房房间状态 1：启用 0：停用" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roomArea" class="col-sm-2 control-label">房房间面积</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roomArea" ng-model="room.roomArea" ng-bind="room.roomArea" placeholder="请输入房房间面积" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roomUnit" class="col-sm-2 control-label">房房间单元</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roomUnit" ng-model="room.roomUnit" ng-bind="room.roomUnit" placeholder="请输入房房间单元" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roomFloor" class="col-sm-2 control-label">房房间楼层</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roomFloor" ng-model="room.roomFloor" ng-bind="room.roomFloor" placeholder="请输入房房间楼层" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roomNum" class="col-sm-2 control-label">房房间门牌号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roomNum" ng-model="room.roomNum" ng-bind="room.roomNum" placeholder="请输入房房间门牌号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="buildingId" class="col-sm-2 control-label">房楼栋ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="buildingId" ng-model="room.buildingId" ng-bind="room.buildingId" placeholder="请输入房楼栋ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="buildingName" class="col-sm-2 control-label">房楼栋名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="buildingName" ng-model="room.buildingName" ng-bind="room.buildingName" placeholder="请输入房楼栋名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="room.updateBy" ng-bind="room.updateBy" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="room.createBy" ng-bind="room.createBy" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateRoom(room)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/room">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/framework-building-service/room/roomDetail.js"></script>
