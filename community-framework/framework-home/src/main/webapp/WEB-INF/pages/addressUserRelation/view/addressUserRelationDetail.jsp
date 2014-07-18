<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="addressUserRelation" id="current_nav">
	<div id="addressUserRelationDetailApp" ng-app="addressUserRelationDetailApp">
		<div ng-controller="addressUserRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="addressUserRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="addressUserRelationId" ng-model="addressUserRelation.id" ng-bind="addressUserRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="addressID" class="col-sm-2 control-label">收货人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="addressID" ng-model="addressUserRelation.addressID" ng-bind="addressUserRelation.addressID" placeholder="请输入收货人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userID" class="col-sm-2 control-label">用户人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userID" ng-model="addressUserRelation.userID" ng-bind="addressUserRelation.userID" placeholder="请输入用户人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateAddressUserRelation(addressUserRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/addressUserRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/addressUserRelation/addressUserRelationDetail.js"></script>
