$(document).ready(function(){
	$(".sh_nav").mouseenter(function(){
		$("#shGnb").addClass("on");
 		$("#shGnb:not(.fix) .sh_logo img").attr("src","img/common/logo.png");
	 	$(".sh_lnb_s").fadeIn(200);
		$(".sh_lnb_bg").fadeIn(200);	
	}).mouseleave(function(){
		$("#shGnb").removeClass("on");
     	$("#shGnb:not(.fix) .sh_logo img").attr("src","img/common/logo.png");
		$('.sh_lnb_s').stop().fadeOut(200);
	  	$('.sh_lnb_bg').stop().fadeOut(200);
	});

	 /* 반응형 [s] */
	 $("#m_navBtn").click(function(){
		m++;
		if(m%2 == 1){
			$("#m_navBtn").addClass("on");
			$("#navWrap").fadeIn(300).addClass("on");
		}else{
			navClose(); 
		}; 
	});	
	$("#topmenuM .m_bmenu").click(function(){
		$('.m_smenu').not($(this).next()).slideUp(200);
		$('.m_bmenu').removeClass('on');
		$(this).addClass('on')
		$(this).next().slideDown(200);
	});	

	m = 0;  	
	/* 반응형 [e] */
});