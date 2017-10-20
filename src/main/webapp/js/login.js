$(function() {

	//验证密码是否为空
	$("#btn").click(function(){
		if($("#userName").val() == "") {
			$("#tip").html("请输入用户名");
			return false;
		}else{
			if($("#pwd").val() == ""){
				$("#tip").html("请输入密码");
				return false;
			}else{
				$("tip").html("");
				
				return true;
			}
		}
	});

});