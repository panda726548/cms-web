package org.xupan.cms.service;

import java.util.List;

import org.xupan.cms.model.FileTree;
import org.xupan.cms.model.Files;


public interface IFileService {
	public Files load(int id);
	/**
	 * 根据父亲id加载栏目，该方面首先检查SystemContext中是否存在排序如果没有存在把orders加进去
	 * @param pid
	 * @return
	 */
	public List<Files> listByParent(Integer pid);
	
	/**
	 * 把所有的栏目获取并生成一颗完整的树
	 * @return
	 */
	public List<FileTree> generateTree();
	/**
	 * 根据父类对象获取子类栏目，并且生成树列表
	 * @param pid
	 * @return
	 */
	public List<FileTree> generateTreeByParent(Integer pid);
	public Files loadFirstChannelByNav(int pid);
}
