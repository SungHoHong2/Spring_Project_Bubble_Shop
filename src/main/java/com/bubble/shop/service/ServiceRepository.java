package com.bubble.shop.service;


import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bubble.shop.model.Bean;
import com.bubble.shop.model.Form_Data;

@Service
public class ServiceRepository {

	@Autowired
	SqlSessionTemplate SqlSessionTemplate;
	
	@Autowired
	JavaMailSender mailSender;
	
	public Object refunds()
	{
		return SqlSessionTemplate.selectList("mapper.refunds");
	}
	
	public Object purchase_finished_total(Bean bean)
	{
		return SqlSessionTemplate.selectOne("mapper.purchase_finished_total",bean);
	}
	
	
	public Object purchase_finished_loop(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.purchase_finished_loop",bean);
	}
	
	
	public Object admin_purchase_finished()
	{
		return SqlSessionTemplate.selectList("mapper.admin_purchase_finished");
	}
	
	
	public Object search_ajax(Bean bean)
	{
		bean.setData(SqlSessionTemplate.selectList("mapper.hw_ajax2", bean));
		bean.setData2(SqlSessionTemplate.selectList("mapper.hw_ajax3", bean));
		System.out.println(bean.getData() + "//" + bean.getData2());
		return bean;
	}
	
		//민 추가
		public Object getSearchRes(Bean bean){
			bean.setBestitem(SqlSessionTemplate.selectList("mapper.searchGoods", bean));
			
			System.out.println("찾을 것!!"+bean.getSrch_value());
			
			bean.setEventList(SqlSessionTemplate.selectList("mapper.searchEvent", bean));
			
			return bean;
		}

	/*	public void searchList(bean)

	{
		new ZipSearch().searchList(bean);
	}*/
	
	
	/*이벤트 참여하기*/
	public Object event(Bean bean)
	{ 
		bean.setMsg("N");
		
		bean.setData(SqlSessionTemplate.selectOne("mapper.eventselect",bean));
		
		if(bean.getData()==null)
		{
			
			SqlSessionTemplate.insert("mapper.eventinsert",bean);
			bean.setMsg("Y");
		}
		
		bean.setData(SqlSessionTemplate.selectOne("mapper.noticedetail",bean));
		
		bean.setUrl("event/detail");
		
		return bean;
	}
	
	public Object eventchk(Bean bean)
	{
		bean.setData(SqlSessionTemplate.selectOne("mapper.eventchk",bean));
				
		return bean;
	}
	
	/*리스트*/
	public Object noticeList(Bean bean)
	{
		
		bean.setTotal((Integer)(SqlSessionTemplate.selectOne("mapper.total",bean)));
		
		bean.setTotalPage(bean.getTotal()/bean.getLimit());

		if(bean.getTotal()%bean.getLimit()!=0)
			bean.setTotalPage(bean.getTotalPage()+1);
		
		bean.setStartPage((bean.getPage()-1)/bean.getPageLimit()*bean.getPageLimit()+1);
		
		bean.setEndPage(bean.getStartPage()+bean.getPageLimit()-1);
		
		if(bean.getEndPage()>bean.getTotalPage())
			bean.setEndPage(bean.getTotalPage());
		
		bean.setStart((bean.getPage()-1) * bean.getLimit() + 1);
		bean.setEnd(bean.getStart() + bean.getLimit() - 1);
		

		
		bean.setData(SqlSessionTemplate.selectList("mapper.noticelist", bean));

		
		return bean;
	}
	
	/*상세글*/
	public Object noticeDetail(Bean bean, String service)
	{
		if(service.equals("detail"))
		{
			bean.setNotice_cnt((Integer)(SqlSessionTemplate.update("mapper.notice_cnt",bean)));
		}
		bean.setData(SqlSessionTemplate.selectOne("mapper.noticedetail",bean));
		
		
		
		return bean;
	}
	
	
	/*글쓰기*/
	public Object noticeWrite(Bean bean)
	{		
		
		System.out.println("비회원 전 bs_id : "+bean.getBs_id());
		if(bean.getBs_id()==null)
		{
			bean.setBs_id(0);
			System.out.println("비회원 후 bs_id : "+bean.getBs_id());
		}
		bean.setData(SqlSessionTemplate.insert("mapper.noticewrite",bean));
		
		bean.setRedirect(true);
		
		bean.setUrl("redirect:detail?notice_id="+(Integer)bean.getNotice_id()+"&page="+bean.getPage());
		
		
		return bean;
	}
	
	
	/* 비밀번호 체크*/
	public Object noticepwChk(Bean bean,String service, HttpServletRequest request, HttpSession session)
	{
		/*System.out.println("notice_id : "+bean.getNotice_id()+"\n"
				+ ""+"notice_gid:"+bean.getNotice_gid()+"\n"+"bbl_id:"+bean.getBbl_id()+"\n"+"notice_seq:"+bean.getNotice_seq()+"\n"
						+ "notice_rev : "+bean.getNotice_rev()+"\n"+"notice_cnt : "+bean.getNotice_cnt()+"\n"+"notice_reg_date"+bean.getNotice_reg_date()+"\n"
						+"notice_mod_date : " + bean.getNotice_mod_date()+"\n"+"notice_title : " + bean.getNotice_title()+"\n"+"bs_id : " +bean.getBs_id()+"\n"
						+"notice_pw : " + bean.getNotice_pw() +"\n"+"notice_content : "+bean.getNotice_content()+"\n"+ "notice_upfile : " + bean.getNotice_upfile()+"\n"
						+"notice_yn : " +bean.getNotice_yn()+"\n" + "notice_user_upfile : " + bean.getNotice_user_upfile());*/
		
		if(SqlSessionTemplate.selectOne("mapper.noticepwchk",bean)!=null || session.getAttribute("session_rate").equals(10))
		{	
			bean.setMsg("Y");
			
			bean.setNotice_pw_chk(true);
			
			 /*글삭제*/ 
			if(bean.getNotice_md().equals("delete"))
			{
				
				/*첨부파일삭제*/
				bean.setData(SqlSessionTemplate.selectOne("mapper.noticedetail",bean));
				
				bean.setNotice_upfile(((Bean)bean.getData()).getNotice_upfile());
			
				if(bean.getNotice_upfile()!=null || !bean.getNotice_upfile().equals(""))
				{
					if(new FileDelete().fileDelete(bean))
					{
						upfile_delete(bean);
						bean.setNotice_upfile(null);
						bean.setNotice_user_upfile(null);
					}
				}
				
				SqlSessionTemplate.delete("mapper.noticedelete",bean);
				
				bean.setRedirect(true);
				
				bean.setUrl("redirect:list");
			}
			
			 /*글수정*/ 
			if(bean.getNotice_md().equals("modify"))
			{
				bean.setData(SqlSessionTemplate.selectOne("mapper.noticedetail",bean));
			}
		}
		else
		{	bean.setMsg("N");
		
			bean.setNotice_id(bean.getNotice_id());
			
			bean.setNotice_md(bean.getNotice_md());
			
			bean.setUrl("qna/pwChk");
			
		}
		
		return bean;
	}
	
	/*글수정완료*/
	public Object modifyOk(Bean bean)
	{
		
		System.out.println("글수정 완료 진입");
		if(bean.getUpfile()!=null && !bean.getUpfile().equals("") && !bean.getUpfile().equals(null) && !bean.getUpfile().equals("null"))
		{
			System.out.println("파일있다 업데이트 전");
			SqlSessionTemplate.update("mapper.noticemodifyok_file",bean);
			System.out.println("파일있다 업데이트 후");
		}
		else
		{
			System.out.println("파일없다 업데이트 전");
			SqlSessionTemplate.update("mapper.noticemodifyok",bean);
			System.out.println("파일없다 업데이트 후");
		}
		
		
		bean.setRedirect(true);
		
		bean.setUrl("redirect:detail?notice_id="+(Integer)bean.getNotice_id());
		
		return bean;
	}
	/* 답글 */
	public Object noticereply(Bean bean)
	{
		
		SqlSessionTemplate.selectOne("mapper.noticereply_up",bean);
		
		bean.setData(SqlSessionTemplate.selectOne("mapper.noticereply_write",bean));
		
		bean.setNotice_id(((Bean)SqlSessionTemplate.selectOne("mapper.notice_id_max_select")).getNotice_id());
		
		bean.setRedirect(true);
		
		bean.setUrl("redirect:detail?notice_id="+(Integer)bean.getNotice_id());
		
		return bean;
	}
	/* 첨부 삭제*/
	public Object upfile_delete(Bean bean)
	{
		SqlSessionTemplate.update("mapper.upfile_delete",bean);
		
		return bean;
	}
	
