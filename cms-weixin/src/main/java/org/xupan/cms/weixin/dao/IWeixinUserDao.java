package org.xupan.cms.weixin.dao;

import java.util.List;

import org.xupan.basic.dao.IBaseDao;
import org.xupan.cms.model.WeiXinUser;

/**
 * 用户操作Dao
 * 
 * @author Administrator
 *         在关注者与公众号产生消息交互后，公众号可获得关注者的OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的
 *         。对于不同公众号
 *         ，同一用户的openid不同）。公众号可通过本接口来根据OpenID获取用户基本信息，包括昵称、头像、性别、所在城市、语言和关注时间。
 */
public interface IWeixinUserDao extends IBaseDao<WeiXinUser> {
	// 根据用户名获得用户
	public WeiXinUser loadByUsername(String username);

	//根据OpenID获得用户
	public WeiXinUser loadByOpenId(String openid);

	//获得所有的用户的列表
	public List<WeiXinUser> list();

	
}
