package com.douban.api;


/**
 * 记录api使用过程的所有常量
 * @author 6a209
 * 10:24:51 PM Nov 17, 2012
 */
public class DBApiConst{
	
	//base
	public static final String BASE_URL = "https://api.douban.com/";
	
//	public static final String VERSION_TYPE = "V2";
	
	// ==== 豆瓣说 ======
	/** 发送消息 */
	public static final String STATUS =  BASE_URL + "shuo/v2/statuses/";
	/** 获取当前用户的 time line */
	public static final String HOME_TIMELINE = BASE_URL + "shuo/V2/statuses/home_timeline";
	/** 获取用户发布的广播 (得在路径上加上用户id)*/ 
	public static final String USER_TIMELINE = BASE_URL + "shuo/v2/statuses/user_timeline/%s"; //:user_id;
	/** 对单推的操作, 删除还是(delete), 获取(get) */
	public static final String ONE_MINIBLOG = BASE_URL + "shuo/v2/statuses/%s";
	/** 获取单条评论列(get), 删除一条评论(del)*/
	public static final String ONE_MINIBLOG_COMMENT = BASE_URL + "shuo/v2/statuses/commnt/%s";
	/** 新建一条评论 */
	public static final String NEW_MINIBLOG_COMMENTS = BASE_URL + "shuo/v2/statuses/%s/comments";
	/** 获取评论列表 */
	public static final String MINIBLOG_COMMNETS = NEW_MINIBLOG_COMMENTS;
	/** 获取转播相关 */
	public static final String MINIBLOG_RESHARE = BASE_URL + "shuo/v2/statuses/%s/reshare";
	/** 赞 相关 */
	public static final String MINIBLOG_LIKE = BASE_URL + "shuo/v2/statues/%s/like";
	
	// ======== 豆瓣关注列表 =====
	
	/** 取某用户信息 */
	public static final String USER_INFO = BASE_URL + "v2/user/%s";
	/** 登入用户信息 */
	public static final String ME_INFO = BASE_URL + "~me";
	/** 用户关注列表 */
	public static final String FOLLOWINGS = BASE_URL + "shuo/v2/users/%s/following";
	/** 被关注列表 */
	public static final String FOLLOWS = BASE_URL + "shuo/v2/users/%s/followers";
	/** 共同关注 */
	public static final String FOLLOW_IN_COMMON = BASE_URL + "shuo/v2/users/%s/follow_in_common";
	/** 关注的人中也关注该用户的列表 */
	public static final String FOLLOWING_FOLLOWERS_OF = BASE_URL + "shuo/v2/users/%s/following_followers_of";
	/** 搜索用户 */
	public static final String SEARCH_USER = BASE_URL + "v2/user";
	/** 加入黑名单 */
	public static final String BLOCK_USER = BASE_URL + "shuo/v2/users/%s/block";
	/** 加关注 */
	public static final String ADD_FOLLOW = BASE_URL + "shuo/v2/friendships/create";
	/** 取消关注 */
	public static final String DEL_FOLLOW = BASE_URL + "shuo/v2/friendships/destroy";
	/** 获取两个用户关系 */
	public static final String FRIENDSHIPS = BASE_URL + "shuo/v2/friendships/show";
	
	// ======= 豆瓣 相册 =======
	
	/** 获取某个相册的信息*/
	public static final String GET_ALBUM = BASE_URL + "v2/album/%s";
	/** 获取某个线程照片列表 */
	public static final String GET_PHOTOS = BASE_URL + "v2/album/%s/photos";
	/** 获取某人的相册列表 */
	public static final String GET_USER_ALBUM = BASE_URL + "v2/album/user_created/%s";
	/** 获取单张照片 */
	public static final String GET_ONE_PHOTO = BASE_URL + "v2/photo/%s";

	
	// ======= 回复 接口 ========
}