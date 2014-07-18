<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="decorate" id="current_nav">
	<div id="decorateDetailApp" ng-app="decorateDetailApp">
		<div ng-controller="decorateDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="decorateForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="decorateId" ng-model="decorate.id" ng-bind="decorate.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="serialId" class="col-sm-2 control-label">装修序列号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="serialId" ng-model="decorate.serialId" ng-bind="decorate.serialId" placeholder="请输入装修序列号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">客户ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="decorate.userId" ng-bind="decorate.userId" placeholder="请输入客户ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userName" class="col-sm-2 control-label">客户姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userName" ng-model="decorate.userName" ng-bind="decorate.userName" placeholder="请输入客户姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userMobile" class="col-sm-2 control-label">客户手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userMobile" ng-model="decorate.userMobile" ng-bind="decorate.userMobile" placeholder="请输入客户手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userWxId" class="col-sm-2 control-label">客户微信ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userWxId" ng-model="decorate.userWxId" ng-bind="decorate.userWxId" placeholder="请输入客户微信ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userWxName" class="col-sm-2 control-label">客户微信名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userWxName" ng-model="decorate.userWxName" ng-bind="decorate.userWxName" placeholder="请输入客户微信名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roomId" class="col-sm-2 control-label">房间ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roomId" ng-model="decorate.roomId" ng-bind="decorate.roomId" placeholder="请输入房间ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roomName" class="col-sm-2 control-label">房间名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roomName" ng-model="decorate.roomName" ng-bind="decorate.roomName" placeholder="请输入房间名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="buildingId" class="col-sm-2 control-label">楼栋ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="buildingId" ng-model="decorate.buildingId" ng-bind="decorate.buildingId" placeholder="请输入楼栋ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderId" class="col-sm-2 control-label">装修公司ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderId" ng-model="decorate.venderId" ng-bind="decorate.venderId" placeholder="请输入装修公司ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderName" class="col-sm-2 control-label">装修公司名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderName" ng-model="decorate.venderName" ng-bind="decorate.venderName" placeholder="请输入装修公司名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="chargerId" class="col-sm-2 control-label">现场责任人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="chargerId" ng-model="decorate.chargerId" ng-bind="decorate.chargerId" placeholder="请输入现场责任人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="chargerName" class="col-sm-2 control-label">现场责任人名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="chargerName" ng-model="decorate.chargerName" ng-bind="decorate.chargerName" placeholder="请输入现场责任人名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="chargerMobile" class="col-sm-2 control-label">公众号ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="chargerMobile" ng-model="decorate.chargerMobile" ng-bind="decorate.chargerMobile" placeholder="请输入公众号ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="publicsId" class="col-sm-2 control-label">公众号名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="publicsId" ng-model="decorate.publicsId" ng-bind="decorate.publicsId" placeholder="请输入公众号名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="publicsName" class="col-sm-2 control-label">图纸数量</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="publicsName" ng-model="decorate.publicsName" ng-bind="decorate.publicsName" placeholder="请输入图纸数量" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="drawingCount" class="col-sm-2 control-label">审核状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="drawingCount" ng-model="decorate.drawingCount" ng-bind="decorate.drawingCount" placeholder="请输入审核状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">预计开工日期</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="decorate.status" ng-bind="decorate.status" placeholder="请输入预计开工日期" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="expectStartDate" class="col-sm-2 control-label">预计验收日期</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="expectStartDate" ng-model="decorate.expectStartDate" ng-bind="decorate.expectStartDate" placeholder="请输入预计验收日期" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="expectCheckDate" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="expectCheckDate" ng-model="decorate.expectCheckDate" ng-bind="decorate.expectCheckDate" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="decorate.updateBy" ng-bind="decorate.updateBy" placeholder="请输入更新者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="decorate.createBy" ng-bind="decorate.createBy" placeholder="请输入创建者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDecorate(decorate)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/decorate">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/app-decorate-service/decorate/decorateDetail.js"></script>
