/**
 * 选项卡
 */
layui.use(['element','layer'], function () {
    var element = layui.element,
        layer = layui.layer;   //加载模块

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

            /**
             * 果当前Tab项上有选项卡, 则根据索引值进行点击切换
             */
            if (tabs >= 0) {

                element.tabChange('demo', mytitle); //用于外部切换到指定的Tab项上  ,切换到 lay-id="xxx" 的这一项

            } else {
                // $("#iframe").remove(); //用于删除id="iframe"首页 选项卡

                /**
                 * 如果当前Tab项上没有选项卡，则新增一个Tab选项, 新增之后则根据索值引进行点击切换
                 *
                 *新增一个Tab选项   
                 * element.tabAdd('demo', {
                   title: '选项卡的标题'
                   ,content: '选项卡的内容' //支持传入html
                   ,id: '选项卡标题的lay-id属性值'
                   });   
                 */
                element.tabAdd('demo', {
                    title: mytitle,
                    content: '<iframe frameborder="0" scrolling="yes" width="100%" height="100%" src=' +
                    htmlurl + ' ></iframe>',
                    id: mytitle
                })
                element.tabChange('demo', mytitle); //用于外部切换到指定的Tab项上  ,切换到 lay-id="xxx" 的这一项              
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
            //获取lay-id = "xxx"
            var ids = $("#tabTitle").find("li[class='layui-this']").attr("lay-id");
            //删除 lay-id="xxx" 的这一项
            element.tabDelete('demo', ids);
            //获取value值
            var id = $("input[name='state']:checked").val();

            console.log(id);
            localStorage.setItem("selectIndex", id);

            //取消确认 弹窗消失
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

            //多窗口模式，层叠置顶
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


