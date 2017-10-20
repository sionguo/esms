<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>订单</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/fsOrder.js"></script>
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
	<div style="width: 1200px; margin: 0 auto;">
		<table align="center">
			<thead>
				<tr class="head">
					<th>商品ID</th>
					<th>订单号</th>
					<th>图片</th>
					<th>描述</th>
					<th>状态</th>
					<th>金额</th>
					<th>下单时间</th>
				</tr>
			</thead>
			<tbody class="b1" id="b1">


			</tbody>
		</table>
	</div>

	<%@include file="foot.jsp"%>

</body>
</html>
