<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="decorateVenderUser" id="current_nav">
	<div id="decorateVenderUserDetailApp" ng-app="decorateVenderUserDetailApp">
		<div ng-controller="decorateVenderUserDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="decorateVenderUserForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="decorateVenderUserId" ng-model="decorateVenderUser.id" ng-bind="decorateVenderUser.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderId" class="col-sm-2 control-label">供方ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderId" ng-model="decorateVenderUser.venderId" ng-bind="decorateVenderUser.venderId" placeholder="请输入供方ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderName" class="col-sm-2 control-label">供方名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderName" ng-model="decorateVenderUser.venderName" ng-bind="decorateVenderUser.venderName" placeholder="请输入供方名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userName" class="col-sm-2 control-label">责任人姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userName" ng-model="decorateVenderUser.userName" ng-bind="decorateVenderUser.userName" placeholder="请输入责任人姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userIdNumber" class="col-sm-2 control-label">责任人身份证号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userIdNumber" ng-model="decorateVenderUser.userIdNumber" ng-bind="decorateVenderUser.userIdNumber" placeholder="请输入责任人身份证号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userMobile" class="col-sm-2 control-label">责任人手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userMobile" ng-model="decorateVenderUser.userMobile" ng-bind="decorateVenderUser.userMobile" placeholder="请输入责任人手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userMobile1" class="col-sm-2 control-label">责任人手机号1</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userMobile1" ng-model="decorateVenderUser.userMobile1" ng-bind="decorateVenderUser.userMobile1" placeholder="请输入责任人手机号1" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userMobile2" class="col-sm-2 control-label">责任人手机号2</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userMobile2" ng-model="decorateVenderUser.userMobile2" ng-bind="decorateVenderUser.userMobile2" placeholder="请输入责任人手机号2" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userEmail" class="col-sm-2 control-label">责任人Email</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userEmail" ng-model="decorateVenderUser.userEmail" ng-bind="decorateVenderUser.userEmail" placeholder="请输入责任人Email" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userQq" class="col-sm-2 control-label">责任人QQ</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userQq" ng-model="decorateVenderUser.userQq" ng-bind="decorateVenderUser.userQq" placeholder="请输入责任人QQ" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="decorateVenderUser.updateBy" ng-bind="decorateVenderUser.updateBy" placeholder="请输入更新者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="decorateVenderUser.createBy" ng-bind="decorateVenderUser.createBy" placeholder="请输入创建者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDecorateVenderUser(decorateVenderUser)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/decorateVenderUser">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/app-decorate-service/decorateVenderUser/decorateVenderUserDetail.js"></script>
