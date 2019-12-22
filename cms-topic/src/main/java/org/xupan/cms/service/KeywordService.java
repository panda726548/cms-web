package org.xupan.cms.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.xupan.basic.model.Pager;
import org.xupan.cms.dao.IKeywordDao;
import org.xupan.cms.model.Keyword;
import org.springframework.stereotype.Service;

@Service("keywordService")
public class KeywordService implements IKeywordService {
	private IKeywordDao keywordDao;
	
	
	
	public IKeywordDao getKeywordDao() {
		return keywordDao;
	}

	@Inject
	public void setKeywordDao(IKeywordDao keywordDao) {
		this.keywordDao = keywordDao;
	}

	@Override
	public void addOrUpdate(String name) {
		keywordDao.addOrUpdate(name);
	}

	@Override
	public List<Keyword> getKeywordByTimes(int num) {
		List<Keyword> ks = keywordDao.findUseKeyword();
		List<Keyword> kks = new ArrayList<Keyword>();
		for(Keyword k:ks) {
			if(k.getTimes()>=num) kks.add(k);
			else break;
		}
		return kks;
	}

	@Override
	public List<Keyword> getMaxTimesKeyword(int num) {
		List<Keyword> ks = keywordDao.findUseKeyword();
		List<Keyword> kks = new ArrayList<Keyword>();
		if(ks.size()<=num) return ks;
		for(int i=0;i<=num;i++) {
			kks.add(ks.get(i));
		}
		return kks;
	}

	@Override
	public Pager<Keyword> findNoUseKeyword() {
		return keywordDao.findNoUseKeyword();
	}

	@Override
	public void clearNoUseKeyword() {
		keywordDao.clearNoUseKeyword();
	}

	@Override
	public List<Keyword> findUseKeyword() {
		return keywordDao.findUseKeyword();
	}

	@Override
	public List<Keyword> listKeywordByCon(String con) {
		return keywordDao.listKeywordByCon(con);
	}

	@Override
	public List<String> listKeywordStringByCon(String con) {
		return keywordDao.listKeywordStringByCon(con);
	}

}
