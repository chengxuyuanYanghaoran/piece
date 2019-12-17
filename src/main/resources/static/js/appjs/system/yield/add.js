$().ready(function() {
    var mode=parent.parent.parent.$("input[name='state']:checked").val();//获取计价的方式;
	if (mode==0){ //进行产品校验
        validateRule();
	}else {
        validateRule2();
	}
});

/*
* 校验未通过时拦截submit请求
* */
$.validator.setDefaults({
	submitHandler : function() {
		save();//调用保存方法
	}
});
/*
* 保存数据的方法
* */
function save() {
    var mode=parent.parent.parent.$("input[name='state']:checked").val();//获取计价的方式;
    $("#mode").val(mode);//修改隐藏表单域的值

	$.ajax({
		cache : true,
		type : "POST",
		url : "/system/yield/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				// parent.reLoad();
                var msg = data.msg;//获取保存的数据的id
                parent.loadTable(msg);
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}

/*
* 产品校验
* */
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            // yieldCode: {
            //     required: true,
            //     remote: {
            //         url: "/system/yield/validateByCard",     //后台处理程序
            //         type: "post",               //数据发送方式
            //         dataType: "json",           //接受数据格式
            //         data: {                     //要传递的数据
            //             yieldCode: function () {
            //                 return $("#yieldCode").val()
            //             }
            //         }
            //     }
            // },
            dateMark: {
                required: true
            },
            name: {
                required: true
            },
            productName: {
                required: true
            },
            harvest:{
                required: true
			}
        },

        messages : {
        //     yieldCode : {
			// 	required : icon + "请输入单据编号",
        //         remote:icon+"单据编号已存在"
        //      },
            dateMark : {
                required : icon + "请输入日期",
            },
            name : {
                required : icon + "请输入姓名",
            },
            productName : {
                required : icon + "请输入产品名称",
            },
            harvest : {
                required : icon + "请输入数量",
			}
		}
	})
}

/*
* 工序校验
* */
function validateRule2() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            dateMark: {
                required: true
            },
            name: {
                required: true
            },
            proName: {
                required: true
            },
            harvest:{
                required: true
            }
        },

        messages : {
            dateMark : {
                required : icon + "请输入日期",
            },
            name : {
                required : icon + "请输入姓名",
            },
            proName : {
                required : icon + "请输入工序名称",
            },
            harvest : {
                required : icon + "请输入数量",
            }
        }
    })
}