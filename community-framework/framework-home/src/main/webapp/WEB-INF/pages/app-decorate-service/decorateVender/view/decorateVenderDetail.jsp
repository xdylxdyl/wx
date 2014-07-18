<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="decorateVender" id="current_nav">
	<div id="decorateVenderDetailApp" ng-app="decorateVenderDetailApp">
		<div ng-controller="decorateVenderDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="decorateVenderForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="decorateVenderId" ng-model="decorateVender.id" ng-bind="decorateVender.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderId" class="col-sm-2 control-label">供方ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderId" ng-model="decorateVender.venderId" ng-bind="decorateVender.venderId" placeholder="请输入供方ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="venderName" class="col-sm-2 control-label">供方名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="venderName" ng-model="decorateVender.venderName" ng-bind="decorateVender.venderName" placeholder="请输入供方名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="isHveLcense" class="col-sm-2 control-label">是否有营业执照( 0：无，1：有)，默认为0</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="isHveLcense" ng-model="decorateVender.isHveLcense" ng-bind="decorateVender.isHveLcense" placeholder="请输入是否有营业执照( 0：无，1：有)，默认为0" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="legalName" class="col-sm-2 control-label">法人姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="legalName" ng-model="decorateVender.legalName" ng-bind="decorateVender.legalName" placeholder="请输入法人姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="legalIdNumber" class="col-sm-2 control-label">法人身份证号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="legalIdNumber" ng-model="decorateVender.legalIdNumber" ng-bind="decorateVender.legalIdNumber" placeholder="请输入法人身份证号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="legalMobile" class="col-sm-2 control-label">法人手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="legalMobile" ng-model="decorateVender.legalMobile" ng-bind="decorateVender.legalMobile" placeholder="请输入法人手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactName" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactName" ng-model="decorateVender.contactName" ng-bind="decorateVender.contactName" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactIdNumber" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactIdNumber" ng-model="decorateVender.contactIdNumber" ng-bind="decorateVender.contactIdNumber" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactMobile" class="col-sm-2 control-label"></label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactMobile" ng-model="decorateVender.contactMobile" ng-bind="decorateVender.contactMobile" placeholder="请输入" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="decorateVender.updateBy" ng-bind="decorateVender.updateBy" placeholder="请输入更新者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="decorateVender.createBy" ng-bind="decorateVender.createBy" placeholder="请输入创建者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDecorateVender(decorateVender)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/decorateVender">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/app-decorate-service/decorateVender/decorateVenderDetail.js"></script>
