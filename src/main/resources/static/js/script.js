 $(function(){
 var swiper = new Swiper('.gallery .gallery_inner ', {
    slidesPerView: 3,//보여지는 갤러리 수
    spaceBetween: 20,//갤러리 사이 간격
    speed: 1200,//버튼을 슬라이드가 넘어가는 시간
	  autoplay: {
        delay: 2500,//자동으로 넘어가기 전 머무르는 시간
        disableOnInteraction: false,
      },
      loop: true,//슬라이드 무한반복
      navigation: {//화살표 버튼
        nextEl: '.gallery .swiper-button-next',
        prevEl: '.gallery .swiper-button-prev',
      },
	    // pagination: {//블릿 버튼
      //   el: '.gallery .swiper-pagination',
      //   clickable: true,
      // },
    });
});


$(function(){
  var swiper = new Swiper('.gallery2 .gallery_inner ', {
     slidesPerView: 3,//보여지는 갤러리 수
     spaceBetween: 20,//갤러리 사이 간격
     speed: 1200,//버튼을 슬라이드가 넘어가는 시간
     autoplay: {
         delay: 8000,//자동으로 넘어가기 전 머무르는 시간
         disableOnInteraction: false,
       },
       loop: true,//슬라이드 무한반복
       navigation: {//화살표 버튼
         nextEl: '.gallery2 .swiper-button-next',
         prevEl: '.gallery2 .swiper-button-prev',
       },
       pagination: {//블릿 버튼
         el: '.gallery2 .swiper-pagination',
         clickable: true,
       },
     });
 });

 $(function(){
  var swiper = new Swiper('.gallery3 .gallery_inner ', {
     slidesPerView: 4,//보여지는 갤러리 수
     spaceBetween: 20,//갤러리 사이 간격
     speed: 1200,//버튼을 슬라이드가 넘어가는 시간
     autoplay: {
         delay: 8000,//자동으로 넘어가기 전 머무르는 시간
         disableOnInteraction: false,
       },
       loop: true,//슬라이드 무한반복
       navigation: {//화살표 버튼
         nextEl: '.gallery3 .swiper-button-next',
         prevEl: '.gallery3 .swiper-button-prev',
       },
       pagination: {//블릿 버튼
         el: '.gallery3 .swiper-pagination',
         clickable: true,
       },
     });
 });


 $(function(){
  var swiper = new Swiper('.sub2_gallery .sub2_gallery_inner ', {
     slidesPerView: 3,//보여지는 갤러리 수
     spaceBetween: 20,//갤러리 사이 간격
     speed: 1200,//버튼을 슬라이드가 넘어가는 시간
     autoplay: {
         delay: 8000,//자동으로 넘어가기 전 머무르는 시간
         disableOnInteraction: false,
       },
       loop: true,//슬라이드 무한반복
       navigation: {//화살표 버튼
         nextEl: '.sub2_gallery .swiper-button-next',
         prevEl: '.sub2_gallery .swiper-button-prev',
       },
      
     });
 });



 $(window).scroll(function() {
  var height = $(window).scrollTop();
  if (height > 700) {
      $('.top').fadeIn();
  } else {
      $('.top').fadeOut();
  }
});

$( '.top' ).click( function() {
$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
return false;
} );
