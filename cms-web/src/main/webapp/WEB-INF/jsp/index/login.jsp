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
<script type="text/javascript">
	function login() {
		var username = $('[name="username"]').val();
		if (username == '') {
			alert('用户名不能为空！');
			return false;
		}

		var pwd = $('[name="password"]').val();
		if (pwd == '') {
			alert('密码不能为空！');
			return false;
		}
		var imageCode = $('[name="imageCode"]').val();
		if (imageCode == '') {
			alert('验证码不能为空！');
			return false;
		}
		if (imageCode.length != 4) {
			alert('验证码输入错误！');
			return false;
		}
		return true;
	}

	//jQuery 当键盘敲击【ENTER】键时，系统登录 
	$(document).ready(function() {
		$("body").keydown(function(event) {
			if (event.which == 13) {
				login();
			}
		});
	});
	
	function reCheckcode(img) {
		img.src="drawCheckCode?"+Math.random();
	}
</script>

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
							<li class="active">用户登陆</li>
						</ol>
					</div>
				</div>

			</div>
		</div>

		<div class="row">

			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">用户登陆</h3>
					</div>
					<div class="row">
						<div class="col-md-8">
							<div class="panel-body">
								<form class="form-horizontal" id="form1" name="form1" action="<%=request.getContextPath()%>/userlogin"
									method="post" onsubmit="return login()">

									<div class="form-group">
										<label for="email" class="col-sm-4 control-label">账户名：</label>
										<div class="col-sm-8">
											<input name="username" class="form-control" id="username"
												placeholder="登录账号" autofocus="autofocus" autocomplete="off"
												tabindex="1" value="" maxlength="100">
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-4 control-label">登录密码：</label>
										<div class="col-sm-8">
											<input name="password" type="password" class="form-control"
												id="password" placeholder="登录密码" autocomplete="off"
												tabindex="2" value="" maxlength="100">
										</div>
									</div>
									<div class="form-group">
										<label for="imageCode" class="col-sm-4 control-label">验证码：</label>
										<div class="col-sm-8">
											<div class="input-group">
												<input name="checkcode" type="text" class="form-control"
													id="imageCode" tabindex="3" placeholder="验证码" maxlength="4">
												<div class="input-group-addon" style="padding:2px;">
													<img id="picimageCode" align="middle" width="120"
														height="26" style="line-height: 18px;cursor:pointer;"
														src="drawCheckCode" onclick="reCheckcode(this)" title="更换一张验证码图片" />
												</div>
											</div>

										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<input type="submit" value="登 录"
												class="btn btn-success btn-block" tabindex="4"/>
										</div>
									</div>
								</form>

							</div>
						</div>
						<div class="col-md-4">
							<div class="thumbnail">
								<div class="caption">请用微信扫描二维码登录</div>
								<img
									src="resources/img/weixin.jpg"
									data-holder-rendered="true"
									style="height: 200px; width: 100%; display: block;">
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