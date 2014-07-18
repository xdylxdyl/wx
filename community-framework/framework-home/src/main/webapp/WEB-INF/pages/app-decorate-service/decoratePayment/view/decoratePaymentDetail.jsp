<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="decoratePayment" id="current_nav">
	<div id="decoratePaymentDetailApp" ng-app="decoratePaymentDetailApp">
		<div ng-controller="decoratePaymentDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="decoratePaymentForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="decoratePaymentId" ng-model="decoratePayment.id" ng-bind="decoratePayment.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">款项名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="decoratePayment.name" ng-bind="decoratePayment.name" placeholder="请输入款项名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="amount" class="col-sm-2 control-label">款项金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="amount" ng-model="decoratePayment.amount" ng-bind="decoratePayment.amount" placeholder="请输入款项金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">款项状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="decoratePayment.status" ng-bind="decoratePayment.status" placeholder="请输入款项状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">款项类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="decoratePayment.type" ng-bind="decoratePayment.type" placeholder="请输入款项类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="remark" class="col-sm-2 control-label">款项备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="remark" ng-model="decoratePayment.remark" ng-bind="decoratePayment.remark" placeholder="请输入款项备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="decorateId" class="col-sm-2 control-label">装修手续ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="decorateId" ng-model="decoratePayment.decorateId" ng-bind="decoratePayment.decorateId" placeholder="请输入装修手续ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="decorateSerialId" class="col-sm-2 control-label">装修手续序列号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="decorateSerialId" ng-model="decoratePayment.decorateSerialId" ng-bind="decoratePayment.decorateSerialId" placeholder="请输入装修手续序列号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="decoratePayment.updateBy" ng-bind="decoratePayment.updateBy" placeholder="请输入更新者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="decoratePayment.createBy" ng-bind="decoratePayment.createBy" placeholder="请输入创建者ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDecoratePayment(decoratePayment)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/decoratePayment">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/app-decorate-service/decoratePayment/decoratePaymentDetail.js"></script>
