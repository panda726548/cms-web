package org.xupan.cms.weixin.service;
/**
 * 微信菜单service 操作微信服务器的 调用微信提供的接口
 * @author Administrator
 *
 */
public interface IWMenuService {
	/**
	 * 发布菜单
	 */
	public void publishMenu();
	/**
	 * 获取菜单
	 * @return
	 */
	public String queryMenu();

}
