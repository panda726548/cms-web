package org.xupan.cms.weixin.quartz;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.xupan.cms.weixin.kit.DuplicateMessageKit;
/**
 * 清空DuplicateMessage对象的定时器
 * @author Administrator
 *
 */
public class ClearDuplicateMessageJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		DuplicateMessageKit.clear();
	}

}
