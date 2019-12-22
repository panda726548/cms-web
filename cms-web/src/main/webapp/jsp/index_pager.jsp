<%@page import="org.xupan.basic.model.SystemContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="<%=request.getContextPath()%>/resources/css/index/bootstrap.min.css"
	rel="stylesheet">
<link href="<request.getContextPath()()%>/resources/css/index/style.css"
	rel="stylesheet">
<pg:pager export="curPage=pageNumber" items="${param.totalRecord }"
	maxPageItems="<%=SystemContext.getPageSize() %>" url="${param.url }">
	<li class="list-group-item"><nav>
		<ul class="pagination" style="margin: 0px;">
			<pg:first>
				<li class="page"><a href="${pageUrl }">首页</a>
				</li>
			</pg:first>
			<pg:prev>
				<li class="page"><a href="${pageUrl }">上一页</a>
				</li>
			</pg:prev>
			<pg:pages>
				<c:if test="${curPage eq pageNumber }">
					<li class="page active"><a href="${pageUrl }">${pageNumber }</a></li>
				</c:if>
				<c:if test="${curPage != pageNumber }">
					<li class="page"><a href="${pageUrl }">${pageNumber }</a></li>
				</c:if>
			</pg:pages>
			<pg:next>
				<li class="page"><a href="${pageUrl }">下一页</a>
				</li>
			</pg:next>
			<pg:last>
				<li class="page"><a href="${pageUrl }">尾页</a>
				</li>
			</pg:last>
		</ul>
		</nav></li>
</pg:pager>
