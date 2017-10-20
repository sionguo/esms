$(function() {
	layui.use('element', function() {
		var element = layui.element;
	});
	layui
			.use(
					'upload',
					function() {
						var upload = layui.upload;
						// 执行实例
						var uploadInst = upload
								.render({
									elem : '#test1' // 绑定元素
									,
									url : '/esms/bs/update.do' // 上传接口
									,
									titil : "请选择",
									before : function(obj) {
										// 预读本地文件示例，不支持ie8
										obj.preview(function(index, file,
												result) {
											$('#demo1').attr('src', result); // 图片链接（base64）
										});
									},
									done : function(res) {
										// 上传完毕回调
										// 如果上传失败
										if (res.code > 0) {
											return layer.msg('上传失败');
										}
										var in1 = $("<input type='hidden' name='smallImg' value='"
												+ res.smallImg
												+ "'/>"
												+ "<input type='hidden' name='bigImg' value='"
												+ res.bigImg + "'/>");
										$("#updateFrom").append(in1);
										console.log(res);
										// 上传成功
									},
									error : function() {// 请求异常回调
										var demoText = $('#demoText');
										demoText
												.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
										demoText.find('.demo-reload').on(
												'click', function() {
													uploadInst.upload();
												});
									}
								});
					});
	layui.use('form', function() {
		var form = layui.form;

		// 监听提交
		form.on('submit(formDemo)', function(data) {
			$.ajax({
				type : "POST",
				url : "/esms/bs/formupdate.do",
				data : data.field,
				success : function(msg) {
					layer.msg(msg);
					form.render();
					update();
				}
			});
			return false;
		});

		// 监听下拉
		form.on('select(bigType)', function(data) {
			var btId = data.value;
			var pramas = "btId=" + btId;
			$.ajax({
				url : "/esms/bs/getType.do",
				data : pramas,
				success : function(date) {
					$("#smallType").empty();
					$("#smallType").append("<option value=''></option>");
					form.render('select');
					for (var i = 0; i < date.length; i++) {
						var option = $("<option value='" + date[i].stId + "'>"
								+ date[i].stName + "</option>");
						$("#smallType").append(option);
						form.render();
					}
				}
			});
		});
	});

});