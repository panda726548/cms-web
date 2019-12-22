package org.xupan.cms.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.xupan.basic.model.SystemContext;
import org.xupan.cms.model.WeiXinUser;
import org.xupan.cms.service.IIndexService;
import org.xupan.cms.weixin.service.IWeiXinUserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestIndexService {
	@Inject
	private IIndexService indexService;
	@Inject
	private IWeiXinUserService weixinUserService;
	private String rp = "F:\\mokuai\\cms-web\\src\\main\\webapp";
	@Test
	public void testGenerateTop() {
		SystemContext.setRealPath(rp);
		indexService.generateTop();
	}
	@Test
	public void testGenerateTop1() {
		SystemContext.setRealPath(rp);
		WeiXinUser u = weixinUserService.login("admin", "123456");
		
		indexService.generateTop1(null);
	}
	
	@Test
	public void testGenerateBody() {
		SystemContext.setRealPath(rp);
		indexService.generateBody();
	}
	@Test
	public void testgenerateBottom() {
		SystemContext.setRealPath(rp);
		indexService.generateBottom();
	}
}
