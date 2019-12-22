package org.xupan.weixin;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.xupan.basic.util.JsonUtil;
import org.xupan.cms.weixin.json.AccessToken;
import org.xupan.cms.weixin.model.WeixinFinalValue;

public class Test1 {
	@Test
	public void httpClienTest(){
		try {
			CloseableHttpClient client=HttpClients.createDefault();
			String url=WeixinFinalValue.ACCESS_TOKEN_URL;
			url=url.replace("APPID", "wx146f17097a4aad95").replace("APPSECRET", "71c580481f379cad4206a108fc5c4e67");
			HttpGet get=new HttpGet(url);
			CloseableHttpResponse  response=client.execute(get);
			int statusCode=response.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300){//获得到请求
			HttpEntity entity=response.getEntity();
			String content=EntityUtils.toString(entity);
			AccessToken at = (AccessToken)JsonUtil.getInstance().json2obj(content, AccessToken.class);
			System.out.println(at.getAccess_token()+"    "+at.getExpires_in());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
