<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>库存管理</title>
<script src="${pageContext.request.contextPath }/js/user.js"></script>
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
</style>
</head>
<body>
	<table align="center">
		<thead>
			<tr class="head">
				<th>用户ID</th>
				<th>用户名</th>
				<th>邮箱</th>
				<th>用户密码</th>
				<th>用户等级</th>
			</tr>
		</thead>
		<tbody class="b1" id="b1b">
			


		</tbody>
	</table>
</body>
</html>
