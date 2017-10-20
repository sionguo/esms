<%@page import="cn.guoxy.esms.fs.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet" type="text/css" href="css/regist.css" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
<title>注册</title>
</head>

<body>
	<div class="head">
		<a href="toindex.do"><img src="img/logo18546.png" /></a>
		<p>
			<a href="#" style="color: #000000;">帮助</a>
		</p>
	</div>
	<div class="body">
		<div style="width: 100%; height: 25px; position: relative;">
			<h3
				style="font-size: 22px; color: #979797; font-weight: bolder; text-align: left; height: 25px; line-height: 25px; float: right; margin: 0 100px 0 0; width: 400px; position: relative;">
				凡客 Vancl 注册 <span
					style="font-size: 14px; font-weight: normal; position: absolute; right: 0px; bottom: 0px;">我已经注册,现在就
					<a id="gotoReg" href="tologin.do"
					style="color: #b42025; margin: 0px;"> 登录 </a>
				</span>
			</h3>
		</div>
		<%
			User user = (User) request.getAttribute("now");
		%>
		<div class="regist">
			<%
				String btn = "btn1";
				String aa = "hidden";
				String str = "";
				String name = "";
				String pwd = "";
				String email = "";
				String url = "";
				if (user != null) {
					str = "hidden";
					aa = "";
					name = user.getUserName();
					pwd = user.getPwd();
					email = user.getEmail();
					btn = "btn";
					url = "regist.do";
				}
			%>
			<form action="<%=url%>" method="post">

				<div class=<%=str%>>
					<input type="text" name="code" id="code" placeholder="请输入验证码"
						autocomplete="off" value='<%=name%>' />
					<div class="codeimg">
						<img id="num" src="code.do"
							onclick="document.getElementById('num').src='code.do?'+(new Date()).getTime()" />
					</div>
					<p id="codeError" class="tips hidden"></p>
				</div>


				<input type="text" name="userName" id="userName"
					placeholder="请输入用户名" autocomplete="off" value='<%=name%>' /> <input
					type="text" id="email" name="email" placeholder="请输入邮箱"
					autocomplete="off" value='<%=email%>'>

				<div class=<%=aa%>>

					<input type="password" id="pwd" name="pwd" placeholder="设定登录密码"
						autocomplete="off" value='<%=pwd%>' />

				</div>

				<p class="tips" id="error"></p>
				<input type="submit" id="<%=btn%>" value="立即注册" />
			</form>
		</div>
		<div class="show">
			<img src="img/login_logo.jpg" />
		</div>
	</div>
</body>

</html>