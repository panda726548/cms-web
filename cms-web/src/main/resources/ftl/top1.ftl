<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<input type="hidden" id="ctx" value="<%=request.getContextPath()%>"/>
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
      <ul class="nav navbar-nav">
      			<li class=" active "><a href="<%=request.getContextPath()%>/index">首页</a></li>
				<#list navs as nav>
					<li class="  ">
						<#if nav.customLink==0>
							<a href="<%=request.getContextPath()%>/channel/${nav.id}">${nav.name}</a>
						<#else>
							<a href="${nav.customLinkUrl}">${nav.name}</a>
						</#if>
					</li>
				</#list>
				
      </ul>
      <form class="navbar-form navbar-left" role="search" name="search_form" method="post">
		<div class="form-group input-group">
		  <input type="text" class="form-control" name="search_header" id="search_con" placeholder="搜索...">
		  <span class="input-group-btn">
			<button class="btn btn-default" type="button" id="search_btn">搜索</button>
		  </span>
		</div>
      </form>
      <#if weixinUser??>
	     <ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"  aria-expanded="false"><img width="40" src="${weixinUser.imgUrl}" class="img-circle"/></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="market">个人信息</a></li>					
						<li><a href="advice">退出</a></li>
          			</ul>
				</li>
	      </ul>
      <#else>
	       <ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/userlogin">登录</a></li>
				<li class=""><a href="<%=request.getContextPath()%>/userregister" >注册</a></li>
	      </ul>
      </#if>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
	<!-- 固定导航 -->
	<div class="row" style="height:60px;">
	  <div class="col-md-12">
			&nbsp;
	  </div>
	</div>
</div>



  