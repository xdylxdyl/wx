<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="cartGoodsRelation" id="current_nav">
	<div id="cartGoodsRelationDetailApp" ng-app="cartGoodsRelationDetailApp">
		<div ng-controller="cartGoodsRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="cartGoodsRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="cartGoodsRelationId" ng-model="cartGoodsRelation.id" ng-bind="cartGoodsRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="cartID" class="col-sm-2 control-label">购物车ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="cartID" ng-model="cartGoodsRelation.cartID" ng-bind="cartGoodsRelation.cartID" placeholder="请输入购物车ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="goodsID" class="col-sm-2 control-label">商品ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="goodsID" ng-model="cartGoodsRelation.goodsID" ng-bind="cartGoodsRelation.goodsID" placeholder="请输入商品ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="count" class="col-sm-2 control-label">数量</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="count" ng-model="cartGoodsRelation.count" ng-bind="cartGoodsRelation.count" placeholder="请输入数量" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="cartGoodsRelation.updateBy" ng-bind="cartGoodsRelation.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="cartGoodsRelation.createBy" ng-bind="cartGoodsRelation.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateCartGoodsRelation(cartGoodsRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/cartGoodsRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/cartGoodsRelation/cartGoodsRelationDetail.js"></script>
