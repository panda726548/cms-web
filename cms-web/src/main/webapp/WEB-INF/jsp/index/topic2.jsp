<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎访问${baseInfo.name }</title>
<meta http-equiv="keywords" content="java,java攻城狮">   
<meta http-equiv="description" content="java攻城狮分享网站"> 
 <link href="<%=request.getContextPath() %>/resources/css/index/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/index/style.css" rel="stylesheet">
  	<script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
<style type="text/css">
</style>
</head>
<body>
<jsp:include page="/jsp/template/top.jsp"/>	
<div id="content">
	<div id="content_con">
		<div id="article_title"><span>${topic.title}</span></div>
		<div id="article_info">
		<fmt:formatDate value="${topic.publishDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		&nbsp;${topic.author }
		</div>
		<div id="article_content">
		${topic.content }
		</div>
		<div class="article_atts">
		相关附件:
		<c:if test="${!hasAtts}">该文章没有附件</c:if>
		<c:if test="${hasAtts }">
			<c:forEach items="${atts }" var="att">
				<span><a href="<%=request.getContextPath()%>/resources/upload/${att.newName}" class="article_att_link">${att.oldName }</a></span>
			</c:forEach>
		</c:if>
		</div>
	</div>
</div>
<jsp:include page="/jsp/template/bottom.jsp"/>
</body>
</html>