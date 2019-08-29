<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市区级联</title>
<style>
	select{
		width: 155px;
	}
</style>
<script type="text/jscript" src="js/ProCityArea.js" language="javascript"></script>
</head>
<body>
    <span> 选择省</span>
    <span>
        <select id="selPro"> 
        </select>
    </span>
    <span> 选择市</span>
    <span >
        <select id="selCity"> 
        </select>
    </span>
    <span> 选择区</span>
    <span >
        <select id="selArea"> 
        </select>
    </span>

</body>
</html>
