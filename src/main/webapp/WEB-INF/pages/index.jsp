<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>凡客网</title>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css">
<link href="layui/css/layer.css">
</head>

<body>
	<%@include file="head.jsp"%>
	<div id="neirong">
		<!-- 轮播图开始 -->

		<%@include file="banner.jsp"%>
		<!-- 轮播图结束 -->

		<!-- 春季新品文字开始 -->
		<div class="chunji">
			<div class="chunji1">新品预售</div>
		</div>
		<!-- 春季文字结束 -->
		<!-- 春季新品开始 -->

		<div class="yifu" id="yifu"></div>
		<!-- 春季新品结束 -->

		<!-- 春季新品文字开始 -->
		<div class="chunji">
			<div class="chunji1">热卖</div>
		</div>
		<!-- 春季文字结束 -->
		<!-- 春季新品开始 -->

		<div class="yifu" id="yifu12"></div>
		<!-- 春季新品结束 -->
		<!-- 韩国购开始 -->

		<!-- 韩国购结束 -->
	</div>

	<%@include file="foot.jsp"%>
</body>

</html>