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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
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
	<table width="580" cellspacing="0" cellPadding="0" class="listTable">
		<thead>
		<tr>
			<td>栏目名称</td>
			<td>文件url</td>
			<td>备注信息</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${files }" var="f">
			<tr id="id_${f.id }">
				<td>
				${f.name }
				&nbsp;</td>
				<td class="ctype">${f.fileUrl}</td>
				<td class="ctype">${f.remark}</td>
				<td class="centerTd">
					<c:if test="${not empty f.file }">
						<a href="<%=request.getContextPath() %>/admin/file/eidtfile/${f.id }" class="list_op">
						修改文件</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>