package org.xupan.cms.weixin.controller;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xupan.cms.model.WeiXinUser;
import org.xupan.cms.weixin.service.IWeiXinUserService;
import org.xupan.cms.weixin.service.IWeixinGroupService;

@RequestMapping("/admin/weixinUser")
@Controller
public class WeiXinUserController {
	@Inject
	private IWeiXinUserService weixinUserService;
	@Inject
	private IWeixinGroupService wGroupService;
	
	/*@Inject
	private IWeixinQrService weixinQrService;
	@Inject
	private IKfService kfService;*/
	/**
	 * 获得所有的用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("weiXinUsers", weixinUserService.list());
		return "weixinUser/list";	
	}
	/**
	 * 添加用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("weiXinUser", new WeiXinUser());
		model.addAttribute("groups",wGroupService.queryAll());
		return "weixinUser/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(WeiXinUser user) {
		user.setBind(0);
		weixinUserService.add(user);
		return "redirect:/admin/weixinUser/list";
	}
	
	@RequestMapping(value="/updateStatus/{id}",method=RequestMethod.GET)
	public String updateStatus(@PathVariable int id) {
		weixinUserService.updateStatus(id);
		return "redirect:/admin/weixinUser/list";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		WeiXinUser u = weixinUserService.load(id);
		model.addAttribute("weiXinUser",u);
		model.addAttribute("groups",wGroupService.queryAll());
		return "weixinUser/update";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,WeiXinUser user) {
		WeiXinUser tu = weixinUserService.load(id);
		tu.setNickname(user.getNickname());
		tu.setPassword(user.getPassword());
		weixinUserService.update(tu);
		return "redirect:/admin/weixinUser/list";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		weixinUserService.delete(id);
		return "redirect:/admin/weixinUser/list";
	}
	
	/*@RequestMapping(value="/bindNewUser",method=RequestMethod.GET)
	public String bindNewUser(Model model,HttpSession session,HttpServletResponse resp) throws IOException {
		WeiXinUser u = (WeiXinUser)session.getAttribute("weixinUser");
		if(u==null) resp.sendRedirect("/index/login");
		System.out.println(u.getBind());
		if(u.getBind()==1) return "redirect:/weixinUser/list";
		model.addAttribute("user", u);
		return "weixinUser/bindNewUser";
	}
	
	
	@RequestMapping(value="/bindNewUser",method=RequestMethod.POST)
	public String bindNewUser(String username,String password,HttpSession session,HttpServletResponse resp) throws IOException {
		WeiXinUser u = (WeiXinUser)session.getAttribute("weiXinUser");
		if(u==null) resp.sendRedirect("/weixinUser/login");
		System.out.println(username);
		WeiXinUser tu = weixinUserService.load(u.getId());
		tu.setBind(1);
		tu.setUsername(username);
		tu.setPassword(password);
		weixinUserService.update(tu);
		session.setAttribute("weiXinUser", tu);
		return "redirect:/admin/weixinUser/list";
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
		return "redirect:/admin/weixinUser/list";
	}
	*/

	@RequestMapping(value="/forgetPwd",method=RequestMethod.GET)
	public String forgetPassword(HttpSession session,Model model) {
		WeiXinUser u = (WeiXinUser)session.getAttribute("weiXinUser");
		if(u.getBind()==0) {
			throw new RuntimeException("请绑定用户之后才能在微信中修改密码！");
		}
		model.addAttribute("weiXinUser", u);
		return "weixinUser/forgetPwd";
		
	}
	
	@RequestMapping(value="/forgetPwd",method=RequestMethod.POST)
	public String forgetPassword(HttpSession session,String password) {
		WeiXinUser u = (WeiXinUser)session.getAttribute("weiXinUser");
		if(u.getBind()==0) {
			throw new RuntimeException("请绑定用户之后才能在微信中修改密码！");
		}
		u.setPassword(password);
		weixinUserService.update(u);
		return "redirect:/admin/weixinUser/list";
		
	}
	/*@RequestMapping(value="/qrlogin")
	public String qrlogin(Model model,HttpServletRequest request) {
		WeixinQr wq = generateLoginQr();
		weixinQrService.add(wq, request);
		model.addAttribute("wq", wq);
		return "user/qrlogin";
	}
	@RequestMapping(value="checkqrlogin")
	public void checkqrlogin(int snum,HttpSession session,HttpServletResponse resp) throws IOException {
		WeixinQr wq = weixinQrService.loadBySnum(snum);
		resp.setContentType("text/txt");
		if(wq.getQrData()!=null&&wq.getStatus()==1) {
			String openid = wq.getQrData();
			User u = userService.loadByOpenid(openid);
			session.setAttribute("user", u);
			resp.getWriter().println(1);
		} else {
			resp.getWriter().println(0);
		}
		
	}
	
	private WeixinQr generateLoginQr() {
		WeixinQr wq = new WeixinQr();
		wq.setName("扫码登录");
		wq.setMsg("扫码登录");
		wq.setSnum(RandomUtils.nextInt()+(WeixinQr.MAX_BASE_SNUM+1));
		wq.setStatus(0);
		wq.setType(WeixinQr.TEMP_LOGIN);
		return wq;
	}
	
	@RequestMapping(value="addKf",method=RequestMethod.GET)
	public String addKf() {
		return "user/addKf";
	}
	
	@RequestMapping(value="addKf",method=RequestMethod.POST)
	public String addKf(String account,String password,String nickname) {
		kfService.add(account, nickname, password);
		return "user/addKf";
	}
	*/
}
