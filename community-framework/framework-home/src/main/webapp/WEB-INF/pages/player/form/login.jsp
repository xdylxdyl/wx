<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="../../includes/includes.jsp"%>



<form action="/login/index"
			method="post">


			<h1>创建帐户</h1>

				
				<label for="mobile">手机号</label>
				
					<input type="text" id="mobile" name="mobile"
						placeholder="手机号" class="sign" value="">
						
				<label for="verifyCode">验证码</label>
				
					<input type="text" id="verifyCode" name="verifyCode"
						placeholder="验证码" class="sign" value="">				
					
					<a onclick="sendCode()">获取验证码</a>
				
				<input class="" type="submit"
					id="submit" />
				

			
		</form>

	<script type="text/javascript" src="/r/js/jquery.js"></script>
	<script>
	<!--
	function sendCode(){
		if($("#mobile").val()){
			$.ajax({
				type:'post',
				url:'/web/a/send/sms',
				data:{mobile:$("#mobile").val()},
				dataType:'json',
				success:function(data){
					console.log(data);
					if(data.success){
						alert("发送成功");
					}else{
						alert("发送失败");
					}
				}
			});
		}else{
			alert("请填写手机号");
		}
	}
	//-->
	</script>