
//年范围
layui.use(['form', 'layedit', 'laydate', "jquery"], function () {
    var form = layui.form
        , layer = layui.layer
        , $ = layui.jquery
        , laydate = layui.laydate;
    var nowTime = new Date().valueOf();
    //开始月份
    var start = laydate.render({
        elem: '#start_timer', //指定元素
        value:new Date(),
        //进入页面显示当前月份
        // value: new Date().getMonth() + 1,
        type: 'month',
        format: 'y-MM',
        done: function (value, date) {
            endMax = end.config.max;
            end.config.min = date;
            end.config.min.month = date.month -1;
        }
    });
    //结束月份
    var end = laydate.render({
        elem: '#end_timer', //指定元素
        type: 'month',
        value:new Date(),
        format: 'y-MM',
        min: new Date().getMonth(),
        done: function (value, date) {
            if ($.trim(value) == '') {
                var curDate = new Date();
                date = {'date': curDate.getDate(), 'month': curDate.getMonth() + 1, 'year': curDate.getFullYear()};
            }
            start.config.max = date;
            start.config.max.month = date.month - 1;
        }
    });
})


//年月日
layui.use(['form', 'layedit', 'laydate',"jquery"], function(){
    var form = layui.form
        ,layer = layui.layer
        ,$ = layui.jquery
        ,laydate = layui.laydate;
    var nowTime = new Date().valueOf();

    //日期
    var start = laydate.render({ //投票开始
        elem: '#start',
        // min:nowTime,
        value:new Date(),
        done:function(value,date){
            endMax = end.config.max;
            end.config.min = date;
            end.config.min.month = date.month -1;
        }
    });
    var end = laydate.render({
        elem: '#end',
        // min : nowTime,
        value:new Date(),
        done:function(value,date){
            if($.trim(value) == ''){
                var curDate = new Date();
                date = {'date': curDate.getDate(), 'month': curDate.getMonth()+1, 'year': curDate.getFullYear()};
            }
            start.config.max = date;
            start.config.max.month = date.month -1;
        }
    });
});

//弹框

