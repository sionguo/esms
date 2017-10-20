<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>饼图</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath }/dist/Chart.bundle.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/chart/utils.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/chart/tu.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/chart/tu.css" />
<style type="text/css">
.hide {
	display: none;
}
</style>
</head>

<body>
	<div style="margin: 0 auto; width: 800px;">
		<div id="canvas-holder" style="width: 300px; float: left;">
			<canvas id="chart-area" width="300" height="300"></canvas>
			<div id="chartjs-tooltip">
				<table></table>
			</div>
		</div>

		<div id="canvas-holder" style="width: 300px; float: left;">
			<canvas id="chart-area1" width="300" height="300"></canvas>
			<div id="chartjs-tooltip">
				<table></table>
			</div>
		</div>
	</div>
	<div
		style="position: absolute; z-index: 22; left: 200px; top: 200px; border: 2px solid; border-radius: 15px; font-size: 30px; color: white; background: red;"
		class="" id="msgmsg">页面数据生成中......</div>
</body>

</html>