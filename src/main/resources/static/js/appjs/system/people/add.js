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
		url : "/system/people/save",
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
        rules: {
            peopleCode: {
                required: true,
                remote: {
                    url: "/system/people/validateByCard",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        peopleCode: function () {
                            return $("#peopleCode").val()
                        }
                    }
                }
        },
        peopleName: {
            required: true,
            remote: {
                url: "/system/people/validateByCard",     //后台处理程序
                type: "post",               //数据发送方式
                dataType: "json",           //接受数据格式
                data: {                     //要传递的数据
                    peopleName: function () {
                        return $("#peopleName").val()
                    }
                }
            }
        }
    },

        messages : {
            peopleCode : {
                required : icon + "请输入人员编号",
                remote:icon+"人员编号已存在"
            },
            peopleName : {
                required : icon + "请输入人员姓名",
                remote:icon+"人员姓名已存在"

            }

        }
    })
}