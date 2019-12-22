<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<#--  picAndTopicList macro的名字主要是视频  模板  项目列表  list数据集合   channelNum栏目id channelName栏目名-->
<#macro picAndTopicList list channelNum channelName>
	<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="channel/${channelNum}" target="_blank">${channelName}</a> <a class="more"
								href="channel/${channelNum}" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<#list list as l>
								<#if l_index <3>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/${l.id}" target="_blank"> <img
												alt="${l.title }" src="<%=request.getContextPath()%>/resources/upload/thumbnail/${(l.newName)!zanwutupian.jpg}" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/${l.id}" target="_blank">${l.title }</a>
											</div>
										</div>
									</div>
								</#if>
							</#list>
						</div>
						<div class="row">
							<#list list as l>
								<#if l_index gte 3>
									<div class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/${l.id}" target="_blank"> <img
												alt="${l.title }" src="<%=request.getContextPath()%>/resources/upload/thumbnail/${(l.newName)!zanwutupian.jpg}" data-holder-rendered="true"
												style="height: 157px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/${l.id}" target="_blank">${l.title }</a>
											</div>
										</div>
									</div>
								</#if>
							</#list>
						</div>
						<div class="row"></div>

					</div>
				</div>
</#macro>

<#macro topicList list channelNum channelName>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="channel/${channelNum}" target="_blank">${channelName}</a> <a class="more"
								href="channel/${channelNum}" target="_blank">更多</a>
						</h3>
					</div>
					<div class="panel-body" style="padding-bottom:0px;">
						<div class="row">
							<#list list as l>
								<#if l_index <2>
									<div class="col-md-6">
										<div class="thumbnail">
											<a href="<%=request.getContextPath()%>/topic/${l.id}" target="_blank"> <img
												alt="${l.title }" src="<%=request.getContextPath()%>/resources/upload/thumbnail/${(l.newName)!zanwutupian.jpg}" data-holder-rendered="true"
												style="height: 120px; width: 100%; display: block;"> </a>
											<div class="caption">
												<a href="<%=request.getContextPath()%>/topic/${l.id}" target="_blank">${l.title }</a>
											</div>
										</div>
									</div>
								</#if>
							</#list>
						</div>
					</div>

					<ul class="list-group">
						<#list list as l>
							<#if l_index gte 2>
								<li class="list-group-item"><span class="badge">${(l.publishDate)?string("MM-dd")}</span>
									<a href="topic/${l.id}" target="_blank"
									title="${l.title}">
										<#if l.title?length gt 25>
											${l.title[0..25]}...
										<#else>
											${l.title}
										</#if>
									</a>
								</li>
							</#if>
						</#list>
					</ul>
				</div>
</#macro>

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
							<#list pics as pic>
								<li data-target="#carousel-example-generic" data-slide-to="${pic_index}"
									<#if pic_index==0>class="active"</#if>></li>
							</#list>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
								<#list pics as pic>
									<div style="height: 300px;" class="item <#if pic_index==0>active</#if> ">
										<a href="${pic.linkUrl}" target="_blank"> <img src="<%=request.getContextPath()%>/resources/indexPic/${pic.newName}" alt="${pic.title}"></a>
										<div class="carousel-caption">
											<h4></h4>
											<p>${pic.title}</p>
										</div>
									</div>
								</#list>
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
						<#list jswz as topic>
							<li class="list-group-item"><span class="badge">${(topic.publishDate)?string("MM-dd")}</span>
								<span class="label <#if topic_index+1 lt 4>label-success<#else>label-info</#if>">${topic_index+1}</span> <a href="topic/${topic.id}"
								target="_blank" title="${topic.title}">
									<#if topic.title?length gt 20>
										${topic.title[0..20]}...
									<#else>
										${topic.title}
									</#if>
								</a>
							</li>
						</#list>
						<#if jswz?size gt 0>
							<li class="list-group-item"><span> <a href="channel/7"
									target="_blank" title="更多"> 更多... </a> </span>
							</li>
						</#if>
					</ul>
				</div>
			</div>
		</div>
		<!-- 广告位 -->
		
		<!-- 广告位end -->
		<div class="row">

			<div class="col-md-8">
				<!-- 学习视频 -->
				<@picAndTopicList list=studyList channelNum=11 channelName="学习视频"/>
				<!-- 学习视频 -->
				<!-- 项目案例 -->
				<@picAndTopicList list=projectList channelNum=26 channelName="项目案例"/>
				<!-- 项目案例 -->
				<!-- 网站模板 -->
				<@picAndTopicList list=mubanList channelNum=15 channelName="网站模板"/>
				<!-- 网站模板 -->
			</div>

			<div class="col-md-4">

				<!-- 开发API -->
				<@topicList list=APIList channelNum=29 channelName="开发API"/>
				<!-- 开发API -->
				<!-- 广告 -->
				
				<!-- 资源下载 -->
				<@topicList list=utilList channelNum=20 channelName="资源下载 "/>

				<!-- 友情链接 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">友情链接</h3>
					</div>

					<ul class="list-group">
						<#list cmsLinkList as link>
							<li class="list-group-item"><a href="${link.url}" target="_blank"
								title="${link.title}"> ${link.title} </a>
							</li>
						</#list>
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
