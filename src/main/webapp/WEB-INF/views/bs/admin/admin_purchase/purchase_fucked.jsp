<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="hong_title">
주문 취소
</div>

<div class="hong_template">
	<div id="getdetail">
	</div>
	<div class="scrolldiv">
	<table class="tbl_full">
	<thead>
		<tr>
			<th>
				구매 번호
			</th>
			<th>
				주문 고객 
			</th>
			<th>
				결제 방식
			</th>
			<th>
				지불 액수
			</th>
			<th>
				요청 날짜	
			</th>
			<th>
				구매 개수
			</th>
			<th>
				주문 상황
			</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${bean.data }" var="e" varStatus="no"> 
	
		<tr class="${e.bq_id }" id="table_select_${no.index }" bgcolor="">
			<td>
				<button class="reg_detail" value="${e.bp_id }" id="select_${no.index }">${e.bp_id }</button> 		
			</td>
			<td>
				<button class="getBsmember" value="${e.bs_id }" id="select_${no.index }">${e.bs_id }</button>		
			</td>
			<td>
				<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">${e.bp_price_type }</span>
			</td>
			<td>
				<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">${e.bp_price }</span>
			</td>
			<td>
			 <fmt:formatDate value="${e.bp_reg_date }" pattern="MM-dd HH:mm"/>
			</td>
			<td>
				<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">${e.bp_cnt }</span>
			</td>
				<c:choose>
					<c:when test="${e.bp_status=='y'}">
					<td>
						<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">지불 </span>
					</td>
					</c:when>
					<c:otherwise>
					<td bgcolor="#FFD3D3">
						<span class="deleteaction" value="${e.bp_id }" id="select_${no.index }">주문 취소</span>
					</td>
					</c:otherwise>
				</c:choose>				
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</div>