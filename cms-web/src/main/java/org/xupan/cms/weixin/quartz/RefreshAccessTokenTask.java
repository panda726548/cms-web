package org.xupan.cms.weixin.quartz;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.xupan.basic.util.JsonUtil;
import org.xupan.cms.servlet.WeixinContext;
import org.xupan.cms.weixin.json.AccessToken;
import org.xupan.cms.weixin.kit.WeixinBasicKit;
import org.xupan.cms.weixin.model.WeixinFinalValue;

/**
 * 刷新token
 * @author Administrator
 *
 */
@Component
public class RefreshAccessTokenTask {
	
	public void refreshToken(){
		String url = WeixinFinalValue.ACCESS_TOKEN_URL;
		System.out.println("url:------>>>>"+url);
		url = url.replaceAll("APPID", WeixinContext.getInstance().getAppId());
		url = url.replaceAll("APPSECRET", WeixinContext.getInstance().getAppSecret());
		String content = WeixinBasicKit.sendGet(url);
		System.out.println("content:------>>>>"+content);
		if(WeixinBasicKit.checkRequestSucc(content)) {
			AccessToken at = (AccessToken)JsonUtil.getInstance().json2obj(content, AccessToken.class);
			WeixinContext.getInstance().setAccessToken(at);
			System.out.println("token-------->>>>>:"+at.getAccess_token());
		} else {
			refreshToken();
		}
	}
	

}
