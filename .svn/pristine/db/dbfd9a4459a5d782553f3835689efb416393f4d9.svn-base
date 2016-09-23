<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<table class="tbl_full" id="hong_detail_table3">
	<thead>
		<tr>
			<th colspan="2">
				<div class = "hong_exit3">
   					<span class="button large neutral">접기</span>
   				</div>	
			</th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td width="200px">
		 상세 내용 
		</td>
		<td>
		    ${bean.data.g_describe }
		</td>
	</tr>
	<tr>
		<td>
		제품 개수
		</td>
		<td>
			${bean.data.g_num }
		</td>
	</tr>
	<tr>
		<td>
			가격 / 할인 가격 
		</td>
		<td>
			${bean.data.g_price } / ${bean.data.g_pricedis }
		</td>
	</tr>
	<tr>
		<td>
			판매 상태
		</td>
		<td>
			<c:choose>
				<c:when test="${bean.data.g_sell=='Y'}">
						<span class="button large positive">판매</span>
				</c:when>
				<c:otherwise>
						<span class="button large negative">보류</span>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>
			게시 상태
		</td>
		<td>
			<c:choose>
				<c:when test="${bean.data.g_show_list=='Y'}">
						<span class="button large positive">게시</span>
				</c:when>
				<c:otherwise>
						<span class="button large negative">보류</span>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>
			메인화면 진열
		</td>
		<td>
			<c:choose>
				<c:when test="${bean.data.g_show_hot=='Y'}">
						<span class="button large positive">게시</span>
				</c:when>
				<c:otherwise>
						<span class="button large negative">보류</span>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>
			게시시작일 ~  게시종료일 
		</td>
		<td>
			  <fmt:formatDate value="${bean.data.g_start_day}" pattern="MM-dd HH:mm"/>
			  ~
			  <fmt:formatDate value="${bean.data.g_end_day}" pattern="MM-dd HH:mm"/>
		</td>
	</tr>
	<tr>
		<td>
			리스트 이미지
		</td>
		<td>
			<img src="../../../resources/upimage/${bean.data.g_imglist}" width="450" height="350">
		</td>
	</tr>
	<tr>
		<td>
			상세 이미지
		</td>
		<td>
			<img src="../../../resources/upimage/${bean.data.g_imgdetail }" width="450" height="350">
		</td>
	</tr>
	<tr>
		<td>
			핫아이템<br>
			썸네일 
		</td>
		<td>
			<img src="../../../resources/upimage/${bean.data.g_imghotitem }" width="450" height="350">
		</td>
	</tr>
	<tr>
		<td>
			핫아이템<br>
			이미지
		</td>
		<td>
			<img src="../../../resources/upimage/${bean.data.g_imgshotitem}" width="450" height="350">
		</td>
	</tr>
	
	</tbody>
</table>
		