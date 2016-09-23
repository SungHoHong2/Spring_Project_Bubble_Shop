package com.bubble.shop;

import java.util.Calendar;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bubble.shop.model.Bean;
import com.bubble.shop.model.Form_Data;
import com.bubble.shop.service.ServiceRepository;

@Controller
@RequestMapping("/bs/{main}/{sub}/{service}")
public class MainController {

	@Autowired
	ServiceRepository repository;
	
	@Autowired
	NoticeController notice;
	
	@Autowired 
	AdminController admin;
	
	@Autowired
	GoodsController shop;
	
	@Autowired
	MemberController member;
	
	@Autowired
	BuyController buy;
	
	@ModelAttribute("bean")
	public Object data(@PathVariable("main") String main, @PathVariable("sub") String sub,
			@PathVariable("service") String service, Bean bean, Form_Data fd,
			HttpServletRequest request, HttpSession session, HttpServletResponse response)
	{
		// 시스템 날짜
		Calendar sys_calendar = Calendar.getInstance();
		
		bean.setSysYear(sys_calendar.get(Calendar.YEAR));
		bean.setSysMonth(sys_calendar.get(Calendar.MONTH) + 1);
		bean.setSysDay(sys_calendar.get(Calendar.DATE));
		
		if (session.getAttribute("session_rate") == null)
		{
			session.setAttribute("session_bsid", "");
			session.setAttribute("session_userid", "");
			session.setAttribute("session_name", "");
			session.setAttribute("session_rate", "");
		}
		else
		{
			if (!session.getAttribute("session_rate").equals(""))
			{
				// 로그인 상태라면 맴버테이블 변수에 세션데이터를 넣어준다.
				bean.setBs_id((Integer)session.getAttribute("session_bsid"));
				bean.setBs_userid((String)session.getAttribute("session_userid"));
				bean.setBs_name((String)session.getAttribute("session_name"));
				bean.setBs_rate((Integer)session.getAttribute("session_rate"));
			}
		}
		
		Object res = null;
		repository.get_menu(bean);
		System.out.println("URL 디버깅 >> main : " + main + "   sub : " + sub + "   service : " + service);
		bean.setUrl(sub + "/" + service);
		
		if (service.equals("search_ajax"))
		{
			// 통합검색
			res = repository.search_ajax(bean);
			bean.setRedirect(true);
			bean.setUrl("bs/user/include/" + service);
		}
		else if (service.equals("login"))
		{
			if ((!bean.getBs_userid().equals("")) && (!bean.getBs_pwd().equals("")))
			{
				// 로그인
				res = repository.bs_login(bean);

				if (((Bean)res).getMsg().equals("Y"))
				{
					// 로그인 성공
					session.setAttribute("session_bsid", ((Bean)((Bean)res).getData()).getBs_id());
					session.setAttribute("session_userid", ((Bean)((Bean)res).getData()).getBs_userid());
					session.setAttribute("session_name", ((Bean)((Bean)res).getData()).getBs_name());
					session.setAttribute("session_rate", ((Bean)((Bean)res).getData()).getBs_rate());
					
					bean.setRedirect(true);
					bean.setUrl("redirect:/bs/user/shop/main");
					
					if (((Bean)((Bean)res).getData()).getBs_rate() == 10)
					{
						// 관리자
						bean.setRedirect(true);
						bean.setUrl("redirect:/bs/admin/goods/reg_main");
					}
				}
				else
				{
					// 로그인 실패
					bean.setMsg("아이디 또는 비밀번호가 일치 하지 않습니다!");
					bean.setUrl(sub + "/login");
				}
			}
			else
			{
				if (session.getAttribute("session_rate") != "")
				{
					// 로그인 상태인데 로그인 페이지에 왔다면
					//bean.setRedirect(true);
					//bean.setUrl("redirect:/bs/user/shop/main");
				}
			}
		}
		else if (service.equals("logout"))
		{
			bean.setMsg("로그아웃 되었습니다!");
			bean.setRedirect(true);
			bean.setUrl("redirect:/bs/user/shop/main");
			session.setAttribute("session_bsid", "");
			session.setAttribute("session_userid", "");
			session.setAttribute("session_name", "");
			session.setAttribute("session_rate", "");
		}
		else if (service.equals("zipcode_sch2"))
		{
			bean.setRedirect(true);
			bean.setUrl("bs/user/include/zipcode_sch2");
		}
		else
		{
			switch(sub)
			{
				case "goods" : 
					res = admin.data(service, repository, bean, request,fd);
					break;	
					
				case "admin_purchase" :
					res = admin.data(service, repository, bean, request,fd);
					break;
				
				case "admin_member" :
					res=admin.data(service, repository, bean, request, fd);
					break;
					
				case "admin_modify" : 
					res=admin.data(service, repository, bean, request, fd);
				    break;
					
				case "notice" :
					bean.setBbl_id(0);
					res = notice.data(sub, service, repository, bean, request, session);
					break;
					
				case "faq" :
					bean.setBbl_id(2);
					res = notice.data(sub, service, repository, bean, request, session);
					break;
				case "qna" :
					bean.setBbl_id(4);
					res = notice.data(sub, service, repository, bean, request, session);
					break;
				case "comment":
					bean.setBbl_id(5);
					res = notice.data(sub, service, repository, bean, request, session);
					break;
				case "event":
					System.out.println("메인 이벤트 탐");
					bean.setBbl_id(6);
					res = notice.data(sub, service, repository, bean, request, session);
					break;
				case "member" :
					res = member.data(service, repository, bean, request, fd, session);
					break;

				case "shop" :

					res=shop.data(service, repository, bean, request, response);

					if(session.getAttribute("session_bsid")!=null)
					{
						//res=shop.data(service, repository, bean, request, session);
					}
					else
					{
						bean.setUrl("/bs/user/shop/goodsdetail?g_code="+bean.getG_code());
					}

					break;
				
				case "buy" :

					//System.out.println("상품 코드 : " + bean.getG_code());


					res = buy.data(service, repository, bean, request, session);

					break;
					
				default :
					
					break;
			}
		}

		return res;

	}
	
	@RequestMapping()
	public String list(@PathVariable("main") String main, Bean bean)
	{
		//System.out.println("페이지 이동 디버깅 >>> Redirect : " + bean.isRedirect() + "   URL : " + bean.getUrl());
		
		if (bean.isRedirect())
		{
			return bean.getUrl();
		}
		
		return "bs/" + main + "/template";
	}
	
}