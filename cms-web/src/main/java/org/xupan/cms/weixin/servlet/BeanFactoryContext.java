package org.xupan.cms.weixin.servlet;

import org.springframework.web.context.WebApplicationContext;

public class BeanFactoryContext {
private static WebApplicationContext wc;
	
	public static WebApplicationContext getWc() {
		return wc;
	}

	public static void setWc(WebApplicationContext wc) {
		BeanFactoryContext.wc = wc;
	}
	
	public static Object getService(String serviceName) {
		return wc.getBean(serviceName);
	}
}
