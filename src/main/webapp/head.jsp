<%@page import="cn.guoxy.esms.fs.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/headhead.js"></script>
</head>
<body>
	<!-- 头部开始 -->
	<div class="head" id="head">
		<div class="headmain">
			<div class="right">
				<%
					String str1 = "";
					String str2 = "";
					User user = (User) session.getAttribute("user");
					if (user != null) {
						str1 = "hide";
						str2 = user.getUserName();
					}
				%>
				<div class="right1">
					您好<%=str2%>，欢迎光临凡客诚品!
				</div>
				<div class="right2">
					<a href="tologin.do" class="login <%=str1%>">登录</a> <span
						class="shu <%=str1%>">丨</span> <a href="toregist.do"
						class="reg <%=str1%>">注册</a>
				</div>
				<div class="ding">
					<a href="toorderForm.do" class="dingdan">我的订单</a>
				</div>
				<div class="web">
					<a href="" class="yin"> <!-- <img src="img/notice.png" alt="" class="img5"> -->
					</a> <a href="" class="gonggao">网站公告</a> <a href="" class="weixin">
					</a> <a href="" class="weixin1"> </a>
				</div>
			</div>
		</div>
	</div>
	<!-- 头部结束 -->
	<!-- 导航栏开始 -->
	<div class="nav">
		<div class="nav-right">
			<div class="search">
				<input type="text" class="sou" id="suosuokuang"
					placeholder="&nbsp搜“衬衫”，体验与众不同"> <a href="javascript:;"
					class="van" onclick="searchGoods();"> </a>
			</div>
			<div class="gouwu">
				<a href="togwc.do" class="car"> <!-- <img src="img/van.png" alt="" class="che"> -->
				</a>
			</div>
		</div>
	</div>
	<div class="sosuo">
		<div class="so-right"></div>
	</div>
	<!-- 导航栏结束 -->

	<!-- 选购栏开始 -->
	<div class="xuangou">
		<div class="xuan-left">
			<!-- <img src="img/logo18546.png" alt=""> -->
		</div>
		<ul class="nav2">
			<li><a href="toindex.do" >首页</a></li>
			<li><a href="javascript:;" onclick="f2()">衬衫</a></li>
			<li><a href="javascript:;" onclick="f3()">羽绒服</a></li>
			<li><a href="javascript:;" onclick="f4()">外套</a></li>
			<li><a href="javascript:;" onclick="f5()">针织衫</a></li>
			<li><a href="javascript:;" onclick="f6()">水柔绵</a></li>
			<li><a href="javascript:;" onclick="f7()">裤装</a></li>
			<li><a href="javascript:;" onclick="f8()">鞋</a></li>
			<li><a href="javascript:;" onclick="f9()">袜品</a></li>
			<li id="jiaju"><a href="javascript:;" onclick="f0()">家具配饰</a></li>
		</ul>
	</div>
	<!-- 选购结束 -->
</body>
</html>