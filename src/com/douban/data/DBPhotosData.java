package com.douban.data;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class DBPhotosData{
	
	@SerializedName("start")
	public int mStart;
	@SerializedName("count")
	public int mCount;
	@SerializedName("total")
	public int mTotal;
	@SerializedName("album")
	public DBAlbumData mAlbum;
	@SerializedName("photos")
	public ArrayList<DBPhotosData> mPhotos;
}