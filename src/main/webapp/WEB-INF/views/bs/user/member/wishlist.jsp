<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_container"> 
        <ul class="mypage_category" >
            <li class="menu1"><a href="/user/buyInfo/List?type=all"><span class="name">구매내역</span></a>
            </li> 
            <li class="menu2"><a href="/user/buyInfo/claim"><span class="name">취소,환불 내역</span></a></li>
            <li class="menu3"><a href="/user/buyInfo/coupon"><span class="name">할인쿠폰</span></a>
                </li>
            <li class="menu5 on"><a href="/user/wishlist"><span class="name">찜한 상품</span></a></li>
            <li class="menu8"><a href="/user/qna/talklist?type=talk"><span class="name">문의/답변</span></a>
                </li>
            <li class="menu9"><a href="/user/info"><span class="name">개인정보</span></a></li>
         </ul>
                <div class="alimipop" style="display:none;z-index:10000000;"></div>
        <div class="zzim_lst">
            <h3 class="h_zzim"><span>찜한 상품</span></h3>
            <div class="align_area">
                <div class="fl">
                    <a href="javascript:cartWishlistSelect();" class="btn_cart">카트담기</a>
                    <a href="javascript:deleteWishlistSelect();" class="btn_sel_delete">선택 삭제</a>
                </div>
                
            </div>
            <form name="wishlist">
            <table >
                <caption>내가 찜한 상품 리스트</caption>
                <colgroup><col width="36"><col width="108"><col width=""><col width="121"><col width="121"><col width="121"></colgroup>
                <thead>
                    <tr>
                        <th scope="col" class="bn"><input type="checkbox" id="chk_all"></th>
                        <th scope="col" class="bn" colspan="2">상품정보</th>
                        <th scope="col">남은시간</th>
                        <th scope="col">찜한날짜</th>
                        <th scope="col">관리</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="frst">
                            <input type="checkbox" id="0" name="wish_chk[]" value="72453425" =""="" nocart="N">
                        </td>
                        <td class="thmb">
                                                            <a href="/deal/72453425" tl:area="WWCO" tl:ord="1">
                                    <img src="http://img2.tmon.kr/deals/7245/72453425/around_dbd29.jpg" width="106" height="71" alt="">
                                                                                                                        </a>
                            
                        </td>
                        <td class="deal_info">
                            <a href="/deal/72453425" tl:area="WWCO" tl:ord="1" tl:linktype="txt">앵콜! 아나이스 블랙&amp;화이트 통굽샌들</a>
                                                            <span class="state todayend">todayend</span>
                            
                            <p class="price">
                                                                                                                                                <span class="blind">티몬가</span><strong><em>12,800</em>원</strong>
                                    
                                
                                                                </p>
                            </td>
                        <td><strong class="left_time"><span>오늘마감</span></strong></td>
                        <td><em>2014.05.22</em></td>
                        <td class="manage">
                                                                                                <a href="javascript:buyWishlistcart(72453425)" class="btn_buy">구매하기</a>
                                    <a href="javascript:cartWishlist(72453425)" class="btn_scart">카트담기</a>
                                
                                <a href="javascript:deleteWishlist(72453425)" class="btn_delete">삭제</a>
                                </td>
                    </tr>
                    <tr>
                        <td class="frst">
                            <input type="checkbox" id="1" name="wish_chk[]" value="73459901" =""="" nocart="N">
                        </td>
                        <td class="thmb">
                                                            <a href="/deal/73459901" tl:area="WWCO" tl:ord="2">
                                    <img src="http://img2.tmon.kr/deals/7345/73459901/around_48730.jpg" width="106" height="71" alt="">
                                                                                                                        </a>
                            
                        </td>
                        <td class="deal_info">
                            <a href="/deal/73459901" tl:area="WWCO" tl:ord="2" tl:linktype="txt">탑모델 썸머신상 데일리 샌들</a>
                                                            <p class="price">
                                                                                                                                                <span class="blind">티몬가</span><strong><em>8,900</em>원</strong>
                                    
                                
                                                                </p>
                            </td>
                        <td><strong class="left_time"><span>6일</span> 남음</strong></td>
                        <td><em>2014.05.22</em></td>
                        <td class="manage">
                                                                                                <a href="javascript:buyWishlistcart(73459901)" class="btn_buy">구매하기</a>
                                    <a href="javascript:cartWishlist(73459901)" class="btn_scart">카트담기</a>
                                
                                <a href="javascript:deleteWishlist(73459901)" class="btn_delete">삭제</a>
                                <div class="alarm">
                                    <a id="btn_alarm_73459901" onclick="alarmRequest('73459901', '');" class="btn_alarm" style="cursor:pointer">알리미 신청</a>
                                    <div class="ly" id="alarm_ok_73459901" style="display:none"><span class="arr"></span>알리미가 신청되었습니다.</div>
                                    <div class="ly" id="alarm_cancel_73459901" style="display:none"><span class="arr"></span>알리미가 취소되었습니다.</div>
                                </div>
                            
                        </td>
                    </tr>
                    </tbody>
            </table>
            <input type="hidden" name="del" value="">
            <input type="hidden" name="return_url" value="">
            </form>
            <div class="align_area">
                <div class="fl">
                    <a href="javascript:cartWishlistSelect();" class="btn_cart">카트담기</a>
                    <a href="javascript:deleteWishlistSelect();" class="btn_sel_delete">선택 삭제</a>
                </div>
                <p class="txt_zzim_info">찜한 상품 구매시 목록에서 자동으로 삭제됩니다.</p>
            </div>
                        <div class="paginate_regular">
    </div>
            
        </div>
