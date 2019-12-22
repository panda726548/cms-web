<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<table cellpadding="0" cellspacing="0">
		<tr>
		<td>username</td>
		<td><input type="text" name="username"/></td>
		</tr>
		<tr>
		<td>password</td>
		<td><input type="text" name="password"/></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit"/></td>
		</tr>
		</table>
	</form>
	<a href="qrlogin">扫码登录</a>
</body>
</html>