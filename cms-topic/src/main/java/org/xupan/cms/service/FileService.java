package org.xupan.cms.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.xupan.cms.dao.IFileDao;
import org.xupan.cms.model.FileTree;
import org.xupan.cms.model.Files;
@Service("fileService")
public class FileService implements IFileService {
	private IFileDao fileDao;
	

	public IFileDao getFileDao() {
		return fileDao;
	}

	@Inject
	public void setFileDao(IFileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	public List<Files> listByParent(Integer pid) {
		return fileDao.listByParent(pid);
	}

	@Override
	public List<FileTree> generateTree() {
		return fileDao.generateTree();
	}

	@Override
	public List<FileTree> generateTreeByParent(Integer pid) {
		return fileDao.generateTreeByParent(pid);
	}

	@Override
	public Files loadFirstChannelByNav(int pid) {
		return fileDao.loadFirstChannelByNav(pid);
	}

	@Override
	public Files load(int id) {
		return fileDao.load(id);
	}

}
