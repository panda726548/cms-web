package org.xupan.cms.weixin.kit;

import java.io.IOException;
import java.util.Map;


/**
 * 接收事件推送
 * @author Administrator
 *
 */
public class WeixinEventKit {

	public static String handlerEventMsg(Map<String, String> msgMap) throws IOException {
		String event = msgMap.get("Event");
		if("CLICK".equals(event)) {//单击事件
			//return handlerClickEvent(msgMap);
		}else if("SCAN".equals(event)){//扫描事件
			//return handlerScanEvent(msgMap);
		}else if("subscribe".equals(event)){//用户关注事件
			//return handlerSubscribeEvent(msgMap);
		}else if("unsubscribe".equals(event)){//取消关注
			//return handlerUnsubscribeEvent(msgMap);
		}
		return null;
	}
	/**
	 * 扫描事件
	 * @param msgMap
	 * @return
	 * @throws IOException 
	 *//*
	private static String handlerScanEvent(Map<String, String> msgMap) throws IOException {
		handlerUserInfo(msgMap);
		String snum = getSence(msgMap, false);
		String openid = msgMap.get("FromUserName");
		IWeixinQrService weixinQrService = (IWeixinQrService)BeanFactoryContext.getService("weixinQrService");
		//获得微信二维码对象
		WeixinQr wq = weixinQrService.loadBySnum(Integer.parseInt(snum));
		//根据二维码的类型执行相关的操作
		if(wq.getType()==WeixinQr.REPASSWORD_TYPE) {
			//处理修改密码操作
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\""+wq.getQrData()+"\">"+wq.getMsg()+"</a>"));
		} else if(wq.getType()==WeixinQr.SET_GROUP_TYPE) {
			//处理设置用户组的操作
			IWeixinGroupService wGroupService = (IWeixinGroupService)BeanFactoryContext.getService("wGroupService");
			//修改用户组
			wGroupService.moveUserToGroup(openid, Integer.parseInt(wq.getQrData()));
			//获得修改后的用户组
			WeixinGroup wg = wGroupService.queryUserGroup(openid);
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "你的用户组已经修改,用户组修改为:"+wg.getName()));
		} else if(wq.getType()==WeixinQr.TEMP_BIND) {
			//处理绑定用户操作
		} else if(wq.getType()==WeixinQr.TEMP_LOGIN) {
			//处理用户扫码登录操作
			long t = System.currentTimeMillis()-wq.getCreateDate().getTime();
			if((t/1000)>60) {
				return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "你所扫描的二维码已经过期，请在网页中重新刷新并且扫描"));
			} else {
				wq.setStatus(1);
				wq.setQrData(openid);
				weixinQrService.update(wq);
			}
		}
		
		
		
		return null;
	}
	*//**
	 * 用户取消关注
	 * @param msgMap
	 * @return
	 *//*
	private static String handlerUnsubscribeEvent(Map<String, String> msgMap) {
		//获取用户所关注的信息
		String openid=msgMap.get("FromUserName");
		//获取用户的userservice
		IUserService userService=(IUserService)BeanFactoryContext.getService("userService");
		//从本地数据库中根据openid获得用户信息
		User u=userService.loadByOpenid(openid);
		if(u!=null){//用户不存在
			u.setStatus(0);
			userService.update(u);
		}
		return null;
	}
	*//**
	 * 获得用户
	 * @param msgMap
	 * @return
	 *//*
	private static User getUser(Map<String, String> msgMap) {
		//获取用户所关注的信息
		String openid=msgMap.get("FromUserName");
		//获取用户的userservice
		IUserService userService=(IUserService)BeanFactoryContext.getService("userService");
		//从本地数据库中根据openid获得用户信息
		User u=userService.loadByOpenid(openid);
		return u;
		
	}
	
	private static User handlerUserInfo(Map<String, String> msgMap) {
		IUserService userService = (IUserService)BeanFactoryContext.getService("userService");
		String openid = msgMap.get("FromUserName");
		User u=getUser(msgMap);
		if(u==null){//用户不存在
			//获取WUser对象添加到数据库
			IWUserService wUserService=(IWUserService)BeanFactoryContext.getService("wUserService");
			WUser wUser= wUserService.queryByOpenId(openid);
			//将WUser对象转换为user对象
			u=wUser.getUser();
			//将user对象存入到数据库
			userService.add(u);
		}else{
			if(u.getStatus()==0) {
				//存在就将状态设置为1已关注
				u.setStatus(1);
				//更新
				userService.update(u);
			}
		}
		return u;
	}
	
	*//**
	 * 根据扫描的eventKey获得场景值snum
	 * @param msgMap
	 * @param subscribe
	 * @return
	 *//*
	private static String getSence(Map<String,String> msgMap,boolean subscribe) {
		String key = msgMap.get("EventKey");
		if(key==null||"".equals(key)) return null;
		if(subscribe)
			return key.split("_")[1];
		else 
			return key;
	}
	
	
	
	*//**
	 * 用户关注
	 * @param msgMap
	 * @return
	 * @throws IOException 
	 *//*
	private static String handlerSubscribeEvent(Map<String, String> msgMap) throws IOException {
		User u = handlerUserInfo(msgMap);
		//获得二维码的场景值
		String snum = getSence(msgMap, true);
		String openid = msgMap.get("FromUserName");
		if(snum!=null) {
			IWeixinQrService weixinQrService = (IWeixinQrService)BeanFactoryContext.getService("weixinQrService");
			WeixinQr wq = weixinQrService.loadBySnum(Integer.parseInt(snum));
			IWeixinGroupService wGroupService = (IWeixinGroupService)BeanFactoryContext.getService("wGroupService");
			if(wq.getType()==WeixinQr.SET_GROUP_TYPE) {
				//移动用户到指定的组
				wGroupService.moveUserToGroup(openid, Integer.parseInt(wq.getQrData()));
			}
		}
		
		//判断用户是否绑定
		if(u.getBind()==0){//没有绑定
			//TODO:这里的URL需要修改
			String bindUrl="http://www.jmnewsoft.com/weixin/user/bindExistUser";
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\""+bindUrl+"\">请绑定用户获得更好的体验</a>"));
		}else{
			//TODO:这里的URL需要修改
			String bindUrl="http://www.jmnewsoft.com/weixin/user/list";
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\""+bindUrl+"\">欢迎再次使用微信公共平台，点击打开</a>"));
		}
		
	}

	*//**
	 * 处理click事件
	 * @param msgMap
	 * @return
	 * @throws IOException
	 *//*
	private static String handlerClickEvent(Map<String, String> msgMap) throws IOException {
		String keyCode = msgMap.get("EventKey");
		IWeixinMenuService weixinMenuService = (IWeixinMenuService)BeanFactoryContext.getService("weixinMenuService");
		WeixinMenu wm = weixinMenuService.loadByKey(keyCode);
		if(wm!=null&&wm.getRespType()==1) {
			//创建文本消息
			Map<String,Object> map = MessageCreateKit.createTextMsg(msgMap, wm.getContent());
			//将文本消息转换为xml
			return WeixinMessageKit.map2xml(map);
		}
		return null;
	}*/

}
