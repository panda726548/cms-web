package org.xupan.cms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_files")
public class Files {
	public static final String ROOT_NAME = "网站系统文件";
	public static final int ROOT_ID = 0;
	private int id;
	private String name;
	private String fileType;
	private String fileUrl;
	private Date fileCreate;
	private Files file;
	private String remark;
	private String postfix;
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
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Date getFileCreate() {
		return fileCreate;
	}
	public void setFileCreate(Date fileCreate) {
		this.fileCreate = fileCreate;
	}
	@ManyToOne
	@JoinColumn(name="pid")
	public Files getFile() {
		return file;
	}
	public void setFile(Files file) {
		this.file = file;
	}
	public Files(int id, String fileName, String fileType, String fileUrl,
			Files file) {
		super();
		this.id = id;
		this.name = fileName;
		this.fileType = fileType;
		this.fileUrl = fileUrl;
		this.file = file;
	}
	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Files(int id, String fileName, String fileType, String fileUrl) {
		super();
		this.id = id;
		this.name = fileName;
		this.fileType = fileType;
		this.fileUrl = fileUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPostfix() {
		return postfix;
	}
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	
	

}
