package com.douban.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;



public class DBOAuth2 {

	private static final String GET_AUTHORIZATION_CODE = "https://www.douban.com/service/auth2/auth";
	private static final String GET_ACCESS_TOKEN = "https://www.douban.com/service/auth2/token";
	private static final String DEFAULT_TYPE = "code";
	private static final String DEFAULT_GRANT_TYPE = "authorization_code";
	
	private String mClientId;
	private String mRedirectUri;
	private String mResponseType;
	private String mScope;
	private String mState;
	private String mClientSecret;
	private String mGrantType;
	private String mAuthorizationCode;
	private String mAccessToken;
	private int mExpiresIn;
	private String mRefreshToken;
	private String mDoubanUserId;
	private String mDoubanUserName;
	
	private WebView mWebView;
	private AsyncHttpClient mHttpClient;
	
	private DBUserManager mUserManager;
	
	public interface OnLoginOverListener{
		void onLoginSuccess();
		void onLoginFail(String err);
	}
	private OnLoginOverListener mLoginOverListener; 
	
	
	public DBOAuth2(WebView webView, String clientId, String redirectUri, String clientSecret, String scope){
		initOAuthParams(webView.getContext(), clientId, redirectUri, clientSecret, scope);
		mWebView = webView;
		initWebView();
	}
	
	public DBOAuth2(Context ctx, String clientId, String redirectUri, String clientSecret, String scope){
		initOAuthParams(ctx, clientId, redirectUri, clientSecret, scope);
	}
	
	private void initOAuthParams(Context ctx, String clientId, String redirectUri, 
		String clientSecret, String scope){
		mClientId = clientId;
		mRedirectUri = redirectUri;
		mClientSecret = clientSecret;
		mScope = scope;
		mResponseType = DEFAULT_TYPE;
		mUserManager = DBUserManager.getInstance(ctx.getApplicationContext());
		mHttpClient = new AsyncHttpClient();
	}
	
	private void initWebView(){
		mWebView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url){
				if(url.contains(mRedirectUri)){
					mAuthorizationCode = url.replace(mRedirectUri + "/?code=", "");
					reqAccessToken();
				}
				return true;
			}
		});
	}
	
	public void setOnLoginOverListener(OnLoginOverListener listener){
		mLoginOverListener = listener;
	}
	
	public void setScope(String scope){
		mScope = scope;
	}
	
	public void setResponseType(String type){
		mResponseType = type;
	}
	
	public String getUserId(){
		return mDoubanUserId;
	}
	
	public String getDoubanUserName(){
		return mDoubanUserName;
	}
	
	public String getAccessToken(){
		return mAccessToken;
	}
	
	public int getExpiresIn(){
		return mExpiresIn;
	}
	
	public String getRefreshToken(){
		return mRefreshToken;
	}
	
	public void reqAccessToken(){
		refreshAccessToken(null);
	}
	
	
	public void refreshAccessToken(String refreshToken){
		Map<String, String> map = new HashMap<String, String>();
		map.put("client_id", mClientId);
		map.put("client_secret", mClientSecret);
		map.put("redirect_uri", mRedirectUri);
		
		// 是获取还是刷新
		if(null == refreshToken){
			mGrantType = "authorization_code";
			map.put("code", mAuthorizationCode);
		}else{
			mGrantType = "refresh_token";
			map.put("refresh_token", mRefreshToken);
		}
		map.put("grant_type", mGrantType);
		RequestParams params = new RequestParams(map);
		mHttpClient.post(GET_ACCESS_TOKEN, params, new AsyncHttpResponseHandler(){
			
			@Override
			public void onSuccess(String content){
				JSONObject obj = null;
				try {
					obj = new JSONObject(content);
					mAccessToken = obj.optString("access_token");
					mExpiresIn = obj.optInt("expires_in");
					mRefreshToken = obj.optString("refresh_token");
					mDoubanUserId = obj.optString("douban_user_id");
					mDoubanUserName = obj.optString("douban_user_name");
					mUserManager.login(mAccessToken, mExpiresIn, mRefreshToken, mDoubanUserId);
					if(null != mLoginOverListener){
						mLoginOverListener.onLoginSuccess();
					}
				} catch (JSONException e) {
					e.printStackTrace();
					Log.e("login err", content);
					if(null != mLoginOverListener){
						mLoginOverListener.onLoginFail(content);
					}	
				}
			}
			
			@Override
			public void onFailure(Throwable t, String content){
				Log.e("err err", content);
				t.printStackTrace();
				if(null != mLoginOverListener){
					mLoginOverListener.onLoginFail(content);
				}
			}
			
			@Override
			public void onFinish(){
				Log.d("finish", "finish");
			}
		});
	}
	
	public void reqAuthorizationCode(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("client_id", mClientId);
		map.put("redirect_uri", mRedirectUri);
		map.put("response_type", mResponseType);
		map.put("scope", mScope);
		String url = GET_AUTHORIZATION_CODE + createParam(map);
		mWebView.loadUrl(url);
	}
	
	private String createParam(Map<String, String> map){
		StringBuilder result = new StringBuilder();
		for(Entry<String, String> entry : map.entrySet()){
			if(result.length() > 0){
				result.append("&");
			}else{
				result.append("?");
			}
			result.append(entry.getKey());
			result.append("=");
			result.append(entry.getValue());
		}
		return result.toString();
	}
	
}