$(function() {
	$.getJSON("getForm.do", function(json) {
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
		var tr = $("<tr><td>" + json[i].goodsId + "</td><td>"
				+ json[i].orderNumber
				+ "</td><td><img src='/img/"
				+ json[i].smallImg + "' /></td><td>" + json[i].goodsShow
				+ "</td><td>" + sta + "</td><td>" + money + "</td><td>"
				+ json[i].createTime + "</td></tr>");
		console.log(tr);
		$("#b1").append(tr);
	}

}