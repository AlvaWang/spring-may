/**
 * Created by Administrator on 2017/4/22.
 */
$(".click_menu1").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    $(".click_menu1").css("background-color","#7aae1a");
    $(".click_menu2").css("background-color","#12aaf0");
    $(".click_menu3").css("background-color","#12aaf0");
    $(".click_menu4").css("background-color","#12aaf0");
    window.location.href="pictures";
});
$(".click_menu2").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    $(".click_menu1").css("background-color","#12aaf0");
    $(".click_menu2").css("background-color","#7aae1a");
    $(".click_menu3").css("background-color","#12aaf0");
    $(".click_menu4").css("background-color","#12aaf0");
    window.location.href="threads?type=VIDEO";
});
$(".click_menu3").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    $(".click_menu1").css("background-color","#12aaf0");
    $(".click_menu2").css("background-color","#12aaf0");
    $(".click_menu3").css("background-color","#7aae1a");
    $(".click_menu4").css("background-color","#12aaf0");
    window.location.href="threads?type=PROJECT";
});
$(".click_menu4").click(function () {
    // $(".click_menu").style.backgroundColor="#7aae1a"
    $(".click_menu1").css("background-color","#12aaf0");
    $(".click_menu2").css("background-color","#12aaf0");
    $(".click_menu3").css("background-color","#12aaf0");
    $(".click_menu4").css("background-color","#7aae1a");
    window.location.href="avatars";
});