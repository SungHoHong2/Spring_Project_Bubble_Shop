<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>


<script type="text/javascript">
    
    //setting detail 
	function ajaxRequest(urls, paramname, keywords, div)
	{
		   $.ajax({
			    	  type:"GET"
			    	  ,async : true
			          , url : urls
			          , dataType : "html"
			          , data : paramname+"="+ encodeURIComponent(keywords) 
			          , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			   		  , success : function(response, status, request) {          
					 
					  $(div).html('');
				      $(div).animate({height : '0px'},0);	
				      
			   	      $(div).append(response);		  
			   		  var heights = $('#hong_detail_table2').height();	   
					  $(div).animate({height : heights},500);	
					  
					  $('#hong_fix_input').click(function(){
							document.frmchange.submit();
					  });
					  
					  $('#hong_fix_delete').click(function(){
							$('#formchanging').attr('action','distribute_coupons_delete');	
							document.frmchange.submit();
					  });
			   	}
		   });
	}

	$(document).ready(function(){
		$('.hong_fixz').click(function(){
			var text  = $(this).attr('value');
			ajaxRequest('bs_coupon_detail', 'keyword', text, '.hong_detail');
		});
		
		$('.findid').click(function(){
			var getid = $(this).attr('value');
			ajaxRequest('reg_member_detail2', 'memberid', getid, '.hong_detail');
		});

		
	});
	
</script>

<style>
	.hong_fix{
		background : #3fadf7;
		width : 100px;
		height : 30px;
		display : block;
	}

	.hong_detail{
	 background :#3fadf7;
	 height : 5px;
	}



/* exit button */
.hong_exit2{
	width : 0px;
	float : left;
	position : relative;
}

.hong_delete2{
	width : 0px;
	float : left;
	left : 50px;
	position : relative;
	
}

.hong_fix2{
	width : 0px;
	float : left;
	left : 100px;
	position : relative;
}

#wrap_buttons2{
	left : 365px;	
	position : relative;
}

</style>

<div class="hong_title">
쿠폰 보유 현황
</div>
 
<div class="hong_template">
<div class="hong_detail">
</div>
 <table class="tbl_full">
 <thead>
 	<tr>
 	<th>
 	 배포 관리자
 	</th>
 	<th>
 	 쿠폰 번호
 	</th>
 	<th>
 	 등록 날짜 
 	</th>
 	<th colspan="2">
 	 사용 날짜
 	</th>
 	<th>
 	 쿠폰 가격
 	</th>
 	<th>
 	 수정 여부
 	</th>
 	</tr>
 </thead>
 <tbody>
 <c:forEach items="${bean.data }" var="e" varStatus="no">
 	<tr>
 		<td>
 			<button class="findid" value="${e.bs_id }">${e.bs_id }</button>
 		</td>
 		<td>
 			${e.bc_id }			
 		</td>
 		<td>
 		<fmt:formatDate value="${e.bc_reg_date}" pattern="MM-dd HH:mm"/>
 		</td>
  		<td>
  		 <fmt:formatDate value="${e.bc_start_date }" pattern="MM-dd HH:mm"/>	
 		</td>
 		<td>
  		 <fmt:formatDate value="${e.bc_end_date }" pattern="MM-dd HH:mm"/>	
 		</td>
 		  <td>
 			${e.bc_price }
 		</td>
 		<td width="100px">
 			<span class="hong_fixz" value="${e.bc_id }">수정 하기</span>
 		</td>
 	</tr>
  </c:forEach>
 	
 </tbody>
 </table>
</div>