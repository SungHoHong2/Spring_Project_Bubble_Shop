<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <script type="text/javascript">
    
	    $(document).ready(function(){
	    	
	    	var sDay = "";
	    	var iNum = 0;

	    	var frm = document.frm;

	    	$("#btn_auth").click(function(){
	    		
	    		if (!phone_chk())
    			{
    				return false;
    			}
	    		$("#auth_num").val("");
	    		while(true)
	    		{
	    			iNum = Math.floor(Math.random() * 99999) + 1;
	    			if (iNum.toString().length == 5)
	    			{
	    				$("#auth_call").val("Y");
	    				$("#auth_num").attr("disabled", false);
	    				alert(iNum);
	    				break;	
	    			}
	    		}
	    		
	    		$("#auth_num").focus();

	    	});
	    	
	    	$("#chk_total").click(function(){
	    		
	    		if($(this).is(":checked"))
	    		{
	    			$("[name='chk']").prop("checked", true);	
	    		}
	    		else
	    		{
	    			$("[name='chk']").prop("checked", false);	
	    		}
	    		
	    	});
	    	
	    	btn_next = function()
	    	{
	    		for(var i = 0; i < $("[name='chk']").length; i++)
	    		{
	    			if (!$("[name='chk']").eq(i).is(":checked"))
	    			{
	    				alert($("[name='chk']").eq(i).attr("title") + "를 하셔야 합니다!");
	    				$("[name='chk']").eq(i).focus();
	    				return false;
	    			}
	    		}
					    		
	    		if (form_chk(frm, "auth_num"))
				{
	    			$("#bs_birth").val($("#birth1").val() + "-" + $("#birth2").val() + "-" + $("#birth3").val());
	    			$("#bs_hp").val($("#hp1").val() + "-" + $("#hp2").val() + "-" + $("#hp3").val());
	    			if (!$("[name='bs_sex']").eq(0).is(":checked") && !$("[name='bs_sex']").eq(1).is(":checked"))
	    			{
	    				alert("성별을 선택하세요!");
	    				$("[name='bs_sex']").eq(0).focus();
	    				return false;
	    			}
	    			
	    			if (!phone_chk())
	    			{
	    				return false;
	    			}

	    			if ($("#auth_call").val() != "Y")
		    		{
		    			alert("인증번호를 요청하세요!");
		    			return false;
		    		}
	    			
	    			if ($("#auth_num").val() == iNum.toString())
	    			{
	    				$("#frm").attr("method", "post").attr("action", "signup2").submit();
	    			}
	    			else
	    			{
	    				alert("인증번호가 일치 하지 않습니다!");
	    				$("#auth_num").val("");
	    				$("#auth_num").focus();
	    			}
	    			
				}
	    	}
	    	
	    	phone_chk = function()
	    	{
	    		var regexp = /^[0-9]{3,20}$/i;

    			if(!regexp.test($("#hp2").val()))
    			{    
    				alert("휴대폰 중간자리는 숫자만 입력 가능 합니다!");
    				$("#hp2").focus();
    				return false;
    			}
    			
    			if(!regexp.test($("#hp3").val()))
    			{    
    				alert("휴대폰 끝자리는 숫자만 입력 가능 합니다!");
    				$("#hp3").focus();
    				return false;
    			}
    			
    			return true;
	    	}
	    	
	    	$("#birth1").change(function(){
	    		
	    		if ($(this).val() != "" && $("#birth2").val() != "")
	    		{
	    			Last_day_call($(this).val() + "-" + $("#birth2").val() + "-01");
	    		}
	    		
	    	});
	    	
			$("#birth2").change(function(){
	    		
	    		if ($(this).val() != "" && $("#birth1").val() != "")
	    		{
	    			Last_day_call($("#birth1").val() + "-" + $(this).val() + "-01");
	    		}
	    		
	    	});
	    	
			$("#birth3").click(function(){
				
				sDay = $(this).val();
				
			});
	    	
	    	Last_day_call = function(sDate)
	    	{
	    		$("#birth3").html("");
	    		var res = "<option value=''>선택</option>";
	    		for (var i = 1; i <= Last_Day(sDate); i++)
	    		{
	    			res += "<option value='" + i + "'>" + i + "</option>";
	    		}
	    		$("#birth3").append(res);
	    		$("#birth3 > option[value='" + sDay + "']").prop("selected", true);
	    	}
	    	
	    	var sGetDate = "${bean.sysYear}" + "-" +  "${bean.sysMonth}" + "-" + "${bean.sysDay}";
	    	
	    	Last_day_call(sGetDate);
	    	
	    	$("#chk1").focus();
	    	
	    });
    
    </script>
    
