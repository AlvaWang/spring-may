/**
 * Created by Administrator on 2017/5/3.
 */
var comName = GetQueryString("comName")
$(function () {
    $("#unit_project_list").show();
    $("#team_project_list").hide();

    $("#unit_list").css("background","#0fc9f4");
    $("#team_list").css("background","#67b4dc");

    getEntireList(comName,"unit");
})
$("#unit_list").click(function () {
    $("#unit_project_list").show();
    $("#team_project_list").hide();

    $("#unit_list").css("background","#0fc9f4");
    $("#team_list").css("background","#67b4dc");

    getEntireList(comName,"unit");
})

$("#team_list").click(function () {
    $("#team_project_list").show();
    $("#unit_project_list").hide();


    $("#unit_list").css("background","#67b4dc");
    $("#team_list").css("background","#0fc9f4");

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
            var et = 0;
            var eu = 0;
            if (result.data != null) {
                // alert(result.data.data.length)
                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){
                    if (type == "unit"){
                        if(resultData[i][1] == "UNIT"){
                            eu=eu+1;
                            $("#unit_project_list ul").empty();
                            getEntireProName_unit(resultData[i][0],eu)
                        }
                    }
                    if (type == "team"){
                        if(resultData[i][1] == "TEAM"){
                            et =et+1;
                            $("#team_project_list ul").empty();
                            getEntireProName_team(resultData[i][0],et);
                        }
                    }
                }
            }

        }
    });
}

var getEntireProName_unit = function (condition,e_u) {
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
                console.log(result.data.data)

                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){

                    var text = (e_u)+"."+resultData[i];

                    var html_ul = "<li id='unit_list_"+condition+"'>"+text+"</li>";//id是entireId
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

var getEntireProName_team = function (condition,e_t) {
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

                // alert(.length)
                console.log(result.data.data)
                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){
                    // alert(resultData[i]);
                    var text = (e_t)+"."+resultData[i];
                    var html_ul = "<li id='team_list_"+condition+"'>"+text+"</li>";
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

$("#add_project").click(function () {
    window.location.href="/entry?comName="+comName;
})
$("#turn_competition").click(function () {
    window.location.href="/success?comName="+comName;
});