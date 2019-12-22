package org.xupan.cms.dao;


import java.util.List;

import org.xupan.basic.dao.BaseDao;
import org.xupan.basic.model.Pager;
import org.xupan.cms.model.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {

	@Override
	public List<Role> listRole() {
		return this.list("from Role");
	}

	@Override
	public void deleteRoleUsers(int rid) {
		this.updateByHql("delete UserRole ur where ur.role.id=?",rid);
	}

	


}
