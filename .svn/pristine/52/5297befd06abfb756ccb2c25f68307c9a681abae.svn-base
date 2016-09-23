<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="visual">
	<h3 class="hidden">Bubble shop Hot</h3>
	<div class="roll">
		<c:forEach items="${bean.data}" var="img" varStatus="no">
			<div class="item" id="item${no.index+1}" style="display:none">
				<a href="#" onclick="getGoodsDetail('${img.g_code}'); return false;"><img src="/shop/resources/up_img/${img.g_imghotitem}" alt="" width="704" height="355" /></a>
			</div>
		</c:forEach>
	</div>
	<div id="roll_list">
		<ul class="hot_lst">
			<c:forEach items="${bean.data}" var="img" varStatus="no">
			<li id="mini${no.index+1}">
				<span class="ico"></span>
				<a href="#" style="background:url(/shop/resources/up_img/${img.g_imgshotitem}) no-repeat;">
				이동
                </a>
			</li>
			</c:forEach>
		</ul>
		<div class="ctrl_banner" id="storehometodaypage">
                <p class="prev" onmouseover="pagemouseoverbig('storehomebigpage_prev')" onmouseout="pagemouseoutbig('storehomebigpage_prev')"><a id="storehomebigpage_prev" style="cursor: pointer; display: none;"><span>이전 배너</span></a></p>
        <p class="next" onmouseover="pagemouseoverbig('storehomebigpage_next')" onmouseout="pagemouseoutbig('storehomebigpage_next')"><a id="storehomebigpage_next" style="cursor:pointer;display:none"><span>다음 배너</span></a></p>
        <span class="page" id="bigbanner_page_view"></span>
    </div>
	</div>
	
</div>
<script>var time = 2000;
var banner_cnt = ${bean.data.size()}; // 전체 롤링배너 갯수
var banner_time = null;
var b_page = 1;
var page_total = Math.ceil(banner_cnt / 5); //페이지
var cat_srl = 104125;
var slideStart = getStorehomeBigBannerSlideStart(cat_srl, banner_cnt);
var page_click = null; //페이지클릭할때
if (slideStart == 'fixed')
{
    var is_first = false; //시작값 없는지 있는지 
}
else
{
    if (slideStart == 1)
        var is_first = false;
    else
    {
        var is_first = true;
        var n = slideStart - 2 ;
        var first_idx = n; //시작 배너 값
    }
}

var storehomebannerroll = function() {
    var idx;
    if (is_first && page_click===null)
        idx = first_idx;
    else
        idx = $('.item:visible').index();
 
    var next_idx = idx + 1;
    if (next_idx == banner_cnt) {
        next_idx = 0;
    }

    storehomebanner(next_idx);

    is_first = false;
}

$(function() {
    if (banner_cnt > 5)
    {
        $('#storehometodaypage p').click(function(){
            if ($(this).hasClass('next'))
            {
                b_page = b_page + 1;
                if (b_page > page_total)
                    b_page = 1;
            }
            else if ($(this).hasClass('prev'))
            {
                b_page = b_page - 1;
                if (b_page <= 0)
                    b_page = page_total;
            }
            movebannerpage(b_page);
            clear_time();
            set_time();
            page_click = '1';
        });
    }
    
    $('.hot_lst li')
      .bind('mouseover', function() {
        clear_time();
        storehomebanner($(this).index());
    }).bind('mouseout', function() {
        set_time();
    });

    $('.item')
      .bind('mouseover', function() {
        clear_time();
    }).bind('mouseout', function() {
        set_time();
    });
    set_time();
});

function set_time()
{
    if (banner_time === null)
        banner_time = setInterval(storehomebannerroll, time);
}

function clear_time()
{
    clearInterval(banner_time);
    banner_time = null;
}

function movebannerpage(page)
{
    for (var i=1; i<=banner_cnt; i++)
    {
        if ((i >= (page*5)-4) && (i <= (page*5)))
        {
            $('#mini'+i).show();
        }
        else
            $('#mini'+i).hide();
    }
    var num = (page*5)-5;
    var idx = num +1;
    $('.item:visible').hide();
    $('.item').eq(num).show();
    $('.hot_lst li').removeClass('selected');
    $('#mini'+idx).addClass('selected');
    
    $('.hot_lst .selected a').css("background-position","0px -65px");

    $('#bigbanner_page_view').html("<strong>"+page+"</strong>/"+page_total);
}

