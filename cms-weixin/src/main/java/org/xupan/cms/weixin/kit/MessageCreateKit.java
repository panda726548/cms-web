package org.xupan.cms.weixin.kit;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建文本消息
 * @author Administrator
 *
 */
public class MessageCreateKit {

	/**
	 * 创建文本消息
	 * @param msgMap
	 * @param content
	 * @return
	 */
	public static Map<String, Object> createTextMsg(Map<String, String> msgMap,
			String content) {
		Map<String,Object > tm = new HashMap<String,Object>();
		tm.put("ToUserName", msgMap.get("FromUserName"));
		tm.put("FromUserName", msgMap.get("ToUserName"));
		tm.put("CreateTime", System.currentTimeMillis()+"");
		tm.put("MsgType", "text");
		tm.put("Content", content);
		return tm;
	}

}
