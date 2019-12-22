package org.xupan.cms.weixin.kit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xupan.cms.weixin.model.DuplicateMessage;


/**
 * 排重消息工具类
 * @author Administrator
 *
 */
public class DuplicateMessageKit {

	public static final List<DuplicateMessage> MSGS = new ArrayList<DuplicateMessage>();
	/**
	 * 检查是否有重复
	 * @param msgMap
	 * @return
	 */
	public static boolean checkDuplicate(Map<String, String> msgMap) {
		DuplicateMessage dm = initDuplicateMessage(msgMap);
		if(MSGS.contains(dm)) {//重复
			return false; 
		} else {//不重复就要将这个对象添加到list集合
			MSGS.add(dm);
			return true;
		}
	}
	/**
	 * 获得DuplicateMessage对象
	 * 从map中取出来
	 * @param msgMap
	 * @return
	 */
	private static DuplicateMessage initDuplicateMessage(
			Map<String, String> msgMap) {
		String fromUserName = msgMap.get("FromUserName");
		String createTime = msgMap.get("CreateTime");
		DuplicateMessage dm = new DuplicateMessage(fromUserName, createTime);
		return dm;
	}
	/**
	 	每隔30秒执行清空
	 * 清空MSGS 
	 */
	public static void clear() {
		DuplicateMessage dm = null;
		System.out.println("清空开始，之前："+MSGS.size());
		for(int i=0;i<MSGS.size();i++) {
			dm = MSGS.get(i);
			if(((System.currentTimeMillis()-dm.getCurTime())/1000)>30) {
				MSGS.remove(dm);
			}
		}
		System.out.println("清空结束，之后："+MSGS.size());
	}

	
	
	public static String getRel(Map<String,String> msgMap) {
		DuplicateMessage dm = initDuplicateMessage(msgMap);
		DuplicateMessage tdm = MSGS.get(MSGS.indexOf(dm));
		return tdm.getRel();
	}
	
	public static void setRel(Map<String,String> msgMap,String rel) {
		DuplicateMessage dm = initDuplicateMessage(msgMap);
		DuplicateMessage tdm = MSGS.get(MSGS.indexOf(dm));
		tdm.setRel(rel);
	}
}
