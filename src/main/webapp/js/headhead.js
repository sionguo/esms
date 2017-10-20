function searchGoods() {
	var sad = $("#suosuokuang").val();
	if (sad != null || sad != "") {
		$
				.getJSON(
						"search.do?keyword=" + sad,
						function(json) {
							console.log(json);
							$("#neirong").empty();
							var yifu = $("<div class='yifu' id='yifu'></div>");
							$("#neirong").append(yifu);
							for (var i = 0; i < json.length; i++) {
								var a = $("<a href='details.do?goodsId="
										+ json[i].goodsId
										+ "' class='yifu1'> <img src='/img/"
										+ json[i].bigImg
										+ "' class='tu1'> </a> ");
								$("#yifu").append(a);
							}
						});
	}
}
function f0() {
	searchGoods123('家具配饰');
}
function f2() {
	searchGoods123('衬衫');
}
function f3() {
	searchGoods123('羽绒服');
}
function f4() {
	searchGoods123('外套');
}
function f5() {
	searchGoods123('针织');
}
function f6() {
	searchGoods123('水柔绵');
}
function f7() {
	searchGoods123('裤');
}
function f8() {
	searchGoods123('鞋');
}
function f9() {
	searchGoods123('袜品');
}

function searchGoods123(data) {

	$.getJSON("search.do?keyword=" + data, function(json) {
		console.log(json);
		$("#neirong").empty();
		var yifu = $("<div class='yifu' id='yifu'></div>");
		$("#neirong").append(yifu);
		for (var i = 0; i < json.length; i++) {
			var a = $("<a href='details.do?goodsId=" + json[i].goodsId
					+ "' class='yifu1'> <img src='/img/"
					+ json[i].bigImg + "' class='tu1'> </a> ");
			$("#yifu").append(a);
		}
	});

}