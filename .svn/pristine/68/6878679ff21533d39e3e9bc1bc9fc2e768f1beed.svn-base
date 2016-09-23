<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="tbl_full" id="tablesheight">
	<thead>
		<tr>
			<th>
				BR_ID
			</th>
			<th>
				BR_REG_DATE
			</th>
			<th>
				BR_CNT
			</th>
			<th>
				G_CODE
			</th>
			<th>
				BS_ID
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
				${e.br_id }
			</td>
			<td>
				${e.br_reg_date }
			</td>
			<td>
				${e.br_cnt }
			</td>
			<td>
				${e.g_code }
			</td>
			<td>
				${e.bs_id }
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