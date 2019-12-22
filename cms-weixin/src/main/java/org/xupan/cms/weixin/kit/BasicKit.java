package org.xupan.cms.weixin.kit;
/**
 * 判断是否为空
 * @author Administrator
 *
 */
public class BasicKit {

	public static boolean isEmpty(Object obj) {
		if(obj==null) return true;
		if(obj instanceof String) {
			if("".equals(((String)obj).trim())) return true;
		}
		if(obj instanceof Integer) {
			if((Integer)obj==0) return true;
		}
		return false;
	}
}
