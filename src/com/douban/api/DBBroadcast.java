package com.douban.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.douban.data.DBBroadcastTimeLineData;
import com.douban.data.DBBroadcastTimeLineData.BoradcastData;
import com.douban.http.DBHttpClient;
import com.douban.http.DBHttpResponseHandler;
import com.loopj.android.http.RequestParams;


/**
 *  豆瓣说接口, 
 * @author 6a209
 * 9:52:46 PM Nov 17, 2012
 */
public class DBBroadcast {
	
	private static final int DEFAULT_COUNT = 20;
	private Context mCtx;

	public Map getUserTimeline(String uid){
		Map map = new HashMap<String, Object>();
		return map;
	}
	
	DBBroadcast(Context ctx){
		mCtx = ctx.getApplicationContext();
	}
	
	/**
	 * 发送广播
	 */
	public void reqSendBroacast(String source, String text, DBHttpResponseHandler handler){
		reqSendBroadcast(source, text, null, null, null, null, handler);
	}
	
	/**
	 * 带图
	 * @throws FileNotFoundException 
	 */
	public void reqSendBroadcast(String source, String text, File image, 
			DBHttpResponseHandler handler) throws FileNotFoundException{
		reqSendBroadcast(source, text, image, null, null, null, null, handler);
	}
	
	/**
	 * 带推荐
	 */
	public void reqSendBroadcast(String source, String text, String recTitle,
			String recUrl, String recDesc,  String recImage, DBHttpResponseHandler handler){
		reqSendBroadcast(source, text, null, recTitle, recUrl, recDesc, handler);
	}
	
	/**
	 * 带图带推荐
	 * @param source
	 * @param text
	 * @param image
	 * @param recTitle
	 * @param recUrl
	 * @param recDesc
	 * @return
	 * @throws FileNotFoundException 
	 */
	public void reqSendBroadcast(String source, String text, 
			File image, String recTitle, String recUrl, String recDesc, 
			String recImage, DBHttpResponseHandler handler) throws FileNotFoundException{
		RequestParams params = new RequestParams();
		params.put("source", DBApiHelper.APP_KEY);
		params.put("image", image);
		params.put("text", text);
		params.put("rec_title", recTitle);
		params.put("rec_url", recUrl);
		params.put("rec_desc", recDesc);
		params.put("rec_image", recImage);
		DBHttpClient.instance(mCtx).post(DBApiConst.STATUS, params, handler);
	}

	public void reqMyTimeLine(int sinceId, int untilId, int count, int start, 
		DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("since_id", String.valueOf(sinceId));
		params.put("until_id", String.valueOf(untilId));
		params.put("conut", String.valueOf(count));
		params.put("start", String.valueOf(start));
		DBHttpClient.instance(mCtx).post(DBApiConst.HOME_TIMELINE, params, handler);
	}
	
	public void reqUserTimeLine(String uidOrName, int sinceId, int untilId, 
		DBHttpResponseHandler handler){
		RequestParams params = new RequestParams();
		params.put("since_id", String.valueOf(sinceId));
		params.put("until_id", String.valueOf(untilId));
		String url = String.format(DBApiConst.USER_TIMELINE, uidOrName);
		DBHttpClient.instance(mCtx).get(url, params, handler);
	}
	
	public void reqOneBroadcast(String id, DBHttpResponseHandler hander){
		String url = String.format(DBApiConst.ONE_MINIBLOG, id);
		DBHttpClient.instance(mCtx).get(url, null, hander);
	}
	
	public void reqDelOneBroadcast(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.ONE_MINIBLOG, id);
		DBHttpClient.instance(mCtx).del(url, handler);
	}
	
	public void reqComments(String id, int start, int count, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.MINIBLOG_COMMNETS, id);
		RequestParams params = new RequestParams();
		params.put("start", String.valueOf(start));
		params.put("count", String.valueOf(count));
		DBHttpClient.instance(mCtx).get(url, params, handler);
	}
	
	public void reqNewComment(String id, String text, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.NEW_MINIBLOG_COMMENTS, id);
		RequestParams params = new RequestParams();
		params.put("text", text);
		DBHttpClient.instance(mCtx).post(url, params, handler);
	}
	
	public void reqOneComment(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.ONE_MINIBLOG_COMMENT, id);
		DBHttpClient.instance(mCtx).get(url, null, handler);
	}
	
	public void reqDelComment(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.ONE_MINIBLOG_COMMENT, id);
		DBHttpClient.instance(mCtx).get(url, null, handler);
	}
	
	// 转播相关,
	public void reqReshare(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.MINIBLOG_RESHARE, id);
		DBHttpClient.instance(mCtx).post(url, null, handler);
	}
	
	//删除转播
	public void reqUnReshare(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.MINIBLOG_RESHARE, id);
		DBHttpClient.instance(mCtx).del(url,  handler);
	}
	
	//获取转播用户列表
	public void reqResharers(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.MINIBLOG_RESHARE, id);
		DBHttpClient.instance(mCtx).get(url, null, handler);
	}
	
	public void reqLike(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.MINIBLOG_LIKE, id);
		DBHttpClient.instance(mCtx).post(url, null, handler);
	}
	
	public void reqUnlike(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.MINIBLOG_LIKE, id);
		DBHttpClient.instance(mCtx).del(url, handler);
	}
	
	public void reqLikers(String id, DBHttpResponseHandler handler){
		String url = String.format(DBApiConst.MINIBLOG_LIKE, id);
		DBHttpClient.instance(mCtx).get(url, null, handler);
	}
	
	
}