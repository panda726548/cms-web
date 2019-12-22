<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
								<li data-target="#carousel-example-generic" data-slide-to="1"
									></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"
									></li>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
									<div style="height: 300px;" class="item active ">
										<a href="http://pan.baidu.com/s/1kUw1Z3D" target="_blank"> <img src="<%=request.getContextPath()%>/resources/indexPic/1452661984226.png" alt="非常详细Hibernate 3帮助文档"></a>
										<div class="carousel-caption">
											<h4></h4>
											<p>非常详细Hibernate 3帮助文档</p>
										</div>
									</div>
									<div style="height: 300px;" class="item  ">
										<a href="http://pan.baidu.com/s/1eQLy246" target="_blank"> <img src="<%=request.getContextPath()%>/resources/indexPic/1452661867220.png" alt="H-ui Admin后台模板"></a>
										<div class="carousel-caption">
											<h4></h4>
											<p>H-ui Admin后台模板</p>
										</div>
									</div>
									<div style="height: 300px;" class="item  ">
										<a href="http://pan.baidu.com/s/1bwexJo" target="_blank"> <img src="<%=request.getContextPath()%>/resources/indexPic/1452661715247.png" alt="jquery1.8.3帮助文档"></a>
										<div class="carousel-caption">
											<h4></h4>
											<p>jquery1.8.3帮助文档</p>
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
							<li class="list-group-item"><span class="badge">01-22</span>
								<span class="label label-success">1</span> <a href="topic/31"
								target="_blank" title="使用hibernate的hql查询一个月、一周内的数据">
										使用hibernate的hql查询一个月、...
								</a>
							</li>
							<li class="list-group-item"><span class="badge">01-22</span>
								<span class="label label-success">2</span> <a href="topic/30"
								target="_blank" title="构建一个基于 Spring 的 RESTful Web Service">
										构建一个基于 Spring 的 RESTf...
								</a>
							</li>
							<li class="list-group-item"><span class="badge">01-01</span>
								<span class="label label-success">3</span> <a href="topic/7"
								target="_blank" title="JavaMail 保证邮件发送成功的方法总结">
										JavaMail 保证邮件发送成功的方法总...
								</a>
							</li>
							<li class="list-group-item"><span class="badge">12-30</span>
								<span class="label label-info">4</span> <a href="topic/5"
								target="_blank" title="最全面的常用正则表达式大全">
										最全面的常用正则表达式大全
								</a>
							</li>
							<li class="list-group-item"><span class="badge">12-26</span>
								<span class="label label-info">5</span> <a href="topic/4"
								target="_blank" title="REST API 最佳入门指南">
										REST API 最佳入门指南
								</a>
							</li>
							<li class="list-group-item"><span> <a href="channel/7"
									target="_blank" title="更多"> 更多... </a> </span>
							</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 广告位 -->
		
		<!-- 广告位end -->
		<div class="row">

			<div class="col-md-8">
				<!-- 学习视频 -->
	<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="channel/11" target="_blank">学习视频</a> <a class="more"
								href="channel/11" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/10" target="_blank"> <img
												alt="Mybatis视频教程" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452735542604.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/10" target="_blank">Mybatis视频教程</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/13" target="_blank"> <img
												alt="权限模型视频" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452735512927.jpg" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/13" target="_blank">权限模型视频</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/9" target="_blank"> <img
												alt="微信公众平台开发视频" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452735479361.jpg" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/9" target="_blank">微信公众平台开发视频</a>
											</div>
										</div>
									</div>
						</div>
						<div class="row">
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/12" target="_blank"> <img
												alt="WebService视频教程" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452735437389.jpg" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/12" target="_blank">WebService视频教程</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/11" target="_blank"> <img
												alt="SpringMVC视频" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452735358426.jpg" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/11" target="_blank">SpringMVC视频</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/8" target="_blank"> <img
												alt="Java基础学习视频" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452739041697.jpg" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/8" target="_blank">Java基础学习视频</a>
											</div>
										</div>
									</div>
						</div>
						<div class="row"></div>

					</div>
				</div>
				<!-- 学习视频 -->
				<!-- 项目案例 -->
	<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="channel/26" target="_blank">项目案例</a> <a class="more"
								href="channel/26" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/17" target="_blank"> <img
												alt="植物大战僵尸" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452650136533.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/17" target="_blank">植物大战僵尸</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/19" target="_blank"> <img
												alt="CRM客户管理系统" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452650841259.jpg" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/19" target="_blank">CRM客户管理系统</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/18" target="_blank"> <img
												alt="Javamall电子商城系统" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452650378805.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/18" target="_blank">Javamall电子商城系统</a>
											</div>
										</div>
									</div>
						</div>
						<div class="row">
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/16" target="_blank"> <img
												alt="电力智能巡检系统" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452649983136.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/16" target="_blank">电力智能巡检系统</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/15" target="_blank"> <img
												alt="代理商管理系统" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452649605805.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/15" target="_blank">代理商管理系统</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/14" target="_blank"> <img
												alt="SL会员商城系统" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452649296528.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/14" target="_blank">SL会员商城系统</a>
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
							<a href="channel/15" target="_blank">网站模板</a> <a class="more"
								href="channel/15" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/20" target="_blank"> <img
												alt="Ace Admin后台模板" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452747899939.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/20" target="_blank">Ace Admin后台模板</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/21" target="_blank"> <img
												alt="BUI前端框架" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452747954633.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/21" target="_blank">BUI前端框架</a>
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/22" target="_blank"> <img
												alt="H-ui Admin模板" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452747816653.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/22" target="_blank">H-ui Admin模板</a>
											</div>
										</div>
									</div>
						</div>
						<div class="row">
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/29" target="_blank"> <img
												alt="Modern_admin模板" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452735631295.png" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/29" target="_blank">Modern_admin模板</a>
											</div>
										</div>
									</div>
						</div>
						<div class="row"></div>

					</div>
				</div>
				<!-- 网站模板 -->
			</div>

			<div class="col-md-4">

				<!-- 开发API -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="channel/29" target="_blank">开发API</a> <a class="more"
								href="channel/29" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body" style="padding-bottom:0px;">
						<div class="row">
									<div class="col-md-6">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/25" target="_blank"> <img
												alt="jquery1.8.3帮助文档" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452656990437.png" data-holder-rendered="true"
												style="height: 120px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/25" target="_blank">jquery1.8.3帮助文档</a>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/24" target="_blank"> <img
												alt="JDK6_API帮助文档" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452656413677.jpg" data-holder-rendered="true"
												style="height: 120px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/24" target="_blank">JDK6_API帮助文档</a>
											</div>
										</div>
									</div>
						</div>
					</div>

					<ul class="list-group">
								<li class="list-group-item"><span class="badge">01-13</span>
									<a href="topic/23" target="_blank"
									title="Hibernate3帮助文档">
											Hibernate3帮助文档
									</a>
								</li>
					</ul>
				</div>
				<!-- 开发API -->
				<!-- 广告 -->
				
				<!-- 资源下载 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="channel/20" target="_blank">资源下载 </a> <a class="more"
								href="channel/20" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body" style="padding-bottom:0px;">
						<div class="row">
									<div class="col-md-6">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/26" target="_blank"> <img
												alt="MyEclipse10.6 " src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452659073749.jpg" data-holder-rendered="true"
												style="height: 120px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/26" target="_blank">MyEclipse10.6 </a>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/27" target="_blank"> <img
												alt="Dreamweaver绿色版（免安装）" src="<%=request.getContextPath()%>/resources/upload/thumbnail/1452659567702.jpg" data-holder-rendered="true"
												style="height: 120px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/27" target="_blank">Dreamweaver绿色版（免安装）</a>
											</div>
										</div>
									</div>
						</div>
					</div>

					<ul class="list-group">
								<li class="list-group-item"><span class="badge">01-13</span>
									<a href="topic/28" target="_blank"
									title="Screen2Exe屏幕录制软件">
											Screen2Exe屏幕录制软件
									</a>
								</li>
					</ul>
				</div>

				<!-- 友情链接 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">友情链接</h3>
					</div>

					<ul class="list-group">
							<li class="list-group-item"><a href="http://www.oschina.net/" target="_blank"
								title="开源中国"> 开源中国 </a>
							</li>
							<li class="list-group-item"><a href="http://down.51cto.com/" target="_blank"
								title="51CTO下载中心"> 51CTO下载中心 </a>
							</li>
					</ul>
					
				</div>
				<!-- 微信公众号 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">扫一扫关注微信公众号</h3>
					</div>

					<div class="thumbnail">
						<img src="resources/img/weixin.jpg" data-holder-rendered="true"
						style="height: 258px; width:258px; display: block;"> 
					</div>
				</div>
			</div>
		</div>

	</div>
