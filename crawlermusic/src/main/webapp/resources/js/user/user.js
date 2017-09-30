window.ajaxStatus = 1;

/**
 * 修改用户状态
 * @param id
 * @param state
 */
function editUserState(id, state) {
    $.ajax({
        url:"editUserState",
        data:{
            "id":id,
            "status":state
        },
        dataType:"JSON",
        type:"POST",
        success: function (data) {
            if(data.code == '000000') {
                $.messager.show({
                    title:"提示",
                    msg:"操作成功",
                    timeout:5000
                });
                $("#userListContent").datagrid("reload");
            } else {
                $.messager.alert("提示", data.msg, "error");
            }
        },
        timeout:15000,
        error:function () {
            $.messager.alert("提示", "连接服务器失败,请检查网络连接！", "warning");
        }
    });
}

/**
 *  停用用戶
 */
function disableUser(id) {
    $.messager.confirm("提示", "你确定要停用该用户吗？", function(bool){
        if(bool)
            editUserState(id, 0);
    });
}

/**
 *启用用户
 */
function enableUser(id) {
    $.messager.confirm("提示", "你确定要启用该用户吗？", function(bool){
        if(bool)
            editUserState(id, 1);
    });
}

function getUserById(id) {
    var dataList = $("#userListContent").datagrid("getRows");
    var user  = undefined;
    if(dataList) {
        for(var i=0; i<dataList.length; ++i) {
            var user = dataList[i];
            if(user.id == id) {
                u = user;
                break;
            }
        }
    }
    return user;
}

/**
 * 修改用户信息
 */
function editUser(id) {
    // var user = getUserById(id);
    $.ajax({
        url:"toEdit",
        data:{
            "id":id
        },
        dataType:"JSON",
        type:"POST",
        success: function (d) {
            if(d.code == '000000') {
                $("#edis_user_id").val(d.user.id);
                $("#edit_username").textbox("setValue", d.user.username);
                $("#edit_username").textbox("readonly", true);
                $("#edisUserPassword").hide();
                user_roles();
                $("#edis_password").textbox("setValue", d.user.password);
                $("#edit_user").dialog("setTitle", "编辑用户");
                $("#edit_user").dialog("open");
            } else{
                $.messager.alert("提示", d.msg, "error");
            }
        }
    })
   /* if(user) {
        $("#edis_user_id").val(user.id);
        $("#edit_username").textbox("setValue", user.username);
        $("#edit_username").textbox("readonly", true);
        $("#edisUserPassword").hide();
        user_roles();
        $("#edis_password").textbox("setValue", user.password);
        $("#edit_nickname").textbox("setValue", user.nickname);
        $("#edit_user").dialog("setTitle", "编辑用户");
        $("#edit_user").dialog("open");
    }*/
}

/**
 *  添加用戶信息
 */
function addUserInfo() {
    $("#edis_user_id").val("");
    $("#edit_username").textbox("clear");
    $("#edis_password").textbox("clear");
    $("#edisUserPassword").show();
    user_roles();
    $("#edit_username").textbox("readonly", false);
    $("#edit_user").dialog("setTitle", "新增用户");
    $("#edit_user").dialog("open");
}

function  user_roles() {
    var url = "getAllRoles";
    $.getJSON(url, function(json) {
        $('#user_roles').combobox({
            data : json.roleList,
            valueField:'id',
            textField:'roleName',
            panelHeight:'auto'
        });
    });
}
/**
 * 编辑
 */
