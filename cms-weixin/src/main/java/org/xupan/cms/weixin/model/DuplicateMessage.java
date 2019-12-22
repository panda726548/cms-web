package org.xupan.cms.weixin.model;
/**
 * 排重的消息对象
 * @author Administrator
 *
 */
public class DuplicateMessage {
	private String fromUserName;//发送的用户
	private String createTime;//创建消息时间
	private Long curTime;//创建对象的时间 用来清空数据记录
	private String rel;//返回的字符串
	
	public Long getCurTime() {
		return curTime;
	}
	public void setCurTime(Long curTime) {
		this.curTime = curTime;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public DuplicateMessage() {
	}
	
	public DuplicateMessage(String fromUserName, String createTime) {
		super();
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.curTime = System.currentTimeMillis();
		this.rel = null;
	}
	/**
	 * 重写equals方法判断两个对象是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		DuplicateMessage dm = (DuplicateMessage)obj;
		if(dm.getCreateTime().equals(this.getCreateTime())&&(dm.getFromUserName()).equals(this.getFromUserName())) {
			return true;
		}
		return false;
	}
}
