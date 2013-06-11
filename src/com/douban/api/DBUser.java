package com.douban.api;

import android.content.Context;

import com.douban.http.DBHttpClient;
import com.douban.http.DBHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * 用户相关接口
 * @author 6a209
 * 1:21:57 AM Jan 26, 2013
 */
public class DBUser{
	
	private Context mCtx;
	DBUser(Context ctx){
		mCtx = ctx;
	}
	
	public void reqFollowingList(String uid,  int start, int count,
			DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("page", String.valueOf(start / count));
		params.put("count", String.valueOf(count));
		String url = String.format(DBApiConst.FOLLOWINGS, uid);  
		DBHttpClient.instance(mCtx).get(url, params, handler);
	}
	
	public void reqFollowersList(String uid, int start, int count, 
			DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("page", String.valueOf(start/ count));
		params.put("count", String.valueOf(count));
		String url = String.format(DBApiConst.FOLLOWS, uid);
		DBHttpClient.instance(mCtx).get(url, params, handler);
	}
	
	/**
	 * 共同关注
	 * @param uid
	 * @param start
	 * @param count
	 * @param handler
	 */
	public void reqFollowInCommon(String uid, int start, int count,
			DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("start", String.valueOf(start));
		params.put("count", String.valueOf(count));
		String url = String.format(DBApiConst.FOLLOW_IN_COMMON, uid);
		DBHttpClient.instance(mCtx).get(url, params, handler);
	}
	
	public void reqSearchUser(String q, int start, int count,
			DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("start", String.valueOf(start));
		params.put("count", String.valueOf(count));
		params.put("q", q);
		DBHttpClient.instance(mCtx).get(DBApiConst.SEARCH_USER, params, handler);
	}
	
	public void reqBlock(String uid, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.BLOCK_USER, uid);
		DBHttpClient.instance(mCtx).post(url, null, handler);
	}
	
	public void reqAddFollow(String uid, DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("user_id", uid);
		DBHttpClient.instance(mCtx).post(DBApiConst.ADD_FOLLOW, params, handler);
	}
	
	public void reqUnFollow(String uid, DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("user_id", uid);
		DBHttpClient.instance(mCtx).post(DBApiConst.DEL_FOLLOW, params, handler);
	}
	
	public void reqFriendships(String targetId, String sourceId, 
		DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("target_id", targetId);
		params.put("source_id", sourceId);
		DBHttpClient.instance(mCtx).get(DBApiConst.FRIENDSHIPS, params, handler);
	}
	
	public void reqUserInfo(String uid, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.USER_INFO, uid);
		DBHttpClient.instance(mCtx).get(url, null, handler);
	}
	
	public void reqMeInfo(DBHttpResponseHandler handler){
		DBHttpClient.instance(mCtx).get(DBApiConst.ME_INFO, null, handler);
	}
}