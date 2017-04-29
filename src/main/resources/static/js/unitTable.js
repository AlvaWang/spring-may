/**
 * Created by Administrator on 2017/4/30.
 */

$(function () {
    $("#first_table").show();
    $("#second_table").hide();
    $("#third_table").hide();
});
$("#first_btn").click(function () {
    $("#first_table").show();
    $("#second_table").hide();
    $("#third_table").hide();
})

$("#second_btn").click(function () {
    $("#second_table").show();
    $("#first_table").hide();
    $("#third_table").hide();
})
$("#third_btn").click(function () {
    $("#third_table").show();
    $("#second_table").hide();
    $("#first_table").hide();
})
