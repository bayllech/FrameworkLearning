<%--
  Created by IntelliJ IDEA.
  User: weicj01
  Date: 2017/9/13
  Time: 10:12
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
	<script type="text/javascript" src="${ctx}/resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${ctx}/resources/js/function.js"></script>
	<link rel="stylesheet" href="${ctx}/resources/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="${ctx}/resources/easyui/themes/icon.css" />
	<link rel="stylesheet" href="${ctx}/resources/css/common.css" />
	<script type="text/javascript" src="${ctx}/resources/js/jquery.cookie.js"></script>
</head>
<body>
