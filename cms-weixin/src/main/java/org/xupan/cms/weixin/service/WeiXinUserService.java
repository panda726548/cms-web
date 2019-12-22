package org.xupan.cms.weixin.service;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.xupan.cms.model.CmsException;
import org.xupan.cms.model.User;
import org.xupan.cms.model.WeiXinUser;
import org.xupan.cms.weixin.dao.IWeixinUserDao;

@Service("weixinUserService")
public class WeiXinUserService implements IWeiXinUserService {
	@Inject
	private IWeixinUserDao weixinUserDao;
	
	@Override
	public void add(WeiXinUser user) {
		WeiXinUser u = this.loadByUsername(user.getUsername());
		if(u!=null) throw new RuntimeException("用户名已经存在");
		user.setStatus(1);
		weixinUserDao.add(user);
	}

	@Override
	public void update(WeiXinUser user) {
		weixinUserDao.update(user);
	}

	@Override
	public void delete(int id) {
		weixinUserDao.delete(id);
	}

	@Override
	public WeiXinUser load(int id) {
		return weixinUserDao.load(id);
	}

	@Override
	public WeiXinUser loadByUsername(String username) {
		return weixinUserDao.loadByUsername(username);
	}

	@Override
	public WeiXinUser loadByOpenid(String openid) {
		return weixinUserDao.loadByOpenId(openid);
	}

	@Override
	public List<WeiXinUser> list() {
		return weixinUserDao.list();
	}

	@Override
	public WeiXinUser login(String username, String password) {
		WeiXinUser u = this.loadByUsername(username);
		if(u==null) throw new RuntimeException("用户名不存在!");
		if(!password.equals(u.getPassword())) throw new RuntimeException("用户密码不正确！");
		if(u.getStatus()==0) throw new RuntimeException("用户已经停用!");
		return u;
	}

	@Override
	public void updateStatus(int id) {
		WeiXinUser u = weixinUserDao.load(id);
		if(u==null) throw new CmsException("修改状态的用户不存在");
		if(u.getStatus()==0) u.setStatus(1);
		else u.setStatus(0);
		weixinUserDao.update(u);
	}

	@Override
	public WeiXinUser getWeiXinUserById(int uid) {
		return weixinUserDao.load(uid);
	}

}
