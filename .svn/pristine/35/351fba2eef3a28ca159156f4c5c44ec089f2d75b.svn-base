<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">

	$(document).ready(function(){
		
		var frm = document.frm;
		var checkPasswordTimer = null;
		
		$("#bs_userid").keyup(function(){
			
			$("#valid_userid").val("N");
			$("h_userid").val("");
			$("#guide_userid").html("* 아이디는 4자 이상이어야 합니다.");
			
			if ($(this).val().length >= 4)
			{
				var regexp = /^[A-Za-z0-9]{4,20}$/i;

				if(!regexp.test($(this).val()))
				{    
					alert("아이디는 영문 또는 숫자만 가능합니다!");
					$(this).focus();
					return false;
				}

				$.ajax({
				    type : "POST"
				    , async : true
				    , url : "signup2_ajax"
				    , dataType : "html"
				    , timeout : 3000
				    , cache : false
				    , data : "bs_userid=" + $(this).val()
				    , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
				    , error : function(request, status, error) {
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				    }
				    , success : function(response, status, request) {

				    	if (response.replace(/ /g, '').replace(/\r\n/g, '') == "Y")
				    	{
							$("#h_userid").val($("#bs_userid").val());
							$("#valid_userid").val("Y");
							$("#guide_userid").html("* 사용가능한 아이디 입니다!");
						}
						else
						{
							$("#guide_userid").html("* 이미 사용중인 아이디 입니다!");
						}
				    }
				});
			}

		});
		
		$("#bs_pwd").keypress(function(e)
	    {
	        checkCapsLock(e, '#pPwdCapsLock');
	    });

	    $("#bs_pwd").keyup(function(e)
	    {
	    	password_chk($(this));
	    });
	    
	    $("#passwd_chk").keypress(function(e)
	    {
	        checkCapsLock(e, '#pPwdCapsLock2');
	    });
	    
	    $("#passwd_chk").keyup(function(e)
	    {
	    	password_chk($(this));
	    });
		
		
		
		
		/*  비밀번호 체크  */
		checkCapsLock = function(e, layer)
	    {
	        var s = String.fromCharCode( e.which );
	        if ( s.toUpperCase() === s && s.toLowerCase() !== s && !e.shiftKey ) 
	        {
	            $(layer).show();
	            return false;
	        }
	        else
	        {
	            $(layer).hide();
	        }
	        return true;
	    }
		
		checkPasswordLength = function(password, layer)
	    {
	        if (password.length < 6 || password.length > 15) {
	            $(layer).find('p').html('6~15자 범위로 입력하셔야 합니다.');
	            $(layer).show();
	            return false;
	        }
	        else 
	        {
	            $(layer).hide();
	        }
	        return true;
	    }

	    checkPasswordRepeat = function(password, layer)
	    {
	        var ch = '';
	        var cnt = 0;
	        for(var i=0;i<password.length;i++)
	        {
	            if(password.charAt(i)==ch)
	            {
	                cnt++;
	                if(cnt>=4)
	                {
	                    $(layer).find('p').html('4개 이상의 연속된 문자는 입력할 수 없습니다.');
	                    $(layer).show();
	                    return false;
	                }
	            }
	            else
	            {
	                cnt = 1;
	                ch = password.charAt(i);
	            }
	        }
	        $(layer).hide();
	        return true;
	    }

	    checkPasswordComplexity = function(password, layer)
	    {
	        var checkVal = 0;
	        if (password.match(/[0-9]/g)!=null) checkVal++;
	        if (password.match(/[a-z]/g)!=null) checkVal++;
	        if (password.match(/[A-Z]/g)!=null) checkVal++;
	        if (password.match(/\W/g)!=null) checkVal++;

	        if(checkVal < 2)
	        {
	            $(layer).find('p').html('영문 대/소문자, 숫자, 특수문자 중 2개 이상 조합되어야 합니다.');
	            $(layer).show();
	            return false;
	        }
	        else
	        {
	            $(layer).hide();
	        }
	        return true;
	    }
	    
	    
	    
	    password_chk = function(obj)
	    {
	    	var inp = $(obj).val();
	        if(inp.length == 0) 
	        {
	            $('#divPwdLayer').hide();
	            return;
	        }
	        if(checkPasswordLength(inp, '#divPwdLayer'))
	            if(checkPasswordRepeat(inp, '#divPwdLayer'))
	                checkPasswordComplexity(inp, '#divPwdLayer');
	    }
	    
	    validatePassword = function(password)
	    {
	        var checkVal = 0;
	        if (password.match(/[0-9]/g)!=null) checkVal++;
	        if (password.match(/[a-z]/g)!=null) checkVal++;
	        if (password.match(/[A-Z]/g)!=null) checkVal++;
	        if (password.match(/\W/g)!=null) checkVal++;

	        if (checkVal < 2)
	            throw {message:'비밀번호는 영문 대/소문자, 숫자, 특수문자 중 2개 이상 조합되어야 합니다.'};

	        var ch = '';
	        var cnt = 0;
	        for(var i=0;i<password.length;i++)
	        {
	            if(password.charAt(i)==ch)
	            {
	                cnt++;
	                if(cnt>=4)
	                {
	                    throw {message:'4개 이상의 연속된 문자는 입력할 수 없습니다.'};
	                }
	            }
	            else
	            {
	                cnt = 1;
	                ch = password.charAt(i);
	            }
	        }

	        if (password.length < 6 || password.length > 15)
	            throw {message:'비밀번호는 6~15자 범위로 입력하셔야 합니다.'};
	    }
	    
	    startCheckPassword = function(editbox)
	    {
	        if (checkPasswordTimer == null)
	        {
	            var callback = function() {
	            	$("#valid_passwd").val("N");
	                try
	                {
	                    var password = $(editbox).val();
	                    if (password)
	                    {
	                        validatePassword(password);
	                        $("#password_validate_disallow").hide();
	                        $("#password_validate_allow").show();
	                        $("#valid_passwd").val("Y");
	                    }
	                    else
	                    {
	                        $("#password_validate_disallow").hide();
	                        $("#password_validate_allow").hide();
	                    }
	                }
	                catch(e)
	                {
	                    $("#password_validate_disallow").show();
	                    $("#password_validate_allow").hide();
	                    //console.log(e.message);
	                }
	            };
	            checkPasswordTimer = setInterval(callback, 300);
	        }
	    }
	    
	    stopCheckPassword = function()
	    {
	        if (checkPasswordTimer != null)
	        {
	            clearInterval(checkPasswordTimer);
	            checkPasswordTimer = null;
	        }
	    }
		
		
		
		$("#email_domain").change(function(){
			
			$("#email2").val("");
			
			if ($(this).val() != "direct")
			{
				$("#email2").val($(this).val());
				$("#email2").hide();	
			}
			else
			{
				$("#email2").show();
				$("#email2").focus();
			}
			
		});

		
		btn_join = function()
		{
			
			if ($("#bs_userid").val() != $("#h_userid").val() || $("#valid_userid").val() != "Y")
			{
				alert("아이디를 확인하세요!");
				$("#bs_userid").focus();
				return false;
			}
			
			if (form_chk(frm, "user_name,user_hp"))
			{
				if ($("#bs_userid").val().length < 4)
				{
					alert("아이디는 4자이상이야 합니다!");
					$("#bs_userid").focus();
					return false;
				}
				
				if ($("#bs_userid").val() != $("#h_userid").val() || $("#valid_userid").val() != "Y")
				{
					alert("아이디를 확인하세요!");
					$("#bs_userid").focus();
					return false;
				}
				
				if ($("#valid_passwd").val() != "Y")
				{
					alert("비밀번호 보안등급이 낮습니다.\r\n비밀번호를 확인하세요!");
					$("#bs_pwd").focus();
					return false;
				}
				
				if ($("#bs_pwd").val() != $("#passwd_chk").val())
				{
					alert("비밀번호와 비밀번호 확인이 일치 하지 않습니다!")
					$("#bs_pwd").focus();
					return false;
				}
				
				$("#bs_email").val($("#email1").val() + "@" + $("#email2").val());
				
				if (!Check_Mail($("#bs_email").val()))
				{
					alert("이메일 주소를 확인하세요");
					$("#email1").focus();
					return false;
				}
				
				if ($("#c_1:checked").val() != "Y")
				{
					alert("이용약관에 동의하셔야 합니다!");
					$("#c_1").focus();
					return false;
				}
				
				if ($("[name='rdo_chk']:checked").val() != "Y")
				{
					alert("개인정보 수집 및 이용 동의하셔야 합니다");
					$("[name='rdo_chk']").eq(0).focus();
					return false;
				}
				
				$("#frm").submit();

			}
		}
		
		btn_cancel = function()
		{
			
		}
		
		$("#bs_userid").focus();
		
	});

