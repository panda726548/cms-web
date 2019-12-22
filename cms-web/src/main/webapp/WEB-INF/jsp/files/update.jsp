<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/admin/main.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/base/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/admin/article.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/validate/main.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/zTree/zTreeStyle.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/core/jquery.cms.keywordinput.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/uploadify/uploadify.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/tree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/core/jquery.cms.keywordinput.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/ui/jquery-ui-1.10.0.custom.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/admin/main.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/xheditor/xheditor-1.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/xheditor/xheditor_lang/zh-cn.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/core/jquery.cms.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/dwr/engine.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/dwr/interface/dwrService.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/admin/topicAdd.js"></script>
<script type="text/javascript">
$(function(){
	$("#addForm").cmsvalidate();
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<span>当前栏目:${file.name }[${file.id }]&nbsp;
		<a href="<%=request.getContextPath() %>/admin/file/files/${file.file.id}" class="admin_link">子栏目列表</a>
</span>
	</h3>
	<sf:form method="post" modelAttribute="fileDto" id="addForm">
	<table width="600px" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">更新[${file.name}]系统文件</td></tr></thead>
		<sf:hidden path="id"/>
		<tr>
			<td class="rightTd" width="96px">系统文件名称:</td><td class="leftTd"><sf:input path="name" size="30"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		<tr>
			<td colspan="2"><sf:textarea path="content" rows="24" cols="80"/></td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="修改系统文件"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>