<%--
  Created by IntelliJ IDEA.
  User: qaedw
  Date: 2017/9/5
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<html>
<head>
    <title>联璧港运营管理系统</title>
    <script type="text/javascript" src="${ctx}/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/resources/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="${ctx}/resources/js/clipboard/clipboard.min.js"/>
    <link rel="stylesheet" href="${ctx}/resources/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="${ctx}/resources/css/loyout.css"/>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false,border:false" style="height:71px;" class="header">
    <div class="header_right">
        <div class="ranklist-box">
            <div class="ranklist" id="todo_list_scroll">
                <ul class="ul2" id="todo_list_scroll_ul"></ul>
            </div>
        </div>
        <div>
            <img src="${ctx}/resources/images/header_icon1.jpg" alt="">${curr_user.username},您好！欢迎登录联壁港！
        </div>
        <span></span>
        <a href="javascript:;" id="chgpwd" onclick="chgpwd();">
            <img src="${ctx}/resources/images/header_icon2.jpg" onclick="chgpwd();" alt="">修改密码</a>
        <a href="/logout">
            <img src="${ctx}/resources/images/header_icon3.jpg" alt="">退出
        </a>
    </div>

</div>
<div data-options="region:'west',split:true,title:'导航菜单',border:false" style="width: 260px;height: auto;"
     class="easyui-layout" id="layout">
    <div class="main">
        <div class="left_menu">


                <dl>
                    <dt class="sys-menu-bar">
                            <span>
                                <img src="${ctx}/resources/images/menu_icon9.png" alt="" class="menu_icon" style="display: inline-block;">
                                <img src="${ctx}/resources/images/menu_icon9_cur.png" alt="" class="menu_icon_cur" style="display: none;">
                            </span>
                        <a href="javaScript:;">系统管理</a>
                    </dt>

                        <shiro:hasRole name="admin">
                            <dd>
                                <a href="javaScript:;" onclick="addTabIframe('${ctx}/user/showUserList','用户管理')">用户管理</a>
                            </dd>
                        </shiro:hasRole>

                        <dd>
                            <a href="javaScript:;" onclick="addTabIframe('${ctx}/role/showRoleList','角色管理')">角色管理</a>
                        </dd>
                </dl>

        </div>
    </div>
</div>
<div data-options="region:'center',border:false" style="padding:5px;background:#eee;">
    <div id="center_tabs" class="easyui-tabs" data-options="fit:true">
        <div title="首页" data-options="fit:true,border:true">
            首页
        </div>
    </div>
</div>
<%--修改密码弹窗--%>
<!-- 编辑用户信息弹窗 -->
<div id="chg_pwd" class="easyui-dialog"
     data-options="closed:true,buttons:[{text:'保存',iconCls:'icon-edit', handler:function(){chgpwdInfo();}},{text:'取消',iconCls:'icon-clear', handler: function(){$('#chg_pwd').dialog('close');}}]"
     title="修改密码" style="width: 350px; height: 250px;">
    <form>
        <input type="hidden" id="chgpwd_user_id" value="${curr_user.id}">
        <div style="margin-top: 20px;">
            <span style="width: 70px; text-align: right;padding-right: 10px;display: inline-block;">原始密码:</span>
            <input type="password" class="easyui-textbox" id="old_pwd" maxlength="12"
                   style="width:200px" name="old_pwd">
        </div>
        <div style="margin-top: 20px;">
            <span style="width: 70px; text-align: right;padding-right: 10px;display: inline-block;">新密码:</span>
            <input type="password" class="easyui-textbox" id="new_pwd" maxlength="12"
                   style="width:200px" name="new_pwd">
        </div>
        <div style="margin-top: 20px;">
            <span style="width: 70px; text-align: right;padding-right: 10px;display: inline-block;">重复密码:</span>
            <input type="password" class="easyui-textbox" id="rnew_pwd" maxlength="12"
                   style="width:200px" name="rnew_pwd" validType="equals['#new_pwd']">
        </div>
    </form>
