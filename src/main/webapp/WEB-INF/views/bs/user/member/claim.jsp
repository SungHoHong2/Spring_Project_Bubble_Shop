<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_container"> 
        <ul class="mypage_category" >
            <li class="menu1"><a href="/shop/bs/user/member/buyInfo"><span class="name">구매내역</span></a>
            </li> 
            <li class="menu2 on"><a href="/shop/bs/user/member/claim"><span class="name">취소,환불 내역</span></a></li>
            <li class="menu3"><a href="/shop/bs/user/member/coupon"><span class="name">할인쿠폰</span></a>
                </li>
            <li class="menu9"><a href="/shop/bs/user/member/userInfo"><span class="name">개인정보</span></a></li>
         </ul>   
    <h3 class="hidden">취소·환불 내역</h3>
    <div class="date_control" style="margin-top:20px">
        <ul class="date_lst">
	        <li class="all"><a href="">전체</a></li>
	        <li class="month3"><a href="" class="on">3개월</a></li>
	        <li class="month6"><a href="">6개월</a></li>
	        <li class="year1"><a href="">1년</a></li>
        </ul>
    </div>
    <div class="buy_lst">
        <table >
            <caption>취소·환불내역</caption>
            <colgroup><col width="170"><col><col width="121"><col width="139">
            </colgroup><thead>
                <tr>
                    <th scope="colgroup" colspan="2">취소·환불내역</th>
                    <th scope="col">환불금액</th>
                    <th scope="col">상태</th>
                </tr>
            </thead>
            <tbody>
            <!-- 없을 떄 -->
                <tr style="display:none">
	                <td colspan="4" class="none_lst">
	                    <strong>취소·환불내역이 없습니다.</strong>
	                </td>
                </tr>
            <!-- 있을 때 -->
            	<tr>
                    <th scope="rowgroup" class="deal_info" rowspan="1">
                        <div class="date_num">
                            <p>요 청 일 : <strong>2014.05.30</strong></p>
                        </div>
                    </th>
                    <th class="sum_up bundle_line">
                        <div class="thmb_area">
                            <a href="" ><img src="" alt="구매상품 썸네일" class="thmb" width="106" height="71"></a>
                            <h4>
                                <a href="" >[아베홀리] 여름 경품이벤트!</a>
                            </h4>
                        </div>
                        <ul class="ticket_lst">
	                        <li>
	                            <div class="tit">
	                                <strong>01-03)홀리스터 여자 나시_실버 PINK|M</strong>
	                                <p>(취소환불 <em>1</em>개<span class="bar">&nbsp;</span><em>16,900</em>원)</p>
	                            </div>
	                        </li>
                        </ul>
                    </th>
                    <td class="cncl_price bundle_line" rowspan="1">
                    	<em>0</em>원
                    </td>
                    <td class="expiry bundle_line">
                        <p class="delivery_condition" style="text-align:center;">
                            <strong>미입금 취소완료</strong>
                            <span class="date">
                            	2014.05.30                                
                            </span>
                        </p>
                    </td>
                </tr>
        	</tbody>
        </table>
      </div>
    </div>