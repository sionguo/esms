<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>库存管理</title>
<script src="${pageContext.request.contextPath }/js/admin.js"></script>
<style type="text/css">
img {
	width: 50px;
	height: 50px;
}

table {
	text-align: center;
	border-spacing: 0;
	width: 100%;
}

.head {
	background-color: #23262E;
	height: 40px;
	color: white;
}

.b1 tr:hover {
	background-color: #009688;
	height: 60px;
}

.motai {
	position: absolute;
	top: 200px;
	left: 200px;
	z-index: 20;
}

input {
	width: 400px;
	height: 40px;
	font-size: 24px;
	margin-top: 10px;
}

.hide {
	display: none;
}
</style>
</head>
<body>
	<a href='javascript:; ' class='layui-btn layui-btn-normal'
		onclick='show();'>添加管理员</a>
	<table align="center">
		<thead>
			<tr class="head">
				<th>管理员ID</th>
				<th>管理员用户名</th>
				<th>管理员密码</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="b1" id="bb1">



		</tbody>
	</table>
	<div class="motai hide" id="motai">
		<h2
			style="font-size: 36px; font-weight: 900; background: #23262E; color: white;">添加管理员</h2>
		<table style="background-color: #BDBEC1;">
			<tr>
				<td>用户名</td>
				<td><input type="text" id="adminName"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" id="adminPwd"></td>
			</tr>
			<tr>
				<td></td>
				<td><a href='javascript:; ' style="margin-top: 10px;"
					class='layui-btn layui-btn-normal' onclick='submit()'>添加管理员</a><a
					href='javascript:; ' style="margin-top: 10px;"
					class='layui-btn layui-btn-normal' onclick='fanhui()'>返回</a></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td></td>
			</tr>
		</table>
	</div>

</body>
</html>
