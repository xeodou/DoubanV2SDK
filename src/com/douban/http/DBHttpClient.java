package com.douban.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * http 请求, 封装了get, post, del, put
 * @author 6a209
 * 9:04:55 PM Jan 22, 2013
 */
public class DBHttpClient {

	private AsyncHttpClient mHttpClient;
	private static DBHttpClient sHttpClient;
	private Context mCtx;

	private DBHttpClient(Context ctx) {
		mCtx = ctx.getApplicationContext();
		mHttpClient = new AsyncHttpClient();
	}
	
	

	public static DBHttpClient instance(Context ctx) {
		if (null == sHttpClient) {
			sHttpClient = new DBHttpClient(ctx);
		}
		return sHttpClient;
	}
	
	public void addHeader(String key, String value){
		mHttpClient.addHeader(key, value);
	}

	public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		if(!isAvailable()){
			showToast("网络异常");
			return;
		}
		Log.d("url is", url);
		Log.d("params is", params.toString());
		mHttpClient.get(null, url, params, responseHandler);
	}

	public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		if(!isAvailable()){
			showToast("网络异常");
			return;
		}
		mHttpClient.post(url, params, responseHandler);
	}
	
	public void put(String url, RequestParams params, AsyncHttpResponseHandler handler){
		if(!isAvailable()){
			showToast("网络异常");
			return;
		}
		mHttpClient.put(url, params, handler);
	}
	
	public void del(String url, AsyncHttpResponseHandler handler){
		if(!isAvailable()){
			showToast("网络异常");
			return;
		}
		mHttpClient.delete(url, handler);
	}
	
	private void showToast(String str){
		Toast.makeText(mCtx, str, Toast.LENGTH_SHORT).show();
	}
	
    private  boolean isAvailable() {
		ConnectivityManager manager = (ConnectivityManager) mCtx
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkinfo = manager.getActiveNetworkInfo();
		if (networkinfo == null || !networkinfo.isAvailable()) {
			return false;
		}
		return true;
	}

}