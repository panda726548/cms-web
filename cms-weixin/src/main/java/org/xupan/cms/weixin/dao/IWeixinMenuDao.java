package org.xupan.cms.weixin.dao;

import java.util.List;

import org.xupan.basic.dao.IBaseDao;
import org.xupan.cms.weixin.model.WeixinMenu;
import org.xupan.cms.weixin.model.WeixinMenuTree;


public interface IWeixinMenuDao extends IBaseDao<WeixinMenu>{
	//根据key获得菜单
	public WeixinMenu loadByKey(String key);
	//获取所有的菜单信息
	public List<WeixinMenu> listAll();
	
	/**
	 * 根据父id获取所有的子栏目
	 * @param pid
	 * @return
	 */
	public List<WeixinMenu> listByParent(Integer pid);
	/**
	 * 把所有的栏目获取并生成一颗完整的树
	 * @return
	 */
	public List<WeixinMenuTree> generateTree();
	/**
	 * 根据父类对象获取子类栏目，并且生成树列表
	 * @param pid
	 * @return
	 */
	public List<WeixinMenuTree> generateTreeByParent(Integer pid);
}
