<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form name="frm2" method="post">
<table class="tbl_full">
	<thead>
			<tr>
   					<th width="100">
   						진열 여부
   					</th>
   					<th width="100">
   						제품코드 
   					</th>
   					<th>
   						상품명
   					</th>
   					<th>
   						가격 
   					</th>
   					<th>
   						수량
   					</th>
   					<th>
   						등록일    <input type="hidden" name="beanArray" value="0">
   						
   					</th>
   				</tr>
</thead>
<tbody>

	<c:forEach items="${bean.data }"  var = "e" varStatus="no"> 
 	
 	<c:choose>
		<c:when test="${e.g_show_list =='Y'}">
			<tr>
   					<td width = "50px">
					 <input type="checkbox" name="beanArray" value="${e.g_code }" />
   					</td>
   					<td>
   						${e.g_code }
   					</td>
   					<td width="200px">
						  <a href="widget_detail?id=${e.g_code }" class="hong_click">${e.g_name }</a>
   					</td>
  					<td>
  						${e.g_price }
  					</td>
  					<td>
  						${e.g_num }
  					</td>
  					<td width="150">
  					  <fmt:formatDate value="${e.g_reg_day}" pattern="MM-dd HH:mm"/>
  					</td>
   				</tr>
		</c:when>
 	</c:choose> 		
   		</c:forEach>
  </tbody> 
 </table>
 </form>
  