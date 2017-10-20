layui.use('element', function() {
	var element = layui.element;
});
function update() {
	clearInterval(window.timeid);
	$("#bodyMain").load(
			"/esms/bs/toUpdate.do?timestamp=" + new Date().getTime());
}
function order() {
	clearInterval(window.timeid);
	$("#bodyMain").load(
			"/esms/bs/toOrderForm.do?timestamp=" + new Date().getTime());
}
function kucun() {
	clearInterval(window.timeid);
	$("#bodyMain")
			.load("/esms/bs/toKuCun.do?timestamp=" + new Date().getTime());
}
function admin() {
	clearInterval(window.timeid);
	$("#bodyMain")
			.load("/esms/bs/toAdmin.do?timestamp=" + new Date().getTime());
}
function user() {
	clearInterval(window.timeid);
	$("#bodyMain").load("/esms/bs/toUser.do?timestamp=" + new Date().getTime());
}
