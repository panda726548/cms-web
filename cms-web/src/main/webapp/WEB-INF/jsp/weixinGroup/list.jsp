<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>组标识</td>
			<td>组名称</td>
			<td>用户人数</td>
			<td>用户操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${datas}" var="wg">
			<tr>
				<td>${wg.id }&nbsp;</td>
				<td><a href="${wg.id }" class="list_link">${wg.name }</a></td>
				<td>${wg.count }&nbsp;</td>
				<td>
					<a href="<%=request.getContextPath() %>/admin/weixinGroup/delete/${wg.id }" class="list_op delete">删除</a>
					<a href="<%=request.getContextPath() %>/admin/weixinGroup/update//${wg.id }/name/${wg.name}" class="list_op">更新</a>
					<a href="<%=request.getContextPath() %>/admin/weixinGroup/clearUsers/${group.id }" class="list_op delete">清空用户</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>