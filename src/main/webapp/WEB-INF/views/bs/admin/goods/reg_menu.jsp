<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<select id="secondtest" name="list[0].bm_id">
<c:forEach items="${bean.data }" var="e">
	<option value="${e.bm_id }">${e.bm_name }</option>
</c:forEach> 
</select>    
