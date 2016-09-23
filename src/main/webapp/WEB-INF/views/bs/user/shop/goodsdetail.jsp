<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">

	$(document).ready(function(){
		
		var k='${bean.bestitem[0].g_pricedis}';
		var iPrice = 0;
		if(k!=''){
		k=k.format();
		iPrice='${bean.bestitem[0].g_pricedis}';
		var res="";
		for(var i=0;i<k.length;i++){
			if(k[i]==','){
				res+="<span class='comma'>,</span>";
			}else{
				res+="<span class='no"+k[i]+"'>"+k[i]+"</span>";
			}
		}
		res+="<span class='won'>원</span>";
		$('.now_price').append(res);
		
		var per =Math.round('${(bean.bestitem[0].g_price-bean.bestitem[0].g_pricedis)/bean.bestitem[0].g_price*100}');
		per=per.format();
		res="";
		for(var i=0;i<per.length;i++){
				res+="<span class='no"+per[i]+"'>"+per[i]+"</span>";
		}
		res+="<span class='percent'>% 할인</span>";
		$('.discount').append(res);
		}else{
			iPrice='${bean.bestitem[0].g_price}';
			k='${bean.bestitem[0].g_price}';
			k=k.format();
			var res="";
			for(var i=0;i<k.length;i++){
				if(k[i]==','){
					res+="<span class='comma'>,</span>";
				}else{
					res+="<span class='no"+k[i]+"'>"+k[i]+"</span>";
				}
			}
			res+="<span class='won'>원</span>";
			$('.now_price').append(res);
		}
		
		
		$("#a_g_code_price").val(iPrice);
		
		$("#g_option").change(function(){
			
			var sCheck = "Y", sText = "";
			var aData = "";
			var aTemp1, aTemp2, aTemp3; 

			var index = $("#g_option option").index($("#g_option option:selected"));
			
			if (index != 0)
			{
				aData = $("#h_option option").eq(index).text().split("#");
				
				if (parseInt(aData[3]) > 0)
				{
					if ($("#a_bgd_id").val() != "")
					{
						aTemp1 = $("#a_bgd_id").val().split("#");
						aTemp2 = $("#a_bgd_cnt").val().split("#");
						aTemp3 = $("#a_bgd_price").val().split("#");
						
						for (var i = 0; i < aTemp1.length; i++)
						{
							if (aData[0] == aTemp1[i])
							{
								sCheck = "N";
								break;
							}
						}
					}
					
					if (sCheck == "Y")
					{
						if ($("#a_bgd_id").val() == "")
						{
							$("#a_bgd_id").val(aData[0]);	
							$("#a_bgd_cnt").val(1);
							$("#a_bgd_price").val(iPrice);
						}
						else
						{
							$("#a_bgd_id").val($("#a_bgd_id").val() + "#" + aData[0]);	
							$("#a_bgd_cnt").val($("#a_bgd_cnt").val() + "#" + 1);
							$("#a_bgd_price").val($("#a_bgd_price").val() + "#" + iPrice);
						}
						
						$("#item_list").append(add_item());
						
						sText = $("#g_title").text() + " <span class='bar'>|</span>" + aData[1] + " <span class='bar'>|</span>" + aData[2];   
						$("#item_list li").last().find(".option").html(sText);
						
						sText = "<em class='opt_amt_76057153'>" + FormatNumber(iPrice) + "</em>원";
						$("#item_list li").last().find(".total").html(sText);
						
						var index = $("#item_list li").index($("#item_list li").last());
						
						$("[name='g_total_cnt']").eq(index).val(aData[3]);
						
						price_con();
					}
				}
			}
			
			$(this).blur();
			
		});
		
		
		add_count = function(obj, gubun)
		{
			var index = $("#item_list li").index($(obj).parent().parent().parent());
			
			var aTemp1 = $("#a_bgd_id").val().split("#");
			var aTemp2 = $("#a_bgd_cnt").val().split("#");
			var aTemp3 = $("#a_bgd_price").val().split("#");

			var iTotalCnt = $("[name='g_total_cnt']").eq(index).val();
			
			$("#a_bgd_cnt").val("");
			$("#a_bgd_price").val("");
			
			for (var i = 0; i < aTemp1.length; i++)
			{
				if (i == index)
				{
					if (gubun == "U")
					{
						if (parseInt(aTemp2[i]) > parseInt(iTotalCnt))
						{
							aTemp2[i] = iTotalCnt;
						}
						else
						{
							aTemp2[i] = parseInt(aTemp2[i]) + 1;
						}
					}
					else
					{
						if (parseInt(aTemp2[i]) <= 1)
						{
							aTemp2[i] = 1;
						}
						else
						{
							aTemp2[i] = parseInt(aTemp2[i]) - 1; 
						}
					}
					
					$("[name='view_cnt']").eq(i).val(aTemp2[i]);
					
					aTemp3[i] = parseInt(aTemp2[i]) * iPrice;
					
					
					$("#item_list li").eq(index).find(".opt_amt_76057153").html(FormatNumber(aTemp3[i]));
				}
				
				
				if ($("#a_bgd_cnt").val() == "")
				{
					$("#a_bgd_cnt").val(aTemp2[i]);
					$("#a_bgd_price").val(aTemp3[i]);
				}
				else
				{
					$("#a_bgd_cnt").val($("#a_bgd_cnt").val() + "#" + aTemp2[i]);
					$("#a_bgd_price").val($("#a_bgd_price").val() + "#" + aTemp3[i]);
				}
				
				
				price_con();
				
			}
			
			
		}
		
		
		price_con = function()
		{
			var iTemp = 0;
			var aTemp3 = $("#a_bgd_price").val().split("#");
			
			for (var i = 0; i < aTemp3.length; i++)
			{
				if (aTemp3[i] == "")
				{
					aTemp3[i] = 0;	
				}
				iTemp += parseInt(aTemp3[i]);
			}

			$("#bb_price").val(iTemp);
			$(".total_amount").html(FormatNumber($("#bb_price").val()));
		}
		
		
		remove_row = function(obj)
		{
			var index = $("#item_list li").index($(obj).parent());
			var aTemp1 = $("#a_bgd_id").val().split("#");
			var aTemp2 = $("#a_bgd_cnt").val().split("#");
			var aTemp3 = $("#a_bgd_price").val().split("#");
			
			$("#a_bgd_id").val("");
			$("#a_bgd_cnt").val("");
			$("#a_bgd_price").val("");
			
			for (var i = 0; i < aTemp1.length; i++)
			{
				if (i != index)
				{
					if ($("#a_bgd_id").val() == "")
					{
						$("#a_bgd_id").val(aTemp1[i]);	
						$("#a_bgd_cnt").val(aTemp2[i]);
						$("#a_bgd_price").val(aTemp3[i]);
					}
					else
					{
						$("#a_bgd_id").val($("#a_bgd_id").val() + "#" + aTemp1[i]);	
						$("#a_bgd_cnt").val($("#a_bgd_cnt").val() + "#" + aTemp2[i]);
						$("#a_bgd_price").val($("#a_bgd_price").val() + "#" + aTemp3[i]);
					}
				}
			}
			
			price_con();
			
			$("#item_list li").eq(index).remove();
			
		}
		
		
		
		
		add_item = function()
		{
			
			var html = "";
			html = "<li>";
			html += "<span class='option'></span>";
			html += "<span class='uio_option_cnt'>";
			html += "<input type='hidden' name='g_total_cnt' value='' />";
			html += "<input type='text' class='t_76057153 uio_option_input' readonly name='view_cnt' value='1' />";
			html += "<span class='uio_option_control'>";
			html += "	<a href=\"#none\" onclick=\"add_count(this, 'U');\" class='uio_btn_plus'>증가</a>";
			html += "	<a href=\"#none\" onclick=\"add_count(this, 'D');\" class='uio_btn_minus'>감소</a></span>";
			html += "</span>";
			html += "<span class='total'></span>";
			html += "<a href=\"#none\" onclick=\"remove_row(this);\" name='ee' class='btn_option_del'>옵션삭제</a>";
			html += "</li>";
			
			return html;
		}

		direct_buy = function()
		{
			if ($("#bb_price").val() != "0")
			{
				$("#frm").attr("action", "/shop/bs/user/buy/pay");
				$("#frm").submit();
			}
			else
			{
				alert("상품을 선택하세요!");
				return false;
			}
		}
		 
		
		cart = function()
		{	
			
			if('${session_userid}'=='' || '${session_userid}'== null  )
			{
				alert("로그인이 필요한 서비스 입니다.");
				return false;
			}
			
			if ($("#bb_price").val() == "0")
			{
				alert("상품을 선택하세요!");
				return false;
			}
			
			
			/* alert("g_code="+$('#g_code2').val()+"&a_arr="+$('#a_bgd_id').val()+"&a_arr2="+$('#a_bgd_cnt').val() + "&a_arr3=" + $('#a_bgd_price').val());
			return false; */
			 
			$.ajax({
			    type : "POST"
			    , async : true
			    , url : "basketOk"
			    , dataType : "html"
			    , timeout : 3000
			    , cache : false
			    , data :  "g_code="+$('#g_code2').val()+"&a_arr="+$('#a_bgd_id').val()+"&a_arr2="+$('#a_bgd_cnt').val() + "&a_arr3=" + $('#a_bgd_price').val()+"&bb_price="+$('#bb_price').val()
			    , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			    , error : function(request, status, error) {
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    },
			    success : function(response, status, request) 
			    {
			    	if('${session_bsid}'!='')
			    	{
			    		if('${bean.msg}'=='N')
			    		{
			    			alert('카트담기 완료 되었습니다.');
			    		}
			    		if('${bean.msg}'=='Y')
			    		{
			    			alert('이미 장바구니에 넣으셨습니다.')
			    		}
			    	}
			    	else
		    		{
			    		alert('장바구니는 로그인 이후 이용하실 수 있습니다.');
		    		}
			    }
			});
		}
		
		
		// 이방식은 좋은 방식은 아니지만, 프로젝트 시간이 너무 없어서 ㅠㅠ...  하악;;
		if ('${bean.a_bgd_id}' != "")
		{
			var sText = "";
			var aData = "";
			var aTemp1, aTemp2, aTemp3; 
			
			aTemp1 = $("#a_bgd_id").val().split("#");
			aTemp2 = $("#a_bgd_cnt").val().split("#");
			aTemp3 = $("#a_bgd_price").val().split("#");
			
			for (var i = 0; i < aTemp1.length; i++)
			{
				$("#h_option > option[value='" + aTemp1[i] + "']").prop('selected', 'true');
				aData = $("#h_option option:selected").text().split("#");
 
				$("#item_list").append(add_item());
				
				sText = $("#g_title").text() + " <span class='bar'>|</span>" + aData[1] + " <span class='bar'>|</span>" + aData[2];   
				$("#item_list li").last().find(".option").html(sText);
				
				sText = "<em class='opt_amt_76057153'>" + FormatNumber(aTemp3[i]) + "</em>원";
				$("#item_list li").last().find(".total").html(sText);
				
				var index = $("#item_list li").index($("#item_list li").last());
				
				$("[name='view_cnt']").eq(index).val(aTemp2[i]);
				$("[name='g_total_cnt']").eq(index).val(aData[3]);
				
				price_con();
			}

		}

	});
