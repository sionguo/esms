<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/login.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/login.js"></script>
<title>登录</title>
</head>

<body>
	<div class="head">
		<a href="toindex.do"><img src="${pageContext.request.contextPath }/img/logo18546.png" /></a>
		<p></p>
	</div>
	<div class="body">
		<div style="width: 100%; height: 25px; position: relative;">
			<h3
				style="font-size: 22px; color: #979797; font-weight: bolder; text-align: left; height: 25px; line-height: 25px; float: right; margin: 0 100px 0 0; width: 400px; position: relative;">
				凡客 Vancl 后台 登录 <span
					style="font-size: 14px; font-weight: normal; position: absolute; right: 0px; bottom: 0px;">
				</span>
			</h3>
		</div>
		<div class="login">
			<form action="bslogin.do" method="post">
				<input type="text" name="adminName" id="userName"
					placeholder="请输入用户名" autocomplete="off" /> <input type="password"
					id="pwd" name="adminPwd" placeholder="请输入密码" autocomplete="off" />
				<p id="tip" class="tips">${login_failed}</p>
				<input type="submit" id="btn" value="登录" />
			</form>
		</div>
		<div class="show">
			<img src="${pageContext.request.contextPath }/img/login_logo.jpg" />
		</div>
	</div>
</body>

</html>
