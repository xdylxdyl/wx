<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="category" id="current_nav">
	<div id="categoryDetailApp" ng-app="categoryDetailApp">
		<div ng-controller="categoryDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="categoryForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="categoryId" ng-model="category.id" ng-bind="category.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="category.name" ng-bind="category.name" placeholder="请输入名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="category.status" ng-bind="category.status" placeholder="请输入状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="category.createBy" ng-bind="category.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="category.updateBy" ng-bind="category.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateCategory(category)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/category">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/category/categoryDetail.js"></script>
