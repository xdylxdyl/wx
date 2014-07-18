<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="building" id="current_nav">
	<div id="buildingDetailApp" ng-app="buildingDetailApp">
		<div ng-controller="buildingDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="buildingForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="buildingId" ng-model="building.id" ng-bind="building.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">楼栋名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="building.name" ng-bind="building.name" placeholder="请输入楼栋名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="code" class="col-sm-2 control-label">楼栋编码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="code" ng-model="building.code" ng-bind="building.code" placeholder="请输入楼栋编码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">楼栋状态 1：启用 0：停用</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="building.status" ng-bind="building.status" placeholder="请输入楼栋状态 1：启用 0：停用" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="projectId" class="col-sm-2 control-label">所属项目ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="projectId" ng-model="building.projectId" ng-bind="building.projectId" placeholder="请输入所属项目ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="projectName" class="col-sm-2 control-label">所属项目名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="projectName" ng-model="building.projectName" ng-bind="building.projectName" placeholder="请输入所属项目名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="isVirtual" class="col-sm-2 control-label">是否虚拟 1：是 0：否</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="isVirtual" ng-model="building.isVirtual" ng-bind="building.isVirtual" placeholder="请输入是否虚拟 1：是 0：否" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="building.updateBy" ng-bind="building.updateBy" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="building.createBy" ng-bind="building.createBy" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateBuilding(building)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/building">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/framework-building-service/building/buildingDetail.js"></script>
