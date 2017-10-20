$(function() {
	var layer;
	layui.use('layer', function() {
		layer = layui.layer;

	});
	$.getJSON("getgwc.do", function(json) {
		console.log(json);
		put12(json);
	});

});
function put12(json) {
	for (var i = 0; i < json.length; i++) {
		var sta;
		var money = json[i].count * json[i].goodsPrice;
		if (json[i].status == 0)
			sta = "已支付";
		if (json[i].status == 1)
			sta = "已发货";
		if (json[i].status == 2)
			sta = "已收货";
		if (json[i].status == 3)
			sta = "已完成";
		json[i].goodsName
		var tr = $("<tr><td>"
				+ json[i].goodsName
				+ "</td><td>"
				+ json[i].goodsId
				+ "</td><td><img src='/img/"
				+ json[i].smallImg
				+ "' /></td><td>"
				+ json[i].count
				+ "</td><td>"
				+ money
				+ "</td><td><a href='javascript:; ' class='layui-btn layui-btn-danger' onclick='buy("
				+ json[i].count
				+ ","
				+ json[i].goodsId
				+ ","
				+ json[i].gwcId
				+ ")'>购买</a><a href='javascript:; ' class='layui-btn layui-btn-danger' onclick='del("
				+ json[i].gwcId + ")'>删除</a></td></tr>");
		console.log(tr);
		$("#b1").append(tr);
	}

}
function buy(count, id, gwcId) {
	$.ajax({
		url : "putinorder1.do?goodsId=" + id + "&count=" + count + "&gwcId="
				+ gwcId,
		success : function(res) {
			layer.alert(res.message, {
				icon : 6
			});
			location.reload();
		}
	});
}
function del(data) {
	$.ajax({
		url : "delgwc.do?gwcId=" + data,
		success : function(res) {
			layer.alert(res.message, {
				icon : 6
			});
			location.reload();
		}
	});
}
