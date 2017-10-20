<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
<script src="${pageContext.request.contextPath }/js/orderForm.js"></script>
<body>
	<table align="center" cellspacing="2" width="100%"
		style="text-align: center;">
		<tr class="head">
			<th>订单编号</th>
			<th>商品名称</th>
			<th>商品图片</th>
			<th>商品单价</th>
			<th>商品数量</th>
			<th>用户ID</th>
			<th>总金额</th>
			<th>订单状态</th>
			<th>操作</th>
		</tr>
		<tbody class="b1" id="tbody">

		</tbody>
	</table>
</body>
</html>
