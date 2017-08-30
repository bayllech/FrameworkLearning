/**
 * 方法名:添加管理员
 * Author: lei.zhang
 * createTime: 2017/8/2 14:31
 */
//返回
$(".return").click(function(){
    window.location.href = window.basePath+"/tps/admin/list";
});

//确定
$(".sure").click(function () {
    var roleId = $("#roleId").val();
    if (roleId==0){
        layer.msg("请选择角色!", {time:1500});
        return;
    }
    var loginNo = $("#LoginNo").val().trim();
    if(loginNo==''){
        layer.msg("用户名不能为空!", {time:1500});
        return;
    }
    if(loginNo.length > 20){
        layer.msg("账号不能超过20位!", {time:1500});
        return;
    }
    var pwd = $("#pwd").val().trim();
    if (pwd==''){
        layer.msg("密码不能为空!", {time:1500});
        return;
    }
    if(pwd.length < 6 || pwd.length > 20){
        layer.msg("密码长度6-20位!", {time:1500});
        return;
    }
    var sumBut = $(this);
    if (sumBut.attr("ajaxTime")) {
        return false;
    } else {
        sumBut.attr("ajaxTime", "ajaxTime");
        $.ajax({
            url: window.basePath+"/tps/admin/add",
            data:{
                "roleId":roleId,
                "loginNo":loginNo,
                "pwd":pwd
            },
            dataType:"JSON",
            type:"POST",
            success: function (d) {
                if(d.code == '000000') {
                    layer.msg(d.msg, {time:2000});
                    sumBut.removeAttr("ajaxTime");
                    setTimeout(function() {
                        window.location.href = window.basePath+"/tps/admin/list";
                    }, 500)
                } else{
                    layer.msg(d.msg, {time:2000});
                    sumBut.removeAttr("ajaxTime");
                }
            }
        })
    }
});






