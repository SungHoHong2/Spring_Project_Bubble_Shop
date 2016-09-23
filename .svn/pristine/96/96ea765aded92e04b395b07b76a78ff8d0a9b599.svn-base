<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${bean.data }" var ="e"></c:set>

<form id="formchanging" name="frmchange" method="post" action="bs_coupon_detail_fix">
<table class="tbl_full" id="hong_detail_table2">
<thead>
<tr>
 	<th>
 	 소유 회원
 	</th>
 	<th>
 	 쿠폰 번호
 	</th>
 	<th>
 	 등록 날짜 
 	</th>
 	<th colspan="2">
 	 사용 날짜
 	</th>
 	<th>
 	 쿠폰 가격
 	</th>
 	<th>
 	 수정 여부
 	</th>
 	<th>
 	 삭제 여부
 	</th>
 	</tr>
</thead>
<tbody>
<tr>
 		<td>
 		   ${e.bs_id }
 		</td>
 		<td>
 			${e.bc_id}	<input type="hidden" name="bc_id" value="${e.bc_id}">
 		</td>
 		<td>
 			  <fmt:formatDate value="${e.bc_reg_date}" pattern="MM-dd HH:mm"/>
 		</td>
  		<td>
 			  <input type="date" name="bc_start_date_before" size="8">
 		</td>
 		<td>
 			  <input type="date" name="bc_end_date_before" size="8">
 		</td>
 		<td>
 		    <input type="text" name="bc_price" value="${e.bc_price }" size="5">			
 		</td>
 		<td width="100px">
			<span class="button positive large" id="hong_fix_input">수정</span> 				
 		</td>
 		<td width="100px">
 			<span class="button negative large" id="hong_fix_delete">삭제</span>
 		</td>
 	</tr>
</tbody>
</table>
</form>