function pagemouseoverbig(kind)
{
    $('#'+kind).show();
}

function pagemouseoutbig(kind)
{	
	
    $('#'+kind).hide();
}

function storehomebanner(num)
{
    $('.item:visible').hide();
    $('.item').eq(num).show();
    var idx = num+1;
    $('.hot_lst li').removeClass('selected');
    $('.hot_lst li a').css("background-position","0px 0px");
    $('#mini'+idx).addClass('selected');
    $('.hot_lst .selected a').css("background-position","0px -65px");
    if (idx%5==1)
    {
        var p = Math.ceil(idx/5);
        movebannerpage(p);
    }
}


function getStorehomeBigBannerSlideStart(cat_srl, banner_cnt)
{
    cat_srl = Number(cat_srl);
    var view_type = 'fixed';
    if (view_type == 'fixed')
        return view_type;
    
    var cookie_info = getCookie('storehome_bigbanner');
    if (cookie_info == null)
    {
        var storehome_bigbanner_cookies = {};
        storehome_bigbanner_cookies[cat_srl] = 1;

        setCookie('storehome_bigbanner', $.stringify(storehome_bigbanner_cookies) , {path : '/'});

        return 1;
    }

    var storehome_bigbanner_cookies = $.parseJSON(cookie_info);
    var last_idx = storehome_bigbanner_cookies.length;
    var order = 0;

    for (var i in storehome_bigbanner_cookies)
    {
        if (i == cat_srl)
        {
            var val = storehome_bigbanner_cookies[i];
            if (storehome_bigbanner_cookies[i] < banner_cnt)
                order = val + 1;
            else
                order = 1;

            storehome_bigbanner_cookies[i] = order;
        }
    }

    if (order == 0) //쿠키값이 없을 경우
    {
        storehome_bigbanner_cookies[cat_srl] = 1;
        setCookie('storehome_bigbanner', $.stringify(storehome_bigbanner_cookies), {path : '/'});
        return 1;

    }
    else
    {
        setCookie('storehome_bigbanner', $.stringify(storehome_bigbanner_cookies), {path : '/'});
        return order;
    } 
}
</script>
<div class="wrap_event">
	<h3>Bubble Shop 기획전</h3>
	<ul>
		<c:forEach items="${bean.eventList}"  var="elist">
			<li><a href="" onclick="eventGo('${elist.notice_id}'); return false;">

			<c:choose>
				<c:when test="${elist.notice_upfile!=null}">
					<img src="/shop/resources/upfile/${elist.notice_upfile}" alt="${elist.notice_title}" style="width:231px;height:178px;">
				</c:when>
				<c:otherwise>
					<img src="/shop/resources/up_img/default.jpg" alt="준비중" style="width:231px;height:178px;">
				</c:otherwise>
			</c:choose>
			</a></li>
		</c:forEach>
		<c:forEach begin="1" end="${8-bean.eventList.size()}">
			<li><img src="/shop/resources/up_img/default.jpg" alt="준비중" style="width:231px;height:178px;"></li>
		</c:forEach>	
	</ul>
</div>
<div class="wrap_best">
	<h3>Bubble Shop Best</h3>
	<ul>
		<c:forEach items="${bean.bestitem}"  var="itemlist" varStatus="no">
			
			<li <c:if test="${no.index%3==2}">class="lastOne"</c:if>>
			<a href="" class="thmb" onclick="getGoodsDetail('${itemlist.g_code}'); return false;">
		        <img src="/shop/resources/up_img/${itemlist.g_imglist}" width="322" height="330" alt="">
		        <span class="edge"></span>
		        <span class="hover"></span>
		    </a>
			<div class="detail">
				<p class="summary">${itemlist.g_describe}</p>
				<a href="">${itemlist.g_name}</a>
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
				<div class="sico">
					<span class="free" style="display:none">무료배송</span>
				</div>
				<div class="select" style="display:none">
					<a href="" class="btn_select"><span>찜하기</span></a>
				</div>
			</div></li>
		</c:forEach>
		</ul>
</div>




