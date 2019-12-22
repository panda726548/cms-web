package org.xupan.cms.service;

import org.xupan.cms.model.WeiXinUser;


public interface IIndexService {
	public void generateTop();
	public void generateTop1(WeiXinUser u);
	public void generateBottom();
	public void generateBody();
}