</script>
    

<form id="frm" name="frm" method="post" action="signup2ok">
	<input type="hidden" id="h_userid" />
	<input type="hidden" id="valid_userid" value="N" />
	<input type="hidden" id="valid_passwd" value="N" />

    <input type="hidden" id="bs_name" name="bs_name" value="${bean.bs_name }" />
    <input type="hidden" id="bs_hp" name="bs_hp" value="${bean.bs_hp }" />
    
    <input type="hidden" id="bs_email" name="bs_email" value="" />
    <input type="hidden" id="bs_sex" name="bs_sex" value="${bean.bs_sex }" />
    <input type="hidden" id="bs_birth" name="bs_birth" value="${bean.bs_birth }" />
<div class="signup_wp">
            <div class="steps">
                <!-- [D] 선택된 단계 span에 on 클래스 추가 -->
                <ol>
                <li class="step1"><span class="sp_sup">Step01 - 본인 인증</span><em class="sp_sup ar"></em></li>
                <li class="step2"><span class="sp_sup on">Step02 - 정보 입력 및 약관동의</span><em class="sp_sup ar"></em></li>
                <li class="step3"><span class="sp_sup">Step03 - 가입 완료</span></li>
                </ol>
            </div>
            
<div class="tit_area">
    <h3 class="sp_sup prinfo_extend">개인정보 입력</h3>
    <p class="must"><em class="ico_circle"></em>표시정보는 필수 입력 사항입니다.</p>
</div>
<table cellspacing="0" border="1" class="tbl_join">
<colgroup><col width="131"><col width="">
</colgroup><tbody>
<tr class="first">
<th scope="row"><p>이름</p></th>
<td>
    <input type="text" id="user_name" name="user_name" value="${bean.bs_name }" title="이름" disabled="disabled" class="txt fl" style="width:168px">
</td>
</tr>
<tr>
<th scope="row"><p>휴대폰</p></th>
<td>
    <input type="text" id="user_hp" name="user_hp" value="${bean.bs_hp }" title="휴대폰" disabled="disabled" class="txt fl" style="width:168px">
</td>
</tr>
<tr>
<th scope="row"><p><span class="ico_circle">필수입력 - </span>아이디</p></th>
<td>
    <input type="text" id="bs_userid" name="bs_userid" class="txt fl" style="width:168px" maxlength="20" value="" title="아이디" />
    <span class="guide" id="guide_userid">* 아이디는 4자 이상이어야 합니다.</span>
</td>
</tr>
<tr>
<th scope="row"><p><span class="ico_circle">필수입력 - </span>비밀번호</p></th>
<td>
    <input type="password" class="txt fl" style="width:168px" id="bs_pwd" name="bs_pwd" onfocus="startCheckPassword(this);" onfocusout="stopCheckPassword();" maxlength="15" title="비밀번호" />
	<div class="uio_ly_balloon" style="left:355px;display:none;" id="password_validate_disallow"><div class="ly_member">보안등급 : <strong class="no">불가<span>X</span></strong><span class="arr"></span></div></div>
    <div class="uio_ly_balloon" style="left:355px;display:none;" id="password_validate_allow"><div class="ly_member">보안등급 : <strong class="safe">안전<span>O</span></strong><span class="arr"></span></div></div>
    <span class="guide" id="guide_passwd">6~15자의 영문 대소문자, 숫자, 특수문자 2개이상 사용하실 수 있으며 연속된 숫자 및 문자(4개이상)제한 합니다.</span>
    <p class="noti_capslock" id="pPwdCapsLock" style="display:none;"><span class="spr_ico ico_attention2">!</span> Caps Lock이 켜져 있습니다.</p>

</td>
</tr>
<tr>
<th scope="row"><p><span class="ico_circle">필수입력 - </span>비밀번호 확인</p></th>
<td>
    <input type="password" class="txt fl" style="width:168px" id="passwd_chk" name="passwd_chk" value="" tilte="비밀번호 확인" />
    <span class="guide" id="guide_passwd_chk">* 설정하신 비밀번호를 한번 더 입력해주세요.</span>
    <p class="noti_capslock" id="pPwdCapsLock2" style="display:none;"><span class="spr_ico ico_attention2">!</span> Caps Lock이 켜져 있습니다.</p>
</td>
</tr>
<tr>
<th scope="row"><p><span class="ico_circle">필수입력 - </span>이메일</p></th>
<td>
    <input type="text" id="email1" class="txt" style="width:168px" title="이메일" /> @ <input type="text" id="email2" class="txt" style="width:118px" title="이메일" />
    <select id="email_domain">
        <option value="direct">직접입력</option>
    <option value="naver.com">naver.com</option>
    <option value="daum.net">daum.net</option>
    <option value="hanmail.net">hanmail.net</option>
    <option value="nate.com">nate.com</option>
    <option value="gmail.com">gmail.com</option>
    <option value="paran.com">paran.com</option>
    <option value="chol.com">chol.com</option>
    <option value="dreamwiz.com">dreamwiz.com</option>
    <option value="empal.com">empal.com</option>
    <option value="freechal.com">freechal.com</option>
    <option value="hanafos.com">hanafos.com</option>
    <option value="hanmir.com">hanmir.com</option>
    <option value="hitel.net">hitel.net</option>
    <option value="hotmail.com">hotmail.com</option>
    <option value="korea.com">korea.com</option>
    <option value="lycos.co.kr">lycos.co.kr</option>
    <option value="netian.com">netian.com</option>
    <option value="yahoo.co.kr">yahoo.co.kr</option>
    <option value="yahoo.com">yahoo.com</option>
    </select>
</td>
</tr>
<tr>
    <th scope="row"><p><span class="ico_circle">필수입력 - </span>SMS/메일<br>수신동의</p></th>
    <td>
        <p class="txt">
            휴대폰번호와 입력하신 메일로 다양한 혜택과 각종 할인/상품 정보에 대한 안내를 받겠습니다.<br>
            <span>(거래정보와 관련된 내용은 수신동의 여부와 관계없이 발송됩니다.)</span>
        </p>
        <div class="agree">
            <span class="bu">·</span><em>SMS 수신동의</em>
            <input type="radio" name="bs_sms_yn" checked="checked" value="Y" class="form_input"><label for="smsAgree" class="form_label">예</label>
            <input type="radio" name="bs_sms_yn" value="N" class="form_input"><label for="smsNo" class="form_label" style="margin-right:36px">아니오</label>
            <span class="bu">·</span><em>메일 수신동의</em>
            <input type="radio" name="bs_email_yn" checked="checked" value="Y" class="form_input"><label for="mailAgree" class="form_label">예</label>
            <input type="radio" name="bs_email_yn" value="N" class="form_input"><label for="mailNo" class="form_label">아니오</label>
        </div>
    </td>
</tr>

