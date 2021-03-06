$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/system/user/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            username : {
                required : true,
                remote:{
                    url: "/system/user/validateByCard",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        username: function() {
                            return $("#username").val();
                        }
                    }
                }
            },

            password : {
                required : true,
                minlength: 5
            }
        },

        messages : {
            username : {
                required : icon + "请输入您的用户名",
                remote:    icon + "此用户已经存在"

            },
            password:{
                required: icon +"请输入密码",
                minlength: icon +"密码长度不能小于 5 个字母"
            }

        }
    })
}