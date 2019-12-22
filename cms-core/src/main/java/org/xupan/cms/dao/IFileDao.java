package org.xupan.cms.dao;

import java.util.List;

import org.xupan.basic.dao.IBaseDao;
import org.xupan.cms.model.FileTree;
import org.xupan.cms.model.Files;

public interface IFileDao extends IBaseDao<Files>{
	/**
	 * 根据父id获取所有的子栏目
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
	/**
	 * 获取导航栏目中的第一个栏目
	 * @param cid
	 * @return
	 */
	public Files loadFirstChannelByNav(int cid);

}
