function sub() {
	var email = $("#email").val();
	var patten = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
	if(patten.test(email)) {
		var url = "getyzm.do?email=" + email;
		$.ajax({
			type: "POST",
			url: url,
			success: function(res) {
				if(res.code == 0) {
					$("#001").addClass("green");
					$("#111").addClass("hidden");
					$("#112").removeClass("hidden");
				}else{
					alert(res.message);
				}
			}
		});
	} else {
		alert("请输入正确的邮箱");
	}

}

function sub12() {
	var yzm = $("#yzm").val();
	var pwd = $("#pwd").val();
	if(yzm == "" || yzm == null) {
		$("#yzm").addClass("error");
	} else if(pwd == "" || pwd == null) {
		$("#yzm").removeClass("error");
		$("#pwd").addClass("error");
	} else {
		$("#yzm").removeClass("error");
		$("#pwd").removeClass("error");
		var url = "updatePwd.do?yzm=" + yzm + "&pwd=" + pwd;
		$.ajax({
			type: "POST",
			url: url,
			success: function(res) {
				if(res.code == 0){
				$("#002").addClass("green");
				$("#003").addClass("green");
				$("#112").addClass("hidden");
				$("#113").removeClass("hidden");
				}else{
					alert(res.message);
				}
			}
		});
	}
}