<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%
	Cookie[] cookies= request.getCookies();
	String [] res=null;
	String [][] dataSet=null;
	if(cookies!=null){
		res= new String [cookies.length-1];
		for(int i=0;i<cookies.length-1;i++){
			res[i]=URLDecoder.decode(cookies[i].getValue(), "utf-8");
		}
		String[] resR= new String[res.length];
		int ban=0;
		for(int i=res.length-1;i>=0;ban++,i--){
			resR[ban]=res[i];
		}
		
		dataSet= new String[ban][];
		for(int i=0;i<dataSet.length;i++){
			
			dataSet[i]=resR[i].split("/");
		}
		
	}
%>
<form name='frm' method="post" action="goods">
	<input type="hidden" name="page" value="${bean.page}" /> 
	<input type="hidden" id="bm_id" name="bm_id"  value="${bean.bm_id}"/>
	<input type="hidden" id="bm_depth" name="bm_depth" value="${bean.bm_depth}" />
 
<div class="cnb" style="display: block;">
	<ul class="cnb_lst">
		<c:set var="i" value="1" />
            	<c:forEach items="${bean.menuitem}"  var="m_1depth" >
            		<c:if test="${m_1depth.bm_par_id==0}">
            			<li class="m${i} menu <c:if test='${m_1depth.bm_id==bean.bm_id}'> selected</c:if>">
	            				<c:if test="${i!=4}">
	            					<h3><a href="" onclick="getGoodsList('${m_1depth.bm_id}', 1); return false;" >${m_1depth.bm_name}</a></h3>
	            				</c:if>
            				<ul style="display:none" class="depth">
            				<c:forEach items="${bean.menuitem}"  var="m_2depth" >
            						<c:if test="${m_1depth.bm_id==m_2depth.bm_par_id}">
  	          							<li <c:if test="${m_2depth.bm_id==bean.bm_id}">class="selected"</c:if>>
            								<a href="" onclick="getGoodsList('${m_2depth.bm_id}', 2); return false;">${m_2depth.bm_name}</a>
            							</li>
            						</c:if>
            				</c:forEach>
            				</ul>
            			</li>
            			<c:set var="i" value="${i+1}" />
            		</c:if>
            	</c:forEach>
	
    	
        </ul>

        <!--[ 좌측날개 플로팅 배너 ]-->
        <!--[ 좌측날개 플로팅 배너 ]-->
<div class="prmt_banner">
       
        </div>
    </div>
    
    <div class="zzim_area flow" id="zzim_area">
        <div class="cart" style="display:none">
            <h3><a class="redirect_cart" style="cursor:pointer"><span>카트</span><em></em></a></h3>
        </div>
        
        <div id="float_recent" class="lately on">
                        <h3><a>최근본상품<em id="recent_total_cnt"><%=dataSet.length%></em></a></h3>
            <div class="lst">
            <c:choose>
            	<c:when test="<%=dataSet.length!=0%>">
					<ul>
	                <c:forEach items="<%=dataSet%>" var="cookies" varStatus="no">
	                	
	                	<li class="saw${cookies[0]}" <c:if test="${no.index>3}">style="display:none"</c:if>>
	                    <a href="#" onclick="getGoodsDetail('${cookies[0]}'); return false;">
		                    <img src="/shop/resources/up_img/${cookies[1]}" width="82" height="55" alt="">
							
						</a>
	                    <div class="detail">
	                        ${cookies[3]}<span><em><fmt:formatNumber type="number" maxFractionDigits="3" value="${cookies[2]}" /> </em>원</span>
	                        <a href="#" onclick="delete_cookie('${cookies[0]}'); return false;" class="btn_delete">삭제</a>
	                    </div>
		                </li>
		            
	                </c:forEach>
                </ul>            	
            	</c:when>
            	<c:otherwise>
            		<p class="data_none">최근 본 상품이<br>없습니다.</p>
            	</c:otherwise>
            </c:choose>
             
            </div>
        </div>
    </div>
    
    <div class="wrap_best">
	<h3 class="goods_cate">
	<c:forEach items="${bean.menuitem}" var="menu">
		<c:if test="${menu.bm_id==bean.bm_id}">
			${menu.bm_name} 
		</c:if>
	</c:forEach>
	</h3>
	<ul>
		<c:if test="${bean.bestitem.size()!=0}">
		<c:forEach items="${bean.bestitem}"  var="itemlist" varStatus="no">
			
			<li <c:if test="${no.index%3==2}">class="lastOne"</c:if>>
			<a href="" class="thmb" onclick="getGoodsDetail('${itemlist.g_code}'); return false;">
		        <img src="/shop/resources/up_img/${itemlist.g_imglist}" width="322" height="330" alt="">
		        <span class="edge"></span>
		        <span class="hover"></span>
		    </a>
			<div class="detail">
				<p class="summary">${itemlist.g_describe}</p>
				<a href="#">${itemlist.g_name}</a>
				<div class="amounts">
					<c:choose>
						<c:when test="${itemlist.g_pricedis!=null}">
							<p class="percent">
						<fmt:formatNumber type="number" pattern="###" value="${(itemlist.g_price-itemlist.g_pricedis)/itemlist.g_price*100}" /><em>%</em><span class="hidden">할인</span>
					</p>
					<div class="price">
						<p class="prime">
							<span class="hidden">정상가</span>
							<em>
							<fmt:formatNumber   maxFractionDigits="3" value="${itemlist.g_price }" type="number"/>  
							</em>원
						</p>
						<p class="sale">
							<span class="hidden">할인가</span>
							<em>
							<fmt:formatNumber   maxFractionDigits="3" value="${itemlist.g_pricedis }" type="number"/>
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
				<span class="people"><c:if test="${itemlist.bp_cnt!=0 }" ><em>${itemlist.bp_cnt}</em>개 구매</c:if></span>
			</div>
			<div class="option">
				<div class="sico" style="display:none;">
					<span class="free">무료배송</span>
				</div>
				<div class="select" style="display:none;">
					<a href="" class="btn_select"><span>찜하기</span></a>
				</div>
			</div></li>
		</c:forEach>
		</c:if>
		
		</ul>
		<c:if test="${bean.bestitem.size()==0}">
			<p>서비스 준비중입니다!</p>
		</c:if>
</div>
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
    <script type="text/javascript">
		
		pageGo = function(page) 
		{
			
			frm.page.value = page;
			
			frm.submit();
		}
		
</script>
 </form>