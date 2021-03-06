<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="../../../resources/js/common.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		var frm = document.frm;
		
		pwChk = function(chk)
		{
			if(chk=="delete")
			{
				if(confirm("삭제 하시겠습니까?"))
				{	
					frm.notice_md.value="delete";
					frm.action = "pwChk";
					frm.submit();
				}
			}
			else if(chk=="modify")
			{
				if(confirm("수정 하시겠습니까?"))
				{	
					frm.notice_md.value="modify";
					frm.action = "pwChk";
					frm.submit();
				}
			}
		}
		
		listPageGo = function()
		{
			frm.action = "list";
			frm.submit();
		}
		
		
		
	});
		
	</script>

<div class="hong_title">FAQ</div>

<div class="hong_template">



	<form name="frm" action="#" method="post">
		<input type="hidden" name="page" value="${bean.page }">
		<input type="hidden" name="notice_id" value="${bean.data.notice_id}">
		<input type="hidden" name="notice_md" value="${bean.data.notice_md}">
		<table class="brd_detail">
			<colgroup>
				<col width="180px">
				<col width="">
			</colgroup>
			<tr>
				<th>제목</th>
				<td>${bean.data.notice_title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bean.data.bs_name }</td>
			</tr>		
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${bean.data.notice_reg_date}"
						pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bean.data.notice_cnt }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td class="board_text"><div>
						<ct:replace str="${bean.data.notice_content }" />
					</div>	
				</td>
			</tr>
			<c:if test="${bean.data.notice_upfile!='null' && bean.data.notice_upfile!=null && bean.data.notice_upfile!='' }">
			<ct:ext var="ext" fileName="${bean.data.notice_upfile }"/>
			<tr>
				
					<c:choose>
						<c:when test="${ext }">
								<th>이미지</th>
								<td>
								<img src="/shop/resources/upfile/${bean.data.notice_upfile }" /></td>
						</c:when>		
						<c:otherwise>
								<th>파일</th>
								<td><a href="#">${bean.data.notice_upfile }</a></td>
						</c:otherwise>			
					</c:choose>
				
			</tr>
			</c:if>
		</table>
		<div class="board_act">
			<a href="#" onclick="pwChk('modify'); return false;">수정</a>
			<a href="#" onclick="pwChk('delete'); return false;">삭제</a> 
			<a href="#" onclick="listPageGo(); return false;">목록으로</a>
		</div>
	</form>
</div>