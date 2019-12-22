package org.xupan.cms.weixin.model;
/**
 * 微信菜单树
 * @author Administrator
 *
 */
public class WeixinMenuTree {
	private Integer id;
	private String name;
	private String url;
	private Integer pid;
	private String type;//点击菜单类型
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public WeixinMenuTree(Integer id, String name, String url, Integer pid,
			String type) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.pid = pid;
		this.type = type;
	}
	public WeixinMenuTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
