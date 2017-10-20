$(function() {

});
function putin() {
	var goodsId = $("#goodsId").html();
	var count = $("#count").val();
	var data = {
		"goodsId" : goodsId,
		"count" : count
	};
	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		complete : function(XMLHttpRequest, textStatus) {
			// 通过XMLHttpRequest取得响应头，sessionstatus
			var sessionstatus = XMLHttpRequest
					.getResponseHeader("sessionstatus");
			if (sessionstatus == "timeout") {
				// 这里怎么处理在你，这里跳转的登录页面
				layer.alert('请登录', {
					icon : 5
				});
				window.location.replace(XMLHttpRequest
						.getResponseHeader("redirectUrl"));
			}
		}
	});

	$.ajax({
		url : "putingwc.do",
		beforeSend : function(request) {
			request.setRequestHeader("ajax", "ajax");
		},
		data : data,
		success : function(res) {
			if (res.code == 0) {
				layer.alert('加入购物车成功', {
					icon : 6
				});
			}
		}
	});
}

function buy() {
	var goodsId = $("#goodsId").html();
	var count = $("#count").val();
	var data = {
		"goodsId" : goodsId,
		"count" : count
	};
	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		complete : function(XMLHttpRequest, textStatus) {
			// 通过XMLHttpRequest取得响应头，sessionstatus
			var sessionstatus = XMLHttpRequest
					.getResponseHeader("sessionstatus");
			if (sessionstatus == "timeout") {
				// 这里怎么处理在你，这里跳转的登录页面
				layer.alert('请登录', {
					icon : 5
				});
				window.location.replace(XMLHttpRequest
						.getResponseHeader("redirectUrl"));
			}
		}
	});

	$.ajax({
		url : "putinorder.do",
		beforeSend : function(request) {
			request.setRequestHeader("ajax", "ajax");
		},
		data : data,
		success : function(res) {
			if (res.code == 0) {
				layer.alert(res.message, {
					icon : 6
				});
			}
		}
	});
}
