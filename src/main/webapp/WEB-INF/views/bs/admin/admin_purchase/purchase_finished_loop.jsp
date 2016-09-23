<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="../../../resources/js/common.js"></script>
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		var start = $('#start').attr('value');
		var end= $('#end').attr('value');
		var totalSum=0;
		var Sum=0;
		  $.ajax({
	           type:"GET"
	           ,async : true
	              , url : "purchase_finished_total"
	              , dataType : "html"
	              , data : "startids=" + encodeURIComponent(start)+"&endids="+ encodeURIComponent(end) 
	              , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	              , success : function(response, status, request) {        	        	   	            	  
	            	 $('#output').attr('value',response);
	            	  
	         		 totalSum=$('#output').attr('value');
	         		 
	         		 for(var i=0; i<totalSum; i++)
	         		 Sum+=new Number($('.pricing_'+i).attr('id'));
	         		
	         		 var buffing = "매출액 : ￦"+FormatNumber(Sum);
	         		 $('#outputingz').append(buffing);
	           }
		  });
		


		
	});
</script>

<style>
.hong_template{
 padding : 20px;
 width : 800px;
 margin:0 auto;
}

.hong_title{
 padding-top : 40px;
 width : 800px;
 margin:0 auto;
 color : blue;
 font-size : 20px; 
}


.sum_title{
 padding : 20px;
 width : 800px;
 margin:0 auto;
 color : blue;
 font-size : 20px; 
}
</style>

	<input id="output" type="hidden" value="">
	<input id="start" type="hidden" value="${bean.bq_reg_date_start_string }">
	<input id="end" type="hidden" value="${bean.bq_reg_date_end_string }">

<div class="hong_title">
	<div>매출 현황</div>
	<div>
	<form action="purchase_finished_loop" method="post">
	<input type="date" name="bq_reg_date_start_string"> ~ <input type="date" name="bq_reg_date_end_string">
	<button value="검색">검색</button>
	</form>
	</div>
</div>
<div class="hong_template">
	<div id="getdetail">
	</div>
	<table class="tbl_full">
	<thead>
		<tr>
			<th width="100px">
				구매 번호
			</th>
			<th>
				주문 고객 
			</th>
			<th>
				결제 방식
			</th>
			<th>
				결제 금액
			</th>
			<th>
				구매 개수
			</th>
			<th>
				요청 날짜	
			</th>
			<th width="100px">
			    쿠폰 사용
			</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${bean.data }" var="e" varStatus="no"> 
		<tr>
			<td>
				${e.bp_id } 		
			</td>
			<td>
			<c:choose>
					<c:when test="${e.bs_id==0}">
					비회원	
					</c:when>
					<c:otherwise>
					회원		
					</c:otherwise>
			</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${e.bp_price_type==1 }">					
						신용카드		
					</c:when>
					<c:when test="${e.bp_price_type==2 }">
						무통장입금
					</c:when>
				</c:choose>
			</td>
			<td>
			 <div class="pricing_${no.index }" id="${e.bp_price }">${e.bp_price }</div>
			</td>
			<td>
				${e.bp_cnt }
			</td>	
			<td>
			 <fmt:formatDate value="${e.bp_reg_date }" pattern="MM-dd HH:mm"/>
			</td>		
			<td>
			 ${e.bp_coupon_price }
			</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7">
		<div class="sum_title" id="outputingz">
		</div>
		</td>
	</tr>
	</tbody>
	
	</table>
	</div>
	
		