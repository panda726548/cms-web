package org.xupan.cms.weixin.service;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.xupan.cms.weixin.dao.IWeixinMenuDao;
import org.xupan.cms.weixin.dto.WeixinMenuDto;
import org.xupan.cms.weixin.model.WeixinMenu;
import org.xupan.cms.weixin.model.WeixinMenuTree;

@Service("weixinMenuService")
public class WeixinMenuService implements IWeixinMenuService {
	@Inject
	private IWeixinMenuDao weixinMenuDao;

	public void add(WeixinMenu wm) {
		if(wm.getType().equals("click")){
			wm.setMenuKey("KEY_"+System.currentTimeMillis());
		}else{
			wm.setMenuKey(null);
		}
		weixinMenuDao.add(wm);
	}

	public void delete(int id) {
		//TODO: 删除如果有子菜单要先删除子菜单
		weixinMenuDao.delete(id);
	}

	public void update(WeixinMenu wm) {
		if(wm.getType().equals("click")){
			wm.setMenuKey("KEY_"+System.currentTimeMillis());
		}else{
			wm.setMenuKey(null);
		}
		weixinMenuDao.update(wm);
	}

	public WeixinMenu load(int id) {
		return weixinMenuDao.load(id);
	}

	public List<WeixinMenu> listAll() {
		return weixinMenuDao.listAll();
	}

	public WeixinMenu loadByKey(String key) {
		return weixinMenuDao.loadByKey(key);
	}

	public List<WeixinMenuDto> generateWeixinMenuDto() {
		List<WeixinMenu> menus = this.listAll();
		List<WeixinMenuDto> menuDtos = new ArrayList<WeixinMenuDto>();
		WeixinMenuDto wmd = null;
		for(WeixinMenu wm:menus) {
			wmd = new WeixinMenuDto();
			wmd.setKey(wm.getMenuKey());
			wmd.setName(wm.getName());
			wmd.setType(wm.getType());
			wmd.setId(wm.getId());
			wmd.setUrl(wm.getUrl());
			//判断是否有父菜单
			if(wm.getPid()==null||wm.getPid()==0) {
				if(wmd.getSub_button()==null) {
					wmd.setSub_button(new ArrayList<WeixinMenuDto>());
				}
				menuDtos.add(wmd);
			} else {
				WeixinMenuDto twmd = findById(wm.getPid(), menuDtos);
				if(twmd==null) throw new RuntimeException("菜单的父类对象有问题，请检查");
				twmd.getSub_button().add(wmd);
			}
		}
		return menuDtos;
	}
	
	private WeixinMenuDto findById(int id,List<WeixinMenuDto> wmds) {
		for(WeixinMenuDto wmd:wmds) {
			if(wmd.getId()==id) {
				return wmd;
			}
		}
		return null;
	}

	@Override
	public List<WeixinMenu> listByParent(Integer pid) {
		return weixinMenuDao.listByParent(pid);
	}

	@Override
	public List<WeixinMenuTree> generateTree() {
		return weixinMenuDao.generateTree();
	}

	@Override
	public List<WeixinMenuTree> generateTreeByParent(Integer pid) {
		return weixinMenuDao.generateTreeByParent(pid);
	}

}
