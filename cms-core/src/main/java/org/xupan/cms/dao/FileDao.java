package org.xupan.cms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.xupan.basic.dao.BaseDao;
import org.xupan.cms.model.FileTree;
import org.xupan.cms.model.Files;

@Repository("fileDao")
public class FileDao extends BaseDao<Files> implements IFileDao{

	public static void initTreeNode(List<FileTree> fts) {
		fts.add(0,new FileTree(Files.ROOT_ID,Files.ROOT_NAME,-1));
		for(FileTree ft:fts) {
			if(ft.getPid()==null)ft.setPid(0);
		}
	}
	
	@Override
	public List<Files> listByParent(Integer pid) {
		String hql = "select f from Files f left join fetch f.file fp where fp.id="+pid;
		if(pid==null||pid==0) hql = "select f from Files f where f.file is null";
		return this.list(hql);
	}

	@Override
	public List<FileTree> generateTree() {
		String sql = "select id,name,pid from t_files";
		List<FileTree> fts = this.listBySql(sql, FileTree.class, false);
		initTreeNode(fts);
		return fts;
	}

	@Override
	public List<FileTree> generateTreeByParent(Integer pid) {
		if(pid==null||pid==0) {
			return this.listBySql("select id,name,pid from t_files where pid is null ", FileTree.class, false);
		} else {
			return this.listBySql("select id,name,pid from t_files where pid="+pid, 
					FileTree.class,false);
		}
	}

	@Override
	public Files loadFirstChannelByNav(int pid) {
		String hql = "select new Files(f.id,f.name,f.fileType,f.fileUrl) from Files f where f.file.id=? ";
		return (Files)this.getSession().createQuery(hql)
			.setFirstResult(0).setMaxResults(1).setParameter(0, pid).uniqueResult();
	}

}
