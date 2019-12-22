package org.xupan.cms.model;

/**
 * 系统栏目树对象
 * @author Administrator
 *
 */
public class FileTree {
	
	private Integer id;
	private String name;
	private String fileUrl;
	private Integer pid;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public FileTree() {
	}

	public FileTree(Integer id, String name, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}

	
	public FileTree(Integer id, String fileName, String fileUrl, Integer pid) {
		super();
		this.id = id;
		this.name = fileName;
		this.fileUrl = fileUrl;
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "FileTree [id=" + id + ", fileName=" + name + ", fileUrl="
				+ fileUrl + ", pid=" + pid + "]";
	}

	
	
}
