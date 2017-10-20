<%@page import="cn.guoxy.esms.bs.entity.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>后台</title>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
<script src="${pageContext.request.contextPath }/js/bsindex.js"></script>
<script src="${pageContext.request.contextPath }/chart/tu.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">后台</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="javascript:;"
					onclick="update();">商品管理</a></li>
				<li class="layui-nav-item"><a href="javascript:;"
					onclick="admin()">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<%
				Admin admin = (Admin) request.getSession().getAttribute("admin");
			%>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <%=admin.getAdminName()%>
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="bslogout.do">退出登录</a>
						</dd>

					</dl></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">

				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">商品管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="update();">添加商品</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="kucun();">库存管理</a>
							</dd>
							<dd>
								<a href="javascript:; " onclick="order();">订单管理</a>
							</dd>
							<dd>
								<a href="javascript:;">物流管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">账号管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="user()">会员管理</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="admin()">管理员管理</a>
							</dd>
						</dl></li>

				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;" id="bodyMain">
				<!-- 内容-->

				<%@include file="chart.jsp"%>


				<!-- 内容-->
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© gxy.cn - 郭晓勇荣誉出品
		</div>
	</div>



</body>

</html>