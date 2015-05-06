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
  </head>
  
  <body>
  	<div title="用户登录" class="easyui-window" data-options="collapsible:false,
  	minimizable:false,maximizable:false,
  	closable:false,modal:false,draggable:false,resizable:false"
  	style="width:300px;"
  	>
  	
  	<s:form action="user_login" method="post" id="form">  	
  	<table>
		<tr>
			<th colspan="2" style="text-align:left;border-bottom:1px solid green;">
				<s:fielderror/>
				<s:actionerror/>			
			</th>
		</tr>  	
		<tr>
			<td><label for="name">用户名:</label></td>
			<td>
			  	<input name="name" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'用户名不能为空'" />
			</td>
		</tr>
		<tr>
			<td><label for="password">密　码:</label></td>
			<td>
			  	<input name="password" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'用户名不能为空'" />
			</td>
		</tr>
		<tr>
			<td><label for="validateCode">验证码:</label></td>
			<td>
			  	<input style="width:60px;" name="validateCode" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'验证码不能为空'" />
				<img style="cursor:pointer;" onclick="this.src='${pageContext.request.contextPath}/imageValidate.action?date='+Math.random()*1000" src="${pageContext.request.contextPath}/imageValidate.action"/>
			</td>
		</tr>		
		
		<tr>
			<td colspan="2">
			  	<a id="submit" onclick="$('#form')[0].submit();" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>  
			  	<a id="cancel" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>  
			</td>
		</tr>
  	</table>
  	</s:form>
  	</div>
  </body>
</html>
