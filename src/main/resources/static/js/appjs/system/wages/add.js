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
		url : "/system/wages/save",
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
            billCode: {
                required: true,
                remote: {
                    url: "/system/wages/validateByCard",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        billCode: function () {
                            return $("#billCode").val()
                        }
                    }
                }
            },

            proCode: {
                required: true,
                remote: {
                    url: "/system/wages/validateByCard",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        proCode: function () {
                            return $("#proCode").val()
                        }
                    }
                }
            },
            productCode: {
                required: true,
                remote: {
                    url: "/system/wages/validateByCard",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式
                    data: {                     //要传递的数据
                        productCode: function () {
                            return $("#productCode").val()
                        }
                    }
                }
            },
            dateMark: {
                required: true
            },
            name: {
                required: true
            },

            harvest: {
                required: true
            },

            peopleCode: {
                required: true
            }
        },


        messages : {
            billCode : {
                required : icon + "请输入单据编号",
                remote:icon+"单据编号已存在"
            },
            peopleCode : {
                required : icon + "请输入人员编码"
            },
            proCode : {
                required : icon + "请输入工序编码",
                remote:icon+"不能输入重复的工序编码"
            },
            productCode : {
                required : icon + "请输入产品编码",
                remote:icon+"不能输入重复的产品编码"
            },
            dateMark : {
                required : icon + "请输入日期"
            },
            name : {
                required : icon + "请输入姓名"
            },
            harvest : {
                required : icon + "请输入产量"
            }


        }
    })
}