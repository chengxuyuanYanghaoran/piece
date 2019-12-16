/**
 * 选项卡
 */
layui.use(['element','layer'], function () {
    var element = layui.element,
        layer = layui.layer;
    var active = {
        tabAdd: function () {
            var htmlurl = $(this).attr('data-url');
            var mytitle = $(this).attr('mytitle');      
            var newArry = [];
            $(".layui-tab-title").find('li').each(function () {
                var li = $(this).attr("lay-id");
                newArry.push(li);
            });
            var tabs = $.inArray(mytitle, newArry);
            /**
             * 果当前Tab项上有选项卡, 则根据索引值进行点击切换
             */
            if (tabs >= 0) {
                element.tabChange('demo', mytitle);
            } else {
                element.tabAdd('demo', {
                    title: mytitle,
                    content: '<iframe frameborder="0" scrolling="yes" width="100%" height="100%" src=' +
                    htmlurl + ' ></iframe>',
                    id: mytitle
                })
                element.tabChange('demo', mytitle);           
            }
        }
    };

    $(".btabs").click(function () {
        var type = "tabAdd";
        var othis = $(this);
        active[type] ? active[type].call(this, othis) : null;
    });

    /**
     * 退出操作
     */
    $("#logout").click(function () {

        layer.confirm("确定要退出吗？", function (index) {
            window.location = "login.html";
        });
    });
});


/**
 * 计件方式确认、取消按钮，对应选项卡消失
 */
layui.use(['element','layer'], function () {
    var element = layui.element;//加载模块

    //触发事件
    var active = {
        tabAdd: function () {
            var ids = $("#tabTitle").find("li[class='layui-this']").attr("lay-id");
            element.tabDelete('demo', ids);
            var id = $("input[name='state']:checked").val();
            console.log(id);
            localStorage.setItem("selectIndex", id);
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.closeAll(index);
        }
    };

    $(".Tabs").click(function () {
        var type = "tabAdd";
        var othis = $(this);
        active[type] ? active[type].call(this, othis) : null;
    });

});


/**
 * 计件方式
 */
layui.use('layer', function(){
    var $ = layui.jquery, layer = layui.layer;

    //触发事件
    var active = {
        tabAdd: function(){
            layer.open({
                type: 1
                ,title: '信息'
                ,area: ['600px', '360px']
                ,shade: 0.3
                ,maxmin: true
                ,offset: 'auto'
                ,content: $("#signupForm")
                ,zIndex: layer.zIndex //重点1

            });
        },
    };

    $('.layui-btn-hfl').on('click', function(){
        var type = "tabAdd";
        var othis = $(this);
        active[type] ? active[type].call(this, othis) : null;
    });

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


