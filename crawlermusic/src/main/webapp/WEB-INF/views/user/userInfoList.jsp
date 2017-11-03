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
    <%--<link rel="stylesheet" href="/resources/bootstrap/css/jquery.dataTables.css">--%>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-table.css">
    <script src="/resources/js/jquery.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.js"></script>
    <%--<script src="/resources/bootstrap/js/jquery.dataTables.js"></script>--%>
    <script src="/resources/bootstrap/js/bootstrap-table.js"></script>
    <script src="/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>

<div class="container" style="margin-top:20px">
    <div class="row">
        <div class="col-md-4">
            <div class="input-group">
                <span class="input-group-addon">姓名</span>
                <input type="text" class="form-control" placeholder="姓名" id="q_name">
            </div>
        </div>
        <div class="col-md-2">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon2">性别</span>
                <%--<input type="text" class="form-control" placeholder="性别" aria-describedby="basic-addon2" id="q_sex">  // aria-describedby  aria-*是为残障认识提供的描述--%>
                <select class="form-control" id="q_sex">
                    <option value="">请选择</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select>
            </div>
        </div>
        <div class="col-md-2">
            <button id="btn_search" type="button" class="btn btn-info">
                <span class="glyphicon glyphicon-search"></span>搜索
            </button>
        </div>

        <div class="col-md-1 col-md-offset-3 ">
            <button id="btn_add" type="button" class="btn btn-info" data-toggle="modal" data-target="#addModal">
                <span class="glyphicon glyphicon-plus"></span>新增
            </button>
        </div>

    </div>
</div>


<div class="container" style="margin-top: 20px">
    <table class="table" data-toggle="table" id="tb_departments" >
    </table>

</div>

<div class="modal fade" tabindex="-1" role="dialog" id="addModal" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增</h4>
            </div>
            <div class="modal-body">
               <form class="form-horizontal">
                   <input type="hidden"  class="form-control" name="id" id="id" >
                   <div class="form-group">
                       <label class="col-sm-2 control-label">姓名</label>
                       <div class="col-sm-6">
                           <input type="text" class="form-control" name="name" id="name" >
                       </div>
                   </div>

                   <div class="form-group">
                       <label class="col-sm-2 control-label">性别</label>
                       <div class="col-sm-4">
                           <select name="sex" id="sex" class="form-control">
                               <option value="1">男</option>
                               <option value="2">女</option>
                           </select>
                       </div>
                   </div>

                   <div class="form-group">
                       <label class="col-sm-2 control-label">民族</label>
                       <div class="col-sm-2">
                           <input type="text" class="form-control" name="native" id="native" >
                       </div>
                   </div>

                   <div class="form-group">
                       <label class="col-sm-2 control-label">年龄</label>
                       <div class="col-sm-2">
                           <input type="number" class="form-control" name="age" id="age" min="0" max="150" >
                       </div>
                   </div>

                   <div class="form-group">
                       <label class="col-sm-2 control-label">地址</label>
                       <div class="col-sm-6">
                           <input type="text" class="form-control" name="address" id="address" >
                       </div>
                   </div>

                   <div class="form-group">
                       <label class="col-sm-2 control-label">Email</label>
                       <div class="col-sm-6">
                           <input type="email" class="form-control" name="email" id="email" >
                       </div>
                   </div>

                   <div class="form-group">
                       <label class="col-sm-2 control-label">电话</label>
                       <div class="col-sm-6">
                           <input type="tel" class="form-control" name="tel" id="tel"  maxlength="14">
                       </div>
                   </div>

               </form>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<%--<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="/resources/images/header_icon1.jpg" alt="...">
            <div class="carousel-caption">
                <h3>第一张</h3>
                <p>描述</p>
            </div>
        </div>
        <div class="item active">
            <img src="/resources/images/header_icon2.jpg.jpg" alt="...">
            <div class="carousel-caption">
                <h3>第二张</h3>
                <p>描述</p>
            </div>
        </div>
        <div class="item active">
            <img src="/resources/images/header_icon3.jpg.jpg.jpg" alt="...">
            <div class="carousel-caption">
                <h3>第三张</h3>
                <p>描述</p>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>--%>


