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

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.core-3.3.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css"/>
<script type="text/javascript">
<!--

	changeTheme = function(themeName) {
		var $easyuiTheme = $('#easyuiTheme');
		var url = $easyuiTheme.attr('href');
		var href = url.substring(0, url.indexOf('themes')) + 'themes/'
				+ themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);
		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for ( var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				$(ifr).contents().find('#easyuiTheme').attr('href', href);
			}
		}
	};
	
	
	editPassword=function(){
		$('#editPassword').window({   
		width:600,   
		height:400,   
		modal:true,
		collapsible:false, 
		minimizable:false, 
		maximizable:false
		});  
	}
	
	cancel=function(){
		$("#editPassword").window("close");
	}

	managerInfo=function(){
		$.messager.alert('个人信息','金鑫伟，手机号码：13916688900，QQ：6556489','info');	
	}	
	
	logout=function(){
		$.messager.confirm('退出登录', '您真的确定要退出登录吗？', function(r){
			if (r){
				window.alert("你已经退出登录");
			}
		});


	}
	
	$(function(){
	
		$.messager.show({
			title:'消息提示!',
			msg:'您还有5条订单没有处理',
			timeout:5000,
			showType:'slide'
		});
	
	});
	
	
	

	
		var setting = {
			data: {
				simpleData: {
					enable: true
				},
				key : {checked : "checked",
			children : "children",  //名称的作用:"父节点.children=childrenNodesObject"
			name : "title",	//节点显示时的名称
			title : "title"}	//节点上漂浮显示的名称
			}
		};

		var zNodes =[
			{ id:1, pId:0, title:"父节点1 - 展开", open:true},
			{ id:11, pId:1, title:"父节点11 - 折叠"},
			{ id:111, pId:11, title:"叶子节点111"},
			{ id:112, pId:11, title:"叶子节点112"},
			{ id:113, pId:11, title:"叶子节点113"},
			{ id:114, pId:11, title:"叶子节点114"},
			{ id:12, pId:1, title:"父节点12 - 折叠"},
			{ id:121, pId:12, title:"叶子节点121"},
			{ id:122, pId:12, title:"叶子节点122"},
			{ id:123, pId:12, title:"叶子节点123"},
			{ id:124, pId:12, title:"叶子节点124"},
			{ id:13, pId:1, title:"父节点13 - 没有子节点", isParent:true},
			{ id:2, pId:0, title:"父节点2 - 折叠"},
			{ id:21, pId:2, title:"父节点21 - 展开", open:true},
			{ id:211, pId:21, title:"叶子节点211"},
			{ id:212, pId:21, title:"叶子节点212"},
			{ id:213, pId:21, title:"叶子节点213"},
			{ id:214, pId:21, title:"叶子节点214"},
			{ id:22, pId:2, title:"父节点22 - 折叠"},
			{ id:221, pId:22, title:"叶子节点221"},
			{ id:222, pId:22, title:"叶子节点222"},
			{ id:223, pId:22, title:"叶子节点223"},
			{ id:224, pId:22, title:"叶子节点224"},
			{ id:23, pId:2, title:"父节点23 - 折叠"},
			{ id:231, pId:23, title:"叶子节点231"},
			{ id:232, pId:23, title:"叶子节点232"},
			{ id:233, pId:23, title:"叶子节点233"},
			{ id:234, pId:23, title:"叶子节点234"},
			{ id:3, pId:0, title:"父节点3 - 没有子节点", isParent:true}
		];

	
	$(function(){
		$.fn.zTree.init($("#ztree"), setting, zNodes);	
	});


		var setting1 = {
			async: {
				enable: true,
				url:"${pageContext.request.contextPath}/ztree.json",
				dataFilter: filter
			},
			data: {
				simpleData: {
					enable: true,
					idKey:"id",
					pIdKey:"pid"
				},
				key : {checked : "checked",
			children : "children",
			name : "title",
			title : "title"}	
			},
			callback:{
				onClick:onClick
			}
		};



		
		function onClick(event, treeId, treeNode) {
    		console.info(event);
    		console.info(treeId);
    		console.info(treeNode);
    		console.info(treeNode.link);
			var frame='<iframe src="${pageContext.request.contextPath}/treeNode.link"/>';    		
    		var href="${pageContext.request.contextPath}/tree.json";
    		$('#tabs').tabs('add',{closable:true,title: treeNode.title,selected: true,href:href});
    		
    		
		};
		

		function filter(treeId, parentNode, childNodes) {
			console.info(treeId);
			console.info(parentNode);
			console.info(childNodes);
			
					
			if (!childNodes) return null;

			return childNodes;
			
			
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#ztree1"), setting1);
		});
	
	var i=5;
	$("#tabs").click(function(){
		$(this).append("<div title='Title"+i+"'>content"+i+"</div>");
		++i;
	});
	
	
	
	
	
	
	
	
	
			var setting2 = {
			async: {
				enable: true,
				url:"${pageContext.request.contextPath}/tree.json",
				dataFilter: filter
			}
		};



		$(document).ready(function(){
			$.fn.zTree.init($("#ztree2"), setting2);
		});
	
	
	
	
	
