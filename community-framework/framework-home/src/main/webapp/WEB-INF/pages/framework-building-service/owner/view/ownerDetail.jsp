<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="owner" id="current_nav">
	<div id="ownerDetailApp" ng-app="ownerDetailApp">
		<div ng-controller="ownerDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="ownerForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="ownerId" ng-model="owner.id" ng-bind="owner.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">业主姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="owner.name" ng-bind="owner.name" placeholder="请输入业主姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phone" class="col-sm-2 control-label">固定电话</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phone" ng-model="owner.phone" ng-bind="owner.phone" placeholder="请输入固定电话" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="mobile" class="col-sm-2 control-label">手机（多个以逗号分隔）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="mobile" ng-model="owner.mobile" ng-bind="owner.mobile" placeholder="请输入手机（多个以逗号分隔）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="birthday" class="col-sm-2 control-label">生日</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="birthday" ng-model="owner.birthday" ng-bind="owner.birthday" placeholder="请输入生日" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="sex" class="col-sm-2 control-label">性别</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="sex" ng-model="owner.sex" ng-bind="owner.sex" placeholder="请输入性别" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="email" class="col-sm-2 control-label">邮件</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="email" ng-model="owner.email" ng-bind="owner.email" placeholder="请输入邮件" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="owner.updateBy" ng-bind="owner.updateBy" placeholder="请输入更新者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="owner.createBy" ng-bind="owner.createBy" placeholder="请输入创建者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateOwner(owner)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/owner">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/framework-building-service/owner/ownerDetail.js"></script>