</div>
<%--修改密码弹窗结束--%>
<script type="text/javascript" src="${ctx}/resources/js/content.js"></script>
<script type="text/javascript">
    window.ctx = "${ctx}";
    window.ajaxStatus = 1;

    function addTabIframe(url, title, refresh) {

        if ($("#center_tabs").tabs("exists", title)) {
            $("#center_tabs").tabs("select", title);
            var currentTab = $('#center_tabs').tabs('getSelected');
            var id = "tabsiframe_" + (Math.random() + "").replace(".", "") + "_" + (new Date()).getTime();
            var str = "<iframe id='" + id + "' name='" + id + "' src='" + url + "'  width='100%' height='100%' frameborder=0></iframe>";
            $('#center_tabs').tabs('update', {
                tab: currentTab,
                options: {
                    content: str
                }
            });
            currentTab.panel('refresh');
        } else {
            var id = "tabsiframe_" + (Math.random() + "").replace(".", "") + "_" + (new Date()).getTime();
            var str = "<iframe id='" + id + "' name='" + id + "' src='" + url + "'  width='100%' height='100%' frameborder=0></iframe>";
            $("#center_tabs").tabs("add", {
                title: title,
                content: str,
                closable: true,
                onAdd: function (tbtitle, index) {
                    var contentWin = $("#" + id)[0].contentWindow;
                    if (contentWin.onTabCloseCallBack) {
                        $($("#" + id)).onunload(contentWin.onTabCloseCallBack);
                    }
                }
            });
        }
    }

    function chgpwd() {
        $("#old_pwd").textbox("clear");
        $("#new_pwd").textbox("clear");
        $("#rnew_pwd").textbox("clear");
        $("#chg_pwd").dialog("open");
    }

    function chgpwdInfo() {
        var oldpwd = $.trim($("#old_pwd").textbox("getText"));
        var newpwd = $.trim($("#new_pwd").textbox("getText"));
        var rnewpwd = $.trim($("#rnew_pwd").textbox("getText"));
        var id = $.trim($("#chgpwd_user_id").val());

        if (oldpwd.length < 6 || newpwd.length < 6 || rnewpwd.length < 6) {
            $.messager.alert("提示", "密码不能少于6位!", "info");
            return false;
        }
        if (oldpwd.length > 32 || newpwd.length > 32 || rnewpwd.length > 32) {
            $.messager.alert("提示", "密码不能多于32位!", "info");
            return false;
        }
        if (newpwd != rnewpwd) {
            $.messager.alert("提示", "两次密码不一致！", "info");
            return false;
        }

        if (window.ajaxStatus) {
            window.ajaxStatus = 0;
            $.ajax({
                url: "chgpwd",
                type: "POST",
                data: {
                    "id": id,
                    "oldpwd": oldpwd,
                    "newpwd": newpwd,
                    "rnewpwd": rnewpwd
                },
                dataType: "JSON",
                success: function (data) {
                    window.ajaxStatus = 1;
                    if (data.code == '000000') {
                        $.messager.show({
                            title: "提示",
                            msg: "修改成功",
                            timeout: 3000
                        });
                        $("#chg_pwd").dialog("close");
                        window.location.href = window.ctx + '/logout';
                    } else if (data.code == '010004') {
                        $.messager.show({
                            title: "提示",
                            msg: "用户不存在",
                            timeout: 3000
                        });
                    } else if (data.code == '010003') {
                        $.messager.show({
                            title: "提示",
                            msg: "原密码错误",
                            timeout: 3000
                        });
                    }
                },
                timeout: 15000,
                error: function () {
                    window.ajaxStatus = 1;
                    $.messager.alert("提示", "连接服务器失败，请检查网络连接", "question");
                }
            });
        }
    }

    (function () {
        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function (value, param) {
                    return value == $(param[0]).val();
                },
                message: '密码不一致'
            }
        });
    })();

</script>
</body>
</html>
