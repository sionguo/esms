<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/find.css" />
<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/find.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
	<div class="head">
		<a href="index.html"><img src="img/logo18546.png" /></a>
		<p>
			<a href="#" style="color: #000000;">帮助</a>
		</p>
	</div>
	<div class="body">
		<div style="width: 100%; height: 25px; margin: 0 auto;">
			<h3
				style="font-size: 22px; color: #979797; font-weight: bolder; text-align: left; height: 25px; line-height: 25px; float: left; margin: 0 auto; width: 400px; margin-top: 30px; margin-left: 100px;">
				凡客 Vancl 找回密码</h3>
		</div>
		<div
			style="width: 1000px; height: 30px; border-top: 2px dotted saddlebrown; margin: 0 auto; margin-top: 80px;">
			<div
				style="box-sizing: border-box; margin: 0 auto; margin-top: 10px; width: 430px;">
				<div class="oo" id="001"></div>
				<div class="ss">验证邮箱</div>
				<div class="oo" id="002"></div>
				<div class="ss">更改密码</div>
				<div class="oo" id="003"></div>
				<div class="ss">更改完成</div>
			</div>
		</div>

	</div>
	<div class="bo" id="111">

		<input type="text" id="email" placeholder="请输入邮箱" autocomplete="off" />
		<input type="button" class="submit" id="submit" value="确定"
			onclick="sub();" />

	</div>
	<div class="bo hidden" id="112">
		<input type="text" id="yzm" placeholder="请输入验证码" autocomplete="off" />
		<input type="password" id="pwd" placeholder="请输入密码" autocomplete="off" />
		<input type="button" class="submit" id="submit" value="确定"
			onclick="sub12();" />

	</div>
	<div class="bo hidden" id="113">

		<a href="tologin.do"
			style="display: block; height: 30px; line-height: 30px; width: 300px; background: #a10000; font-size: 24px; font-weight: 900; color: white;">去登陆>>>></a>

	</div>
</body>

</html>