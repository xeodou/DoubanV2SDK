package com.douban.data;

import com.google.gson.annotations.SerializedName;

/**
 * 豆瓣用户数据结构
 * 
 * @author 6a209 12:29:50 AM Jan 4, 2013
 */
public class DBUserData {

	@SerializedName("uid")
	public String mUid;
//	@SerializedName("description")
//	public String mDesc;
	@SerializedName("avatar")
	public String mAvatar;
	@SerializedName("small_avatar")
	public String mSmallAvatar;
	@SerializedName("large_avatar")
	public String mLargeAvatar;
	@SerializedName("loc_name")
	public String mLocatioName;
	@SerializedName("type")
	public String mType;
	@SerializedName("id")
	public String mId;
	@SerializedName("screen_name")
	public String mScreenName;
	@SerializedName("name")
	public String mName;
	@SerializedName("desc")
	public String mDesc;
}