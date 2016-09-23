<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="tbl_full" id="tablesheight">
	<thead>
		<tr>
			<th>
				BB_ID
			</th>
			<th>
				G_CODE
			</th>
			<th>
				BB_CNT
			</th>
			<th>
				BB_PRICE
			</th>
			<th>
				수정
			</th>
			<th>
			    삭제
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${bean.data }" var="e">
		<tr>
			<td>
				${e.bb_id }
			</td>
			<td>
				${e.g_code }
			</td>
			<td>
				${e.bb_cnt }
			</td>
			<td>
				${e.bb_price }
			</td>
			<td>
				<span class="button neutral large">수정</span>
			</td>
			<td>
				<span class="button negative large">삭제</span>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>