<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="tagsPublicsRelation" id="current_nav">
	<div id="tagsPublicsRelationDetailApp" ng-app="tagsPublicsRelationDetailApp">
		<div ng-controller="tagsPublicsRelationDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="tagsPublicsRelationForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="tagsPublicsRelationId" ng-model="tagsPublicsRelation.id" ng-bind="tagsPublicsRelation.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tagsID" class="col-sm-2 control-label">标签ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tagsID" ng-model="tagsPublicsRelation.tagsID" ng-bind="tagsPublicsRelation.tagsID" placeholder="请输入标签ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="publicsID" class="col-sm-2 control-label">公众号ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="publicsID" ng-model="tagsPublicsRelation.publicsID" ng-bind="tagsPublicsRelation.publicsID" placeholder="请输入公众号ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="tagsPublicsRelation.updateBy" ng-bind="tagsPublicsRelation.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="tagsPublicsRelation.createBy" ng-bind="tagsPublicsRelation.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateTagsPublicsRelation(tagsPublicsRelation)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/tagsPublicsRelation">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/tagsPublicsRelation/tagsPublicsRelationDetail.js"></script>
