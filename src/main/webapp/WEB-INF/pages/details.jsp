<%@page import="cn.guoxy.esms.commons.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Goods goods = (Goods) request.getAttribute("goods");
%>
<!DOCTYPE html>
<html lang="zh">
<head>
<script src="js/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="css/details.css">
<script src="js/details.js"></script>
<script src="js/layer.js"></script>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title><%=goods.getGoodsName()%></title>
</head>
<body>
	<%@include file="head.jsp"%>
	<div class="main" id="neirong">
		<div class="top_name">
			<h2>
				<%=goods.getGoodsName() + "\t" + goods.getGoodsShow()%>
			</h2>
		</div>
		<div class="left_img">
			<img src="/img/<%=goods.getSmallImg()%>">
		</div>
		<div class="right_info">
			<h2><%=goods.getGoodsName()%></h2>
			<div class="infoo">
				<h3>售价:￥</h3>
				<h2><%=goods.getGoodsPrice()%></h2>
				<div class="num">
					<h3>数量：</h3>
					<select id="count">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
				<div class="btn_ny">
					<div style="display: none;" id="goodsId"><%=goods.getGoodsId()%></div>
					<div class="bt" onclick="putin()">加入购物车</div>
					<div class="bt" onclick="buy()">立即购买</div>
				</div>
			</div>

		</div>
	</div>
	<%@include file="foot.jsp"%>
</body>
</html>