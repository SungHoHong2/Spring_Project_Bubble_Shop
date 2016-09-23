<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <script type="text/javascript" src="../../../resources/js/common.js"></script>
    
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">

function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function ajaxRequestKill(ids,idss)
{
	  $.ajax({
        type:"GET"
        ,async : true
           , url : "bs_good_detail_delete"
           , dataType : "html"
           , data : "bs_good_detail_id=" + encodeURIComponent(ids)+"&getkeys="+encodeURIComponent(idss) 
           , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
           , success : function(response, status, request) {    
      	    
            $('#forAddtionals').html('');
            $('#forAddtionals').append(response);

            $('.kill_good_detail').click(function(){
				 var ids = $(this).attr('name');				 
				 var idss = $('.hong_fix').attr('id');
				 ajaxRequestKill(ids,idss);        		  
       	  });	              
        }
	  });	        	  
}


$(document).ready(function(){
	
	  $.ajax({
          type:"GET"
          ,async : true
             , url : "bs_good_detail"
             , dataType : "html"
             , data : "bs_good_detail_id=" + encodeURIComponent($('#getkey').attr('value')) 
             , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
             , success : function(response, status, request) {        
        	 
        	  $('#forAddtionals').append(response);
    
        	  $('.kill_good_detail').click(function(){
				 var ids = $(this).attr('name');				 
				 var idss = $('.hong_fix').attr('id');
				 ajaxRequestKill(ids,idss);        		  
			    				 
        	  });	  
            }
          });
	
	  
	var buffings;
	var enlargeNum = 1;

	$('#addinput').click(function(){	
		
		var inputtext = '<tr colspan="3"><td><input type="text" name="list['+enlargeNum+'].bgd_size" size="3"></td><td><input type="text" name="list['+enlargeNum+'].bgd_color" size="3"></td><td><input type="number" class="cnt" name="list['+enlargeNum+'].bgd_cnt" onkeypress="return isNumberKey(event)"></td><td width="100px"></td></tr>';
		$('#input').append(inputtext);
		enlargeNum++;
		
	});
	
	
	
	var checker = new Array(4);
	
	$('#submit_button').click(function(){
		 

		  var frm = document.frm;	    
		    
		  if(form_chk(frm, ""))
		  {	
				  document.frm.submit();
		  }	

	});	
});
</script>

<style type="text/css">

input[type="number"] {
   width:30px;
}

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

/* exit button */
.hong_exit{
	width : 0px;
	float : left;
	position : relative;
}


.hong_fix{
	width : 0px;
	float : left;
	left : 50px;
	position : relative;
	
}

#enlarge{
	height : 0px;
	overflow : hidden;

}

</style>

	<div class="hong_title">
		상품 수정
	</div>


<form name="frm" action="reg_list_update_input" method="post" enctype="multipart/form-data">
   <input id="getkey" type="hidden" name="g_code" value="${bean.data.g_code }">
   <div class = 'hong_template'>
   		<table class="tbl_full">
   		<thead>
		<tr>
			<th colspan="3">
				<div class = "hong_exit">
   					<span class="button large neutral">뒤로</span>
   				</div>	
   				<div class="hong_fix" id="${bean.data.g_code }">
   					<span class="button large positive">초기화</span>
   				</div>
			</th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>
			제품 이름 
		</td>
		<td colspan="2">
			<input type="text" name="g_name" value="${bean.data.g_name }">
		</td>
	  </tr>
		<tbody id="forAddtionals">
		
		</tbody>
		<tr>
		<td>
			종류 추가
		</td>
		<td colspan="2">
		<table width="100%">
		 <tbody id="input">
		 </tbody>		
			<tr>
				<td colspan="4">
				  <span class ="button large neutral" id="addinput">크기추가</span>				
				</td>
			</tr>
		</table>		
		</td>
		<td>
	</td>
	</tr>
	
	
	<tr>
		<td width="200px">
		 상세 내용 
		</td>
		<td colspan="2">
		    <textarea rows="4" cols="70" name="g_describe">${bean.data.g_describe }</textarea> 
		</td>
	</tr>
	<tr>
		<td>
			가격 / 할인 가격 
		</td>
		<td colspan="2">
			<input type="text" value="${bean.data.g_price }" name="g_price"> / 
			<input type="text" value="${bean.data.g_pricedis }" name="g_pricedis">
		</td>
	</tr>
	<tr>
		<td>
			판매 상태
		</td>
		<td colspan="2">
			<c:choose>
				<c:when test="${bean.data.g_sell=='Y'}">
						판매 <input type="radio" name="g_sell" value="Y" checked="checked">
						보류 <input type="radio" name="g_sell" value="N">
				</c:when>
				<c:otherwise>
						판매 <input type="radio" name="g_sell" value="Y">
						보류 <input type="radio" name="g_sell" value="N" checked="checked">				
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>
			게시 상태
		</td>
		<td colspan="2">
			<c:choose>
				<c:when test="${bean.data.g_show_list=='Y'}">
						게시 <input type="radio" name="g_show_list" value="Y" checked="checked">
						보류 <input type="radio" name="g_show_list" value="N">				
				</c:when>
				<c:otherwise>
						게시 <input type="radio" name="g_show_list" value="Y">
						보류 <input type="radio" name="g_show_list" value="N" checked="checked">				
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>
			메인화면 진열
		</td>
		<td colspan="2">
			<c:choose>
				<c:when test="${bean.data.g_show_hot=='Y'}">
						진열 <input type="radio" name="g_show_hot" value="Y" checked="checked">
						보류 <input type="radio" name="g_show_hot" value="N">					
				</c:when>
				<c:otherwise>
						진열 <input type="radio" name="g_show_hot" value="Y">
						보류 <input type="radio" name="g_show_hot" value="N" checked="checked">					
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>
			게시시작일 ~  게시종료일 
		</td>
		<td>
			  <fmt:formatDate value="${bean.data.g_start_day}" pattern="MM-dd HH:mm"/>
			  ~
			  <fmt:formatDate value="${bean.data.g_end_day}" pattern="MM-dd HH:mm"/>
		</td>
		<td>
			 <input class="datestarter" type="date" name="g_start_days"> ~ 
			 <input class="dateender" type="date" name="g_end_days">
		</td>
	</tr>
	
	<tr>
		<td>
			리스트 이미지
		</td>
		<td>
			${bean.data.g_imglist }
		</td>
		<td>
			<input id="inputfiles0" type="file" name="list[0].g_imglists">
		</td>
	</tr>
	<tr>
		<td>
			상세 이미지
		</td>
		<td>
			${bean.data.g_imgdetail }
		</td>
		<td colspan="2">
			<input id="inputfiles1" type="file" name="list[0].g_imgdetails">
		</td>
	</tr>
	<tr>
	
	</tr>
	<tr>
		<td>
			핫아이템 썸네일 
		</td>
		<td>
			${bean.data.g_imghotitem }
		</td>
		<td>
			<input id="inputfiles2" type="file" name="list[0].g_imghotitems">
		</td>
	</tr>
	<tr>
		<td>
			핫아이템 이미지
		</td>
		<td>
			${bean.data.g_imgshotitem }
		</td>
		<td>
			<input id="inputfiles3" type="file" name="list[0].g_imgshotitems">
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<span class="button large positive" id="submit_button">수정 완료</span>
		</td>
	</tr>
	
	</tbody>
   		
   		</table>	
	</div>
	</form>
	