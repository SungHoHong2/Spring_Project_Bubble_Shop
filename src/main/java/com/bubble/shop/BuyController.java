package com.bubble.shop;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.bubble.shop.model.Bean;
import com.bubble.shop.service.ServiceRepository;

@Controller()
public class BuyController {

	public Object data(String service, ServiceRepository repository, Bean bean, HttpServletRequest request, HttpSession session)
	{
		Object res	= bean;
		
		switch(service)
		{
			case "userInfo" :

				if (bean.getBs_userid() != null && !bean.getBs_userid().equals(""))
				{
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

			
			case "cart" :
				System.out.println("상품코드 : " + bean.getA_g_code());
				System.out.println("상세코드 : " + bean.getA_bgd_id());
				System.out.println("상품갯수 : " + bean.getA_bgd_cnt());
				System.out.println("상품가격 : " + bean.getA_bgd_price());
				System.out.println("총 금액 : " + bean.getBb_price());
				
				// 결제정보
				res = repository.cart_select(bean);
				
				
				break;
			case "cartok" :

				res = repository.cart_delete(bean);
				bean.setRedirect(true);
				bean.setUrl("redirect:/bs/user/shop/main");
				
				break;
			
			case "pay" : 
								
				System.out.println("상품코드 : " + bean.getA_g_code());
				System.out.println("상세코드 : " + bean.getA_bgd_id());
				System.out.println("상품갯수 : " + bean.getA_bgd_cnt());
				System.out.println("상품가격 : " + bean.getA_bgd_price());
				System.out.println("총 금액 : " + bean.getBb_price());
				
				// 결제정보
				res = repository.pay_select(bean);
				
				// 은행정보
				res = repository.getBankList(bean);
				bean.setBank(res);
				
				if (bean.getBs_userid() != null && !bean.getBs_userid().equals(""))
				{
					// 회원정보
					res = repository.getMemberDetail(bean);
					bean.setUserinfo(res);
					
					String arr2 [] = ((Bean)res).getBs_hp().split("-");
					
					bean.setH_hp1(arr2[0]);
					bean.setH_hp2(arr2[1]);
					bean.setH_hp3(arr2[2]);
					
					if (((Bean)res).getBs_zip() != null)
					{
						String arr3 [] = ((Bean)res).getBs_zip().split("-");
						bean.setH_zip1(arr3[0]);
						bean.setH_zip2(arr3[1]);
					}
				}
			
				break;
				
			case "pop_coupon" :
				
				// 결제정보
				res = repository.pop_coupon(bean);
				bean.setRedirect(true);
				bean.setUrl("bs/user/buy/pop_coupon");
				break;
			
			case "payok" : 

				// 결제정보
				res = repository.pay_buy(bean);
				bean.setUrl("buy/endpay");
				break;

		}

		return res;
	}
	
}
