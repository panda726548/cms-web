package org.xupan.cms.weixin.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.xupan.basic.dao.BaseDao;
import org.xupan.cms.model.WeiXinUser;

@Repository("weixinUserDao")
public class WeiXinUserDao extends BaseDao<WeiXinUser> implements IWeixinUserDao {


	@Override
	public WeiXinUser loadByUsername(String username) {
		
		return (WeiXinUser)super.queryObject("from WeiXinUser where username=?", username);
	}

	@Override
	public WeiXinUser loadByOpenId(String openid) {
		return (WeiXinUser)super.queryObject("from WeiXinUser where openid=?", openid);
	}

	@Override
	public List<WeiXinUser> list() {
		return super.list("from WeiXinUser");
	}

	
}
