<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript" src="../../../resources/js/common.js"></script>


<style>
 
 textarea{
  width : 97%;
 }

.hong_template{
 padding : 20px;
 width : 800px;
 margin:0 auto;
}
 
.hong_product_detail{
 
}
 
.hong_product_detail table{
 border-collapse : collapse;
 width : 100%;
}
 
.hong_product_detail td{
 border : 1px solid #BBBBBB;
 
}
 
#test{
 width: 60px;
 text-align : "center"; 
}

.menubox{
 width : 100px;
 float : left;
 position : relative;
 padding : 12px;
} 

.finalboxy{
 width: 50px;
 height : 30px;
 font-size : 20px;
 text-align: center;
 padding-top: 5px;
 position : relative;
 float : left;
 margin-top : 10px;
 color : blue;
}

.hong_title{
 padding-top : 40px;
 width : 800px;
 margin:0 auto;
 color : blue;
 font-size : 20px; 
}

.plain{
	border : 0px;
}
</style>    


<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>
 
<script type="text/javascript">
 
 var date;
 
 $(document).ready(function(){
	 
  var proNum=0;
  var lastNum=3;
  
  // 메뉴코드 초기값
  $("#fatalblow").val($("#firstmenu").val());
  var buffering = $('#fatalblow').val();
  $('#fatalblow').attr('value',buffering);
 
  
  //initialize product date
  var date_output = document.getElementById('date_output');
  loadingdate();
  date_output.innerHTML=date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate(); 
 
  //initialize product id
  var testid = document.getElementById('testid'); 
  testid.innerHTML= getids();
 
  $('#addproducts').click(function(){
   proNum++;
   
   $("#cnt").val(proNum);
   
   var tester = document.getElementById('hong_table');
 
   //1) create new div in beta div
   $('#beta').append('<div id="test'+proNum+'" class="tbl_full"></div>');
   var test_output = document.getElementById('test'+proNum);
   //2) add new info in new div 
   test_output.innerHTML=tester.innerHTML;  
 
 
 	//1)change the inputs in the newly created divs 
   $('#test'+proNum+' #input_g_name').attr('name', 'list['+proNum+'].g_name');
   $('#test'+proNum+' #input_g_num').attr('name', 'list['+proNum+'].g_num');
   $('#test'+proNum+' #input_g_price').attr('name', 'list['+proNum+'].g_price');
   $('#test'+proNum+' #input_g_describe').attr('name', 'list['+proNum+'].g_describe');
   
    //change the inputs for file input
   $('#test'+proNum+' #input_g_imghotitems').attr('name', 'list['+proNum+'].g_imghotitems');
   $('#test'+proNum+' #input_g_imgshotitems').attr('name', 'list['+proNum+'].g_imgshotitems');
   $('#test'+proNum+' #input_g_imgdetails').attr('name', 'list['+proNum+'].g_imgdetails');
   $('#test'+proNum+' #input_g_imglists').attr('name', 'list['+proNum+'].g_imglists');

   
   var buffer1 = lastNum+1;
   var buffer2 = buffer1+1;
   var buffer3 = buffer2+1;
   var buffer4 = buffer3+1;
   lastNum=buffer4;
   
    //change the inputs for file validation 
   $('#test'+proNum+' #input_g_imghotitems').attr('class', 'fileinput_'+buffer1);
   $('#test'+proNum+' #input_g_imgshotitems').attr('class', 'fileinput_'+buffer2);
   $('#test'+proNum+' #input_g_imgdetails').attr('class', 'fileinput_'+buffer3);
   $('#test'+proNum+' #input_g_imglists').attr('class', 'fileinput_'+buffer4);

   
    //change the inputs for date 
   $('#test'+proNum+' #input_g_start_day').attr('name', 'list['+proNum+'].g_start_days');
   $('#test'+proNum+' #input_g_end_day').attr('name', 'list['+proNum+'].g_end_days');

   
   //change the inputs for date validation
   $('#test'+proNum+' #input_g_start_day').attr('class', 'dateinputing_'+proNum);
   $('#test'+proNum+' #input_g_end_day').attr('class', 'dateinputing2_'+proNum);
   
   
   //1)changes the menus 
   	 $('#test'+proNum+' #fatalblow').attr('name', 'list['+proNum+'].bm_id');
  	
	  var buffering = $('#fatalblow').val();
	  $('#fatalblow').attr('value',buffering);
	  $('#test'+proNum+' #fatalblow').attr('value',buffering);

   
   //1) create unique product id    
   var testid = document.getElementById('testid'); 
   testid.innerHTML= getids();
  
  });
  
  
  function getids()
  { 
   return "#"+Math.floor((Math.random() * 99999) + 1);
  }
  
  
  function loadingdate()
  {
   date = new Date();
  }
  
  	function getExtension(filename) {
	    var parts = filename.split('.');
	    return parts[parts.length - 1];
	}
  
     
  $('#insert').click(function(){
   	  	       
	  var frm = document.frm;
      var points = 0; //point accumulates when directed to the correct path 
      //and also refreshes per click
     
	  if(form_chk(frm, ""))
	  {	
		 var datekey  = proNum;
		 var dateStarter = new Array(datekey+1);
		 var dateEnder = new Array(datekey+1);
		 
		 for(var i=0; i<datekey+1; i++)
		 {
		      dateStarter[i] = $('.dateinputing_'+i).val();
		      dateEnder[i] = $('.dateinputing2_'+i).val();
		 }
		 
		 for(var i=0; i<dateStarter.length; i++)
		 {
			if(dateStarter[i]==''||dateStarter[i]==null||dateStarter[i]=='null')
			{
				alert(i+'번째 시작 날짜가 누락되었습니다. ')
			}	
		    
			else if(dateEnder[i]==''||dateEnder[i]==null||dateEnder[i]=='null')
			{
				alert(i+'번째 종료 날짜가 누락되었습니다. ')
			}				
			
			else
			{
			     var key = lastNum;

				 var fileName = new Array(key+1);
				 
		    	 for(var i=0; i<fileName.length; i++)
				 {	
				   fileName[i] = $(".fileinput_"+i).val();
				 } 
		    	 
		         for(var i=0; i<fileName.length; i++)
		         { 	 
		   		  var ext = getExtension(fileName[i]);
		        	 
				  if(fileName[i]==null || fileName[i]=='null' || fileName[i]=='')
				  {
					  alert(i+'번째 파일을 첨부하십시오');
				  }
				  		  
				  else if(ext=='jpg' || ext=='png' || ext=='gif')
				  {
						if(points==key)
						{
							alert('파일 전송 완료');
							frm.submit();
						}
						
					    points++;  
				  }
				  
				  else
				  {				
					 alert(i+'번째 올바른 형식의 이미지 파일이 아닙니다.');
				  }
		       }
			}
		 }	
	  }	
  });
  
		 
    //activate while the firstmenu changes 


    // 1Depth - Event
	$("#firstmenu").change(function(){
		menu_call(1, $(this), $("#secondmenu"));
		$("#fatalblow").val($(this).val());
	});
    
    
    // 메뉴 호출
    menu_call = function(iDepth, obj, res_layer){
    	 
    	var sUrl = "";
    	
    	if (iDepth == 1)
    	{
    		sUrl = "reg_menu";
    	}
    	else
    	{
    		sUrl = "reg_menu2";
    	}
    	
    	$.ajax({
		    type:"GET"
		    ,async : true
		    , url : sUrl
		    , dataType : "html"
		    , data : "menu=" + $(obj).val() 
		    , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		    , success : function(response, status, request) {     

		    	$(res_layer).html("");
		    	$(res_layer).append(response);

		    	if (iDepth == 1)
		    	{
		    		// 3Depth 초기화
		    		$("#thirdmenu").html("");	
					
		    		// 2Depth - Event
					$("#secondtest").change(function(){
						menu_call(2, $(this), $("#thirdmenu"));
						$("#fatalblow").val($(this).val());
					});
		    	}
		    	else
		    	{
		    		// 3Depth - Event
					$("#thirdtest").change(function(){
						$("#fatalblow").val($(this).val());
					});
		    	}
		    }
		});
    }    
 }); 
 

 
