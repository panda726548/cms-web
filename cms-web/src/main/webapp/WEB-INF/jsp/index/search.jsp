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
<script type="text/javascript">
$(function(){
	$("#search_btn1").click(function() {
		var k = $("#search_con1").val();
		if(k=="") {
			alert("请输入要检索的关键字");
		} else {
			window.location.href=$("#ctx").val()+"/search/"+k;
		}
	})
})
</script>
</head>
<body>
<jsp:include page="/jsp/template/top1.jsp"/>	
<div class="container">

		<div class="row">
			<div class="col-md-12">

				<div class="panel panel-default">
					<div class="panel-body" style="padding:0px;">
						<ol class="breadcrumb" style="margin:0px;">
							<li><a href="<%=request.getContextPath()%>/index">首页</a>
							</li>
							<li class="active">检索:${con }</li>
						</ol>
					</div>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<!--栏目 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">导航栏目</h3>
					</div>
					<ul class="list-group">
						<c:forEach var="c" items="${cs}">
							<li class="list-group-item">
								<a href="${c.id }"> ${c.name } </a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">检索内容:[${con }]</h3>
						 <%--  <input type="text" class="form-control" name="search_header" id="search_con1" placeholder="${con }">
						  <span class="input-group-btn">
							<button class="btn btn-default" type="button" id="search_btn1">搜索</button>
						  </span> --%>
					</div>
					<!-- 文章列表 -->
					<ul class="list-group">
						<c:if test="${datas.total le 0 }">
							<li class="list-group-item">该栏目还没有任何文章....</li>
						</c:if>
						<c:if test="${datas.total gt 0 }">
							<c:forEach items="${datas.datas}" var="topic">
								<li class="list-group-item">
									<div class="row">
										<div class="col-md-2">
											<div class="thumbnail">
												<img src="<%=request.getContextPath()%>/resources/upload/thumbnail/${topic.newName}"
													alt="${topic.title }" height="85" data-holder-rendered="true"
													style="height: 85px; width: 100%; display: block;">
											</div>
										</div>
										<div class="col-md-10">
											<h4>
												<a href="<%=request.getContextPath()%>/topic/${topic.id}" target="_blank"
													title="${topic.title }"> ${topic.title } </a>
		
												<div class="pull-right" style="font-size:12px;">
		
													<!-- 编辑区 -->
													<a href="<%=request.getContextPath()%>/topic/${topic.id}" target="_blank"><span>查看全部</span>
													</a>
												</div>
											</h4>
		
											<p>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${topic.summary}
											</p>
		
											<footer>
											<div class="pull-left">
												<small>发布时间：<fmt:formatDate value="${topic.publishDate }" pattern="yyyy-MM-dd"/></small>
											</div>
											</footer>
										</div>
									</div>
								</li>
							</c:forEach>
						</c:if>
						<!-- 分页 -->
						<jsp:include page="/jsp/index_pager.jsp">
							<jsp:param value="${datas.total }" name="totalRecord"/>
							<jsp:param value="${channel.id}" name="url"/>
						</jsp:include>
					</ul>
				</div>
			</div>
		</div>

	</div>
<jsp:include page="/jsp/template/bottom.jsp"/>
</body>
</html>