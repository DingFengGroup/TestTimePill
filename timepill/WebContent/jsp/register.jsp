<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../global.jsp"%>
<html>
<head>
<title>用户登录</title>
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
	
	
	
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>