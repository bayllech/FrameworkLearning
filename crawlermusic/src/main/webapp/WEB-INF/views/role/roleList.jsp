<%--
  Created by IntelliJ IDEA.
  User: qaedw
  Date: 2017/9/6
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp" %>
<form id="searchUserList" class="search_toolbar">
    <div class="field">
        <label>角色名:</label><input class="easyui-textbox" name="roleName" value="" style="width:100px">
    </div>

    <div>
        <a id="search_user_but" class="easyui-linkbutton btn" data-options="iconCls:'icon-search'">搜索</a>
        <shiro:hasPermission name="addUser">
            <a id="add_user" class="easyui-linkbutton btn" data-options="iconCls:'icon-add'" onclick="addUserInfo();">新增用户</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="delUser">
            <a id="remove_user" class="easyui-linkbutton btn" data-options="iconCls:'icon-remove'">删除用户</a>
        </shiro:hasPermission>
    </div>
</form>
<div id="userListContent"></div>

<!-- 编辑用户信息弹窗 -->
<div id="edit_user" class="easyui-dialog"
     data-options="closed:true,buttons:[{text:'保存',iconCls:'icon-edit', handler:function(){editUserInfo();}},{text:'取消',iconCls:'icon-clear', handler: function(){$('#edit_user').dialog('close');}}]"
     title="编辑用户信息" style="width: 350px; height: 250px;">
    <form>
        <input type="hidden" id="edis_user_id" value="">
        <div style="margin-top: 20px;">
            <span style="width: 70px; text-align: right;padding-right: 10px;display: inline-block;">角色名:</span>
            <input class="easyui-textbox" id="edit_username" maxlength="12" style="width:200px" name="username">
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctx}/resources/js/role/role.js"></script>
<%@include file="../common/bottom.jsp" %>

