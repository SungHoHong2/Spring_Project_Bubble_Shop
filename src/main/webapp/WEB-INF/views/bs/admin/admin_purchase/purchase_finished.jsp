<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="../../../resources/js/common.js"></script>
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
    
	function getColorful(FruitLoops, buffing)
	{
		var s=0;
		for(var i=0; i<=buffing.innerHTML; i++)
		{
			if(s<4)
			{
				$('.'+i).attr('bgcolor',FruitLoops[s]);
				s++;
			}
			
			else
			{
				s=0;
				$('.'+i).attr('bgcolor',FruitLoops[s]);
			}
		}	
	}
	
	function AjaxRequest(urls, ids, datas, detail, tableid, FruitLoops, buffing, exit)
	{
		 $.ajax({
	           type:"GET"
	           ,async : true
	           , url : urls
	           , dataType : "html"
	           , data : ids+"="+encodeURIComponent(datas) 
	           , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	           , success : function(response, status, request) {          
	         
	        	//배송현황    
	   			$(detail).html('');
	   			$(detail).animate({height: 0},10);
	   			
	   			$(detail).append(response);
	   			var heights = $(tableid).height();
	   			$(detail).animate({height: heights},500);
	   			
	   			$(exit).click(function(){	 			
	   				getColorful(FruitLoops,buffing);		
	   	   			$(detail).animate({height: 0},500);
	   			});
	   			
	   			//for delivery purposes
	   	       $('#fix_button').click(function(){
	        	   document.frmUpdate.submit();
	           });
	           
	           $('#delete_button').click(function(){	        	   
	        	   $('#hong_form').attr('action', 'purchase_quit');
	        	   document.frmUpdate.submit();
	           });
	   			
	   			$('#button_quickform').click(function(){
	   				 document.quickform.submit();
	   			});	
	          }
		  });	
	  }
	
	$(document).ready(function(){
		
		var FruitLoops = new Array('#FFD3D3','#FFECD3','#E3DDFF','#CEFFB3'); 
		var buffing = document.getElementById('totalnumber');

		getColorful(FruitLoops,buffing);		
			
		$('.getBsmember').click(function(){

			   getColorful(FruitLoops,buffing);		
			   var text= $(this).attr('id');
			   $("#table_"+text).attr('bgcolor','#2DB4DF');
			
			   AjaxRequest("reg_member_detail_purchase", "memberid", 
					       $(this).attr('value'), '#getdetail', '#hong_detail_table',
					       FruitLoops, buffing, '.hong_exit');			   
		});
		
		
		$('.reg_detail').click(function(){
			
			   getColorful(FruitLoops,buffing);		
			   var text= $(this).attr('id');
			   $("#table_"+text).attr('bgcolor','#2DB4DF');

			   AjaxRequest("reg_detail_purchase", "idtest", 
				       $(this).attr('value'), '#getdetail', '#hong_detail_table',
				       FruitLoops, buffing, '.hong_exit');
		           });
		
		$('.bs_quick').click(function(){

			   getColorful(FruitLoops,buffing);		
			   var text= $(this).attr('id');
			   $("#table_"+text).attr('bgcolor','#2DB4DF');
			
			   AjaxRequest("getbs_quick", "bqid", 
				       $(this).attr('value'), '#getdetail', '#hong_table',
				       FruitLoops, buffing, '.hong_exit');
		});
		

		$('.fixPurchase').click(function(){

			   getColorful(FruitLoops,buffing);		
			   var text= $(this).attr('id');
			   $("#table_"+text).attr('bgcolor','#2DB4DF');
			
			   AjaxRequest("purchase_fix", "bqid", 
				       $(this).attr('value'), '#getdetail', '#hong_table',
				       FruitLoops, buffing, '.hong_exit');	
		    });
		
		$('.bs_non_delivery').click(function(){
	
			   AjaxRequest("getbs_quick3", "bqid", 
			   $(this).attr('value'), '#getdetail3', '#hong_table3',
		       FruitLoops, buffing, '.hong_exit3');
			
		});
		
		$('.purchaseOk').click(function(){
			
			alert('');
		});
		
		$('.getOutsider').click(function(){
			
			   getColorful(FruitLoops,buffing);		
			   var text= $(this).attr('id');
			   $("#table_"+text).attr('bgcolor','#2DB4DF');
			
			   AjaxRequest("getOutsider", "bpid", 
			   $(this).attr('value'), '#getdetail', '#hong_detail_table',
			   FruitLoops, buffing, '.hong_exit');
			   
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


#totalnumber{
	height : 0px;
	overflow : hidden;
}

.space{
	height : 40px;
}


#getdetail{
	height : 0px;
	overflow:hidden;
}

#getdetail2{
	height : 0px;
	overflow:hidden;
}

/* exit button */
.hong_exit{
	width : 0px;
	float : left;
	position : relative;
}

.hong_delete{
	width : 0px;
	float : left;
	left : 50px;
	position : relative;
	
}

.hong_fix{
	width : 0px;
	float : left;
	left : 100px;
	position : relative;
	
}

.hong_exit2{
	width : 0px;
	float : left;
	position : relative;
}


#wrap_buttons{
	left : 365px;	
	position : relative;
}

.hong_button{
 padding : 10px;
 width : 200px;
 margin:0 auto;
 background : #DAE5F6;
}

.bs_quick{
	width : 100px;
}
</style>

<div class="hong_title">
	<div>주문 완료</div>
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
			<th>
				<div id="totalnumber">${bean.bq_total }</div>
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
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${bean.data }" var="e" varStatus="no"> 
		<tr class="${e.bq_id }" id="table_select_${no.index }" bgcolor="">
			<td>
				<button class="reg_detail" value="${e.bp_id }" id="select_${no.index }">${e.bp_id }</button> 		
			</td>
			<td>
			<c:choose>
					<c:when test="${e.bs_id==0}">
					<button class="getOutsider" value="${e.bp_id }" id="select_${no.index }">비회원</button>			
					</c:when>
					<c:otherwise>
					<button class="getBsmember" value="${e.bs_id }" id="select_${no.index }">회원 ${e.bs_id }</button>		
					</c:otherwise>
			</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${e.bp_price_type==1 }">
					<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">
						신용카드		
					</span>				
					</c:when>
					<c:when test="${e.bp_price_type==2 }">
					<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">
						무통장입금
					</span>	
					</c:when>
				</c:choose>
			</td>
			<td>
				<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">${e.bp_price }</span>
			</td>
			<td>
				<span class="fixPurchase" value="${e.bp_id }" id="select_${no.index }">${e.bp_cnt }</span>
			</td>	
			<td>
			 <fmt:formatDate value="${e.bp_reg_date }" pattern="MM-dd HH:mm"/>
			</td>		
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
	
