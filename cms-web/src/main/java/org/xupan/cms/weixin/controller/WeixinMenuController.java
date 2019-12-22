package org.xupan.cms.weixin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xupan.cms.dto.TreeDto;
import org.xupan.cms.weixin.model.WeixinMenu;
import org.xupan.cms.weixin.model.WeixinMenuTree;
import org.xupan.cms.weixin.service.IWMenuService;
import org.xupan.cms.weixin.service.IWeixinMenuService;
@Controller
@RequestMapping("/admin/weixinMenu")
public class WeixinMenuController {
	@Inject
	private IWeixinMenuService weixinMenuService;
	@Inject
	private IWMenuService wMenuService;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		//model.addAttribute("menus",weixinMenuService.listAll());
		//model.addAttribute("wmds", weixinMenuService.generateWeixinMenuDto());
		return "weixin/list";
	}
	
	@RequestMapping("/weixinMenu/{pid}")
	public String listChild(@PathVariable Integer pid,@Param Integer refresh,Model model) {
		WeixinMenu wm = null;
		if(refresh==null) {
			model.addAttribute("refresh",0);
		} else {
			model.addAttribute("refresh",1);
		}
		if(pid==null||pid<=0) {
			wm = new WeixinMenu();
			wm.setName(WeixinMenu.ROOT_NAME);
			wm.setPid(pid);
			wm.setUrl(null);
		} else
		wm = weixinMenuService.load(pid);
		model.addAttribute("pc", wm);
		model.addAttribute("weixinMenu",weixinMenuService.listByParent(pid));
		return "weixin/list_child";
	}
	
	@RequestMapping("/treeAll")
	public @ResponseBody List<WeixinMenuTree> tree() {
		return weixinMenuService.generateTree();
	}
	
	@RequestMapping(value="/treeAs",method=RequestMethod.POST)
	public @ResponseBody List<TreeDto> tree(@Param Integer pid) {
		List<TreeDto> tds = new ArrayList<TreeDto>();
		if(pid==null||pid<=0) {
			tds.add(new TreeDto(0,"微信菜单",null,1));
			return tds;
		}
		List<WeixinMenuTree> wmts = weixinMenuService.generateTreeByParent(pid);
		for(WeixinMenuTree wm:wmts) {
			tds.add(new TreeDto(wm.getId(),wm.getName(),wm.getUrl(),1));
		}
		return tds;
	}
	
	private void initAdd(Model model,Integer pid) {
		if(pid==null) pid = 0;
		WeixinMenu wm = null;
		if(pid==0) {
			wm = new WeixinMenu();
			wm.setName(WeixinMenu.ROOT_NAME);
			wm.setId(WeixinMenu.ROOT_ID);
			wm.setUrl(null);
			wm.setPid(pid);
		} else{
			wm = weixinMenuService.load(pid);
		}
		model.addAttribute("pc", wm);
	}
	
	@RequestMapping(value="/add/{pid}",method=RequestMethod.GET)
	public String add(@PathVariable Integer pid,Model model){
		initAdd(model, pid);
		model.addAttribute("menu",new WeixinMenu());
		return "weixin/add";
	}
	
	@RequestMapping(value="/add/{pid}",method=RequestMethod.POST)
	public String add(@PathVariable Integer pid,WeixinMenu menu,BindingResult br,Model model){
		if(br.hasErrors()) {
			initAdd(model, pid);
			return "weixin/add";
		}
		System.out.println(menu);
		weixinMenuService.add(menu);
		return "redirect:/admin/weixinMenu/weixinMenu/"+pid+"?refresh=1";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("menu", weixinMenuService.load(id));
		return "weixin/add";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,WeixinMenu menu) {
		Integer pid=0;
		WeixinMenu twm = weixinMenuService.load(id);
		twm.setContent(menu.getContent());
		twm.setName(menu.getName());
		twm.setRespType(menu.getRespType());
		twm.setType(menu.getType());
		twm.setUrl(menu.getUrl());
		twm.setRespType(menu.getRespType());
		pid=twm.getPid();
		weixinMenuService.update(twm);
		return "redirect:/admin/weixinMenu/weixinMenu/"+pid+"?refresh=1";
	}
	
	@RequestMapping(value="/delete/{pid}/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable Integer pid,@PathVariable int id,Model model) {
		weixinMenuService.delete(id);
		
		return "redirect:/admin/weixinMenu/weixinMenu/"+pid+"?refresh=1";
	}
	
	@RequestMapping("/queryPublishMenu")
	public String queryPublish(Model model) {
		model.addAttribute("ms", wMenuService.queryMenu());
		return "weixin/queryPublishMenu";
	}
	
	@RequestMapping("/publishMenu")
	public void publishMenu(HttpServletResponse resp) throws IOException {
		wMenuService.publishMenu();
		resp.setContentType("text/xml;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("菜单发布成功！");
		//return "admin/weixinMenu/list";
	}
	
	
	
}
