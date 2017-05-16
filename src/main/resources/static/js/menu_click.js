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

    $("#event_profile1").css("background","#ffffff")
    $("#news_center1").css("background","#ffffff")
    $("#review1").css("background","#7aae1a")
    $("#com_login").css("background","#ffffff")
    $("#active_nev").css("background","#ffffff")
    if(bannerType == "VIDEO"){
        $(".click_menu2").css("background","url('../img/lvse.png')")
        $(".click_menu2").css("background-size","100% 100%")
    }
    if(bannerType == "PROJECT"){
        $(".click_menu3").css("background","url('../img/lvse.png')")
        $(".click_menu3").css("background-size","100% 100%")
    }
}
if(bannerType == "NATIONAL" || bannerType == "MAIN" || bannerType == "REPORT" || bannerType == "OTHER"){
    $("#event_profile1").css("background","#ffffff")
    $("#news_center1").css("background","#7aae1a")
    $("#review1").css("background","#ffffff")
    $("#com_login").css("background","#ffffff")
    $("#active_nev").css("background","#ffffff")
    if(bannerType == "NATIONAL"){
        $(".click_menu5").css("background","url('../img/lvse.png')")
        $(".click_menu5").css("background-size","100% 100%")
    }
    if(bannerType == "MAIN"){
        $(".click_menu6").css("background","url('../img/lvse.png')")
        $(".click_menu6").css("background-size","100% 100%")
    }
    if(bannerType == "REPORT"){
        $(".click_menu7").css("background","url('../img/lvse.png')")
        $(".click_menu7").css("background-size","100% 100%")
    }
    if(bannerType == "OTHER"){
        $(".click_menu8").css("background","url('../img/lvse.png')")
        $(".click_menu8").css("background-size","100% 100%")
    }
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
$("#com_nev").click(function () {
    $("#event_profile1 div").css("background","#ffffff")
    $("#news_center1 div").css("background","#ffffff")
    $("#review1 div").css("background","#ffffff")
    $("#com_login div").css("background","#ffffff")
    $("#active_nev div").css("background","#7aae1a")
})
$("#com_entire").click(function () {
    $("#event_profile1 div").css("background","#ffffff")
    $("#news_center1 div").css("background","#ffffff")
    $("#review1 div").css("background","#ffffff")
    $("#com_login div").css("background","#7aae1a")
    $("#active_nev div").css("background","#ffffff")
})
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

$("#register_btn").click(function () {
    window.location.href="/register";
});









