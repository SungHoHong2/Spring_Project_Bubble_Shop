<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	Date date = new Date();
	long temp=date.getTime();
%>

<script type="text/javascript" src="../../../resources/js/common.js"></script>
<script type="text/javascript">
	
	
	$(document).ready(function(){
		
		var frm = document.frm;
		
		
		list_search = function()
		{
			frm.page.value=1;
			frm.submit();
		}
		
		search_go = function(e)
		{
			if (e.keyCode == 13)
			{
				list_search();
			}
			
		}
		
		detail_go = function(id) 
		{
			frm.notice_id.value = id;
			frm.action = "detail";
			frm.submit();
		}
		
		write_go = function() 
		{
			frm.action = "write";
			frm.submit();
		}
		
		pageGo = function(page) 
		{
			frm.page.value = page;
			frm.submit();
		}
		
		list_count = function()
		{
			frm.page.value=1;
			frm.submit();
		}
		
		content_search = function()
		{
			
			frm.search.focus();
		}
		
	});
	
	
	
	
</script>


<div class="hong_title">Q&A</div>

<div class="hong_template">


<form name='frm' method="post" action="list">
	<input type="hidden" name="page" value="${bean.page}">
	<input type="hidden" name="notice_id">
	<input type="hidden" name="bs_id" value="${session_bsid}">
	<table class="brd_table">
		<colgroup>
			<col width="100px">
			<col width="">
			<col width="125px">
			<col width="61px">
			<col width="55px">
		</colgroup>
		<thead>
		<tr>
			<th>
				&nbsp;&nbsp;&nbsp;글수<select id="limit" name="limit" onchange="list_search()">
					<c:forEach begin="15" end="100" var="i" step="5" >
					<c:if test="${i==15 || i==30 || i==50 ||i==100 }">
						<option value="${i }" <c:if test="${bean.limit == i}"> selected </c:if>>${i }</option>
					</c:if>
					</c:forEach>
				</select>
			</th>
			<th colspan="3">
				
				<select id="searchType" name="searchType" onchange="content_search()">
					<option value="notice_title" <c:if test="${bean.searchType == 'notice_title'}">selected </c:if> >제목</option>
					<option value="notice_content" <c:if test="${bean.searchType == 'notice_content'}">selected </c:if>>내용</option>
				</select>
				
				
				<input type="text" id="search" name="search" value="${bean.search }" onkeypress="search_go(event);" />
				<a href="#none" class="btn_search1" onclick="list_search(); return false;">검색</a>
			</th>
			<th>
					<a href="#" onclick="write_go(); return;">글쓰기</a>
			</th>
		</tr>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		</thead>
		
		<!-- 리스트 -->
		<c:forEach items="${bean.data }" var="list" varStatus="no">
			
		
				<tr>
					<!-- 글번호 -->
					<td>
						<c:choose>
							<c:when test="${list.notice_yn=='N'}">
								${bean.total - ((bean.page-1)*bean.limit+no.index)}
							</c:when>
							
							<c:otherwise>
								<img src="/shop/resources/images/notice_gongji.gif" />
							</c:otherwise>
						</c:choose>	
					</td>
		
					
					
					<!-- 답글 -->	
					<td class="subject_cell">
					<c:forEach begin="1" end="${list.notice_rev }" var="i">
						&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${list.notice_rev>0 }">
						┗
					</c:if>
					
					<c:if test="${bean.limit==(no.index+1) }">
						<c:set var="last" value="&last=last" />	
					</c:if>
					
					<!-- 제목 -->
					<c:choose>
						<c:when test="${list.notice_yn=='N'}">
								<a href="#"	onclick="detail_go('${list.notice_id}'); return false; ">${list.notice_title }</a></td>
						</c:when>
						
						<c:otherwise>
							<a href="#"	onclick="detail_go('${list.notice_id}'); return false; "><strong>${list.notice_title }</strong></a></td>
						</c:otherwise>
					</c:choose>	
					
					
					<!-- 작성자 -->
					<td>${list.bs_name }</td>
					
					
					<!-- 날짜 -->
					<td class="time_cell">
					<c:choose>
						<c:when test="${bean.newDate.getDate()==list.notice_reg_date.getDate() && bean.newDate.getMonth()==list.notice_reg_date.getMonth() && bean.newDate.getYear()==list.notice_reg_date.getYear()}">
							<fmt:formatDate value="${list.notice_reg_date }" pattern="HH:mm" />
						</c:when>
						<c:otherwise>
							<fmt:formatDate value="${list.notice_reg_date }" pattern="MM-dd" />
						</c:otherwise>
					</c:choose>
					</td>
					
					
					<!-- 조회수 -->
					<td class="hits_cell">${list.notice_cnt }</td>
				</tr>
				
		</c:forEach>
		
	</table>
	<div class="pageset">
		<div class="default_paginate">
				<c:choose>
					<c:when test="${bean.startPage>1 }">
						<a href="#" class="prev2"  onclick="pageGo(1)" >
							<strong><em>prev2</em></strong>
						</a>
					<a href="#" class="prev" onclick="pageGo(${bean.startPage-1 })">
						<strong><em>prev</em></strong>
					</a>
					</c:when>
					<c:otherwise>
						<span class="prev2" onclick="pageGo(1)" >
							<strong><em>prev</em></strong>
						</span>
					<span class="prev" >
						<strong><em>prev</em></strong>
					</span>
					</c:otherwise>
				</c:choose>	
					
				<c:forEach begin="${bean.startPage }" end="${bean.endPage }" var="i">
					<c:choose>
						<c:when test="${i==bean.page }">
							<span class="num on"><strong>${i }</strong></span>
						</c:when>
						<c:otherwise>
							<a href="#" class="num" onclick="pageGo(${i})" ><strong>${i }</strong></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${bean.endPage<bean.totalPage }">
						<a href="#" class="next" onclick="pageGo(${bean.endPage+1})">
						<strong><em>next</em></strong>
					</a>
					<a  class="next2" href="list?page=${bean.totalPage }">
						<strong><em>next2</em></strong>
					</a>
					</c:when>
					<c:otherwise>
						<span  class="next" >
						<strong><em>next</em></strong>
					</span>
					<span  class="next2">
						<strong><em>next2</em></strong>
					</span>
					</c:otherwise>
				</c:choose>
			</div>
	</div>
	
</form>
</div>