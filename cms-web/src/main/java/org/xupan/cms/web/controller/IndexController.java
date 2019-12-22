package org.xupan.cms.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xupan.basic.model.Pager;
import org.xupan.basic.model.SystemContext;
import org.xupan.cms.model.Attachment;
import org.xupan.cms.model.Channel;
import org.xupan.cms.model.ChannelType;
import org.xupan.cms.model.Topic;
import org.xupan.cms.model.WeiXinUser;
import org.xupan.cms.service.IAttachmentService;
import org.xupan.cms.service.IChannelService;
import org.xupan.cms.service.ICmsLinkService;
import org.xupan.cms.service.IKeywordService;
import org.xupan.cms.service.ITopicService;
import org.xupan.cms.web.BaseInfoUtil;
import org.xupan.cms.weixin.model.WeixinGroup;
import org.xupan.cms.weixin.service.IWeiXinUserService;
import org.xupan.cms.weixin.service.IWeixinGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	private IChannelService channelService;
	private IAttachmentService attachmentService;
	private IKeywordService keywordService;
	private ITopicService topicService;
	private ICmsLinkService cmsLinkService;
	private IKeywordService keyworkService;
	
	
	@Inject
	private IWeiXinUserService weixinUserService;
	@Inject
	private IWeixinGroupService wGroupService;
	public IKeywordService getKeyworkService() {
		return keyworkService;
	}

	@Inject
	public void setKeyworkService(IKeywordService keyworkService) {
		this.keyworkService = keyworkService;
	}

	public ICmsLinkService getCmsLinkService() {
		return cmsLinkService;
	}

	@Inject
	public void setCmsLinkService(ICmsLinkService cmsLinkService) {
		this.cmsLinkService = cmsLinkService;
	}

	public IKeywordService getKeywordService() {
		return keywordService;
	}
	@Inject
	public void setKeywordService(IKeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public IAttachmentService getAttachmentService() {
		return attachmentService;
	}
	
	@Inject
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}
	@Inject
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	@RequestMapping({"/","/index"})
	public String index(Model model,HttpSession session) {
		model.addAttribute("baseInfo", BaseInfoUtil.getInstacne().read());
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/index";
	}
	/**
	 * 免责声明
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/disclaimer",method=RequestMethod.GET)
	public String disclaimer(Model model) {
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/disclaimer";
	}
	/**
	 * 关于我们
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about(Model model) {
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/about";
	}
	
	@RequestMapping(value="/showinfo/{uid}")
	public String showinfo(@PathVariable int uid, Model model) {
		System.out.println("uid--------------->>>>"+uid);
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		WeiXinUser wxUser= weixinUserService.getWeiXinUserById(uid);
		model.addAttribute("wxUser", wxUser);
		if(wxUser.getOpenid()!=null){
			//根据用户组openid获得用户组的名字
			WeixinGroup  wxGroup=wGroupService.queryUserGroup(wxUser.getOpenid());
			model.addAttribute("wxGroup", wxGroup);
		}else{
			model.addAttribute("wxGroup", null);
		}
		
		return "index/showInfo";
	}
	
	@RequestMapping("/channel/{cid}")
	public String showChannel(@PathVariable int cid,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
		Channel c = channelService.load(cid);
	
		Channel pc = null;
		if(c.getType()==ChannelType.NAV_CHANNEL) {
			pc = c;
			//如果是导航栏目，需要获取该栏目中的第一个栏目
			c = channelService.loadFirstChannelByNav(c.getId());
		} else {
			pc = c.getParent();
		}
		System.out.println(c.getType()==ChannelType.TOPIC_LIST);
		System.out.println("栏目的类型>>>>>"+c.getType());
		if(c.getType()==ChannelType.TOPIC_CONTENT) {
			resp.sendRedirect(req.getContextPath()+"/topic/"+topicService.loadLastedTopicByColumn(cid).getId());
		} else if(c.getType()==ChannelType.TOPIC_IMG){
			SystemContext.setPageSize(15);
			SystemContext.setSort("t.publishDate");
			SystemContext.setOrder("desc");
			//Pager<Attachment> atts = attachmentService.findChannelPic(cid);
			Pager<Topic> topicPic=topicService.find(cid, null, 1);
			model.addAttribute("datas", topicPic);
			
		} else if(c.getType()==ChannelType.TOPIC_LIST) {
			SystemContext.setSort("t.publishDate");
			SystemContext.setOrder("desc");
			//System.out.println(c.getType());
			Pager<Topic> topicList=topicService.find(c.getId(),null,1);
			model.addAttribute("datas", topicList);
		}
		SystemContext.removeSort();
		SystemContext.removeOrder();
		model.addAttribute("pc", pc);
		model.addAttribute("cs", channelService.listUseChannelByParent(pc.getId()));
		model.addAttribute("channel", c);
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		System.out.println("推荐文章---------->>>>>>"+topicService.ListRecommendTopic(null,10).size());
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		if(c.getType()==ChannelType.TOPIC_LIST) {
			return "index/channel";
		} else {
			return "index/channel_pic";
		}
	}
	
	@RequestMapping("/topic/{tid}")
	public String showTopic(@PathVariable int tid, Model model) {
		model.addAttribute("topic", topicService.load(tid));
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		List<Attachment> atts = attachmentService.listAttachByTopic(tid);
		if(atts.size()>0) {
			model.addAttribute("hasAtts", true);
			model.addAttribute("atts", atts);
		} else {
			model.addAttribute("hasAtts",false);
		}
		return "index/topic";
	}
	
	@RequestMapping("/search/{con}")
	public String search(@PathVariable String con,Model model) {
		SystemContext.setOrder("asc");
		//SystemContext.setSort("c.orders");
		model.addAttribute("cs", channelService.listChannelByType(ChannelType.NAV_CHANNEL));
		//SystemContext.setOrder("desc");
		Pager<Topic> topics = topicService.searchTopic(con);
		emp(topics,con);
		model.addAttribute("datas", topics);
		model.addAttribute("con", con);
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/search";
	}
	
	@RequestMapping("/keyword/{con}")
	public String keyword(@PathVariable String con,Model model) {
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		SystemContext.setOrder("desc");
		//SystemContext.setSort("t.publishDate");
		Pager<Topic> topics = topicService.searchTopicByKeyword(con);
		emp(topics,con);
		model.addAttribute("datas", topics);
		model.addAttribute("con", con);
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/keyword";
	}

	private void emp(Pager<Topic> topics, String con) {
		for(Topic t:topics.getDatas()) {
			if(t.getTitle().contains(con)) {
				String tt = t.getTitle().replaceAll(con, "<span class='emp'>"+con+"</span>");
				t.setTitle(tt);
			}
		}
	}
	
	
	@RequestMapping(value="/bindNewUser",method=RequestMethod.GET)
	public String bindNewUser(Model model,HttpSession session,HttpServletResponse resp) throws IOException {
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		WeiXinUser u = (WeiXinUser)session.getAttribute("weixinUser");
		if(u==null) resp.sendRedirect("/index/login");
		System.out.println(u.getBind());
		if(u.getBind()==1) return "redirect:/weixinUser/list";
		model.addAttribute("wxuser", u);
		return "weixinUser/bindNewUser";
	}
	
	
	@RequestMapping(value="/bindNewUser",method=RequestMethod.POST)
	public String bindNewUser(String username,String password,String checkcode,HttpSession session,HttpServletResponse resp,Model model) throws IOException {
		String cc = (String)session.getAttribute("cc");
		if(!cc.equals(checkcode)) {
			model.addAttribute("error","验证码出错，请重新输入");
			model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
			model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
			model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
			return "index/login";
		}
		WeiXinUser u = (WeiXinUser)session.getAttribute("weixinUser");
		if(u==null) resp.sendRedirect("/index/login");
		System.out.println(username);
		WeiXinUser tu = weixinUserService.load(u.getId());
		tu.setBind(1);
		tu.setUsername(username);
		tu.setPassword(password);
		weixinUserService.update(tu);
		session.setAttribute("weixinUser", tu);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/bindExistUser",method=RequestMethod.GET)
	public String bindExistUser(Model model,HttpSession session,HttpServletResponse resp) throws IOException {
		WeiXinUser u = (WeiXinUser)session.getAttribute("weiXinUser");
		if(u==null) resp.sendRedirect("/weixinUser/login");
		if(u.getBind()==1) return "redirect:/weixinUser/list";
		return "weixinUser/bindExistUser";
	}
	
	@RequestMapping(value="/bindExistUser",method=RequestMethod.POST)
	public String bindExistUser(String username,String password,Model model,HttpSession session,HttpServletResponse resp) throws IOException {
		WeiXinUser u = (WeiXinUser)session.getAttribute("weiXinUser");
		if(u==null) resp.sendRedirect("/weixinUser/login");
		WeiXinUser tu = weixinUserService.loadByUsername(username);
		if(tu.getPassword().equals(password)) {
			tu.setBind(1);
			tu.setImgUrl(u.getImgUrl());
			tu.setSex(u.getSex());
			tu.setStatus(1);
			tu.setNickname(u.getNickname());
			tu.setOpenid(u.getOpenid());
			weixinUserService.update(tu);
			weixinUserService.delete(u.getId());
			session.setAttribute("weiXinUser", tu);
		} else {
			throw new RuntimeException("原始的密码输入出错!");
		}
		return "redirect:/weixinUser/list";
	}
	
	
	
	
	
	
	
}
