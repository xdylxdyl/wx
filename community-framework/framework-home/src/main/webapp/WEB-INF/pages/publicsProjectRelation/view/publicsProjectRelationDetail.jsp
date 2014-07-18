<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="publicsProjectRelation" id="current_nav">
	<div id="publicsProjectRelationDetailApp" ng-app="publicsProjectRelationDetailApp">
		<div ng-controller="publicsProjectRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="publicsProjectRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="publicsProjectRelationId" ng-model="publicsProjectRelation.id" ng-bind="publicsProjectRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="publicsID" class="col-sm-2 control-label">公众号ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="publicsID" ng-model="publicsProjectRelation.publicsID" ng-bind="publicsProjectRelation.publicsID" placeholder="请输入公众号ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="projectID" class="col-sm-2 control-label">项目ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="projectID" ng-model="publicsProjectRelation.projectID" ng-bind="publicsProjectRelation.projectID" placeholder="请输入项目ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">数据更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="publicsProjectRelation.updateBy" ng-bind="publicsProjectRelation.updateBy" placeholder="请输入数据更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="publicsProjectRelation.createBy" ng-bind="publicsProjectRelation.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updatePublicsProjectRelation(publicsProjectRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/publicsProjectRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/publicsProjectRelation/publicsProjectRelationDetail.js"></script>
