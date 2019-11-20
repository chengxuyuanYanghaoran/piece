layui.use('element', function () {
    var element = layui.element; //加载Tab的element模块

    //触发事件
    var active = {
        tabAdd: function () {
            //给当前点击的a标签添加自定义属性  
            var htmlurl = $(this).attr('data-url');
            var mytitle = $(this).attr('mytitle');

            //创建一个数组            
            var newArry = [];
            $(".layui-tab-title").find('li').each(function () {
                var li = $(this).attr("lay-id");
                newArry.push(li);
            });
            var tabs = $.inArray(mytitle, newArry); //$.inArray() 函数用于在数组中查找指定值，并返回它的索引值

            if (tabs >= 0) { //tab栏已有标签

                element.tabChange('demo', mytitle); //用于外部切换到指定的Tab项上  , 切换到当前点击的页面

            } else { //没有相同tab 添加tab项
                $("#iframe").remove(); //如果页面有两个iframe标签，通过指定id对前一个iframe标签删除。           
                element.tabAdd('demo', { //新增一个Tab选项               
                    title: mytitle,
                    content: '<iframe style="border:0; width:100%; height:630px" src=' +
                    htmlurl + ' ></iframe>',
                    id: mytitle
                })
                element.tabChange('demo', mytitle); //切换到当前点击的页面              
            }
        }
    };

    $(".btabs").click(function () {
        var type = "tabAdd";
        var othis = $(this);
        active[type] ? active[type].call(this, othis) : '';
    });
});





layui.use(['layer', 'form'], function () {
    var form = layui.form;
    var layer = layui.layer;
    $ = layui.jquery;

    var active = {
        setTop: function(){
//多窗口模式，层叠置顶
            layer.open({
                type: 1 //此处以iframe举例
                ,title: '信息'
                ,area: ['600px', '360px']
                ,shade: 0.3
                ,maxmin: true
                ,offset: 'auto'
                ,content: $("#signupForm")
                ,zIndex: layer.zIndex
            });
        }
    };

    $('.layui-btn-hfl').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });

/**
   * 左侧菜单展开动画
   */
  $("#navBar").on("click", ".layui-nav-item a", function () {
    if (!$(this).attr("lay-id")) {
      var superEle = $(this).parent();
      var ele = $(this).next('.layui-nav-child');
      var height = ele.height();
      ele.css({"display": "block"});
      // 是否是展开状态
      if (superEle.is(".layui-nav-itemed")) {
        ele.height(0);
        ele.animate({height: height + "px"}, function () {
          ele.css({height: "auto"});
        });
      } else {
        ele.animate({height: 0}, function () {
          ele.removeAttr("style");
        });
      }
    }
  });

  /**
   * 左边菜单显隐功能
   */
  $(".ok-menu").click(function () {
    $(".layui-layout-admin").toggleClass("ok-left-hide");
    $(this).find("i").toggleClass("ok-menu-hide");
    localStorage.setItem("isResize", false);
    setTimeout(function () {
      localStorage.setItem("isResize", true);
    }, 1200);
  });

  /**
   * 移动端的处理事件
   */
  $("body").on("click", ".layui-layout-admin .ok-left a[data-url], .ok-make", function () {
    if ($(".layui-layout-admin").hasClass("ok-left-hide")) {
      $(".layui-layout-admin").removeClass("ok-left-hide");
      $(".ok-menu").find('i').removeClass("ok-menu-hide");
    }
  });


  /**
   * 全屏/退出全屏
   */
  $("body").on("keydown", function (event) {
    event = event || window.event || arguments.callee.caller.arguments[0];
    // 按 Esc
    if (event && event.keyCode === 27) {
      console.log("Esc");
      $("#fullScreen").children("i").eq(0).removeClass("okicon-screen-restore");
    }
    // 按 F11
    if (event && event.keyCode == 122) {
      $("#fullScreen").children("i").eq(0).addClass("okicon-screen-restore");
    }
  });

  $("body").on("click", "#fullScreen", function () {
    if ($(this).children("i").hasClass("okicon-screen-restore")) {
      screenFun(2).then(function () {
        $(this).children("i").eq(0).removeClass("okicon-screen-restore");
      });
    } else {
      screenFun(1).then(function () {
        $(this).children("i").eq(0).addClass("okicon-screen-restore");
      });
    }
  });

  /**
   * 全屏和退出全屏的方法
   * @param num 1代表全屏 2代表退出全屏
   * @returns {Promise}
   */
  function screenFun(num) {
    num = num || 1;
    num = num * 1;
    var docElm = document.documentElement;

    switch (num) {
      case 1:
        if (docElm.requestFullscreen) {
          docElm.requestFullscreen();
        } else if (docElm.mozRequestFullScreen) {
          docElm.mozRequestFullScreen();
        } else if (docElm.webkitRequestFullScreen) {
          docElm.webkitRequestFullScreen();
        } else if (docElm.msRequestFullscreen) {
          docElm.msRequestFullscreen();
        }
        break;
      case 2:
        if (document.exitFullscreen) {
          document.exitFullscreen();
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen();
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen();
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen();
        }
        break;
    }

    return new Promise(function (res, rej) {
      res("返回值");
    });
  }

  /**
   * 系统公告
   */


  function noticeFun() {
    var srcWidth = okUtils.getBodyWidth();
    layer.open({
      type: 0, title: "系统公告", btn: "我知道啦", btnAlign: 'c', content: getContent(),
      yes: function (index) {
        if (srcWidth > 800) {
          layer.tips('公告跑到这里去啦', '#notice', {
            tips: [1, '#000'],
            time: 2000
          });
        }
        sessionStorage.setItem("notice", "true");
        layer.close(index);
      },
      cancel: function (index) {
        if (srcWidth > 800) {
          layer.tips('公告跑到这里去啦', '#notice', {
            tips: [1, '#000'],
            time: 2000
          });
        }
      }
    });
  }



  /**
   * 退出操作
   */
  $("#logout").click(function () {

      layer.confirm("确定要退出吗？", function (index) {
      window.location = "login.html";
    });
  });
});


