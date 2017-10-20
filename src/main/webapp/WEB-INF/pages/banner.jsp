<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Document</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<script src="js/jquery-1.11.1.js"></script>
<script src="./layui/layui.js"></script>
</head>

<body>
	<div class="layui-carousel" id="test1" id="neirong">
		<div carousel-item="">
			<div>
				<img alt="" src="img/ys535.jpg">
			</div>
			<div>
				<img alt="" src="img/ys535.jpg">
			</div>
			<div>
				<img alt="" src="img/ys535.jpg">
			</div>
			<div>
				<img alt="" src="img/ys535.jpg">
			</div>
			<div>
				<img alt="" src="img/ys535.jpg">
			</div>
		</div>
	</div>
	<script src="layui/layui.js"></script>
	<script>
		layui.use('carousel', function() {
			var carousel = layui.carousel;
			//建造实例
			carousel.render({
				elem : '#test1',
				width : '100%' //设置容器宽度
				,
				height:'534px'
				,
				arrow : 'always' //始终显示箭头
			//,anim: 'updown' //切换动画方式
			});
		});
	</script>
</body>

</html>