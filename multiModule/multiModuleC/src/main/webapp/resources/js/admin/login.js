/**
 * 方法名:登录
 * Author: lei.zhang
 * createTime: 2017/8/2 14:31
 */
(function (win, $) {

    $(".btn_sub").click(function () {
        login();
    });

    function login() {
        var loginNo = $.trim($("#loginNo").val());
        var pwd = $.trim($("#pwd").val());
        if (loginCheck(loginNo, pwd)) {
            ajaxLogin(loginNo, pwd);
        }
    }

    function loginCheck(loginNo, pwd) {
        if (loginNo == '') {
            layer.msg("账号不能为空", {time: 2000});
            return false;
        }
        if (pwd == '') {
            layer.msg("密码不能为空", {time: 2000});
            return false;
        }
        return true;
    }

    function ajaxLogin(loginNo, pwd) {
        var sumBut = $(".btn_sub");
        if (sumBut.attr("ajaxTime")) {
            return false;
        } else {
            sumBut.attr("ajaxTime", "ajaxTime");
            $.ajax({
                url: "/home",
                data: {
                    "loginNo": loginNo,
                    "pwd": pwd
                },
                dataType: "JSON",
                type: "POST"
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