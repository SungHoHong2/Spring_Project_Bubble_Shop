<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 
  $('.hong_click').click(function(){   
   
     $.ajax({
           type:"GET"
           ,async : true
              , url : "reg_member_detail"
              , dataType : "html"
              , data : "memberid=" + encodeURIComponent($(this).attr('id')) 
              , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
           , success : function(response, status, request) {          
          
          $('#detailinput').html(""); 
       	  $('#detailinput').append(response);
       
          var heightbuf = $('#hong_detail_table').height();
          $('#detailinfo').animate({height : heightbuf},500); 
          
          $('.hong_exit').click(function(){
   		   $('#nodata').animate({height : '0px'},500);
           $('#detailinfo').animate({height : '0px'},500);
		   $('#extradetail').html('');	
		   $("#extradetail").animate({height:"0px"},500);
          });
          
          //double click on the title will make the detail close 
          $('.hong_click').click(function(){  
		   $('#nodata').animate({height : '0px'},500);
           $('#detailinfo').animate({height : '0px'},500);    
		   $('#extradetail').html('');	
		   $("#extradetail").animate({height:"0px"},500);
          });       
          
          
          $('#delete_button').click(function(){
        	  var text = $('#delete_button').attr('name');
        	  alert('삭제할 고유 아이디  : '+text);
        	  window.location = "after_member_list?id="+text;
              return false;
        	  
          });
          
          $('#fix_button').click(function(){
    		 var text= $('#fix_button').attr('name');
    		 alert('수정할 고유 아이디 : '+text);
	       	 window.location ="member_fix?id="+text;
          	 return false;
          });
          
          
          $('#bs_participant').click(function(){
        	
    			    $.ajax({
     	           type:"GET"
     	           ,async : true
     	              , url : "reg_member_specific_detail"
     	              , dataType : "html"
     	              , data : "memberid=" + encodeURIComponent($('#bs_participant').attr('id')+"/"+$('#bs_participant').attr('name')) 
     	              , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
     	       		  , success : function(response, status, request) {          
     	          	
  							$("#extradetail").stop().animate({height:"0px"},0);
							$('#extradetail').html('');	
     	       			  	$("#extradetail").append(response);
     	       			  	var bufheight= $('#tablesheight').height();
     		
     	       			  	if(bufheight<50)
     	       			  	{
    							$('#extradetail').html('');	
     	       			  		$('#nodata').animate({height : '50px'},500);
     	       			  	}
     	       			  	else
     	       			  	{	
     	       			  		$('#nodata').animate({height : '0px'},500);
    							$("#extradetail").stop().animate({height: bufheight},500);
     	       			  	}
     	       		    } 
    			   });
          	});
          
                
          $('#bs_basket').click(function(){
        	  $.ajax({
    	           type:"GET"
    	           ,async : true
    	              , url : "reg_member_specific_detail"
    	              , dataType : "html"
    	              , data : "memberid=" + encodeURIComponent($('#bs_basket').attr('id')+"/"+$('#bs_basket').attr('name'))
    	              , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
    	       		  , success : function(response, status, request) {          
 							$("#extradetail").stop().animate({height:"0px"},0);
							$('#extradetail').html('');	
    	       			  	$("#extradetail").append(response);
     	       			  	var bufheight= $('#tablesheight').height();

    	       			  	if(bufheight<50)
     	       			  	{
    							$('#extradetail').html('');	
     	       			  		$('#nodata').animate({height : '50px'},500);
     	       			  	}
     	       			  	else
     	       			  	{	
     	       			  		$('#nodata').animate({height : '0px'},500);
    							$("#extradetail").stop().animate({height: bufheight},500);
     	       			  	}    	       		    
    	       			  	} 
   			   });          
          });
          
          $('#bs_purchase').click(function(){
        	  $.ajax({
   	           type:"GET"
   	           ,async : true
   	              , url : "reg_member_specific_detail"
   	              , dataType : "html"
   	              , data : "memberid=" + encodeURIComponent($('#bs_purchase').attr('id')+"/"+$('#bs_purchase').attr('name'))
   	              , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
   	       		  , success : function(response, status, request) {          
							$("#extradetail").stop().animate({height:"0px"},0);
							$('#extradetail').html('');	
   	       			  		$("#extradetail").append(response);
    	       			  	var bufheight= $('#tablesheight').height();

    	       			  	if(bufheight<50)
     	       			  	{
    							$('#extradetail').html('');	
     	       			  		$('#nodata').animate({height : '50px'},500);
     	       			  	}
     	       			  	else
     	       			  	{	
     	       			  		$('#nodata').animate({height : '0px'},500);
    							$("#extradetail").stop().animate({height: bufheight},500);
     	       			  	}   	       		    
    	       			  	} 
  			   });       
        	  });
          
          $('#bs_refund').click(function(){
         	 alert(''); 
           });
          
          $('#bs_mycoupon').click(function(){
         	 alert(''); 
           });
          
          $('#bs_user_comments').click(function(){
         	 alert(''); 
           });
          
          $('#bs_board_comments').click(function(){
         	 alert(''); 
           });
         
          
          $('#bs_shop_notice').click(function(){
          	 alert(''); 
            });
          
          $('#bs_address').click(function(){
          	 alert(''); 
            });
          
          
          
          $('#bs_boardlist').click(function(){
         	 alert(''); 
           });
          
          return false;
        }
       });
  });
 });
 
