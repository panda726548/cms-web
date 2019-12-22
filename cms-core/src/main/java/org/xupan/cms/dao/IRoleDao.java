package org.xupan.cms.dao;

import java.util.List;

import org.xupan.basic.dao.IBaseDao;
import org.xupan.basic.model.Pager;
import org.xupan.cms.model.Role;

public interface IRoleDao extends IBaseDao<Role> {
	public List<Role> listRole();
	public void deleteRoleUsers(int rid);
}
