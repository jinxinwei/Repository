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
	            
	            
			$('#datagrid').datagrid({
					idField :'id',
					rownumbers:true,
					striped:true,   
					toolbar: [
					{
						text:'编辑',iconCls:'icon-edit',
						handler:function(){alert('编辑');}
					},'-',
					
					{
						text:'添加',
						iconCls: 'icon-add',
						handler: function(){
							window.location.href="${pageContext.request.contextPath}/user_addUI.action";
						}
					},'-',{
						text:'查询',
						iconCls: 'icon-search',
						handler: function(){alert('help')}
					},'-',{
						text:'删除',
						iconCls:'icon-remove',
						handler:function(){
							var datas=$('#datagrid').datagrid('getSelections');
							if(datas.length==0){
								$.messager.alert('警告信息','请选择要删除的信息!','warning');
								return;
							}
							$.messager.confirm('删除消息', '您是否真的要删除?', function(r){
								if (r){
									var ids="";
									var data=null;
									console.info(datas.length);
									
									for(var i=0;i<datas.length;i++){
										ids+="ids="+datas[i].id+"&";								
									}
									
									ids=ids.substring(0, ids.length-1);
									var url="${pageContext.request.contextPath}/user_delete.action";
									sendMessage(url,ids);						


								}
							});
	
						
						}
					}
					
					],
					onDblClickRow:function(rowIndex, rowData){
						console.info(rowIndex);
						console.info(rowData);
						window.location.href="${pageContext.request.contextPath}/user_editUI.action?id="+rowData.id;
					}		    
			}); 	            



			$("#pagination").pagination({   
			    total:<s:property value="%{#pageBean.recordsCount}"/>,
			    pageList: [10,30,50],   
			    pageSize:${pageSize},
			    pageNumber:${page},
			    onSelectPage:function(pageNumber,pageSize){

			    	$("#form")[0].page.value=pageNumber;
			    	$("#form")[0].pageSize.value=pageSize;

			    	var data=$("#form").serialize();
					window.location.href='${pageContext.request.contextPath}/user_list.action?'+data;


			    },
			    onChangePageSize:function(pageSize){
			    	console.info(pageSize);
			    	$("#form")[0].page.value=1;
			    	$("#form")[0].pageSize.value=pageSize;
			    	var data=$("#form").serialize();
					window.location.href='${pageContext.request.contextPath}/user_list.action?'+data;
			    }
			       
			});
			
			
  			
  		});
  	-->
  	</script>
  
  </head>
  
  <body style="margin:0px;">
  	<form id="form">
  		<input type="hidden" name="page" value="${page}"/>
  		<input type="hidden" name="pageSize" value="${pageSize}"/>
  		<input type="hidden" name="name" value="${name}"/>
  		<input type="hidden" name="sex" value="${sex}"/>
  		
  		
  		<s:hidden name="beginBirthday"></s:hidden>
  		<s:hidden name="endBirthday"></s:hidden>
  	</form>
	<table id="datagrid" class="easyui-datagrid">  
	    <thead>  
	        <tr>  
	            <th data-options="checkbox:true,field:'id'">ID号</th>  
	            <th data-options="field:'name'">名字</th>  
	            <th data-options="field:'telephone'">电话</th>  
	            <th data-options="field:'birthday'">生日</th>  
	            <th data-options="field:'sex'">性别</th>  
	            <th data-options="field:'company'">公司</th>  
	            <th data-options="field:'salary'">工资</th>  
	            <th data-options="field:'info'">备注</th>  
	        </tr>  
	    </thead>  
	    <tbody>  
			<s:iterator value="#pageBean.entitys">
	        <tr>  
	        	<td>${id}</td>
	        	<td>${name}</td>
	        	<td>${telephone}</td>
	        	<td>${birthday}</td>
	        	<td>${sex}</td>
	        	<td>${company}</td>
	        	<td>${salary}</td>
	        	<td>${info}</td>
	        </tr>  
			</s:iterator>
	    </tbody>  
	</table> 
	<div id="pagination" style="border:1px solid #ccc;">  
	</div>  
  </body>
</html>

