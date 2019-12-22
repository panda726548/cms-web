package org.xupan.cms.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.xupan.basic.util.Captcha;
import org.xupan.cms.model.Channel;
import org.xupan.cms.model.Role;
import org.xupan.cms.model.RoleType;
import org.xupan.cms.model.User;
import org.xupan.cms.model.WeiXinUser;
import org.xupan.cms.service.IChannelService;
import org.xupan.cms.service.ICmsLinkService;
import org.xupan.cms.service.IIndexService;
import org.xupan.cms.service.IKeywordService;
import org.xupan.cms.service.ITopicService;
import org.xupan.cms.service.IUserService;
import org.xupan.cms.web.CmsSessionContext;
import org.xupan.cms.weixin.service.IWeiXinUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private IUserService userService;
	private ITopicService topicService;
	private ICmsLinkService cmsLinkService;
	private IKeywordService keyworkService;

	private IWeiXinUserService weixinUserService;
	private IIndexService indexService;
	private IChannelService channelService;
	
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}


	public IIndexService getIndexService() {
		return indexService;
	}

	
	@Inject
	public void setIndexService(IIndexService indexService) {
		this.indexService = indexService;
	}

	public IWeiXinUserService getWeixinUserService() {
		return weixinUserService;
	}

	@Inject
	public void setWeixinUserService(IWeiXinUserService weixinUserService) {
		this.weixinUserService = weixinUserService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}

	@Inject
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

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

	public IUserService getUserService() {
		return userService;
	}
	
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,String checkcode,Model model,HttpSession session) {
		String cc = (String)session.getAttribute("cc");
		if(!cc.equals(checkcode)) {
			model.addAttribute("error","验证码出错，请重新输入");
			return "admin/login";
		}
		User loginUser = userService.login(username, password);
		session.setAttribute("loginUser", loginUser);
		List<Role> rs = userService.listUserRoles(loginUser.getId());
		boolean isAdmin = isRole(rs,RoleType.ROLE_ADMIN);
		session.setAttribute("isAdmin", isAdmin);
		if(!isAdmin) {
			session.setAttribute("allActions", getAllActions(rs, session));
			session.setAttribute("isAudit", isRole(rs,RoleType.ROLE_AUDIT));
			session.setAttribute("isPublish", isRole(rs,RoleType.ROLE_PUBLISH));
		}
		session.removeAttribute("cc");
		CmsSessionContext.addSessoin(session);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
	public String userlogin(Model model) {
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/login";
	}
	
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	public String userlogin(String username,String password,String checkcode,Model model,HttpSession session) {
		String cc = (String)session.getAttribute("cc");
		if(!cc.equals(checkcode)) {
			model.addAttribute("error","验证码出错，请重新输入");
			model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
			model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
			model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
			return "index/login";
		}
		WeiXinUser u = weixinUserService.login(username, password);
		session.setAttribute("weixinUser", u);
		session.removeAttribute("cc");
		CmsSessionContext.addSessoin(session);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/exit")
	public String exit(HttpSession session) {
		session.removeAttribute("weixinUser");
		return "redirect:/index";
	}
	
	@RequestMapping(value="/changPwd",method=RequestMethod.GET)
	public String changPassword(HttpSession session,Model model) {
		WeiXinUser u = (WeiXinUser)session.getAttribute("weixinUser");
		if(u.getBind()==0) {
			throw new RuntimeException("请绑定用户之后才能在微信中修改密码！");
		}
		///model.addAttribute("weiXinUser", u);
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/changPwd";
		
	}
	@RequestMapping(value="/changPwd/{id}",method=RequestMethod.POST)
	public void changPassword(@PathVariable int id,String password,Model model,HttpServletResponse response,HttpSession session) throws IOException {
		WeiXinUser u = weixinUserService.load(id);
		u.setPassword(password);
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		weixinUserService.update(u);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		session.removeAttribute("weixinUser");
		out.write("<script>alert('修改密码成功！请重新登录！');location.href='/userlogin'</script>");
		out.flush();
		out.close();
		//return "index/changPwd";
		
	}
	@RequestMapping(value="/updateWxUser/{id}",method=RequestMethod.GET)
	public String updateWxUser(@PathVariable int id,Model model) {
		WeiXinUser u = weixinUserService.load(id);
		model.addAttribute("weiXinUser",u);
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/editwxuser";
	}
	
	@RequestMapping(value="/updateWxUser/{id}",method=RequestMethod.POST)
	public void updateWxUser(@PathVariable int id,WeiXinUser user,Model model,HttpServletResponse response) throws IOException {
		WeiXinUser tu = weixinUserService.load(id);
		tu.setUsername(user.getUsername());
		tu.setNickname(user.getNickname());
		tu.setSex(user.getSex());
		weixinUserService.update(tu);
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		PrintWriter out=response.getWriter();
		out.write("<script>alert('修改用户信息成功！');localtion.href='/index'</script>");
		out.flush();
		out.close();
		//return "redirect:/index";
	}
	
	@RequestMapping(value="/userregister",method=RequestMethod.GET)
	public String userregister(Model model) {
		model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
		model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
		model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
		model.addAttribute("weiXinUser", new WeiXinUser());
		List<Channel> cs = channelService.listTopNavChannel();
		model.addAttribute("navs", cs);
		return "index/register";
	}
	
	@RequestMapping(value="/userregister",method=RequestMethod.POST)
	public String userregister(@Valid WeiXinUser weiXinUser,String checkcode,Model model,HttpSession session) {
		String cc = (String)session.getAttribute("cc");
		if(!cc.equals(checkcode)) {
			model.addAttribute("error","验证码出错，请重新输入");
			model.addAttribute("cmsLinkList", cmsLinkService.listByType("友情链接"));
			model.addAttribute("recommendList", topicService.ListRecommendTopic(null,10));
			model.addAttribute("keywords", keyworkService.getMaxTimesKeyword(30));
			List<Channel> cs = channelService.listTopNavChannel();
			model.addAttribute("navs", cs);
			return "index/register";
		}
		weiXinUser.setBind(0);
		weiXinUser.setGroupId(0);
		weiXinUser.setStatus(1);
		weixinUserService.add(weiXinUser);
		session.removeAttribute("cc");
		return "redirect:/index";
	}
	
	
	@SuppressWarnings("unchecked")
	private Set<String> getAllActions(List<Role> rs,HttpSession session) {
		Set<String> actions = new HashSet<String>();
		Map<String,Set<String>> allAuths = (Map<String,Set<String>>)session.getServletContext().getAttribute("allAuths");
		actions.addAll(allAuths.get("base"));
		for(Role r:rs) {
			if(r.getRoleType()==RoleType.ROLE_ADMIN) continue;
			actions.addAll(allAuths.get(r.getRoleType().name()));
		}
		return actions;
	}
	
	
	private boolean isRole(List<Role> rs,RoleType rt) {
		for(Role r:rs) {
			if(r.getRoleType()==rt) return true;
		}
		return false;
	}
	
	
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp,HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 200;
		int height = 30;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
}
