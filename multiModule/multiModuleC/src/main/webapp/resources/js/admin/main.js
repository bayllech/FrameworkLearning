/**
 * 方法名:主页
 * Author: lei.zhang
 * createTime: 2017/8/2 14:31
 */
(function (win, $) {

    //日期格式化
    Date.prototype.format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };


    function getWeek(date) {
        var str = "";
        switch (date.getUTCDay()) {
            case 1:
                str = "星期一";
                break;
            case 2:
                str = "星期二";
                break;
            case 3:
                str = "星期三";
                break;
            case 4:
                str = "星期四";
                break;
            case 5:
                str = "星期五";
                break;
            case 6:
                str = "星期六";
                break;
            default :
                str = "星期日";
        }
        return str;
    }

    var currentDate = new Date().getTime();
    window.setInterval(function () {
        var date = new Date(currentDate);

        try {
            window.document.getElementById('date').innerHTML = date.format("yyyy.MM.dd hh:mm:ss");
            window.document.getElementById("week").innerHTML = getWeek(date);
        } catch (e) {
        }
        currentDate += 1000;
    }, 1000);

    var menu = $("#right").val();
    var showMenu = new RegExp("/tps/order/search");
    if (showMenu.test(menu)) {
        var iframe = document.getElementById("center_content_iframe");
        iframe.style.height='1000px';
        iframe.src = window.basePath+"/tps/order/search";
    }

    var items = $('.items');
    var list = $('.list');
    var managers = $('.managers');
    var title = $('.title');
    title.bind('click', function () {
        $(this).addClass('click').parent().siblings().children().removeClass('click');
        //$(this).next().find('.items:first').addClass('cur').parent().parent().siblings().find('.items').removeClass('cur');
        items.removeClass('cur');
        if (!$(this).hasClass('nohref')){
            getPage($(this));
        }
    });
    items.bind('click', function () {
        $(this).addClass('cur').siblings().removeClass('cur');
        $(this).addClass('cur').parent().parent().siblings().children().children().removeClass('cur');
        $(this).parent().prev().addClass('click').parent().siblings().children().removeClass('click');
        getPage($(this));
    });
    var arrow = $('.arrow');
    arrow.bind('click', function () {
        $(this).parent().next().toggle();
    });

    function getPage(doc) {
        var href = doc.attr("href");
        if (href != '') {
            var iframe = document.getElementById("center_content_iframe");
            window.iframe = iframe;
            iframe.style.height='1000px';
            iframe.src = href;
        }
    }

    //显示退出登录
    $('.LoginUsername').mouseenter(function(){
        $('.quit').show();
    }).mouseleave(function(){
        $('.quit').hide();
    });

    $('.quit').bind('click',function () {
        $('.popup').show();
        $('#popDiv').show();

    });

    //返回
    $('#closeConfirm').bind('click',function () {
        $('#popDiv').hide();
        $('.popup').hide();
    });

    //确定退出登录
    $('#closeTrue').bind('click',function () {
        $('#popDiv').hide();
        $('.popup').hide();
        $.ajax({
            url: window.basePath + "/tps/admin/logout",
            data: {},
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data.code == '000000') {
                    layer.msg(data.msg, {time: 1500});
                    setTimeout(function() {
                        window.location.href = window.basePath+'/login';
                    }, 500);
                } else {
                    layer.msg(data.msg, {time: 1500});
                }
            },
            timeout: 15000,
            error: function () {
                layer.msg("连接服务器失败，请检查网络连接!", {time: 1500});
            }
        });
    });



    //登录退出
    $('.LoginUsername').attr('width') == $('.quit').attr('width');
})(window, jQuery);



