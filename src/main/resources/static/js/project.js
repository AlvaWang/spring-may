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
            var eu = 0;
            var et = 0;
            if (result.data != null) {
                // alert(result.data.data.length)
                console.log(result.data.data)
                var resultData = result.data.data;
                for(var i=0;i<resultData.length;i++){
                    if (type == "unit"){
                        $("#unit_project_list ul").empty();
                        if(resultData[i][1] == "UNIT"){
                            eu = eu+1
                            var text = eu+"."+"作品Id为"+resultData[i][0]+"号作品";
                            var html_ul = "<li id='unit_list_"+resultData[i][0]+"'>"+text+"</li>";//id是entireId
                            // alert(html_ul);
                            $("#unit_project_list ul").append(html_ul);

                            var entireId =  resultData[i][0];
                            // alert(entireId);
                            $("#unit_list_"+resultData[i][0]).bind('click',function () {
                                window.location.href = "/unitTable?entireId=" + entireId+"&type="+"KEEP";
                            })
                        }
                        // getEntireProName_unit(resultData[i])
                    }
                    if (type == "team"){
                        $("#team_project_list ul").empty();
                        if(resultData[i][1] == "TEAM"){
                            et = et+1
                            // getEntireProName_team(resultData[i]);
                            var text = et+"."+"作品Id为"+resultData[i][0]+"号作品";
                            var html_ul = "<li id='team_list_"+resultData[i][0]+"'>"+text+"</li>";
                            // alert(html_ul);
                            $("#team_project_list ul").append(html_ul);
                            var entireId =  resultData[i][0]
                            $("#team_list_"+resultData[i][0]).bind('click',function () {
                                window.location.href = "/teamTable?entireId=" + entireId +"&type="+"KEEP";
                            })
                        }

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
                    var text = (i+1)+"."+resultData[i];
                    var html_ul = "<li id='unit_list_"+condition+"'>"+text+"</li>";//id是entireId
                    // alert(html_ul);
                    $("#unit_project_list ul").append(html_ul);

                    $("#unit_list_"+condition).bind('click',function () {
                        window.location.href = "/unitTable?entireId=" + condition+"&type="+"KEEP";
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
                    var text = (i+1)+"."+resultData[i];
                    var html_ul = "<li id='team_list_"+condition+"'>"+text+"</li>";
                    // alert(html_ul);
                    $("#team_project_list ul").append(html_ul);

                    $("#team_list_"+condition).bind('click',function () {
                        window.location.href = "/teamTable?entireId=" + condition +"&type="+"KEEP";
                    })
                }
            }
        }
    });
}

$("#add_project").click(function () {
    window.location.href="/entry?comName="+comName;
})