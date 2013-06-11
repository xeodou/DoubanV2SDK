package com.douban.data;

import java.util.ArrayList;

import com.douban.api.DBUser;
import com.google.gson.annotations.SerializedName;

public class DBAlbumsData extends DBBaseData{
	@SerializedName("count")
	public int mCount;
	@SerializedName("start")
	public int mStart;
	@SerializedName("albums")
	public ArrayList<DBAlbumData> mAlbumDatas;
	@SerializedName("user")
	public DBUserData mUserData;
}