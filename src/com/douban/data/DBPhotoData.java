package com.douban.data;

import com.douban.api.DBUser;
import com.google.gson.annotations.SerializedName;


/**
 * 图片数据类型
 * @author 6a209
 * Mar 16, 2013
 */
public class DBPhotoData extends DBBaseData{
	@SerializedName("id")
	public String mId;
	@SerializedName("alt")
	public String mAlt;
	@SerializedName("album_id")
	public String mAlbumId;
	@SerializedName("album_title")
	public String mAlbumTitle;
	/*大图*/
	@SerializedName("image")
	public String mImage;
	/*小图*/
	@SerializedName("thumb")
	public String mThumb;
	@SerializedName("cover")
	public String mCover;
	@SerializedName("desc")
	public String mDesc;
	@SerializedName("created")
	public String mCreated;
	@SerializedName("privacy")
	public String mPrivacy;
	@SerializedName("position")
	public String mPosition;
	/*前一张图的id*/
	@SerializedName("prev_photo")
	public String mPrevPhoto;
	@SerializedName("next_photo")
	public String mNextPhoto;
	@SerializedName("liked_count")
	public int mLikeCount;
	@SerializedName("recs_count")
	public int mRecsCount;
	@SerializedName("comments_count")
	public int mCommentCount;
	@SerializedName("author")
	public DBUser mAuthor;
	/*当前登陆用户是否喜欢*/
	@SerializedName("liked")
	public boolean mIsLiked;
	@SerializedName("sizes")
	public Sizes mSizes;
	
	public static class Sizes{
		@SerializedName("icon")
		public int[] mIcon;
		@SerializedName("thumb")
		public int[] mThumb;
		@SerializedName("conver")
		public int[] mCover;
		@SerializedName("image")
		public int[] mImage;
	}
}