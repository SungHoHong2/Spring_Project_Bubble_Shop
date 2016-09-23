<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name ="str" required="true" %>
<%= str.replaceAll("\n", "<br>") %>