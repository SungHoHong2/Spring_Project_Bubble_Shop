<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/shop/resources/js/jquery-1.9.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>나의 쿠폰 리스트</title>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
		
			coupon_con = function()
			{
				if ($("[name='p_bc_id']:checked").val() != "")
				{
					var arr = $("[name='p_bc_id']:checked").val().split("//");
					opener.frm.bc_id.value = arr[0];
					opener.frm.pay_pay2.value = arr[1];	
				}
				else
				{
					opener.frm.bc_id.value = "";
					opener.frm.pay_pay2.value = "0";
				}
				
				opener.price_con();
				
				window.close();
			}
			
		});
	
	</script>
	
</head>
<body>
	<table border="1">
		<tr>
			<td align="center" colspan="3">나의 쿠폰 리스트</td>
		</tr>
		<tr>
			<td align="center">선택</td>
			<td align="center">쿠폰종류</td>
			<td align="center">사용가능기간</td>
		</tr>
		<c:forEach items="${bean.coupon }" var="list" varStatus="no">
			<tr>
				<td align="center"><input type="radio" name="p_bc_id" value="${list.bc_id }//${list.bc_price }" /></td>
				<td align="center">${list.bc_price }원</td>
				<td align="center">${list.bc_start_date2 } ~ ${list.bc_end_date2 }</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="center"><input type="radio" name="p_bc_id" value="" checked /></td>
			<td align="center" colspan="2">쿠폰사용안함</td>
		</tr>
	</table>
	<br />
	<a href="#none" onclick="coupon_con(); return false;">[ 쿠폰선택 ]</a>&nbsp;&nbsp;
	<a href="#none" onclick="window.close(); return false;">[ 닫기 ]</a>
</body>
</html>