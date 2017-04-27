/**
 * Created by Administrator on 2017/4/22.
 */
$(function () {
   $("#login_competition") .show();
    $("#login_work") .hide();
});

$(".click_menu1").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    //设置背景图片
    $(".click_menu1").css("background-color","#7aae1a");

    $(".click_menu2").css("background-color","#12aaf0");
    $(".click_menu3").css("background-color","#12aaf0");
    $(".click_menu4").css("background-color","#12aaf0");
    window.location.href="/pictures";
});

$(".click_menu2").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    $(".click_menu1").css("background-color","#12aaf0");
    $(".click_menu2").css("background-color","#7aae1a");
    $(".click_menu3").css("background-color","#12aaf0");
    $(".click_menu4").css("background-color","#12aaf0");
    window.location.href="/threads?type=VIDEO";
});
$(".click_menu3").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    $(".click_menu1").css("background-color","#12aaf0");
    $(".click_menu2").css("background-color","#12aaf0");
    $(".click_menu3").css("background-color","#7aae1a");
    $(".click_menu4").css("background-color","#12aaf0");
    window.location.href="/threads?type=PROJECT";
});
$(".click_menu4").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    $(".click_menu1").css("background-color","#12aaf0");
    $(".click_menu2").css("background-color","#12aaf0");
    $(".click_menu3").css("background-color","#12aaf0");
    $(".click_menu4").css("background-color","#7aae1a");
    window.location.href="/avatars";
});
$("#event_profile").click(function () {
    window.location.href="/intro/info";
});
$("#news_center").click(function () {
    window.location.href="/threads?type=NATIONAL";
});
$("#review").click(function () {
    window.location.href="/pictures";
});
$("#click_menu_index1").click(function () {
    $("#click_menu_index1").css("background-image","url(../img/lvse.png)")
})

$("#login_competition_btn").click(function () {
    $("#login_competition") .show();
    $("#login_work") .hide();
});

$("#login_work_btn").click(function () {
    $("#login_work") .show();
    $("#login_competition") .hide();
});