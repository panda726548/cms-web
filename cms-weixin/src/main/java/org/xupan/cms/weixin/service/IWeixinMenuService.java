package org.xupan.cms.weixin.service;


import java.util.List;

import org.xupan.cms.weixin.dto.WeixinMenuDto;
import org.xupan.cms.weixin.model.WeixinMenu;
import org.xupan.cms.weixin.model.WeixinMenuTree;



public interface IWeixinMenuService {
	//添加菜单
	public void add(WeixinMenu wm);
	//根据id删除菜单
	public void delete(int id);
	//修改菜单
	public void update(WeixinMenu wm);
	//根据id加载菜单
	public WeixinMenu load(int id);
	//获得所有的菜单
	public List<WeixinMenu> listAll();
	//根据key加载菜单
	public WeixinMenu loadByKey(String key);
	//生成发布菜单
	public List<WeixinMenuDto> generateWeixinMenuDto();
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
