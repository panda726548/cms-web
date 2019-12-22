package org.xupan.basic.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * hql获取最近一周  一个月的数据
 * @author Administrator
 *
 */
public class HqlDataUtil {
	/**
	 * 如果(str！=month) &&  (str！=week), 则查询的就是当天的数据
	 * 如果str="month"//距离今天，一个月内数据
	 * 如果str="week"//距离今天，一个月内数据
	 * @param str
	 * @return  开始时间   和  结束时间
	 */
	public static Date[] getLastData(String str){
		//创建Date对象
		Date endDate = new Date();
		//创建基于当前时间的日历对象
		Calendar cl = Calendar.getInstance();
		cl.setTime(endDate);
		//距离今天，一个月内数据
		if(str.equals("month")){
			cl.add(Calendar.MONTH, -1);
		}
		//距离今天，一周内的数据
		if(str.equals("week")){
			cl.add(Calendar.DATE, -7);
		}
		Date startDate = cl.getTime();
		
		return new Date[]{startDate,endDate};
	}
	
	
	public static String[] getLastDataForString(String str){
		//创建Date对象
				Date endDate = new Date();
				//创建基于当前时间的日历对象
				Calendar cl = Calendar.getInstance();
				cl.setTime(endDate);
				//距离今天，一个月内数据
				 if(str.equals("month")){
				  cl.add(Calendar.MONTH, -1);
				}
				 //距离今天，一周内的数据
				if(str.equals("week")){
				  cl.add(Calendar.DATE, -7);
				 }
				Date startDate = cl.getTime();
				SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
				//格式化开始日期和结束日期
				String start = dd.format(startDate);
				String end = dd.format(endDate);
				return new String[]{start,end};
	}

}
