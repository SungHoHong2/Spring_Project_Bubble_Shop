<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bubble Shop Admin</title>
<link href="/shop/resources/css/admin_common.css" rel="stylesheet" type="text/css" media="all">
<link href="/shop/resources/css/bubble.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="/shop/resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/shop/resources/js/nav.js"></script>


</head>
<body>
	<div class="wrap">
			<div id="header" class="bg_nav_color">
				<h1 class="logo"><a href="http://localhost:8080/shop/">admin home</a></h1>
				<div id="nav">
					<h2 class="hidden">글로벌네비게이션</h2>
					<ul class="dropdownmenu">						
						<li class="m1 menu">
							<h3><a class="depth1" href="../goods/reg" >상품관리</a></h3>
							<ul>
								<li>
									<a class="sub1_1" href="../goods/reg">상품등록</a>
								</li>
								<li>
									<a class="sub1_2" href="../goods/reg_list">상품 리스트</a>
								</li>
								<li>
									<a class="sub1_3" href="../goods/display_product">상품 진열 관리</a>
								</li>
							</ul>
						</li>
						
						<li class="m2 menu">
							<h3><a class="depth1" href="../admin_purchase/purchase_list">주문 관리</a></h3>
							<ul>
								<li>
									<a class="sub2_1" href="../admin_purchase/purchase_list">주문 요청</a>
								</li>
								<li>
									<a class="sub2_1" href="../admin_purchase/purchase_finished">주문 완료</a>
								</li>								<li>
									<a class="sub2_2" href="../admin_purchase/purchase_fucked">주문 취소</a>
								</li>
								<li>
									<a class="sub2_3" href="../admin_purchase/refunds">환불</a>
								</li>
							</ul>
						</li>
						
						
						<li class="m3 menu">
							<h3><a class="depth1" href="">게시판</a></h3>
							<ul>
								<li>
									<a class="sub3_1" href="../qna/list">Q&A</a>
								</li>
								<li>
									<a class="sub3_2" href="../faq/list">FAQ</a>
								</li>
								<li>
									<a class="sub3_3" href="../notice/list" >공지사항</a>
								</li>
								<li>
									<a class="sub3_3" href="../event/list" >이벤트</a>
								</li>
								<li>
									<a class="sub3_3" href="../comment/list" >사용기게시판</a>
								</li>
							</ul>
						</li>
						<li class="m4 menu">
							<h3><a class="depth1" href="../admin_member/member_list" >회원관리</a></h3>
							<ul>
								<li>
									<a class="sub3_1" href="../admin_member/member_list">전체회원관리 </a>
								</li>
								<li>
									<a class="sub3_2" href="../admin_member/member_input">회원 등록</a>
								</li>
								<li>
									<a class="sub3_2" href="../admin_member/create_coupons">쿠폰 생성</a>
								</li>
								<li>
									<a class="sub3_2" href="../admin_member/distribute_coupons">쿠폰 현황</a>
								</li>
							</ul>
						</li>
						<li class="m5 menu">
							<h3><a class="depth1" href="../admin_modify/bs_menu" >사이트 설정</a></h3>
						</li>
					</ul>
				</div>
				<div class="topMenu">
					<ul>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
		<div class="contents">
			<jsp:include page="${bean.url }.jsp" />
		</div>
		<div class="footer">
		
		</div>
	
	
	</div>
</body>
</html>