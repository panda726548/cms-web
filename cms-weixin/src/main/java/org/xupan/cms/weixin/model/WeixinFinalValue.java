package org.xupan.cms.weixin.model;

public class WeixinFinalValue {
	// 获取access_token的接口地址（GET） 限2000（次/天）
	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 添加菜单的路径 https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
	public final static String MENU_ADD = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 获得菜单
	public final static String MENU_QUERY = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	// 消息类型
	public final static String MSG_TEXT_TYPE = "text";
	public final static String MSG_IMAGE_TYPE = "image";
	public final static String MSG_VOICE_TYPE = "voice";
	public final static String MSG_VIDEO_TYPE = "video";
	public final static String MSG_SHORTVIDEO_TYPE = "shortvideo";
	public final static String MSG_LOCATION_TYPE = "location";
	public final static String MSG_EVENT_TYPE = "event";

	// 临时素材管理接口post和get
	public final static String POST_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	public final static String GET_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

	// 发送模板消息接口
	public final static String SEND_TEMPLATE_MSG = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	// 用户组相关的接口
	public final static String ADD_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	public final static String QUERY_ALL_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	public final static String QUERY_USER_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	public final static String UPDATE_GROUP_NAME = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	public final static String MOVE_USER_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	public final static String MOVE_USERS_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
	public final static String DELETE_GROUP = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=ACCESS_TOKEN";
	// 查询素材列表
	public final static String QUERY_ALL_FINAL_MEDIA = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	// 新增永久图文素材
	public final static String ADD_FINAL_IMAGE_AND_TEST_MEDIA = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	// 新增其他类型永久素材
	public final static String ADD_FINAL_MEDIA = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
	public final static String ADD_FINAL_MEDIA2 = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	// 上传图文消息内的图片获取URL
	public final static String UPLOADINGIMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

	//获取用户基本信息（包括UnionID机制）
	public final static String USER_QUERY="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//网页授权获取用户基本信息  用户同意授权，获取code
	public final static String OAuth_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public final static String OAuth_GET_OPENID="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	public final static String QR_GET = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	//添加客服
	public final static String KF_ADD = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
}
