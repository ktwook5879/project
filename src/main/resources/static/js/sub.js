
$(function(){
    $('.a_menu').mouseover(function(){
        $(this).children('.sub').stop().slideDown();
    });
    $('.a_menu').mouseleave(function(){
        $(this).children('.sub').stop().slideUp();
    });
});
