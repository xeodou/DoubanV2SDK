package com.douban.data;

import com.douban.api.DBUser;
import com.douban.data.DBPhotoData.Sizes;
import com.google.gson.annotations.SerializedName;


public class DBAlbumData {
	@SerializedName("id")
	public int mId;
	@SerializedName("alt")
	public String mAlt;
	@SerializedName("title")
	public String mTitle;
	@SerializedName("icon")
	public String mIcon;
	@SerializedName("cover")
	public String mCover;
	@SerializedName("thumb")
	public String mThumb;
	@SerializedName("image")
	public String mImage;
	@SerializedName("privacy")
	public String mPrivacy;
	@SerializedName("created")
	public String mCreated;
	@SerializedName("updated")
	public String mUpdated;
	@SerializedName("liked_count")
	public int mLikeCount;
	@SerializedName("recs_count")
	public int mRecsCount;
	@SerializedName("size")
	public int mSize;
	@SerializedName("desc")
	public String mDesc;
	@SerializedName("author")
	public DBUser mAuthor;
	@SerializedName("liked")
	public boolean mIsLiked;
	@SerializedName("sizes")
	public Sizes mSizes;
}