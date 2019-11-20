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
		url : "/system/product/save",
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
            productCode : {
				required : true
			},
            productName : {
                required : true
            },
            productModel : {
                required : true
            },
            productPrice : {
                required : true
            }
		},
		messages : {
            productCode : {
				required : icon + "请输入产品编码"
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