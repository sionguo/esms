<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="layui/css/layui.css">
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/gwc.js"></script>
<style type="text/css">
img {
	width: 50px;
	height: 50px;
}

table {
	width: 1200px;
	text-align: center;
	border-spacing: 0;
}

.head {
	background-color: #a10000;
	height: 40px;
	color: black;
}

.b1 tr:hover {
	background-color: #FA7178;
}
</style>
</head>
<body>
	<%@include file="head.jsp"%>

	<div style="width: 1200px; margin: 0 auto;" id="neirong">
		<table align="center">
			<thead>
				<tr class="head">

					<th>商品名</th>
					<th>商品ID</th>
					<th>图片</th>
					<th>数量</th>
					<th>金额</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="b1" id="b1">




			</tbody>
		</table>
	</div>

	<%@include file="foot.jsp"%>
</body>
</html>
