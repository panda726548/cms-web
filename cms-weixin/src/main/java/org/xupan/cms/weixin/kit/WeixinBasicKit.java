package org.xupan.cms.weixin.kit;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.xupan.basic.util.JsonUtil;
import org.xupan.basic.util.PropertiesUtil;
import org.xupan.cms.servlet.WeixinContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class WeixinBasicKit {
	public static void setWeixinContext() {
		Properties prop = PropertiesUtil.getInstance().load("weixin_basic");
		WeixinContext.getInstance().setAppId(prop.getProperty("appId"));
		WeixinContext.getInstance().setAppSecret(prop.getProperty("appsecret"));
		WeixinContext.getInstance().setBaseUrl(prop.getProperty("base_url"));
		WeixinContext.getInstance().setToken(prop.getProperty("weixin_token"));
		System.out.println(WeixinContext.getInstance().getToken());
		System.out.println("AppId:----->>>>"+WeixinContext.getInstance().getAppId());
		System.out.println("AppSecret----->>>"+WeixinContext.getInstance().getAppSecret());
	}
	
	public static String replaceAccessTokenUrl(String url) {
		return url.replace("ACCESS_TOKEN", WeixinContext.getInstance().getAccessToken().getAccess_token());
	}
	
	/**
	 * 检查请求是否成功
	 * @return
	 */
	public static boolean checkRequestSucc(String content) {
		try {
			JsonNode jn = JsonUtil.getMapper().readTree(content);
			if(!jn.has("errcode")) return true;
			if(jn.get("errcode").asInt()==0) return true;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 返回错误code
	 * @param content
	 * @return
	 */
	public static int getRequestCode(String content) {
		try {
			JsonNode jn = JsonUtil.getMapper().readTree(content);
			if(jn.has("errcode")) return jn.get("errcode").asInt();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 得到错误消息
	 * @param content
	 * @return
	 */
	public static String getRequestMsg(String content) {
		try {
			JsonNode jn = JsonUtil.getMapper().readTree(content);
			if(jn.has("errcode")) return jn.get("errmsg").asText();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 发送get请求
	 * @param url
	 * @return
	 */
	public static String sendGet(String url) {
		HttpGet get = null;
		CloseableHttpResponse resp = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
			get = new HttpGet(url);
			resp = client.execute(get);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				HttpEntity entity = resp.getEntity();
				//解决中文乱码问题
				String content = EntityUtils.toString(entity,"UTF-8");
				return content;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resp!=null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(client!=null) client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String sendJsonPost(String url,String content) {
		return sendPost(url, content, "application/json");
	}
	
	public static String sendXmlPost(String url,String content) {
		return sendPost(url, content, "application/xml");
	}
	/**
	 * 发送请求
	 * @param url
	 * @param content
	 * @param type
	 * @return
	 */
	public static String sendPost(String url,String content,String type) {
		CloseableHttpClient client = null;
		CloseableHttpResponse resp = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-type",type);
			StringEntity entity = new StringEntity(content, ContentType.create(type, "UTF-8"));
			post.setEntity(entity);
			resp = client.execute(post);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				String str = EntityUtils.toString(resp.getEntity());
				return str;
			}
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(client!=null) client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if(resp!=null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
