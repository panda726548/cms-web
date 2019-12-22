<%@page import="org.xupan.basic.model.SystemContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pg:pager export="curPage=pageNumber" 
	items="${param.totalRecord }" 
	maxPageItems="<%=SystemContext.getPageSize() %>"
	url="${param.url }">
	<li class="list-group-item">
	<!--分页--> <nav>
	<ul class="pagination" style="margin: 0px;">
	<pg:pages>
		<c:if test="${curPage eq pageNumber }">
			<li class="page">${pageNumber }</li>
		</c:if>
		<c:if test="${curPage != pageNumber }">
			<li class="page"><a href="${pageUrl }">${pageNumber }</a></li>
		</c:if>
	</pg:pages>
	<pg:next>
		<li class="page next"><a href="${pageUrl }">&gt;</a></li>
	</pg:next>
	</ul>
	</nav>
</li>
</pg:pager>
