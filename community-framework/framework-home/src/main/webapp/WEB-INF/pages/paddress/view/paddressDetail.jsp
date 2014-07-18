<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="paddress" id="current_nav">
	<div id="paddressDetailApp" ng-app="paddressDetailApp">
		<div ng-controller="paddressDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="paddressForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="paddressId" ng-model="paddress.id" ng-bind="paddress.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="paddress.name" ng-bind="paddress.name" placeholder="请输入名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phone" class="col-sm-2 control-label">电话</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phone" ng-model="paddress.phone" ng-bind="paddress.phone" placeholder="请输入电话" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="address" class="col-sm-2 control-label">地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="address" ng-model="paddress.address" ng-bind="paddress.address" placeholder="请输入地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="code" class="col-sm-2 control-label">邮编</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="code" ng-model="paddress.code" ng-bind="paddress.code" placeholder="请输入邮编" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">数据创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="paddress.createBy" ng-bind="paddress.createBy" placeholder="请输入数据创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">数据更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="paddress.updateBy" ng-bind="paddress.updateBy" placeholder="请输入数据更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updatePaddress(paddress)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/paddress">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/paddress/paddressDetail.js"></script>
