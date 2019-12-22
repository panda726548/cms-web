package org.xupan.cms.web;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.xupan.cms.auth.AuthUtil;
import org.xupan.cms.weixin.kit.WeixinBasicKit;
import org.xupan.cms.weixin.servlet.BeanFactoryContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static WebApplicationContext wc;
	private static String realpath;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//初始化spring的工厂
		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//初始化权限信息
		Map<String,Set<String>> auths = AuthUtil.initAuth("org.xupan.cms.web.controller");
		this.getServletContext().setAttribute("allAuths", auths);
		this.getServletContext().setAttribute("baseInfo", BaseInfoUtil.getInstacne().read());
		System.out.println("------------------------系统初始化成功:"+auths+"-----------------------------");
		System.out.println("------------------------初始化微信相关信息----------------------");
		realpath = config.getServletContext().getRealPath("");
		BeanFactoryContext.setWc(wc);
		//获取微信基本配置文件内容
		WeixinBasicKit.setWeixinContext();
	}
	
	public static WebApplicationContext getWc() {
		return wc;
	}
	public static String getRealpath() {
		return realpath;
	}
	
}