<!-- 
<tr class="contact">
<th scope="row"><p>연락처</p></th>
<td>
    <select style="width:77px" id="hp1">
        <option sg:foreach="$self->hp_prefixes as $k=>$v" value="yahoo.com">yahoo.com</option>
    </select>
    - <input type="text" id="hp2" class="txt" style="width:71px" maxlength="4" value=""> 
    - <input type="text" id="hp3" class="txt" style="width:77px" maxlength="4" value="">
    <button href="#" class="btn_cfm_mobile" id="hp_auth">휴대폰 인증</button>

    <input type="text" id="hp_auth_code" class="txt validate_phone hp_auth_cont" style="display:none;" maxlength="4">
    <button href="#" id="hp_auth_validation" class="btn_cfm validate_phone hp_auth_cont" style="display:none;">확인</button>
    <input type="hidden" id="hp_token">

    <div class="noti3">
        <p class="dsc">입력한 연락처와 메일로 다양한 혜택과 각종 할인/상품 정보에 대한 안내를 받겠습니다. <span>(거래정보와 관련된 내용은 수신동의 여부와 관계없이 발송됩니다.)</span></p>
        <div class="sel">
            <span><em class="bu"></em>SMS 수신동의</span>
            <input type="radio" name="allow_sms" checked value="Y" disabled><label for="chk_1">예</label>
            <input type="radio" name="allow_sms" value="N" disabled><label for="chk_1">아니요</label>
        </div>
        <div class="sel">
            <span><em class="bu"></em>메일 수신동의</span>
            <input type="radio" name="allow_email" checked value="Y" disabled><label for="chk_2">예</label>
            <input type="radio" name="allow_email" value="N" disabled><label for="chk_2">아니요</label>
        </div>
    </div>
</td>
</tr>
 -->

<!-- [D] 추천링크 유입시만 추천인/추가적립금 노출 -->
</tbody></table>
<div class="tit_area">
    <h3 class="sp_sup terms">약관동의</h3>
</div>
<div class="terms_wp">
   <!-- <div class="check_all">
        <input type="checkbox" id="c_5" class="chk"><label for="c_5">아래의 이용약관, 개인정보 수집 및 이용에 모두 동의합니다.</label>
    </div>-->
    <div class="clause">
        <div>
            <strong>(주)버블샵 서비스 이용약관</strong>
 <br><br>
제1조(목적)<br>
이 약관은 (주)버블샵(이하 "회사"라 함)가 운영하는 인터넷사이트(이하 "사이트"라 함)를 통하여 제공하는 전자상거래 서비스(이하 "서비스"라 함)와 관련하여 “회사”와 “회원”(제2조에 정합니다)의 권리와 의무, 책임사항 및 “회원”의 “서비스” 이용절차에 관한 사항을 규정함을 목적으로 합니다. 이 약관은PC 통신, 스마트폰(안드로이드폰, 아이폰 등) 앱, 제휴 은행 사이트 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 준용됩니다.<br>
<br>
제2조(용어의 정의)<br>
(1) 이 약관에서 사용하는 용어의 정의는 다음과 같습니다.<br>
1) “회사”가 운영하는 “사이트”(2013. 10. 현재)는 아래와 같습니다.<br>
- ticketmonster.co.kr<br>
- tmon.co.kr<br>
- 추후 “회사”에서 공지하고 제공하는 기타 웹사이트<br>
2) 회원: “회사”에 개인정보를 제공하여 회원등록을 한 자로서 이 약관에 따라 “회사”와 “서비스” 이용계약을 체결하고 아이디를 부여 받은 자를 말합니다.<br>
3) 아이디(ID): “회원”의 식별과 “서비스” 이용을 위하여 “회원”이 선정하고 “회사”가 승인한 문자와 숫자의 조합을 말합니다.<br>
4) 비밀번호(Password): “회원”의 동일성 확인과 “회원”의 권익 및 비밀보호를 위하여 “회원” 스스로가 설정하여 “회사”에 등록한 영문과 숫자의 조합을 말합니다.<br>
5) 티몬 적립금: “서비스”를 이용할 때 현금처럼 사용할 수 있는 “회사” 전용의 사이버 화폐를 말합니다.<br>
6) 티켓: 상품 또는 서비스(이하“재화 등”이라 합니다)를 정상적인 가격보다 할인된 가격으로 이용할 수 있는 디지털 증권을 말합니다.<br>
7) 할인쿠폰: “티켓” 또는 “재화 등”을 구매할 때 증권 상 표기된 액면가액만큼 할인 받을 수 있는 디지털 증권을 말합니다.<br>
8) 게시물: “회원”이 “서비스”를 이용함에 있어 “사이트” 상에 게시한 부호, 문자, 음성 형태의 글, 사진, 동영상 및 각종 파일과 링크 등을 의미합니다.<br>
(2) 이 약관에서 정의되지 않은 용어는 관련법령이 정하는 바에 따릅니다.<br>
 <br>
제3조(약관의 명시와 설명 및 개정)<br>
(1) “회사”는 이 약관의 내용과 “회사”의 상호, 영업소 소재지, 대표자의 성명, 사업자등록번호, 연락처(전화, 팩스, 전자우편 주소 등) 등을 “회원”이 알 수 있도록 “사이트”의 초기 “서비스” 화면에 게시합니다. 다만, 이 약관의 구체적 내용은 “회원”이 연결화면을 통하여 볼 수 있습니다.<br>
(2) “회사”는 약관의 규제에 관한 법률, 전자거래기본법, 전자서명법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 전자상거래 등에서의 소비자보호에 관한 법률, 소비자기본법, 위치정보의 보호 및 이용 등에 관한 법률 등 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.<br>
(3) “회사”가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행 약관과 함께 “사이트” 내 공지사항 란에 최소 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다.<br>
(4) 전 항에 따라 공지된 적용일자 이후에 “회원”이 “회사”의 “서비스”를 계속 이용하는 경우에는 개정된 약관에 동의하는 것으로 봅니다. 개정된 약관에 동의하지 아니하는 “회원”은 언제든지 자유롭게 “서비스” 이용계약을 해지할 수 있습니다. 유료 “서비스”를 이용하는 “회원”이 약관의 개정에 동의하지 아니하여 해지할 경우 “회사”가 정한 환불정책에 따릅니다.<br>
(5) 이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 정부가 제정한 전자상거래 등에서의 소비자보호 지침 및 관련법령에 따릅니다.<br>
 (6) “회사”는 “회원”에게 “서비스”의 성질에 따라 다음 “서비스” 이용시 특칙 규정이 관련조항에 우선하여 적용됩니다. 특칙 규정에서 정하지 아니한 사항에 대해서는 이 약관의 각 조건이 적용될 수 있는 사항인 경우 이 약관이 공통적 또는 보충적으로 적용됩니다.<br>
- 제16조의2(배송 상품의 티켓사용 특칙)<br>
- 제17조의2(공연업/여행업에서의 환불 특칙)<br>
- 제17조의3(상품에서의 환불 특칙)<br>
<br>
제4조(개별 서비스에 대한 약관 및 이용조건)<br>
“회사”는 제공하는 “서비스”의 구체적 내용에 따라 개별 “서비스”에 대한 약관 및 이용조건을 각 개별 “서비스”마다 별도로 정하여 “회원’의 동의를 얻을 수 있습니다. 이 경우 개별 “서비스”에 대한 이용약관 등이 본 약관에 우선합니다.<br>
<br>
제5조(이용계약의 성립)<br>
(1) 이용계약은 “회원”의 약관 동의, 이용신청에 대한 “회사”의 승낙에 의하여 성립합니다.<br>
(2) 이용계약의 성립시기는 “회사”가 가입완료 표시를 신청절차 상에서 표시한 시점으로 합니다.<br>
(3) 이용계약은 만14세 이상의 회원이 할 수 있습니다.<br>
 <br>
