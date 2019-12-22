package org.xupan.cms.weixin.json;
/**
 * 通过请求获得返回来的json数据中的票据和有效时间
 * @author Administrator
 *
 */
public class AccessToken {
	//获得票据
	private String access_token;
	//有效时间
	private String expires_in;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	

}
