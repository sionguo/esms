<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/update.js"></script>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<title></title>
</head>

<body>

	<form class="layui-form" id="updateFrom" action="">
		<input type="hidden" name="token"
			value="<%=session.getAttribute("token")%>">
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称</label>
			<div class="layui-input-block">
				<input type="text" name="goodsName" required lay-verify="required"
					placeholder="商品名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品描述</label>
			<div class="layui-input-block">
				<input type="text" name="goodsShow" required lay-verify="required"
					placeholder="商品描述" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品图片</label>
			<div class="layui-input-block">
				<button type="button" class="layui-btn" id="test1">上传图片</button>
				<div class="layui-upload-list">
					<img class="layui-upload-img" id="demo1">
					<p id="demoText"></p>
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">商品类别</label>
			<div class="layui-input-block">
				<select name="bigType" id="bigType" lay-filter="bigType"
					lay-verify="required">
					<option value="-1"></option>
					<option value="0">男装</option>
					<option value="1">女装</option>
					<option value="2">男鞋</option>
					<option value="3">女鞋</option>
					<option value="4">袜品</option>
					<option value="5">家居</option>
					<option value="6">童装</option>
					<option value="7">内衣</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<select name="smallType" id="smallType" lay-verify="required">
					<option value=""></option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">适用季节</label>
			<div class="layui-input-block">
				<input type="radio" name="season" value="1" title="春"> <input
					type="radio" name="season" value="2" title="夏"> <input
					type="radio" name="season" value="3" title="秋"> <input
					type="radio" name="season" value="4" title="冬">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品价格</label>
			<div class="layui-input-block">
				<input type="text" name="goodsPrice" required
					lay-verify="required|number" placeholder="商品价格" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品总量</label>
			<div class="layui-input-block">
				<input type="text" name="goodsCount" required
					lay-verify="required|number" placeholder="商品总量" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>

</html>