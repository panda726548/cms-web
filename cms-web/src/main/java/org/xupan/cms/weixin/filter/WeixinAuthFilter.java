package org.xupan.cms.weixin.filter;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xupan.basic.model.User;
import org.xupan.cms.weixin.model.WeixinFinalValue;
/**
 * 网页授权获取用户基本信息 过滤器
 * @author Administrator
 *
 */
public class WeixinAuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	/*	
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		//获取session中user对象
		User tu = (User)hRequest.getSession().getAttribute("user");
		//System.out.println("------Session中的对象："+tu);
		if(tu==null) {//说明用户没有登录
			//返回客户端浏览器的版本号、类型
			String agent = hRequest.getHeader("User-Agent");
			//System.out.println("---------agent:"+agent);
			if(agent!=null&&agent.toLowerCase().indexOf("micromessenger")>=0) {//说明在微信客户端打开的
				//获得code
				String code = request.getParameter("code");
				String state = request.getParameter("state");
				System.out.println("------------>code:"+code+",---------->state:"+state);
				if(code!=null&&state!=null&&state.equals("1")) {
					//获取wUserService对象
					IWUserService wUserService = (IWUserService)BeanFactoryContext.getService("wUserService");
					//根据code获得openid
					String openid = wUserService.queryOpenidByCode(code);
					if(openid!=null) {
						//用户openi不为空  根据openid到数据库中获得用户
						IUserService userService = (IUserService)BeanFactoryContext.getService("userService");
						User u = userService.loadByOpenid(openid);
						if(u==null) {//如果用户对象不存在 就根据微信openid到微信服务器获得user对象存入数据库
							u = wUserService.queryByOpenId(openid).getUser();
							userService.add(u);
						} else {//用户已经存在 将状态改为1
							if(u.getStatus()==0) {
								u.setStatus(1);
								userService.update(u);
							}
						}
						hRequest.getSession().setAttribute("user", u);
					}
				} else {
					//获得请求的路径
					String path = hRequest.getRequestURL().toString();
					//获得请求的参数
					String query = hRequest.getQueryString();
					if(query!=null) {//参数不为空就拼接url
						path = path+"?"+query;
					}
					System.out.println("------->path:"+path);
					String uri = WeixinFinalValue.OAuth_URL;
					uri = uri.replace("APPID", WeixinContext.getInstance().getAppId())
					   .replace("REDIRECT_URI",URLEncoder.encode(path, "UTF-8"))
					   .replace("SCOPE", "snsapi_base")//snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
					   .replace("STATE", "1");
					hResponse.sendRedirect(uri);
					System.out.println(uri);
					return;
				}
			}
		}
		chain.doFilter(hRequest, hResponse);*/
	}

	@Override
	public void destroy() {

	}

}
