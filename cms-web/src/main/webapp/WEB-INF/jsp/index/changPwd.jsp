<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎访问${baseInfo.name }</title>
<meta http-equiv="keywords" content="java,java攻城狮">
<meta http-equiv="description" content="java攻城狮分享网站">
<link
	href="<%=request.getContextPath()%>/resources/css/index/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/index/style.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>

</head>
<body>
	<jsp:include page="/jsp/template/top1.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body" style="padding:0px;">
						<ol class="breadcrumb" style="margin:0px;">
							<li><a href="<%=request.getContextPath()%>/index">首页</a></li>
							<li class="active">修改密码</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">修改密码</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" name="form1" action="changPwd/${weixinUser.id}" method="post">
							<div class="form-group">
								<label for="oldPwd" class="col-sm-2 control-label">旧密码</label>
								<div class="col-sm-10">
									<input name="odpwd" class="form-control" type="password"
										id="odpwd" placeholder="旧密码">
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">新密码</label>
								<div class="col-sm-10">
									<input name="password" type="password" class="form-control"
										id="password" placeholder="新密码">
								</div>
							</div>
							<div class="form-group">
								<label for="password2" class="col-sm-2 control-label">重复密码</label>
								<div class="col-sm-10">
									<input name="password2" type="password" class="form-control"
										id="password2" placeholder="重复密码">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="submit" value="修改密码" class="btn btn-primary"/> &nbsp;&nbsp;&nbsp;&nbsp; <input
										type="reset" value="重 置" class="btn btn-default" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 信息列表 -->
			<div class="col-md-4">
				<!--广告栏-->
				<div class="panel panel-default"></div>
				<!--栏目 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${pc.name}</h3>
					</div>
					<ul class="list-group">
						<c:forEach var="c" items="${cs}">
							<li class="list-group-item"><a href="${c.id }"> ${c.name
									} </a></li>
						</c:forEach>
					</ul>
				</div>
				<!-- 推荐文章 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">推荐文章</h3>
					</div>
					<ul class="list-group">
						<c:if test="${empty recommendList }">
							<li class="list-group-item">没有推荐的文章....</li>
						</c:if>
						<c:if test="${!empty recommendList }">
							<c:forEach items="${recommendList }" var="topic">
								<li class="list-group-item"><span class="badge"><fmt:formatDate
											value="${topic.publishDate}" type="date" pattern="MM-dd" />
								</span> <a href="<%=request.getContextPath()%>/topic/${topic.id}"
									target="_blank" title="${topic.title}"> ${topic.title} </a></li>
							</c:forEach>
						</c:if>
					</ul>
				</div>
				<!-- 广告 -->
				<div class="panel panel-default" style="padding: 5px 0px 5px 10px;">

				</div>
				<!-- 友情链接 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">友情链接</h3>
					</div>
					<ul class="list-group">
						<c:forEach items="${cmsLinkList}" var="link">
							<li class="list-group-item"><a href="${link.url}"
								target="_blank" title="${link.title}"> ${link.title} </a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- 关键字 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							热门标签<a class="more" href="">更多</a>
						</h3>
					</div>
					<div class="panel-body">
						<ul class="q-taglist clearfix">
							<li title="标签"><span class="q-icon"></span>
							</li>
							<c:forEach items="${keywords}" var="kw">
								<li class="q-tagitem"><a class="a-tagitem"
									href="<%=request.getContextPath()%>/keyword/${kw.name}">${kw.name}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/jsp/template/bottom.jsp" />
</body>
</html>