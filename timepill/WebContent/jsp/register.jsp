<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../global.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>用户登录</title>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	var err = 0;
	$("#but").click(function(){
		var nickName = $("#nickName").val();
		if(nickName == null || nickName == ""){
			$("#errMessage").html("<p style=\"color:red\">名字 必须填写。 </p>");
			return;
		}
		var email = $("#Email").val();
		if(email == null || email == ""){
			$("#errMessage").html("<p style=\"color:red\">邮箱 必须填写。 </p>");
			return ;
		}
		var passWord = $("#passWord").val();
		if(passWord == null || passWord == ""){
			$("#errMessage").html("<p style=\"color:red\">密码  必须填写。 </p>");
			return;
		}
		var passWord1 = $("#passWord1").val();
		if(passWord1 == null || passWord1 == ""){
			$("#errMessage").html("<p style=\"color:red\">确认密码  必须填写。 </p>");
			return;
		}
		if(passWord1 != passWord){										//验证密码和确认密码相同
			$("#errMessage").html("<p style=\"color:red\">密码与确认密码 不符合 。 </p>");
			return;
		}
		if(!checkIsEmail(email)){
			$("#errMessage").html("<p style=\"color:red\">邮箱 必须是一个有效的电子邮箱地址. </p>");
			return;
		}
		if(err == -1){
			$("#errMessage").html("<p style=\"color:red\">邮箱 已经存在. </p>");
			return false;
		}
		if(err == 1){
			$("#errMessage").html("<p style=\"color:red\">邮箱 必须是一个有效的电子邮箱地址. </p>");
			return false;
		}
		$("#form1").submit();
	})
	//验证是否是有效邮箱格式
	function checkIsEmail(email){
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		 if(myreg.test(email)){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	//当邮箱失去焦点时 触发的事件
	 $("#Email").focusout(function(){
		var email = $("#Email").val();
		if(!checkIsEmail(email)){
			err = 1;
			$("#errMessage").html("<p style=\"color:red\">邮箱 必须是一个有效的电子邮箱地址. </p>");
			return false;
		}
		$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/registerServlet",
		   data: "method=checkEmail&Email="+email,
		   success: function(back){
			   if(back == 0 || back == '0'){
				   err = -1;
				   $("#errMessage").html("<p style=\"color:red\">邮箱 已经存在. </p>");
			   }
		   }
		});
	}); 
	
})
</script>
<c:if test="${back1 == 0 }">
<script type="text/javascript">
	alert("保存成功！！");
</script>
</c:if>
<c:if test="${back1 == -1 }">
<script type="text/javascript">
	alert("保存失败！！");
</script>
</c:if>
</head>
<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<form method="post" action="${pageContext.request.contextPath}/registerServlet?method=registerUser" id="form1" 
		style="width: 300px; height: auto; margin: auto; margin-top: 50px">
		<input type="hidden" name="method" value="registerUser">
		<h2 style="text-align: center;font-size: 25px;">注册</h2>
		<br/>
		<table width="300" border="0">
			<tr>
				<td id="errMessage"></td>
			</tr>
			<tr style="height:20px">
				<th>名字：</th>
			</tr>
			<tr>
				<th scope="col"><input type="text" name="nickName" id="nickName" value="${back1}"></th>
			</tr>
			<tr style="height:20px">
				<th>邮箱：</th>
			</tr>	
			<tr>
				<th scope="col"><input  type="text" name="Email" id="Email"></th>
			</tr>
			<tr style="height:20px">
				<th>密码：</th>
			</tr>	
			<tr>
				<th scope="col"><input  type="passWord" name="passWord" id="passWord"></th>
			</tr>
			<tr style="height:20px">
				<th>确认密码：</th>
			</tr>
			<tr>
				<th  scope="col"><input  type="passWord" name="passWord1" id="passWord1"></th>
			</tr>
			<tr>
				<th><input type="button" value="注册" id="but"></th>
			</tr>
		</table>
	</form>
	
	
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>