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
<style type="text/css">
</style>
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
							<li class="active">网站免责声明</li>
						</ol>
					</div>
				</div>

			</div>
		</div>

		<div class="row">

			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">网站免责声明</h3>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="panel-body">
								<article class="art-container"> 
									<h3 class="art-title">网站免责声明</h3>
									<section class="art-content" style="word-break:break-all;word-wrap:break-word;">
										<p style="margin-top: 1em; margin-bottom: 1em; padding: 0px; border: 0px; font-family: 宋体; line-height: 28.7999992370605px; white-space: normal;">&nbsp;
											本网站大部分资料来源于互联网，转载的目的在于传递更多信息及用于网络分享，并不代表本站赞同其观点和对其真实性负责，也不构成任何其他建议，不为其版权负责。仅供读者预览及学习交流使用，下载后请24小时内删除，如果喜欢请购买正版资源!<span style="color: red;">如果您发现网站上有侵犯您的知识产权的作品，请与我们取得联系，我们会立即删除。</span>
										</p>
										<p style="margin-top: 1em; margin-bottom: 1em; padding: 0px; border: 0px; font-family: 宋体; line-height: 28.7999992370605px; white-space: normal;">&nbsp;
										本网站所提供的信息，只供参考之用。本网站不保证信息的准确性、有效性、及时性和完整性。本网站及其雇员一概毋须以任何方式就任何信息传递或传送的失误、不准确或错误，对用户或任何其他人士负任何直接或间接责任。在法律允许的范围内，本网站在此声明，不承担用户或任何人士就使用或未能使用本网站所提供的信息或任何链接所引致的任何直接、间接、附带、从属、特殊、惩罚性或惩戒性的损害赔偿。 
电子邮件：498617606@qq.com ,联系方式：QQ:498617606 微信号:panda726548
										</p>
									</section> 
								</article>
							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- 信息列表 -->
			<div class="col-md-4">
				<!--广告栏-->
				<div class="panel panel-default"></div>
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
							<c:forEach items="${keywords }" var="kw">
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