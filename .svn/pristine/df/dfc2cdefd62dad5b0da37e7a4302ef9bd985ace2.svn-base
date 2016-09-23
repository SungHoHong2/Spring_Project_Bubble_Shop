<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<table class="tbl_full" id="individual_table">
	 	<thead>
				<tr>
					<th>
						선택 	
					</th>
					<th>
						사용자 ID
					</th>
					<th>
						전화번호 
					</th>
					<th>
						이름
					</th>
					<th>
						비밀번호
					</th>
					<th>
						가입날짜 
					</th>
					<th>
						E-Mail
					</th>
					<th>
						수신여부 
					</th>
				</tr>
			</thead>
		<tbody>
			<c:forEach items="${bean.data }" var="e" varStatus ="no">
				<tr>
					<td>
					<input type="checkbox" name="list[${no.index }].bs_id" value="${e.bs_id }">
					<input type="hidden" class="bc_price" name="list[${no.index}].bc_price" value="">
					<input type="hidden" class="bc_start_date_before" name="list[${no.index }].bc_start_date_before" value="">
					<input type="hidden" class="bc_end_date_before" name="list[${no.index }].bc_end_date_before" value="">
					</td>
					<td>
					 <span class="hong_click" id='${e.bs_id }'>${e.bs_userid }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_hp }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_name }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_pwd }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'><fmt:formatDate value="${e.bs_reg_date }" pattern="MM-dd HH:mm"/>
					</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_email }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_email_yn }</span>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
				<c:if test="${bean.startPage>1 }">
      			<a href="?page=${1 }"> << </a>
    
    			<a href="?page=${bean.startPage-1}"> <- </a>
     			</c:if>
     			<c:forEach begin="${bean.startPage }" end="${bean.endPage }" var="i">
     			<c:choose>
       			<c:when test="${i==bean.page }">
        		<font color="#ff0000">[${i }]</font> 
       			</c:when>
       			<c:otherwise>
          		<a href="?page=${i}">${i}</a>
       			</c:otherwise>
      			</c:choose>
    
       			</c:forEach>
       			<c:if test="${bean.endPage<bean.totalPage }">
        		<a href="?page=${bean.endPage+1}"> -> </a>
        		<a href="?page=${bean.totalPage}"> -> </a>
       			</c:if>
				</td>
			</tr>	
 		</tbody>
</table>
 