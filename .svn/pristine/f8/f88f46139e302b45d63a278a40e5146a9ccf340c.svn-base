<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>


	
	<script type="text/javascript" src="/shop/resources/js/httpRequest.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
	
			var frm = document.frm;
			
			if('${session_rate}'!='10')
			{
				frm.action = 'list';
				frm.submit();
			}
			
			
			
			fileDelete = function(url)
			{
				if (confirm("삭제 하시겠습니까?"))
				{
					//location.href=url;
					var params = "notice_id=" + frm.notice_id.value+"&notice_upfile="+frm.notice_upfile.value;
					
					sendRequest("fileDelete", params, viewMessage, "GET");
				}
			
			}
			viewMessage = function () 
			{
				if (httpRequest.readyState == 4) 
				{
					if (httpRequest.status == 200) 
					{
						$("#tr_file").html("");
						$("#tr_file").append("<td>파일첨부</td><td><input type='file' name='upfile' ></td>");
						
					}
				}
			}
			
			
			
			
				
			modifyOk = function()
			{
				if ($("#notice_content").val() == "내용을 입력하세요")
				{
					$("#notice_content").val("");
				}
				if (form_chk(frm, "upfile"))
				{
					frm.action="modifyOk";
					
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
			
			frm.notice_title.focus();
		
			
		});
		
	</script>

	<form name="frm" method="post" action="" enctype="multipart/form-data">
		<input type="hidden" name="page" value="${bean.page }">
		<input type="hidden" name="notice_id" value="${bean.data.notice_id}">
		<input type="hidden" name="notice_upfile" value="${bean.data.notice_upfile }">
		<table class="brd_detail">
			<colgroup>
				<col width="180px">
				<col width="">
			</colgroup>
			<tr>
				<th>글번호</th>
				<td>${bean.data.notice_id}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="notice_title" title="제목" name="notice_title" value="${bean.data.notice_title }"></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bean.data.notice_cnt }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="30" id="notice_content" name="notice_content" title="내용">${bean.data.notice_content }</textarea>
				</td>
			</tr>
			<tr>
			
		<c:if test="${bean.data.notice_seq==0 }">
				<tr id="tr_file">
					<c:choose>
						<c:when test="${bean.data.notice_upfile=='' || bean.data.notice_upfile==null }">
							<th>파일첨부</th>
							<td><input type="file" id="upfile" name="upfile"></td>
						</c:when>
						
						<c:otherwise>
						
							<ct:ext var="ext" fileName="${bean.data.notice_upfile }"/>
							<c:choose>
								<c:when test="${ext }">
								<th>이미지</th>
								<td>
									<img src="/shop/resources/upfile/${bean.data.notice_upfile }" />
								
								</c:when>		
								<c:otherwise>
									<th>파일</th>
									<td><a href="#">${bean.data.notice_upfile }</a>
								</c:otherwise>			
							</c:choose>
							<br>
							<input type="button" value="삭제" onclick="fileDelete(fileDelete); return;" >
							</td>
			
						</c:otherwise>
					</c:choose>
				</tr>
			</c:if>
			
		</table>
		<div class="board_act">
					<a href="#" onclick="modifyOk(); return false;">수정</a>
					<a href="list">목록으로</a></td>
		</div>
	</form>

