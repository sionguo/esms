$(function() {
	var layer;
	layui.use('layer', function(res1) {
		layer = layui.layer;
	});
	layui.use('element', function() {
		var element = layui.element;
	});

	$.getJSON("getorderfrom.do", function(json) {
		put(json);
	});

});
function put(json) {
	for (var i = 0; i < json.length; i++) {
		var sta;

		if (json[i].status == 0)
			sta = "已支付";
		if (json[i].status == 1)
			sta = "已发货";
		if (json[i].status == 2)
			sta = "已收货";
		if (json[i].status == 3)
			sta = "已完成";
		var tr = $("<tr><td >"
				+ json[i].orderNumber
				+ "</td><td >"
				+ json[i].goodsName
				+ "</td><td ><img src='/img/"
				+ json[i].smallImg
				+ " 'width='50px ' height='50px ' /></td><td >"
				+ json[i].goodsPrice
				+ "</td><td >"
				+ json[i].count
				+ "</td><td >"
				+ json[i].userId
				+ "</td><td >"
				+ json[i].goodsPrice
				* json[i].count
				+ "</td>"
				+ "<td >"
				+ sta
				+ "</td><td >"
				+ "<a href='javascript:; ' class='layui-btn layui-btn-normal' onclick='rep("
				+ json[i].orderId + ");'>修改订单状态</a></td></tr>");
		$("#tbody").append(tr);
	}
}
function rep(orderId) {
	var newstatus;
	layer.open({
		content : '请更改状态',
		anim : 4,
		btn : [ '已支付', '已发货', '已收货', '已完成' ],
		btn1 : function(index, layero) {
			newstatus = 0;
			var url = "ree.do?orderId=" + orderId + "&status=" + newstatus
			$.ajax({
				url : url,
				success : function(res) {
					layer.msg(res.message);
					order();
				}
			});
		},
		btn2 : function(index, layero) {
			newstatus = 1;
			var url = "ree.do?orderId=" + orderId + "&status=" + newstatus
			$.ajax({
				url : url,
				success : function(res) {
					layer.msg(res.message);
					order();
				}
			});
		},
		btn3 : function(index, layero) {
			newstatus = 2;
			var url = "ree.do?orderId=" + orderId + "&status=" + newstatus
			$.ajax({
				url : url,
				success : function(res) {
					layer.msg(res.message);
					order();
				}
			});
		},
		btn4 : function(index, layero) {
			newstatus = 3;
			var url = "ree.do?orderId=" + orderId + "&status=" + newstatus
			$.ajax({
				url : url,
				success : function(res) {
					layer.msg(res.message);
					order();
				}
			});
		},
		cancel : function() {
			layer.msg("您已退出修改");
			order();
		}
	});

}
