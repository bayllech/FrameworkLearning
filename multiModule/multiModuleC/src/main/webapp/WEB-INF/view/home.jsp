<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
</head>
<body>
    <input type="text" id="loginNo" placeholder="请输入账号"/>
    <input type="password" id="pwd" placeholder="请输入密码"/>
    <input type="submit" id="btn_sub" value="登入"/>

</body>
<script src="https://cdn.staticfile.org/jquery/2.2.3/jquery.min.js"></script>
<script>
    $(function () {
        $("#btn_sub").click(function () {
            var loginNo = $("#loginNo").val();
            var pwd = $("#pwd").val();
            alert("loginNo=" + loginNo);
            $.ajax({
                url: "/home",
                data: {
                    "loginNo": loginNo,
                    "pwd": pwd
                },
                dataType: "JSON",
                type: "POST"
            });
        });
    });
</script>
</html>