package org.xupan.cms.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.xupan.basic.model.Pager;
import org.xupan.cms.dao.IAttachmentDao;
import org.xupan.cms.dao.IChannelDao;
import org.xupan.cms.dao.ITopicDao;
import org.xupan.cms.dao.IUserDao;
import org.xupan.cms.model.Attachment;
import org.xupan.cms.model.Channel;
import org.xupan.cms.model.CmsException;
import org.xupan.cms.model.ReportDto;
import org.xupan.cms.model.Topic;
import org.xupan.cms.model.User;
import org.springframework.stereotype.Service;

@Service("topicService")
public class TopicService implements ITopicService {
	private ITopicDao topicDao;
	private IAttachmentDao attachmentDao;
	private IChannelDao channelDao;
	private IUserDao userDao;
	
	
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	@Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public ITopicDao getTopicDao() {
		return topicDao;
	}
	@Inject
	public void setTopicDao(ITopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public IAttachmentDao getAttachmentDao() {
		return attachmentDao;
	}
	@Inject
	public void setAttachmentDao(IAttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}
	
	private void addTopicAtts(Topic topic,Integer[] aids) {
		if(aids!=null) {
			for(Integer aid:aids) {
				Attachment a = attachmentDao.load(aid);
				if(a==null) continue;
				a.setTopic(topic);
			}
		}
	}

	@Override
	public void add(Topic topic, int cid, int uid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		User u = userDao.load(uid);
		if(c==null||u==null)throw new CmsException("要添加的文章必须有用户和栏目");
		topic.setAuthor(u.getNickname());
		topic.setCname(c.getName());
		topic.setCreateDate(new Date());
		topic.setChannel(c);
		topic.setUser(u);
		topicDao.add(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void add(Topic topic, int cid, int uid) {
		add(topic,cid,uid,null);
	}

	@Override
	public void delete(int id) {
		List<Attachment> atts = attachmentDao.listByTopic(id);
		attachmentDao.deleteByTopic(id);
		topicDao.delete(id);
		//删除硬盘上面的文件
		for(Attachment a:atts) {
			AttachmentService.deleteAttachFiles(a);
		}
	}

	@Override
	public void update(Topic topic, int cid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		if(c==null)throw new CmsException("要更新的文章必须有用户和栏目");
		topic.setCname(c.getName());
		topic.setChannel(c);
		topicDao.update(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void update(Topic topic, int cid) {
		update(topic,cid,null);
	}

	@Override
	public Topic load(int id) {
		Topic topic=topicDao.load(id);
		//访问一次 访问量+1
		Topic temp=topic;
		temp.setBrowseNumber(temp.getBrowseNumber()+1);
		topicDao.update(temp);
		return topic;
	}

	@Override
	public Pager<Topic> find(Integer cid, String title, Integer status) {
		return topicDao.find(cid, title, status);
	}

	@Override
	public Pager<Topic> find(Integer uid, Integer cid, String title,
			Integer status) {
		return topicDao.find(uid, cid, title, status);
	}

	@Override
	public Pager<Topic> searchTopicByKeyword(String keyword) {
		return topicDao.searchTopicByKeyword(keyword);
	}

	@Override
	public Pager<Topic> searchTopic(String con) {
		return topicDao.searchTopic(con);
	}

	@Override
	public Pager<Topic> findRecommendTopic(Integer ci) {
		return topicDao.findRecommendTopic(ci);
	}
	@Override
	public void updateStatus(int tid) {
		Topic t = topicDao.load(tid);
		if(t.getStatus()==0) t.setStatus(1);
		else t.setStatus(0);
		topicDao.update(t);
	}
	@Override
	public List<Topic> listTopicByChannelAndNumber(int cid, int num) {
		return topicDao.listTopicByChannelAndNumber(cid, num);
	}
	@Override
	public List<Topic> listTopicByChannel(int cid) {
		return topicDao.listTopicsByChannel(cid);
	}
	@Override
	public boolean isUpdateIndex(int cid) {
		return topicDao.isUpdateIndex(cid);
	}
	
	@Override
	public Topic loadLastedTopicByColumn(int cid) {
		return topicDao.loadLastedTopicByColumn(cid);
	}
	@Override
	public List<Topic> ListRecommendTopic(Integer ci, int num) {
		return topicDao.ListRecommendTopic(ci,num);
	}
	@Override
	public Object[]  getChannelReportdata() {
		List<ReportDto> list=topicDao.getChannelReportdata();
		String[] names=new String [list.size()];
		Long[] counts=new Long[list.size()];
		for (int i=0;i<list.size();i++) {
			names[i]=list.get(i).getChannelName();
			counts[i]=list.get(i).getChannelNameCount();
		}
		return new Object[]{names,counts};
	}
	@Override
	public Object[] getLastWeekData() {
		List<ReportDto> list=topicDao.getLastWeekData();
		String[] names=new String [list.size()];
		Long[] counts=new Long[list.size()];
		for (int i=0;i<list.size();i++) {
			names[i]=list.get(i).getChannelName();
			counts[i]=list.get(i).getChannelNameCount();
		}
		return new Object[]{names,counts};
	}

}
