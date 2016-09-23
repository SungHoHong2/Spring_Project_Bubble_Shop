<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${bean.data }" var ="e"/>

	<table class="tbl_full" id="hong_detail_table">
	<thead>
		<tr>
			<th width="100px" colspan="2">
			<div class = "hong_exit">
        		<span class="button large neutral">접기</span>
       		</div> 
       		</th>
			<th>
				고유 ID
			</th>
			<th>
				사용자 ID 
			</th>
			<th>
				전화번호
			</th>
			<th>
			   가입 날짜
			</th>
		</tr>
	</thead>
	<tbody>	
		<tr>
			<td colspan="2" bgcolor="#efefef">
			</td>
			
			<td>
				${e.bs_id }
			</td>
			<td>
				${e.bs_userid }
			</td>
			<td>
				${e.bs_hp }
			</td>
			<td>
				${e.bs_reg_date }
			</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
			주소
		</td>
		<td colspan="4">
			${e.bs_address }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
			상세 주소 
		</td>
		<td colspan="4">
			${e.bs_address2 }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	이름  
		</td>
		<td colspan="4">
			${e.bs_name }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	비밀번호  
		</td>
		<td colspan="4">
			${e.bs_pwd }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	가입날짜   
		</td>
		<td colspan="4">
		<fmt:formatDate value="${e.bs_reg_date }" pattern="MM-dd HH:mm"/>
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		  이메일   
		</td>
		<td colspan="4">
			${e.bs_email }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	메일 수신 여부    
		</td>
		<td colspan="4">
			${e.bs_email_yn }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	SNS 수신 여부   
		</td>
		<td colspan="4">
			${e.bs_sms_yn }
		</td>
		</tr>
		
	</tbody>
	</table>