<form id="frm" name="frm" method="post" action="signup2">
<input type="hidden" id="auth_call" name="auth_call" />
<input type="hidden" id="auth_data" name="auth_data" />
<input type="hidden" id="bs_birth" name="bs_birth" />
<input type="hidden" id="bs_hp" name="bs_hp" />
<div class="signup_wp">
            <div class="steps">
                <!-- [D] 선택된 단계 span에 on 클래스 추가 -->
                <ol>
                <li class="step1"><span class="sp_sup on">Step01 - 본인 인증</span><em class="sp_sup ar"></em></li>
                <li class="step2"><span class="sp_sup">Step02 - 정보 입력 및 약관동의</span><em class="sp_sup ar"></em></li>
                <li class="step3"><span class="sp_sup">Step03 - 가입 완료</span></li>
                </ol>
            </div>
            


    <div class="verify_wp">
        <div class="verify_to cellphone" name="signup_container">
            <div class="verify_cp">
                <div class="do">
                    <div class="tit_area">
                        <h4 class="sp_sup tit_terms">약관 동의</h4>
                    </div>
                    <div class="terms_area">
                        <ul class="terms_lst">
                            <li>
                                <input type="checkbox" id="chk1" name="chk" value="Y" title="본인확인 이용 동의">
                                <label for="termsAgree">본인확인 이용 동의</label>
                                <span class="sp_sup btn_p"><button type="button" name="btn_policy" title="본인확인 이용 동의 전문보기">전문보기</button></span>
                            </li>
                            <li>
                                <input type="checkbox" id="chk2" name="chk" value="Y" title="개인정보 수집/이용/취급위탁 동의">
                                <label for="termsAgree2" class="even">개인정보 수집/이용/취급위탁 동의</label>
                                <span class="sp_sup btn_p"><button type="button" name="btn_policy" title="개인정보 수집/이용/취급위탁 동의 전문보기">전문보기</button></span>
                            </li>
                            <li>
                                <input type="checkbox" id="chk3" name="chk" value="Y" title="고유 식별정보처리 동의">
                                <label for="termsAgree3">고유 식별정보처리 동의</label>
                                <span class="sp_sup btn_p"><button type="button" name="btn_policy" title="고유 식별정보처리 동의 전문보기">전문보기</button></span>
                            </li>
                            <li>
                                <input type="checkbox" id="chk4" name="chk" value="Y" title="통신사 본인확인서비스 이용 동의">
                                <label for="termsAgree4" class="even">통신사 본인확인서비스 이용 동의</label>
                                <span class="sp_sup btn_p"><button type="button" name="btn_policy" title="통신사 본인확인서비스 이용 동의 전문보기">전문보기</button></span>
                            </li>
                        </ul>
                    </div>
                    <p class="terms_all_agree">
                        <input type="checkbox" id="chk_total" name="chk_total">
                        <label for="termsAllAgree">위의 이용약관, 개인정보 수집 및 이용에 모두 동의합니다.</label>
                    </p>
                    <div class="tit_area">
                        <h4 class="sp_sup tit_private">개인정보 입력</h4>
                        <p class="must"><em class="ico_circle"></em>표시정보는 필수 입력 사항입니다.</p>
                    </div>
                    <table  border="1" class="tbl_join">
                    <colgroup>
                    <col width="131px">
                    <col width="">
                    </colgroup><tbody>
                    <tr class="first">
                    <th scope="row"><p><span class="ico_circle">필수입력 - </span>이름</p></th>
                    <td>
                        <input type="text" id="bs_name" name="bs_name" maxlength="10" title="이름" class="txt" style="width:168px">
                    </td>
                    </tr>
                    <tr>
                    <th scope="row"><p><span class="ico_circle">필수입력 - </span>성별</p></th>
                    <td>
                    <input type="radio" id="bs_sex_M" name="bs_sex" value="M" class="form_input"><label for="bs_sex_M" class="form_label">남</label>
                    <input type="radio" id="bs_sex_F" name="bs_sex" value="F" class="form_input"><label for="bs_sex_F" class="form_label">여</label>
                    </td>
                    </tr>
                    <tr>
                    
                    <th scope="row"><p><span class="ico_circle">필수입력 - </span>생년월일</p></th>
                    <td>
                        <select id="birth1" name="birth1" title="생년월일" style="width:71px">
                            <option value="">선택</option>
                            <c:forEach begin="0" end="${bean.sysYear - 1900}" var="i">
								<option value="${(bean.sysYear) - i}">${(bean.sysYear) - i}</option>
							</c:forEach>
						</select> 년 &nbsp;
                        <select id="birth2" name="birth2" title="생년월일" style="width:71px">
                        	<option value="">선택</option>
                            <c:forEach begin="1" end="12" var="i">
								<option value="${i }">${i }</option>								
							</c:forEach>
						</select> 월 &nbsp;
                        <select id="birth3" name="birth3" title="생년월일" style="width:71px"></select> 일
                    </td>
                    </tr>
                    <tr>
                    <th scope="row"><p><span class="ico_circle">필수입력 - </span>통신사</p></th>
                    <td>
                        <input type="radio" id="telecom" name="telecom" value="01" class="form_input" checked="checked" ><label for="telecomskt" class="form_label">SKT</label>
                        <input type="radio" id="telecom" name="telecom" value="02" class="form_input"><label for="telecomkt" class="form_label">KT</label>
                        <input type="radio" id="telecom" name="telecom" value="03" class="form_input"><label for="telecomlg" class="form_label">LG U+</label>
                        <input type="radio" id="telecom" name="telecom" value="04" class="form_input"><label for="telecomskmvno" class="form_label">SKT MVNO</label>
                    </td>
                    </tr>
                    <tr>
                    <th scope="row"><p><span class="ico_circle">필수입력 - </span>휴대폰 번호</p></th>
                    <td>
                        <select id="hp1" name="hp1" title="휴대폰 앞자리" style="width:71px">
                            <option value="010">010</option>
                        	<option value="011">011</option>
                        	<option value="016">016</option>
                        	<option value="017">017</option>
                        	<option value="018">018</option>
                        	<option value="019">019</option>
                        </select>
                        - 
                        <input id="hp2" name="hp2" title="휴대폰 중간자리" type="text" class="txt" style="width:76px" maxlength="4"> 
                        - 
                        <input id="hp3" name="hp3" title="휴대폰 끝자리"type="text" class="txt" style="width:76px" maxlength="4">
                        <span class="btn_cfm_req"><button type="button" id="btn_auth">인증 번호 요청</button></span>
                    </td>
                    </tr>
                    <tr>
                    <th scope="row"><p><span class="ico_circle">필수입력 - </span>인증 번호</p></th>
                    <td>
                        <input type="text" id="auth_num" maxlength="6" name="auth_num" disabled="disabled" class="txt" style="width:68px">
					</td>
                    </tr>
                        </tbody></table>
                        <div class="btns">
                        <a href="#none" onclick="btn_next(); return false;" class="sp_sup bt_ok">확인</a>
                        <a href="#none" class="sp_sup bt_cancel">취소</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- verify_wp 끝 -->





        </div>
</form>