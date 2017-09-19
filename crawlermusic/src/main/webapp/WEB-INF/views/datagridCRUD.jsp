<%--
  User: bei.qi
  Date: 2017-09-18  9:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UserList</title>
    <link rel="stylesheet" type="text/css" href="/resources/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/resources/easyui/themes/icon.css">
    <script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/resources/easyui/jquery.easyui.min.js"></script>
</head>
<body>

<table id="dg" title="用户列表" class="easyui-datagrid" style="width:550px;height:250px" url="/getUserList"
       toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
        <tr>
            <th field="firstname" width="50">用户名</th>
            <th field="lastname" width="50">昵称</th>
            <th field="phone" width="50">Phone</th>
            <th field="email" width="50">Email</th>
        </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增用户</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
</div>



</body>
</html>
