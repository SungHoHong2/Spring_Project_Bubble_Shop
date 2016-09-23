<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<script type="text/javascript">
	$(document).ready(function(){		  
		  $.ajax({
	           type:"GET"
	           ,async : true
	              , url : "reg_detail_purchase_detail"
	              , dataType : "html"
	              , data : "idtest=" + encodeURIComponent($('#goodkey').attr('value')) 
	              , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	           	  , success : function(response, status, request) {          
	           
	           		 $('#inputz').append(response);	           		 
	           		 var heights2 = $('#hong_detail_table').height();
	           		 $('#getdetail').animate({height: heights2},500);
	           }
	      });
	});
</script>
		 

<table class="tbl_full" id="hong_detail_table">
	<thead>
		<tr>
			<th colspan="4">
				<div class = "hong_exit">
   					<span class="button large neutral">접기</span>
   				</div>	
			</th>
		</tr>
	</thead>
	<tbody>
	<tr bgcolor="#efefef">
		<td>
			재고
		</td>
		<td>
		    제품 색상
		</td>
		<td>
		    제품 크기
		</td>
		<td>
		    구매 수량
		</td>
	</tr>
	<c:forEach items="${bean.data }" var="e">
	<input type="hidden" id="goodkey" value="${e.g_code }"> 
		<tr>
		<td>
				 ${e.bgd_cnt }   
		</td>
		<td>
				 ${e.bgd_color }
		</td>
		<td>
		 		${e.bgd_size }
		</td>	 
		<td>
				${e.bpd_cnt }
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4">
		<div id="inputz"></div>
		</td>
	</tr>
	</tbody>
</table>
		