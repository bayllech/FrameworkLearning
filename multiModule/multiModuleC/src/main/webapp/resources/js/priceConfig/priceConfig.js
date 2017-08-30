$(".button").bind('click',function () {
    var r = /^([1-9]\d?|100)$/;　　//0-100的正整数
    var priceConfigNum = $("#priceConfigNum").val();
    if(!r.test(priceConfigNum)){
        layer.msg("请输入1~100的正整数！", {time:2000});
        return;
    }

    $.ajax({
        url: window.basePath+"/tps/priceConfig/priceConfig",
        data:{
            "priceConfigNum":priceConfigNum
        },
        dataType:"JSON",
        type:"POST",
        success: function (d) {
            if(d.code == '000000') {
                layer.msg(d.msg, {time:2000});
            } else{
                layer.msg(d.msg, {time:2000});
            }
        }
    });
});