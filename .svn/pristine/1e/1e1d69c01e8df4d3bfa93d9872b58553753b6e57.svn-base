<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <tr>
 	<td>등록된 종류</td>
	<td colspan="2">
	<table width="100%">
	<thead>
		<tr>
			<th width="166"> 
			 	크기
			</th>
			<th width="171">
			    색상
			</th>
			<th>
			    개수
			</th>
			<th width="100px">
				삭제
			</th>
		</tr>
	</thead>
	<tbody>
	   <c:forEach items="${bean.data }" var="e">
		<tr>
			<td>			
					${e.bgd_size }
			</td>
			<td>
					${e.bgd_color }
			
			</td>
			<td>
					${e.bgd_cnt }
			</td>
			<td>
					<span class="kill_good_detail" id="${e.bgd_id }" name="${e.bgd_id }">삭제</span>
			</td>
		</tr>
	   </c:forEach>
	</tbody>
	
	</table>
	
	</td>
 </tr>



    