window.onload=function () {
    //产品
    (function() {
        /*建立模态框对象*/
        var modalBox = {};
        /*获取模态框*/
        modalBox.modal = document.getElementById("myModal_four");
        /*获得trigger按钮*/
        modalBox.depection = document.getElementById("depection_four");
        /*获得关闭按钮*/
        modalBox.closeBtn = document.getElementById("true_four");
        /*模态框显示*/
        modalBox.show = function() {
            // console.log(this.modal);
            this.modal.style.display = "block";
            //清除重复遍历的数据
            $("#myModal_four .modal-header div").each(function (index) {
                // alert(1)
                if (index >= 0) {
                    $(this).remove();
                }
            });
            $.ajax({
                url: "/system/reportSelection/findProductName",
                async: true,
                type: "GET",
                datatype: "json",
                success: function (res) {
                    // console.log(res)
                    $.each(res.productDOS, function (index, obj) {
                        $("#myModal_four .modal-header").append(
                            "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-4\" value='" + obj["productName"] + "'/> "
                            + obj["productName"] + "</div>"
                        );
                    });
                    //获取所有复选框
                    var obox = document.getElementById("working");
                    var odiv = document.getElementById("daaa_four")
                    var ach = odiv.getElementsByTagName("input");

                    obox.onclick = function () {
                        // alert(2)
                        for (var i = 0; i < ach.length; i++) {
                            ach[i].checked = this.checked;
                        }
                    };
                    // alert(ach.length);
                    for (var i = 0; i < ach.length; i++) {
                        ach[i].onclick = function () {
                            if (!this.checked) {
                                obox.checked = false;
                            }

                            var flag = true;
                            for (var i = 0; i < ach.length; i++) {
                                if (!ach[i].checked) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                obox.checked = true;
                            }
                        };
                    }
                },
                error: function () {
                    alert("失败");
                }
            });
            // 防止重复点击
            $("#true_four").unbind("click");
            $("#true_four").bind('click', function (res) {
                text = $("input:checkbox[name='check-4']:checked").map(function () {
                    return $(this).val();
                }).get();
                //给p标签动态添加内容
                $("#dec_input_four").append("<span>" + text + "," + "</span>");
            });
            $("#four").click(function () {
                $("#myModal_four").fadeOut();
            })
        };
        /*模态框关闭*/
        modalBox.close = function() {
            this.modal.style.display = "none";
        };

        /*模态框初始化*/
        modalBox.init = function() {
            var that = this;
            this.depection.onclick = function() {
                that.show();
            };
            this.closeBtn.onclick = function() {
                that.close();
            };
        };
        modalBox.init();
    })();

    ///工序
    (function() {
        /*建立模态框对象*/
        var modalBox = {};
        /*获取模态框*/
        modalBox.modal = document.getElementById("myModal_three");
        /*获得trigger按钮*/
        modalBox.depection = document.getElementById("depection_three");
        /*获得关闭按钮*/
        modalBox.closeBtn = document.getElementById("true_three");

        /*模态框显示*/
        modalBox.show = function() {
            // console.log(this.modal);
            this.modal.style.display = "block";
            //清除重复遍历的数据
            $("#myModal_three .modal-header div").each(function (index) {
                // alert(1)
                if (index >= 0) {
                    $(this).remove();
                }
            });
            $.ajax({
                url: "/system/reportSelection/findProcedureName",
                async: true,
                type: "GET",
                datatype: "json",
                success: function (res) {
                    // console.log(res)
                    $.each(res.procedureDOS, function (index, obj) {
                        $("#myModal_three .modal-header").append(
                            "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-3\" value='" + obj["proName"] + "'/> "
                            + obj["proName"] + "</div>"
                        );
                    });
                    //获取所有复选框
                    var obox = document.getElementById("product");
                    var odiv = document.getElementById("daaa_three")
                    var ach = odiv.getElementsByTagName("input");

                    obox.onclick = function () {
                        for (var i = 0; i < ach.length; i++) {
                            ach[i].checked = this.checked;
                        }
                    };
                    // alert(ach.length);
                    for (var i = 0; i < ach.length; i++) {
                        ach[i].onclick = function () {
                            if (!this.checked) {
                                obox.checked = false;
                            }

                            var flag = true;
                            for (var i = 0; i < ach.length; i++) {
                                if (!ach[i].checked) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                obox.checked = true;
                            }
                        };
                    }
                },
                error: function () {
                    alert("失败");
                }
            });
            // 防止重复点击
            $("#true_three").unbind("click");
            $("#true_three").bind('click', function (res) {
                text = $("input:checkbox[name='check-3']:checked").map(function () {
                    return $(this).val();
                }).get();
                //给p标签动态添加内容
                $("#dec_input_three").append("<span>" + text + "," + "</span>");
            });
            $("#three").click(function () {
                $("#myModal_three").fadeOut();
            })
        };
        /*模态框关闭*/
        modalBox.close = function() {
            this.modal.style.display = "none";
        };

        /*模态框初始化*/
        modalBox.init = function() {
            var that = this;
            this.depection.onclick = function() {
                that.show();
            };
            this.closeBtn.onclick = function() {
                that.close();
            };
        };
        modalBox.init();
    })();
    //人员
    (function() {
        /*建立模态框对象*/
        var modalBox = {};
        /*获取模态框*/
        modalBox.modal = document.getElementById("myModal_two");
        /*获得trigger按钮*/
        modalBox.depection = document.getElementById("depection_two");
        /*获得关闭按钮*/
        modalBox.closeBtn = document.getElementById("true_one");

        /*模态框显示*/
        modalBox.show = function() {
            // console.log(this.modal);
            this.modal.style.display = "block";
            //清除重复遍历的数据
            $("#myModal_two .modal-header div").each(function (index) {
                // alert(1)
                if (index >= 0) {
                    $(this).remove();
                }
            });
            $.ajax({
                url: "/system/reportSelection/findPeopleName",
                async: true,
                type: "GET",
                datatype: "json",
                success: function (res) {
                    // console.log(res)
                    $.each(res.peopleDOS, function (index, obj) {
                        $("#myModal_two .modal-header").append(
                            "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-2\" value='" + obj["peopleName"] + "'/> "
                            + obj["peopleName"] + "</div>"
                        );
                    });
                    //获取所有复选框
                    var obox = document.getElementById("everything");
                    var odiv = document.getElementById("daaa_two")
                    var ach = odiv.getElementsByTagName("input");

                    obox.onclick = function () {
                        for (var i = 0; i < ach.length; i++) {
                            ach[i].checked = this.checked;
                        }
                    };
                    // alert(ach.length);
                    for (var i = 0; i < ach.length; i++) {
                        ach[i].onclick = function () {
                            if (!this.checked) {
                                obox.checked = false;
                            }

                            var flag = true;
                            for (var i = 0; i < ach.length; i++) {
                                if (!ach[i].checked) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                obox.checked = true;
                            }
                        };
                    }
                },
                error: function () {
                    alert("失败");
                }
            });
            // 防止重复点击
            $("#true_one").unbind("click");
            $("#true_one").bind('click', function (res) {
                text = $("input:checkbox[name='check-2']:checked").map(function () {
                    return $(this).val();
                }).get();
                //给p标签动态添加内容
                $("#dec_input_two").append("<span>" + text + "," + "</span>");
                // $("#daaa").fadeOut();
                // $("input:checkbox[id='everything']").removeAttr('checked');
            });
            $("#two").click(function () {
                $("#myModal_two").fadeOut();
            })
        };
        /*模态框关闭*/
        modalBox.close = function() {
            this.modal.style.display = "none";
        };

        /*模态框初始化*/
        modalBox.init = function() {
            var that = this;
            this.depection.onclick = function() {
                that.show();
            };
            this.closeBtn.onclick = function() {
                that.close();
            };
        };
        modalBox.init();
    })();
    //部门
    (function() {
        /*建立模态框对象*/
        var modalBox = {};
        /*获取模态框*/
        modalBox.modal = document.getElementById("myModal_one");
        /*获得trigger按钮*/
        modalBox.depection = document.getElementById("depection");
        /*获得关闭按钮*/
        modalBox.closeBtn = document.getElementById("true");

        /*模态框显示*/
        modalBox.show = function() {
            // console.log(this.modal);
            this.modal.style.display = "block";
            //清除重复遍历的数据
            $("#myModal_one .modal-header div").each(function (index) {
                // alert(1)
                if (index >= 0) {
                    $(this).remove();
                }
            });
            $.ajax({
                url: "/system/reportSelection/findDepartmentName",
                async: true,
                type: "GET",
                datatype: "json",
                success: function (res) {
                    // console.log(res)
                    $.each(res.departmentDOS, function (index, obj) {
                        $("#myModal_one .modal-header").append(
                            "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-1\" value='" + obj["bmName"] + "'/> "
                            + obj["bmName"] + "</div>"
                        );
                    });
                    //获取所有复选框
                    var obox = document.getElementById("department");
                    var odiv = document.getElementById("daaa")
                    var ach = odiv.getElementsByTagName("input");

                    obox.onclick = function () {
                        // alert(2)
                        for (var i = 0; i < ach.length; i++) {
                            ach[i].checked = this.checked;
                        }
                    };
                    // alert(ach.length);
                    for (var i = 0; i < ach.length; i++) {
                        ach[i].onclick = function () {
                            if (!this.checked) {
                                obox.checked = false;
                            }

                            var flag = true;
                            for (var i = 0; i < ach.length; i++) {
                                if (!ach[i].checked) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                obox.checked = true;
                            }
                        };
                    }
                },
                error: function () {
                    alert("失败");
                }
            });
            // 防止重复点击
            $("#true").unbind("click");
            $("#true").bind('click', function (res) {
                text = $("input:checkbox[name='check-1']:checked").map(function () {
                    return $(this).val();
                }).get();
                //给p标签动态添加内容
                $("#dec_input").append("<span>" + text + "," + "</span>");
            });
            $("#one").click(function () {
                $("#myModal_one").fadeOut();
            })
        };
        /*模态框关闭*/
        modalBox.close = function() {
            this.modal.style.display = "none";
        };

        /*模态框初始化*/
        modalBox.init = function() {
            var that = this;
            this.depection.onclick = function() {
                that.show();
            };
            this.closeBtn.onclick = function() {
                that.close();
            };
        };
        modalBox.init();
    })();
};

