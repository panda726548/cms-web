package org.xupan.cms.weixin.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xupan.cms.weixin.model.WeixinGroup;
import org.xupan.cms.weixin.service.IWeixinGroupService;
@Controller
@RequestMapping("/admin/weixinGroup")
public class WeixinGroupController {
	@Inject
	private IWeixinGroupService wGroupService;

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("datas",wGroupService.queryAll());
		return "weixinGroup/list";
	}
	
	@RequestMapping("/query/{openid}")
	public String list(@PathVariable String openid,Model model) {
		model.addAttribute("wg",wGroupService.queryUserGroup(openid));
		return "weixinGroup/query";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("wg", new WeixinGroup());
		return "weixinGroup/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(WeixinGroup wg) {
		wGroupService.addGroup(wg);
		return "redirect:/admin/weixinGroup/list";
	}
	
	
	
	@RequestMapping(value="/update/{id}/name/{name}",method=RequestMethod.GET)
	public String update(@PathVariable int id,@PathVariable String name,Model model) {
		/*String newName=null;
		try {
			newName=new String(name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		System.out.println("name:--------->>>>>"+name);
		WeixinGroup wg=new WeixinGroup();
		wg.setId(id);
		wg.setName(name);
		model.addAttribute("wg",wg);
		return "weixinGroup/update";
	}
	
	@RequestMapping(value="/update/{id}/name/{name}",method=RequestMethod.POST)
	public String update(WeixinGroup wg) {
		System.out.println(wg.getId()+","+wg.getName());
		wGroupService.updateGroupName(wg.getId(), wg.getName());
		return "redirect:/admin/weixinGroup/list";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		//TODO: 删除前先将这组的用户移动到未分组 然后在删除
		wGroupService.deleteGroup(id);
		return "redirect:/admin/weixinGroup/list";
	}
	
	
	
	
	
}
