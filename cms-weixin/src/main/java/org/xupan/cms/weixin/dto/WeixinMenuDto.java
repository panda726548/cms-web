package org.xupan.cms.weixin.dto;
import java.util.ArrayList;
import java.util.List;
/**
 *  {
     "button":[
     {	
          "type":"click",
          "name":"今日歌曲",
          "key":"V1001_TODAY_MUSIC"
      },
      {
           "name":"菜单",
           "sub_button":[
           {	
               "type":"view",
               "name":"搜索",
               "url":"http://www.soso.com/"
            },
            {
               "type":"view",
               "name":"视频",
               "url":"http://v.qq.com/"
            },
            {
               "type":"click",
               "name":"赞一下我们",
               "key":"V1001_GOOD"
            }]
       }]
 }
 * @author Administrator
 *
 */
public class WeixinMenuDto {
	private String name;//菜单名
	private String key;//
	private String type;
	private String url;
	//子菜单集合   sub_button不能是null
	private List<WeixinMenuDto> sub_button = new ArrayList<WeixinMenuDto>();
	private int id;
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<WeixinMenuDto> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WeixinMenuDto> sub_button) {
		this.sub_button = sub_button;
	}
}
