package com.bubble.shop.service;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import com.bubble.shop.model.Bean;

public class FileUp {

	public String fileUpload(Bean bean, HttpServletRequest request, String folder_name)
	{
		
		String folder="/resources/" + folder_name;
		//String path = request.getRealPath(folder);

		//String path = "c:\\sts\\b_shop\\src\\main\\webapp" + folder;
		String path = "/Users/hongdavid/Documents/workspace-sts-3.5.0.RELEASE/b_shop/src/main/webapp" + folder;
		
		String filename = path + "/" + bean.getUpfile().getOriginalFilename();
		bean.setOri_upfile(bean.getUpfile().getOriginalFilename());
		
		File file = new File(filename);

		String ext = filename.substring(filename.lastIndexOf(".") + 1);
	    
		if(file.exists())
	    {
	    	String fname = filename.substring(0, filename.lastIndexOf("."));
	    	filename = fname + "_1." + ext;
	    }
	    
	    file = new File(filename);
	    
	    while(true)
	    {
	    	if(file.exists())
	    	{
	    		String fname = filename.substring(0, filename.lastIndexOf("_") + 1);
	    		int num = Integer.parseInt(filename.substring(filename.lastIndexOf("_") + 1, filename.lastIndexOf(".")));
	    		num++;
	    		filename = fname + num + "." + ext;
	    		file = new File(filename);
	    	}
	    	else
	    	{
	    		break;
	    	}
	    }
		
		try
		{
			byte[] byteArr = bean.getUpfile().getBytes();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(byteArr);
			fos.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file.getName();
	}
	
	
	// 박병길 - 이벤트 게시판 전용
	public String fileUpload_Event(Bean bean, HttpServletRequest request, String folder_name)
	{
		
		System.out.println("fileUpload_Event : "+bean.getUpfile2().getOriginalFilename());
		String folder="/resources/" + folder_name;
		//String path = request.getRealPath(folder);

		//String path = "c:\\sts\\b_shop\\src\\main\\webapp" + folder;
		String path = "c:\\sts\\b_shop\\src\\main\\webapp" + folder;
		
		String filename = path + "/" + bean.getUpfile2().getOriginalFilename();
		//bean.setOri_upfile(bean.getUpfile2().getOriginalFilename());
		
		
		System.out.println("filename최초 : "+filename);
		File file = new File(filename);

		String ext = filename.substring(filename.lastIndexOf(".") + 1);
	    
	    String fname = filename.substring(0, filename.lastIndexOf("."));
	   
	    //filename = fname + "_1." + ext;
	    filename = "de_" + bean.getNotice_upfile();
	    
	    file = new File(filename);
	    System.out.println("filename : "+ filename);
		try
		{
			byte[] byteArr = bean.getUpfile2().getBytes();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(byteArr);
			fos.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("두번째파일업 끝");
		return file.getName();
	}
	
}
