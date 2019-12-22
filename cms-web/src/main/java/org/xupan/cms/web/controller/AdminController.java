package org.xupan.cms.web.controller;

import javax.servlet.http.HttpSession;

import org.xupan.cms.auth.AuthClass;
import org.xupan.cms.auth.AuthMethod;
import org.xupan.cms.web.CmsSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AuthClass("login")
public class AdminController {

	@RequestMapping("/admin")
	@AuthMethod
	public String index() {
		return "admin/index";
	}
	
	@AuthMethod
	@RequestMapping("/admin/logout")
	public String logout(HttpSession session) {
		CmsSessionContext.removeSession(session);
		session.invalidate();
		return "redirect:/login";
	}
}
