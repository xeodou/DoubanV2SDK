package com.douban.http;

import android.content.Context;
import android.util.Log;

import com.douban.data.DBBaseData;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;


/**
 * 统一的错误处理, 和消息分发
 * @author 6a209
 * 12:32:10 AM Jan 22, 2013
 */
public abstract class DBHttpResponseHandler extends AsyncHttpResponseHandler{

	private Class<?> mTyp;
	private Context mCtx;;
	
	public DBHttpResponseHandler(Context ctx) {
		mCtx = ctx;
	}
	
	public void setClassType(Class<?> type){
		mTyp = type;
	}
	
	@Override
	public void onFailure(Throwable error, String content){
		onDoubanErr("onFailure" + content);
	}
	
	@Override
	public void onSuccess(String content){
		Log.d("onSuccess", content);
		try{
			Gson gson = new Gson();
			DBBaseData data = (DBBaseData) gson.fromJson(content, mTyp);
			onDoubanSuccess(data);
		}catch(Exception e){
			e.printStackTrace();
			onDoubanErr(e.toString());
		}
	}
	
	/**
	 * 豆瓣返回失败, 统一的错误处理
	 * @param content
	 */
	protected void onDoubanErr(String content){
		// 记录下所有错误,根据错误做出相应的回调处理
		Log.d("net err", content);
	}
	
	public void onDoubanSuccess(DBBaseData data){
		
	}
}