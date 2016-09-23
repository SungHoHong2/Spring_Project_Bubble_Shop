<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form name="quickform" action="changequick" method="post">
<table id="hong_table3" class="tbl_full">
<thead>
	<tr>
		<th>
			주문 날짜 
		</th>
		<th colspan="4">
			수령 여부
		</th>
		<th>
		    수령 번호
		</th>
		<th>
			상태 변경
		</th>
	</tr>
</thead>

<c:forEach items="${bean.data }" var="e">
	<tr>
		<td>
		     <input type="hidden" value="${e.bq_id }" name="bq_id">
			 <fmt:formatDate value="${e.bq_reg_date }" pattern="MM-dd HH:mm"/>
		</td>		
		<c:choose>
			<c:when test="${e.bq_status=='0' }">
		    		<td bgcolor="#5dc434">
		    		 수령 전 
		    		</td>
		    		<td bgcolor="#5dc434">
		    		<input type="radio" value="0" name="bq_status" checked>
		    		</td>
		    		<td>
		    		 수령 후 
		    		</td>
		    		<td>
		    		<input type="radio" value="3" name="bq_status">
		    		</td>
			</c:when>
		</c:choose>
		<td>
			${e.bq_id }
		</td>
		<td>
			<span id="button_quickform" class="button large positive">수정 완료</span>
		</td>
	</tr>
</c:forEach>
</table>
</form>