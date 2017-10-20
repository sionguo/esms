$(function() {

	$("#code")
			.blur(
					function() {
						if ($("#code").val() == "") {
							$("#codeError").html("请输入验证码")
									.removeClass("hidden");
						} else {
							$("#codeError").addClass("hidden");
							var xhr = getAjax();
							xhr.open("GET", "ckcode.do?code="
									+ $("#code").val(), true);
							xhr.onreadystatechange = function() {
								if (xhr.readyState == 4 && xhr.status == 200) {
									$("#codeError").html(xhr.responseText)
											.removeClass("hidden");
								}
							}
							xhr.send();
						}
					});
	$("#btn").click(function() {
		var preg = /^[a-z0-9_-]{6,18}$/;
		var reg = /^[a-z0-9_-]{3,16}$/;
		if ($("#code").val() == "") {
			$("#codeError").html("请输入验证码").removeClass("hidden");
		} else if ($("#codeError").html() == "验证码错误") {
			return false;
		} else if ($("#userName").val() == "") {
			$("#error").html("请输入用户名").addClass("error");
			return false;
		} else if ($("#email").val() == "") {
			$("#error").html("请输入邮箱").addClass("error");
			return false;
		} else if ($("#pwd").val() == "") {
			$("#error").html("请输入密码").addClass("error");
			return false;
		} else {
			$("#error").html("").removeClass("error");
			return true;
		}
	});
	$("#btn1").click(function() {
		var preg = /^[a-z0-9_-]{6,18}$/;
		var reg = /^[a-z0-9_-]{3,16}$/;
		if ($("#code").val() == "") {
			$("#codeError").html("请输入验证码").removeClass("hidden");
		} else if ($("#codeError").html() == "验证码错误") {
			return false;
		} else if ($("#userName").val() == "") {
			$("#error").html("请输入用户名").addClass("error");
			return false;
		} else if ($("#email").val() == "") {
			$("#error").html("请输入邮箱").addClass("error");
			return false;
		} else {
			$("#error").html("").removeClass("error");
			alert("请用当前浏览器打开邮箱");
			location.reload();
			return false;
		}
	});

	$("#pwd").blur(function() {
		var reg = /^[a-z0-9_-]{6,18}$/;
		if ($("#pwd").val() == "") {
			$("#error").html("请输入密码").addClass("error");
			return false;
		} else if (!reg.test($("#pwd").val())) {
			$("#error").html("请输入6-18位数字、字母、下划线组成的密码").addClass("error");
			return false;
		} else {
			$("#error").html("").removeClass("error");
		}
	});

	$("#userName").blur(

			function() {
				var reg = /^[a-z0-9_-]{3,16}$/;
				if ($("#userName").val() == "") {
					$("#error").html("请输入用户名").addClass("error");
					return;
				} else if (!reg.test($("#userName").val())) {
					$("#error").html("请输入3-16位数字、字母、下划线组成的用户名").addClass(
							"error");
					return;
				} else {
					$("#error").html("").removeClass("error");
					var xhr = getAjax();
					xhr.open("GET", "ckUserName.do?userName="
							+ $("#userName").val(), true);
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							$("#error").html(xhr.responseText)
									.addClass("error");
						}
					}
					xhr.send();
				}
			});

	$("#email")
			.blur(

					function() {
						var reg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
						if ($("#email").val() == "") {
							$("#error").html("请输入邮箱").addClass("error");
							return;
						} else if (!reg.test($("#email").val())) {
							$("#error").html("请输入正确邮箱").addClass("error");
							return;
						} else {
							$("#error").html("").removeClass("error");
							var url = "ckEmail.do?email=" + $("#email").val()
									+ "&userName=" + $("#userName").val()
									+ "&pwd=" + $("#pwd").val();

							$.ajax({
								type : "POST",
								url : url,
								success : function(res) {
									if(res.code == 1){
										alert(res.message);
									}
								}
							});
						}
					});

});