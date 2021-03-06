<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title></title>
   <link href="/shop/resources/css/common.css" rel="stylesheet" type="text/css" media="all">
   <link href="/shop/resources/css/bubble.css" rel="stylesheet" type="text/css" media="all">
   <script type="text/javascript" src="/shop/resources/js/jquery-1.9.1.min.js"></script>
   <script type="text/javascript" src="/shop/resources/js/common.js"></script>
   <script type="text/javascript" src="/shop/resources/js/nav.js"></script>
</head>
<body>
   <div class="wrap">
      <div class="animation"></div>
      <div id="header">
         <jsp:include page="include/header.jsp" />
      </div>
   
      <div class="wrap_contents">
         <div class="inner">
            <div class="contents">
              <jsp:include page="${bean.url }.jsp" />
            </div>
         </div>
      </div>
   </div>
   <div id="footer">
   		<jsp:include page="include/footer.jsp" />  
   </div>
</body>
</html>