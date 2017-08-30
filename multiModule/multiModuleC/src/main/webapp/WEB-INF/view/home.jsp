<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>

</head>
<body>
    <div>
        <form action="/home" method="post">
            <input type="text" name="loginNo" placeholder="请输入账号"/>
            <input type="password" name="pwd" placeholder="请输入密码">
            <button>登录</button>
        </form>
    </div>
</body>
</html>
