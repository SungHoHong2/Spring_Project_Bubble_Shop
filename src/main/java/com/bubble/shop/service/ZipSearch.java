package com.bubble.shop.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.bubble.shop.model.Bean;


public class ZipSearch {
	
	public Object searchList(Bean bean)//Bean bean, String zipWord
	{
		
		System.out.println("zipSearch 클래스 들어옴");
		 String apiurl = "http://biz.epost.go.kr/KpostPortal/openapi?regkey=ae1439dfd60b77fee1390396064742&target=post&query=";
		 
		  HttpURLConnection conn = null;
		     try{
		       String add =bean.getZipWord();//검색어 가져옴
		      System.out.println("add : " + bean.getZipWord());
		       
		       apiurl += URLEncoder.encode(add,"EUC-KR");
		      
		      URL url = new URL(apiurl);
		      conn = (HttpURLConnection) url.openConnection();
		      conn.setRequestProperty("accept-language","ko");
		      SAXBuilder builder = new SAXBuilder();
		      Document doc= builder.build(conn.getInputStream());
		      Element itemlist = doc.getRootElement().getChild("itemlist");
		      List list = itemlist.getChildren();
		      ArrayList<String> addList = new ArrayList();
		      ArrayList<String> postList = new ArrayList();
		      
		      
		    for(int i=0; i<list.size();i++){
		       Element item = (Element)list.get(i);
		       
		       String address = item.getChildText("address");
		       String postcd = item.getChildText("postcd");
		       
		       bean.setData(addList.add(address));
		       postList.add(postcd);
		       
//		       System.out.println(address);
//		       System.out.println(postcd);
		       
		      } 
		      
		     }catch(Exception e){
//		       System.out.println("{data:'error' }");
//		      e.printStackTrace();
		     }finally{
		      try{ if(conn != null) conn.disconnect(); } catch(Exception e){}
		     }
		     
		return bean;
	}
}
