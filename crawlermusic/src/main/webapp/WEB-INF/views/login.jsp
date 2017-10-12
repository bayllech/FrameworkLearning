
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    request.setAttribute("ctx", ctx);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>联璧港运营管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>
    <meta name="robots" content="noindex,nofollow"/>
    <script type="text/javascript" src="${ctx}/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/jquery.cookie.js"></script>
    <link href="${ctx}/resources/css/login_style.css" rel="stylesheet" media="screen"/>
</head>

<body class="loginWeb" onkeydown="if(event.keyCode==13){login()}">
<div id="main">
    <div class="login_box">

        <h1>登录</h1>
        <div class="login">
            <span id="msg" style="color:red;">${msg} </span><br/>
            <dl>
                <dt>账号</dt>
                <dd><input type="text" id="user_pin" value="tom" name="pin"/></dd>
            </dl>
            <dl>
                <dt>密码</dt>
                <dd><input type="password" id="user_pwd" value="123123" name="password"/></dd>
            </dl>
        </div>
        <input type="button" id="user_login_but" class="login_but"  onclick="login()" value="立即登录"/>

    </div>
</div>

<script type="text/javascript">

    // 登录页面若在框架内，则跳出框架
    if (self != top) {
        top.location = self.location;
    }
    ;


    function  login () {
        var pin = $.trim($("#user_pin").val());
        var pwd = $.trim($("#user_pwd").val());
        var imgCode = $.trim($("#captcha").val());
        if (pwd == '' || pin == '') {
            $("#msg").text('请完整输入登录账号、密码');
            return false;
        }
        submit(pin, pwd);
    }

    function submit(pin, pwd) {
        $("#msg").text('');
        $.ajax({
            url: "login",
            type: "POST",
            data: {
                username: pin,
                password: pwd
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == "000000") {
                    window.location.href = "/main";
                }else {
                    $("#msg").text(data.msg);
                }
            },
            timeout: 30000,
            error: function () {
                $("#msg").text('请检查网络连接是否正常！');
            }
        });
    }
</script>
</body>
</html>