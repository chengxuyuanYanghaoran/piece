$().ready(function() {
    validateRule();
});

$.validator.setDefaults({
    submitHandler : function() {
        login();
    }
});
function login(){
    $.ajax({
        cache : true,
        type : "POST",
        url: '/main',
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function() {
            alert('请求失败');
        },
        success: function (data) {
            if (data.code == 0) {
                window.location.href = '/toPageMain';
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
                    url: "/system/user/userLogin",     //后台处理程序
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
                remote:icon + "用户不存在"

            },
            password:{
                required: icon +"请输入密码",
                minlength: icon +"密码长度不能小于 5 个字母"
            }

        }
    })
}