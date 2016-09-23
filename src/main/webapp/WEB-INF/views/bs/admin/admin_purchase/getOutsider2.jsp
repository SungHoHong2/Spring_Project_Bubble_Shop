<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${bean.data }" var ="e"/>

	<table class="tbl_full" id="hong_detail_table2">
	<thead>
		<tr>
			<th width="100px" colspan="2">
			<div class = "hong_exit2">
        		<span class="button large neutral">접기</span>
       		</div> 
       		</th>
			<th>
				비회원 ID 
			</th>
			<th>
				구매 번호 
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
				${bean.data.bg_id }
			</td>
			<td>
				${e.bp_id }
			</td>
			<td>
				${e.bg_hp }
			</td>
			<td>
			<fmt:formatDate value="${e.bg_reg_date }"/>	 
			</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
			주소
		</td>
		<td colspan="4">
			${e.bg_zip }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
			상세 주소 
		</td>
		<td colspan="4">
			${e.bg_address }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	이름  
		</td>
		<td colspan="4">
			${e.bg_name }
		</td>
		</tr>
		<tr>
		<td colspan="2" bgcolor ="#efefef">
		 	비밀번호  
		</td>
		<td colspan="4">
			${e.bg_code }
		</td>
		</tr>	
	</tbody>
	</table>


