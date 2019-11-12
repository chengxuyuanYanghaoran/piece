//初始化
$(function(){
    validateSubmit()
})

//提交点击事件
$.validator.setDefaults({
    submitHandler: function() {
        login();
    }
});

//ajax提交
function login() {
	alert(9999)
    $.ajax({
        dataType: 'json', // 注意：这里是指希望服务端返回json格式的数据-->
        cache: true,
        async: false,
        type: 'post',
        data: $('#signupForm').serialize(),
        url: '/main',
        error: function () {
            alert('请求失败');
        },
        success: function (data) {
            if (data.code == 0) {
                window.location.href = '/toPageMain';
            }

        }
    });
}

//表单验证
function validateSubmit(){
    var icon = "<i class='fa fa-times-circle'></i> ";
					$("#SubmitForm").validate({
						rules: {
							username: {
								required: true
							},
							password: {
								required: true,
								rangelength: [3, 10]
							},
							// newpassword: {
							// 	required: true,
							// 	rangelength: [3, 10],
							// 	equalTo: "#password"
							// },
						},
						messages: {
							username: {
								required: icon + "请输入您的用户名",
							},
							password: {
								required: icon + "请输入您的密码",
								rangelength: icon + "密码介于3-10位数字"
							},
							// newpassword: {
							// 	required: icon + "请再次输入密码",
							// 	rangelength:icon + "密码介于3-10位数字",
							// 	equalTo: icon + "两次密码输入不一致"
							// }
						}
					})
}