	public Object userid_chk(Bean bean)
	{
		if (SqlSessionTemplate.selectOne("mapper.userid_chk", bean) != null)
		{
			bean.setMsg("N");
		}
		else
		{
			bean.setMsg("Y");
		}

		return bean;
	}
	
	
	public Object bs_join(Bean bean)
	{
		//System.out.println(bean.getBs_name() + "//" + bean.getBs_userid() + "//" + bean.getBs_pwd() + "//" + bean.getBs_hp() + "//" + bean.getBs_sms_yn() + "//" + bean.getBs_email() + "//" + bean.getBs_email_yn() + "//" + bean.getBs_sex());

		SqlSessionTemplate.insert("mapper.bs_join",bean);
		
		//System.out.println(bean.getBs_name() + "//" + bean.getBs_userid() + "//" + bean.getBs_pwd() + "//" + bean.getBs_hp() + "//" + bean.getBs_sms_yn() + "//" + bean.getBs_email() + "//" + bean.getBs_email_yn() + "//" + bean.getBs_sex());
		
		bean.setData(SqlSessionTemplate.selectOne("mapper.bs_login", bean));
		bean.setMsg("Y");
		
		return bean;
	}
	
	public Object getBankList(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.getBankList",bean);
	}
	
	public Object mem_update(Bean bean)
	{
		//이메일, 핸드폰, sms,         zip
		/*System.out.println("디버깅 : " + bean.getBs_pwd() + "//" + bean.getBs_email() + "//" + bean.getBs_hp() + "//"+
				bean.getBs_sms_yn() + "//" + bean.getBs_email_yn() + "//" + bean.getBs_zip() +
				bean.getBs_address() + "//" + bean.getBs_address2() + "//" + bean.getBs_id()				
				);*/
		SqlSessionTemplate.update("mapper.mem_update",bean);
		return bean;
	}
	
	
	public Object test_list(Bean bean, Form_Data fd)
	{		
		System.out.println("ccccc");
		System.out.println(fd.getList());
		
		String res = "", res2 = "";
		
		if (fd.getList() != null)
		{
			
			// 데이터 있을때
			System.out.println("데이터 있다!~");
			for (int i = 0; i < fd.getList().size(); i++)
			{
				res += fd.getList().get(i).getTitle();
				res2 += fd.getList().get(i).getContent();
			}
			
			System.out.println(res);
			System.out.println(res2);
		}
		else
		{
			// 없을때
			System.out.println("데이터 없다!~");
		}
	//	System.out.println(fd.getList().size());
		//bean.setData(SqlSessionTemplate.insert("mapper.noticewrite",bean));
		
		return bean;
	}


