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
    $("#unit_project_list ul").empty();

    $("#unit_project_list").show();
    $("#team_project_list").hide();
    $("#unit_list").css("background","#0fc9f4");
    $("#team_list").css("background","#67b4dc");

    getEntireList(comName,"unit");
})

$("#team_list").click(function () {
    $("#team_project_list ul").empty();

    $("#team_project_list").show();
    $("#unit_project_list").hide();
    $("#unit_list").css("background","#67b4dc");
    $("#team_list").css("background","#0fc9f4");
    getEntireList(comName,"team");
})

var getEntireList = function (comName,type) {
    var condition_keep = {
        workState:"KEEP"
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
                var et = 0;
                var eu = 0;

                // alert(result.data.data.length)
                console.log(result.data.data)
                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){
                    if (type == "unit"){
                        if(resultData[i][1] == "UNIT"){
                            eu = eu+1;
                            getUnitEssentialList(resultData[i][0],eu)
                        }
                        // getEntireProName_unit(resultData[i])
                    }
                    if (type == "team"){

                        if(resultData[i][1] == "TEAM"){
                            et = et+1
                            getTeamEssentialList(resultData[i][0],et);
                        }

                    }
                }
            }

        }
    });
}

var getTeamEssentialList = function (entireId,et) {

    $.ajax({
        url: "/getTeamEssentialListByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result);
            if (result != null) {

                // getEntireProName_team(resultData[i]);
                var text = et+"."+result.teProName+"项目";
                var html_ul = "<li id='team_list_"+entireId+"'>"+text+"</li>";
                // alert(html_ul);
                $("#team_project_list ul").append(html_ul);

                $("#team_list_"+entireId).bind('click',function () {
                    window.location.href = "/teamTable?entireId=" + entireId +"&type="+"KEEP"+"&comName="+comName;
                })

            }

        }
    });
}
var getUnitEssentialList = function (entireId,eu) {
    $.ajax({
        url: "/getUnitEssentialListByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result);
            if (result != null) {

                var text = eu+"."+result.ueProjectName+"项目";
                var html_ul = "<li id='unit_list_"+entireId+"'>"+text+"</li>";//id是entireId
                // alert(html_ul);
                $("#unit_project_list ul").append(html_ul);
                // alert(entireId);
                $("#unit_list_"+entireId).bind('click',function () {
                    window.location.href = "/unitTable?entireId=" + entireId+"&type="+"KEEP"+"&comName="+comName;
                })
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