제6조(이용신청 및 승낙)<br>
(1) “회원”은 “회사”가 정한 가입 양식에 따라 회원정보(필수정보, 추가정보(예: 소속 직장, 사번 등))를 기입한 후 이 약관에 동의한다는 의사표시를 함으로써 회원가입을 신청합니다.<br>
(2) “회사”는 전 항에 따른 이용신청 시 “회원”에게 전문기관을 통한 본인인증 절차를 요청할 수 있습니다.<br>
(3) “회사”는 다음 각 호에 해당하는 이용신청에 대하여는 이를 승낙하지 아니하거나 사후에 이용계약을 해지할 수 있습니다.<br>
1) “회사”가 실명확인절차를 실시할 경우에 “회원”의 실명이 아님이 확인된 경우<br>
2) 이미 가입된 “회원”과 이름 및 전자우편 주소가 동일한 경우<br>
3) 타인의 명의를 도용하거나, 기입내용에 허위, 기재누락, 오기가 있는 경우<br>
4) “회사”에 의하여 이용계약이 해지된 날로부터3개월 이내에 재이용 신청을 하는 경우<br>
5) 이 약관에 의하여 이전에 회원자격을 상실한 적이 있는 경우. 다만, 회원자격 상실 후 3개월이 경과한 자로서 “회사”의 “회원” 재가입 승낙을 얻은 경우에는 예외로 합니다.<br>
6) 부정한 용도 또는 영리를 추구할 목적으로 “서비스”를 이용하고자 하는 경우<br>
7) 관련법령에 위배되거나 사회의 안녕질서 혹은 미풍양속을 저해할 수 있는 목적으로 신청한 경우<br>
8) “회사”의 “서비스” 운영에 따른 설비에 여유가 없거나 기술상 지장이 있는 경우. 다만, 이 경우 그 사유가 해소될 때까지 이용 승낙을 유보할 수 있습니다.<br>
9) 만14세 미만의 아동이 이용신청을 하는 경우<br>
10) 기타 이 약관에 위배되거나 위법 또는 부당한 이용신청임이 확인된 경우 및 “회사”가 합리적인 판단에 의하여 필요하다고 인정하는 경우<br>
(4) “회원”은 가입신청 시 작성한 이용신청 사항에 변경이 있는 경우 “사이트”에서 온라인으로 개인정보를 수정하거나 전자우편 기타방법으로 “회사”에 대하여 그 변경 사항을 알려야 합니다. 이를 알리지 않아 발생하는 불이익에 대한 책임은 “회원”에게 있습니다. <br>
<br>
제7조(서비스 이용시간)<br>
“서비스”의 이용은 “회사”의 업무상 또는 기술상 특별한 지장이 없는 한 연중무휴1일24시간을 원칙으로 합니다. 다만, 정기 점검 등의 필요로 “회사”가 정한 날이나 시간은 제외됩니다.<br>
<br>
제8조(회원의 아이디 및 비밀번호에 대한 의무)<br>
(1) “아이디”와 “비밀번호”에 관한 관리책임은 “회원”에게 있으며, 이를 소홀히 하여 발생한 모든 민형사상의 책임은 “회원” 자신에게 있습니다.<br>
(2) “회원”은 자신의”아이디”및 “비밀번호”를 제3자가 이용하게 해서는 안됩니다.<br>
(3) “회원”이 자신의”아이디”및 “비밀번호”를 도난 당하거나 제3자가 사용하고 있음을 인지한 경우에는 즉시 “회사”에 통보하고 “회사”의 조치가 있는 경우에는 그에 따라야 합니다.<br>
(4) “회원”이 전 항에 따른 통지를 하지 않거나 “회사”의 조치에 응하지 아니하여 발생하는 모든 불이익에 대한 책임은 “회원”에게 있습니다.<br>
 <br>
제9조(회원의 의무)<br>
(1) “회원”은 관계법령, 이 약관의 규정, 이용안내 등 “회사”가 통지하는 사항을 준수하여야 하며, 기타 “회사” 업무에 방해되는 행위를 하여서는 안됩니다.<br>
(2) “회원”은 “서비스” 이용과 관련하여 다음 각 호의 행위를 하여서는 안됩니다.<br>
1) “서비스” 신청 또는 변경 시 허위내용의 등록<br>
2) “회사”가 게시한 정보의 허가 받지 않은 변경<br>
3) “회사”가 정한 정보 이외의 정보(컴퓨터 프로그램 등)의 송신 또는 게시<br>
4) “회사” 및 기타 제3자의 저작권 등 지적 재산권에 대한 침해<br>
5) “회사” 및 기타 제3자의 명예를 손상시키거나 업무를 방해하는 행위<br>
6) 외설 또는 폭력적인 메시지, 동영상, 음성 기타 공공질서, 미풍양속에 반하는 정보를 “사이트”에 공개 또는 게시하는 행위<br>
7) “회원”의 의무 불이행<br>
8) 기타 관련법령이나 “회사”에서 정한 규정에 위배되는 행위<br>
 <br>
제10조(회사의 의무)<br>
(1) “회사”는 관련법령과 이 약관이 금지하거나 공공질서, 미풍양속에 반하는 행위를 하지 않으며, 이 약관이 정하는 바에 따라 지속적이고 안정적으로 “서비스”를 제공하기 위하여 최선을 다하여야 합니다.<br>
(2) “회사”는 “회원”이 안전하게 “서비스”를 이용할 수 있도록 “회원”의 개인정보(신용정보 포함)보호를 위한 보안 시스템을 갖추어야 하며 개인정보취급방침을 공시하고 준수합니다.<br>
<br>
제11조(구매신청)<br>
(1) “회원”은 이 약관 및 “회사”가 정한 규정에 따라 아래와 같이 “재화 등”의 구매를 신청합니다.<br>
- 회원정보(성명, 연락처, 전자우편 주소) 입력<br>
- “재화 등”의 선택사항 입력<br>
- 배송지 정보(이름, 연락처, 주소) 입력<br>
- 결제방법의 선택<br>
- 개인정보 제3자 제공 및 이용 조건에 동의한다는 표시(예, 마우스 클릭)<br>
(2) 결제와 관련하여 “회원”이 입력한 정보 및 그 정보와 관련하여 발생한 책임과 불이익은 전적으로 “회원”이 부담하여야 합니다.<br>
(3) “회사”는 “회원”이 구매신청을 완료한 후 “회사”가 정한 양식에 따라 회원정보를 추가하거나 수정할 것을 요구할 수 있고, “회사”는 회원정보에 따라 “회원”에게 별도 “서비스”를 제공할 수 있습니다.<br>
<br>
제12조(사용 가능한 결제 수단)<br>
(1) “회원”은 “회사”에서 구매한 “재화 등”에 대한 대금지급방법을 다음 각 호의 하나로 할 수 있습니다.<br>
1) 신용카드 등<br>
2) 선불카드<br>
3) 티몬 적립금<br>
4) 할인쿠폰<br>
5) 휴대폰 결제<br>
6) 실시간 계좌이체<br>
7) 가상 계좌(단, “회사” 정책에 따라 이용 범위가 제한될 수 있습니다)<br>
8) 기타 “회사”가 추가 지정하는 결제 수단 <br>
(2) “회사”는 “회원”의 대금 지급에 법적, 기술적 문제가 발생하거나 “회사”가 예견하지 못한 장애(은행 통신망 장애 등)가 발생하는 경우 “회사”의 정책에 따라 “회원”에게 결제 수단의 변경을 요청하거나 잠정 결제보류 내지 거부할 수 있습니다.<br>
<br>
제13조(티몬 적립금 서비스)<br>
(1) “회원”은 “티몬 적립금”을 “사이트”에서 “재화 등”의 구매 시 결제 수단으로 사용할 수 있으며, “회사”는 “티몬 적립금”의 적립기준, 사용방법, 사용기한 및 제한에 대한 사항을 “서비스” 화면에 별도로 게시하거나 통지합니다. “티몬 적립금”의 사용조건에 관한 사항은 “회사”의 정책에 따라 달라질 수 있습니다.<br>
(2) “티몬 적립금”의 유효기간은 원칙적으로 전환/적립 후6개월이며, 유효기간 동안 사용하지 않을 경우 순차적으로 소멸됩니다. 다만, 마케팅 기타 프로모션 등을 통하여 지급되는 “티몬 적립금”의 유효기간은 각각 별도로 설정될 수 있습니다. <br>
(3) “티몬 적립금”은 현금으로 환급될 수 없으며, “티몬 적립금”의 사용 기간이 만료되거나 이용계약이 종료되면 소멸됩니다. <br>
(4) “회원”은 “티몬 적립금”을 제3자와 유상으로 거래하거나 현금으로 전환할 수 없습니다.<br>
(5) “회사”는 “회원”이 부정한 목적이나 용도로 “티몬 적립금”을 사용할 경우 “티몬 적립금”을 박탈하거나 “회원” 자격을 정지할 수 있습니다.<br>
(6) “회원” 탈퇴 시 전환/적립된 “티몬 적립금” 중 미사용한 “티몬 적립금”은 즉시 소멸되며, 탈퇴 후 재가입하더라도 소멸된 “티몬 적립금”은 복구되지 아니합니다.<br>
 <br>
