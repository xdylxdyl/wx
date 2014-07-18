<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="userOpenRelation" id="current_nav">
	<div id="userOpenRelationDetailApp" ng-app="userOpenRelationDetailApp">
		<div ng-controller="userOpenRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userOpenRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userOpenRelationId" ng-model="userOpenRelation.id" ng-bind="userOpenRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="uid" class="col-sm-2 control-label">用户ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="uid" ng-model="userOpenRelation.uid" ng-bind="userOpenRelation.uid" placeholder="请输入用户ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="openID" class="col-sm-2 control-label">OPENID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="openID" ng-model="userOpenRelation.openID" ng-bind="userOpenRelation.openID" placeholder="请输入OPENID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">类型 wx_openID,mobile,wx_fakeID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="userOpenRelation.type" ng-bind="userOpenRelation.type" placeholder="请输入类型 wx_openID,mobile,wx_fakeID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserOpenRelation(userOpenRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userOpenRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/userOpenRelation/userOpenRelationDetail.js"></script>
