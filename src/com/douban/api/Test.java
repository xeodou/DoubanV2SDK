//package com.douban.api;
//
//import java.io.IOException;
//
//import com.douban.data.DoubanUserData;
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//public class Test{
//	ObjectMapper mapper = new ObjectMapper();
//	
//	public void testJson(String str){
//		try {
//			mapper.readValue(str, DoubanUserData.class);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}