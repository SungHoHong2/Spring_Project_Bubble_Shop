<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<script type="text/javascript">

	if ('${session_name}' == '')
	{
		alert("로그인이 필요한 서비스 입니다");
		window.location.href="/shop/bs/user/member/login";		
	}
	
	$(document).ready(function(){
		
		cart_del = function(type, code, bbo_code, option_idx, goods_idx)
		{
			var sMent = "해당 상품을 삭제 하시겠습니까?";
			var param = "bb_id=" + code;
			
			if (type == "O" && $("#ul_" + code).find("li").length <= 1)
			{
				sMent = "해당 상품의 옵션을 삭제시 상품이 삭제 됩니다.\r\n\r\n진행 하시겠습니까?";
				type = "C";
			}
			else if (type == "O")
			{
				sMent = "해당 상품의 옵션을 삭제 하시겠습니까?";
				param = "bbo_id=" + bbo_code;
			}
			
			if (!confirm(sMent))
			{
				return false;
			}
			

			$.ajax({
			    type : "POST"
			    , async : true
			    , url : "cartok"
			    , dataType : "html"
			    , timeout : 3000
			    , cache : false
			    , data : param
			    , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			    , error : function(request, status, error) {
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			    , success : function(response, status, request) {
			    	cart_con(type, code, bbo_code, option_idx, goods_idx);
			    }

			});

			//cart_con(type, code, bbo_code, option_idx, goods_idx);
		}
		
		
		cart_con = function(type, code, bbo_code, option_idx, goods_idx){
			
			var str1 = "", text1 = "", str2 = "", text2 = "", str3 = "", text3 = "";
			
			
			var goods_idx = $("[name='deal_row']").index($("#t_" + code));
			var option_idx = $("[name='deal_row']").eq(goods_idx).find("li").index($("#" + code + "_" + bbo_code));
			var index = $("[name='opt_deal']").index($("[name='option_area']").eq(goods_idx).find("li").eq(option_idx));
			
			var acode = $("#a_g_code").val().split("#");		// 상품별 코드
			var arr = $("#a_g_code_price").val().split("#");	// 상품별 가격
			
			var par_arr1 = $("#a_bgd_id").val().split("@");		// 상세코드
			var par_arr2 = $("#a_bgd_cnt").val().split("@");	// 상세갯수
			var par_arr3 = $("#a_bgd_price").val().split("@");	// 상세금액
			
			var arr1 = par_arr1[goods_idx].split("#");
			var arr2 = par_arr2[goods_idx].split("#");
			var arr3 = par_arr3[goods_idx].split("#");

			if (type == "O")
			{
				// 옵션 삭제
				$("#bb_price").val(parseInt($("#bb_price").val()) - (parseInt(arr[goods_idx]) * parseInt(arr2[option_idx])));
				
				for (var i = 0; i < arr2.length; i++)
				{
					if (i == option_idx)
					{
						continue;	
					}
					if (str1 == "")
					{
						str1 += arr1[i];
						str2 += arr2[i];
						str3 += arr3[i];
					}
					else
					{
						str1 += "#" + arr1[i];
						str2 += "#" + arr2[i];
						str3 += "#" + arr3[i];
					}
				}

				for (var i = 0; i < par_arr2.length; i++)
				{
					if (i == goods_idx)
					{
						text1 += str1;
						text2 += str2;
						text3 += str3;
					}
					else
					{
						text1 += par_arr1[i];
						text2 += par_arr2[i];
						text3 += par_arr3[i];
					}
					if (i != par_arr2.length-1)
					{
						text1 += "@";
						text2 += "@";
						text3 += "@";
					}
				}
			}
			else
			{
				// 상품 삭제
				for (var i = 0; i < arr2.length; i++)
				{
					$("#bb_price").val(parseInt($("#bb_price").val()) - (parseInt(arr[goods_idx]) * parseInt(arr2[i])));	
				}
				
				for (var i = 0; i < par_arr3.length; i++)
				{
					if (i == goods_idx)
					{
						continue;	
					}
					
					text1 += par_arr1[i];
					text2 += par_arr2[i];
					text3 += par_arr3[i];
					
					if (i != par_arr2.length-1)
					{
						text1 += "@";
						text2 += "@";
						text3 += "@";
					}
				}
				
				$("#a_g_code").val("");
				$("#a_g_code_price").val("");
				for (var i = 0; i < arr.length; i++)
				{
					if (i == goods_idx)
					{
						continue;	
					}
					if ($("#a_g_code").val() == "")
					{
						$("#a_g_code").val(acode[i]);
						$("#a_g_code_price").val(arr[i]);
					}
					else
					{
						$("#a_g_code").val($("#a_g_code").val() + "#" + acode[i]);	
						$("#a_g_code_price").val($("#a_g_code_price").val() + "#" + arr[i]);
					}
				}
			}
			
			$("#a_bgd_id").val(text1);
			$("#a_bgd_cnt").val(text2);
			$("#a_bgd_price").val(text3);
						
			$("[name='opt_total_amount']").eq(index).html(FormatNumber(parseInt(arr[goods_idx]) * parseInt(arr2[option_idx])));
			
			$("#pay_pay1").val($("#bb_price").val());
			
			price_con();
						
			if (type == "O")
			{
				$("#" + code + "_" + bbo_code).remove();
			}
			else
			{
				var index = $("[name='deal_row']").index($("#t_" + code));
								
				if (index == 0 && $("[name='td_data_img']").length > 1)
				{
					$("[name='td_data_img']").eq(0).parent().attr("id", $("[name='td_data_img']").eq(1).parent().attr("id"));
					$("[name='td_data_img']").eq(0).html($("[name='td_data_img']").eq(1).html());
					$("[name='td_data_option']").eq(0).html($("[name='td_data_option']").eq(1).html());
					$("[name='deal_row']").eq(1).remove();
				}
				else
				{
					$("#t_" + code).remove();	
				}
				
				if ($("[name='deal_row']").length == 0)
				{
					$("#cart_no_data").show();
					$("#div_calculate_area").hide();
					$("#btn_buy2").hide();
				}
			}
			
			
		}
		
		btn_buy = function()
		{
			$("#frm").submit();
		}
		
		btn_cancel = function()
		{
			alert("취소");
		}
		
		
		// 쿠폰
		coupon_ac = function()
		{
			window.open("pop_coupon", "pop_coupon", "width=400, height=490, toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=yes, left=300, top=200")
		}
		
		$("#sel_quick").change(function(){
			
			$("#pay_pay3").val($(this).val());
			
			if ($("#pay_pay3").val() == "0")
			{
				$("#d_type").hide();
			}
			else
			{
				$("#d_type").show();	
			}
			
			price_con();
		
		});
		
		
		price_con = function(){
			
			for (var i = 0; i < $("[name='opt_amount']").length; i++)
			{
				$("[name='opt_amount']").eq(i).html(FormatNumber($("[name='opt_amount']").eq(i).html()));
				$("[name='opt_total_amount']").eq(i).html(FormatNumber($("[name='opt_total_amount']").eq(i).html()));
			}

			$(".lpop_saving").hide();
			
			$("#pay_pay4").val(parseInt($("#pay_pay1").val()) - parseInt($("#pay_pay2").val()) + parseInt($("#pay_pay3").val()));
			
			for (var i = 0; i < $(".result_area").length; i++)
			{
				$(".result_area > em").eq(i).html(FormatNumber($("#pay_pay" + (i+1)).val()));
			}
			
			if ($("#pay_pay2").val() != 0)
			{
				$("#img_cp").attr("src", "/shop/resources/images/btn_coupon_c.png").attr("alt", "쿠폰변경");
				
				$(".saving_amounts").show();
				$(".saving_amounts").html("-<em>" + FormatNumber($("#pay_pay2").val()) + "</em>원");
				$("#cart_save_amount").html(FormatNumber($("#pay_pay2").val())).show();
				$(".lpop_saving").show();
			}
			else
			{
				$(".saving_amounts").hide();
				$("#img_cp").attr("src", "/shop/resources/images/btn_coupon.png").attr("alt", "쿠폰사용");
			}
			
			$("#bc_price").val($("#pay_pay2").val());
			
			$("#totalPay").html(FormatNumber($("#pay_pay4").val()));
			
			$("[name='deal_total_amount']").html(FormatNumber($("#bb_price").val()));
			
		}
		
		add_count = function(obj, gubun, code, option_idx, goods_idx)
		{
			var str = "", text = "";
			
			var goods_idx = $("[name='deal_row']").index($("#t_" + code));
			var option_idx = $("[name='deal_row']").eq(goods_idx).find("li").index($(obj).parent().parent().parent());
			var index = $("[name='opt_deal']").index($(obj).parent().parent().parent());
			
			var arr = $("#a_g_code_price").val().split("#");	// 상품별 가격
			var par_arr2 = $("#a_bgd_cnt").val().split("@");
			
			arr2 = par_arr2[goods_idx].split("#");
			
			if (gubun == "U")
			{
				arr2[option_idx] = parseInt(arr2[option_idx]) + 1;
				$("#bb_price").val(parseInt($("#bb_price").val()) + parseInt(arr[goods_idx]));
			}
			else
			{
				if (parseInt(arr2[option_idx]) <= 1)
				{
					arr2[option_idx] = 1;
				}
				else
				{
					arr2[option_idx] = parseInt(arr2[option_idx]) - 1;
					$("#bb_price").val(parseInt($("#bb_price").val()) - parseInt(arr[goods_idx]));
				}
			}
			
			$("[name='view_cnt']").eq(index).val(arr2[option_idx]);
			
			for (var i = 0; i < arr2.length; i++)
			{
				if (i == 0)
				{
					str += arr2[i];
				}
				else
				{
					str += "#" + arr2[i];
				}
			}

			for (var i = 0; i < par_arr2.length; i++)
			{
				if (i == goods_idx)
				{
					text += str;
				}
				else
				{
					text += par_arr2[i];
				}
				if (i != par_arr2.length-1)
				{
					text += "@";
				}
			}
			
			$("#a_bgd_cnt").val(text);
			
			$("[name='opt_total_amount']").eq(index).html(FormatNumber(parseInt(arr[goods_idx]) * parseInt(arr2[option_idx])));
			
			$("#pay_pay1").val($("#bb_price").val());
			
			price_con();

		}
		
		price_con();
		
	});

</script>    

<form id="frm" name="frm" method="post" action="pay">
<input type="hidden" id="prev_page" name="prev_page" value="cart" />
<input type="hidden" id="a_g_code" name="a_g_code" value="${bean.a_g_code}" />
<input type="hidden" id="a_g_code_price" name="a_g_code_price" value="${bean.a_g_code_price}" />
<input type="hidden" id="a_bgd_id" name="a_bgd_id" value="${bean.a_bgd_id}" />
<input type="hidden" id="a_bgd_cnt" name="a_bgd_cnt" value="${bean.a_bgd_cnt}" />
<input type="hidden" id="a_bgd_price" name="a_bgd_price" value="${bean.a_bgd_price}" />
<input type="hidden" id="bb_price" name="bb_price" value="${bean.bb_price }" />


<input type="hidden" id="pay_pay1" name="pay_pay1" value="${bean.bb_price }" /><br />
<input type="hidden" id="pay_pay2" name="pay_pay2" value="0" /><br />
<input type="hidden" id="pay_pay3" name="pay_pay3" value="2500" /><br />
<input type="hidden" id="pay_pay4" name="pay_pay4" value="0" /><br />

<input type="hidden" id="bc_id" name="bc_id" value="" /><br />
<input type="hidden" id="bc_price" name="bc_price" value="0" /><br />

<div class="cart_area">

        <div class="payment_step">
            <ul>
            <li class="step1"><strong class="on">1. 카트</strong><span class="subscription">구매하실 상품을 선택해 주세요.</span></li>
            <li class="step2"><span class="arr"></span><strong>2. 주문/결제</strong><span class="subscription">구매하실 상품을 결제해 주세요.</span></li>
            <li class="step3"><span class="arr"></span><strong>3. 결제완료</strong><span class="subscription">결제가 완료되었습니다.</span></li>
            </ul>
        </div>

        <table  summary="카트 리스트" class="tbl_cart" style="margin-top:30px">
    <caption>카트 리스트</caption>
    <colgroup>
        <col width="31"><col width="105"><col width="401"><col width="107"><col width="67"><col width="89"><col width="*">
    </colgroup>
    <thead>
        <tr>
            <th scope="col" class="check"></th>
            <th scope="col" class="thmb"><span class="hidden">딜 이미지</span></th>
            <th scope="col" class="deal_info">상품정보</th>
            <th scope="col" class="amounts">상품금액</th>
            <th scope="col" class="disc">할인</th>
            <th scope="col" class="delivery">배송</th>
        </tr>
    </thead>
    <tbody class="cart_tbody">
        ${bean.html_view }
		<tr class='empty' id="cart_no_data" style="display:none">
			<td colspan='7' align='center'>
				<p class='empty_msg'>카트에 담긴 상품이 없습니다.</p>
			</td>
		</tr>
    </tbody>
</table>
<c:if test="${bean.bb_cnt > 0}">
	<div id="div_calculate_area" class="calculate_area calculate_area_v2">
	    <div class="deal_price">
	        <div class="h_area"><strong>상품금액</strong></div>
	        <div class="result_area"><em id="total_amounts"></em><span class="won">원</span></div>
	    </div>
	    <span class="minus">-</span>
	    <div class="disc_price">
	        <div class="h_area">
	            <strong>할인금액</strong>
	            <div id="div_cartcoupon_apply" style="display:none">
	            <a style="cursor:pointer" id="btn_cartcoupon" class="btn_apply_coupon">카트쿠폰</a>
	            <div id="div_cartcoupon_noti" class="uio_ly_balloon" style="top:-42px;left:40px;z-index:999">
		            <div class="ly_cart_discount">
		                <span class="apply" id="span_cartcoupon_noti">카트쿠폰으로 <em class="emphasis">할인</em> 받으세요!</span>
		                <span class="arr"></span>
		            </div>
	            </div>
	            </div>
	        </div>
	        <div class="result_area"><em id="total_discount_amounts">0</em><span class="won">원</span></div>
	    </div>
	    <span class="plus">+</span>
	    <div class="delivery_price">
	        <div class="h_area"><strong>배송비</strong></div>
	        <div class="result_area"><em id="total_delivery_amounts"></em><span class="won">원</span></div>
	    </div>
	    <span class="equal">=</span>
	    <div class="payment_price">
	        <div class="h_area"><strong>결제 예정 금액</strong></div>
	        <div class="result_area"><em id="pay_amounts"></em><span class="won">원</span></div>
	        <div class="lpop_saving" style="top:19px;right:24px;display:none;">
	            총 절약금액: <em id="cart_save_amount">0</em>원
	            <span class="arr"></span>
	        </div>
	        <div class="benefit" id="div_cart_benefit_amount" style="display:none;">
	            <span class="tit">구매시 혜택</span>
	            <strong class="point">적립금 <span><em id="total_benefit_amounts">0</em>원</span> <a style="cursor:pointer" id="btn_benefit" class="btn_detail">상세보기</a></strong>
	        </div>
	    </div>
	</div>
</c:if>
<div class="btn_area" style="margin:52px 0 50px">
            <c:if test="${bean.bb_cnt > 0}">
            	<a style="cursor:pointer" id="btn_buy2" class="btn_buy btn_buy_cart" onclick="btn_buy(); return false;">구매하기</a>
            </c:if>
    
    <div class="in_layer">
        <a href="/shop/bs/user/shop/main" style="cursor:pointer" class="btn_retry">쇼핑 계속하기</a>
    </div>
</div>

<div id="div_guide_buywait" style="display:none">
    <div class="lpop_wrap2" style="top:44px;left:0">
        <div class="lpop_cont" style="padding:2px 33px 10px 20px;">
            <div class="caution_area">
                <ul>
                <li>대기 예약 상품 구매 시 매진된 상품 물량이 추가 입고 될 경우 대기자 순으로<br>자동 구매 확정되며 SMS로 구매확정 안내 메시지를 보내드립니다.</li>
                <li>추가입고가 없을 시 판매종료 7일후 (단, 토/일 공휴일 일 경우 직후 영업일)<br><span>일괄 환불처리</span> 됩니다.</li>
                </ul>
            </div>
        </div>
        <a style="cursor:pointer" class="buywait_guid_btn_close btn_clse">레이어 닫기</a>
    </div>
</div>

    </div>
</form>