function fixit()
{
	alert('');	
}

</script>


<style>

.hong_button{
 padding : 10px;
 width : 200px;
 margin:0 auto;
 background : #DAE5F6;
}

.hong_button2{
 padding : 10px;
 width : 200px;
 margin:0 auto;
 background : #efefef;
}


.hong_template{
 padding : 20px;
 width : 800px;
 margin:0 auto;
}

#hong_detail{
 background : white;
 height : 0px;
}

.hong_title{
 padding-top : 40px;
 width : 800px;
 margin:0 auto;
 color : blue;
 font-size : 20px; 
}

#detailinfo{  /* detail div which opens and closes */
 background :white;
 height : 0px;
 overflow : hidden;
}

/* detail box which was yellow */
#detailinput{
 width : 100%;
 height : 100%;
 background : white;
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

#wrap_buttons{
	left : 365px;	
	position : relative;
}

#wraplargebutton{
	width : 100px;
	text-align : center; 
}

#extradetail{
 	height : 0px;
}

#nodata{
	background : red;
	color :white;
	text-align : center;
	overflow : hidden;
	height :0px;
	margin:0 auto;
}
</style>


	<div class="hong_title">
		전체 회원 관리  
	</div>

		<div class="hong_template">
         			<div id="detailinfo">
          			<div id="detailinput"> 
               			<!--the data from db comes in-->
          			</div>
          	
         			</div>
         			
         			<div id="nodata"> 회원과 연관된 정보가 없습니다. </div>
         			
					<div id="extradetail">
						<div id="extradetail2"></div>
						<!-- the specific date comming from the db -->
					</div>
		<table class="tbl_full">
			<thead>
				<tr>
					<th>
						권한 	
					</th>
					<th>
						사용자 ID
					</th>
					<th>
						전화번호 
					</th>
					<th>
						이름
					</th>
					<th>
						비밀번호
					</th>
					<th>
						가입날짜 
					</th>
					<th>
						E-Mail
					</th>
					<th>
						수신여부 
					</th>
				</tr>
			</thead>
		
			<tbody>
			<c:forEach items="${bean.data }" var="e">
				<tr>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_rate }</span>
					</td>
					<td>
					 <span class="hong_click" id='${e.bs_id }'>${e.bs_userid }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_hp }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_name }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_pwd }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'><fmt:formatDate value="${e.bs_reg_date }" pattern="MM-dd HH:mm"/>
					</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_email }</span>
					</td>
					<td>
					<span class="hong_click" id='${e.bs_id }'>${e.bs_email_yn }</span>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
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
			</tbody>
		</table>
		
	</div>
				