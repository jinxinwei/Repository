function alertMessage(message,urlAddress){
	
	
	if($("#messageDialog")==null||$("#messageDialog").length<=0){
		var html='<div id="messageDialog"></div>';	
		$("body").append(html);
	}
   	$('#messageDialog').dialog({   
	    title: '反馈信息',
	    content:"<h3 style='text-align:center;margin:10px;'>"+message+"</h3>",   
	    width: 400,   
	    height: 200,   
	    closed: false,   
	    modal: true,
	    buttons:[{text:'确定',handler:function(){if(urlAddress!=null&&urlAddress.length>0){window.location.href="${pageContext.request.contextPath}/"+urlAddress;}else{$("#messageDialog").dialog("close");}}}] 
	}); 		

	
}


function sendMessage(url,data){
	$.ajax({
		   type: "POST",
		   url:url,
		   data:(data==null)?"":data,
		   success: function(msg){
				alertMessage(msg.message,msg.urlAddress);
		   }
		});
}


function encodeWord(value){
	return encodeURIComponent(encodeURIComponent(value));
}

function decodeWord(value){
	return decodeURIComponent(decodeURIComponent(value));
}