-->
</script>
  </head>
  
<body class="easyui-layout">
<div data-options="region:'north'" style="height:100px;">
  <div><img src="${pageContext.request.contextPath}/images/bdlogo.png" style="height:80px;" /></div>
    <div style="position:absolute;top:10px;right:10px;">
		<strong>[欢迎管理员，使用<span>127.0.0.1</span>IP登录！</strong>
	</div>
	<div style="position:absolute;bottom:10px;right:10px;"> <a href="javascript:void(0)" id="mb" class="easyui-menubutton"    
        data-options="menu:'#skin',iconCls:'icon-ok'">主题更改</a> <a href="javascript:void(0)" id="mb" class="easyui-menubutton"    
        data-options="menu:'#panel',iconCls:'icon-help'">个人操作</a>
      <div id="skin" style="width:150px;">
        <div onClick="changeTheme('default');">default</div>
        <div onClick="changeTheme('gray');">gray</div>
        <div onClick="changeTheme('black');">black</div>
        <div onClick="changeTheme('bootstrap');">bootstrap</div>
        <div onClick="changeTheme('metro');">metro</div>
      </div>
      <div id="panel" style="width:150px;">
        <div onclick="editPassword();">修改密码</div>
        <div onclick="managerInfo();">个人信息</div>
        <div class="menu-sep"></div>
        <div onclick="logout();">退出登录</div>
      </div>    
  </div>
</div>
<div data-options="region:'south',title:'South Title',split:true" style="height:100px;">south</div>
<div data-options="region:'west',title:'West',split:true" style="width:200px;">

	<div id="aa" class="easyui-accordion" data-options="fit:true">  
		<div title="Title1" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">  
			<ul id="ztree" class="ztree"></ul>
		</div>  
		<div title="Title2" data-options="iconCls:'icon-reload'" style="padding:10px;">  
			<ul id="ztree2" class="ztree"></ul>   
		</div>  
		<div title="Title3">  
			<ul id="ztree1" class="ztree"></ul>
		</div>  
	</div>  

</div>

<div data-options="region:'center',title:'center title'" style="background:#eee;">
	<div id="tabs" class="easyui-tabs">  
	    <div title="Tab1" style="padding:20px;">
	    	<input id="vv" class="easyui-validatebox" data-options="required:true,validType:'email'" />  
	    </div>  
	    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;">  
	        tab2   
	    </div>  
	    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;">  
	        tab3   
	    </div>  
	</div>  
</div>


<div id="editPassword" >
	<div data-option="region:center">
		<label>用户名：<input class="easyui-validatebox" type="text" name="name" data-options="required:true" /></label><p/>
		<label>密&nbsp;码：<input type="password" name="password"/></label><p/>
	</div>
	<div data-options="region:south">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>  
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="cancel();">取消</a>  
	</div>
</div>
</body>
</html>
