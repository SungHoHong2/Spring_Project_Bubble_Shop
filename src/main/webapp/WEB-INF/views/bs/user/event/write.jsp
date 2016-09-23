<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<script type="text/javascript">

		$(document).ready(function(){

			var frm = document.frm;
			
		
	         
	         
	      // IE 경로 보안 대처
	         ProductFile = function(obj, num)
	         {
	          f = document.frm;
	          inputFileLength = document.getElementsByName("upfile").length;

	          obj.select();
	          realFilePath = document.selection.createRange().text.toString();
	          
	          $("#fpath").val(realFilePath);

	          if (inputFileLength == 1)
	           f.fileuploadView.value = realFilePath;
	          else
	           f.fileuploadView[num].value = realFilePath;
	         }
	         
	         
	         
	         
	         
	         
			
			
			if('${session_rate}'!='10')
			{
				frm.page.value=1;
				frm.action = 'list';
				frm.submit();
			}
			
			writeok_go = function()
			{
				
				if (form_chk(frm, ""))
				{
 					var name     = $("#upfile").val();
			         var extName = name.substring(name.lastIndexOf(".") + 1).toLowerCase();

			         if (!(extName == "jpg" || extName == "jpeg" || extName == "bmp" || extName == "gif" || extName == "png"))
			         {
			            alert("첨부파일을 확인하세요. \r\n ('JPG, JPEG, BMP, GIF, PNG') 이미지 파일만 가능합니다.");
			            return false;
			         }
					else
					{ 	
						frm.action = "writeOk";					
						frm.submit();
					}
					
				}
				
			}
			
			document.frm.notice_title.focus();
			
				
		});
		
		
	</script>

	<form name="frm" action="writeOk" method="post" enctype="multipart/form-data">
		<input type="hidden" name='page' value="${param.page }">
		<input type="hidden" name="bs_id" value="${session_bsid }">
		<input type="hidden" name="notice_id" value="${bean.notice_id }">
		<input type="hidden" name="notice_content" value="">
		<input type="hidden" name="fpath" id="fpath" value="">
		
		<table class="brd_detail">
			<colgroup>
				<col width="180px">
				<col width="">
			</colgroup>
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
					<input type="file" id="upfile" name="upfile" ><!-- onchange="ProductFile(this, 0)" -->
				</td>
			</tr>
			<c:if test="${session_rate==10 }">
			<tr>
				<th>이벤트</th>
				<td>
					Y &nbsp; <input type="radio" class="rdo" name="notice_yn" value="Y" >&nbsp;&nbsp;
					N &nbsp; <input type="radio"  class="rdo" name="notice_yn" value="N" checked="checked" >
				</td>
			</tr>
			</c:if>
			</table>
			<div class="board_act">
				<th colspan="2">
					<a href="#none" onclick="writeok_go(); return false;">작성</a>
					<a href="list">목록</a>
				</th>
			</div>
		
	</form>
