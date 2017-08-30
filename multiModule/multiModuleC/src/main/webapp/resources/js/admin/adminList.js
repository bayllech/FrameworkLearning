/**
 * 方法名:管理员列表
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
    window.location.href= window.basePath+"/tps/admin/list?p="+page+"&jumpPage="+page;
});

//添加按钮事件
$(".btn_Add").click(function () {
    window.location.href = window.basePath+"/tps/admin/toAdd";
});


//关闭事件
function closeDivFun(){
    $('.adminPopup').hide();
    $('#popDiv').hide();
}

//删除事件
var adminId = "";
$(".del").bind("click",function(){
    $('.adminPopup').show();
    $('#popDiv').show();
    adminId = $(this).attr("data-id");
});

$("#delOk").bind("click",function(){
    $.ajax({
        url: window.basePath+"/tps/admin/delete",
        data:{
            "adminId":adminId
        },
        dataType:"JSON",
        type:"POST",
        success: function (d) {
            if(d.code == '000000') {
                document.getElementById('popDiv').style.display='none';
                layer.msg(d.msg, {time:2000});
                setTimeout(function() {
                    window.location.href = window.basePath+"/tps/admin/list";
                }, 500)
            } else{
                document.getElementById('popDiv').style.display='none';
                layer.msg(d.msg, {time:2000});
            }
            $('.adminPopup').hide();
        }
    });
});





