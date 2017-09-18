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
    <input id="pwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true" />
    <br>
    <input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"
           required="required" validType="equals['#pwd']" />
    <br>
    <div id="cc" class="easyui-calendar" style="width:180px;height:180px;"></div>
    <div id="pp" class="easyui-pagination" data-options="total:2000,pageSize:10"
         style="background:#efefef;border:1px solid #ccc;">
    </div>



    <script>
        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '密码不一致'
            }
        });

        $('#cc').calendar({
            onSelect: function(date){
                alert(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
            }
        });

        $('#pp').pagination({
            pageList: [10,20,50,100],
            total: 114,
            buttons: [{
                iconCls:'icon-add',
                handler:function(){alert('add')}
            },'-',{
                iconCls:'icon-save',
                handler:function(){alert('save')}
            }]
        });


    </script>

</body>
</html>
