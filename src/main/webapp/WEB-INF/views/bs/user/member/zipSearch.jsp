<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>





<script type="text/javascript">

	$(document).ready(function(){
		
		var frm = document.frm;
		
		wooGo = function()
		{
			alert('!');
			frm.action = "zipOk";
			frm.submit();
		}
		
	});
</script>
<form method="post" name="frm">
	<input type="text" name="zipWord"> <a href="" onclick="wooGo(); return false;">검색</a><br><br><br>
	
	

	<%-- </c:forEach> --%>
	
	
	
</form>