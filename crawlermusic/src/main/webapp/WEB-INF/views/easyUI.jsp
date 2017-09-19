<%--
  User: bei.qi
  Date: 2017-09-18  9:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EasyUI</title>
    <link rel="stylesheet" type="text/css" href="/resources/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/resources/easyui/themes/icon.css">
    <script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/resources/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<input id="pwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true"/>
<br>
<input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"
       required="required" validType="equals['#pwd']"/>
<br>
<div id="ccc" class="easyui-calendar" style="width:180px;height:180px;"></div>
<div id="pp" class="easyui-pagination" data-options="total:2000,pageSize:10"
     style="background:#efefef;border:1px solid #ccc;">
</div>
<br>
<table id="dg" class="easyui-datagrid" style="width:400px;height:250px"
       data-options="fitColumns:true,singleSelect:true,border:false,">
    <thead>
    <tr>
        <th data-options="field:'url',width:100">编码</th>
        <th data-options="field:'title',width:100">名称</th>
        <th data-options="field:'commentCount',width:100,align:'right'">价格</th>
    </tr>
    </thead>
</table>

<input id="cc" class="easyui-combobox" name="dept"
       data-options="valueField:'id',textField:'text',url:'/getCCData'"/>
<select id="ss" class="easyui-combotree" style="width:200px;"
                data-options="url:'/getTreeData'"></select>


<script>
    (function () {
        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function (value, param) {
                    return value == $(param[0]).val();
                },
                message: '密码不一致'
            }
        });

        $('#cc').calendar({
            onSelect: function (date) {
                alert(date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate());
            }
        });

        $('#pp').pagination({
            pageList: [10, 20, 50, 100],
            total: 114,
            buttons: [{
                iconCls: 'icon-add',
                handler: function () {
                    alert('add')
                }
            }, '-', {
                iconCls: 'icon-save',
                handler: function () {
                    alert('save')
                }
            }]
        });

        /*       $('#dg').datagrid({
                   url:'/data',
                   loadMsg : 'Loading',
                   idField: 'id',
                   pageSize : 50,
                   autoRowHeight : false,
                   singleSelect : true,
                   border : false,
                   striped : true,
               });*/
        setTimeout(loaddata, 50);

        //加载某列排序的数据
        function loaddata() {
            $.getJSON("http://localhost:/data", {}, function (result) {
                rows = result.lists;
                $("#dg").datagrid('loadData', rows);
            });
        };



    })();

</script>

</body>
</html>
