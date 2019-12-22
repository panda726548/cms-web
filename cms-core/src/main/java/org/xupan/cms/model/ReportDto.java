package org.xupan.cms.model;
/**
 * 报表Dto相关类
 * @author Administrator
 * 报表需要用到的属性 都可以写在这里
 */
public class ReportDto {
	/**
	 * 栏目名称
	 */
	private String channelName;
	/**
	 * 每个栏目总文章数
	 */
	private Long channelNameCount;
	
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public ReportDto(String channelName, Long channelNameCount) {
		super();
		this.channelName = channelName;
		this.channelNameCount = channelNameCount;
	}
	public Long getChannelNameCount() {
		return channelNameCount;
	}
	public void setChannelNameCount(Long channelNameCount) {
		this.channelNameCount = channelNameCount;
	}
	public ReportDto() {
		super();
	}
	

}
