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
									<li class="  ">
							<a href="<%=request.getContextPath()%>/channel/1">技术文章</a>
					</li>
					<li class="  ">
							<a href="<%=request.getContextPath()%>/channel/11">学习视频</a>
					</li>
					<li class="  ">
							<a href="<%=request.getContextPath()%>/channel/26">项目案例</a>
					</li>
					<li class="  ">
							<a href="<%=request.getContextPath()%>/channel/15">后台模板</a>
					</li>
					<li class="  ">
							<a href="<%=request.getContextPath()%>/channel/20">资源下载</a>
					</li>
					<li class="  ">
							<a href="<%=request.getContextPath()%>/channel/29">开发API</a>
					</li>
				
      </ul>
      <form class="navbar-form navbar-left" role="search" name="search_form" method="post">
		<div class="form-group input-group">
		  <input type="text" class="form-control" name="search_header" id="search_con" placeholder="搜索...">
		  <span class="input-group-btn">
			<button class="btn btn-default" type="button" id="search_btn">搜索</button>
		  </span>
		</div>
      </form>
	       <ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/userlogin">登录</a></li>
				<li class=""><a href="<%=request.getContextPath()%>/userregister" >注册</a></li>
	      </ul>
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