	//start [민경훈]
	public Object shopHome(Bean bean){
		
		bean.setData(SqlSessionTemplate.selectList("mapper.getVisualImg", bean));
		bean.setEventList(SqlSessionTemplate.selectList("mapper.getFrontEvent", bean));
		bean.setBestitem(SqlSessionTemplate.selectList("mapper.getBestItem", bean));
		return bean;
	}
	public Object getGoodsList(Bean bean){
		
		if(bean.getBm_depth()==1){
			
			
			bean.setTotal((Integer)(SqlSessionTemplate.selectOne("mapper.getCntGoods1",bean)));
			
			bean.setTotalPage(bean.getTotal()/bean.getLimitItem());

			if(bean.getTotal()%bean.getLimitItem()!=0)
				bean.setTotalPage(bean.getTotalPage()+1);
			
			bean.setStartPage((bean.getPage()-1)/bean.getPageLimit()*bean.getPageLimit()+1);
			
			bean.setEndPage(bean.getStartPage()+bean.getPageLimit()-1);
			
			if(bean.getEndPage()>bean.getTotalPage())
				bean.setEndPage(bean.getTotalPage());
			bean.setStart((bean.getPage()-1) * bean.getLimitItem() + 1);
			bean.setEnd(bean.getStart() + bean.getLimitItem() - 1);
			
			System.out.println(bean.getStart()+ " : "+bean.getEnd()+" : "+bean.getPage());
			
			bean.setBestitem(SqlSessionTemplate.selectList("mapper.getGoodsItem1", bean));
		}else if(bean.getBm_depth()==2){
			System.out.println("bm_id : "+bean.getBm_id()+" depth : "+bean.getBm_depth());
			bean.setTotal((Integer)(SqlSessionTemplate.selectOne("mapper.getCntGoods2",bean)));
			System.out.println("2depth : "+bean.getTotal());
			
			bean.setTotalPage(bean.getTotal()/bean.getLimitItem());

			if(bean.getTotal()%bean.getLimitItem()!=0)
				bean.setTotalPage(bean.getTotalPage()+1);
			
			bean.setStartPage((bean.getPage()-1)/bean.getPageLimit()*bean.getPageLimit()+1);
			
			bean.setEndPage(bean.getStartPage()+bean.getPageLimit()-1);
			
			if(bean.getEndPage()>bean.getTotalPage())
				bean.setEndPage(bean.getTotalPage());
			bean.setStart((bean.getPage()-1) * bean.getLimitItem() + 1);
			bean.setEnd(bean.getStart() + bean.getLimitItem() - 1);
			
			System.out.println(bean.getStart()+ " : "+bean.getEnd()+" : "+bean.getPage());
			
			
			bean.setBestitem(SqlSessionTemplate.selectList("mapper.getGoodsItem2", bean));
		}
		return bean;
	}
	
	
	
	
	public Object getGoodsDetail( HttpServletRequest request, HttpServletResponse response, Bean bean){
		bean.setBestitem(SqlSessionTemplate.selectList("mapper.getGoodsDetail", bean));
		
		String g_code = Integer.toString((((ArrayList<Bean>)bean.getBestitem()).get(0)).getG_code()); 
		String g_img=(((ArrayList<Bean>)bean.getBestitem()).get(0)).getG_imglist();
		Integer g_price=((Bean)((ArrayList)bean.getBestitem()).get(0)).getG_pricedis();
		if((((ArrayList<Bean>)bean.getBestitem()).get(0)).getG_pricedis()==null){
			g_price=(((ArrayList<Bean>)bean.getBestitem()).get(0)).getG_price();
		}
		String des=(((ArrayList<Bean>)bean.getBestitem()).get(0)).getG_describe();
		
		
		// 품절임박 및 품절상품 있는지 확인 - 전문현 추가 (2014-06-01)
		bean.setGoods_data(SqlSessionTemplate.selectList("mapper.goods_item_cnt", bean));
		
		if (((ArrayList)bean.getGoods_data()).size() > 0)
		{
			bean.setMin_bgd_cnt(((ArrayList<Bean>)bean.getGoods_data()).get(0).getMin_bgd_cnt());
			bean.setSum_bgd_cnt(((ArrayList<Bean>)bean.getGoods_data()).get(0).getSum_bgd_cnt());
		}
		//System.out.println("전문현 >>" + bean.getG_code() + "//" + ((Bean)bean.getGoods_data()). .getMin_cnt());
		
		boolean chk=false;
		Cookie[] cooArr = request.getCookies();
		for (Cookie coo: cooArr) {
			if(coo.getName().equals(g_code)) {
				chk=true;
				break;
			}
		}
		if(!chk){
			String value=g_code+"/"+g_img+"/"+g_price+"/"+des;
			try {
				value=URLEncoder.encode(value,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cookie cookie = new Cookie(g_code,value);
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
			System.out.println("cookie 삽입!!");
		}
		return bean;
	}
	
	public Object getMyCoupon(Bean bean, HttpSession session){
		Integer userid=(Integer)session.getAttribute("session_bsid");
		System.out.println("접속자 아이디 : "+userid);
		if(userid!=null){
			bean.setBs_id(userid);
			bean.setCoupon(SqlSessionTemplate.selectList("mapper.getMyCoupon", bean));
		}
		
		
		return bean;
	}
	
	//end [민경훈]
	

//Admin Repository [홍성호]
	
	
	public Object inputAdminTest(Bean bean)
	{
			SqlSessionTemplate.insert("mapper.inputadmintest",bean);
			
			return null;
	}
	
	public Object reglist(Bean bean)
	{		
		return SqlSessionTemplate.selectList("mapper.reglist",bean);	
	}
	
	public Object display_product()
	{
		return SqlSessionTemplate.selectList("mapper.display_product");	
	}
	
	public Object regdetail(Bean bean)
	{
		return SqlSessionTemplate.selectOne("mapper.regdetail",bean);
	}
	
	public Object regdetail_purchase(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.regdetail_purchase",bean);
	}
	
	
	public Object getTotal()
	{
		return SqlSessionTemplate.selectOne("mapper.gettotal");
	}
	 	 
	public Object getShowTotal()
	{
		return SqlSessionTemplate.selectOne("mapper.getshowtotal");
	}
	
	public Object bs_goods_group(Bean bean, Form_Data fd, HttpServletRequest request)
	{
		 if (fd.getList() != null)
		  {
			 bean.setBm_id(fd.getList().get(0).getBm_id());
			 System.out.println("ddd : "+bean.getBm_id());
			 System.out.println("ddd : "+bean.getG_code());

			 SqlSessionTemplate.insert("mapper.bs_good_group",bean);
		  }
		 
		 
		return bean;

	}
	
	
	public Object reg_input(Bean bean, Form_Data fd, HttpServletRequest request)
	{		
		
		 if (fd.getList() != null)
		  {
		   
		   for (int i = 0; i < fd.getList().size(); i++)
		   {
			   //bean.setG_code((int)(Math.random()*999999));
			   bean.setG_name(fd.getList().get(i).getG_name());
			   bean.setG_num(fd.getList().get(i).getG_num());
			   bean.setG_price(fd.getList().get(i).getG_price());
			   bean.setG_describe(fd.getList().get(i).getG_describe());
			   bean.setBm_id(fd.getList().get(i).getBm_id());
			   
			   System.out.println("DD : "+bean.getG_name());
			   System.out.println("DD : "+bean.getG_num());
			   System.out.println("DD : "+bean.getG_price());
			   System.out.println("DD : "+bean.getG_describe());

			   System.out.println("DDBM_ID :"+bean.getBm_id());
			   
			   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
			   
			   
			   try {
				   		bean.setG_start_day(formatter.parse(fd.getList().get(i).getG_start_days()));
				   		bean.setG_end_day(formatter.parse(fd.getList().get(i).getG_end_days()));
				   		
						System.out.println("DD : "+bean.getG_start_days());
						System.out.println("DD : "+bean.getG_end_days());
			   
			   } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
			   
			   bean.setRename_g_imghotitem(fd.getList().get(i).getRename_g_imghotitem());
			   bean.setRename_g_imgshotitem(fd.getList().get(i).getRename_g_imgshotitem());
			   bean.setRename_g_imgdetail(fd.getList().get(i).getRename_g_imgdetail());
			   bean.setRename_g_imglist(fd.getList().get(i).getRename_g_imglist());
			   bean.setBm_id(fd.getList().get(i).getBm_id());
			   
			   System.out.println("DD : "+bean.getRename_g_imglist());
			   System.out.println("DD : "+bean.getRename_g_imgdetail());
			   System.out.println("DD : "+bean.getRename_g_imgshotitem());
			   System.out.println("DD : "+bean.getRename_g_imghotitem());

			   			   
			   SqlSessionTemplate.insert("mapper.reg_insert",bean);			   
		   }
		   System.out.println("reg_input Successful");
		  }
		
		return bean;
	}
	
	public Object bs_login(Bean bean)
	{
		bean.setData(SqlSessionTemplate.selectOne("mapper.bs_login", bean));

		if (bean.getData() != null)
		{
			bean.setMsg("Y");
		}
		else
		{
			bean.setMsg("N");
		}
		
		return bean;
	}
	

	public Object reg_findmenu()
	{
		return SqlSessionTemplate.selectList("mapper.reg_findmenu");
	}
	
	public Object reg_findmenu2(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.reg_findmenu2",bean);
	}
	
	public Object reg_inputMenu(Bean bean, Form_Data fd)
	{
		 if (fd.getList() != null)
		  {
		   for (int i = 0; i < fd.getList().size(); i++)
		   {
			   bean.setBm_par_id(fd.getList().get(i).getBm_par_id());
			   SqlSessionTemplate.insert("mapper.reg_insertmenu",bean);
		   }		   
		  }
		   return bean;
	}	 
	
	public Object showup(Bean bean)
	{
		
			String [] buffing = (String[]) bean.getBeanArray();
			if(buffing!=null)
			{
			
		    Integer[] buffer2 = new Integer[buffing.length];
		    
		    Integer input = 234;
			for(int i=0; i<buffing.length; i++)
			{
				buffer2[i]= Integer.parseInt(buffing[i]);
				
				System.out.println("Repository : "+buffer2[i]);
				input = buffer2[i];
				SqlSessionTemplate.update("mapper.reg_updateshow",input);	
			}
		}

			return bean;
	}
	
	public Object showdown(Bean bean)
	{
		    
			String [] buffing = (String[]) bean.getBeanArray();
			if(buffing!=null)
			{
			
		    Integer[] buffer2 = new Integer[buffing.length];
		    
		    Integer input = 234;
			for(int i=0; i<buffing.length; i++)
			{
				buffer2[i]= Integer.parseInt(buffing[i]);
				
				System.out.println("Repository : "+buffer2[i]);
				input = buffer2[i];
				SqlSessionTemplate.update("mapper.reg_updateshowdown",input);	
			}
			}

			return bean;
	}
	
	
	public Object reg_members(Bean bean)
	{
		System.out.println("reg_members on ");
		return SqlSessionTemplate.selectList("mapper.reg_members", bean);
	}
	
	public Object getMemberDetail(Bean bean)
	{
		return SqlSessionTemplate.selectOne("mapper.getmemberdetail", bean);
	}
	
	public Object reg_member_delete(Bean bean)
	{
		return SqlSessionTemplate.delete("mapper.reg_member_delete",bean);
	}

	public Object reg_member_input(Bean bean)
	{
		return SqlSessionTemplate.insert("mapper.reg_member_insert",bean);
	}
	
	public Object getMemTotal()
	{
		return SqlSessionTemplate.selectOne("mapper.reg_member_total");
	}
	
	public Object reg_member_update(Bean bean)
	{	
		return SqlSessionTemplate.update("mapper.reg_member_update", bean);
	}
	
	
	public Object getParticipantData(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.reg_participantdata",bean);
	}
	
	public Object getBasketData(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.getbasketdata",bean);
	}
	
	public Object getPurchaseData(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.getpurchasedata",bean);
	}
	
	public Object reg_list_delete(Bean bean)
	{
		return SqlSessionTemplate.delete("mapper.reg_list_delete",bean);
	}
	
	public Object reg_list_update(Bean bean)
	{
		System.out.println("update go");
	    return  SqlSessionTemplate.selectOne("mapper.reg_list_update",bean);	        
	}
	
	
	public Object reg_list_update_input(Bean bean, Form_Data fd, HttpServletRequest request)
	{	
		
		if(!bean.getG_start_days().equals("") || !bean.getG_end_days().equals(""))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	        	
			 try {
	        	 bean.setG_start_day(formatter.parse(bean.getG_start_days()));			
	        	 bean.setG_end_day(formatter.parse(bean.getG_end_days()));			
			 }catch(Exception e)
			 {}
			
		    if (fd.getList() != null)
			{
		    	bean.setUpfile(fd.getList().get(0).getG_imghotitems());
				bean.setRename_g_imghotitem(new FileUp().fileUpload(bean, request, "up_img"));

				bean.setUpfile(fd.getList().get(0).getG_imgshotitems());
				bean.setRename_g_imgshotitem(new FileUp().fileUpload(bean, request, "up_img"));
				
				bean.setUpfile(fd.getList().get(0).getG_imgdetails());
				bean.setRename_g_imgdetail(new FileUp().fileUpload(bean, request, "up_img"));

				bean.setUpfile(fd.getList().get(0).getG_imglists());
				bean.setRename_g_imglist(new FileUp().fileUpload(bean, request, "up_img"));	
				
				String bufferz = bean.getRename_g_imglist();
				
				System.out.println("belat : "+bean.getRename_g_imglist());
				
				if(bufferz.equals("up_img"))
				{						
					SqlSessionTemplate.update("mapper.reg_list_update_input2_small",bean);			
				}
				else
				{
					SqlSessionTemplate.update("mapper.reg_list_update_input2",bean);			
				}
				
			}			
		}
		else
		{
			   if (fd.getList() != null)
				{
			    	bean.setUpfile(fd.getList().get(0).getG_imghotitems());
					bean.setRename_g_imghotitem(new FileUp().fileUpload(bean, request, "up_img"));

					bean.setUpfile(fd.getList().get(0).getG_imgshotitems());
					bean.setRename_g_imgshotitem(new FileUp().fileUpload(bean, request, "up_img"));
					
					bean.setUpfile(fd.getList().get(0).getG_imgdetails());
					bean.setRename_g_imgdetail(new FileUp().fileUpload(bean, request, "up_img"));

					bean.setUpfile(fd.getList().get(0).getG_imglists());
					bean.setRename_g_imglist(new FileUp().fileUpload(bean, request, "up_img"));	
					
					
					String bufferz = bean.getRename_g_imglist();
					
					System.out.println("belat : "+bean.getRename_g_imglist());
					if(bufferz.equals("up_img"))
					{						
						SqlSessionTemplate.update("mapper.reg_list_update_input_small",bean);			
					}
					else
					{
						SqlSessionTemplate.update("mapper.reg_list_update_input",bean);			
					}
				}
			System.out.println("no date");
		}
		
		
	    if (fd.getList() != null)
			{
				for (int i = 0; i < fd.getList().size(); i++)
				{	
					if(i==0)
					{
						bean.setBgd_size("trash");
						bean.setBgd_cnt(9999);
						bean.setBgd_color("trash");
					}
					
					else
					{
						bean.setBgd_size(fd.getList().get(i).getBgd_size());
						bean.setBgd_cnt(fd.getList().get(i).getBgd_cnt());
						bean.setBgd_color(fd.getList().get(i).getBgd_color());
						SqlSessionTemplate.insert("mapper.bs_goods_detail",bean);
					}
				}
			}		
		return bean;
	}

	public Object distributeCoupons(Bean bean, Form_Data fd)
	{
		
		  if (fd.getList() != null)
		  {
			  String res = "", res2 = "";
			  bean.setBc_price(fd.getList().get(0).getBc_price());
			  
			  /*
			   * insert into bs_coupon(bc_id, bc_reg_date, bc_price, bs_id, bc_start_date, bc_end_date) 
		         values(<include refid="coupon_maxidz"/>, sysdate, #{bc_price }, #{bs_id}, #{bc_start_date}, #{bc_end_date})  
			   * 
			   */
			  
			  
			  System.out.println("dd"+bean.getBc_price());
			  
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			   try {
		        	 bean.setBc_start_date(formatter.parse(bean.getBc_start_date_before()));
		        	 bean.setBc_end_date(formatter.parse(bean.getBc_end_date_before()));
		    
					  System.out.println("dd"+bean.getBc_start_date_before());
					  System.out.println("dd"+bean.getBc_end_date_before());
		        	 
		         } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			  
  		    SqlSessionTemplate.insert("mapper.reg_coupon_distribute",bean);

		    System.out.println("bc_id : "+bean.getBc_id());
		    
		    //SqlSessionTemplate.insert();
		    
		    //insert into bs_my_coupon(bmc_id, bc_id, bs_id, bmc_status, bmc_reg_date)
		    
		   for (int i = 0; i < fd.getList().size(); i++)
		   {   
		    res += "coupons acheived : "+fd.getList().get(i).getBs_id()+"/s";
	        
			bean.setBs_id(fd.getList().get(i).getBs_id());
		    
			System.out.println("dd : "+bean.getBs_id());
			
			if(bean.getBs_id()!=0)
			SqlSessionTemplate.insert("mapper.reg_coupon_distribute2",bean);
		
		   }
		   /////
		   System.out.println("finish");
		  
		  }
		
		  return bean;
	}
	
	
	public Object getRandomApplicants(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.reg_randomgo",bean);
	}

	
	public Object admin_purchase_bq_total()
	{
		return SqlSessionTemplate.selectOne("mapper.admin_purchase_bq_total");
	}
	
	public Object admin_purchase_list()
	{
		return SqlSessionTemplate.selectList("mapper.admin_purchase_list");
	}
	
	public Object getBs_quick(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.getBs_quick", bean);
	}
	
	public Object getBs_purchaseGrant(Bean bean)
	{
		return SqlSessionTemplate.update("mapper.getBs_purchaseGrant",bean);
	}
	
	public Object getBS_purchaseWhole(Bean bean)
	{
		return SqlSessionTemplate.selectOne("mapper.getBS_purchaseWhole",bean);
	}
	
	public Object updatePurchase(Bean bean)
	{
		return SqlSessionTemplate.update("mapper.updatePurchase",bean);
	}
	
	public Object quitPurchase(Bean bean)
	{
		return SqlSessionTemplate.delete("mapper.quitPurchase",bean);
	}
	
	public Object changequick(Bean bean)
	{
		return SqlSessionTemplate.update("mapper.changequick",bean);
	}
	
	public Object getBadPurchase()
	{
		return SqlSessionTemplate.selectList("mapper.getBadPurchase");
	}
	
	public Object getDistributedCoupons()
	{
		return SqlSessionTemplate.selectList("mapper.getDistributedCoupons");
	}
	
	public Object getBsCouponOne(Integer keyword)
	{
		return SqlSessionTemplate.selectOne("mapper.getBsCouponOne", keyword);
	}
	
	//flags important
	public Object updateBsCoupon(Bean bean)
	{
		System.out.println("update Coupon : "+bean.getBc_start_date_before());
		System.out.println("update Coupon : "+bean.getBc_end_date_before());
				
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

   	 	try {
		
   	 		bean.setBc_start_date(formatter2.parse(bean.getBc_start_date_before()));
	   	 	bean.setBc_end_date(formatter2.parse(bean.getBc_end_date_before()));
	   	 	
	   	 	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return SqlSessionTemplate.update("mapper.updateBsCoupon",bean);
	}
	
	
	public Object bs_coupon_delete(Bean bean)
	{
		SqlSessionTemplate.delete("mapper.killBsMyCoupon",bean);
		SqlSessionTemplate.delete("mapper.deleteBsCoupon",bean);
		return bean;
	}
	
	public Object get2ndmenu(Bean bean)
	{
		return SqlSessionTemplate.selectList("mapper.get2ndmenu",bean);
	}
	
	public Object SecondMenuUpload(Bean bean)
	{
		return SqlSessionTemplate.insert("mapper.2ndMenuUpload",bean);
	}
	
	public Object deleteMenu(Integer deleteid)
	{
		return SqlSessionTemplate.delete("mapper.deleteMenu",deleteid);
	}
	
	public Object deleteMenuChild(Integer deleteid)
	{
		return SqlSessionTemplate.delete("mapper.deleteMenuChild",deleteid);	
	}
	
	public Object easy_kill(Bean bean, Form_Data fd, HttpServletRequest request)
	{
		 if (fd.getList() != null)
		 {
		   for (int i = 0; i < fd.getList().size(); i++)
		   {
			   bean.setG_code(fd.getList().get(i).getG_code()); 
		   	
			   System.out.println("get easykill : "+bean.getG_code());
			   
			   
			   SqlSessionTemplate.delete("mapper.easy_kill",bean);			   
		   }
		   	   System.out.println("easy_kill Successful");
		  }
		
		return bean;		
	}
	
	
	public Object getNewBqId(Bean bean)
	{
		return SqlSessionTemplate.selectOne("mapper.getNewBqId",bean);
	}
	
	
	public Object initialBs_Quick(Bean bean)
	{
		return SqlSessionTemplate.update("mapper.initialBs_Quick",bean);
	}
	
	
	public Object getBs_good_detail(Integer getkey)
	{
		return SqlSessionTemplate.selectList("mapper.getBs_good_detail",getkey);
	}
	
	public Object bs_good_detail_delete(Bean bean)
	{
		return SqlSessionTemplate.delete("mapper.bs_good_detail_delete",bean);
	}
		
	
	public Object initialQuicky(Bean bean)
	{
		return SqlSessionTemplate.update("mapper.initialQuicky",bean);
	}
	
	public Object getBs_nonDeliveryGrant(Bean bean)
	{
		return SqlSessionTemplate.update("mapper.getBs_nonDeliveryGrant",bean);
	}
	
	
	public Object getBs_Guest(Bean bean)
	{
		return SqlSessionTemplate.selectOne("mapper.getBs_Guest",bean);
	}
	
	
//Admin Repository end
	
	
	//get 해더 메뉴 
	public void get_menu(Bean bean){
		bean.setMenuitem(SqlSessionTemplate.selectList("mapper.getMenu", bean));
	}


	
	
/* 병기리 */
	/* 핸드폰 아이디 찾기 */
	public Object userid_find_hp(Bean bean)
	{
		bean.setMsg("N");
		
		if(bean.getBs_hp()!=null)
		{
			try
			{
				bean.setBs_userid(((Bean)SqlSessionTemplate.selectOne("mapper.userid_find_hp", bean)).getBs_userid());
			}
			catch (Exception e)
			{
				//e.printStackTrace();
			}
		}
		
		
		if(!bean.getBs_userid().equals(null) && !bean.getBs_userid().equals("") && !bean.getBs_userid().equals("null"))
		{
			bean.setMsg("Y");
		}
		
			
		return bean;
	}
	
	/* 핸드폰 비밀번호 찾기 */
	public Object uesrpw_find_hp(Bean bean)
	{
			try
			{
				if(bean.getBs_hp()!=null)
				{
					bean.setBs_pwd(((Bean)SqlSessionTemplate.selectOne("mapper.userpw_find_hp",bean)).getBs_pwd());
					System.out.println("있다");
					bean.setBs_pwd(((int)(Math.random()*100)+1)*2*3*4*5*6+"");
					SqlSessionTemplate.update("mapper.userpw_temp",bean);
					bean.setMsg("Y");
				}
			}
			catch (Exception e)
			{
				bean.setMsg("N");
			}
				
		return bean;
	}
	
	/* 이메일 아이디 찾기 */
	public Object userid_fined_email(Bean bean)
	{
		
		
		bean.setData(SqlSessionTemplate.selectOne("mapper.userid_fined_email",bean));
		try
		{
			if( ((Bean)bean.getData()).getBs_userid()!=null  && !((Bean)bean.getData()).getBs_userid().equals(""))
			{
				
					sendMail("B-Shop "+((Bean)bean.getData()).getBs_name()+" 님의 아이디 찾기. ",
							((Bean)bean.getData()).getBs_name()+"님의 아이디는 [  "+(((Bean)bean.getData()).getBs_userid()).substring(0,((Bean)bean.getData()).getBs_userid().length()-2)+"**   ] 입니다.","B-Shop",((Bean)bean.getData()).getBs_email(),null);
					
					bean.setMsg("Y");
					bean.setFind_email_chk("Y");		
				
			}
		}
		catch (Exception e)
		{
			bean.setMsg("N");
		}
		bean.setUrl("member/findid");
		
		return bean;
	}
	
	
	/* 이메일 비밀번호 찾기 */
	public Object userpw_fined_email(Bean bean)
	{
		
		bean.setData(SqlSessionTemplate.selectOne("mapper.userpw_fined_email", bean));
		

		try
		{

		
			if(((Bean)bean.getData()).getBs_pwd()!=null && !((Bean)bean.getData()).getBs_pwd().equals(""))
			{	
	
				bean.setBs_pwd(((int)(Math.random()*100)+1)*2*3*4*5*6+"");
				SqlSessionTemplate.update("mapper.userpw_temp",bean);
	
				sendMail("B-Shop "+((Bean)bean.getData()).getBs_name()+" 님의 임시 비밀번호. ",
						"임시 발급된 비밀번호는 [  "+bean.getBs_pwd()+"   ] 입니다.","B-Shop",((Bean)bean.getData()).getBs_email(),null);
				bean.setMsg("Y");
				bean.setFind_email_chk("Y");
			}		
		}
		catch (Exception e)
		{
			bean.setMsg("N");
			
		}
		
		bean.setUrl("member/findpw");
		

		return bean;
	}
	
	
	
	/* 마이페이지 인증*/
	public Object getuserpw(Bean bean)
	{
		
		bean.setBs_pwd(SqlSessionTemplate.selectOne("mapper.getuserpw",bean)+"");
		
		if(bean.getBs_pwd()!=null)
			return bean;
		
		bean.setUrl("/shop/bs/user/member/uesrInfo");
		return null;
	}
	
	/*장바구니*/
	
	public Object basketselect(Bean bean)
	{
		//boolean res = true;
		bean.setMsg("N");
		
		bean.setData(SqlSessionTemplate.selectOne("mapper.basketselect",bean));
		
		if( ((Bean)bean.getData()).getBb_id() > 0)
		{
			
			bean.setMsg("Y");
		}
		
		
		return bean;
	}
	
	public Object basketinsert(Bean bean)
	{
		String [] arr = bean.getA_arr().split("#");
		String [] arr2 = bean.getA_arr2().split("#");
		String [] arr3 = bean.getA_arr3().split("#");
		
		bean.setBb_cnt(arr.length);
		
		SqlSessionTemplate.insert("mapper.basketinsert",bean);
		
		for(int i=0; i<arr.length; i++)
		{
			bean.setBgd_id(Integer.parseInt(arr[i]));
			bean.setBbo_cnt(arr2[i]);
			bean.setBbo_price(arr3[i]);
			
			SqlSessionTemplate.insert("mapper.basketOptionInsert",bean);
		}
		
		bean.setRedirect(true);
		bean.setUrl("bs/user/shop/goodsdetail");
		
		return bean;
	}
	
	
	public Object cartlist(Bean bean)
	{
		bean.setData(SqlSessionTemplate.selectList("mapper.cartlist", bean));
		
		return bean;
	}
	
	
	
	
/*병기리 끝*/
	

	
	// 장바구니
	public Object cart_select(Bean bean)
	{
		String sql = "", where = "", sHtml = "", sHtml2 = "";
		Integer bbo_id = 0, g_cnt = 0, g_pay = 0, total_pay = 0;
	
		bean.setData(SqlSessionTemplate.selectList("mapper.cart_select",bean));
		
		if (((ArrayList)bean.getData()).size() > 0)
		{
			bean.setBb_cnt(((ArrayList)bean.getData()).size());
			bean.setA_g_code("");
			bean.setA_bgd_id("");
			bean.setA_bgd_cnt("");
			bean.setA_bgd_price("");
			bean.setA_g_code_price("");

			for (int i = 0; i < ((ArrayList)bean.getData()).size(); i++)
			{
				if (bean.getA_g_code().equals(""))
				{
					bean.setA_g_code(Integer.toString(((ArrayList<Bean>)bean.getData()).get(i).getG_code()));
					bean.setA_g_code_price(Integer.toString(((ArrayList<Bean>)bean.getData()).get(i).getBb_price()));
				}
				else
				{
					bean.setA_g_code(bean.getA_g_code() + "#" + Integer.toString(((ArrayList<Bean>)bean.getData()).get(i).getG_code()));
					bean.setA_g_code_price(bean.getA_g_code_price() + "#" + Integer.toString(((ArrayList<Bean>)bean.getData()).get(i).getBb_price()));
				}
				//total_pay += ((ArrayList<Bean>)bean.getData()).get(i).getBb_price();
			}
			
			String [] arr = bean.getA_g_code().split("#");			// 상품코드
			
			for (int i = 0; i < arr.length; i++)
			{
				sql = "SELECT C.BGD_ID, C.BGD_SIZE, C.BGD_COLOR, B.BBO_CNT, C.BGD_CNT, B.BBO_PRICE, B.BBO_ID FROM BS_BASKET A "
						+ "INNER JOIN BS_BASKET_OPTION B "
						+ "ON A.BB_ID = B.BB_ID "
						+ "INNER JOIN BS_GOODS_DETAIL C "
						+ "ON B.BGD_ID = C.BGD_ID "
						+ "WHERE A.BB_ID = " + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id();
										
				bean.setSqler(sql);
				
				System.out.println("장바구니 쿼리 " + sql);

				bean.setGoods_data(SqlSessionTemplate.selectList("mapper.pay_goods_select_detail",bean));
				
				for (int j = 0; j < ((ArrayList<Bean>)bean.getGoods_data()).size(); j++)
				{
					if (bean.getA_bgd_id().equals(""))
					{
						bean.setA_bgd_id(Integer.toString(((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_id()));
						bean.setA_bgd_cnt(((ArrayList<Bean>)bean.getGoods_data()).get(j).getBbo_cnt());
						bean.setA_bgd_price(((ArrayList<Bean>)bean.getGoods_data()).get(j).getBbo_price());
					}
					else
					{
						bean.setA_bgd_id(bean.getA_bgd_id() + "#" + Integer.toString(((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_id()));
						bean.setA_bgd_cnt(bean.getA_bgd_cnt() + "#" + ((ArrayList<Bean>)bean.getGoods_data()).get(j).getBbo_cnt());
						bean.setA_bgd_price(bean.getA_bgd_price() + "#" + ((ArrayList<Bean>)bean.getGoods_data()).get(j).getBbo_price());
					}
				}
				
				bean.setA_bgd_id(bean.getA_bgd_id() + "@");
				bean.setA_bgd_cnt(bean.getA_bgd_cnt() + "@");
				bean.setA_bgd_price(bean.getA_bgd_price() + "@");
				
				bean.setA_bgd_id(bean.getA_bgd_id().replace("@#", "@"));
				bean.setA_bgd_cnt(bean.getA_bgd_cnt().replace("@#", "@"));
				bean.setA_bgd_price(bean.getA_bgd_price().replace("@#", "@"));
				
				
				System.out.println("============================================");
				System.out.println("상품코드 : " + bean.getA_g_code());
				System.out.println("상세코드 : " + bean.getA_bgd_id());
				System.out.println("상품갯수 : " + bean.getA_bgd_cnt());
				System.out.println("상품가격 : " + bean.getA_bgd_price());
				System.out.println("총 금액 : " + bean.getBb_price());
				System.out.println("============================================");
				
				String [] par_arr2 = bean.getA_bgd_id().split("@");			// 상세코드
				String [] par_arr3 = bean.getA_bgd_cnt().split("@");		// 상세갯수 
				String [] par_arr4 = bean.getA_bgd_price().split("@");		// 상세가격
				//String [] par_arr5 = bean.getA_g_code_price().split("@");	// 상품가격
				
				
				String [] arr2 = par_arr2[i].split("#");			// 상세코드
				String [] arr3 = par_arr3[i].split("#");		// 상세갯수 
				String [] arr4 = par_arr4[i].split("#");		// 상세가격
				String [] arr5 = bean.getA_g_code_price().split("#");	// 상품가격

				sHtml += "<tr id='t_" + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id() + "' name='deal_row'>";
				sHtml += "    <td class='check'></td>";
				sHtml += "    <td class='thmb' name='td_data_img'>";
				sHtml += "        <a href='/deal/75653041' target='_blank' class='thmb_inner'>";
				sHtml += "			<img src='/shop/resources/up_img/" + ((ArrayList<Bean>)bean.getData()).get(i).getG_imglist() + "' width='100' height='102' alt='temp thmb' />";
				sHtml += "        </a>";
				sHtml += "    </td>";
				sHtml += "    <td class='deal_info' name='td_data_option'>";
				sHtml += "        <a href='/deal/75653041' target='_blank' class='h_deal' title=''></a>";
				sHtml += "        <div>";
				sHtml += "            <ul id='ul_" + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id() + "' name='option_area' class='uio_option_area'>";
				
				
				if (((ArrayList)bean.getGoods_data()).size() > 0)
				{
					for (int j = 0; j < ((ArrayList)bean.getGoods_data()).size(); j++)
					{
						for (int k = 0; k < arr2.length; k++)
						{
							System.out.println(arr2[k] + "//" + ((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_id());
							if (Integer.parseInt(arr2[k]) == ((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_id())
							{
								bbo_id = ((ArrayList<Bean>)bean.getGoods_data()).get(j).getBbo_id();
								g_cnt = Integer.parseInt(arr3[k]);
								g_pay = Integer.parseInt(arr5[i]) * g_cnt;
								break;
							}
						}
						
						total_pay += g_pay;
						
						sHtml += "                <li id='" + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id() + "_" + bbo_id + "' name='opt_deal'>";
						sHtml += "                    <span class='option'>" + 
														((ArrayList<Bean>)bean.getData()).get(i).getG_name() + "　" +
														((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_size() + "　" +
														((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_color() + "</span>";
						sHtml += "                    <span class='amounts'><em name='opt_amount'>" + Integer.parseInt(arr5[i]) + "</em>원</span>";
						sHtml += "                    <span class='uio_option_cnt'>";
						sHtml += "                        <input type='text' name='view_cnt' value='" + g_cnt + "' readonly class='uio_option_input option_count_75653041_0'>";
						sHtml += "                        <span class='uio_option_control'>";
						sHtml += "                            <a style='cursor:pointer' onclick=\"add_count(this, 'U', '" + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id() + "', '" + j + "', '" + i + "');\" class='uio_btn_plus'>증가</a>";
						sHtml += "                            <a style='cursor:pointer' onclick=\"add_count(this, 'N', '" + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id() + "', '" + j + "', '" + i + "');\" class='uio_btn_minus'>감소</a>";
						sHtml += "                        </span>";
						sHtml += "                    </span>";
						sHtml += "                    <span class='total'><em name='opt_total_amount'>" + g_pay +"</em>원<div style='position:relative; top:-15px'><img src='/shop/resources/images/btn_close.png' alt='삭제' style='cursor:pointer' onclick=\"cart_del('O', '" + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id() + "', '" + bbo_id + "', '" + j + "', '" + i + "');\" /></div></span>";
						sHtml += "                </li>";
	
					}
				}
	
				sHtml += "             <br /><a style='cursor:pointer' class='btn_del' onclick=\"cart_del('C', '" + ((ArrayList<Bean>)bean.getData()).get(i).getBb_id() + "', '', '" + i + "', '" + i + "');\">삭제하기</a></ul>";
				sHtml += "        </div>";
				sHtml += "    </td>";
				if (i == 0)
				{
					sHtml += "    <td class='amounts' rowspan='" + arr.length + "'><span><em name='deal_total_amount'>0</em>원</span></td>";
					sHtml += "    <td class='disc' rowspan='" + arr.length + "'>";
					sHtml += "        <div style='display:none' name='discount_amount' class='saving_amounts'>-<em>0</em>원</div>";
					sHtml += "        <a href='#none' onclick=\"coupon_ac(); return false;\"><img src='/shop/resources/images/btn_coupon.png' alt='쿠폰사용' id='img_cp' /></a>";
					sHtml += "    </td>";
					sHtml += "    <td class='delivery' rowspan='" + arr.length + "'>";
					sHtml += "        <div name='deal_delivery_amount'>";
					sHtml += "            <select id='sel_quick'>";
					sHtml += "                <option value='2500'>2,500원</option>";
					sHtml += "                <option value='0'>직접수령</option>";
					sHtml += "            </select>";
					sHtml += "        </div>";
					sHtml += "    </td>";
					sHtml += "</tr>";
					
				}

				sHtml += "</tr>";
			}
		}
		else
		{
			bean.setBb_cnt(0);
			sHtml += "<tr class='empty'>";
			sHtml += "    <td colspan='7' align='center'>";
			sHtml += "        <p class='empty_msg'>카트에 담긴 상품이 없습니다.</p>";
			sHtml += "    </td>";
			sHtml += "</tr>";
		}
		
		bean.setBb_price(total_pay);
		bean.setHtml_view(sHtml);

		return bean;
		
	}
	
	// 결제
	public Object pay_select(Bean bean)
	{
		String [] arr = bean.getA_g_code().split("#");			// 상품코드
		String [] par_arr2 = bean.getA_bgd_id().split("@");		// 상세코드
		String [] par_arr3 = bean.getA_bgd_cnt().split("@");	// 상세갯수 
		String [] par_arr4 = bean.getA_bgd_price().split("@");	// 상세가격
		String [] arr5 = bean.getA_g_code_price().split("#");	// 상품가격
		
		System.out.println("유저 아이디 : " + bean.getBs_userid() + ">>>>>>ㄴㅇㄹㄴㅇㄹㄴㅇㄹ>>>>>>>>>>>>>>" + bean.getBc_id() + "//" + bean.getBc_price());
		
		System.out.println("페이지명 : " + bean.getPrev_page());

		bean.setPay_flag("Y");
		String cnt_check = "Y", sql = "", where = "", sHtml = "";
		Integer g_cnt = 0, g_pay = 0;
		
		if (!bean.getBs_userid().equals(""))
		{
			bean.setMem_address(((Bean)SqlSessionTemplate.selectOne("mapper.mem_address",bean)).getMem_address());

			// 주소정보 가져오기
			bean.setAdd_post(SqlSessionTemplate.selectList("mapper.add_post",bean));
		}

		for (int i = 0; i < arr.length; i++)
		{
			
			String [] arr2 = par_arr2[i].split("#");	// 상세코드
			String [] arr3 = par_arr3[i].split("#");	// 상세갯수 
			String [] arr4 = par_arr4[i].split("#");	// 상세가격
			
			if (cnt_check == "N")
			{
				break;
			}
			bean.setG_code(Integer.parseInt(arr[i]));
			bean.setData(SqlSessionTemplate.selectList("mapper.pay_goods_select",bean));
			
			if (((ArrayList)bean.getData()).size() > 0)
			{
				sql = "SELECT BGD_ID, BGD_SIZE, BGD_COLOR, BGD_CNT FROM BS_GOODS_DETAIL "
						+ "WHERE G_CODE = " + ((ArrayList<Bean>)bean.getData()).get(0).getG_code();
				
				where = " AND ( BGD_ID = " + arr2[0];
				
				for (int j = 0; j < arr2.length; j++)
				{
					where += " OR BGD_ID = " + arr2[j];
				}

				where += " )";

				sql += where;
				
				bean.setSqler(sql);
				System.out.println("sql : " + sql);
				
				sHtml += "<tr name='deal_row' class='last'>";
				sHtml += "    <td class='thmb'>";
				sHtml += "        <a href='/deal/74946277#content_start' target='_blank' class='thmb_inner'>";
				sHtml += "            <img src='/shop/resources/up_img/" + ((ArrayList<Bean>)bean.getData()).get(0).getG_imglist() + "' width='100' height='102' alt='temp thmb' />";
				sHtml += "        </a>";
				sHtml += "    </td>";
				sHtml += "    <td class='deal_info'>";
				sHtml += "        <a href='/deal/74946277#content_start' target='_blank' class='h_deal' title='" + ((ArrayList<Bean>)bean.getData()).get(0).getG_describe() + "'>" + ((ArrayList<Bean>)bean.getData()).get(0).getG_describe() + "</a>";
				sHtml += "        <ul class='uio_option_area'>";
				
				bean.setGoods_data(SqlSessionTemplate.selectList("mapper.pay_goods_select_detail",bean));
				
				if (((ArrayList)bean.getGoods_data()).size() > 0)
				{
					for (int j = 0; j < ((ArrayList)bean.getGoods_data()).size(); j++)
					{
						/*System.out.println(((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_size() + "//" +
								((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_color());*/
						
						// 수량체크
						if (((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_cnt() < Integer.parseInt(arr3[j]))
						{
							bean.setMsg(((ArrayList<Bean>)bean.getData()).get(0).getG_name() + 
									"#" + ((ArrayList<Bean>)bean.getGoods_data()).get(i).getBgd_size() +
									"#" + ((ArrayList<Bean>)bean.getGoods_data()).get(i).getBgd_color() +
									"#" + arr3[j] +
									"#" + ((ArrayList<Bean>)bean.getGoods_data()).get(i).getBgd_cnt());

							cnt_check = "N";
							bean.setPay_flag(cnt_check);
							break;
						}

						for (int k = 0; k < arr2.length; k++)
						{
							if (Integer.parseInt(arr2[k]) == ((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_id())
							{
								g_cnt = Integer.parseInt(arr3[k]);
								g_pay = Integer.parseInt(arr5[i]) * g_cnt; 
								break;
							}
							 
						}
						
						
						sHtml += "            <li>";
						sHtml += "                <span class='option'>" +
													((ArrayList<Bean>)bean.getData()).get(0).getG_name() + "　" +
													((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_size() + "　" +
													((ArrayList<Bean>)bean.getGoods_data()).get(j).getBgd_color() + "</span>";
						sHtml += "                <span class='amounts'><em>" + Integer.parseInt(arr5[i]) + "</em>원</span>";
						sHtml += "                <span class='uio_option_cnt'>";
						sHtml += "                    <span class='uio_option_input'>" + g_cnt + "</span>";
						sHtml += "                </span>";
						sHtml += "                <span class='total'><em>" + g_pay +"</em>원</span>";
						sHtml += "            </li>";
					}
				}

				sHtml += "        </ul>";
				sHtml += "    </td>";
				if (i == 0)
				{
					sHtml += "    <td class='amounts' rowspan='" + arr.length + "'><span><em name='deal_total_amount'>" + bean.getBb_price() +"</em>원</span></td>";
					if (!bean.getBs_userid().equals(""))
					{
						sHtml += "    <td class='disc' rowspan='" + arr.length + "'>";
						sHtml += "        <div style='display:none' name='discount_amount' class='saving_amounts'>-<em>0</em>원</div>";
						sHtml += "        <a href='#none' onclick=\"coupon_ac(); return false;\"><img src='/shop/resources/images/btn_coupon.png' alt='쿠폰사용' id='img_cp' /></a>";
						sHtml += "    </td>";
					}
					else
					{
						sHtml += "    <td class='disc' rowspan='" + arr.length + "'>";
						sHtml += "        <div style='display:none' name='discount_amount' class='saving_amounts'>-<em>0</em>원</div>";
						sHtml += "    </td>";
					}
					sHtml += "    <td class='delivery' rowspan='" + arr.length + "'>";
					sHtml += "        <select id='sel_quick' name='bq_type'>";
					sHtml += "            <option value='2500'>2,500원</option>";
					sHtml += "            <option value='0'>직접수령</option>";
					sHtml += "        </select>";
					sHtml += "    </td>";
				}
				sHtml += "</tr>";
			}
			
			bean.setHtml_view(sHtml);
		}
		
		return bean;
		
		
	}
	

	
	public Object pay_buy(Bean bean)
	{
		System.out.println("------------------------디버깅----------------");
		System.out.println("유저 : " + bean.getBs_id() + "//" + bean.getBs_userid());
		
		if (bean.getBs_userid() == null || bean.getBs_userid().equals(""))
		{
			bean.setBs_id(0);
		}
		
		System.out.println("bs_id : " + bean.getBs_id());
		System.out.println("상품코드 : " + bean.getA_g_code());
		System.out.println("상세번호 : " + bean.getA_bgd_id());
		System.out.println("갯수" + bean.getA_bgd_cnt());
		System.out.println("상세금액" + bean.getA_bgd_price());
		System.out.println("총 금액" + bean.getA_g_code_price());
		System.out.println("쿠폰사용여부 : " + bean.getBc_id());
		System.out.println("쿠폰금액 : " + bean.getPay_pay2());
		System.out.println("택배사용여부 : " + bean.getBq_type());
		System.out.println("택배금액 : " + bean.getPay_pay3());

		// 택배비용
		bean.setBq_price(bean.getPay_pay3());
		
		// 쿠폰할인 금액
		bean.setBp_coupon_price(bean.getPay_pay2());
		
		// 최종금액 설정
		//bean.setPay_total_price(bean.getBb_price()); 
		//System.out.println("총금액 : " + bean.getPay_total_price());
		//bean.setBp_price(bean.getPay_total_price());
		
		System.out.println("----------------------------------------");
		System.out.println("bg_name" + bean.getBg_name());
		System.out.println("bg_hp" + bean.getBg_hp());
		System.out.println("bg_zip" + bean.getBg_zip());
		System.out.println("bg_address" + bean.getBg_address());
		System.out.println("bg_address2" + bean.getBg_address2());
		System.out.println("bq_memo" + bean.getBq_memo());
		System.out.println("bp_price_type" + bean.getBp_price_type());
		System.out.println("------------------------디버깅----------------");
		System.out.println("로그인 : " + bean.getBs_id() + "//" + bean.getBs_userid());
		
		/////////////////////////// 택배 설정 ///////////////////////////
		// 택배사용여부
		bean.setBq_type("N");
		bean.setBq_code("");	// 송장번호
		bean.setBq_status("0");
		if (bean.getPay_pay3() > 0)
		{
			// 택배사용
			bean.setBq_type("Y");
			bean.setBq_code("3423-234234-3242");	// 송장번호
			// 택배상태 (준비중 배송중 배송완료)
			bean.setBq_status("1");
		}
		
		// BS_QUICK - INSERT - o
		SqlSessionTemplate.insert("mapper.bs_quick_insert",bean);
		
		System.out.println("인서트 후 > bq_id : " + bean.getBq_id());
		
		// 결제완료처리
		if (bean.getBp_price_type() == 1)
		{
			bean.setBp_status("Y");
		}
		else
		{
			bean.setBp_status("N");
		}
		
		System.out.println("디버깅 :>>" + bean.getG_code() + "//" + bean.getBq_id() + "//" + bean.getBp_status() + "//" + bean.getBp_price_type() + "//" + bean.getBb_price());
		
		String [] arr = bean.getA_g_code().split("#");			// 상품코드
		String [] par_arr2 = bean.getA_bgd_id().split("@");		// 상세코드
		String [] par_arr3 = bean.getA_bgd_cnt().split("@");	// 상세갯수 
		String [] par_arr4 = bean.getA_bgd_price().split("@");	// 상세가격
		String [] arr5 = bean.getA_g_code_price().split("#");	// 상품가격
		
		for (int i = 0; i < arr.length; i++)
		{
			// 상품 상세 인서트
			String [] arr2 = par_arr2[i].split("#");	// 상세코드
			String [] arr3 = par_arr3[i].split("#");	// 상세갯수 
			String [] arr4 = par_arr4[i].split("#");	// 상세가격
			bean.setBp_price(0);
			
			// 상품별 총 옵션 갯수
			bean.setBp_cnt(arr2.length);
			
			// 상품별 총 금액
			for (int j = 0; j < arr2.length; j++)
			{
				bean.setBp_price(bean.getBp_price() + Integer.parseInt(arr5[i]) * Integer.parseInt(arr3[j]));
			}
			
			// BS_PURCHASE - INSERT - o
			SqlSessionTemplate.insert("mapper.bs_purchase_insert",bean);
			
			System.out.println("인서트 후 > bp_id : " + bean.getBp_id());
			
			//values (<include refid="bs_pur_id_Max"/>, #{bs_id}, #{g_code}, #{bq_id}, #{bp_status}, #{bp_price_type}, #{bp_price}, sysdate)
			
			for (int k = 0; k < arr2.length; k++)
			{
				bean.setBgd_id(Integer.parseInt(arr2[k]));
				bean.setBpd_cnt(Integer.parseInt(arr3[k]));
				bean.setBpd_price(Integer.parseInt(arr4[k]));
				
				System.out.println(bean.getBp_id() + "//" + bean.getBgd_id() + "//" + bean.getBpd_cnt()  + "//" + bean.getBpd_price() );
				
				SqlSessionTemplate.insert("mapper.bs_purchase_detail_insert",bean); 
			}
		}
			
		// BS_GUEST - INSERT
		bean.setBg_code(bean.getBp_id() + ((int)(Math.random()*100)+1)*2*3*4*5*6+"");	// 비회원 조회코드
		System.out.println(bean.getBp_id() + "//" + bean.getBs_id() + "//" + bean.getBg_code()  + "//" + bean.getBg_name()  + "//" + bean.getBg_hp() + "//" + bean.getBg_zip()  + "//" + bean.getBg_address()  + "//" + bean.getBg_address2());
		
		SqlSessionTemplate.insert("bs_guest_insert",bean);
		//values(<include refid="bg_id_Max"/>, #{bp_id}, #{bs_id}, #{bg_code}, #{bg_name}, #{bg_hp}, #{bg_zip}, #{bg_address}, #{bg_address2}, sysdate)
		
		
		// 쿠폰을 사용했다면
		if (bean.getBp_coupon_price() > 0)
		{
			// BS_COUPON - INSERT
			SqlSessionTemplate.update("mapper.coupon_update",bean);
		}
		
		// 장바구니 결제라면 장바구니 데이터 삭제
		if (bean.getPrev_page().equals("cart"))
		{
			SqlSessionTemplate.delete("mapper.bs_basket_option_del3",bean);
			SqlSessionTemplate.delete("mapper.bs_basket_del2",bean);
		}

		return bean;

	}

	
	/*EmailSender*/	
	
	public void sendMail(String subject, String text, String fromUser, String toUser, String[] toCC) {
	
		 MimeMessage message = mailSender.createMimeMessage();	     

	       try {

	           MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

	            if (toCC != null) {

	               messageHelper.setCc(toCC);

	         }

	          messageHelper.setSubject(subject);

	           messageHelper.setTo(toUser);

	           messageHelper.setFrom(fromUser);

	           messageHelper.setText(text, true);

	           mailSender.send(message);

	    

	       } catch (Exception e) {

	          e.printStackTrace();

	      }

	   }
	
	public Object cart_delete(Bean bean)
	{
		if (bean.getBbo_id() != null)
		{
			// 장바구니 옵션 삭제
			SqlSessionTemplate.delete("mapper.bs_basket_option_del1",bean);
		}
		else
		{
			// 장바구니 + 장바구니 옵션 삭제
			SqlSessionTemplate.delete("mapper.bs_basket_option_del2",bean);
			SqlSessionTemplate.delete("mapper.bs_basket_del",bean);
		}
		
		return bean;
	}
	
	
	public Object pop_coupon(Bean bean)
	{
		System.out.println("bs_id : " + bean.getBs_id());
		bean.setCoupon(SqlSessionTemplate.selectList("mapper.pop_coupon", bean));
				
		//System.out.println(((ArrayList<Bean>)bean.getCoupon()).get(0).getBc_id());
		//System.out.println("데이터 존재 여부 : " + ((Bean)bean.getCoupon()).getBc_id());
		
		return bean;
	}
	
	
}

