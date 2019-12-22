package org.xupan.cms.weixin.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * 刷新token定时任务器
 * @author Administrator
 * 可以执行所有的定时任务
 */
public class RefreshAccessTokenJob extends QuartzJobBean {
	//刷新token任务
	private RefreshAccessTokenTask refreshAccessTokenTask;
	
	

	@Override
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		refreshAccessTokenTask.refreshToken();
	}
	//set方法  （spring配置文件中映射）
	public RefreshAccessTokenTask getRefreshAccessTokenTask() {
		return refreshAccessTokenTask;
	}


	public void setRefreshAccessTokenTask(
			RefreshAccessTokenTask refreshAccessTokenTask) {
		this.refreshAccessTokenTask = refreshAccessTokenTask;
	}

}
