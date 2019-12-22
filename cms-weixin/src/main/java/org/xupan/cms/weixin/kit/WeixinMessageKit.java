package org.xupan.cms.weixin.kit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 消息管理工具
 * 
 * @author xupan
 * 
 */
public class WeixinMessageKit {
	/**
	 * 处理请求信息
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public static String handlerReceiveMsg(HttpServletRequest req) throws IOException {
		//将获得的消息转换成map
		Map<String,String> msgMap = reqMsg2Map(req);
		System.out.println(msgMap);
		//消息排重
		if(!DuplicateMessageKit.checkDuplicate(msgMap)) {
			String rel = DuplicateMessageKit.getRel(msgMap);
			return rel;
		}
		String msgType = msgMap.get("MsgType");
		if("event".equals(msgType.trim())) {//事件消息
			String rel = WeixinEventKit.handlerEventMsg(msgMap);
			DuplicateMessageKit.setRel(msgMap, rel);
			return rel;
		} else {//普通消息
			return hanlderCommonMsg(msgMap);
		}
		
	}

	/**
	 * 回复消息
	 * @param msgMap
	 * @return
	 * @throws IOException
	 */
	private static String hanlderCommonMsg(Map<String, String> msgMap) throws IOException {
		//TODO:将消息转到多客服
		return WeixinMessageKit.map2xml( MessageCreateKit.createTextMsg(msgMap, "我收到了消息"));
	}

	// 通过reques获取发送过来的消息 存入map中
	@SuppressWarnings("unchecked")
	private static Map<String,String> reqMsg2Map(HttpServletRequest req) throws IOException {
		String xml = req2xml(req);
		try {
			Map<String,String> maps = new HashMap<String, String>();
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Element> eles = root.elements();
			for(Element e:eles) {
				maps.put(e.getName(), e.getTextTrim());
			}
			return maps;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 将将String转换成xml
	private static String req2xml(HttpServletRequest req) throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str=br.readLine())!=null) {
			sb.append(str);
		}
		return sb.toString();
	}
	/**
	 * 将map转换为xml
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public static String map2xml(Map<String, Object> map) throws IOException {
		Document d = DocumentHelper.createDocument();
		Element root = d.addElement("xml");
		Set<String> keys = map.keySet();
		for(String key:keys) {
			Object o = map.get(key);
			if(o instanceof String) {
				String t = (String)o;
//				System.out.println(t);
				if(t.indexOf("<a")>=0) {
					root.addElement(key).addCDATA(t); 
				} else {
					root.addElement(key).addText((String)o);
				}
			} else {
				
			}
			
		}
		StringWriter sw = new StringWriter();
		XMLWriter xw = new XMLWriter(sw);
		xw.setEscapeText(false);
		xw.write(d);
		return sw.toString();
	}
}
