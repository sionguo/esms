$(function() {
	var layer;
	layui.use('layer', function(res1) {
		layer = layui.layer;
	});
	layui.use('element', function() {
		var element = layui.element;
	});

	$.getJSON("getuser.do", function(json) {
		putuser(json);
	});

});
function putuser(json) {
	for (var i = 0; i < json.length; i++) {
		var tr = $("<tr><td>" + json[i].id + "</td><td>" + json[i].userName
				+ "</td><td>" + json[i].email + "</td><td>" + json[i].userPwd
				+ "</td><td>" + json[i].vip + "</td></tr>");
		$("#b1b").append(tr);
	}
}