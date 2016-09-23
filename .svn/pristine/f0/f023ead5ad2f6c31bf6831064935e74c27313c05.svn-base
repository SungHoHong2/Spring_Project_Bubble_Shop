<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table id="hong_table2" class="tbl_full">
<thead>
	<tr>
		<th>
			BG_REG_DATE
		</th>
		<th>
			BQ_STATUS
		</th>
		<th>
			BQ_1
		</th>
		<th>
			 BQ_CODE
		</th>
	</tr>
</thead>

<c:forEach items="${bean.data }" var="e">
	<tr>
		<td>
			 <fmt:formatDate value="${e.bq_reg_date }" pattern="MM-dd HH:mm"/>
		</td>
		<td>
			${e.bq_status }
		</td>
		<td>
			${e.bq_id }
		</td>
		<td>
			${e.bq_code }
		</td>
	</tr>
</c:forEach>
</table>