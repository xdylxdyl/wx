<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="gorder" id="current_nav">
	<div id="gorderDetailApp" ng-app="gorderDetailApp">
		<div ng-controller="gorderDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="gorderForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="gorderId" ng-model="gorder.id" ng-bind="gorder.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userID" class="col-sm-2 control-label">用户人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userID" ng-model="gorder.userID" ng-bind="gorder.userID" placeholder="请输入用户人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="addressID" class="col-sm-2 control-label">收货人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="addressID" ng-model="gorder.addressID" ng-bind="gorder.addressID" placeholder="请输入收货人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="publicsID" class="col-sm-2 control-label">公众号ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="publicsID" ng-model="gorder.publicsID" ng-bind="gorder.publicsID" placeholder="请输入公众号ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="code" class="col-sm-2 control-label">编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="code" ng-model="gorder.code" ng-bind="gorder.code" placeholder="请输入编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="total" class="col-sm-2 control-label">金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="total" ng-model="gorder.total" ng-bind="gorder.total" placeholder="请输入金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="gorder.type" ng-bind="gorder.type" placeholder="请输入类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="gorder.status" ng-bind="gorder.status" placeholder="请输入状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="gorder.createBy" ng-bind="gorder.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="gorder.updateBy" ng-bind="gorder.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="gorderAt" class="col-sm-2 control-label">数据更新时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="gorderAt" ng-model="gorder.gorderAt" ng-bind="gorder.gorderAt" placeholder="请输入数据更新时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateGorder(gorder)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/gorder">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/gorder/gorderDetail.js"></script>
