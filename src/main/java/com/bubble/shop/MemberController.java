package com.bubble.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.bubble.shop.model.Bean;
import com.bubble.shop.model.Form_Data;
import com.bubble.shop.service.FileUp;
import com.bubble.shop.service.ServiceRepository;
import com.bubble.shop.service.ZipSearch;


@Controller()
public class MemberController {

	public Object data(String service, ServiceRepository repository, Bean bean, HttpServletRequest request, Form_Data fd, HttpSession session)
	{
		Object res	= bean;
		
		switch(service)
		{
			case "test_list" :
				//System.out.println(fd.getList().size());
				//System.out.println("ddd");

				// 첨부파일
				if (fd.getList() != null)
				{
					for (int i = 0; i < fd.getList().size(); i++)
					{
						//System.out.println(fd.getList().get(i).getUpfile().getOriginalFilename());
						if (!fd.getList().get(i).getUpfile().getOriginalFilename().equals("") && fd.getList().get(i).getUpfile().getOriginalFilename() != null)
						{
							bean.setUpfile(fd.getList().get(i).getUpfile());
							fd.getList().get(i).setRename_upfile(new FileUp().fileUpload(bean, request, "up_img"));
							System.out.println(i + "번 - 업로드 파일명 : " + fd.getList().get(i).getUpfile().getOriginalFilename());
							System.out.println(i + "번 - 저장된 파일명 : " + fd.getList().get(i).getRename_upfile());
						}
						else
						{
							System.out.println("첨부 -- 없다");
						}
					}
				}
				else
				{
					System.out.println("데이터 없음");
				}
				//System.out.println(bean.get);
				
				
				//res = repository.test_list(bean, fd);
				break;
			case "signup2" :
				if (bean.getBs_hp() == null || bean.getBs_sex() == null)
				{
					bean.setRedirect(true);
					bean.setUrl("redirect:/bs/user/shop/main");
				}
				else
				{
					bean.setUrl("member/" + service);
				}
				break;
			case "signup2ok" :
				res = repository.bs_join(bean);
				
				if (((Bean)res).getMsg().equals("Y"))
				{
					// 회원가입 성공시
					session.setAttribute("session_bsid", ((Bean)((Bean)res).getData()).getBs_id());
					session.setAttribute("session_userid", ((Bean)((Bean)res).getData()).getBs_userid());
					session.setAttribute("session_name", ((Bean)((Bean)res).getData()).getBs_name());
					session.setAttribute("session_rate", ((Bean)((Bean)res).getData()).getBs_rate());
					bean.setRedirect(true);
					bean.setUrl("redirect:/bs/user/member/welcome");
				}
				else
				{
					bean.setRedirect(true);
					bean.setUrl("redirect:/bs/user/shop/main");
				}
				
				break;
			
			case "signup2_ajax" :
				res = repository.userid_chk(bean);
				bean.setRedirect(true);
				bean.setUrl("bs/user/member/" + service);
				break;
			case "find_id_hp":
				res = repository.userid_find_hp(bean);
				bean.setUrl("member/findid");
				break;
			case "find_pw_hp":
				res = repository.uesrpw_find_hp(bean);
				bean.setUrl("member/findpw");
				break;
			case "userid_fined_email":
				res = repository.userid_fined_email(bean);
				bean.setUrl("member/findid");
				break;
			
			case "userpw_fined_email":
				res = repository.userpw_fined_email(bean);
				bean.setUrl("member/findpw");
				break;
			
			case "chkpwd":
				
				if(session.getAttribute("session_userid")!=null && !session.getAttribute("session_userid").equals("") )
				{
					bean.setBs_userid((String)session.getAttribute("session_userid"));
					res = repository.getuserpw(bean);
				}else
				{
					bean.setRedirect(true);
					bean.setUrl("redirect:/bs/user/shop/main");
				}
				break;
			case "userInfo" :
				
				if (bean.getBs_userid() != null && !bean.getBs_userid().equals(""))
				{System.out.println("userInfo접근");
				System.out.println("bean.getBs_userid() : " + bean.getBs_userid());
					// 은행정보
					res = repository.getBankList(bean);
					bean.setBank(res);
					
					// 회원정보
					res = repository.getMemberDetail(bean);
					
					String arr [] = ((Bean)res).getBs_email().split("@");
					
					bean.setH_email1(arr[0]);
					bean.setH_email2(arr[1]);

					String arr2 [] = ((Bean)res).getBs_hp().split("-");
					
					bean.setH_hp1(arr2[0]);
					bean.setH_hp2(arr2[1]);
					bean.setH_hp3(arr2[2]);
					
					String arr3 [] = ((Bean)res).getBs_zip().split("-");
					bean.setH_zip1(arr3[0]);
					bean.setH_zip2(arr3[1]);
					
					bean.setData(res);
				}
				else
				{
					bean.setMsg("ERROR");
					res = bean;
				}
				
				break;
				
			case "userInfook" :
				
				bean.setBs_photo("");
				if (bean.getUpfile() != null)
				{
					// 프로필 사진 업로드
					System.out.println("사진 있냐??");
				}
				
				res = repository.mem_update(bean);
				bean.setMsg("회원정보 수정이 완료 되었습니다");
				bean.setRedirect(true);
				bean.setUrl("redirect:/bs/user/member/userInfo");
				break;
				
			case "coupon" :
				repository.getMyCoupon(bean, session);
				break;
				
				
				
			/*우편검색*/
				
			case "zipOk":
				System.out.println("우편검색실행");
				res = new ZipSearch().searchList(bean);
				bean.setUrl("member/zipOk");
				break;
		}

		return res;
	}
	
}
