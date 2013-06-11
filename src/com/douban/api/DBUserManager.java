package com.douban.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class DBUserManager{
	
	private static DBUserManager sUserManager;
	private SharedPreferences mPreference;
	public static final String PREFERENCES_NAME = "douban_account";
	public static final String ACCESS_TOKEN_KEY = "access_token";
	public static final String EXPIRES_IN_KEY = "expires_in";
	public static final String REFRES_TOKEN_KEY = "refresh_token";
	public static final String USER_ID_KEY = "douban_user_id";
	private DBUserManager(Context ctx){
		mPreference = ctx.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
	}
	
	public static DBUserManager getInstance(Context ctx){
		if(null == sUserManager){
			sUserManager = new DBUserManager(ctx);
		}
		return sUserManager;
	}
	
	public void login(String accessToken, long expiress, String refreshToken, String userId){
		Editor editor = mPreference.edit();
		editor.putString(ACCESS_TOKEN_KEY, accessToken);
		editor.putLong(EXPIRES_IN_KEY, expiress);
		editor.putString(REFRES_TOKEN_KEY, refreshToken);
		editor.putString(USER_ID_KEY, userId);
		editor.commit();
	}
	
	public boolean isLogin(){
		String uid = mPreference.getString(USER_ID_KEY, "");
		return null != uid && !uid.equals("");
	}
	
	public boolean isExpiress(){
		return false;
	}
	
	public void refreshToken(){
	}
	
	public void loginOut(){
		reset();
	}
	
	private void reset(){
		Editor editor = mPreference.edit();
		editor.putString(ACCESS_TOKEN_KEY, "");
		editor.putString(REFRES_TOKEN_KEY, "");
		editor.putString(USER_ID_KEY, "");	
		editor.commit();
	}
}