<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'test.jsp' starting page</title>
    <%@include file="/WEB-INF/pages/public/commons.jspf" %>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<script type="text/javascript">
	<!--
	$(function(){
		$("#search").click(function(){
			var _form=$("#form")[0];
			_form.name.value=encodeWord(_form.name.value);
			_form.sex.value=encodeWord(_form.sex.value);
		
			
			var data=$("#form").serialize();
			
			//这里需要进行一下解码，不然表单字段的值会变成编码后的值，
			//这样如果重复按提交按钮，会把编码后的值再进行编码。

			_form.name.value=decodeWord(_form.name.value);
			_form.sex.value=decodeWord(_form.sex.value);

			
			$("#frame")[0].src="${pageContext.request.contextPath}/user_list.action?"+data;		
		});	
	
	});
	-->
	</script>

  </head>
  
	<body class="easyui-layout">  
	    <div data-options="region:'center'">
	    	<iframe id="frame" src="${pageContext.request.contextPath}/user_list.action" style="width:100%;height:100%;"></iframe>
	    </div>
	    <div data-options="region:'east',title:'用户查询',split:false" style="width:200px;">
	    	<form id="form">
	    		<label for="name">名字：</label><br/>
	    		<input name="name" class="easyui-validatebox"/><br/>  
	    		<label for="sex">性别：</label><br/>
	    		<select class="easyui-combobox" name="sex">  
				    <option value="" selected="selected">请选择</option>  
				    <option value="男">男</option>  
				    <option value="女">女</option>  
				</select>  
	    		<br/>
	    		<label for="beginBirthday">生日：</label><br/>
	    		<input name="beginBirthday" type="text" class="easyui-datebox" required="required"></input>
	    		<br/>
	    		<input name="endBirthday" type="text" class="easyui-datebox" required="required"></input>
	    		<br/>	    		
	    		<a id="search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>  
	    	</form>
	    </div>  
	</body>  
</html>
