<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

	$(document).ready(function(){
		
		for (var i = 0; i < $("[name='p_sum']").length; i++)
		{
			$("[name='p_sum']").eq(i).html(FormatNumber($("[name='p_sum']").eq(i).html()));
		}

	});

</script>


<div class="cart_area">
                <div class="payment_step">
            <ul>
            <li class="step1"><strong class="">1. 카트</strong><span class="subscription">구매하실 상품을 선택해 주세요.</span></li>
            <li class="step2"><span class="arr"></span><strong class="">2. 주문/결제</strong><span class="subscription">구매하실 상품을 결제해 주세요.</span></li>
            <li class="step3"><span class="arr"></span><strong class="on">3. 결제완료</strong><span class="subscription">결제가 완료되었습니다.</span></li>
            </ul>
        </div>
        <div class="order_complate_area">
            <h3 class="title2">주문이 정상적으로 접수되었습니다.</h3>
            <c:if test="${bean.bp_price_type == 2 }">
	            <table class="tb_accout">
	            <caption>입급하실 계좌 정보</caption>
	            <colgroup>
	            <col width="181"><col>
	            </colgroup>
	            <tbody>
	            <tr>
	            <th scope="row"><span>입금하실 금액</span></th>
	            <td><strong class="sum"><em name="p_sum">${bean.bp_price }</em>원</strong></td>
	            </tr>
	            <tr>
	            <th scope="row"><span>입금은행</span></th>
	            <td>국민은행</td>
	            </tr>
	            <tr>
	            <th scope="row"><span>입금계좌</span></th>
	            <td>049-40-19023462 (예금주: B_Shop)</td>
	            </tr>
	            </tbody>
	            </table>
			</c:if>
            <table summary="결제완료정보" class="tb_order_price">
            <caption>결제완료정보</caption>
            <colgroup>
                <col width="181"><col width="115"><col>
            </colgroup>
            <tbody>
                <tr class="total">
                                <th scope="row" rowspan="3"><span class="order_num">주문번호</span>${bean.bg_code }</th>
                    <td class="tit"><span class="h_total">총 결제 금액</span></td>
                    <td class="price">
                        <c:if test="${bean.bc_price > 0}">
                        <div class="lpop_saving">
                            총 절약금액: <em name="p_sum">${bean.bc_price }</em>원
                            <span class="arr_rgt"></span>
                        </div>
                        </c:if>
                        <em name="p_sum">${bean.bp_price }</em><span class="won">원</span>
                    </td>
                </tr>
                <tr class="payment" style="display:none">
                    <td class="tit"><span>무통장입금</span></td>
                    <td class="price"><em>23,900</em>원</td>
                </tr>

            </tbody>
            </table>
            <p class="order_dsc"><span class="bu">·</span> 자세한 구매내역 확인 및 문자발송, 배송지 변경 등의 서비스는 사이트 우측 상단의 <strong>마이페이지&gt;구매내역</strong>에서 이용 가능합니다.</p>
            <p class="order_dsc2"><span class="bu">·</span> 입금하실 해당 은행을 확인하시고 입금해 주세요. 입금 확인되면 주문이 정상적으로 처리됩니다.</p>

         </div>
         
         <div class="btn_section">
            <a href="/user/buyInfo" class="btn_confirm">구매/예약/예매내역 확인</a>
            <a href="/shop/bs/user/shop/main" class="btn_continue">쇼핑 계속하기</a>
         </div>
            
</div>            
          