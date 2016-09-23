<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="tbl_full" id="tablesheight">
	<thead>
		<tr>
			<th>
				BP_ID
			</th>
			<th>
				BP_WIN_YN
			</th>
			<th>
				BP_REG_DATE
			</th>
			<th>
				BE_ID
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
				${e.bp_id }
			</td>
			<td>
				${e.be_win_yn }
			</td>
			<td>
				${e.bp_reg_date }
			</td>
			<td>
				${e.be_id }
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