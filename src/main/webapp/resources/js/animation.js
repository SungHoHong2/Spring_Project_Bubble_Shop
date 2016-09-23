$(document).ready(function () {
	var scrollSpeed = 0.2;
	var imgWidth = 1245;
	var posX = 0;
		setInterval(function(){
			if (posX >= imgWidth) posX= 0;
			posX += scrollSpeed;
			$('.animation').css("background-position",posX+"px 124px");
		}, 1);

});