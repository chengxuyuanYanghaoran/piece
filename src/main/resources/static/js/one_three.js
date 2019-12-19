
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
        type: 'year',
        format: 'y',
        done: function (value, date) {
            endMax = end.config.max;
            end.config.min = date;
            end.config.min.month = date.month -1;
        }
    });
    //结束月份
    var end = laydate.render({
        elem: '#end_timer', //指定元素
        type: 'year',
        value:new Date(),
        format: 'y',
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
            $("#myModal_four .pagination-container .pagination span").each(function (index) {
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
                    // $.each(res.productDOS, function (index, obj) {
                    //     $("#myModal_four .modal-header").append(
                    //         "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-4\" value='" + obj["productName"] + "'/> "
                    //         + obj["productName"] + "</div>"
                    //     );
                    // });
                    let a = res.productDOS;
                    let p = 1;//根据p值显示每页的数据
                    let d = 25;//每页显示多少条
                    let b=(res.productDOS.length)%(a.slice((p - 1) * d, d * p)).length;
                    let c=(res.productDOS.length)/(a.slice((p - 1) * d, d * p)).length;
                    if (b!=0){
                        b=c+1;
                    }else {
                        b=c;
                    }
                    // console.log(a);
                    let newMain = document.querySelector("#daaa_four");
                    let pagination = document.querySelector('#pagin_four');//分页容器
                    let pageCount = b; //根据数据的长度计算总共几页
                    let newsDataRender = [];//每页要显示的数据

                    let render = function () {
                        newMain.innerHTML = '';
                        newsDataRender = a.slice((p - 1) * d, d * p); //每页要显示的数据,一页显示5条
                        newsDataRender.forEach((item ,index) => {
                            newMain.innerHTML += `<div style='display: inline-block;padding-left: 10px;padding-top: 15px'>
                                                  <div>
                                                  <input type='checkbox' name=\"check-4\"  value='${item.productName}'/> ${item.productName}</div>
                                                  </div>`;
                        })
                    };
                    //初始化页面
                    render();
                    //渲染分页
                    for (let i = 1; i <= pageCount; i++) {
                        pagination.innerHTML += `<span>${i}</span>`;
                    }
                    // pagination.innerHTML += `<span class="skip">跳转至 <input type="text"> </span>页`;//获取页数
                    let asAll = pagination.querySelectorAll('span');
                    //页面刚进来时第一页高亮
                    asAll[p - 1].classList.add('active');
                    //遍历总页数
                    asAll.forEach((item, index) => {
                    //点击页数
                        item.onclick = function () {
                            for (let j = 0; j < asAll.length; j++) {
                                asAll[j].classList.remove('active');
                            }
                            this.classList.add('active');
                            p = index + 1; //点击页数，改变p的值，以改变这个页面要显示的数据，达到分页的效果
                            render(); //重新渲染页面
                        }
                    });
                    //点击上一页下一页，改变高亮
                    let changePageClass = () => {
                        for (let j = 0; j < asAll.length; j++) {
                            asAll[j].classList.remove('active');
                        }
                        asAll[p - 1].classList.add('active');
                    };
                    //上一页
                    let prev = document.querySelector('.prev_four');
                    prev.onclick = function (e) {
                        if (p <= 1) {
                            console.log(p);
                            return;
                        } else {
                            p = p - 1;
                            changePageClass();
                            render();
                        }
                    };
                    //下一页
                    let next = document.querySelector('.next_four');
                    next.onclick = function () {
                        if (p >= asAll.length) {
                            return;
                        }
                        p = p + 1;
                        changePageClass();
                        render();
                    };
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
            $("#myModal_three .pagination-container .pagination span").each(function (index) {
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
                    // $.each(res.procedureDOS, function (index, obj) {
                    //     $("#myModal_three .modal-header").append(
                    //         "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-3\" value='" + obj["proName"] + "'/> "
                    //         + obj["proName"] + "</div>"
                    //     );
                    // });
                    let a = res.procedureDOS;
                    let p = 1;//根据p值显示每页的数据
                    let d = 20;
                    let b=(res.procedureDOS.length)%(a.slice((p - 1) * d, d * p)).length;
                    let c=(res.procedureDOS.length)/(a.slice((p - 1) * d, d * p)).length;
                    if (b!=0){
                        b=c+1;
                    }else {
                        b=c;
                    }
                    // console.log(a);
                    let newMain = document.querySelector("#daaa_three");
                    let pagination = document.querySelector('#pagin_three');//分页容器
                    let pageCount = b; //根据数据的长度计算总共几页
                    let newsDataRender = [];//每页要显示的数据
                    let render = function () {
                        newMain.innerHTML = '';
                        newsDataRender = a.slice((p - 1) * d, d * p); //每页要显示的数据,一页显示5条
                        newsDataRender.forEach((item ,index) => {
                            newMain.innerHTML += `<div style='display: inline-block;padding-left: 10px;padding-top: 15px'>
                                                  <div>
                                                  <input type='checkbox' name=\"check-3\"  value='${item.proName}'/> ${item.proName}</div>
                                                  </div>`;
                        })
                    };
                    //初始化页面
                    render();
                    //渲染分页
                    for (let i = 1; i <= pageCount; i++) {
                        pagination.innerHTML += `<span>${i}</span>`;
                    }
                    // pagination.innerHTML += `<span class="skip">跳转至 <input type="text"> </span>页`;//获取页数
                    let asAll = pagination.querySelectorAll('span');
                    //页面刚进来时第一页高亮
                    asAll[p - 1].classList.add('active');
                    //遍历总页数
                    asAll.forEach((item, index) => {
                    //点击页数
                        item.onclick = function () {
                            for (let j = 0; j < asAll.length; j++) {
                                asAll[j].classList.remove('active');
                            }
                            this.classList.add('active');
                            p = index + 1; //点击页数，改变p的值，以改变这个页面要显示的数据，达到分页的效果
                            render(); //重新渲染页面
                        }
                    });
                    //点击上一页下一页，改变高亮
                    let changePageClass = () => {
                        for (let j = 0; j < asAll.length; j++) {
                            asAll[j].classList.remove('active');
                        }
                        asAll[p - 1].classList.add('active');
                    };
                    //上一页
                    let prev = document.querySelector('.prev_three');
                    prev.onclick = function (e) {
                        if (p <= 1) {
                            console.log(p);
                            return;
                        } else {
                            p = p - 1;
                            changePageClass();
                            render();
                        }
                    };
                    //下一页
                    let next = document.querySelector('.next_three');
                    next.onclick = function () {
                        if (p >= asAll.length) {
                            return;
                        }
                        p = p + 1;
                        changePageClass();
                        render();
                    };
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
            $("#myModal_two .pagination-container .pagination span").each(function (index) {
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
                    // $.each(res.peopleDOS, function (index, obj) {
                    //     $("#myModal_two .modal-header").append(
                    //         "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-2\" value='" + obj["peopleName"] + "'/> "
                    //         + obj["peopleName"] + "</div>"
                    //     );
                    // });
                    let a = res.peopleDOS;
                    let p = 1;//根据p值显示每页的数据
                    let d = 25;
                    let b=(res.peopleDOS.length)%(a.slice((p - 1) * d, d * p)).length;
                    let c=(res.peopleDOS.length)/(a.slice((p - 1) * d, d * p)).length;
                    if (b!=0){
                        b=c+1;
                    }else {
                        b=c;
                    }
                    // console.log(a);
                    let newMain = document.querySelector("#daaa_two");
                    let pagination = document.querySelector('#pagin_two');//分页容器
                    let pageCount = b; //根据数据的长度计算总共几页
                    let newsDataRender = [];//每页要显示的数据

                    let render = function () {
                        newMain.innerHTML = '';
                        newsDataRender = a.slice((p - 1) * d, d * p); //每页要显示的数据,一页显示5条
                        newsDataRender.forEach((item ,index) => {
                            newMain.innerHTML += `<div style='display: inline-block;padding-left: 10px;padding-top: 15px'>
                                                  <div>
                                                  <input type='checkbox' name=\"check-2\"  value='${item.peopleName}'/> ${item.peopleName}</div>
                                                  </div>`;
                        })
                    };
                    //初始化页面
                    render();
                    //渲染分页
                    for (let i = 1; i <= pageCount; i++) {
                        pagination.innerHTML += `<span>${i}</span>`;
                    }
                    // pagination.innerHTML += `<span class="skip">跳转至 <input type="text"> </span>页`;//获取页数
                    let asAll = pagination.querySelectorAll('span');
                    //页面刚进来时第一页高亮
                    asAll[p - 1].classList.add('active');
                    //遍历总页数
                    asAll.forEach((item, index) => {
                    //点击页数
                        item.onclick = function () {
                            for (let j = 0; j < asAll.length; j++) {
                                asAll[j].classList.remove('active');
                            }
                            this.classList.add('active');
                            p = index + 1; //点击页数，改变p的值，以改变这个页面要显示的数据，达到分页的效果
                            render(); //重新渲染页面
                        }
                    });
                    //点击上一页下一页，改变高亮
                    let changePageClass = () => {
                        for (let j = 0; j < asAll.length; j++) {
                            asAll[j].classList.remove('active');
                        }
                        asAll[p - 1].classList.add('active');
                    };
                    //上一页
                    let prev = document.querySelector('.prev_two');
                    prev.onclick = function (e) {
                        if (p <= 1) {
                            console.log(p);
                            return;
                        } else {
                            p = p - 1;
                            changePageClass();
                            render();
                        }
                    };
                    //下一页
                    let next = document.querySelector('.next_two');
                    next.onclick = function () {
                        if (p >= asAll.length) {
                            return;
                        }
                        p = p + 1;
                        changePageClass();
                        render();
                    };

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
            $("#myModal_one .pagination-container .pagination span").each(function (index) {
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
                    // $.each(res.departmentDOS, function (index, obj) {
                    //     $("#myModal_one .modal-header").append(
                    //         "<div style='display: inline-block;padding-left: 10px;padding-top: 15px'><input type='checkbox' name=\"check-1\" value='" + obj["bmName"] + "'/> "
                    //         + obj["bmName"] + "</div>"
                    //     );
                    // });
                    let a = res.departmentDOS;
                    let p = 1;//根据p值显示每页的数据
                    let d = 20;
                    let b=(res.departmentDOS.length)%(a.slice((p - 1) * d, d * p)).length;
                    let c=(res.departmentDOS.length)/(a.slice((p - 1) * d, d * p)).length;
                    if (b!=0){
                        b=c+1;
                    }else {
                        b=c;
                    }
                    // console.log(a);
                    let newMain = document.querySelector("#daaa");
                    let pagination = document.querySelector('#pagin');//分页容器
                    let pageCount = b; //根据数据的长度计算总共几页
                    let newsDataRender = [];//每页要显示的数据

                    let render = function () {
                        newMain.innerHTML = '';
                        newsDataRender = a.slice((p - 1) * d, d * p); //每页要显示的数据,一页显示5条
                        newsDataRender.forEach((item ,index) => {
                            newMain.innerHTML += `<div style='display: inline-block;padding-left: 10px;padding-top: 15px'>
                                                  <div>
                                                  <input type='checkbox' name=\"check-1\"  value='${item.bmName}'/> ${item.bmName}</div>
                                                  </div>`;
                        })
                    };
                    //初始化页面
                    render();
                    //渲染分页
                    for (let i = 1; i <= pageCount; i++) {
                        pagination.innerHTML += `<span>${i}</span>`;
                    }
                    // pagination.innerHTML += `<span class="skip">跳转至 <input type="text"> </span>页`;//获取页数
                    let asAll = pagination.querySelectorAll('span');
                    //页面刚进来时第一页高亮
                    asAll[p - 1].classList.add('active');
                    //遍历总页数
                    asAll.forEach((item, index) => {
                    //点击页数
                        item.onclick = function () {
                            for (let j = 0; j < asAll.length; j++) {
                                asAll[j].classList.remove('active');
                            }
                            this.classList.add('active');
                            p = index + 1; //点击页数，改变p的值，以改变这个页面要显示的数据，达到分页的效果
                            render(); //重新渲染页面
                        }
                    });
                    //点击上一页下一页，改变高亮
                    let changePageClass = () => {
                        for (let j = 0; j < asAll.length; j++) {
                            asAll[j].classList.remove('active');
                        }
                        asAll[p - 1].classList.add('active');
                    };
                    //上一页
                    let prev = document.querySelector('.prev');
                    prev.onclick = function (e) {
                        if (p <= 1) {
                            console.log(p);
                            return;
                        } else {
                            p = p - 1;
                            changePageClass();
                            render();
                        }
                    };
                    //下一页
                    let next = document.querySelector('.next');
                    next.onclick = function () {
                        if (p >= asAll.length) {
                            return;
                        }
                        p = p + 1;
                        changePageClass();
                        render();
                    }
                    //获取所有复选框
                    var obox = document.getElementById("department");
                    var odiv = document.getElementById("daaa")
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
    var a = parent.$("#btnn").val();
    var Get_start_time = $("#start_timer").val();
    var Get_end_time = $("#end_timer").val();
    var Get_dec_input_four = $("#dec_input_four").text();
    var Get_dec_input_three = $("#dec_input_three").text();
    var Get_dec_input_two = $("#dec_input_two").text();
    var Get_dec_input = $("#dec_input").text();

    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#test'
            , url: '/system/reportForm/statistics'
            ,method:'post'
            ,where:{"product":Get_dec_input_four,
                    "procedure":Get_dec_input_three,
                    "people":Get_dec_input_two,
                    "department":Get_dec_input,
                    "accountingOff":Get_start_time,
                    "accountingOn":Get_end_time
            }
            , cols: [[
                {type: 'checkbox'}
                , {field: 'id', title: 'ID',hide:true}
                , {field: 'accDataStr', title: '日期', sort: true,totalRowText:'合计：'}
                , {field: 'moneys', title: '金额', sort: true,totalRow: true}
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
//删除
//
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
            if(parent.$("#btnn").val() == 0 ) {
                $("#dec_ddd_two").show();
                $("#dec_ddd").hide();
            } else if(parent.$("#btnn").val() == 1 ) {
                $("#dec_ddd").show();
                $("#dec_ddd_two").hide();
            } else {
                alert("选择失败！")
            }
        }
    });

});
