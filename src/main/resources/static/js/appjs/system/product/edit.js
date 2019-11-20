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
		url : "/system/product/update",
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
            productCode: {
                required: true,
                remote: {
                    url: "/system/product/validateByCard",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        productCode: function () {
                            return $("#productCode").val()
                        }
                    }
                }
            },
            productName: {
                required: true
            },
            productModel: {
                required: true
            },
            productPrice: {
                required: true
            }
        },

        messages : {
            productCode : {
                required : icon + "请输入产品编码",
                remote:icon+"产品编码已存在"
            },
            productName : {
                required : icon + "请输入产品名称"
            },
            productModel : {
                required : icon + "请输入规格型号"
            },
            productPrice : {
                required : icon + "请输入产品计件单价"
            }

        }
    })
}