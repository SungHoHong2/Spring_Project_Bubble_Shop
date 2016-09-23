<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">

$(document).ready(function(){
		
		var frm = document.frm;
		
		
		
		if ('${bean.msg}' != "")
		{
			if ('${bean.msg}' == "Y")
			{
				if('${bean.find_email_chk}'=="Y")
				{
					/* 이메일 인증 성공 */
					$("#join_info").hide();
					$("#id_res").html("<em id='js_result_id'>고객님의 아이디는 이메일로 전송하였습니다.</em>");
					$("#js_result_suc").show();
				}
				else
				{
					/* 핸드폰 인증 성공 */
					var chkpw = '${bean.bs_pwd}';
					$("#join_info").hide();
					$("#id_res").html("<span></span><em id='js_result_id'>고객님의 임시비밀번호는 [ "+chkpw+" ] 입니다.</em><span></span>"); 
					$("#js_result_suc").show();
					
				}
			}
			else
			{
				/* 인증 실패 */
				$("#join_info").hide();
				$("#js_result_fail").show();
				
				
			
			}
		}
		
		find_pw = function()
		{ 

			
			if($('#hp1').val()!='' && $('#hp2').val()!='' && $('#hp3').val() != '' )
			{
				frm.bs_hp.value = frm.hp1.value +"-" + frm.hp2.value +"-"+frm.hp3.value;
				frm.action = "find_pw_hp";
				frm.submit();
			}
			
			if($('#txt_mail').val() != '')
			{
				frm.action="userpw_fined_email";
				frm.submit();
			}
			
		
		}
		/* 페이지 전환 */
		$("[name='find_info']").click(function(){
			
			if($('[name="find_info"]:checked').val() == 'byhp')
			{
				$("#js_result_fail").hide();
				$("#js_infofind_email").hide();
				$("#js_infofind_hp").show();
				
				
			}
			else
			{
				$("#js_result_fail").hide();
				$("#js_infofind_hp").hide();
				$("#js_infofind_email").show();
			}
			
		});
		
		
		
	});
</script>    
<form name="frm" action="#" method="post">
	<input type="hidden" name="bs_hp" >
<div class="wrap_idpw">
            <ul class="tab_idpw">
                <li class="tab_id"><a href="/shop/bs/user/member/findid">아이디 찾기</a></li>
                <li class="tab_pw"><span class="on">비밀번호 찾기</span></li>
            </ul>
            <div class="ct_pw" id="js_input">
    <h3 class="hidden">비밀번호 찾기</h3>
    <div class="join_info" id ="join_info">
        <h4>가입정보로 찾기</h4>
        <p class="desc">가입 당시 입력한 정보를 통해 비밀번호를 찾을 수 있습니다.<br><strong>휴대폰 또는 이메일</strong> 정보 중 한가지를 선택해주세요.</p>
        <div class="inputs">
            <div class="opt">
                <input type="radio" name="find_info" id="rdo_1" value="byhp" attr-opt="info" class="rdo" checked="checked"><label for="rdo_1"><span class="rd_phone">휴대폰</span></label>
                <input type="radio" name="find_info" id="rdo_2" value="byemail" attr-opt="info" class="rdo"><label for="rdo_2"><span class="rd_email">이메일</span></label>
            </div>
            <div class="input_area">
                <label for="txt_id"><span class="input_id">아이디</span></label>
                <input type="text" id="info_userid" name="bs_userid" maxlength="20" title="아이디" class="inp_tx" style="width:214px">
            </div>
            <div class="input_area">
                <label for="txt_name"><span class="input_name">이름</span></label>
                <input type="text" id="txt_name" name="bs_name" maxlength="20" title="이름" class="inp_tx" style="width:214px">
            </div>
            <div class="input_area">
                <div id="js_infofind_hp">
                    <label for="hp1"><span class="input_phone">휴대폰</span></label>
                    <select id="hp1"name="hp1" title="휴대폰번호" style="width:72px">
                    <option value="010">010</option>
                    <option value="011">011</option>
                    <option value="016">016</option>
                    <option value="017">017</option>
                    <option value="018">018</option>
                    <option value="019">019</option>
                    <option value="0505">0505</option>
                    <option value="0502">0502</option>
                    </select>
                    - <input type="text" id="hp2" name="hp2" maxlength="4" title="휴대폰 중간자리" class="inp_tx" style="width:52px">
                    - <input id="hp3"name="hp3" type="text" maxlength="4" title="휴대폰 끝자리" class="inp_tx" style="width:52px">
                </div>
                <div id="js_infofind_email" style="display: none;">
                    <label for="txt_mail"><span class="input_email">이메일</span></label><input type="text" id="txt_mail" name="bs_email" title="이메일주소" class="inp_tx" style="width:214px">
                </div>
            </div>
        </div>
         
        <div class="btns">
            <div id="js_infostep1">
                <a href="#" onclick="find_pw(); return false;" class="btn_find">찾기</a>
            </div>
            <div id="js_infostep2" style="display: none;">
                <a href="#" onclick="">휴대폰으로 받기</a>
                <a href="#" onclick="" class="btn_email">이메일로 받기</a>
            </div>

        </div>
    </div>
    <div id="js_result_suc" class="idpw_result" style="display:none;">
		    
		    <p class="id_result" id ="id_res"></p>
		    <a class="btn_login" href="/shop/bs/user/member/login">로그인</a>
		    <p class="txt_result">비밀번호가 기억나지 않는 경우에는<a href="findpw" class="btn_pw_sch">비밀번호 찾기<span class="bu"></span></a></p>
		</div>
    <div id="js_result_fail" class="idpw_result" style="display:none;">
		    <h3 class="hidden">비밀번호 찾기</h3>
		    <span class="icon_info"></span>
		    <p class="tit_result">입력하신 정보와 일치하는 회원이 없습니다.</p>
		    <a href="/shop/bs/user/member/findpw" class="btn_pw_research">비밀번호 다시 찾기</a>
		</div>
    <ul class="txt_lst">
    <li>본인 인증 시 제공되는 정보는 인증 이외의 용도로 이용 또는 저장하지 않습니다.</li>
    <li>본인 인증을 통해 비밀번호를 찾으신 경우엔 인증 완료 후 재설정해주세요.</li>
    </ul>
    

</div>
</form>