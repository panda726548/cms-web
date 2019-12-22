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
			<td>用户标识</td>
			<td>用户名称</td>
			<td>用户昵称</td>
			<td>用户性别</td>
			<td>用户状态</td>
			<td>微信公众号用户的标识</td>
			<td>微信头像</td>
			<td>用户操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${weiXinUsers}" var="user">
			<tr>
				<td>${user.id  }&nbsp;</td>
				<td><a href="${user.id }" class="list_link">${user.username}</a></td>
				<td>${user.nickname }&nbsp;</td>
				<td><c:if test="${user.sex eq 0 }">男
				    </c:if><c:if test="${user.sex eq 1 }">女</c:if>
				 </td>
				<td>
					<c:if test="${user.status eq 0 }">
						<span class="emp">停用</span>
						<a href="<%=request.getContextPath() %>/admin/weixinUser/updateStatus/${user.id }" class="list_op">启用</a>
					</c:if>
					<c:if test="${user.status eq 1 }">
						<span>启用</span>
						<a href="<%=request.getContextPath() %>/admin/weixinUser/updateStatus/${user.id }" class="list_op">停用</a>
					</c:if>
					&nbsp;
				</td>
				<td>
					<a href="mailto:${user.openid }" class="list_link">${user.openid }</a>
					&nbsp;
				</td>
				<td>
					<img width="120" src="${user.imgUrl }"/>
					&nbsp;
				</td>
				<td>
					<a href="delete/${user.id }" title="${user.id }" class="list_op delete">删除</a>
					<a href="update/${user.id }" class="list_op">更新</a>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>