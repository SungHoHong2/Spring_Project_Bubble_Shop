<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="mypage_container"> 
        <ul class="mypage_category" >
            <li class="menu1"><a href="/shop/bs/user/member/buyInfo"><span class="name">구매내역</span></a>
            </li> 
            <li class="menu2"><a href="/shop/bs/user/member/claim"><span class="name">취소,환불 내역</span></a></li>
            <li class="menu3"><a href="/shop/bs/user/member/coupon"><span class="name">할인쿠폰</span></a></li>
            <li class="menu9 on"><a href="/shop/bs/user/member/chkpwd"><span class="name">개인정보</span></a></li>
         </ul>
            
<div class="mypage_ct_wrap">
    <h3 class="tit_pw_cfm">비밀번호 확인</h3>
    <div class="pw_cfm_ct">
        <div class="user_link">
            <a href="/user/findpasswd">비밀번호 찾기</a>
        </div>
        <div class="inner">
            <p class="user_info"><strong>아이디</strong><span class="user_name">${session_userid }</span></p><!-- 병기리 DB 아이디 -->
            <p class="user_info"><strong>비밀번호</strong><input name="password" id="pwd" type="password" onkeypress="fn_chkkey(event)" autocomplete="off"></p>
            <p class="txt_info"><strong>${session_name }</strong>님의 개인정보 보호를 위해 비밀번호를 다시 한 번 확인 합니다. <br>회원님의 비밀번호가 타인에게 노출되지 않도록 주의해 주세요.</p>
        </div>
    </div>
    <div class="btn_wrap2">
        <a href="#" onclick="fn_submit(); return false;" class="btn_big"><span class="btn_cfm">확인</span></a>
    </div>
</div>

<form id="submit_frm" method="post" action="/shop/bs/user/member/userInfo">
<input type="hidden" name="password" id="submit_pwd">
<input type="hidden" name="return_url" value="%2Fuser%2Finfo">
<input type="hidden" name="scode" value="02f2aa49934e8af79a54d736bee147a15fd3164d1537ddd9a">
<input type="hidden" name="ts" value="1400757658">
<input type="hidden" name="hash" value="eb0c786b10440f4a7f6e55d57574c96b29ed7e7e">
</form>


<script type="text/javascript">  



	$(document).ready(function(){
		
			
		fn_submit = function()
		{	
			if ( $('#pwd').val() == '' )
		    {
	           alert('비밀번호를 입력하세요');
	           $('#pwd').focus();
	           return false;
		    }
			$.ajax({
			    type : "POST"
			    , async : true
			    , url : "chkpwd"
			    , dataType : "html"
			    , timeout : 3000
			    , cache : false
			    , data : ""
			    , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			    , error : function(request, status, error) {
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    },
			    success : function(response, status, request) 
			    {
			    	
			    	if($('#pwd').val()=='${bean.bs_pwd}')
			    	{
			    			
			    		/*  $('#submit_frm').val())); */
			    	     $("#submit_frm").submit();
			    	}
			    	else
			    	{
			    		$('#pwd').focus();
			    	}
			    }
			});
		}
		
		$('#pwd').focus();
	});












	function fn_chkkey(event) {
        if(event.keyCode == 13)
            fn_submit();
        return false;
    }

   /*  function fn_submit() {
    	
        if ( $('#pwd').val() == '' )
        {
            alert('비밀번호를 입력하세요');
            $('#pwd').focus();
            return;
        }
		
        $('#submit_pwd').val(RSA.encrypt($('#pwd').val(), RSA.getPublicKey("-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvTyZayVGLAgsgCWsG2j1\n1lDB7fvvX6puRH4RBc91nedwqvW2NCYYXEofdKJtffn79DgcFBYjkUI6KkXubF\/S\nhW89yABDACIWdJ4y0fafCuQRQ9yMTQNfDBx9MJSUl1htRLNZZ4bCXxlUNITNpgSs\nXDPuRk4uYCijFkVeutrNg25OzD\/PZtYDbVlhsijvNDyRFEHIktDDVVL5f2CLa9E+\nSSs+84fmSUE54oJk1RVppu2HEifI4Yy+7RaGi05Gqji3JtUij71lMTAagp9D0hRi\n1npSuM5xeqrg8f\/AdMMsxQlGiw\/gdUwFAMNBZU8Svdrdp2XyPKlse6zfyDkTwjsm\n9wIDAQAB\n-----END PUBLIC KEY-----")));
       	$("#submit_frm").submit();
    } */
</script>
    </div>