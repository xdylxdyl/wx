<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="images" id="current_nav">
	<div id="imagesDetailApp" ng-app="imagesDetailApp">
		<div ng-controller="imagesDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="imagesForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="imagesId" ng-model="images.id" ng-bind="images.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">图片名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="images.name" ng-bind="images.name" placeholder="请输入图片名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="originalPath" class="col-sm-2 control-label">原图路径</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="originalPath" ng-model="images.originalPath" ng-bind="images.originalPath" placeholder="请输入原图路径" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="bigPath" class="col-sm-2 control-label">大图路径</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="bigPath" ng-model="images.bigPath" ng-bind="images.bigPath" placeholder="请输入大图路径" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="middlePath" class="col-sm-2 control-label">中图路径</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="middlePath" ng-model="images.middlePath" ng-bind="images.middlePath" placeholder="请输入中图路径" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="smallPath" class="col-sm-2 control-label">小图路径</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="smallPath" ng-model="images.smallPath" ng-bind="images.smallPath" placeholder="请输入小图路径" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="images.updateBy" ng-bind="images.updateBy" placeholder="请输入更新者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="images.createBy" ng-bind="images.createBy" placeholder="请输入创建者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateImages(images)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/images">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/app-decorate-service/images/imagesDetail.js"></script>