function editUserInfo() {
    var username = $.trim($("#edit_username").textbox("getText"));
    var password = $.trim($("#edis_password").textbox("getText"));
    var roleId =  $.trim($("#user_roles").combobox('getValue'));
    var id = $.trim($("#edis_user_id").val());

    if(username.length < 1 ) {
        $.messager.alert("提示", "用户名不能少于1位!", "info");
        $("#edit_username").focus();
        return false;
    }

    if(username.length > 32 ) {
        $.messager.alert("提示", "用户名不能大于32位!", "info");
        $("#edit_username").focus();
        return false;
    }

    if(roleId.length == 0 ) {
        $.messager.alert("提示", "角色为必选项!", "info");
        $("#user_roles").focus();
        return false;
    }

    if(id.length == 0) {  //新增用户
        if(password.length < 6) {
            $.messager.alert("提示", "密码不能少于6位!", "info");
            $("#edis_password").focus();
            return false;
        }
        if(password.length > 32) {
            $.messager.alert("提示", "密码不能多于32位!", "info");
            $("#edis_password").focus();
            return false;
        }
    } else {
        password = ""; //不修改密码
    }


    if(nickname == '') {
        $.messager.alert("提示", "姓名不能为空!", "info");
        $("#edit_nickname").focus();
        return false;
    }
    if(nickname.length > 32) {
        $.messager.alert("提示", "姓名不能多于32位", "info");
        $("#edit_nickname").focus();
        return false;
    }

    if(window.ajaxStatus ) {
        window.ajaxStatus = 0;
        $.ajax({
            url:"edit",
            type:"POST",
            data:{
                "id":$.trim($("#edis_user_id").val()),
                "username":username,
                "password":password,
                "roleId":roleId
            },
            dataType:"JSON",
            success: function (data) {
                window.ajaxStatus = 1;
                if(data.code == '000000') {
                    $.messager.show({
                        title:"提示",
                        msg:"操作成功",
                        timeout:3000
                    });
                    $("#edit_user").dialog("close");
                    $("#userListContent").datagrid("reload");
                }else {
                    $.messager.alert("提示", data.msg, "error");
                }
            } ,
            timeout:15000,
            error:function () {
                window.ajaxStatus = 1;
                $.messager.alert("提示", "连接服务器失败，请检查网络连接", "question");
            }
        });
    }
}

$(function () {

    $("#search_user_but").bind("click", function () {
        $("#userListContent").datagrid("reload", $("#searchUserList").serializeObject() );
    });


    $("#remove_user").bind("click", function () {
        var ids = "";
        var userArray = $("#userListContent").datagrid("getSelections");
        if(userArray != "") {
            for(var i=0; i<userArray.length; ++i) {
                if(ids != '')
                    ids += ",";
                ids+=userArray[i].id;
            }
            $.messager.confirm("提示", "你确定要删除吗？", function(bool){
                if(bool){
                    $.ajax({
                        url:"del",
                        data:{
                            ids:ids
                        },
                        type:"post",
                        dataType:"JSON",
                        success: function (data) {
                            if(data.code == '000000') {
                                $.messager.show({
                                    title:'提示',
                                    msg:"删除用户成功！",
                                    timeout:3000
                                });
                                $("#userListContent").datagrid("reload");
                            } else {
                                $.messager.alert("提示", data.msg, "warning");
                            }
                        }
                    })
                }
            })

        } else {
            $.messager.alert("提示", "请选择你要删除的行！", "warning");
        }
    });

    $("#userListContent").datagrid({
        url:"getUserList",
        fitColumns:true,
        toolbar:"#searchUserList",
        idField:"id",
        loadMsg:"正在加载",
        pagination:true,
        ctrlSelect:true,
        rownumbers:true,

        columns:[[{
            field:"username",
            sortable:true,
            title:"用户名",
            align:"center",
            width:300
        },
            {
            field:"status",
            title:"状态",
            width:200,
            align:"center",
            formatter: function (value) {
                if(value == 0) {
                    return "<lable style='color:red;'>已停用</lable>";
                } else if(value == 1) {
                    return "正常";
                } else {
                    return "未知状态";
                }
            }
        },{
            field:"op",
            title:"操作",
            align:"center",
            width:200,
            formatter: function (id, obj) {
                var str = "";
                if(obj.status == 0) {
                    str = "<a href='javaScript:;' onclick='enableUser(" + obj.id+");return false;'>启用</a>&nbsp;&nbsp;<label style='color: #CCC;'>|</label>&nbsp;&nbsp;";
                } else if(obj.state == 1) {
                    str = "<a href='javaScript:;' onclick='disableUser(" + obj.id +"); return false;'>停用</a>&nbsp;&nbsp;<label style='color: #CCC;'>|</label>&nbsp;&nbsp;";
                }
                str += "<a href='javaScript:;' onclick='editUser(" +obj.id+");'>编辑</a>";
                return str;
            }
        }]]
    });
});