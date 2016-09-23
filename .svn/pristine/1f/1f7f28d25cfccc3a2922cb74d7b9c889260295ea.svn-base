<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="../../../resources/js/common.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			var frm = document.frm;
			
			if('${session_bsid}'=='' && '${session_bsid}'==null && '${session_bsid}'=='0')
			{
				frm.page.value=1;
				frm.action = "list";
				frm.submit();
			}
			
			
			reply_go = function() {
				
				if(form_chk(frm,""))
				{
					frm.action = "replyOk";
					frm.submit();
				}
			}
			
			
			frm.notice_title.focus();
		
				
		});
		
		
	</script>
<div class="hong_title">COMMENT</div>

<div class="hong_template">


	<form name="frm"  method="post" enctype="multipart/form-data">
		<input type="hidden" naem="page" value="${bean.page }">
		<input type="hidden" name="notice_id" value="${bean.data.notice_id }" />
		<input type="hidden" name="notice_gid" value="${bean.data.notice_gid}" />
		<input type="hidden" name="notice_seq" value="${bean.data.notice_seq}" />
		<input type="hidden" name="notice_rev" value="${bean.data.notice_rev}" />
		<input type="hidden" name="bs_id" value="${session_bsid }">
		<table class="brd_detail">
			<colgroup>
				<col width="180px">
				<col width="">
			</colgroup>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="notice_title" name="notice_title" value="[Re]${bean.data.notice_title }" title="제목">
				</td>
			</tr>
			<tr>
				<th>암호</th>
				<td>
					<input type="password" id="notice_pw" name="notice_pw" title="암호">
				</td>
			</tr>
			<tr>	
				<th>내용</th>
				<td class="board_text">
					<div>
						<textarea rows="5" cols="30" id="notice_content" name="notice_content" title="내용">[Re]${bean.data.notice_content }</textarea>
					</div>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" id="upfile" name="upfile">
				</td>
			</tr>
			</table>
			<div class="board_act">
				<th colspan="2">
					<a href="#" onclick="reply_go(); return false;">작성</a>
					<a href="list">목록</a>
				</th>
			</div>
	</form>
</div>