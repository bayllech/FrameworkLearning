/**
 * 方法名:退款用户订单统计
 * Author: lei.zhang
 * createTime: 2017年8月3日10:39:52
 */
var origOrderNo ='';
var startDate = '';
var endDate ='';
var refundAmt = '';
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
        window.location.href= window.basePath+"/tps/refundUserOrder/list?p="+page+"&jumpPage="+page+
            "&origOrderNo="+origOrderNo+"&startDate="+startDate+"&endDate="+endDate+
            "&refundAmt="+refundAmt;

    }
});

$("#query").bind("click",function(){
    if(getParam()){
        window.location.href= window.basePath+"/tps/refundUserOrder/list?origOrderNo="+origOrderNo+
        "&startDate="+startDate+"&endDate="+endDate+
        "&refundAmt="+refundAmt;
    }
});

function getParam() {
    origOrderNo = $.trim($("#origOrderNo").val());
    startDate = $.trim($("#startDate").val());
    endDate = $.trim($("#endDate").val());
    refundAmt = $.trim($("#refundAmt").val());

    var longStartDate = parseInt(new Date(Date.parse(startDate)).getTime());
    var longEndDate = parseInt(new Date(Date.parse(endDate)).getTime());
    if(startDate!=''  && endDate==''){
        layer.msg("打款结束时间不能为空!", {time:1500});
        return false;
    }
    if(startDate==''  && endDate!=''){
        layer.msg("打款开始时间不能为空!", {time:1500});
        return false;
    }
    if (longStartDate > longEndDate){
        layer.msg("打款开始时间不能晚于结束时间!", {time:1500});
        return false;
    }
    var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    if (refundAmt!='' && !reg.test(refundAmt)) {
        layer.msg("金额有误!", {time:1500});
        return false;
    }
    return true;
}

//导出
$("#export").bind("click",function () {
    if(getParam()){
        var src = window.basePath+"/tps/refundUserOrder/export?origOrderNo="+origOrderNo+
        "&startDate="+startDate+"&endDate="+endDate+
        "&refundAmt="+refundAmt;
        $("#hidden_iframe").attr("src",src);
    }
});




