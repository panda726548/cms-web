package org.xupan.cms.weixin.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xupan.basic.model.User;
/**
 * 过滤器
 * @author Administrator
 *
 */
public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpServletResponse httpResp = (HttpServletResponse)resp;
		String url = httpReq.getRequestURI();
		if(url.indexOf("resources")>0||url.indexOf("login")>0||url.indexOf("/wreceive")>0) {
			chain.doFilter(httpReq, httpResp);
			return;
		} else {
			User u = (User)httpReq.getSession().getAttribute("user");
			if(u==null) {
				httpResp.sendRedirect(httpReq.getContextPath()+"/user/login");
				return;
			}
			chain.doFilter(httpReq, httpResp);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		
	}

}
