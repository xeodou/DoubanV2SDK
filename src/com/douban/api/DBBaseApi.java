package com.douban.api;

import com.douban.http.DBHttpClient;

import android.content.Context;

public class DBBaseApi{
	
	Context mCtx;
	protected String mAccessToken;
	protected String mApiKey;
	DBBaseApi(Context ctx) {
		mCtx = ctx.getApplicationContext();
	}
	
	protected DBHttpClient getHttpClient(){
		return DBHttpClient.instance(mCtx);
	}
	
	protected String getAccessToken(){
		return "d46ed0adba3d1af97d4c72092eb750eb"; 
	}

	
}