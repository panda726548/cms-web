package org.xupan.cms.weixin.service;
import java.util.List;

import org.xupan.cms.model.WeiXinUser;

/**
 * 用户service
 * @author Administrator
 *
 */
public interface IWeiXinUserService {
	public void add(WeiXinUser user);
	public void update(WeiXinUser user);
	public void delete(int id);
	public WeiXinUser load(int id);
	public WeiXinUser loadByUsername(String username);
	public WeiXinUser loadByOpenid(String openid);
	public WeiXinUser login(String username,String password);
	public List<WeiXinUser> list();
	//修改用户状态
	public void updateStatus(int id);
	
	public WeiXinUser getWeiXinUserById(int uid);
}