</script>
 
 
	<div class="hong_title">
		<div>상품 등록</div>
	  <div class="menubox" id="menuboxfirst"> 
   		<select id="firstmenu">
   			<c:forEach items="${bean.data }" var="e">
   			<option value="${e.bm_id }">${e.bm_name } </option>
   			</c:forEach>
   		</select>
   		</div>
   		<div class="menubox" id="secondmenu"></div>
   		<div class="menubox" id="thirdmenu"></div>
   		<div class="finalboxy" id="finalbox">
   		<!--  <input type="text" id="fatalblow" name="list[0].bm_id" value="" />-->
 	</div>
	</div>
 
 
<div class ="hong_template">
<form name="frm" method='post' enctype="multipart/form-data">
<div id ="hong_table">
<table class="tbl_full">
 <thead>
 <tr>
  <th>
     메뉴코드
  </th>
  <th>
   상품명
  </th>
  <th>
   상품 수량 
  </th>
  <th>
   가격
  </th>
  <th>
   판매 시작일
  </th>
  <th>
    종료일
  </th>
  <th>
      등록일
  </th>
 </tr>
 </thead>
 <tbody>
 <tr>
  <td width="100px">
   <div id="testid"></div> <!-- Dexter's Lab -->
  </td>
  <td width="150px">
   <input type="text" id="input_g_name" name="list[0].g_name" size="10" title="상품명" value="">
  </td>
  <td width="100px">
   <input type="text" id="input_g_num" name="list[0].g_num" title="상품 수량" size="5">
  </td>
  <td width="100px">
   <input type="text" id="input_g_price" name="list[0].g_price" title="가격" size="5">
  </td>
  <td>
 	<input class="dateinputing_0" type="date" id="input_g_start_day" title="판매시작일" name="list[0].g_start_days">
  </td>
  <td>
   	<input class="dateinputing2_0" type="date" id="input_g_end_day" title="판매종료일" name="list[0].g_end_days">
  </td>
  <td width="100px">
   <span id="date_output"></span>
  </td>
 </tr>
 <tr>
  <td colspan="7">
   <div class="hong_product_detail">
   <table>  
    <tr>
     <td bgcolor="#efefef" width="135px">
      요약 설명 
     </td>
     <td>
      <textarea cols="70" rows="4" id="input_g_describe" name="list[0].g_describe" title="요약설명">
      </textarea>
     </td>
    </tr>
     <tr>
     <td bgcolor="#efefef">
      리스트 이미지
     </td>
     <td>
      <input class="fileinput_3" type="file" id="input_g_imglists" name="list[0].g_imglists" title="이미지 리스트">
     </td>
    </tr> 
    <tr>
    <tr>
     <td bgcolor="#efefef">
      아이템 이미지
     </td>
     <td>
      <input class="fileinput_0" type="file" id="input_g_imghotitems" name="list[0].g_imghotitems" title="아이템 이미지">
     </td>
    </tr> 
    <tr>
     <td bgcolor="#efefef">
      아이템 썸네일 이미지
     </td>
     <td>
      <input class="fileinput_1"  type="file" id="input_g_imgshotitems" name="list[0].g_imgshotitems" title="썸네일 이미지">
     </td>
    </tr>
    <tr>
     <td bgcolor="#efefef">
      상세 이미지
     </td>
     <td>
      <input class="fileinput_2"  type="file" id="input_g_imgdetails" name="list[0].g_imgdetails" title="상세 이미지">
      
      <input type="hidden" id="fatalblow" name="list[0].bm_id" value="" />
     </td>
    </tr>
      
   </table>
     </div>
   
  </td>
 </tr>
 
 </tbody> 
</table>
</div>
<div id="beta"></div>   
</form>
</div>
 
<table class="tbl_full">
 <tbody>
 <tr>
  <td colspan="5">
   <span class="button large positive" id="insert">insert</span>
   <span class="button large neutral" id="addproducts">add products</span>
  </td>
 </tr>
 </tbody>
</table>
   		