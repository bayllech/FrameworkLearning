/**
 * 方法名:登录
 * Author: lei.zhang
 * createTime: 2017/8/2 14:31
 */
(function (win, $) {
    $("#imgCode").click(function () {
        $(this).attr("src", "/verifyCodeImg?a=" + Math.random());
    });

    $(".btn_sub").click(function () {
        login();
    });

    function login() {
        var loginNo = $.trim($("#loginNo").val());
        var pwd = $.trim($("#pwd").val());
        var cookidCode = $.cookie("checkCode");
        var veriCode = $.trim($("#veriCode").val());
        if (loginCheck(loginNo, pwd, cookidCode, veriCode)) {
            ajaxLogin(loginNo, pwd, veriCode);
        }
    }

    function loginCheck(loginNo, pwd, cookidCode, veriCode) {
        if (loginNo == '') {
            layer.msg("账号不能为空", {time: 2000});
            return false;
        }
        if (pwd == '') {
            layer.msg("密码不能为空", {time: 2000});
            return false;
        }
        if (veriCode == '') {
            layer.msg("验证码不能为空", {time: 2000});
            return false;
        }
        if($.cookie("checkCode")==undefined){
            layer.msg("验证码已过期", {time: 2000});
            return false;
        }
        if (veriCode.toLowerCase() != cookidCode.toLowerCase()) {
            layer.msg("验证码不正确", {time: 2000});
            return false;
        }
        return true;
    }

    function ajaxLogin(loginNo, pwd, veriCode) {
        var sumBut = $(".btn_sub");
        if (sumBut.attr("ajaxTime")) {
            return false;
        } else {
            sumBut.attr("ajaxTime", "ajaxTime");
            $.ajax({
                url: window.basePath + "/tps/admin/login",
                data: {
                    "loginNo": loginNo,
                    "pwd": pwd,
                    "code": veriCode
                },
                dataType: "JSON",
                type: "POST",
                success: function (data) {
                    sumBut.removeAttr("ajaxTime");
                    if (data.code == '000000') {
                        layer.msg(data.msg, {time: 1500});
                        setTimeout(function() {
                            $("#loginComForm").submit();
                        }, 500)
                    } else {
                        layer.msg(data.msg, {time: 1500});
                    }
                },
                timeout: 15000,
                error: function () {
                    sumBut.removeAttr("ajaxTime");
                    layer.msg("连接服务器失败，请检查网络连接!", {time: 1500});
                }
            });
        }
    }

    $(win.document.body).bind("keydown", function (e) {
        if (e.keyCode == 13) {
            login();
            return false;
        }
    });

})(window, jQuery);