<script>
$(function() {

    if (2 <= 0 )
    {
        $('#chk_all').attr('disabled',true);
    }

    $('select[name=wishlist_filter]').change(function (){
        location.href='/user/wishlist?wishlist_filter='+$(this).val();
    });

    $('#chk_all').click(function(){
        var on = $(this).attr('checked') == 'checked';
        $(':checkbox').each(function() {
            var c = this.disabled;
            if (!c){
                $(this).attr('checked', on);
            }
        });
    });
});

function buyWishlist(deal_srl)
{
    location.href='/buy/'+deal_srl;
}

function buyWishlistcart(deal_srl)
{
    location.href='/deal/'+deal_srl;
}


function deleteWishlist(deal_srl)
{
    if (!confirm("선택하신 상품을 삭제하시겠습니까?"))
        return;

    var frm = document.forms['wishlist'];
    frm.method = 'POST';
    frm.del.value = deal_srl;
    frm.return_url.value = "/user/wishlist";
    frm.action = "/user/wishlist/deletewishlist";
    frm.submit();
}

function deleteWishlistSelect()
{
    if (!$("input[name='wish_chk[]']:checked").val())
    {
        alert('삭제할 상품을 선택하세요.');
        return;
    }
    if(!confirm("선택하신 상품을 삭제하시겠습니까?"))
        return;

    var frm = document.forms['wishlist'];
    frm.method = 'POST';
    frm.return_url.value = "/user/wishlist";
    frm.action = "/user/wishlist/deletewishlist";
    frm.submit();
}

function cartWishlistSelect()
{

    if (!$("input[name='wish_chk[]']:checked").val())
    {
        alert('카트에 담을 상품을 선택하세요.');
        return;
    }

    var chk = false;

    var len = $("input[name='wish_chk[]']:checked").size();
    $("input[name='wish_chk[]']:checked").each(function ()
    {
        if (len == 1 && ($(this).attr('is_gift') || $(this).attr('paycustom')))
        {
            alert('이 상품은 카트에 담을 수 없습니다.');
            chk = 'true';
        }
    });
    //성인딜 중,하 등급은 카트담기 제외
    var nocart_len = $("input[name='wish_chk[]']:checked[nocart=Y]").length;
    if (nocart_len)
    {
        if(!(len-nocart_len))
        {
            alert("선택하신 상품은 카트에 담을 수 없습니다");
            chk = 'true';
        }
        else
        {
            alert("선택하신 상품 중 카트에 담을 수 없는 상품이\n" + $("input[name='wish_chk[]']:checked[nocart=Y]").length +"건이 포함되어 있어 해당 상품 제외 후\n카트에 담습니다");
            $("input[name='wish_chk[]']:checked[nocart=Y]").attr("checked", false);
        }
    }
    if (chk == false)
    {
        if (confirm('선택하신 상품을 카트에 담으시겠습니까?'))
            addCart('multi', null);
    }
}

function cartWishlist(deal_srl)
{
    if (!confirm("선택하신 상품을 카트에 담으시겠습니까?"))
        return;
    addCart('single', deal_srl);

}

function addCart(type, deal_srl) //{{{
{
    /*if (typeof selected_item === 'undefined')
        return;

    var to_dic = $.stringify(selected_item);
    var dic = {'item':to_dic, 'delivery_amount':delivery_amount};*/
    var dic = '';
    if (type == 'single')
        dic = {'deal_srl':deal_srl};
    else if (type == 'multi')
    {
        var checked = []

        $("input[name='wish_chk[]']:checked").each(function ()
        {
            if (!$(this).attr('is_gift') && !$(this).attr('paycustom'))
                checked.push(parseInt($(this).val()));
        });
        dic = {'deal_srls':$.stringify(checked)};
    }
    //var cart = 'zzim';
    var _goCart = function() {
        $.post("/cart/addCartOnlyDealSrl/"+type, dic, function(response){
            var res = $.parseJSON(response);
            if (res.success == 'OK')
                location.replace(res.result.data);
            else
                alert(res.error.message);
        });
    }

    _goCart();

} //}}}
</script>
<script src="http://static2.tmon.kr/static/js/alarm.js?v=b8c60b5477825358023e2f453ed6a53011d5ef3b"></script>
    </div>