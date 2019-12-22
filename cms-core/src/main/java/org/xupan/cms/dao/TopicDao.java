package org.xupan.cms.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Repository;
import org.xupan.basic.dao.BaseDao;
import org.xupan.basic.model.Pager;
import org.xupan.basic.util.HqlDataUtil;
import org.xupan.cms.model.ReportDto;
import org.xupan.cms.model.Topic;

@Repository("topicDao")
public class TopicDao extends BaseDao<Topic> implements ITopicDao {

	@Override
	public Pager<Topic> find(Integer cid, String title, Integer status) {
		return find(null,cid,title,status);
	}
	
	private String getTopicSelect() {
		return "select new Topic(t.id,t.title,t.keyword,t.status,t.recommend,t.publishDate,t.author,t.cname,t.newName,t.summary,t.yuanwenLike,t.browseNumber)";
	}

	@Override
	public Pager<Topic> find(Integer uid, Integer cid, String title,
			Integer status) {
		String hql = getTopicSelect()+" from Topic t where 1=1";
		if(status!=null) {
			hql+=" and t.status="+status;
		}
		if(title!=null&&!title.equals("")) {
			hql+=" and t.title like '%"+title+"%'";
		}
 		if(uid!=null&&uid>0) {
			hql+=" and t.user.id="+uid;
		}
		if(cid!=null&&cid>0) {
			hql+=" and t.channel.id="+cid;
		}
		return this.find(hql);
	}

	@Override
	public Pager<Topic> searchTopicByKeyword(String keyword) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and t.keyword like '%"+keyword+"%'";
		return this.find(hql);
	}

	@Override
	public Pager<Topic> searchTopic(String con) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and " +
				"(title like '%"+con+"%' or content like '%"+con+"%' or summary like '%"+con+"%')";
		return this.find(hql);
	}

	@Override
	public Pager<Topic> findRecommendTopic(Integer cid) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and t.recommend=1";
		if(cid==null||cid==0) {
			hql+=" order by publishDate DESC";
			return this.find(hql);
		} else {
			hql +=" and t.channel.id=? order by publishDate DESC";
			return this.find(hql, cid);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> listTopicByChannelAndNumber(int cid, int num) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and t.channel.id=? order by t.publishDate desc";
		return this.getSession().createQuery(hql).setParameter(0, cid)
				.setFirstResult(0).setMaxResults(num).list();
		
	}

	@Override
	public List<Topic> listTopicsByChannel(int cid) {
		String hql = "select t from Topic t where t.channel.id=?";
		return this.list(hql,cid);
	}

	@Override
	public boolean isUpdateIndex(int cid) {
		String hql = "select count(*) from Channel c where c.isIndex=1 and c.status=0 and c.id=?";
		Long count = (Long)this.getSession().createQuery(hql).setParameter(0, cid).uniqueResult();
		if(count==null||count<=0) return false;
		return true;
	}

	@Override
	public Topic loadLastedTopicByColumn(int cid) {
		String s = "select new Topic(t.id,t.title,t.keyword,t.status,t.recommend,t.publishDate,t.author,t.cname,t.summary,t.browseNumber)";
		String hql = s+" from Topic t where t.status=1 and t.channel.id=? order by t.publishDate desc";
		Topic topic = (Topic)this.getSession()
				.createQuery(hql).setFirstResult(0).setMaxResults(1)
				.setParameter(0, cid).uniqueResult();
		return topic;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> ListRecommendTopic(Integer ci, int num) {
		String hql = getTopicSelect()+" from Topic t where t.status=1 and t.recommend=1";
		if(ci==null||ci==0) {
			hql+=" order by publishDate DESC";
			return this.getSession().createQuery(hql)
					.setFirstResult(0).setMaxResults(num).list();
		} else {
			hql +=" and t.channel.id=? order by publishDate DESC";
			return this.getSession().createQuery(hql).setParameter(0, ci)
					.setFirstResult(0).setMaxResults(num).list();
		}
	}

	@Override
	public List<ReportDto>  getChannelReportdata() {
		String hql="select cname, count(*) from Topic group by cname ";
		List list=this.getSession().createQuery(hql).list();
		List<ReportDto> reportDtoList=new ArrayList<ReportDto>();
		 for(int i=0;i<list.size();i++){
			 Object[] obj=(Object[]) list.get(i);
			 ReportDto rd=new ReportDto(obj[0].toString(),(Long)obj[1]);
			 reportDtoList.add(rd);
		}
		return reportDtoList;
	}

	@Override
	public List<ReportDto> getLastWeekData() {
		Date [] strDate=HqlDataUtil.getLastData("week");//最近一周的数据
		String hql="select cname, count(*) from Topic  where publishDate>? and publishDate<? group by cname";
		List list=this.getSession()//
				.createQuery(hql)//
				.setParameter(0, strDate[0])//
				.setParameter(1, strDate[1])//
				.list();
		List<ReportDto> reportDtoList=new ArrayList<ReportDto>();
		 for(int i=0;i<list.size();i++){
			 Object[] obj=(Object[]) list.get(i);
			 ReportDto rd=new ReportDto(obj[0].toString(),(Long)obj[1]);
			 reportDtoList.add(rd);
		}
		return reportDtoList;
	}
	
}
