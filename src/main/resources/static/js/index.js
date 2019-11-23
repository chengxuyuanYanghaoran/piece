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

    /**
     * 退出操作
     */
    $("#logout").click(function () {

        layer.confirm("确定要退出吗？", function (index) {
            window.location = "login.html";
        });
    });
});





layui.use('layer', function(){
    var $ = layui.jquery, layer = layui.layer;

    //触发事件
    var active = {
        setTop: function(){

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
        setbutton: function(){
            var id = $("input[name='state']:checked").val();
            var btn = document.getElementById("btnn");
            btn.setAttribute('value', id);
            var index = layer.open({
                type: 2
                ,title: '信息'
                ,area: 'auto'
                ,shade: 0
                ,maxmin: true
                ,offset: 'auto'
                ,content: '/system/wages/toPage/'+id
                ,zIndex: layer.zIndex //重点1
            });
            layer.full(index);
        }
    };

    $('.layui-btn-hfl').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });

    $('.layui-button').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
});

// //取消确认 按钮 弹窗消失
function clonewindow() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.closeAll(index);
}

/**
 * 移动端的处理事件
 */
$("body").on("click", ".layui-layout-admin .ok-left a[data-url], .ok-make", function () {
    if ($(".layui-layout-admin").hasClass("ok-left-hide")) {
        $(".layui-layout-admin").removeClass("ok-left-hide");
        $(".ok-menu").find('i').removeClass("ok-menu-hide");
    }
});


