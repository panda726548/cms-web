package org.xupan.cms.dto;

public class TreeDto {
	private int id;
	private String name;
	private String url;
	private int isParent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsParent() {
		return isParent;
	}
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}
	
	public TreeDto() {
	}
	public TreeDto(int id, String name, int isParent) {
		super();
		this.id = id;
		this.name = name;
		this.isParent = isParent;
	}
	public TreeDto(int id, String name, String url, int isParent) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.isParent = isParent;
	}
	
}