제14조(할인쿠폰 서비스)<br>
(1) “회사”는 “할인쿠폰”을 발행하여 “회원”이 “할인쿠폰”을 “사이트”에서 “티켓” 또는 “재화 등”의 구매 시 결제 수단으로 사용할 수 있도록 그 사용 대상, 사용 방법, 사용 기간, 할인 금액 등을 정할 수 있습니다. “할인쿠폰”의 종류 또는 내용은 “회사”의 정책에 따라 달라질 수 있습니다.<br>
(2) “회사”는 “할인쿠폰”의 사용 대상, 사용 방법, 사용 기간, 할인 금액 등을 “할인쿠폰” 및/또는 “서비스” 화면에 별도로 표시하거나 통지합니다. <br>
(3) “할인쿠폰”은 현금으로 환급될 수 없으며, “할인쿠폰”의 사용 기간이 만료되거나 구매 취소 시 또는 이용계약이 종료되면 소멸합니다. “회원”은 “할인쿠폰”을 제3자와 유상으로 거래하거나 현금으로 전환할 수 없습니다.<br>
(4) “회사”는 “회원”이 “할인쿠폰” 사용 후 구매 취소 또는 환불을 요청하는 경우, “회원”이 기 사용한 “할인쿠폰”의 유효기간과 동일한 “할인쿠폰”을 복구하여 지급합니다. 다만, “회사”가 미사용 쿠폰 70% 환불 정책에 따르는 경우에는 미사용 쿠폰 가액의 70%에 해당하는 금액에서 이미 사용한 “할인쿠폰” 가액을 공제한 금액(이하 “잔액”이라 함)을 “회원”에게 “티몬 적립금”으로 반환하며, “잔액”이 남아 있지 않은 경우에는 반환하지 않습니다.<br>
(5) “회사”는 “회원”이 부정한 목적이나 용도로 “할인쿠폰”을 사용할 경우 “할인쿠폰”을 박탈하거나 “회원” 자격을 정지할 수 있습니다.<br>
(6) “회원” 탈퇴 시 “회사”로부터 발급받은 “할인쿠폰” 중 미사용한 “할인쿠폰”은 즉시 소멸되며, 탈퇴 후 재가입하더라도 소멸된 “할인쿠폰”은 복구되지 아니합니다.<br>
<br>
제15조(티켓전송)<br>
(1) “회사”는 “회원”이 구매한 “티켓”의 상세 내용을 SMS 또는 전자우편으로 발송합니다.<br>
(2) “티켓” 전송작업은 공휴일과 “회사”가 쉬는 날 및 처리과정의 상황에 따라 변경될 수 있으며, 이는 “사이트” 내 해당 콘텐츠에 명시된 내용을 따릅니다.<br>
 <br>
제16조(티켓 사용)<br>
(1) “회원”은 소셜커머스업의 특성상 개별조건에 명시된 유효 기간 내에 한해서만 “티켓”을 사용할 수 있습니다. “회원”이 유효기간 내에 “티켓”을 사용하지 못한 경우 “회사”의 환불정책에 따라 일부 서비스에 한하여 “티몬 적립금”으로 환불할 수 있으며, 그 유효기간은 6개월로 합니다.<br>
(2) 각 “티켓”1매에 대한 이용 가능횟수는1회로 한정됩니다. “회원”이 “티켓”의 액면가를 모두 사용하지 않은 경우, 잔액에 대한 환불은 이루어지지 않습니다.<br>
(3) “회원”은 “사이트”에 명시된 내용 및 개별 주의사항(사용정보 등)을 확인하여야 할 책임이 있으며, 명시된 이용조건에 따라서만 “티켓”을 사용할 수 있습니다.<br>
<br>
제16조의2(배송 상품의 티켓사용 특칙)<br>
(1) “회사”는 공동구매 대상 “티켓”이 서비스 이용이 아닌 상품의 구매를 내용으로 하는 경우, 상품의 배송에 관하여 별도의 약정이 없는 한 “회원”이 상품을 구매한 날부터 빠른 시일 내에 상품을 배송할 수 있도록 주문제작, 포장 등 기타의 필요한 조치를 취합니다.<br>
(2) “회사”는 “회원”이 구매한 상품에 대한 배송방법, 배송비용, 배송기간 등을 명시합니다. <br>
(3) “회사”와 “회원” 간에 상품의 인도시기에 관하여 별도의 약정이 있는 경우에는 이 약관에 우선합니다.<br>
 <br>
제17조(티켓의 구매취소, 청약철회 등)<br>
(1) “회사”의 구매취소 및 청약철회 규정은 전자상거래 등에서의 소비자보호에 관한 법률 등 관련 법령을 준수합니다.<br>
(2) “회사”는 “회원”이 구매 신청한 “티켓”이 해당 “서비스”가 정한 개별 조건 상의 목표인원을 충족시키지 못해 공동구매가 성사되지 않는 경우에는 지체 없이 그 사유를 “회원”에게 통지하고, 사유발생일 다음날 오전 0시부터3영업일 이내에 환불절차를 취합니다.<br>
(3) 공동구매가 성사되어 “티켓”을 구매하게 된 “회원”은 수신확인의 통지를 받은 날(전자우편 또는 SMS 통지 등을 받은 날) 또는 상품을 공급받은 날로부터 7일(청약 철회기간) 이내에 “회사”에 티켓 구매 청약을 철회할 수 있습니다.<br>
(4) “회원”의 단순 변심에 의한 취소 및 환불일 경우 이의 처리에 발생하는 수수료는 “회원”이 부담합니다.<br>
(5) 공동구매 “티켓”의 판매 기간을 기준으로 공동구매가 성사된 이상, 추후 청약철회로 인하여 당초 정한 최소 구매인원에 미치지 못하게 되었다 하더라도, 일단 성사된 공동구매에는 아무런 영향을 미치지 아니합니다.<br>
(6) “회원”은 “재화 등”의 내용이 표시∙광고 내용과 다르거나 계약 내용과 다르게 이행된 때에는 그 “재화 등”을 공급받은 날부터 3월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 청약을 철회 할 수 있습니다.<br>
(7) 개별 “재화 등”의 성격에 따라 “회사”는 별도 계약 및 이용조건에 따른 구매취소 및 청약철회 관련 규정을 정할 수 있으며 이 경우 별도 계약 및 이용조건상의 구매취소 및 청약철회 규정이 우선 적용됩니다.<br>
(8) 신용카드로 결제한 “회원”의 경우 구매 취소 시 기존에 결제하였던 내역을 취소하며 취소 시점에 따라 예매 취소 수수료를 재승인 합니다. 이 경우 구매 취소 시점과 해당 카드사의 환불 처리기준에 따라 취소금액의 환급 방법과 환급일은 다소 차이가 있을 수 있으며, 사용한 신용카드의 환불 정책은 신용카드회사에 직접 문의해 주시기 바랍니다.<br>
(9) 가상계좌로 결제한 “회원”의 경우 구매 익일 23시 59분 59초까지 “재화 등”의 대금을 송금하지 않는 때에는 “회사”는 “회원”의 “티켓”을 구매 취소 처리합니다. 이 경우 “회원”은 가상계좌 대금 송금 기간 연장이나 구매 취소 처리의 복구를 “회사”에게 요구할 수 없습니다.<br>
(10) 미성년자 또는 미성년자의 법정대리인은 미성년자의 구매를 취소할 수 있으며 구체적인 내용은 민법 상 미성년자의 법률행위 취소 규정에 따릅니다.<br>
(11) “회원”이 타인의 신용카드 또는 휴대전화번호를 도용하여 부당한 이익을 편취하였다고 의심되는 경우 “회사”는 “회원”에게 소명 자료를 요청하고 환불을 보류할 수 있습니다.<br>
(12) 기타 이 약관 및 “사이트”의 이용안내에 규정되지 않은 취소 및 환불에 대한 사항에 대해서는 소비자 피해보상 규정에서 정한 바에 따릅니다.<br>
 <br>
