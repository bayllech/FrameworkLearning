/**
 * 方法名:用户订单支付统计
 * Author: lei.zhang
 * createTime: 2017年8月3日10:39:52
 */
var zfbTradeNo ='';
var businessOrder = '';
var payStartDate ='';
var payEndDate = '';
var payAccountNo ='';
var payAmt ='';
//分页跳转
$(".jump").bind("click",function(){
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
    if(getParam()){
        window.location.href= window.basePath+"/tps/ttxnPayOrder/list?p="+page+"&jumpPage="+page+
            "&zfbTradeNo="+zfbTradeNo+"&businessOrder="+businessOrder+"&payStartDate="+payStartDate+
            "&payEndDate="+payEndDate+"&payAccountNo="+payAccountNo+"&payAmt="+payAmt;

    }
});

$("#query").bind("click",function(){
    if(getParam()){
        window.location.href= window.basePath+"/tps/ttxnPayOrder/list?zfbTradeNo="+zfbTradeNo
            +"&businessOrder="+businessOrder+"&payStartDate="+payStartDate+
            "&payEndDate="+payEndDate+"&payAccountNo="+payAccountNo+"&payAmt="+payAmt;
    }
});

function getParam() {
    zfbTradeNo = $.trim($("#zfbTradeNo").val());
    businessOrder = $.trim($("#businessOrder").val());
    payStartDate = $.trim($("#payStartDate").val());
    payEndDate = $.trim($("#payEndDate").val());
    payAccountNo = $.trim($("#payAccountNo").val());

    var longPayStartDate = parseInt(new Date(Date.parse(payStartDate)).getTime());
    var longPayEndDate = parseInt(new Date(Date.parse(payEndDate)).getTime());
    if(payStartDate!=''  && payEndDate==''){
        layer.msg("付款结束时间不能为空!", {time:1500});
        return false;
    }
    if(payStartDate==''  && payEndDate!=''){
        layer.msg("付款开始时间不能为空!", {time:1500});
        return false;
    }
    if (longPayStartDate > longPayEndDate){
        layer.msg("付款开始时间不能晚于结束时间!", {time:1500});
        return false;
    }
    payAmt = $.trim($("#payAmt").val());
    var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    if (payAmt!='' && !reg.test(payAmt)) {
        layer.msg("金额有误!", {time:1500});
        return false;
    }
    return true;
}

//导出
$("#export").bind("click",function () {
    if(getParam()){
        var src = window.basePath+"/tps/ttxnPayOrder/export?zfbTradeNo="+zfbTradeNo
            +"&businessOrder="+businessOrder+"&payStartDate="+payStartDate+
            "&payEndDate="+payEndDate+"&payAccountNo="+payAccountNo+"&payAmt="+payAmt;
        $("#hidden_iframe").attr("src",src);
    }
});




