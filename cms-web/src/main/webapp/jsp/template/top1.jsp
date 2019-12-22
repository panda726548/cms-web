<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<input type="hidden" id="ctx" value="<%=request.getContextPath()%>"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <!--logo图片-->
      <a class="navbar-brand" href=""><img alt="Brand" width="100" height="30" src="static/front/logo.png"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav" style="margin-top: 5px">
      			<li class=" "><a href="<%=request.getContextPath()%>/index">首页</a></li>
					<c:forEach items="${navs}" var="nav">
						<li class="">
							<c:if test="${nav.customLink==0}">
								<a href="<%=request.getContextPath()%>/channel/${nav.id}">${nav.name}</a>
							</c:if>
							<c:if test="${nav.customLink==1}">
								<a href="${nav.customLinkUrl}">${nav.name}</a>
							</c:if>
						</li>
					</c:forEach>
      </ul>
      <form class="navbar-form navbar-left" role="search" name="search_form" method="post" >
		<div class="form-group input-group" style="margin-top: 5px">
		  <input type="text" class="form-control" name="search_header" id="search_con" placeholder="搜索...">
		  <span class="input-group-btn">
			<button class="btn btn-default" type="button" id="search_btn">搜索</button>
		  </span>
		</div>
      </form>
      <c:if test="${weixinUser !=null}">
	     <ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"  aria-expanded="false">
			<c:if test="${weixinUser.imgUrl!=null}">
				<img width="40" src="${weixinUser.imgUrl}" class="img-circle"/>
			</c:if>
			<c:if test="${weixinUser.imgUrl==null}">
				<img width="40" src="<%=request.getContextPath()%>/resources/img/katongtu.jpg" class="img-circle"/>
			</c:if>
			</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="<%=request.getContextPath() %>/showinfo/${weixinUser.id}">个人信息</a></li>					
						<li><a href="<%=request.getContextPath() %>/updateWxUser/${weixinUser.id}">修改信息</a></li>					
						<li><a href="<%=request.getContextPath() %>/changPwd">修改密码</a></li>					
						<li><a href="<%=request.getContextPath() %>/exit">退出</a></li>
          			</ul>
				</li>
				<li class=" " style="margin-top: 25px">${weixinUser.username}</li>
	      </ul> 
	   </c:if>
      <c:if test="${weixinUser ==null}">
	       <ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/userlogin">登录</a></li>
				<li class=""><a href="<%=request.getContextPath()%>/userregister" >注册</a></li>
	      </ul>
      </c:if>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
	<!-- 固定导航 -->
	<div class="row" style="height:80px;">
	  <div class="col-md-12">
			&nbsp;
	  </div>
	</div>
</div>



