$(function() {
	var layer;
	layui.use('layer', function(res1) {
		layer = layui.layer;
	});
	layui.use('element', function() {
		var element = layui.element;
	});

	$.getJSON("getkucun.do", function(json) {
		console.log(json);
		putin(json);
	});

});
function putin(json) {
	for (var i = 0; i < json.length; i++) {
		var tr = $("<tr><td>"
				+ json[i].goodsId
				+ "</td><td>"
				+ json[i].goodsName
				+ "</td><td>"
				+ json[i].goodsShow
				+ "</td><td>"
				+ json[i].goodsCount
				+ "</td><td><img src='/img/"
				+ json[i].smallImg
				+ "' /></td><td><a href='javascript:; ' class='layui-btn layui-btn-normal' onclick='changeoo("
				+ json[i].goodsId
				+ ");'>更改商品数量</a><a href='javascript:; ' class='layui-btn layui-btn-normal' onclick='deoo("
				+ json[i].goodsId + ");'>删除</a></td></tr>");
		$("#b1").append(tr);

	}

}
function changeoo(data) {
	var reg = new RegExp("^[0-9]*$");
	layer.prompt(function(val, index) {
		var s = reg.test(val);
		if (s) {
			$.ajax({
				url : "updateGoodsCount.do?goodsId=" + data + "&count=" + val,
				success : function(res) {
					layer.msg(res.message);
				}
			});
		} else {
			layer.msg("请输入数字");
		}
		layer.close(index);
		kucun();
	});
}
function deoo(data) {
	$.ajax({
		url : "deleteGoods.do?goodsId=" + data,
		success : function(res) {
			layer.msg(res.message);
		}
	});
	kucun();
}