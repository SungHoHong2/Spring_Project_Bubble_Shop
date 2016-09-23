<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrap_res">    
	<div class="wrap_event_res">
		<h3><span>EVENT</span></h3>
		<ul>
		<c:choose>
			<c:when  test="${bean.eventList.size()!=0}">
				<c:forEach items="${bean.eventList }" var="event">
					<li>
						<div class="listImg">
						<a href="#aa" onclick="eventGo('${elist.notice_id}'); return false;">
							<img src="/shop/resources/up_img/${event.notice_upfile}" style="width:133px;height:136px;"/>
						</a>
						</div>
						<div class="wrap_e_info">
							<p class="event_tit"><a href="" >${event.notice_title}</a></p>
							<p class="event_sub"><a href="" >${event.notice_content}</a></p>
						</div>
					</li>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<li>검색 결과가 없습니다!</li>			
			</c:otherwise>
		</c:choose>
		</ul>
	
	</div>
	<div class="wrap_goods_res">
		<h3><span>GOODS</span></h3>
		<ul>
			<c:choose>
				<c:when test="${bean.bestitem.size()!=0}">
				<c:forEach items="${bean.bestitem}"  var="itemlist" varStatus="no">
						<li>
							<div class="listImg">
							<a href="#" onclick="getGoodsDetail('${itemlist.g_code}'); return false;">
								<img src="/shop/resources/up_img/${itemlist.g_imglist}" style="width:133px;height:136px;"/>
							</a>
							</div>
							<div class="wrap_e_info">
								<div class="detail">
							<a href="" class="tit">${itemlist.g_name}</a>
							<p class="summary">${itemlist.g_describe}</p>
							<div class="amounts">
								<c:choose>
									<c:when test="${itemlist.g_pricedis!=null}">
										<p class="percent">
									<fmt:formatNumber type="number" pattern="###" value="70" /><em>%</em><span class="hidden">할인</span>
								</p>
								<div class="price">
									<p class="prime">
										<span class="hidden">정상가</span>
										<em>
										<fmt:formatNumber   maxFractionDigits="3" value="10000" type="number"/>  
										</em>원
									</p>
									<p class="sale">
										<span class="hidden">할인가</span>
										<em>
										<fmt:formatNumber   maxFractionDigits="3" value="7000" type="number"/>
										</em>원
									</p>
									<p class="price_info"></p>
								</div>
									</c:when>
									<c:otherwise>
										<p class="bs_price">판매가</p>
										<div class="price">
											<p class="sale"><em><fmt:formatNumber   maxFractionDigits="3" value="${itemlist.g_price }" type="number"/></em>원</p>
											<p class="price_info"></p>
										</div>
									</c:otherwise>
								</c:choose>
								
							</div>
							<span class="people"><c:if test="${itemlist.bp_cnt!=0 }" ><em><fmt:formatNumber   maxFractionDigits="3" value="1205" type="number"/></em>개 구매</c:if></span>
						</div>
						<div class="option" style="display:none">
							<div class="sico">
								<span class="free" style="display:none">무료배송</span>
							</div>
							<div class="select" style="display:none">
								<a href="" class="btn_select"><span>찜하기</span></a>
							</div>
						</div>
			
					</div> 
				</li>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<li>검색 결과 없음!!</li>		
		</c:otherwise>
	</c:choose>
		</ul>
	</div>
</div>