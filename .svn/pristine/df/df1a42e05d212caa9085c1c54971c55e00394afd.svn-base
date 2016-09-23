<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="../../../resources/js/common.js"></script>
<script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){

		$('#input').click(function(){
							
			if(form_chk(frm, ""))	
			{
				var password1 = $('input[name="bs_pwd"]').val();
				var password2 = $('input[name="bs_pwd2"]').val();
 				
				if(password1==password2)
				{
					alert('가입승인완료');
					document.frm.submit();	
				}
				else{
					
					alert('잘못된 암호입니다.');
				}
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
</style>

<div class="hong_title">
회원 등록
</div>

<form id="forming" name="frm" method="post" action="member_input_result">
<div class="hong_template">
	<table class="tbl_full">
		<thead>
		<tr>
			<th>
			   회원 정보
			</th>
			<th>
			   입력 내용
			</th>
		</tr>	
		</thead>
		<tbody>
		<tr>
			<td bgcolor = "#efefef">
				사용자 아이디 
			</td>
			<td>
				<input title="아이디" type="text" name="bs_userid"> 
			</td>
		</tr>
		<tr>
			<td bgcolor="#efefef">
				권한
			</td>
			<td>
				<select name="bs_rate" form="forming">
  				<option value="0">0</option>
  				<option value="1">1</option>
  				<option value="2">2</option>
 				<option value="3">3</option>
				</select>
			</td>
		</tr>
		<tr>
			<td bgcolor="#efefef">
				전화번호
			</td>
			<td>
				<input title="전화번호" type="text" name="bs_hp">
			</td>
		</tr>
		<tr>
			<td bgcolor="#efefef">
				주소
			</td>
			<td>
				<input title="주소" type="text" name="bs_address">
			</td>
		</tr>
		<tr>
			<td bgcolor="#efefef">
				상세주소
			</td>
			<td>
				<input title="상세주소" type="text" name="bs_address2">
			</td>
		</tr>
		<tr>
			<td bgcolor="#efefef">
				우편번호
			</td>
			<td>
				<input title="우편번호" type="text" name="bs_zip">
			</td>
		</tr>
		<tr>
			<td bgcolor="#efefef">
				이름
			</td>
			<td>
				<input title="이름" type="text" name="bs_name">
			</td>
		</tr>
		<tr>
			<td bgcolor="#efefef">
				암호
			</td>
			<td>
				<input id="password1" title="암호" type="password" name="bs_pwd">
			</td>
		</tr>	
		<tr>
			<td bgcolor="#efefef">
				암호확인
			</td>
			<td>
				<input id="password2" title="암호" type="password" name="bs_pwd2">
			</td>
		</tr>	
		<tr>
			<td bgcolor="#efefef">
				이메일 
			</td>
			<td>
				<input title="이메일" type="text" name="bs_email">
			</td>
		</tr>	
		<tr>
			<td bgcolor="#efefef">
				이메일 수신여부
			</td>
			<td>
					<input title="이메일 수신 여부" type="radio" name="bs_email_yn" value="y"/> 허용 
					<input type="radio" name="bs_email_yn" value="n"/> 거부 			
			</td>
		</tr>		
		<tr>
			<td bgcolor="#efefef">
				SNS 수신여부
			</td>
			<td>
					<input title="SNS 수신여부" type="radio" name="bs_sms_yn" value="y"/> 허용 
					<input type="radio" name="bs_sms_yn" value="n"/> 거부 			
			</td>
		</tr>
		</tbody>
		<thead>
			<tr>
				<th colspan="2">	
				<span class="button large positive" id="input">입력</span>
				<span class="button large neutral" id="clear">새로고침</span>
				<span class="button large negative" id="goback">뒤로</span>
				</th>
			</tr>
		</thead>
	</table>
</div>
</form>
