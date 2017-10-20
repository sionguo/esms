$(function() {
	display1();
	display();
});
function display() {
	var month = new Date().getMonth();
	var season;
	switch (month) {
	case 1:
	case 2:
	case 3:
		season = 1;
		break;
	case 4:
	case 5:
	case 6:
		season = 2;
		break;
	case 7:
	case 8:
	case 9:
		season = 3;
		break;
	case 10:
	case 11:
	case 12:
		season = 3;
		break;
	}
	var data = {
		"season" : season
	};
	$.getJSON("getNewGoods.do", data, function(json) {
		$("#yifu").empty();
		for (var i = 0; i < json.length; i++) {
			var a = $("<a href='details.do?goodsId=" + json[i].goodsId
					+ "' class='yifu1'> <img src='/img/"
					+ json[i].bigImg + "' class='tu1'> </a> ");
			$("#yifu").append(a);
		}
	});
}
function display1() {
	$.getJSON("getHotGoods.do", function(json) {
		console.log(json);
		$("#yifu12").empty();
		for (var i = 0; i < json.length; i++) {
			var a = $("<a href='details.do?goodsId=" + json[i].goodsId
					+ "' class='yifu1'> <img src='/img/"
					+ json[i].bigImg + "' class='tu1'> </a> ");
			$("#yifu12").append(a);
		}
	});
}