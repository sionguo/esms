function submit() {
	var adminName = $("#adminName").val();
	var adminPwd = $("#adminPwd").val();
	var data = "?adminName=" + adminName + "&adminPwd=" + adminPwd;

	$.ajax({
		url : "updateadmin.do" + data,
		success : function(res) {
			layer.msg(res.message);
			admin();
		}
	});
	$("#motai").addClass("hide");
}
function show() {
	$("#motai").removeClass("hide");
}
$(function() {
	var layer;
	layui.use('layer', function(res1) {
		layer = layui.layer;
	});
	layui.use('element', function() {
		var element = layui.element;
	});

	$.getJSON("getadmin.do", function(json) {
		putadmin(json);
	});

});
function putadmin(json) {
	for (var i = 0; i < json.length; i++) {
		var tr = $("<tr style='height:50px;'><td>"
				+ json[i].adminId
				+ "</td><td>"
				+ json[i].adminName
				+ "</td><td>"
				+ json[i].adminPwd
				+ "</td><td><a href='javascript:; ' class='layui-btn layui-btn-normal' onclick='deadmin("
				+ json[i].adminId + ");'>删除</a></td></tr>");
		$("#bb1").append(tr);
	}
}
function deadmin(data) {
	$.ajax({
		url : "deleteadmin.do?adminId=" + data,
		success : function(res) {
			layer.msg(res.message);
			admin();
		}
	});
}
function fanhui(){
	$("#motai").addClass("hide");
	$("#adminName").val("");
	$("#adminPwd").val("")
}