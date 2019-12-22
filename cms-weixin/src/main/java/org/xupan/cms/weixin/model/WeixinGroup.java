package org.xupan.cms.weixin.model;
/**
 * 微信分组model
 * @author Administrator
 *
 */
public class WeixinGroup {
	
	private int id;
	private String name;
	private int count;//人数
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
