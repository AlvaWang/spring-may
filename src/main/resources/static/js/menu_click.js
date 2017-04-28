/**
 * Created by Administrator on 2017/4/22.
 */
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}
var bannerType = GetQueryString("type");

if(bannerType == "VIDEO" || bannerType == "PROJECT"){
    $("#review_banner") .show();
    $("#news_center_banner") .hide();
}

$(function () {
   $("#login_competition") .show();
    $("#login_work") .hide();

    $("#review_banner").show();
    $("#news_center_banner").hide

    $("#review_banner_post").show();
    $("#news_center_banner_post").hide
});
$("#event_profile").click(function () {
    window.location.href="/intro/info";
});
$("#news_center").click(function () {
    window.location.href="/threads?type=NATIONAL";
    $("#news_center_banner") .show();
    $("#review_banner") .hide();
});
$("#review").click(function () {
    window.location.href="/pictures";
    $("#review_banner") .show();
    $("#news_center_banner") .hide();
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

// $(".click_menu2").click(function () {
//
//     $("#review_banner") .show();
//     $("#news_center_banner") .hide();
// });
//
// $(".click_menu3").click(function () {
//
//     $("#review_banner") .show();
//     $("#news_center_banner") .hide();
// });
$("#register_btn").click(function () {
    window.location.href="/register";
});









