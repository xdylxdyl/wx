<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="projectOrgRelation" id="current_nav">
	<div id="projectOrgRelationDetailApp" ng-app="projectOrgRelationDetailApp">
		<div ng-controller="projectOrgRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="projectOrgRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="projectOrgRelationId" ng-model="projectOrgRelation.id" ng-bind="projectOrgRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="projectId" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="projectId" ng-model="projectOrgRelation.projectId" ng-bind="projectOrgRelation.projectId" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="orgId" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="orgId" ng-model="projectOrgRelation.orgId" ng-bind="projectOrgRelation.orgId" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="projectOrgRelation.updateBy" ng-bind="projectOrgRelation.updateBy" placeholder="请输入更新者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="projectOrgRelation.createBy" ng-bind="projectOrgRelation.createBy" placeholder="请输入创建者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateProjectOrgRelation(projectOrgRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/projectOrgRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/framework-building-service/projectOrgRelation/projectOrgRelationDetail.js"></script>