제17조의2(공연업/여행업에서의 환불 특칙)<br>
(1) 제17조 제3항에도 불구하고, 공연업 및 여행업의 경우에는 예약 및 그에 따른 공연 및 여행서비스 준비 등의 특수한 사정이 있는 관계로 별도의 특별약관이 우선하여 적용됩니다.<br>
(2) “회원”이 “사이트”에서 상시 판매하는 숙박상품을 일반예약(객실 미확정 상품)하여 구매하는 경우 대금결제는 예약과 동시에 이루어집니다. 만일, 일반예약 상품의 잔여객실이 없을 경우 결제가 취소되므로 “회원”에게 별도의 요금이 청구되지 않습니다. 다만, “회원”의 사정으로 인하여 일반예약 상품의 결제를 취소하는 경우에는 “사이트”에 명시된 별도의 특별약관에서 정한 바에 따릅니다.<br>
 <br>
제17조의3(상품에서의 환불 특칙)<br>
(1) 제17조 제3항에도 불구하고, 공동구매 대상 “티켓”이 서비스 이용이 아닌 상품의 구매를 내용으로 하는 경우, “회원”은 상품의 공급을 받은 날로부터 7일 이내에는 청약의 철회를 할 수 있습니다.<br>
(2) “회원”은 상품을 배송 받은 경우 다음 각 호에 해당하는 경우에는 환불 또는 교환을 요청할 수 없습니다.<br>
1) “회원”에게 책임 있는 사유로 상품이 멸실 또는 훼손된 경우<br>
2) “회원”의 사용 또는 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우<br>
3) 시간의 경과에 의하여 재판매가 곤란할 정도로 상품의 가치가 현저히 감소한 경우<br>
4) 복제가 가능한 상품의 포장을 훼손한 경우<br>
5) 기타 “회원”이 환불 또는 교환을 요청할 수 없는 합리적인 사유가 있는 경우<br>
(3) “회사”가 상품의 반품 절차에 따라 고객에게 환불하는 경우 반품하는 상품이 “회사” 또는 제휴업체에 도착하고, 반품사유 및 반품비용 부담에 대한 사항을 확인한 이후 환불이 이루어집니다.<br>
<br>
제18조(정보의 제공)<br>
(1) “회사”는 “서비스” 이용에 관한 다양한 정보를 전자우편 또는 서신우편, SMS등의 방법으로 “회원”에게 제공할 수 있으며 “회원”은 수신을 거부할 수 있습니다. 다만 “회사”는 “서비스” 이용에 필수적으로 요구되는 정보(예: 관련 규정/정책의 변경 등) 에 대해서는 “회원”의 수신거부의사와 무관하게 이를 제공할 수 있습니다.<br>
(2) “회사”는 전항에 따른 정보의 제공 이외에도 “회원”이 “회사”가 정한 양식에 따라 회원가입 시, “서비스” 이용 시 또는 구매신청 완료 후 기입한 회원정보에 대한 개별 “서비스”를 제공할 수 있습니다.<br>
<br>
제19조(회원에 대한 통지)<br>
(1) “회사”가 “회원”에 대한 통지를 하는 경우, “회원”이 가입신청 시 “회사”에 제출한 전자우편 주소나 SMS로 할 수 있습니다.<br>
(2) “회사”가 불특정다수의 “회원”에게 통지하는 경우, 1주일 이상 “사이트”에 게시함으로써 개별 통지에 갈음할 수 있습니다. 다만, “회원” 본인의 거래에 관하여 중대한 영향을 미치는 사항에 대하여는 개별 통지합니다.<br>
<br>
제20조(게시물의 관리)<br>
(1) “회사”는 게시물이 다음 각 호에 해당하는 경우 사전 통보 없이 해당 게시물을 삭제하거나, 열람을 제한하는 등의 조치를 취할 수 있습니다.<br>
1) 타인의 권리나 명예, 신용 기타 정당한 이익을 침해하는 경우<br>
2) 공공질서 및 미풍양속에 위반되는 내용일 경우<br>
3) 범죄행위와 관련된 내용을 포함하는 경우<br>
4) “회사”의 저작권, 제3자의 저작권 등 기타 권리를 침해하는 내용인 경우<br>
5) 불법물, 음란물 또는 청소년유해매체물의 게시, 광고, 사이트를 링크하는 경우<br>
6) “회사”로부터 사전 승인 받지 아니한 상업광고, 판촉 내용을 게시하거나 타 사이트의 링크를 게시하는 경우<br>
7) 상품과 관련 없는 내용일 경우<br>
8) 허위의 사실을 마치 진실인 것처럼 기재하여 “회사”의 업무를 방해하거나 “회사”의 사실관계 확인 요청에 2회 이상 불응한 경우<br>
9)“회사”가 제공하는 “서비스” 기타 영업행위의 원활한 진행을 방해하는 것으로 판단되는 경우<br>
10) 기타 이 약관 또는 관련법령에 위반된다고 판단되는 경우<br>
(2) 전 항에 해당하는 게시물로 인하여 “회사”가 제3자에 대하여 손해배상금을 지급하게 되는 경우(조정, 판결, 민사, 형사 불문) 귀책사유 있는 “회원”은 “회사”가 제3자에게 배상금을 지급하는 즉시 동일 금액 상당을 “회사”에게 지급하여야 합니다.<br>
 <br>
