<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/zTree/zTreeStyle.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/tree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.weixin.js"></script>
<script type="text/javascript">
var mt;
$(function(){
	mt = $("#tree").mytree();
});
function refreshTree() {
	mt.reAsyncChildNodes(null,"refresh");
}

function publishMenu(){
var url=$("#contextPath").val()+"/admin/weixinMenu/publishMenu";
$.ajax({
	   type: "POST",
	   url: url,
	   dataType:"text",
	   success: function(msg){
	   	alert(msg);
	   	window.location.href=$("#contextPath").val()+"/admin/weixinMenu/list";
	   },
	   error:function(){
	   	alert("获取菜单信息失败.......");
	   }
});
}

function queryPublishMenu(){
	var url=$("#contextPath").val()+"/admin/weixinMenu/queryPublishMenu";
	window.location.href=url;
}

</script>
</head>
<body>
<div id="content" >
	<input id="contextPath" type="hidden" value="<%=request.getContextPath() %>"/>
	<h3 class="admin_link_bar">
		<span>正在使用微信菜单管理功能</span>
	</h3>
	<TABLE border=0 align=left height="400px">
		<TR>
			<TD width=140px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
				<ul id="tree" class="ztree" style="width:140px; overflow:auto;"></ul>
			</TD>
			<TD width=690px align=left valign=top><IFRAME ID="cc" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=400px ></IFRAME></TD>
		</TR>
		<tr>
			<td colspan="2" align="center">
				<input id="publishMenu" type="button" value="发布菜单" onclick="publishMenu()"/>&nbsp;&nbsp;
				<input id="queryPublishMenu" type="button" value="查看发布菜单" onclick="queryPublishMenu()"/>
			</td>
		</tr>
	</TABLE>
</div>
</body>
</html>