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
	<sf:form method="post" modelAttribute="wg" id="addForm">
	<table cellspacing="0" cellPadding="0" width="800">
		<thead><tr><td colspan="2">修改微信分组功能</td></tr></thead>
		<tr>
			<td class="rightTd">微信组编号:</td><td class="leftTd"><sf:input path="id" size="30" disabled="true"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		<tr>
			<td class="rightTd" >微信组名称:</td><td class="leftTd"><sf:input path="name" size="30"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="修改分组"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>