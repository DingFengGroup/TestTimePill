<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登录</title>

<link href="../css/main.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.5.1.min.js" type="text/javascript"></script>

</head>

<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<form action="/timepill/login" method="post"
		style="width: 300px; height: auto; margin: auto; margin-top: 50px">
		<h2 style="text-align: center;font-size: 25px;">登录</h2>
		<br/>
		<table width="300" border="0">
			<tr>
				<th>用户名：</th>
				<th scope="col"><input type="text" name="accountName" id="accountName"></th>
			</tr>
			<tr>
				<th scope="col">密&nbsp;&nbsp;&nbsp;码：</th>
				<th scope="col"><input  type="passWord" name="passWord" id="passWord"></th>
			</tr>
			<tr>
				<th><input type="submit" value="登录" name="submit"></th>
			</tr>
		</table>
	</form>
	
	
	<!-- <h1 class="page-header">登录</h1>
	<form action="/login" method="post" accept-charset="utf-8"
		class="form-small">
		<div class="err"></div>
		<label>邮箱：</label> <input type="text" id="email" name="email" value=""
			tabindex="1" />
		<label>密码：</label> <input type="password" name="password" tabindex="2" />
		<a href="/home/forgot_password" tabindex="5">忘记密码?</a> <label
			class="checkbox"> <input type="checkbox" name="expire"
			value="1" tabindex="3" /> 在这台电脑上记住我
		</label> <input type="submit" value="登录" tabindex="4" /> <input type="hidden"
			name="redirect" value="http://www.timepill.net/" />
	</form> -->
	
	
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
