<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${bean.data }" var="e">
	<div class="ThirdMenu_data" id="${e.bm_id }">
	<button class="menu_delete" name="${e.bm_id }">-</button>${e.bm_name }
	</div>
</c:forEach>	
	<div class="ThirdMenu_Button">
	add menu +
	</div>
	<div id ="adding2">
	</div>