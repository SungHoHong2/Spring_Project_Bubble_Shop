<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../../../resources/js/jquery-ui-1.8.23.custom.min.js"></script>


<script type="text/javascript">


//"bs_menu_detail"
	$(document).ready(function(){
		
		function ajaxdelete(keyname)
		{
			 $.ajax({
	   	           type:"GET"
	   	           ,async : true
	   	           , dataType : "html"
	   	           , url : "ajaxdelete"
	   	           , data : "keyname="+ encodeURIComponent(keyname)+"&deletekey="+encodeURIComponent(1) 
	   	           , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	   	           , success : function(response, status, request) {     
	   	        	   
	   	        	   alert('메뉴가 삭제되었습니다.(하위 메뉴 포함)');
	   	        	   
	   	        	   
	   	        	   window.location="bs_menu";
	   	           }
			 });
		}
		
		
		//third menu list
		function requestAjax2(urls,div,keyname)
		{
			 $.ajax({
	   	           type:"GET"
	   	           ,async : true
	   	           , url : urls
	   	           , dataType : "html"
	   	           , data : "keyname="+ encodeURIComponent(keyname) 
	   	           , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	   	           , success : function(response, status, request) {     
	   	        	   
	   	        	$(div).append(response);
 	  	   	        $(div).animate({opacity : 1},0);
	   	        	
 	  	   	  		$('.ThirdMenu_Button').click(function()
  	  	   	        {
 	  	   	  				 alert(keyname);
  	  	   	    	     	 var input = document.getElementById('inputbox2');
							 $('#adding').html('');
							 $('#adding2').append(input.innerHTML);
  	  	   	    	     	 $('.bm_par_ids').attr('value',keyname);
  	  	   	        });
 	  	   	  		
 	  	   	     	$('.menu_delete').click(function(){
						var deleteid= $(this).attr('name');						
						ajaxdelete(deleteid);
	  	   	       });
	   	           }
			 });
		}
		
		
		
		//second menu list  
		function requestAjax(urls,div,keyname)
		{
			  $.ajax({
   	           type:"GET"
   	           ,async : true
   	           , url : urls
   	           , dataType : "html"
   	           , data : "keyname="+ encodeURIComponent(keyname) 
   	           , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
   	           , success : function(response, status, request) {          
   	    		
    	   			   $(div).append(response);
    	  	   	       $(div).animate({opacity : 1},0);

    	  	   	       $('.SecondMenu_Button').click(function()
    	  	   	        {
    	  	   	    	     var input = document.getElementById('inputbox');
							 $('#bm_par_id').attr('value',keyname);
							 $('#adding').append(input.innerHTML);
							  
    	  	   	        });
    	  	   	       
    	  	   	       $('.SecondMenu_data').click(function(){
						$('.SecondMenu_Button').attr('opacity',0);
    	  	   	  		$('#ThirdMenu').html('');
    	     	    	$('#ThirdMenu').animate({opacity : 0},0);
    	  	   	    	   
    	  	   	    	   var text2 = $(this).attr('id');
							
    	  	     	  	   requestAjax2("bs_menu_detail2",'#ThirdMenu',text2);     	  	 
    	  	   	    	   
    	  	   	       });
    	  	   	       
    	  	   	       $('.menu_delete').click(function(){
							var deleteid= $(this).attr('value');
							
							ajaxdelete(deleteid);
							
    	  	   	       });
    	  	   	       
   	           }
   		  });	
		}
		
		
		$('.FirstMenu_data').click(function(){
			var text = $(this).attr('id');
			
	   	  	$('#ThirdMenu').html('');
     	    $('#ThirdMenu').animate({opacity : 0},0);
			$('#SecondMenu').html('');
     	    $('#SecondMenu').animate({opacity : 0},0);
     	    
     	  	 requestAjax("bs_menu_detail",'#SecondMenu',text);     	  	 
			
	   	     
	   	     
		});
		
	});
	
</script>    
<style>
	#FirstMenu{
		width : 130px;
		background : red;
		position : relative;
		float : left;
	}
	
	.FirstMenu_data{
 	padding : 20px;
 	width : 100px;
 	margin:0 auto;
 	font-size : 15px; 
	background : #0a5c98;
	}
	
	.SecondMenu_data{
 	padding : 20px;
 	width : 200px;
 	margin:0 auto;
 	font-size : 15px; 
	background : #99aa22;
	}
	
	.ThirdMenu_data{
 	padding : 20px;
 	width : 140px;
 	margin:0 auto;
 	font-size : 15px; 
	background : #C0CF51;
	}
	
    #adding{
 	width : 180px;
 	text-align : center;
 	margin:0 auto;
 	font-size : 15px; 
	background : #99aa22;
	}
	
	#adding2{
 	width : 180px;
 	text-align : center;
 	margin:0 auto;
 	font-size : 15px; 
	background : #99aa22;
	}
	
	#SecondMenu{
		width : 130px;
		background :#99aa22;
		margin-left : 10px;
		position : relative;
		float : left;
		opacity : 0;
	}
	
	.SecondMenu_Button{
		padding : 20px;
 		width : 140px;
 		margin:0 auto;
 		font-size : 15px; 
		background : #5dc434;
		opacity : 1;
		
	}
	
	#ThirdMenu{
		width : 130px;
		background :#99aaaa;
		margin-left : 110px;
		position : relative;
		float : left;
	}
	
	.ThirdMenu_Button{
		padding : 20px;
 		width : 140px;
 		margin:0 auto;
 		font-size : 15px; 
		background : #5dc434;
		
	}
	
	#inputbox{
	    height : 0px;
	    overflow : hidden;
	}
	
	#inputbox2{
	    height : 0px;
	    overflow : hidden;
	}
	
</style> 

<div id = "inputbox">
<form method="post" action="2ndMenuUpload" name="frm">
<input type="hidden" name="bm_par_id" id="bm_par_id">
<input type="text" name="bm_name" size="8">
<button id="menuUpload_button">추가</button>
</form>
</div> 
 
<div id = "inputbox2">
<form method="post" action="2ndMenuUpload" name="frm">
<input type="hidden" name="bm_par_id" id="bm_par_id" class="bm_par_ids">
<input type="text" name="bm_name" size="8">
<button id="menuUpload_button">추가</button>
</form>
</div>  
 
<div class="hong_title">
메뉴 변경
</div>
 
<div class="hong_template">
<div id="FirstMenu">
	<div class="FirstMenu_data" id="1">
	 카테고리
	</div>
	<div class="FirstMenu_data" id="2">
	 브랜드
	</div>
	<div class="FirstMenu_data" id="3">
	 전문관
	</div>
	<div class="FirstMenu_data" id="4">
	 사용기
	</div>
</div>
<div id="SecondMenu">
</div> 
<div id="ThirdMenu">
</div>

 <table class="tbl_full">
 </table>
</div>