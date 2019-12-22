package org.xupan.cms.servlet;

import org.xupan.cms.weixin.json.AccessToken;




public class WeixinContext {
	private String appId;
	private String appSecret;
	private String baseUrl;
	private String token;
	private AccessToken accessToken;
	private static WeixinContext wc;
	
	private WeixinContext(){}
	
	public static WeixinContext getInstance() {
		if(wc==null) wc = new WeixinContext();
		return wc;
	}
	
	
	public AccessToken getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
