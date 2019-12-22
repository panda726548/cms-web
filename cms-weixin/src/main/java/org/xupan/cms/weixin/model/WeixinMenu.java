package org.xupan.cms.weixin.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 微信菜单
 * @author Administrator
 *
 */
@Entity
@Table(name="t_weixin_menu")
public class WeixinMenu {
	public static final String ROOT_NAME = "微信菜单";
	public static final int ROOT_ID = 0;
	private int id;
	private String name;
	private String content;
	private String url;
	private String menuKey;
	private Integer pid;//菜单父节点
	private String type;//点击菜单类型
	/**
	 * 响应类型如果为1表示去content来响应
	 */
	private int respType;
	
	@Id
	@GeneratedValue
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="menu_key")
	public String getMenuKey() {
		return menuKey;
	}
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
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
	@Column(name="resp_type")
	public int getRespType() {
		return respType;
	}
	public void setRespType(int respType) {
		this.respType = respType;
	}
	@Override
	public String toString() {
		return "WeixinMenu [id=" + id + ", name=" + name + ", content="
				+ content + ", url=" + url + ", menuKey=" + menuKey + ", pid="
				+ pid + ", type=" + type + ", respType=" + respType + "]";
	}
	
	
}
