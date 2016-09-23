<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mypage_container"> 
        <ul class="mypage_category" >
            <li class="menu1"><a href="/shop/bs/user/member/buyInfo"><span class="name">구매내역</span></a></li> 
            <li class="menu2"><a href="/shop/bs/user/member/claim"><span class="name">취소,환불 내역</span></a></li>
            <li class="menu3 on"><a href="/shop/bs/user/member/coupon"><span class="name">할인쿠폰</span></a></li>
            <li class="menu9"><a href="/shop/bs/user/member/userInfo"><span class="name">개인정보</span></a></li>
         </ul>
<div class="option_area">
    <select id="coupon_orderby">
    <option value="c" selected="selected">사용 가능 쿠폰</option>
    <option value="e">기간 만료 쿠폰</option>
    <option value="u">사용 쿠폰 내역</option>
    </select>
</div>

<div class="tb_coupon_wrap serviceable" id="div_c">
    <table >
    <caption>쿠폰 내역</caption>
	    <colgroup>
	    	<col width="26%">
	    	<col width="11%">
	    	<col width="14%">
	    	<col width="19%">
	    	<col width="30%">
	    </colgroup>
    <thead>
    <tr>
    <th scope="col">쿠폰이름</th>
    <th scope="col">할인액/율</th>
    <th scope="col">적용기준</th>
    <th scope="col">적용대상</th>
    <th scope="col">유효기간</th>
    </tr>
    </thead>
    <tbody>
    	<c:set var="cntData" value="0" />
		<c:forEach items="${bean.coupon}" var="coupons">
			<c:if test="${coupons.bmc_status=='N' && coupons.bc_end_date>bean.newDate}">
				<c:set var="cntData" value="${cntData+1}" />
				<tr>
					<td><span><fmt:formatNumber type="number" maxFractionDigits="3" value="${coupons.bc_price}" />원 쿠폰</span></td>
					<td class="discount"><span><em><fmt:formatNumber type="number" maxFractionDigits="3" value="${coupons.bc_price}" />원 </em></span>할인</td>
					<td> - </td>
					<td> - </td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${coupons.bc_end_date}" />까지 사용 가능</td>
				</tr>
			</c:if>
		</c:forEach>
		<c:if test="${cntData==0}">
			<tr>
	    		<td colspan="5" class="coupon_no">보유한 <strong>할인 쿠폰 내역</strong>이 없습니다.</td>
	    	</tr>
		</c:if>    	
    </tbody>
    </table>
</div>

<div class="tb_coupon_wrap unserviceable" id="div_e" style="display:none;">
    <table >
    <caption>쿠폰 내역</caption>
	    <colgroup>
	    	<col width="26%">
	    	<col width="11%">
	    	<col width="14%">
	    	<col width="19%">
	    	<col width="30%">
	    </colgroup>
    <thead>
    <tr>
    <th scope="col">쿠폰이름</th>
    <th scope="col">할인액/율</th>
    <th scope="col">적용기준</th>
    <th scope="col">적용대상</th>
    <th scope="col">만료일</th>
    </tr>
    </thead>
    <tbody>
    	<c:set var="cntData" value="0" />
		<c:forEach items="${bean.coupon}" var="coupons">
			<c:if test="${coupons.bmc_status=='N' && coupons.bc_end_date<bean.newDate}">
				<c:set var="cntData" value="${cntData+1}" />
				<tr>
					<td><span><fmt:formatNumber type="number" maxFractionDigits="3" value="${coupons.bc_price}" />원 쿠폰</span></td>
					<td class="discount"><span><em><fmt:formatNumber type="number" maxFractionDigits="3" value="${coupons.bc_price}" />원 </em></span>할인</td>
					<td> - </td>
					<td> - </td>
					<td>만료일 : <fmt:formatDate pattern="yyyy-MM-dd" value="${coupons.bc_end_date}" /></td>
				</tr>
			</c:if>
		</c:forEach>
		<c:if test="${cntData==0}">
			<tr>
	    		<td colspan="5" class="coupon_no">보유한 <strong>할인 쿠폰 내역</strong>이 없습니다.</td>
	    	</tr>
		</c:if>    	
    </tbody>
    </table>
</div>
<div class="tb_coupon_wrap serviceused" id="div_u" style="display:none;">
    <table >
    <caption>쿠폰 내역</caption>
	    <colgroup>
	    	<col width="26%">
	    	<col width="11%">
	    	<col width="14%">
	    	<col width="19%">
	    	<col width="30%">
	    </colgroup>
    <thead>
    <tr>
    <th scope="col">쿠폰이름</th>
    <th scope="col">할인액/율</th>
    <th scope="col">적용기준</th>
    <th scope="col">적용대상</th>
    <th scope="col">사용일</th>
    </tr>
    </thead>
    <tbody>
    	<c:set var="cntData" value="0" />
		<c:forEach items="${bean.coupon}" var="coupons">
			<c:if test="${coupons.bmc_status=='Y'}">
				<c:set var="cntData" value="${cntData+1}" />
				<tr>
					<td><span><fmt:formatNumber type="number" maxFractionDigits="3" value="${coupons.bc_price}" />원 쿠폰</span></td>
					<td class="discount"><span><em><fmt:formatNumber type="number" maxFractionDigits="3" value="${coupons.bc_price}" />원 </em></span>할인</td>
					<td> - </td>
					<td> - </td>
					<td>사용일 : <fmt:formatDate pattern="yyyy-MM-dd" value="${coupons.bmc_use_date}" /></td>
				</tr>
			</c:if>
		</c:forEach>
		<c:if test="${cntData==0}">
			<tr>
	    		<td colspan="5" class="coupon_no">보유한 <strong>할인 쿠폰 내역</strong>이 없습니다.</td>
	    	</tr>
		</c:if>    	
    </tbody>
    </table>
</div>
<script type="text/javascript">
	$("#coupon_orderby").change(function(){
		$(".tb_coupon_wrap").hide();
		$("#div_"+$(this).val()).show();
		
	});
</script>
<ul class="coupon_guide_lst">
<li><span>&amp;midde1e0e4ot;</span>할인쿠폰은 상품 단위로 적용됩니다. 사용 제한 조건도 상품 단위의 상품금액 기준으로 적용됩니다.</li>
<li><span>·</span>주문 후 거래 취소 시 할인쿠폰 조건에 따라 할인쿠폰 혜택이 회수될 수 있습니다.</li>
<li><span>·</span>거래 취소 시 사용기간이 남아 있을 경우 쿠폰에 따라 다시 돌려드립니다.</li>
<li><span>·</span>일부 상품의 경우, 할인쿠폰 적용 대상에서 제외될 수 있습니다.</li>
</ul>
</div>