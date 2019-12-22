package org.xupan.cms.dto;

public class FileDto {
	private int id;
	private String name;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDto(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public FileDto(int id, String name, String content) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
	}
	
	
}
