// JavaScript Document

//������ݳ�������Ϲ�����
/*$(function(){
    $('.left_info,.right').height($(window).height()-$('.header').height());
    $(window).resize(function(){
        $('.left_menu,.right').height($(window).height()-$('.header').height()-$('.footer').height());
    })
});*/

//left_menu

$(function(){
    $('.left_menu .show dd').show('slow');

    $('.left_menu dl').click(function(){
        $(this).children('dd').slideDown().end().siblings().children('dd').slideUp();
        $(this).children('dt').addClass('icon').end().siblings().children('dt').removeClass();
        //$(this).find('.menu_icon_cur').show().siblings('.menu_icon').hide().parent().siblings().find('.menu_icon_cur').hide().siblings('.menu_icon').show();
        $(this).find('.menu_icon_cur').show(0).siblings('img').hide(0)
            .parents('dl').siblings('dl').find('.menu_icon_cur').hide(0).siblings('img').show(0);

        $('.list .show').children('dt').css({background:'url(images/menu_arrow_down.jpg) no-repeat 200px 23px'});
    });
    $('.left_menu .show').click(function(){
        $(this).children('dt').css({background:'url(images/menu_arrow_up.jpg) no-repeat 200px 23px #3cb5ec;'});
    });
});