제21조(게시물의 저작권 및 배타적 이용허락)<br>
(1) “회원”이 작성한 “게시물”의 저작권은 이를 작성한 “회원” 본인에게 있으며, 해당 “게시물”이 타인의 저작권을 침해하는 경우 그에 대한 책임은 “회원” 본인이 부담합니다.<br>
(2) “회원”은 “회사”에게 자신이 작성한 “게시물”을 독점적으로 이용할 수 있는 권리(license)를 부여합니다. 이에 따라 “회사”는 “회원”이 작성한 “게시물”을 검색노출, 판촉, 홍보 기타의 자료로 무상으로 영구적으로 이용할 수 있으며, 필요한 범위 내에서 “게시물”의 일부를 수정, 복제, 편집할 수 있습니다.<br>
<br>
제22조(이용제한 등)<br>
(1) “회사”는 “회원”이 다음 각 호의 사유에 해당하는 경우 경고, 일시정지, 영구이용정지 등으로 “서비스”의 이용을 단계적으로 제한할 수 있습니다.<br>
1) 가입 신청 시에 허위 내용을 등록한 경우<br>
2) “재화 등”의 대금결제, 기타 “서비스” 이용과 관련하여 “회원”이 부담하는 채무를 기일에 이행하지 않는 경우<br>
3) 타인의 “서비스” 이용을 방해하거나 정보를 도용하는 등 전자상거래질서를 위협하는 경우<br>
4) “회사”를 이용하여 법령과 이 약관이 금지하거나 공공질서, 미풍양속에 반하는 행위를 하는 경우<br>
5) “회원”이 “사이트”를 통하여 “티켓”을 구입한 후 이를 다시 “회사”에 환불처리를 요청한 후 이를 마치 환불하지 않은 듯한 태도를 보이며 제휴업체에서 “재화 등”을 받는 행위 또는 “티켓”을 사용하고도 마치 사용하지 않은 듯한 태도를 보이며 “회사”에 환불을 요구하는 행위 등을 하는 경우<br>
6) “회원”이 “티켓”을 구매한 경우 발송되는 문자를 임의로 조작하여 재사용하거나 유사업체에 사용한 경우<br>
7) “회원”이 “티켓” 구매 시 결제 정보를 임의로 조작하여 정상가격보다 못 미치는 금액을 결제한 경우<br>
(2) “회사”는 전항에도 불구하고 주민등록법을 위반한 명의도용 및 결제도용, 저작권법 및 정보통신망 이용촉진 및 정보보호 등에 관한 법률을 위반한 불법통신 및 해킹, 악성프로그램의 배포 등과 같이 관련 법령을 위반한 경우에는 즉시 영구이용정지를 할 수 있습니다. 본 항에 따른 영구이용정지 시 티몬 적립금, 할인쿠폰 및 기타 혜택 등도 모두 소멸되며, “회사”는 이에 대해 별도로 보상하지 않습니다.<br>
(3) 본 조에 따라 “서비스” 이용을 제한하는 경우 “회원”에게 이를 제24조 제2항 제2)호에 따라 통지하고, 회원등록 말소 전에 소명할 기회를 부여할 수 있습니다.<br>
(4) “회사”는 “회원”에 대하여 영화 및 비디오물의 진흥에 관한 법률 및 청소년 보호법 등에 따라 “서비스” 의 이용을 제한할 수 있습니다.<br>
(5) “회사”는 “회원”이 주민등록법, 저작권법 또는 정보통신망 이용촉진 및 정보보호 등에 관한 법률 등 대한민국 내 제반 법령을 위반한 것으로 의심이 되는 경우 “회원”에게 통지 후 “서비스” 이용을 제한하고 수사기관을 통하여 사실관계를 규명할 수 있습니다.<br>
<br>
제23조(서비스 제공의 중지)<br>
(1) “회사”는 다음 각 호에 해당하는 경우 “서비스” 제공을 중지할 수 있습니다.<br>
1) “서비스”용 설비의 보수 등 공사로 인한 부득이한 경우<br>
2) 전기통신사업법에 규정된 기간통신사업자가 전기통신 “서비스”를 중지했을 경우<br>
3) 기타 불가항력적 사유가 있는 경우<br>
(2) “회사”는 국가비상사태, 정전, “서비스” 설비의 장애 또는 “서비스” 이용의 폭주 등으로 정상적인 “서비스” 이용에 지장이 있는 때에는 “서비스”의 전부 또는 일부를 제한하거나 정지할 수 있습니다.<br>
<br>
제24조(이용계약의 종료)<br>
(1) 회원의 해지<br>
1) “회원”은 언제든지 “사이트” 내 마이페이지 탭을 통하여 이용계약을 해지할 수 있습니다.<br>
2) 전 항에 따라 해지를 한 “회원”은 “회사”가 정하는 규정에 따라 “회원”으로 다시 가입할 수 있습니다.<br>
(2) 회사의 해지<br>
1) “회사”는 “회원”에게 다음과 같은 사유가 있는 경우 이용계약을 해지할 수 있고, 해당 “회원”에 대한 정보의 보유는 개인정보취급방침에 따릅니다.<br>
① 제6조 제3항의 승낙거부사유가 있음이 확인된 경우<br>
② “회사”나 다른 “회원” 기타 타인의 권리나 명예, 신용 기타 정당한 이익을 침해하거나 대한민국 법령 또는 공서양속에 위배되는 행위를 한 경우<br>
③ “회사”가 판매하는 “재화 등”에 대해 확인되지 않는 사실로 불신을 조장하는 행위를 한 경우<br>
④ “회사”가 제공하는 “서비스”의 원활한 진행을 방해하는 행위를 하거나 시도한 경우<br>
⑤ 기타 “회사”가 합리적인 판단에 기하여 “서비스”의 제공을 거부할 필요가 있다고 인정할 경우<br>
2) 이용계약은 “회사”가 해지의사를 “회원”에게 통지한 시점에 종료됩니다. 이 경우 “회사”는 “회원”이 등록한 전자우편 또는 전화, 기타의 방법을 통하여 해지의사를 통지합니다.<br>
(3) 이용계약이 종료되는 경우 “회원”의 “티몬 적립금” 및 “할인쿠폰”은 소멸되며, 환불 등의 처리는 “회사”의 환불규정에 의합니다.<br>
(4) 이용계약의 종료와 관련하여 발생한 손해는 이용계약이 종료된 해당 “회원”이 책임을 부담하여야 하고 “회사”는 일체의 책임을 지지 않습니다.<br>
<br>
제25조(저작권 등의 귀속 및 이용제한)<br>
(1) “회사”가 작성한 저작물에 대한 저작권, 특허권, 상표권 기타 지적재산권은 “회사”에 귀속합니다.<br>
(2) “회원”은 “서비스”를 이용함으로써 얻은 정보를 “회사”의 사전 승낙 없이 복제, 송신, 출판, 배포, 방송 등 기타 방법에 의하여 이용하거나 제3자에게 이용하게 하여서는 안 됩니다.<br>
 <br>
제26조(개인정보보호)<br>
(1) “회사”는 “회원”의 개인정보를 보호하기 위하여 정보통신망 이용촉진 및 정보보호 등에 관한 법률 및 개인정보 보호법 등 관계 법령에서 정하는 바를 준수합니다. 개인정보의 보호 및 사용에 대해서는 관련법령 및 “회사”의 개인정보취급방침이 적용됩니다.<br>
(2) “회사”는 “회원”의 개인정보를 보호하기 위하여 개인정보취급방침을 제정, “서비스” 초기화면에 게시합니다. 다만, 개인정보취급방침의 구체적 내용은 연결화면을 통하여 볼 수 있습니다.<br>
(3) “회사”는 이용계약을 위하여 “회원”이 제공한 정보를 “회사”의 “서비스” 운영을 위한 목적 이외의 용도로 사용하거나 “회원”의 동의 없이 제3자에게 제공하지 않습니다. 단, 다음 각 호의 경우에는 예외로 합니다.<br>
1) 법령에 근거하여 회원정보의 이용과 제3자에 대한 정보제공이 허용되는 경우<br>
2) 배송업무 등 거래 이행에 필요한 최소한의 회원정보(성명, 주소, 연락처 등)를 배송업체에 알려주는 경우<br>
3) 기타 “회사”의 약관 및 정책에 따라 “회원”의 동의를 구한 경우<br>
<br>
제27조(기록 보존)<br>
(1) “회사”는 전자상거래 등에서의 소비자보호에 관한 법률에 따라 다음 각 호에 대한 기록은 법령에서 정한 기간 동안 보존합니다.<br>
1) 이용계약 또는 청약철회 등에 관한 기록<br>
2) 대금결제 및 “티켓” 사용에 관한 기록(성명, 주소, 주민등록번호 등 거래의 주체를 식별할 수 있는 정보에 한함)<br>
(2) “회사”는 “회원”이 “티켓”을 사용하지 못한 경우 해당 유효기간 동안 “티켓” 사용에 관련된 정보를 보존합니다.<br>
 <br>
