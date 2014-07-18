<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="providerPublicsRelation" id="current_nav">
	<div id="providerPublicsRelationDetailApp" ng-app="providerPublicsRelationDetailApp">
		<div ng-controller="providerPublicsRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="providerPublicsRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="providerPublicsRelationId" ng-model="providerPublicsRelation.id" ng-bind="providerPublicsRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="providerID" class="col-sm-2 control-label">供方ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="providerID" ng-model="providerPublicsRelation.providerID" ng-bind="providerPublicsRelation.providerID" placeholder="请输入供方ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="publicsID" class="col-sm-2 control-label">公众号ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="publicsID" ng-model="providerPublicsRelation.publicsID" ng-bind="providerPublicsRelation.publicsID" placeholder="请输入公众号ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="providerPublicsRelation.updateBy" ng-bind="providerPublicsRelation.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="providerPublicsRelation.createBy" ng-bind="providerPublicsRelation.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateProviderPublicsRelation(providerPublicsRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/providerPublicsRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/providerPublicsRelation/providerPublicsRelationDetail.js"></script>
