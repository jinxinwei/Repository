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
		$("#submit").click(function(){
			$('#form')[0].submit();
		});
	
	
	});
	-->
	</script>
  </head>
  
  <body style="margin:0px;">
  		<div>
  			<s:fielderror></s:fielderror>
  			<s:actionerror/>
  		</div>
       <s:form id="form" method="post" action="user_%{id==null?'add':'edit'}">
          <s:debug></s:debug>
           <table  width="95%" align="center">
           		<tr class="title"><td colspan="4">基本信息</td></tr>
           		<s:hidden name="id"></s:hidden>
	           	<tr><td>用户名:</td>
	           	<td>
	           		<s:textfield name="name" id="name" cssClass="easyui-validatebox" required="true"></s:textfield>
	           	</td>
					<td>口令:</td>
				<td>
					<input type="password" name="password" class=="easyui-validatebox" data-options="required:true"/>
				<tr class="title"><td colspan="4">其他信息</td></tr>
	           	<tr><td>工资:</td><td>
					<s:textfield name="salary" id="salary" cssClass="easyui-numberbox"></s:textfield>
					<td>生日:</td><td>
						<s:textfield name="birthday" id="birthday" cssClass="easyui-datebox"></s:textfield>
					</td></tr>
	           	<tr><td>性别:</td><td>
	           		<s:select list="{'男','女'}" headerKey="" headerValue="请选择" name="sex"  cssClass="easyui-combobox" cssStyle="width: 150px;"></s:select>
	           	</td>
					<td>单位:</td><td>
	           		<s:select list="{'总公司','分公司','厅点','基地运转中心','营业厅'}" headerKey="" headerValue="请选择" name="company" cssClass="easyui-combobox" cssStyle="width: 150px;"></s:select>
				</td></tr>
				<tr>
					<td>联系电话</td>
					<td colspan="3">
						<s:textfield name="telephone" cssClass="easyui-validatebox" required="true"></s:textfield>
					</td>
				</tr>
	           	<tr><td>备注:</td><td colspan="3">
	           		<s:textarea name="info" cssStyle="width:80%"></s:textarea><br/>
	           		<a id="submit" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a> 
	           	</td></tr>
           </table>
       </s:form>	
	  
  </body>
</html>
