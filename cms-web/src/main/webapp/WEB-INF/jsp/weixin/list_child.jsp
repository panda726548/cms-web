<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/base/jquery.ui.all.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.weixin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.sortable.js"></script>

<script type="text/javascript">
$(function(){
	if($("#refresh").val()=="1") {
		parent.refreshTree();
	}
	$(".listTable").mysorttable();
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<input type="hidden" id="refresh" value="${refresh}"/>
	<table width="650" cellspacing="0" cellPadding="0" class="listTable">
		<thead>
		<tr>
			<td width="60">菜单名称</td>
			<td>url</td>
			<td>点击内容</td>
			<td>类型</td>
			<td>响应类型</td>
			<td>菜单Key</td>
			<td width="80">操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${weixinMenu}" var="wm">
			<tr id="id_${wm.id }">
				<td>
				${wm.name }
				&nbsp;</td>
				<td class="ctype">${wm.url}</td>
				<td class="ctype">${wm.content}</td>
				<td class="ctype">${wm.type}</td>
				<c:if test="${wm.respType eq 0 }">
					<td class="ctype">跳转</td>
				</c:if>
				<c:if test="${wm.respType eq 1 }">
					<td class="ctype">点击</td>
				</c:if>
				<c:if test="${wm.respType eq 2 }">
					<td class="ctype">无</td>
				</c:if>
				<td class="ctype">${wm.menuKey}</td>
				<td class="centerTd">
					<c:if test="${not empty weixinMenu }">
						<a href="<%=request.getContextPath() %>/admin/weixinMenu/update/${wm.id}" class="list_op">
						修改</a>&nbsp;
						<a href="<%=request.getContextPath() %>/admin/weixinMenu/delete/${wm.pid}/${wm.id}" class="list_op">
						删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>