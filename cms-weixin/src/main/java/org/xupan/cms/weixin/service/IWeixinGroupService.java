package org.xupan.cms.weixin.service;

import java.util.List;

import org.xupan.cms.weixin.model.WeixinGroup;


/**
 * 操作分组的group
 * @author Administrator
 *
 */
public interface IWeixinGroupService {
	//创建分组
	public void addGroup(WeixinGroup group);
	//查询所有分组
	public List<WeixinGroup> queryAll();
	//查询用户所在分组
	public WeixinGroup queryUserGroup(String openid);
	//修改分组名
	public void updateGroupName(int gid,String name);
	//移动用户分组
	public void moveUserToGroup(String openid,int to_groupid);
	//批量移动用户分组
	public void moveUsersToGroup(List<String> list,int to_groupid);
	//删除分组
	public void deleteGroup(int gid);
}