제28조(면책 조항)<br>
(1) “회사”는 천재지변 또는 이에 준하는 불가항력으로 인하여 “서비스”를 제공할 수 없는 경우에는 “서비스” 제공에 관한 책임이 면제됩니다.<br>
(2) “회사”는 “회원”의 귀책사유로 인한 “서비스” 이용의 장애에 대하여 책임을 지지 않습니다.<br>
(3) “회사”는 “회원”이 “서비스”를 이용하여 기대하는 수익을 상실한 것에 대하여 책임을 지지 않으며, 그 밖의 “서비스”를 통하여 얻은 자료로 인한 손해에 관하여 책임을 지지 않습니다.<br>
(4) “회사”는 “회원”이 게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관해서는 책임을 지지 않습니다.<br>
(5) “회사”는 “회원” 간 또는 “회원”과 제3자 상호간에 “서비스”를 매개로 하여 거래 등을 한 경우에는 책임을 지지 않습니다.<br>
 <br>
제29조(분쟁 해결)<br>
(1) “회사”는 “회원”이 제기하는 정당한 의견이나 불만을 반영하고 그 피해를 보상처리하기 위해서 피해보상처리 기구를 설치, 운영합니다.<br>
(2) “회사”는 “회원”이 제기하는 불만사항 및 의견을 우선적으로 처리합니다. 다만 신속한 처리가 곤란한 경우에는 “회원”에게 그 사유와 처리일정을 즉시 통보합니다.<br>
 <br>
제30조(준거법 및 관할법원)<br>
(1) 이 약관의 해석 및 “회사”와 “회원” 간의 분쟁에 대하여는 대한민국의 법령을 적용합니다.<br>
(2) “서비스” 이용 중 발생한 “회사”와 “회원” 간의 소송은 서울중앙지방법원에 제소합니다.<br>
 <br>
* 부 칙<br>
1. 이 약관은 2013년 10월 7일부터 적용됩니다.<br>
1. 2013년 3월 2일부터 시행되던 종전의 약관은 이 약관으로 대체됩니다.<br>
        </div>
        <input type="checkbox" id="c_1" class="chk" value="Y" /> <label for="c_1">이용약관에 동의합니다.</label>
    </div>
    <div class="clause">
        <div>
            <strong>1. 개인정보의 수집 및 이용 목적</strong><br>
가. 회사는 홈페이지에서 회원님의 가입 시 물품 및 서비스 제공과 물품 배송, 대금 결제 및 회원님들께 편리하고 유익한 맞춤정보를 제공하기 위해 필요한 최소한의 정보를 필수 사항으로 수집하고 있습니다.<br>
나. 회사는 인종 및 민족, 사상 및 신조, 출신지 및 본적지, 정치적 성향 및 범죄기록, 건강상태 등의 회원님의 기본적 인권을 현저하게 침해할 우려가 있는 개인정보를 수집하지 않습니다.<br>
다. 회사는 수집된 회원님들의 개인정보를 다음과 같이 수집합니다.<br>
1) 회원<br>
- 필수 정보 : 이름, 핸드폰번호, 아이핀정보, 생년월일, 성별, 외국인등록번호, 이통사 정보, 아이디,E-MAIL 주소<br>
- 선택 정보 : 계좌번호, 사진, 주소, 신용카드 번호<br>
- 기타 : 결제 정보,서비스 이용기록, 접속 로그, 쿠키, 접속IP정보<br>
* 해외 배송 상품의 경우, 관세법에 의거하여 구매하는 사용자에 한해 주민등록번호를 수집함<br>
라. 수집한 개인정보는 다음과 같은 목적으로 사용됩니다.<br>
- 성명, 핸드폰번호, 외국인등록번호, 아이핀번호 : 서비스 제공 및 개인 식별<br>
- 결제정보 : 서비스 구매 및 요금 결제, 관련 법령에 의한 기록 보존<br>
- E-MAIL 주소, 핸드폰 번호, 주소 : 서비스 제공을 위한 연락 및 안내, 상품과 경품 배송, 이벤트 등 광고성 정보 전달, 마케팅을 위한 통계 자료, 민원 처리, 신규 서비스 안내 등<br>
- 계좌번호 : 환불<br>
- 신용카드 번호 : 상품 구매 시 결제 수행<br>
마. 회사는 홈페이지의 회원가입 및 1:1 게시판, 상품문의 게시판 그리고, 고객센터를 통한 상담 등을 통하여 개인정보를 수집합니다.<br>
<br>
<strong>2. 개인정보의 보유 및 이용기간 </strong><br>
회사는 원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당 개인정보를 지체 없이 파기합니다. 단, 내부방침 및 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정&gt;한 일정한 기간 동안 회원정보를 보관합니다.<br>
가. 내부 방침(부정이용기록)<br>
- 보존이유: 기존 구매 티켓에 대한 본인 인증 필요성(부정이용의 배제 등 회사 방침에 의한 보존)<br>
- 보존기간: 6월<br>
나. 상법 등 법령에 따라 보존할 필요성이 있는 경우<br>
1) 계약 또는 청약철회 등에 관한 기록<br>
- 보존근거: 전자상거래 등에서의 소비자보호에 관한 법률<br>
- 보존기간: 5년<br>
2) 대금결제 및 재화 등의 공급에 관한 기록<br>
- 보존근거: 전자상거래 등에서의 소비자보호에 관한 법률<br>
- 보존기간: 5년<br>
3) 소비자의 불만 또는 분쟁처리에 관한 기록<br>
- 보존근거: 전자상거래등에서의 소비자보호에 관한 법률<br>
- 보존기간: 3년<br>
4) 본인확인에 관한 기록<br>
-보존근거: 정보통신망 이용촉진 및 정보보호 등에 관한 법률<br>
-보존기간 : 6개월<br>
5) 웹사이트 방문기록<br>
-보존근거: 통신비밀보호법<br>
-보존기간: 3개월<br>
다. 기타 회원님의 개별적인 동의가 있는 경우에는 개별 동의에 따른 기간까지 보관합니다.
        </div>
        <!-- <input type="checkbox" id="c_21" class="chk"> <label for="c_21">개인정보 수집 및 이용에 동의합니다.</label> -->
       개인정보 수집 및 이용 &nbsp;&nbsp; 
      <!--  <input type="checkbox" id="c_21" class="chk">-->
        <input type="radio" id="rdo_y" name="rdo_chk" value="Y" class="chk">
        <label for="c_21">동의합니다.</label>
        <input type="radio" id="rdo_n" name="rdo_chk" value="N" class="chk">
        <label for="c_21">동의 하지 않습니다.</label>

    </div>
<!--    <div class="line"></div>
    <div class="check_all">
        <input type="checkbox" id="c_6" class="chk"><label for="c_6">아래의 제 3자 이용, 개인정보 취급위탁에 모두 동의합니다.</label>
        <p>(동의 하지 않아도 회원가입 및 서비스 이용에는 제약이 없습니다.)</p>
    </div>
    <div class="clause">
        <div>
            <tpl:policy_termsOfService2forUserSignup3 />
        </div>
        <input type="checkbox" id="c_23" class="chk"> <label for="c_23">제 3자 이용에 동의합니다.</label>
    </div>
    <div class="clause">
        <div>
            <tpl:policy_termsOfService2forUserSignup4 />
        </div>
        <input type="checkbox" id="c_25" class="chk"> <label for="c_25">개인정보 취급위탁에 동의합니다.</label>
    </div>-->
</div>
<div class="btn_cen">
    <a href="#none" onclick="btn_join(); return false;" class="sp_sup bt_join" id="submit">가입하기</a>
    <a href="#none" onclick="btn_cencel(); return false;" class="sp_sup bt_cncl" id="cancel">취소</a>
</div>

        </div>
</form>