/**
 * 方法名:用户管理
 * Author: lei.zhang
 * createTime: 2017/8/2 14:31
 */
//分页跳转
$(".jump").click(function(){
    var page = $(".page_jump").val();
    var pageRegex = /^[0-9]*[1-9][0-9]*$/;  //正整数
    if(!pageRegex.exec(page)){
        layer.msg("请输入正确的页码数!", {time:1500});
        return;
    }
    var maxPage = $("#max_page").val();
    if(parseInt(page) > parseInt(maxPage)){
        layer.msg("超过最大页码数!", {time:1500});
        return;
    }
    window.location.href= window.basePath+"/tps/user/list?p="+page+"&jumpPage="+page+
    "&userId="+$.trim($("#userId").val())+"&phoneNum="
        +$.trim($("#phone").val())+"&startDate="+ $.trim($("#registerStartTime").val())+"&endDate="+$.trim($("#registerEndTime").val())
        +"&userName="+$.trim($("#userName").val())+
        "&sex="+$("#sex").val();
});

//查询
$(".query").click(function () {
    var userId = $.trim($("#userId").val());
    var phone = $.trim($("#phone").val());
    var registerStartTime = $.trim($("#registerStartTime").val());
    var registerEndTime = $.trim($("#registerEndTime").val());
    var userName = $.trim($("#userName").val());
    var sex = $("#sex").val();
    var mobileRegex = /^1[34578]\d{9}$/;  //判断手机号正则表达式

    if(phone!='' && !mobileRegex.exec(phone)){
        layer.msg("手机号码格式有误!", {time:1500});
        return;
    }
    //开始时间和结束时间比较
    if(registerStartTime!='' && registerEndTime==''){
        layer.msg("结束时间不能为空!", {time:1500});
        return;
    }
    if(registerEndTime!='' && registerStartTime==''){
        layer.msg("开始时间不能为空!", {time:1500});
        return;
    }
   var longStartTime = parseInt(new Date(Date.parse(registerStartTime)).getTime());
   var longEndTime = parseInt(new Date(Date.parse(registerEndTime)).getTime());
   if(longStartTime > longEndTime){
       layer.msg("开始时间不能晚于结束时间!", {time:1500});
       return;
   }

    window.location.href= window.basePath+"/tps/user/list?userId="+userId+"&phoneNum="
        +phone+"&startDate="+registerStartTime+"&endDate="+registerEndTime+"&userName="+userName+
        "&sex="+sex;
});

//导出报表
$(".export").click(function(){
    var src = window.basePath+"/tps/user/export?userId="+$.trim($("#userId").val())+"&phoneNum="
        +$.trim($("#phone").val())+"&startDate="+ $.trim($("#registerStartTime").val())+"&endDate="+$.trim($("#registerEndTime").val())
        +"&userName="+$.trim($("#userName").val())+
        "&sex="+$("#sex").val();
    $("#hidden_iframe").attr("src",src);
});






