<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.validate.js"></script>
<script type="text/javascript">
$(function(){
	//    /admin/weixinMenu
	$("#addForm").cmsvalidate();
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="menu" id="addForm">
	<table cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">添加[${pc.name}]子菜单功能</td></tr></thead>
		<tr>
			<td class="rightTd">菜单名称:</td><td class="leftTd"><sf:input path="name" size="30"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		<tr>
			<td class="rightTd" >菜单URL:</td><td class="leftTd"><sf:input path="url" size="30"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		<tr>
			<td class="rightTd" >推送内容:</td><td class="leftTd"><sf:textarea path="content" rows="5" cols="80"/></td>
		</tr>
		<tr>
			<td class="rightTd">菜单类型:</td>
			<td class="leftTd">
				<sf:radiobutton path="type" value="view"/>view
				<sf:radiobutton path="type" value="click"/>click
				<sf:radiobutton path="type" value="none"/>无
			</td>
		</tr>
		<tr>
			<td class="rightTd">响应类型:</td>
			<td class="leftTd">
				<sf:radiobutton path="respType" value="2"/>无
				<sf:radiobutton path="respType" value="0"/>跳转
				<sf:radiobutton path="respType" value="1"/>点击
			</td>
		</tr>
		
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="添加菜单"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>