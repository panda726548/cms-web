package org.xupan.cms.weixin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.xupan.basic.util.JsonUtil;
import org.xupan.cms.weixin.dto.WeixinMenuDto;
import org.xupan.cms.weixin.kit.WeixinBasicKit;
import org.xupan.cms.weixin.model.WeixinFinalValue;

@Service("wMenuService")
public class WMenuService implements IWMenuService {
	@Inject
	private IWeixinMenuService weixinMenuService;

	@Override
	public void publishMenu() {
		String url=WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MENU_ADD);
		System.out.println("添加菜单的URL:"+url);
		List<WeixinMenuDto> wmds = weixinMenuService.generateWeixinMenuDto();
		Map<String,List<WeixinMenuDto>> maps = new HashMap<String,List<WeixinMenuDto>>();
		maps.put("button", wmds);
		String json =  JsonUtil.getInstance().obj2json(maps);
		System.out.println("菜单JSON数据："+json);
		
		String rel = WeixinBasicKit.sendJsonPost(url,json);
		System.out.println("发布菜单返回结果:"+rel);
		if(!WeixinBasicKit.checkRequestSucc(rel)) {
			throw new RuntimeException("发布菜单失败："+WeixinBasicKit.getRequestMsg(rel));
		}

	}

	@Override
	public String queryMenu() {
		String url=WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MENU_QUERY);
		return WeixinBasicKit.sendGet(url);
	}

}
