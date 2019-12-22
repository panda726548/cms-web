package org.xupan.cms.weixin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.xupan.basic.util.JsonUtil;
import org.xupan.cms.weixin.kit.WeixinBasicKit;
import org.xupan.cms.weixin.model.WeixinFinalValue;
import org.xupan.cms.weixin.model.WeixinGroup;
@Service("wGroupService")
public class WeixinGroupServiceImpl implements IWeixinGroupService {

	@Override
	public void addGroup(WeixinGroup group) {
		/*
		 json的数据格式，需要在group对象前面加"group"  所以用map先存，然后在将map转换为json
		 * {
		    "group": {
		        "id": 107, 
		        "name": "test"
		    }
		}
		*/
		String url=WeixinFinalValue.ADD_GROUP;
		url=WeixinBasicKit.replaceAccessTokenUrl(url);
		//将组放入到map中
		Map<String,WeixinGroup> map=new HashMap<String, WeixinGroup>();
		map.put("group", group);
		String json=JsonUtil.getInstance().obj2json(map);
		//微信工具类中的发送请求
		String content=WeixinBasicKit.sendJsonPost(url, json);
		System.out.println("添加分组后的返回代码:"+content);
	}

	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Override
	public List<WeixinGroup> queryAll() {
		String url=WeixinFinalValue.QUERY_ALL_GROUP;
		url=WeixinBasicKit.replaceAccessTokenUrl(url);
		String json=WeixinBasicKit.sendGet(url);
		//将json转换为list集合
		Map<String,List<Map>> maps=(Map<String, List<Map>>) JsonUtil.getInstance().json2obj(json, Map.class);
		List<Map> listMap=maps.get("groups");
		List<WeixinGroup> groupList=new ArrayList<WeixinGroup>();
		for (Map map : listMap) {
			WeixinGroup wg=new WeixinGroup();
			wg.setId((Integer)map.get("id"));
			wg.setName((String)map.get("name"));
			wg.setCount((Integer)map.get("count"));
			groupList.add(wg);
		}
		
		return groupList;
	}

	@Override
	public WeixinGroup queryUserGroup(String openid) {
		List<WeixinGroup> wgs=queryAll();//得到所有的组
		String url=WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.QUERY_USER_GROUP);
		Map<String,String> map=new HashMap<String, String>();
		map.put("openid", openid);
		String content=WeixinBasicKit.sendJsonPost(url, JsonUtil.getInstance().obj2json(map));
		Map<String,Integer> gm=(Map<String, Integer>) JsonUtil.getInstance().json2obj(content, Map.class);
		Integer gid=gm.get("groupid");
		for (WeixinGroup g : wgs) {
			if(g.getId()==gid){
				return g;
			}
		}
		return null;
	}

	@Override
	public void updateGroupName(int gid, String name) {
		String url=WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.UPDATE_GROUP_NAME);
		Map<String,WeixinGroup> map=new HashMap<String, WeixinGroup>();
		WeixinGroup wg=new WeixinGroup();
		wg.setId(gid);
		wg.setName(name);
		map.put("group", wg);
		String json=JsonUtil.getInstance().obj2json(map);
		//System.out.println(json);
		//执行post请求
		String str=WeixinBasicKit.sendJsonPost(url, json);
		System.out.println("修改用户组返回结果:"+str);
	}

	@Override
	public void moveUserToGroup(String openid, int to_groupid) {
		String url=WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MOVE_USER_GROUP);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("openid", openid);
		map.put("to_groupid", to_groupid);
		String json=JsonUtil.getInstance().obj2json(map);
		//执行post请求
		String str=WeixinBasicKit.sendJsonPost(url, json);
		System.out.println("移动用户到分组返回结果:"+str);

	}

	@Override
	public void moveUsersToGroup(List<String> list, int to_groupid) {
		String url=WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MOVE_USERS_GROUP);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("openid_list", list);
		map.put("to_groupid", to_groupid);
		String json=JsonUtil.getInstance().obj2json(map);
		//执行post请求
		String str=WeixinBasicKit.sendJsonPost(url, json);
		System.out.println("移动多个用户到分组返回结果:"+str);
		
	}

	@Override
	public void deleteGroup(int gid) {
		String url=WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.DELETE_GROUP);
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("id", gid);
		//在前面加上  group  成这样的json  {"group":{"id":108}}
		Map<String,Map<String,Integer>> maps=new HashMap<String, Map<String,Integer>>();
		maps.put("group", map);
		String json=JsonUtil.getInstance().obj2json(maps);
		//执行post请求
		String str=WeixinBasicKit.sendJsonPost(url, json);
		System.out.println("删除分组返回结果:"+str);
		

	}

}
