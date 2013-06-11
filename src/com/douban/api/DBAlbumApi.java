package com.douban.api;

import android.content.Context;

import com.douban.data.DBAlbumData;
import com.douban.data.DBAlbumsData;
import com.douban.data.DBPhotosData;
import com.douban.http.DBHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class DBAlbumApi extends DBBaseApi{

	DBAlbumApi(Context ctx){
		super(ctx);
	}
	
	public void reqAlbum(String albumId, DBHttpResponseHandler handler){
		handler.setClassType(DBAlbumData.class);
		String url = String.format(DBApiConst.GET_ALBUM, albumId);
		getHttpClient().get(url, null, handler);
	}
	
	public void reqAlbums(String userId, int start, int count, DBHttpResponseHandler handler){
		handler.setClassType(DBAlbumsData.class);
		String url = String.format(DBApiConst.GET_USER_ALBUM, userId);
		RequestParams params = new RequestParams();
		params.put("start", String.valueOf(start));
		params.put("count", String.valueOf(count));
		getHttpClient().addHeader("Authorization", "Bearer " + getAccessToken());
		getHttpClient().get(url, params, handler);
	}
	
	public void reqAlbumPhotos(String albumId, int start, int count, DBHttpResponseHandler handler){
		reqAlbumPhotos(albumId, start, count, null, null, handler);
	}
	
	public void reqAlbumPhotos(String albumId, int start, int count, 
		String order, String sort, DBHttpResponseHandler handler){
		handler.setClassType(DBPhotosData.class);
		String url = String.format(DBApiConst.GET_PHOTOS, albumId);
		RequestParams params = new RequestParams();
		params.put("start", String.valueOf(start));
		params.put("count", String.valueOf(count));
		// order && sort  暂时没用 文档没告知有哪些值
		getHttpClient().get(url, params, handler);
	}
	
	
	
	//.....
}