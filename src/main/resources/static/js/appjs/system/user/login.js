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
                required : true
            },
            password : {
                required : true,
                minlength: 5
            }
        },

        messages : {
            username:{
                required : icon + "请输入您的用户名"
            },
            password:{
                required: icon +"请输入密码",
                minlength: icon +"密码长度不能小于 5 个字母"
            }

        }
    })
}