package com.bubble.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.bubble.shop.model.Bean;
import com.bubble.shop.service.FileDelete;
import com.bubble.shop.service.FileUp;
import com.bubble.shop.service.ServiceRepository;


@Controller()
public class NoticeController {

	public Object data(String sub, String service, ServiceRepository repository, Bean bean, HttpServletRequest request, HttpSession session)
	{
		System.out.println(">>>  service : " + service);
		Object res	= bean;
		
		if(session.getAttribute("session_rate").equals(10))
		{
			bean.setNotice_pw("1111");
		}

		switch(service)
		{
			case "list" :
				res = repository.noticeList(bean);
				//repository.searchList(bean);
				break;
			
			case "detail" :
				if(bean.getBbl_id() == 6 && bean.getBs_id()!= null)
				{
					res = repository.eventchk(bean);
					
					if( ((Bean)res).getData() != null)
					{
						bean.setMsg("Y");
					}
					else
					{
						bean.setMsg("N");
					}
				}
				res = repository.noticeDetail(bean,service);
				
				break;
			
			case "writeOk":
				/*if(bean.getBs_id()==null)
				{
					bean.setBs_id(0);
				}*/
				if(bean.getUpfile()!=null)
				{
					if(bean.getUpfile().getOriginalFilename() != null && !bean.getUpfile().getOriginalFilename().equals(""))
					{
					
						bean.setNotice_user_upfile(bean.getUpfile().getOriginalFilename());   // 박병길.jpg
						bean.setNotice_upfile(new FileUp().fileUpload(bean, request, "upfile"));  // 박병길_1.jpg
						
						if(bean.getBbl_id() == 6)
						{
							System.out.println("두번째파일 fileup 하기전");
							bean.setNotice_banner_upfile(new FileUp().fileUpload(bean, request, "upfile"));
						}
						System.out.println("업로드 파일명 : "+ bean.getUpfile().getOriginalFilename() );
						System.out.println("Write 우리저장된 파일 명 : "+ bean.getNotice_upfile() );
					}
				}

				res = repository.noticeWrite(bean);
				
				break;
			
			case "pwChk":
				
				if(session.getAttribute("session_rate").equals(10))
				{System.out.println("pwCHK탐 session: " + session.getAttribute("session_rate"));
					res = repository.noticepwChk(bean, "pwChkOk", request, session);
					if(bean.getNotice_md().equals("modify") && bean.isNotice_pw_chk())
						bean.setUrl(sub + "/" + "modify");
				}
				break;
			case "pwChkOk":
				System.out.println("pwChkOK탐");
				res = repository.noticepwChk(bean,service,request, session);
				
				if(bean.getNotice_md().equals("modify") && bean.isNotice_pw_chk())
					bean.setUrl(sub + "/" + "modify");
				
				break;
			
			case "modifyOk":
				
				
					if(bean.getUpfile()!=null)
					{
						if(bean.getUpfile().getOriginalFilename() != null && !bean.getUpfile().getOriginalFilename().equals(""))
						{
							bean.setNotice_user_upfile(bean.getUpfile().getOriginalFilename());   // 박병길.jpg
							bean.setNotice_upfile(new FileUp().fileUpload(bean, request, "upfile"));  // 박병길_1.jpg
							
							System.out.println("업로드 파일명 : "+ bean.getUpfile().getOriginalFilename() );
							System.out.println("수정 우리저장된 파일 명 : "+ bean.getNotice_upfile() );
							System.out.println("------가져오기 유저"+bean.getNotice_user_upfile()+"\n 업파일 : "+ bean.getNotice_upfile());
						}
					}
				
				res = repository.modifyOk(bean);
				break;
			
			case "reply":
				res = repository.noticeDetail(bean,service);
				break;
			
			case "replyOk":
				if(bean.getUpfile()!=null)
				{
				
					if(!bean.getUpfile().getOriginalFilename().equals(""))
					{	
						if(bean.getUpfile().getOriginalFilename() != null || !bean.getUpfile().getOriginalFilename().equals("") || !bean.getUpfile().getOriginalFilename().equals("null"))
						{
							bean.setNotice_user_upfile(bean.getUpfile().getOriginalFilename());   // 박병길.jpg
							bean.setNotice_upfile(new FileUp().fileUpload(bean, request, "upfile"));  // 박병길_1.jpg
							
							System.out.println("업로드 파일명 : "+ bean.getUpfile().getOriginalFilename() );
							System.out.println("수정 우리저장된 파일 명 : "+ bean.getNotice_upfile() );
							System.out.println("------가져오기 유저"+bean.getNotice_user_upfile()+"\n 업파일 : "+ bean.getNotice_upfile());
						}
					}
				}
				res = repository.noticereply(bean);
				break;
				
			case "fileDelete":
				bean.setNotice_upfile(request.getParameter("notice_upfile"));
				
				if(bean.getNotice_upfile()!=null || !bean.getNotice_upfile().equals(""))
				{
					if(new FileDelete().fileDelete(bean))
					{
						res = repository.upfile_delete(bean);
						bean.setNotice_upfile(null);
						bean.setNotice_user_upfile(null);
					}
					
				}
				bean.setUrl(sub + "/" + "modify");
				break;

			case "event":					
				System.out.println("서브 event탐");
				res = repository.event(bean);
				break;
				
		}

		return res;
	}
	
	
	
}
