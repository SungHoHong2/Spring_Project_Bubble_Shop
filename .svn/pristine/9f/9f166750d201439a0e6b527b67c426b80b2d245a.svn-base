<%@tag import="java.util.ArrayList"%>
<%@ tag body-content="scriptless" language="java" pageEncoding="UTF-8"%><!-- scriptless 내용을 가져옴 -->
<%@ attribute name ="fileName" required="true" %>
<%@ attribute name ="var" required="true" rtexprvalue="false" %><!-- rtexprvalue 자바표현방식 외워서 사용하면댐 -->
<%@ variable name-from-attribute="var" alias="res" scope="AT_END" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	ArrayList ar = new ArrayList();
	ar.add("jpg");
	ar.add("bmp");
	ar.add("gif");
	ar.add("png");
	String ext = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();//소문자로 만들어버리겠다
	Boolean res = ar.contains(ext);
%>
<c:set var="res" value="<%= res %>" />