function ddd(){
    var a = parent.$("input[name='state']:checked").val();
    var Get_start_time = $("#start_timer").val();
    var Get_end_time = $("#end_timer").val();
    var Get_start_time_day = $("#start").val();
    var Get_end_time_day = $("#end").val();
    var Get_dec_input_four = $("#dec_input_four").text();
    var Get_dec_input_three = $("#dec_input_three").text();
    var Get_dec_input_two = $("#dec_input_two").text();
    var Get_dec_input = $("#dec_input").text();

    if (a==0){
        if ($("#dec_input_four").text()==""){
            alert("请选择或输入产品条件！");
            return false;
        }
    }else if (a==1){
        if ($("#dec_input_three").text()==""){
            alert("请选择或输入工序条件！");
            return false;
        }
    }else {
        alert("请选择计价方式！");
        return false;
    }

    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#test'
            , url: '/system/reportForm/detailed'
            ,method:'post'
            ,where:{"product":Get_dec_input_four,
                    "procedure":Get_dec_input_three,
                    "people":Get_dec_input_two,
                    "department":Get_dec_input,
                    "accountingOff":Get_start_time,
                    "accountingOn":Get_end_time,
                    "completionOff":Get_start_time_day,
                    "completionOn":Get_end_time_day,
                    "mode":a
            }
            , cols: [[
                {type: 'checkbox'}
                , {field: 'id', title: 'ID',hide:true}
                , {field: 'dateMark2',title: '日期', sort: true,totalRowText:'合计：'}
                , {field: 'name', title: '人员'}
                , {field: 'proName', title: '工序名称', sort: true}
                , {field: 'productName', title: '产品名称', sort: true}
                , {field: 'harvest', title: '产量', sort: true,totalRow: true}
                , {field: 'productPrice', title: '单价', sort: true}
                , {field: 'money', title: '金额', sort: true,totalRow: true}
            ]]
            , page: true,
            totalRow: true,
            limits : [ 5, 10, 15 ], //控制多少行一页（默认五条一页）
            limit : 5 //每页默认显示的数量
        });
    });
    //点击关闭弹框
    $(".layui-layer-close1").trigger('click');
    //按钮
    $("#butt").html("<button type=\"button\" class=\"layui-btn layui-btn-warm\" id='butt_one' data-method=\"setTop\">查询条件</button>");

    layui.use('layer', function () { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        //触发事件
        var active = {
            setTop: function () {
                var that = this;
                //多窗口模式，层叠置顶
                layer.open({
                    type: 1 //此处以iframe举例
                    , title: '再次查询'
                    , area: ['65%', '80%']
                    , offset: ['50px', '140px']
                    , shade: 0
                    , maxmin: true
                    , content: $("#ddd")
                    , zIndex: layer.zIndex //重点1
                    , success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });
            }
        };
        $('#butt_one').on('click', function () {
            $(".dec_ddd .ddd_input").text("");
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });

    });

//    出现layui弹框
//     $("#test_div").fadeIn();
}
    //删除
    // $("#ddd p").each(function(index) {
    //     if(index > 0) {
    //         $(this).remove();
    //     }
    // });

layui.use('layer',function(){
    var layer = layui.layer;

    layer.open({
        type: 1
        , content: $("#ddd")
        , title:  ['查询条件！', 'font-size:18px;color:red']
        , area: ['65%', '80%']
        , shade: 0
        , offset:['50px','140px']
        , tipsMore: true
        , maxmin: true//这里content是一个普通的String
        , success:function (res) {
            if(parent.$("input[name='state']:checked").val() == 0 ) {
                $("#dec_ddd_two").show();
                $("#dec_ddd").hide();
            } else if(parent.$("input[name='state']:checked").val() == 1 ) {
                $("#dec_ddd").show();
                $("#dec_ddd_two").hide();
            } else {
                alert("选择失败！")
            }
        }
    });

});
