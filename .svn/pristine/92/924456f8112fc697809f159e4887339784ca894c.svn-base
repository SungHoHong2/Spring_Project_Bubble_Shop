<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<script type="text/javascript">
	
		$(document).ready(function(){

			if ('${bean.msg}' != "")
			{
				alert('${bean.msg}');
			}
			
			bs_login = function()
			{
				if (form_chk(frm, "quick_search"))
				{
					$("#frm").submit();
				}
			}
			
			
			$("#bs_userid").keyup(function(e){
				
				if (e.keyCode == 13)
				{
					bs_login();
				}
				
			});
			
			$("#bs_pwd").keyup(function(e){
				
				if (e.keyCode == 13)
				{
					bs_login();
				}
				
			});
			
			$("#bs_userid").focus();
			
		});
	
	</script>
	
<form id="frm" name="frm" action="login" method="post">
<div class="login_ct_wrap" id="login_page">
	<h1 class="title">
		LOGIN
	</h1>
	<div class="login_ct_box">
			<fieldset>
				<legend class="hidden">로그인</legend>
				<div class="login_ct">
					<p class="id_ipt">
						<label for="userid">아이디</label><input type="text" id="bs_userid" name="bs_userid" title="아이디" class="input_txt" maxLength="20" />
					</p>
					<p class="pw_ipt">
						<label for="pwd">비밀번호</label><input type="password" name="bs_pwd" id="bs_pwd" title="비밀번호" class="input_txt" maxLength="15" />
					</p>
					<p class="btn_login">
						<a href="#none" onclick="bs_login(); return false;" id="btn_login">로그인</a>
					</p>
					<div class="find">
						<a href="/shop/bs/user/member/findid" class="id_find">아이디 찾기</a> <span
							class="bar">|</span> <a href="/shop/bs/user/member/findpw" class="pw_find">비밀번호
							찾기</a>
					</div>
					<p class="txt">아직 버블샵 회원이 아니십니까?</p>
					<p class="join">
						<a href="/shop/bs/user/member/signup">버블샵 회원
							가입하기</a>
					</p>
			<!-- <div class="qSearch">
                  <label for="srch_value" class="hidden">배송조회</label>
                  <input type="text" title="배송조회" id="" class="searchBox" name="quick_search" value="" />
                  <a class="btn_search" onclick="goSearch(); return false;"href="">배송조회</a>
         	</div> -->
				</div>
				<div class="banner">
					<a href="" style="display:"><img
						src="https://img.tmon.co.kr//deals/banner/banner6_04cd5.jpg"
						alt="" width="388" height="296"> </a>
					
				</div>
				
			</fieldset>
	</div>
</div>
</form>
<!-- <div class="qsearch_res">
	<div class="buy_lst">
			<table>
				<caption>구매내역</caption>
				<colgroup>
					<col width="170">
					<col width="500">
					<col width="121">
					<col width="139">
				</colgroup>
				<thead>
					<tr>
						<th scope="colgroup" colspan="2">구매내역</th>
						<th scope="col">배송상태</th>
						<th scope="col">관리</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="rowgroup" rowspan="2" class="deal_info">
							<div class="date_num">
								주문일
								<p>
									<strong>2014.06.01</strong>
								</p>
								 주문번호
								<p>
									<em>669341153</em>
								</p>
							</div>
							<div class="payment">
								<p>총 주문 금액 :</p>
								<p class="won">
									<em>28,600</em><span class="txt_won">원</span>
								</p>
								<p class="coupon">
									(적립금 <em>0</em>원 사용)
								</p>
							</div>
							<div class="account">
								<p>
									입금기한 : <strong>2014.06.03</strong>
								</p>
							</div>
						</th>
						<th class="sum_up">
							<div class="thmb_area">
								<a href=""><img
									src="https://img.tmon.co.kr/deals/7201/72011857/around_c53b0.jpg"
									width="106" height="71" alt="구매상품 썸네일" class="thmb"> </a>
								<h4>
									<a href="">산뜻한 린넨셔츠&amp;반바지 여름 풀코디</a>
								</h4>
								<p class="pay_info">
									<span class="won"><em>28,600</em>원</span> (입금대기)
								</p>
							</div>
							<p class="add_date_info">&nbsp;</p>
							<ul class="ticket_lst">
								<li>
									<div class="tit">
										<strong> 선택04) [BH]723 / 블루 / L(100) </strong>
										<p>
											(구매수량<em>1</em>개 )
										</p>
									</div>
								</li>
								<li>
									<div class="tit">
										<strong> 선택05) [AA]009 / 블랙 / L(100) </strong>
										<p>
											(구매수량<em>1</em>개)
										</p>
									</div>
								</li>
								<li>
									<div class="msg_area">배송 메모 : :D</div>
								</li>
							</ul>
						</th>
						<td class="expiry">
							<p class="p_cfm"></p>
						</td>
						<td class="manage">
							<a href="" class="cancel" id="">취소/환불/교환</a>
						</td>
					</tr>
					<tr>
						<td colspan="3" class="delivery">
							<span title="" class="adr">
								<span class="bu"></span>
								배송지 정보 : 민경훈, (151-835)서울 관악구 낙성대동우쭈쭈빌딩
							</span> 
							<a href="" class="btn_adr_edt" style="display:none">배송지 수정</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
</div> -->
