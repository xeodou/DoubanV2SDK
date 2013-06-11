package com.douban.data;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;


/**
 * 豆瓣广播的time line
 * @author 6a209
 * 6:55:33 PM Jan 6, 2013
 */
public class DBBroadcastTimeLineData{
	
	public ArrayList<BoradcastData> mBoradcastDatas;
	
	public static class BoradcastData{
		@SerializedName("category")
		public String mCategory;
		@SerializedName("reshared_count")
		public int mResharedCount;
		@SerializedName("attachments")
		public Attachments mAttachments;
		@SerializedName("text")
		public String mText;
		@SerializedName("created_at")
		public String mCreated;
		@SerializedName("title")
		public String mTitle;
		@SerializedName("can_reply")
		public int mCanReply;
		// source 
		@SerializedName("like_count")
		public int mLikeCount;
		@SerializedName("comment_count")
		public int mCommentCount;
		@SerializedName("user")
		public DBUserData mUser;
		@SerializedName("is_follow")
		public boolean mIsFollow;
		@SerializedName("has_photo")
		public boolean mHasPhoto;
		@SerializedName("reshared_status")
		public BoradcastData mRootBoradcast;
		@SerializedName("type")
		public String mType;
		@SerializedName("id")
		public int mId;
	}
	
	//将被废弃的东西~~~
	public static class Attachments{
		public ArrayList<Attachment> mAttachments;
	}
	
	public static class Attachment{
		@SerializedName("description")
		public String mDescription;
		@SerializedName("title")
		public String mTitle;
//		@SerializedName("media")
//		public 
		@SerializedName("expaned_href")
		public String mExpanedHref;
		@SerializedName("caption")
		public String mCaption;
		@SerializedName("href")
		public String mHref;
		@SerializedName("type")
		public String mType;
//		@SerializedName("properties")
//		public
	}
	
	public static class Entities{
		//有三个数组不过目前全是空的, 不知道里面是神马~~~
//		@SerializedName
		
	}
	
	
	
}

