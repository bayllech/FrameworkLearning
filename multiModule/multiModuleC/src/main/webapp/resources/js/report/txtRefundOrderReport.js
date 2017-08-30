/**
 * 方法名:天下通退款订单统计
 * Author: lei.zhang
 * createTime: 2017/8/2 14:31
 */
var orderNo ='';
var refundFailStartTime = '';
var refundFailEndTime ='';
var thirdRefundAmt ='';

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
        window.location.href= window.basePath+"/tps/txnTicketRefundOrder/list?p="+page+"&jumpPage="+page+
            "&orderNo="+orderNo+"&refundFailStartTime="+refundFailStartTime+"&refundFailEndTime="+refundFailEndTime+"&thirdRefundAmt="+thirdRefundAmt;
    }
});

$("#query").bind("click",function(){
    if(getParam()){
        window.location.href= window.basePath+"/tps/txnTicketRefundOrder/list?orderNo="+orderNo+
            "&refundFailStartTime="+refundFailStartTime+"&refundFailEndTime="+refundFailEndTime+"&thirdRefundAmt="+thirdRefundAmt;
    }
});


function getParam() {
    orderNo = $.trim($("#orderNo").val());
    // var longOutTicketStartTime = parseInt(new Date(Date.parse(outTicketStartTime)).getTime());
    // var longOutTicketEndTime = parseInt(new Date(Date.parse(outTicketEndTime)).getTime());
    // if(outTicketStartTime!=''  && outTicketEndTime==''){
    //     layer.msg("出票失败结束时间不能为空!", {time:1500});
    //     return false;
    // }
    // if(outTicketEndTime==''  && outTicketEndTime!=''){
    //     layer.msg("出票失败开始时间不能为空!", {time:1500});
    //     return false;
    // }
    // if (longOutTicketStartTime > longOutTicketEndTime){
    //     layer.msg("出票失败开始时间不能晚于结束时间!", {time:1500});
    //     return false;
    // }
    refundFailStartTime = $.trim($("#refundFailStartTime").val());
    refundFailEndTime = $.trim($("#refundFailEndTime").val());
    var longRefundFailStartTime = parseInt(new Date(Date.parse(refundFailStartTime)).getTime());
    var longRefundFailEndTime = parseInt(new Date(Date.parse(refundFailEndTime)).getTime());
    if(refundFailStartTime!=''  && refundFailEndTime==''){
        layer.msg("出票失败款退回结束时间不能为空!", {time:1500});
        return false;
    }
    if(refundFailStartTime==''  && refundFailEndTime!=''){
        layer.msg("出票失败款退回开始时间不能为空!", {time:1500});
        return false;
    }
    if (longRefundFailStartTime > longRefundFailEndTime){
        layer.msg("出票失败款退回开始时间不能晚于结束时间!", {time:1500});
        return false;
    }
    // refundApplyStartTime = $.trim($("#refundApplyStartTime").val());
    // refundApplyEndTime = $.trim($("#refundApplyEndTime").val());
    // var longRefundApplyStartTime = parseInt(new Date(Date.parse(refundApplyStartTime)).getTime());
    // var longRefundApplyEndTime = parseInt(new Date(Date.parse(refundApplyEndTime)).getTime());
    // if(refundApplyStartTime!=''  && refundApplyEndTime==''){
    //     layer.msg("退票申请结束时间不能为空!", {time:1500});
    //     return false;
    // }
    // if(refundApplyStartTime==''  && refundApplyEndTime!=''){
    //     layer.msg("退票申请开始时间不能为空!", {time:1500});
    //     return false;
    // }
    // if (longRefundApplyStartTime > longRefundApplyEndTime){
    //     layer.msg("退票申请开始时间不能晚于结束时间!", {time:1500});
    //     return false;
    // }
    thirdRefundAmt = $.trim($("#thirdRefundAmt").val());
    var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    if (thirdRefundAmt!='' && !reg.test(thirdRefundAmt)) {
        layer.msg("金额有误!", {time:1500});
        return false;
    }
    return true;
}

//导出
$("#export").bind("click",function () {
    if(getParam()){
        var src = window.basePath+"/tps/txnTicketRefundOrder/export?orderNo="+orderNo+
            "&refundFailStartTime="+refundFailStartTime+"&refundFailEndTime="+refundFailEndTime+"&thirdRefundAmt="+thirdRefundAmt;
        $("#hidden_iframe").attr("src",src);
    }
});




