$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/system/procedure/update",
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
            proCode: {
                required: true,
                remote: {
                    url: "/system/procedure/validateByCard",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        proCode: function () {
                            return $("#proCode").val()
                        }
                    }
                }
            },
            proName: {
                required: true
            },
            proPrice: {
                required: true
            }
        },

        messages : {
            proCode : {
                required : icon + "请输入工序编码",
                remote:icon+"工序编码已存在"
            },
            proName : {
                required : icon + "请输入工序名称"
            },
            proPrice : {
                required : icon + "请输入工序计件单价"
            }

        }
    })
}