<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="../../../resources/js/common.js"></script>

	<script type="text/javascript">

		$(document).ready(function(){

			var frm = document.frm;
			
			if('${session_rate}'!='10')
			{
				frm.page.value=1;
				frm.action = 'list';
				frm.submit();
			}
			
			writeok_go = function()
			{
				if ($("#notice_content").val() == "내용을 입력하세요")
				{
					$("#notice_content").val("");
				}
				if (form_chk(frm, ""))
				{
					frm.action = "writeOk";
					frm.submit();
				}
				
			}
			
			$("#notice_content").click(function(){
				if ($(this).val() == "내용을 입력하세요")
				{
					$(this).val("");	
				}
			});
			
			$("#notice_content").focusout(function(){
				if ($(this).val() == "")
				{
					$(this).val("내용을 입력하세요");
				}
			});
			
			document.frm.notice_title.focus();
			
				
		});
		
		
	</script>
<div class="hong_title">
공지사항
</div>
 
<div class="hong_template">



	<form name="frm" action="writeOk" method="post" enctype="multipart/form-data">
		<input type="hidden" name='page' value="${param.page }">
		<input type="hidden" name="bs_id" value="${session_bsid }">
		<input type="hidden" name="notice_id" value="${bean.notice_id }">
		<table class="brd_detail">
			<colgroup>
				<col width="180px">
				<col width="">
			</colgroup>
			<c:if test="${session_rate==10 }">
			<tr>
				<th>공지여부</th>
				<td>
					Y &nbsp; <input type="radio" class="rdo" name="notice_yn" value="Y" >&nbsp;&nbsp;
					N &nbsp; <input type="radio"  class="rdo" name="notice_yn" value="N" checked="checked" >
				</td>
			</tr>
			</c:if>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="notice_title" name="notice_title" title="제목">
				</td>
			</tr>
			<tr>	
				<th>내용</th>
				<td class="board_text">
					<div>
						<textarea rows="5" cols="30" id="notice_content" name="notice_content">내용을 입력하세요</textarea>
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
					<a href="#none" onclick="writeok_go(); return false;">작성</a>
					<a href="list">목록</a>
				</th>
			</div>
		
	</form>
</div>