</body>

<script type="text/javascript">

    $('#tb_departments').bootstrapTable({
        url: '/info/info.json',         //请求后台的URL（*）
        cache: false,                       //是否使用缓存，默认为true，添加无用参数_
        method: "get",
        contentType: "application/x-www-form-urlencoded",
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "desc",                   //排序方式
        sortName: "id",
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50],             //可供选择的每页的行数（*）
        dataType: "json",
//            search: true,
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        queryParamsType: "undefined",
        queryParams: function (params) {
            var param = {
                p: params.pageNumber,
                pageSize: params.pageSize,
                sortName: params.sortName,
                sortOrder: params.sortOrder,
                name: $("#q_name").val(),
                sex: $("#q_sex").val()
            };
            return param;
        },
        //传递参数（*）
        columns: [{
            field: 'name',
            title: '姓名',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'sex',
            title: '性别',
            align: 'center',
            formatter: function (value, row) {
                if (row.sex == 1) {
                    return "男";
                } else {
                    return "女";
                }
            },
            valign: 'middle'

        }, {
            field: 'nation',
            title: '民族',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'age',
            title: '年龄',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'addredd',
            title: '地址',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'email',
            title: 'Email',
            align: 'center',
            valign: 'middle'

        }, {
            field: 'tel',
            title: '电话',
            align: 'center',
            valign: 'middle'
        }, {
            title: '操作',
            field: 'id',
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
                var e = '<a href="#"  onclick="edit(\'' + row.id + '\')">编辑</a> ';
                var d = '<a href="#" mce_href="#" onclick="del(\'' + row.id + '\')">删除</a> ';
                return e + d;
            }
        }]
    });


    //搜索页码重设
    $(function () {
        $("#btn_search").click(function () {
            $('#tb_departments').bootstrapTable("refreshOptions", {p: 1, pageSize: 10})
        })
    });

    //清除弹窗原数据
    $("#addModal").on("hidden.bs.modal", function() {
        $(".form-horizontal")[0].reset();
    });

    //提交表单
    $("#saveBtn").click(function () {
        var $id = $("#id").val();
        var $name = $("#name").val();
        var $sex = $("#sex").val();
        var $nation = $("#native").val();
        var $age = $("#age").val();
        var $address = $("#address").val();
        var $email = $("#email").val();
        var $tel = $("#tel").val();

        var url = "";

        if (!$name) {
            alert("姓名不能为空");
            return false;
        }

        if (!$id) {
            url = "/info/toAdd";
        } else {
            url = "/info/toEdit"
        }

        $.ajax({
            url: url,
            type: "post",
            dataType: "json",
            data:{
                "id":$id,
                "name":$name,
                "sex":$sex,
                "nation":$nation,
                "age":$age,
                "addredd":$address,
                "email":$email,
                "tel":$tel
            },
            success: function (data) {
                alert("添加成功");
                $(".modal").modal('hide');
                $('#tb_departments').bootstrapTable("refresh");
            },
            error: function () {
            }
        });


    });


    function edit(id) {
        $.ajax({
            url: "/info/getUser",
            type: "post",
            dataType: "JSON",
            data: {"id": id},
            success: function (data) {
//                $(".form-horizontal")[0].reset();
                $("#id").val(data.userInfo.id);
                $("#name").val(data.userInfo.name);
                $("#sex").val(data.userInfo.sex);
                $("#native").val(data.userInfo.nation);
                $("#age").val(data.userInfo.age);
                $("#address").val(data.userInfo.addredd);
                $("#email").val(data.userInfo.email);
                $("#tel").val(data.userInfo.tel);

                $(".modal").modal('show');
            },
            error: function () {
            }
        });
    }


    function del(id) {
        if (confirm("确定删除？")) {
            $.ajax({
                url: "/info/del",
                type: "post",
                dataType: "json",
                data: {"id": id},
                success: function (data) {
                    $('#tb_departments').bootstrapTable("refresh");
                },
                error: function () {
                }
            });
        }
    }

    /*    $(document).ready(function() {
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
        } );*/



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
