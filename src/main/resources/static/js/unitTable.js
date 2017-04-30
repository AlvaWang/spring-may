/**
 * Created by Administrator on 2017/4/30.
 */

$(function () {
    $("#first_table").show();
    $("#second_table").hide();
    $("#third_table").hide();

    $(".streamer_jbxx").show();
    $(".streamer_hxtd").hide();
    $(".streamer_syjhs").hide();

    $("#jbxx_conservation").show();
    $("#hxtd_conservation").hide();
    $("#syjhs_conservation").hide();

});
$("#first_btn").click(function () {
    $("#first_table").show();
    $("#second_table").hide();
    $("#third_table").hide();

    $(".streamer_jbxx").show();
    $(".streamer_hxtd").hide();
    $(".streamer_syjhs").hide();

    $("#jbxx_conservation").show();
    $("#hxtd_conservation").hide();
    $("#syjhs_conservation").hide();
})

$("#second_btn").click(function () {
    $("#second_table").show();
    $("#first_table").hide();
    $("#third_table").hide();

    $(".streamer_hxtd").show();
    $(".streamer_jbxx").hide();
    $(".streamer_syjhs").hide();

    $("#hxtd_conservation").show();
    $("#jbxx_conservation").hide();
    $("#syjhs_conservation").hide();
})
$("#third_btn").click(function () {
    $("#third_table").show();
    $("#second_table").hide();
    $("#first_table").hide();

    $(".streamer_syjhs").show();
    $(".streamer_jbxx").hide();
    $(".streamer_hxtd").hide();

    $("#syjhs_conservation").show();
    $("#jbxx_conservation").hide();
    $("#hxtd_conservation").hide();
})
