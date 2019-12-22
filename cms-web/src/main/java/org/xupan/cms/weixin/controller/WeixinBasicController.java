package org.xupan.cms.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xupan.cms.servlet.WeixinContext;
import org.xupan.cms.weixin.kit.BasicKit;
import org.xupan.cms.weixin.kit.SecurityKit;
import org.xupan.cms.weixin.kit.WeixinMessageKit;

@Controller

public class WeixinBasicController {
	@RequestMapping(value="wreceive",method=RequestMethod.GET)
	public void handlerGet(HttpServletRequest request,HttpServletResponse response) throws IOException{

		// 微信加密签名   
        String signature = request.getParameter("signature");  
        // 时间戳   
        String timestamp = request.getParameter("timestamp");  
        // 随机数   
        String nonce = request.getParameter("nonce");  
        // 随机字符串   
        String echostr = request.getParameter("echostr");  
        System.out.println("echostr----->"+echostr);
        //将token、timestamp、nonce三个参数进行字典序排序
        String [] arr={WeixinContext.getInstance().getToken(),timestamp,nonce};
        
        Arrays.sort(arr);
        //拼接成字符串 
        StringBuffer sb = new StringBuffer();
		for(String a:arr) {
			sb.append(a);
		}
		//将三个参数字符串拼接成一个字符串进行sha1加密
		String sha1Msg = SecurityKit.sha1(sb.toString());
		
		System.out.println("sha1Msg:"+sha1Msg);
		System.out.println("signature:"+signature);

		 PrintWriter out = response.getWriter();  
	     // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败   
		if(signature.equals(sha1Msg)) {
			out.print(echostr);
			System.out.println("校验成功则原样返回echostr"+echostr);
		}
		 out.close();  
	     out = null;  
	}
	
	@RequestMapping(value="/wreceive",method=RequestMethod.POST)
	public void handlerPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String rel = WeixinMessageKit.handlerReceiveMsg(req);
		System.out.println("--------rel:"+rel);
		//判断是否为空
		if(!BasicKit.isEmpty(rel)) {
			resp.getWriter().write(rel);
		}
	}
	@RequestMapping(value="/at",method=RequestMethod.GET)
	public void getToken(HttpServletResponse resp) throws IOException{
		String token=WeixinContext.getInstance().getAccessToken().getAccess_token();
		resp.getWriter().print(token);
		System.out.println("token------->:"+token);
	}

}
