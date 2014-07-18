<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="tagsGoodsRelation" id="current_nav">
	<div id="tagsGoodsRelationDetailApp" ng-app="tagsGoodsRelationDetailApp">
		<div ng-controller="tagsGoodsRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="tagsGoodsRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="tagsGoodsRelationId" ng-model="tagsGoodsRelation.id" ng-bind="tagsGoodsRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tagsID" class="col-sm-2 control-label">标签ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tagsID" ng-model="tagsGoodsRelation.tagsID" ng-bind="tagsGoodsRelation.tagsID" placeholder="请输入标签ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="goodsID" class="col-sm-2 control-label">商品ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="goodsID" ng-model="tagsGoodsRelation.goodsID" ng-bind="tagsGoodsRelation.goodsID" placeholder="请输入商品ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="tagsGoodsRelation.updateBy" ng-bind="tagsGoodsRelation.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="tagsGoodsRelation.createBy" ng-bind="tagsGoodsRelation.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateTagsGoodsRelation(tagsGoodsRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/tagsGoodsRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/tagsGoodsRelation/tagsGoodsRelationDetail.js"></script>
