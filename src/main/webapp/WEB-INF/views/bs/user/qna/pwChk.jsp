<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<script type="text/javascript">
		$(document).ready(function(){
	
			var frm = document.frm;
			
			
			if('${bean.msg}'!="" || '${bean.msg}'!=null)
			{
				if('${bean.msg}'=="N")
				{
					alert('비밀번호 불일치\n다시 입력해 주세요');
				}
			}
			
			detail = function ()
			{
				frm.action = "detail";
				frm.submit();
			}
			
			submit = function()
			{
				if('${session_rate}'=='10')
				{	
					frm.action = "pwChkOk";
					frm.submit();
				}
				else
				{
					if(form_chk(frm, ""))
					{
						frm.action = "pwChkOk";
						frm.submit();
					}
				}
			}

			frm.notice_pw.focus();
			
				
		});
		
	</script>


		<form name="frm" action="pwChkOk" method="post">
			<input type="hidden" name='page' value="${param.page }">
			<input type="hidden" name="notice_id" value="${param.notice_id }" />
			<input type="hidden" name="notice_md" value="${param.notice_md }" />
			<table class="brd_detail">
			<colgroup>
				<col width="180px">
				<col width="">
			</colgroup>
				<tr>
					<th>암호</th>
					<td><input type="password" id="notice_pw" name="notice_pw" title="암호"></td>
				</tr>
			</table>
				<div class="board_act">
				<th colspan="2">
						<a href="#" onclick="submit(); return false;">확인</a>
						<a href="#" onclick="detail(); return false;">취소</a>
				</th>
			</div>
			
		</form>