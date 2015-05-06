<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
	<link id="easyuiTheme" type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css" />

<script type="text/javascript">
<!--




	$(function(){
		$('#dg').datagrid({   
		    url:'${pageContext.request.contextPath}/user_list.action',   
		    columns:[[   
		        {field:'id',title:'ID号'},
		        {field:'name',title:'名字'},
		        {field:'telephone',title:'电话'},		        
		        {field:'birthday',title:'生日'},   
		        {field:'sex',title:'性别'},
		        {field:'company',title:'公司'},   
		        {field:'salary',title:'工资'},
		        {field:'info',title:'备注'}
		    ]]
		});  
	});
-->
</script>
  </head>
  
<body>
	<table id="dg"></table>  

</body>
</html>
