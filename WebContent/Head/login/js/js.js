//窗口效果
//点击登录class为tc 显示
$(".tc").click(function(){
    $(".gray").show();
    $(".popup").show();//查找ID为popup的DIV show()显示#gray
    $(".gray-r").hide();
    $(".popup-r").hide();
    tc_center();
});
//点击关闭按钮
$("a.guanbi").click(function(){
    $(".gray").hide();
    $(".popup").hide();//查找ID为popup的DIV hide()隐藏
})

//窗口水平居中
$(window).resize(function(){
    tc_center();
});

function tc_center(){
    var _top=($(window).height()-$(".popup").height())/2;
    var _left=($(window).width()-$(".popup").width())/2;

    $(".popup").css({top:_top,left:_left});
}


$(document).ready(function(){

    $(".top_nav").mousedown(function(e){
        $(this).css("cursor","move");//改变鼠标指针的形状
        var offset = $(this).offset();//DIV在页面的位置
        var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离
        var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离
        $(document).bind("mousemove",function(ev){ //绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件

            $(".popup").stop();//加上这个之后

            var _x = ev.pageX - x;//获得X轴方向移动的值
            var _y = ev.pageY - y;//获得Y轴方向移动的值

            $(".popup").animate({left:_x+"px",top:_y+"px"},10);
        });

    });

    $(document).mouseup(function() {
        $(".popup").css("cursor","default");
        $(this).unbind("mousemove");
    });
})


//窗口效果
//点击注册class为tc 显示
$(".rc").click(function(){
    $(".gray-r").show();
    $(".popup-r").show();//查找ID为popup的DIV show()显示#gray
    $(".gray").hide();
    $(".popup").hide();
    rc_center();
});
//点击关闭按钮
$("a.guanbi").click(function(){
    $(".gray-r").hide();
    $(".popup-r").hide();//查找ID为popup的DIV hide()隐藏
})

//窗口水平居中
$(window).resize(function(){
    rc_center();
});

function rc_center(){
    var _top=($(window).height()-$(".popup-r").height())/2;
    var _left=($(window).width()-$(".popup-r").width())/2;

    $(".popup-r").css({top:_top,left:_left});
}


$(document).ready(function(){

    $(".top_nav").mousedown(function(e){
        $(this).css("cursor","move");//改变鼠标指针的形状
        var offset = $(this).offset();//DIV在页面的位置
        var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离
        var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离
        $(document).bind("mousemove",function(ev){ //绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件

            $(".popup-r").stop();//加上这个之后

            var _x = ev.pageX - x;//获得X轴方向移动的值
            var _y = ev.pageY - y;//获得Y轴方向移动的值

            $(".popup-r").animate({left:_x+"px",top:_y+"px"},10);
        });

    });

    $(document).mouseup(function() {
        $(".popup-r").css("cursor","default");
        $(this).unbind("mousemove");
    });
})