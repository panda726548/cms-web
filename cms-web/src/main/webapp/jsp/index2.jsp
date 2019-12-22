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

    <link href="<%=request.getContextPath() %>/resources/css/index/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/index/style.css" rel="stylesheet">

  </head>
  <body>

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
      <a class="navbar-brand" href=""><img alt="Brand" width="20" height="20" src="static/front/logo.png"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
      <form class="navbar-form navbar-left" role="search" name="search_form" method="post">
		<div class="form-group input-group">
		  <input type="text" class="form-control" name="search_header" placeholder="搜索...">
		  <span class="input-group-btn">
			<button class="btn btn-default" type="button" id="search_btn">搜索</button>
		  </span>
		</div>
      </form>
      <ul class="nav navbar-nav navbar-right">
			<li><a href="web/login">登录</a></li>
			<li class=""><a href="front/regist" >注册</a></li>
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



		
<div class="container">

	<div class="row">
		<div class="col-md-12">	
	
		<div class="panel panel-default">
			 <div class="panel-body" style="padding:0px;">
			<ol class="breadcrumb" style="margin:0px;">
			  <li><a href="home">首页</a></li>
			  <li class="active"><a href="news">技术文章</a></li>
			</ol>
			</div>
		</div>
	
		</div>
	</div>

	<div class="row">
	<!-- 文章 -->
	<div class="col-md-8">	
		<div class="panel panel-default">
		  <div class="panel-heading">
			<h3 class="panel-title">技术文章</h3>
		  </div>
		  	 <!-- 文章列表 -->
	 	 <ul class="list-group">
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	<li class="list-group-item">
		<div class="row">
		  <div class="col-md-2">
		  	<div class="thumbnail">
		  	  			  <img src="download/image_url/20150525_233451_151572.jpg" alt="#" height="85" data-holder-rendered="true"
			  	 style="height: 85px; width: 100%; display: block;" >
			</div>
		  </div>
		  <div class="col-md-10">
				<h4>
				<a href="front/article/112.html" target="_blank" title="JSONObject使用方法">
					JSONObject使用方法
				</a>
				
 					<div class="pull-right" style="font-size:12px;">
					
					<!-- 编辑区 -->
						<a href="front/article/112.html" target="_blank"><span>查看全部</span></a>
					</div>
				</h4>
				
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包，http://files.cnblogs.com/java-pan/lib.rar提供了除JSONObject的jar之外依赖的其他6个jar包，一共7个jar文件
				</p>
				
				<footer>
					<div class="pull-left" >
						<small>发布时间：2015-04-20</small>
					</div>
					<div class="pull-right" >
						<a href="front/article/112.html#article_comment" style="vertical-align: middle;"   target="_blank"><small>评论(36)</small></a>
						&nbsp;
						<small style="vertical-align: middle;" >浏览量(2037)</small>
						&nbsp;
					</div>
				</footer>
		  </div>
		 </div>
	</li>
	 	
	<li class="list-group-item">
	 	<!--分页-->
	<nav>
		<ul class="pagination" style="margin: 0px;">
			<li class="page active"><a href="http://www.jflyfox.com:80/mtg/news?pageNo=1">1</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=2">2</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=3">3</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=4">4</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=5">5</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=6">6</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=7">7</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=8">8</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=9">9</a></li>
			<li class="page "><a href="http://www.jflyfox.com:80/mtg/news?pageNo=10">10</a></li>
			<li class="page"><a href="http://www.jflyfox.com:80/mtg/news?pageNo=25">25</a></li>
			<li class="page next"><a href="http://www.jflyfox.com:80/mtg/news?pageNo=2">&gt;</a></li>
		</ul>
	</nav>
	</li>
  </ul>
		</div>
	</div>
	
	<!-- 信息列表 -->
	<div class="col-md-4">	
    	<!--广告栏-->
		<div class="panel panel-default">
		  
		</div>
		
		<!-- 推荐文章 -->
