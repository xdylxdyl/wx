<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="addressProjectRelation" id="current_nav">
	<div id="addressProjectRelationDetailApp" ng-app="addressProjectRelationDetailApp">
		<div ng-controller="addressProjectRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="addressProjectRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="addressProjectRelationId" ng-model="addressProjectRelation.id" ng-bind="addressProjectRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="addressID" class="col-sm-2 control-label">地址ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="addressID" ng-model="addressProjectRelation.addressID" ng-bind="addressProjectRelation.addressID" placeholder="请输入地址ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userID" class="col-sm-2 control-label">项目ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userID" ng-model="addressProjectRelation.userID" ng-bind="addressProjectRelation.userID" placeholder="请输入项目ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">数据更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="addressProjectRelation.updateBy" ng-bind="addressProjectRelation.updateBy" placeholder="请输入数据更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="addressProjectRelation.createBy" ng-bind="addressProjectRelation.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateAddressProjectRelation(addressProjectRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/addressProjectRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/addressProjectRelation/addressProjectRelationDetail.js"></script>
