<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="tbl_full" id="tablesheight">
	<thead>
		<tr>
			<th>
				BS_ID
			</th>
			<th>
				BP_ID
			</th>
			<th>
				BP_PRICE
			</th>
			<th>
				G_CODE
			</th>
			<th>
				BP_REG_DATE
			</th>
			<th>
			    BP_CNT
			</th>
			<th>
				BP_STATUS
			</th>
			<th>
				BQ_ID
			</th>
			<th>
				BP_PRICE
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
				${e.bs_id }
			</td>
			<td>
				${e.bp_id }
			</td>
			<td>
				${e.bp_price }
			</td>
			<td>
				${e.g_code }
			</td>
			<td>
				${e.bp_reg_date }
			</td>
			<td>
				${e.bp_cnt }
			</td>
			<td>
				${e.bp_status }
			</td>
			<td>
				${e.bq_id }
			</td>
			<td>
				${e.bp_price }
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