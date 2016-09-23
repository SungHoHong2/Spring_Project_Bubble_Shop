<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${bean.data }" var ="e"/>

	<table class="tbl_full" id="hong_detail_table">
	<thead>
		<tr>
			<th>
				고유 ID
			</th>
			<th>
				사용자 ID 
			</th>
			<th>
				전화번호
			</th>
			<th colspan="2">
			<div id="wrap_buttons">			 
			<div class = "hong_exit">
        		<span class="button large neutral">접기</span>
       		</div> 
       		<div class="hong_delete">
        		<span class="button large negative" id="delete_button" name="${e.bs_id }">삭제</span>
       		</div>
       		<div class="hong_fix">
        		<span class="button large positive" id="fix_button" name="${e.bs_id }">수정</span>
       		</div>
       		</div>	
       		</th>
		</tr>
	</thead>
	<tbody>	
		<tr>
			<td>
				${e.bs_id }
			</td>
			<td>
				${e.bs_userid }
			</td>
			<td>
				${e.bs_hp }
			</td>
			<td>
				${e.bs_reg_date }
			</td>
			<!-- extra menu  -->
			
			<td rowspan="9" width="200px">
			<div id="wraplargebutton">	
				<div class="hong_button" id="bs_participant" name="${e.bs_id }">참여행사 내역</div>
				<div class="hong_button2" id="bs_basket" name="${e.bs_id }">장바구니 내역</div>
				<div class="hong_button"id="bs_purchase" name="${e.bs_id }">구매 내역</div>
				<div class="hong_button2" id="bs_refund" name="${e.bs_id }">BS_Refund</div>
				<div class="hong_button" id="bs_mycoupon" name="${e.bs_id }">BS_MyCoupon</div>
				<div class="hong_button2" id="bs_user_comments" name="${e.bs_id }">BS_User_Comments</div>
				<div class="hong_button" id="bs_board_comments" name="${e.bs_id }">BS_Board_Comments</div>
				<div class="hong_button2" id="bs_shop_notice" name="${e.bs_id }">BS_Shop_notice</div>
				<div class="hong_button" id="bs_address" name="${e.bs_id }">BS_Address</div>
				<div class="hong_button2" id="bs_boardlist" name="${e.bs_id }">BS_Boardlist</div>
			</div>
			
			</td>
			
			<!-- extra menu end -->
			
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
			주소
		</td>
		<td colspan="2">
			${e.bs_address }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
			상세 주소 
		</td>
		<td colspan="2">
			${e.bs_address2 }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	이름  
		</td>
		<td colspan="2">
			${e.bs_name }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	비밀번호  
		</td>
		<td colspan="2">
			${e.bs_pwd }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	가입날짜   
		</td>
		<td colspan="2">
		<fmt:formatDate value="${e.bs_reg_date }" pattern="MM-dd HH:mm"/>
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		  이메일   
		</td>
		<td colspan="2">
			${e.bs_email }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	메일 수신 여부    
		</td>
		<td colspan="2">
			${e.bs_email_yn }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	SNS 수신 여부   
		</td>
		<td colspan="2">
			${e.bs_sms_yn }
		</td>
		</tr>
		
	</tbody>
	</table>


