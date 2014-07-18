<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="gorderGoodsRelation" id="current_nav">
	<div id="gorderGoodsRelationDetailApp" ng-app="gorderGoodsRelationDetailApp">
		<div ng-controller="gorderGoodsRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="gorderGoodsRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="gorderGoodsRelationId" ng-model="gorderGoodsRelation.id" ng-bind="gorderGoodsRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="gorderID" class="col-sm-2 control-label">订单ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="gorderID" ng-model="gorderGoodsRelation.gorderID" ng-bind="gorderGoodsRelation.gorderID" placeholder="请输入订单ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="goodsID" class="col-sm-2 control-label">商品ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="goodsID" ng-model="gorderGoodsRelation.goodsID" ng-bind="gorderGoodsRelation.goodsID" placeholder="请输入商品ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="gorderGoodsRelation.updateBy" ng-bind="gorderGoodsRelation.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="gorderGoodsRelation.createBy" ng-bind="gorderGoodsRelation.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateGorderGoodsRelation(gorderGoodsRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/gorderGoodsRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/gorderGoodsRelation/gorderGoodsRelationDetail.js"></script>