<div class="panel panel-default">
  <div class="panel-heading">
	<h3 class="panel-title">推荐文章<a class="more" href="front/article/recommend">更多</a></h3>
  </div>
	<ul class="list-group">
			<li class="list-group-item">
				<span class="badge">04-20</span>
				<a href="front/article/112.html" target="_blank" title="S1线6号线西延 明年年底开通">
					S1线6号线西延 明年年底开通
				</a>
			</li>
			<li class="list-group-item">
				<span class="badge">06-30</span>
				<a href="front/article/673.html" target="_blank" title="门头沟新桥炸鸡店">
					门头沟新桥炸鸡店
				</a>
			</li>
			<li class="list-group-item">
				<span class="badge">05-24</span>
				<a href="front/article/340.html" target="_blank" title="门头沟新新包子铺">
					门头沟新新包子铺
				</a>
			</li>
			<li class="list-group-item">
				<span class="badge">05-28</span>
				<a href="front/article/398.html" target="_blank" title="惠康嘉园">
					惠康嘉园
				</a>
			</li>
			<li class="list-group-item">
				<span class="badge">05-24</span>
				<a href="front/article/343.html" target="_blank" title="大峪中学">
					大峪中学
				</a>
			</li>
			<li class="list-group-item">
				<span class="badge">05-24</span>
				<a href="front/article/333.html" target="_blank" title="妙峰山">
					妙峰山
				</a>
			</li>
			<li class="list-group-item">
				<span class="badge">05-24</span>
				<a href="front/article/329.html" target="_blank" title="百花山">
					百花山
				</a>
			</li>
			<li class="list-group-item">
				<span class="badge">05-24</span>
				<a href="front/article/327.html" target="_blank" title="潭柘寺">
					潭柘寺
				</a>
			</li>
	  </ul>
</div>		
		<!-- 广告 -->
<div class="panel panel-default" style="padding: 5px 0px 5px 10px;">
    <!-- 创意广告  -->
    <script type="text/javascript">
	    var cpro_id="u2214479";
	    (window["cproStyleApi"] = window["cproStyleApi"] || {})[cpro_id]={at:"3",rsi0:"336",rsi1:"280",pat:"17",tn:"baiduCustNativeAD",rss1:"#FFFFFF",conBW:"1",adp:"1",ptt:"0",titFF:"",titFS:"14",rss2:"#000000",titSU:"0"}
	</script>
	<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
	
	<!-- 右侧广告  -->                        
 <!--
  <script type="text/javascript">
    var cpro_id = "u2145342";
	</script>
	<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
	-->
</div>		
		<!-- 友情链接 -->
<div class="panel panel-default">
  <div class="panel-heading">
	<h3 class="panel-title">友情链接</h3>
  </div>
  
  <ul class="list-group">
		<li class="list-group-item">
			<a href="#" target="_blank" title="门头沟介绍">
				门头沟介绍
			</a>
		</li>
		<li class="list-group-item">
			<a href="#" target="_blank" title="大峪中学">
				大峪中学
			</a>
		</li>
		<li class="list-group-item">
			<a href="#" target="_blank" title="Jflyfox博客">
				Jflyfox博客
			</a>
		</li>
  </ul>
  
</div>		</div>
	</div>

</div>
	
<div class="container">
	<footer class="mod-footer text-center">
		<div class="footer-box">
			<div class="inner-box">
											<a href="web" target="_blank">网站首页</a>
							<span>&nbsp;|&nbsp;</span>
											<a href="front/about/352.html" target="_blank">关于我们</a>
							<span>&nbsp;|&nbsp;</span>
											<a href="front/about/353.html" target="_blank">联系我们</a>
							<span>&nbsp;|&nbsp;</span>
											<a href="front/about/355.html" target="_blank">广告服务</a>
							<span>&nbsp;|&nbsp;</span>
											<a href="front/about/351.html" target="_blank">捐赠我们</a>
							<span>&nbsp;|&nbsp;</span>
											<a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=allcU1tTW15dWiobG0QJBQc" target="_blank">给我写信</a>
							<span>&nbsp;|&nbsp;</span>
											<a href="front/about/354.html" target="_blank">免责声明</a>
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
	
<a id="scrollTop" href="javacript:void(0);" title="返回顶部" style="display: inline;"></a>

    <script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
  </body>
</html>