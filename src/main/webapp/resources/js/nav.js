$(document).ready(function() {
	 $('ul.dropdownmenu li.menu').hover(
             function() { 
                $('ul', this).fadeIn('normal',function(){$(this).stop();});
                //$('a', this).animate({top:-21},'fast').clearQueue();
             },
            function() {
                $('a', this).animate({top:0},100).clearQueue();
                $('ul', this).fadeOut(100);
           });
	 $('ul.dropdownmenu li.menu .depth1').bind('focus', function () {        
         $(this).parents('.menu').find('ul').fadeIn(100);
         $(this).parents('.menu').siblings().find('ul').fadeOut(100);
  });
	 
	 $('.cnb_lst .menu.selected ul').css("display","block");
	 $('.cnb_lst .depth .selected').parent().css("display","block");
	 $('.cnb_lst .menu').hover(function(){
		 
		$('ul', this).slideDown(100).clearQueue(); 
	 },
	 function(){
		 $('ul', this).slideUp(100).clearQueue();
		
	 }
	 );

	 	
});

Number.prototype.format = function(){
    if(this==0) return 0;
    var reg = /(^[+-]?\d+)(\d{3})/;
    var n = (this + '');
    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
    return n;
};
 
String.prototype.format = function(){
    var num = parseFloat(this);
    if( isNaN(num) ) return "0";
    return num.format();
};

function delete_cookie( name ) {
	document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
	$('.saw'+name).remove();
	$('.lst ul li').eq(3).css("display","block");
	var temp=$('#recent_total_cnt').text();
	temp--;
	$('#recent_total_cnt').text(temp);
	if(temp==0){
		$('.lst').find('ul').remove();
		$('.lst').prepend('<p class="data_none">최근 본 상품이<br>없습니다.</p>');
	}
}
