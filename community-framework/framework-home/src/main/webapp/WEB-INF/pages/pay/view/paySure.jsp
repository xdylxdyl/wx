<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>


<form id="paySureForm" action="<%=request.getAttribute("req_url")%>" method="post">
	<input type="hidden" name="req_data" value='<%=request.getAttribute("req_data")%>'/>
</form>

<script language="javascript" type="text/javascript">
 window.onload=function(){
 	document.getElementById("paySureForm").submit();
 }
</script>