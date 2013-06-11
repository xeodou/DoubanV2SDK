package com.douban.api;

import android.content.Context;


/**
 * 豆瓣api接口
 * @author 6a209
 * 1:06:10 AM Jan 23, 2013
 */
public class DBApiHelper {
	
	private DBBroadcast mBroadcastApi;
	private DBAlbumApi mAlbumApi;
	private Context mCtx;
	private static DBApiHelper sApi;
	
	public static final String APP_KEY = "";
	private DBApiHelper(Context ctx) {
		mCtx = ctx.getApplicationContext();
		mBroadcastApi = new DBBroadcast(mCtx);
	}
	
	public static DBApiHelper instance(Context ctx){
		if(null == sApi){
			sApi = new DBApiHelper(ctx);
		}
		return sApi;
	}
	
	public DBAlbumApi getAlbumApi(){
		if(null == mAlbumApi){
			mAlbumApi = new DBAlbumApi(mCtx);
		}
		return mAlbumApi;
	}
	
	public DBBroadcast getBroadcastApi(){
		if(null == mBroadcastApi){
			mBroadcastApi = new DBBroadcast(mCtx);
		}
		return mBroadcastApi;
	}
}