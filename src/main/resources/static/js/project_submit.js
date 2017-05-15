/**
 * Created by Administrator on 2017/5/3.
 */
var comName = GetQueryString("comName")
$(function () {
    $("#unit_project_list").show();
    $("#team_project_list").hide();
    getEntireList(comName,"unit");
})
$("#unit_list").click(function () {
    $("#unit_project_list").show();
    $("#team_project_list").hide();
    getEntireList(comName,"unit");
})

$("#team_list").click(function () {
    $("#team_project_list").show();
    $("#unit_project_list").hide();
    getEntireList(comName,"team");
})

var getEntireList = function (comName,type) {
    var condition_keep = {
        workState:"SUBMIT"
    };
    $.ajax({
        url: "/getEntireListByComName/"+comName,
        type: 'GET',
        async: true,
        data: condition_keep,
        dataType: 'json',
        error: function (obj, msg) {
            alert("查询失败！")
        },
        success: function (result) {
            if (result.data != null) {
                // alert(result.data.data.length)
                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){
                    if (type == "unit"){
                        getEntireProName_unit(resultData[i])
                    }
                    if (type == "team"){
                        getEntireProName_team(resultData[i]);
                    }
                }
            }

        }
    });
}

var getEntireProName_unit = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/getEntireProNameByEntireId/"+condition,
        type: 'GET',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("查询失败！")
        },
        success: function (result) {
            if (result.data != null) {
                // alert(result.data.data.length)
                $("#unit_project_list ul").empty();
                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){
                    // alert(resultData[i]);
                    var html_ul = "<li id='unit_list_"+condition+"'>"+resultData[i]+"</li>";//id是entireId
                    // alert(html_ul);
                    $("#unit_project_list ul").append(html_ul);
                    $("#unit_list_"+condition).bind('click',function () {
                        window.location.href = "/unitTable?entireId=" + condition+"&type="+"SUBMIT";
                    })
                }
            }

        }
    });
}

var getEntireProName_team = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/getEntireProNameByEntireId_team/"+condition,
        type: 'GET',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("查询失败！")
        },
        success: function (result) {
            if (result.data != null) {
                $("#team_project_list ul").empty();
                // alert(result.data.data.length)
                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){
                    // alert(resultData[i]);
                    var html_ul = "<li id='team_list_"+condition+"'>"+resultData[i]+"</li>";
                    // alert(html_ul);
                    $("#team_project_list ul").append(html_ul);

                    $("#team_list_"+condition).bind('click',function () {
                        window.location.href = "/teamTable?entireId=" + condition +"&type="+"SUBMIT";
                    })
                }
            }
        }
    });
}