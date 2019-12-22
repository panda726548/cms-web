package org.xupan.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;

import org.xupan.basic.model.SystemContext;
import org.xupan.basic.util.FreemarkerUtil;
import org.xupan.basic.util.PropertiesUtil;
import org.xupan.cms.model.BaseInfo;
import org.xupan.cms.model.Channel;
import org.xupan.cms.model.ChannelType;
import org.xupan.cms.model.CmsLink;
import org.xupan.cms.model.IndexTopic;
import org.xupan.cms.model.Topic;
import org.xupan.cms.model.WeiXinUser;
import org.xupan.cms.web.BaseInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("indexService")
public class IndexService implements IIndexService {
	
	private String outPath;
	private FreemarkerUtil util;
	
	@Autowired(required=true)
	public IndexService(String ftlPath, String outPath) {
		super();
		if(util==null) {
			this.outPath = outPath;
			util = FreemarkerUtil.getInstance(ftlPath);
		}
	}

	private IChannelService channelService;
	private ITopicService topicService;
	private IIndexPicService indexPicService;
	private IKeywordService keyworkService;
	private ICmsLinkService cmsLinkService;
	
	
	public ICmsLinkService getCmsLinkService() {
		return cmsLinkService;
	}

	@Inject
	public void setCmsLinkService(ICmsLinkService cmsLinkService) {
		this.cmsLinkService = cmsLinkService;
	}

	
	public IKeywordService getKeyworkService() {
		return keyworkService;
	}
	
	@Inject
	public void setKeyworkService(IKeywordService keyworkService) {
		this.keyworkService = keyworkService;
	}
	public IIndexPicService getIndexPicService() {
		return indexPicService;
	}
	@Inject
	public void setIndexPicService(IIndexPicService indexPicService) {
		this.indexPicService = indexPicService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}
	
	@Inject
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}

	@Override
	public void generateTop() {
		System.out.println("=============重新生成了顶部信息====================");
		List<Channel> cs = channelService.listTopNavChannel();
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("navs", cs);
		root.put("baseInfo", BaseInfoUtil.getInstacne().read());
		String outfile = SystemContext.getRealPath()+outPath+"/top.jsp";
		util.fprint(root, "/top1.ftl", outfile);
		util.sprint(root, "/top1.ftl");
	}
	public void generateTop1(WeiXinUser u) {
		System.out.println("=============重新生成了顶部信息====================");
		List<Channel> cs = channelService.listTopNavChannel();
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("navs", cs);
		root.put("baseInfo", BaseInfoUtil.getInstacne().read());
		root.put("weixinUser", u);
		String outfile = SystemContext.getRealPath()+outPath+"/top.jsp";
		util.fprint(root, "/top1.ftl", outfile);
		util.sprint(root, "/top1.ftl");
	}

	@Override
	public void generateBottom() {
		System.out.println("=============重新生成了底部信息====================");
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("baseInfo", BaseInfoUtil.getInstacne().read());
		String outfile = SystemContext.getRealPath()+outPath+"/bottom.jsp";
		util.fprint(root, "/bottom1.ftl", outfile);
		util.sprint(root, "/bottom1.ftl");
	}

	@Override
	public void generateBody() {
		System.out.println("=========重新生成首页的内容信息==============");
		//1、获取所有的首页栏目
		List<Channel> cs = channelService.listAllIndexChannel(null);
		System.out.println("---------------首页栏目个数:---->>>>"+cs.size());
		/*//2、根据首页栏目创建相应的IndexTopic对象
		//加载indexChannel.properties
		Properties prop = PropertiesUtil.getInstance().load("indexChannel");
		Map<String,IndexTopic> topics = new HashMap<String, IndexTopic>();
		for(Channel c:cs) {
			int cid = c.getId();
			//System.out.println("栏目编号:"+cid);
			String[] xs = prop.getProperty(cid+"").split("_");
			for (int i = 0; i < xs.length; i++) {
				System.out.println(xs[i]);
			}
			String order = xs[0];
			int num = Integer.parseInt(xs[1]);
			IndexTopic it = new IndexTopic();
			it.setCid(cid);
			it.setCname(c.getName());
			List<Topic> tops = topicService.listTopicByChannelAndNumber(cid, num);
			//System.out.println("order:"+order+"<<<<<-------->>>>>"+cid+"<<<<<-->>>>>"+tops);
			it.setTopics(tops);
			topics.put(order, it);
			
		}
		IndexTopic ittopic = new IndexTopic();
		ittopic.setCid(31);
		ittopic.setCname("站长推荐");
		ittopic.setTopics(recommendList);
		topics.put("7",ittopic);
		
		
		
		System.out.println("站长推荐:--->"+recommendList);*/
		//获得技术文章
		List<Topic> jswzList=topicService.listTopicByChannelAndNumber(7, 5);
		//获得学习视频
		List<Topic> studyList=topicService.listTopicByChannelAndNumber(11, 6);
		System.out.println("------->>>>>>"+studyList);
		//获得开发API
		List<Topic> APIList=topicService.listTopicByChannelAndNumber(29, 10);
		//获得项目案例
		List<Topic> projectList=topicService.listTopicByChannelAndNumber(26, 6);
		//获得资源下载
		List<Topic> utilList=topicService.listTopicByChannelAndNumber(20, 10);
		//获得网站模板
		List<Topic> mubanList=topicService.listTopicByChannelAndNumber(15, 6);
		//获得友情链接
		List<CmsLink>  cmsLinkList=cmsLinkService.listByType("友情链接");
		
		//3、更新首页图片
		BaseInfo bi = BaseInfoUtil.getInstacne().read();
		int picnum = bi.getIndexPicNumber();
		String outfile = SystemContext.getRealPath()+outPath+"/body.jsp";
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("jswz", jswzList);
		root.put("studyList", studyList);
		root.put("APIList", APIList);
		root.put("projectList", projectList);
		root.put("mubanList", mubanList);
		root.put("utilList", utilList);
		root.put("cmsLinkList", cmsLinkList);
		root.put("pics", indexPicService.listIndexPicByNum(picnum));
		root.put("keywords", keyworkService.getMaxTimesKeyword(12));
		util.fprint(root, "/body4.ftl", outfile);
		util.sprint(root, "/body4.ftl");
	}

}
