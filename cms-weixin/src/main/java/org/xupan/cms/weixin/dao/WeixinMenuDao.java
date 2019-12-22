package org.xupan.cms.weixin.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.xupan.basic.dao.BaseDao;
import org.xupan.cms.model.FileTree;
import org.xupan.cms.weixin.model.WeixinMenu;
import org.xupan.cms.weixin.model.WeixinMenuTree;

@Repository("weixinMenuDao")
public class WeixinMenuDao extends BaseDao<WeixinMenu> implements
		IWeixinMenuDao {
	public static void initTreeNode(List<WeixinMenuTree> wmts) {
		wmts.add(0,new WeixinMenuTree(WeixinMenu.ROOT_ID,WeixinMenu.ROOT_NAME,null, -1, null));
		for(WeixinMenuTree wmt:wmts) {
			if(wmt.getPid()==null)wmt.setPid(0);
		}
	}

	public WeixinMenu loadByKey(String key) {
		return (WeixinMenu)super.queryObject("from WeixinMenu where menuKey=?", key);
	}

	public List<WeixinMenu> listAll() {
		return super.list("from WeixinMenu");
	}

	
	@Override
	public List<WeixinMenuTree> generateTree() {
		String sql = "select id,name,url,pid,type from t_weixin_menu";
		List<WeixinMenuTree> wmts = this.listBySql(sql, WeixinMenuTree.class, false);
		initTreeNode(wmts);
		return wmts;
	}

	@Override
	public List<WeixinMenuTree> generateTreeByParent(Integer pid) {
		if(pid==null||pid==0) {
			return this.listBySql("select id,name,url,pid,type from t_weixin_menu where pid = 0 ", WeixinMenuTree.class, false);
		} else {
			return this.listBySql("select id,name,url,pid,type from t_weixin_menu where pid="+pid, 
					WeixinMenuTree.class,false);
		}
	}

	@Override
	public List<WeixinMenu> listByParent(Integer pid) {
		String hql = "select wm from WeixinMenu wm  where wm.pid="+pid;
		if(pid==null||pid==0) hql = "select wm from WeixinMenu wm where wm.pid = 0";
		return this.list(hql);
	}

}
