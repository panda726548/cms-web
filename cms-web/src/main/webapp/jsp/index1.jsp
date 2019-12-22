
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>java攻城狮资源分享</title>

<meta name="description" content="java攻城狮资源分享">
<meta name="author" content="pandaxu">

<link
	href="<%=request.getContextPath()%>/resources/css/index/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/index/style.css"
	rel="stylesheet">

</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--logo图片-->
				<a class="navbar-brand" href=""><img alt="Brand" width="20"
					height="20" src="static/front/logo.png"> </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li class=" active "><a href="home">首页</a></li>


					<li class="  "><a href="#">学习视频</a></li>


					<li class="  "><a href="#">技术文章</a></li>


					<li class="  "><a href="#">网站模板</a></li>


					<li class="  "><a href="#">项目案例</a></li>


					<li class="  "><a href="#">资源下载</a></li>


					<li class="  "><a href="#">开发API</a></li>
					<li class="  "><a href="#">技术文档</a></li>

				</ul>
				<form class="navbar-form navbar-left" role="search"
					name="search_form" method="post">
					<div class="form-group input-group">
						<input type="text" class="form-control" name="search_header"
							placeholder="搜索..."> <span class="input-group-btn">
							<button class="btn btn-default" type="button" id="search_btn">搜索</button>
						</span>
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="web/login">登录</a></li>
					<li class=""><a href="front/regist">注册</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container">
		<!-- 固定导航 -->
		<div class="row" style="height:60px;">
			<div class="col-md-12">&nbsp;</div>
		</div>
	</div>





	<div class="container">

		<div class="row">

			<!-- 图片 -->
			<div class="col-md-8">

				<div class="panel panel-default">
					<div class="panel-body" style="padding: 0px;">

						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>

							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
								<div style="height: 450px;" class="item active">
									<a href="#" target="_blank"> <img src="img/1.jpg" alt="百花山">
									</a>
									<div class="carousel-caption">
										<h4></h4>
										<p>百花山</p>
									</div>
								</div>
								<div style="height: 450px;" class="item ">
									<a href="#" target="_blank"> <img src="img/3.jpg" alt="百花山">
									</a>
									<div class="carousel-caption">
										<h4></h4>
										<p>美丽门城</p>
									</div>
								</div>
								<div style="height: 450px;" class="item ">
									<a href="#" target="_blank"> <img src="img/3.jpg" alt="百花山">
									</a>
									<div class="carousel-caption">
										<h4></h4>
										<p>永定塔</p>
									</div>
								</div>

							</div>

							<!-- Controls -->
							<a class="left carousel-control" href="#carousel-example-generic"
								role="button" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
								<span class="sr-only">上一页</span> </a> <a
								class="right carousel-control" href="#carousel-example-generic"
								role="button" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
								<span class="sr-only">下一页</span> </a>
						</div>
					</div>
				</div>

			</div>
			<!-- 图片end -->
			<!-- 技术文章 -->
			<div class="col-md-4">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active" style="cursor: pointer;">
						<a style="cursor:pointer;" href="#" onclick="return false;"
						id="new_news_tab">技术文章</a>
					</li>

				</ul>
				<div id="new_news" class="panel panel-default"
					style="border-top-width: 0px;border-radius:0px;border-bottom-right-radius:4px; border-bottom-left-radius: 4px;">
					<!-- List group -->
					<ul class="list-group">
						<li class="list-group-item"><span class="badge">04-20</span>
							<span class="label label-success">1</span> <a href="#"
							target="_blank" title="最新资源1......"> 最新资源1...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-11</span>
							<span class="label label-success">2</span> <a href="#"
							target="_blank" title="最新资2......"> 最新资源2...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-10</span>
							<span class="label label-success">3</span> <a href="#"
							target="_blank" title="最新资源3......"> 最新资源3...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-10</span>
							<span class="label label-info">4</span> <a href="#"
							target="_blank" title="最新资源4......"> 最新资源4...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-10</span>
							<span class="label label-info">5</span> <a href="#"
							target="_blank" title="最新资源5....."> 最新资源5...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-10</span>
							<span class="label label-info">5</span> <a href="#"
							target="_blank" title="最新资源5....."> 最新资源5...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-10</span>
							<span class="label label-info">5</span> <a href="#"
							target="_blank" title="最新资源5....."> 最新资源5...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-10</span>
							<span class="label label-info">5</span> <a href="#"
							target="_blank" title="最新资源5....."> 最新资源5...... </a>
						</li>
						<li class="list-group-item"><span class="badge">12-10</span>
							<span class="label label-info">5</span> <a href="#"
							target="_blank" title="最新资源5....."> 最新资源5...... </a>
						</li>
						<li class="list-group-item"><span> <a href="#"
								target="_blank" title="更多"> 更多... </a> </span>
						</li>

					</ul>
				</div>
			</div>
		</div>
		<!-- 广告位 -->
		<div class="row">
			<div class="col-md-8">
				<div class="thumbnail" style="padding: 3px 0 0 50px;">
					<!-- 广告位 -->
					<script type="text/javascript">
						/*中间左边*/
						var cpro_id = "u2145243";
					</script>
					<script src="http://cpro.baidustatic.com/cpro/ui/c.js"
						type="text/javascript"></script>
				</div>

			</div>
			<div class="col-md-4">
				<div class="thumbnail" style="padding: 3px 0 0 5px;">
					<script type="text/javascript">
						/*中间右边*/
						var cpro_id = "u2145322";
					</script>
					<script src="http://cpro.baidustatic.com/cpro/ui/c.js"
						type="text/javascript"></script>
				</div>
			</div>
		</div>
		<!-- 广告位end -->
		<div class="row">

			<div class="col-md-8">
				<!-- 学习视频 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="travel" target="_blank">学习视频</a> <a class="more"
								href="travel" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body">

						<div class="row">
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/333.html" target="_blank"> <img
										alt="微信开发" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/333.html" target="_blank">微信开发</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/332.html" target="_blank"> <img
										alt="组织机构设计" src="@" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/332.html" target="_blank">组织机构设计</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/331.html" target="_blank"> <img
										alt="权限模型设计" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/331.html" target="_blank">权限模型设计</a>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/330.html" target="_blank"> <img
										alt="shiro框架" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/330.html" target="_blank">shiro框架</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/329.html" target="_blank"> <img
										alt="Java基础视频" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/329.html" target="_blank">Java基础视频</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/328.html" target="_blank"> <img
										alt="JavaWeb开发" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/328.html" target="_blank">JavaWeb开发</a>
									</div>
								</div>
							</div>
						</div>
						<div class="row"></div>

					</div>
				</div>

				<!-- 项目案例 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="travel" target="_blank">项目案例</a> <a class="more"
								href="travel" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body">

						<div class="row">
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/333.html" target="_blank"> <img
										alt="CRM客户关系管理系统" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/333.html" target="_blank">CRM客户关系管理系统</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/332.html" target="_blank"> <img
										alt="SL会员商城管理系统" src="@" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/332.html" target="_blank">SL会员商城管理系统</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/331.html" target="_blank"> <img
										alt="电力巡检系统" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/331.html" target="_blank">电力巡检系统</a>
									</div>
								</div>
							</div>
						</div>
						<div class="row"></div>

					</div>
				</div>
				<!-- 项目案例 -->

				<!-- 网站模板 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="travel" target="_blank">网站模板</a> <a class="more"
								href="travel" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body">

						<div class="row">
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/333.html" target="_blank"> <img
										alt="CRM客户关系管理系统" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/333.html" target="_blank">CRM客户关系管理系统</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/332.html" target="_blank"> <img
										alt="SL会员商城管理系统" src="@" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/332.html" target="_blank">SL会员商城管理系统</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-4">
								<div class="thumbnail">
									<a href="front/article/331.html" target="_blank"> <img
										alt="电力巡检系统" src="#" data-holder-rendered="true"
										style="height: 200px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/331.html" target="_blank">电力巡检系统</a>
									</div>
								</div>
							</div>
						</div>
						<div class="row"></div>

					</div>
				</div>
				<!-- 项目案例 -->
			</div>

			<div class="col-md-4">

				<!-- 开发API -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="food" target="_blank">开发API </a> <a class="more"
								href="food" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body" style="padding-bottom:0px;">
						<div class="row">
							<div class="col-md-6">
								<div class="thumbnail">
									<a href="front/article/673.html" target="_blank"> <img
										alt="JDK1.6API" src="#" data-holder-rendered="true"
										style="height: 120px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/673.html" target="_blank">JDK1.6
											API帮助文档</a>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="thumbnail">
									<a href="front/article/340.html" target="_blank"> <img
										alt="jQuery帮助文档" src="#" data-holder-rendered="true"
										style="height: 120px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/340.html" target="_blank">jQuery帮助文档</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<ul class="list-group">
						<li class="list-group-item"><span class="badge">06-30</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试1......"> 开发API测试1...... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-21</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试2......"> 开发API测试2...... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-11</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试3......"> 开发API测试3...... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-11</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试4......"> 开发API测试4...... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-08</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试5......"> 开发API测试5...... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-08</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试6......"> 开发API测试6...... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-08</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试7......"> 开发API测试7...... </a>
						</li>
						<li class="list-group-item"><span class="badge">05-24</span>
							<a href="front/article/672.html" target="_blank"
							title="开发API测试8......"> 开发API测试8...... </a>
						</li>
					</ul>

				</div>

				<!-- 广告 -->
				<div class="panel panel-default" style="padding: 5px 0px 5px 10px;">
					<!-- 创意广告  -->
					<!-- <script type="text/javascript">
	    var cpro_id="u2214479";
	    (window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"336",rsi1:"280",pat:"17",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"",titFS:"14",rss2:"#000000",titSU:"0"}
	</script>
	<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>-->

					<!-- 右侧广告  -->
					<!--
  <script type="text/javascript">
    var cpro_id = "u2145342";
	</script>
	<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
	-->
				</div>
				<!-- 资源下载 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="education" target="_blank">资源下载</a> <a class="more"
								href="education" target="_blank">更多</a>
						</h3>
					</div>

					<div class="panel-body" style="padding-bottom:0px;">
						<div class="row">
							<div class="col-md-6">
								<div class="thumbnail">
									<a href="front/article/343.html" target="_blank"> <img
										alt="MyEclipse开发工具" src="#" data-holder-rendered="true"
										style="height: 120px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/343.html" target="_blank">MyEclipse开发工</a>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="thumbnail">
									<a href="front/article/378.html" target="_blank"> <img
										alt="MySQL数据库" src="#" data-holder-rendered="true"
										style="height: 120px; width: 100%; display: block;"> </a>
									<div class="caption">
										<a href="front/article/378.html" target="_blank">MySQL数据</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<ul class="list-group">
						<li class="list-group-item"><span class="badge">06-03</span>
							<a href="front/article/449.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-03</span>
							<a href="front/article/448.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-03</span>
							<a href="front/article/447.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-03</span>
							<a href="front/article/446.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-03</span>
							<a href="front/article/445.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-03</span>
							<a href="front/article/444.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-03</span>
							<a href="front/article/443.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
						<li class="list-group-item"><span class="badge">06-02</span>
							<a href="front/article/435.html" target="_blank"
							title="资源下载测试1....."> 资源下载测试1..... </a>
						</li>
					</ul>

				</div>

				<!-- 友情链接 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">友情链接</h3>
					</div>

					<ul class="list-group">
						<li class="list-group-item"><a href="#" target="_blank"
							title="门头沟介绍"> 门头沟介绍 </a>
						</li>
						<li class="list-group-item"><a href="#" target="_blank"
							title="大峪中学"> 大峪中学 </a>
						</li>
						<li class="list-group-item"><a href="#" target="_blank"
							title="Jflyfox博客"> Jflyfox博客 </a>
						</li>
					</ul>

				</div>
			</div>
		</div>

	</div>


	<div class="container">
		<footer class="mod-footer text-center">
			<div class="footer-box">
				<div class="inner-box">
					<a href="web" target="_blank">网站首页</a> <span>&nbsp;|&nbsp;</span> <a
						href="front/about/352.html" target="_blank">关于我们</a> <span>&nbsp;|&nbsp;</span>
					<a href="front/about/353.html" target="_blank">联系我们</a> <span>&nbsp;|&nbsp;</span>
					<a href="front/about/355.html" target="_blank">广告服务</a> <span>&nbsp;|&nbsp;</span>
					<a href="front/about/351.html" target="_blank">捐赠我们</a> <span>&nbsp;|&nbsp;</span>
					<a
						href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=allcU1tTW15dWiobG0QJBQc"
						target="_blank">给我写信</a> <span>&nbsp;|&nbsp;</span> <a
						href="front/about/354.html" target="_blank">免责声明</a>
				</div>
				<div class="copy-box">
					<span></span><a href="http://www.miitbeian.gov.cn/" target="_blank">京ICP备15023826号-1</a>
				</div>
			</div>
		</footer>
	</div>

	<!-- 底部广告 -->
	<!-- 
<script type="text/javascript">
    /*底部广告*/
    var cpro_id = "u2144690";
</script>
<script src=" http://su.bdimg.com/static/dspui/js/uf.js" type="text/javascript"></script>
 -->

	<a id="scrollTop" href="javacript:void(0);" title="返回顶部"
		style="display: inline;"></a>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
</body>
</html>