<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>


<script type="text/javascript">
$(document).ready(function(){

	  $.ajax({
		    type:"GET"
		    ,async : true
		          , url : "reg_widget1_data"
		          , dataType : "html"
		          , timeout : 3000
		          , cache : false
		          , data : "keyword=" + encodeURIComponent($(this).val()) 
		          , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		          , error : function(request, status, error) {
		           alert("code : " + request.status + "\r\n장애가 발생하였습니다.");
		          }
		    	  , success : function(response, status, request) {          
		 			
		    		  $('#widget_1_content').append(response);		
		    		  
		    		  $('.hong_click').click(function(){
							
						   getdetail();		    			     
		    		  });
		    	}
		   });
	  
	  $.ajax({
		    type:"GET"
		    ,async : true
		          , url : "reg_widget2_data"
		          , dataType : "html"
		          , timeout : 3000
		          , cache : false
		          , data : "keyword=" + encodeURIComponent($(this).val()) 
		          , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		          , error : function(request, status, error) {
		           alert("code : " + request.status + "\r\n장애가 발생하였습니다.");
		          }
		    	  , success : function(response, status, request) {          
		 
		    		  
		    		  $('#widget_2_content').append(response);		
		    		
		    	}
		   });
	  
	  
	  
	  
	  $('#hong_fold').click(function(){
		  
		  $("#widget_1").toggle(
				   function(){
				    $("#widget_1").stop().animate({height :"0px"},500);
				   },
				   function(){
					$("#widget_1").stop().animate({height :"230px"},500);
					}
		 ); 
	  });

	$('#hong_fold2').click(function(){
		  
		  $("#widget_2").toggle(
				   function(){
				    $("#widget_2").stop().animate({height :"0px"},500);
				   },
				   function(){
					$("#widget_2").stop().animate({height :"180px"},500);
					}
		 ); 
	  });
});	
		

</script>

<style>
.hong_template{
 padding : 20px;
 width : 800px;
 margin:0 auto;
}

#hong_numbers{
	font-size:20px;
	color : red;
}

#widget_1{
	height : 230px;
	overflow : hidden;
}

#widget_2{
	height : 180px;
	overflow : hidden;
}

.space{
	height : 40px;
}

.leftdiv{
	width:200px;
	float : left;
	position : relative;
}

.rightdiv{
	float : right;
	position : relative;
}

#testbtn{
	height : 100px;
	width : 100px;
	background : red;	
}

#detailinput{
	height : 0px;
}	

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Product Register</title>
</head>
<body>
	<div class="hong_template">
		<table class="tbl_full">
			<thead>
			<tr>
				<th>
				<div class="leftdiv">
					현재 등록 상품 수    <span id="hong_numbers">(${bean.total })</span>
				</div>
				<div class="rightdiv"> 
					<span class="button large neutral" id="hong_fold">접기</span>					
					<a href="reg_list" class="button large positive">
						상세 보기
					</a>
				</div>	
				</th>
			</tr>
		</thead>
		</table>
		<div id="widget_1">
		<div id="detailinput"> 
   				<!--the data from db comes in-->
   		</div>
   		
   		<table class="tbl_full">
		<tbody>
			<tr>
				<td>
					<div id="widget_1_content"></div>
				</td>
			</tr>
		</tbody>		
		</table>
		</div>
		
		<div class="space">
		</div>
		
		<table class="tbl_full">
		<thead>
			<tr>
				<th>
				<div class="leftdiv">
					현재 진열 상품 수    <span id="hong_numbers">(${bean.g_show_list })</span>
				</div>
				<div class="rightdiv"> 
					<span class="button large neutral" id="hong_fold2">접기</span>					
					<a href="display_product" class="button large positive">
						상세 보기
					</a>
				</div>	
				</th>
			</tr>
		</thead>
		</table>
		<div id="widget_2">
		<table class="tbl_full">
		<tbody>
			<tr>
				<td>
						<div id="widget_2_content"></div>
				</td>
			</tr>
		</tbody>		
		</table>
		</div>
	
	<div class="space">
	</div>
	
	<table class="tbl_full">
		<thead>
			<tr>
				<th>
				<div class="leftdiv">
					현재 가입 회원 수    <span id="hong_numbers">(${bean.g_show_list })</span>
				</div>
				<div class="rightdiv"> 
					<span class="button large neutral" id="hong_fold2">접기</span>					
					<a href="display_product" class="button large positive">
						상세 보기
					</a>
				</div>	
				</th>
			</tr>
		</thead>
		</table>
		<div id="widget_2">
		<table class="tbl_full">
		<tbody>
			<tr>
				<td>
						<div id="widget_2_content"></div>
				</td>
			</tr>
		</tbody>		
		</table>
		</div>
	
		</div>
	
</body>
</html>