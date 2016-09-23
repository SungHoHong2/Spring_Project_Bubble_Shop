<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
	
		$('.changimg').click(function(){
			
			alert($(this).attr('value'));
			
			
		});
		
		$('#easykill_button').click(function(){
			
			document.easykill.submit();
		});
		
		$('.hong_click').click(function(){			
			
			  $.ajax({
				    	  type:"GET"
				    	  ,async : true
				          , url : "reg_detail"
				          , dataType : "html"
				          , data : "idtest=" + encodeURIComponent($(this).attr('id')) 
				          , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
				    	  , success : function(response, status, request) {          
				    		
				    		$('#detailinput').html(""); 
							$('#detailinput').append(response);
							
				    		var heightbuf = $('#hong_detail_table').height();
				    		$('#detailinfo').animate({height : heightbuf},500);	
				    		
				    		$('.hong_exit').click(function(){
				    			$('#detailinfo').animate({height : '0px'},500);
				    		});
				    		
				    		//double click on the title will make the detail close 
				    		$('.hong_click').click(function(){			
				    
				    			$('#detailinfo').animate({height : '0px'},0);
				    		});				  
				    		
				    		$('.hong_delete').click(function(){
				    			var text = $('.hong_delete').attr('id');

									window.location='reg_list_delete?id='+text;
				    		});
				    		
				    		$('.hong_fix').click(function(){
				    			var text = $('.hong_fix').attr('id');
									window.location='reg_list_update?id='+text;
				    		});
				    		
				    		return false;
				    }
			});
		});
	});
	
	

</script>

<style>
.hong_template{
 padding : 20px;
 width : 800px;
 margin:0 auto;
}

#hong_detail{
	background : white;
	height : 0px;
}

#detailinfo{  /* detail div which opens and closes */
	background : white;
	height : 0px;
	overflow : hidden;
}

.hong_click{
	display : block;
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

/* detail box which was yellow */
#detailinput{
	width : 100%;
	height : 100%;
	background : white;
}

.hong_title{
 padding-top : 40px;
 width : 800px;
 margin:0 auto;
 color : blue;
 font-size : 20px; 
}

</style>

 
	<div class="hong_title">
		상품 리스트
	</div>
   
   <form name="easykill" method="post" action="easykill_result">
   <div class = 'hong_template'>
   		<table class="tbl_full">
   			<thead>
   				<tr>
   					<th>
   						
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
   						등록일
   					</th>
   				</tr>
   			</thead>
   			<tbody>
   				<tr>
   					<td id="hong_detail" colspan="6" >
   						<div id="detailinfo">
   							<div id="detailinput"> 
   												<!--the data from db comes in-->
   							</div>
   						</div>
   					</td>
   				</tr>
   				
   			<c:forEach items="${bean.data }"  var = "e" varStatus="no"> 
   				<tr>
   					<td width = "50px">
					 <input type="checkbox" name="list[${no.index}].g_code" value="${e.g_code }" />
   					</td>
   					<td>
   						${e.g_code }
   					</td>
   					<td width="200px">
  						<span class="hong_click" id='${e.g_code }'>${e.g_name }</span>
   					</td>
  					<td>
  						${e.g_price }
  					</td>
  					<td>
						<span class="changimg" value=${e.g_code }>이미지 수정</span>
  					</td>
  					<td width="150">
  					  <fmt:formatDate value="${e.g_reg_day}" pattern="MM-dd HH:mm"/>
  					</td>
  					
   				</tr>
   		</c:forEach>
   		<tr>
   		<td colspan="6">
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
   			<tr>
   				<td colspan="6">
   					<span class="negative large button" id="easykill_button">
   					전체 삭제
   					</span>
   				</td>
   			</tr>
   			</tbody>
   			
   		
   		</table>
   		</div>
       </form>
    
    