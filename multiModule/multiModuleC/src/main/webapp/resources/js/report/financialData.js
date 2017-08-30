/**
 * 方法名:财务报表
 * Author: lei.zhang
 * createTime: 2017年8月3日10:39:52
 */

//导出
var startDate='';
var endDate='';
$("#export").bind("click",function () {

    if(getParam()){
        var src = window.basePath+"/tps/financialData/export?startDate="+startDate+"&endDate="+endDate;
        $("#hidden_iframe").attr("src",src);
    }
});


function getParam() {
    startDate = $.trim($("#startDate").val());
    endDate = $.trim($("#endDate").val());
    var longStartDate = parseInt(new Date(Date.parse(startDate)).getTime());
    var longEndDate = parseInt(new Date(Date.parse(endDate)).getTime());
    if(startDate!=''  && endDate==''){
        layer.msg("结束时间不能为空!", {time:1500});
        return false;
    }
    if(startDate==''  && endDate!=''){
        layer.msg("开始时间不能为空!", {time:1500});
        return false;
    }
    if (longStartDate > longEndDate){
        layer.msg("开始时间不能晚于结束时间!", {time:1500});
        return false;
    }
    return true;
}