</script>

<form id="frm" name="frm" method="post" action="">
<input type="hidden" id="prev_page" name="prev_page" value="pay" />
<input type="hidden" name="g_code" id="g_code2" value="${bean.bestitem[0].g_code}" />



<input type="hidden" id="pay_pay1" name="pay_pay1" value="${bean.bb_price }" /><br />
<input type="hidden" id="pay_pay2" name="pay_pay2" value="0" /><br />
<input type="hidden" id="pay_pay3" name="pay_pay3" value="2500" /><br />
<input type="hidden" id="pay_pay4" name="pay_pay4" value="0" /><br />

<input type="hidden" id="bc_id" name="bc_id" value="" /><br />
<input type="hidden" id="bc_price" name="bc_price" value="0" /><br />


<div class="deal_detail_wrap">
	<div class="img_area">
		<div class="main_img" id="main_img">
			<c:choose>
				<c:when test="${bean.sum_bgd_cnt == 0}">
					<!-- 품절 -->
					<span class="runOut">품절</span>
				</c:when>
				<c:when test="${bean.min_bgd_cnt < 11}">
					<!-- 품절임박 -->
					<span class="toRunOut">품절임박</span>
				</c:when>
			</c:choose>			
			<img src="/shop/resources/up_img/${bean.bestitem[0].g_imgdetail}" />
		</div>
		</div>
		<div class="ct_area">
		<div id="promotion_block">
			<div id="price_info" class="price_info" >
				<p class="info">
					${bean.bestitem[0].g_describe}
				</p>
				<c:choose>
					<c:when test="${bean.bestitem[0].g_pricedis!=null}">
						<div class="price">
							<div class="old">
								<span class="hidden">정상가</span><em>
								<fmt:formatNumber maxFractionDigits="3" value="${bean.bestitem[0].g_price}" type="number"/><span class="won">원</span>
								<span class="line"></span>
								</em>
							</div>
							<strong class="now_price">
								<span class="hidden">할인가</span>
							</strong>
						</div>
						<div class="discount">
						</div>	
					</c:when>
					<c:otherwise>
						<div class="price">
                            <div class="old">
                                <span class="hidden">정상가</span>
                            </div>
                            <strong class="now_price">
                                <span class="hidden">할인가</span>
							
							</strong>
                        </div>
                        <div class="deal_condition"><span class="tmon_price">판매가</span></div>
					</c:otherwise>
				</c:choose>
				

			</div>
			
			<div class="coupon_guide_wrapper" style="z-index: 1">
				<div class="coupon_guide" id="coupon_guide" style="display: none">
					<span class="bu"></span>
					<div class="inner" id="coupon_guide_inner"></div>
				</div>
			</div>
		</div>
		
		<div class="people_time">
			<p class="people">
				<span class="txt1">현재</span><strong class="num buycount"
					style="display: inline;"><fmt:formatNumber   maxFractionDigits="3" value="${bean.bestitem[0].bp_cnt}" type="number"/></strong><span class="txt2">명 구매</span>
			</p>
		</div>
		
		<p class="txt_choice">
			<span class="default_opt_msg">상세옵션을 선택해 주세요.</span> 
		</p>
		<div class="option_info1">
			<div class="uio_option_lst uio_idx_0">
			<span id="btn_select_options_0_span">상품명 : </span>
			<span id="g_title">${bean.bestitem[0].g_name}</span>
			</div>
			<div class="uio_option_lst uio_idx_1">
				<span id="btn_select_options_1_span">옵션 : </span>
				
				<select id="h_option" style="display:none">
					<option value=""></option>
					<c:forEach items="${bean.bestitem }" var="goodsdetail">
						<option value="${goodsdetail.bgd_id}">${goodsdetail.bgd_id}#${goodsdetail.bgd_size}#${goodsdetail.bgd_color}#${goodsdetail.bgd_cnt}</option>
					</c:forEach>
				</select>
				
				<select id="g_option">
					<option>선택하세요</option>
					<c:forEach items="${bean.bestitem }" var="goodsdetail">
						<option>크기:${goodsdetail.bgd_size} | 색상:${goodsdetail.bgd_color} | 재고량:
							<c:choose>
								<c:when test="${goodsdetail.bgd_cnt==0}">
									품절
								</c:when>
								<c:otherwise>
									${goodsdetail.bgd_cnt}
								</c:otherwise>						
								</c:choose>
							
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="option_info2" style="display: block;">
				<input type="hidden" id="a_g_code" name="a_g_code" value="${bean.g_code}" />
				<input type="hidden" id="a_g_code_price" name="a_g_code_price" value="0" />
				<input type="hidden" id="a_bgd_id" name="a_bgd_id" value="${bean.a_bgd_id}" />
				<input type="hidden" id="a_bgd_cnt" name="a_bgd_cnt" value="${bean.a_bgd_cnt}" />
				<input type="hidden" id="a_bgd_price" name="a_bgd_price" value="${bean.a_bgd_price}" />
				<input type="hidden" id="bb_price" name="bb_price" value="0" />
	            <ul class="uio_option_area uio_scroll" style="display: block;" id="item_list"></ul>
            </div>
		</div>

		<div class="option_info2" style="display: none">
			<ul class="uio_option_area uio_scroll">
			</ul>
		</div>
		<div class="order_price1 sell" style="display: block;">
			<div class="total">
				<em>총 주문 금액</em> <strong><span class="total_amount">0</span><span
					class="won">원</span></strong>
			</div>
		</div>
		
		<div class="btn_area default">
			<c:choose>
				<c:when test="${bean.sum_bgd_cnt == 0}">
					<div class="btn_direct"><span class="buy_close">판매종료</span></div>
					<div id="btn_cart_main" class="btn_cart"><span class="add_cart_close">상품 준비중</span></div>
				</c:when>
				<c:otherwise>
					<div class="btn_direct"><a href="#none" onclick="direct_buy(); return false;">바로구매</a></div>
					<div id="btn_cart_main" class="btn_cart"><a href="#none" class="add_cart" onclick="cart(); return false;">카트담기</a></div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</div>
	<div id="div_deal_zzimlayer" style=""></div>
	<div class="lpop_wrap2" id="standby_alert"
		style="display: block; top: 50%; z-index: 1110; margin-top: -155px; display: none">
		<div class="lpop_cont">
			<p class="caution_dsc">구매를 계속 진행하시려면 확인을 눌러주세요.</p>
			<div class="btn_area">
				<a style="cursor: pointer" id="lpop_btn_ok_new" class="btn_ok">확인</a>
			</div>
		</div>
		<a style="cursor: pointer" id="lpop_btn_close_new" class="btn_clse">레이어
			닫기
		</a>
	</div>
	<span class="bg_btm"></span>

<div>
	<div></div>
	
</div>
</form>