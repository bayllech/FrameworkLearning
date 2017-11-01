<%--
  User: bei.qi
  Date: 2017-11-01  13:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UserInfoList</title>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/jquery.dataTables.css">
    <%--<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-table.css">--%>
    <script src="/resources/js/jquery.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.js"></script>
    <script src="/resources/bootstrap/js/jquery.dataTables.js"></script>
<%--    <script src="/resources/bootstrap/js/bootstrap-table.js"></script>
    <script src="/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>--%>
</head>
<body>

<table class="" id="tb_departments">
    <thead>
        <tr>
            <th data-field="name">姓名</th>
            <th data-field="sex">性别</th>
            <th data-field="age">年龄</th>
            <th data-field="nation">民族</th>
            <th data-field="adredd">住址</th>
            <th data-field="email">Email</th>
            <th data-field="tel">电话</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>
</body>

<script>

    $(document).ready(function() {
        $('#tb_departments').DataTable( {
            "ajax": "/info/info.json",
            "columns": [
                { "data": "name" },
                { "data": "sex" },
                { "data": "age" },
                { "data": "nation" },
                { "data": "addredd" },
                { "data": "email" },
                { "data": "tel" }
            ]
        } );
    } );



/*    $(function () {

        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

    });


    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#tb_departments').bootstrapTable({
                url: '/info/info.json',         //请求后台的URL（*）
                method: 'post',                      //请求方式（*）
//                toolbar: '#toolbar',                //工具按钮用哪个容器
//                striped: true,                      //是否显示行间隔色
//                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
//                sortable: false,                     //是否启用排序
//                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
//                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50],             //可供选择的每页的行数（*）
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                dataType:"json",
                columns: [{
                    checkbox: true
                }, {
                    field: 'name',
                    title: '姓名'
                }, {
                    field: 'sex',
                    title: '性别'
                }, {
                    field: 'nation',
                    title: '民族'
                }, {
                    field: 'age',
                    title: '年龄'
                },{
                    field: 'email',
                    title: 'Email'
                },{
                    field: 'tel',
                    title: '电话'
                }]
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                name: $("#txt_search_departmentname").val()
            };
            return temp;
        };
        return oTableInit;
    };


    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };

        return oInit;
    };*/

</script>

</html>
