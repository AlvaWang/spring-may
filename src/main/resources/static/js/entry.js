/**
 * Created by Administrator on 2017/4/29.
 */
var comName = GetQueryString("comName");
$("#entry_unit").click(function () {
    var comName = GetQueryString("comName");
    // alert(comName);
    var entryType = "UNIT"
    var workState = "KEEP"
    var state = "1"

    var condition = {
        comName:comName,
        entryType:entryType,
        workState:workState,
        state:state
    }
    addEntireUnit(condition)
});
var addEntireUnit = function (condition) {
    // alert(condition)
    $.ajax({
        url: "/entire/addEntire",
        type: 'POST',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                // alert(result);
                window.location.href = "/unitCreate?entireId=" + result+"&comName="+comName;
                // comId = result;
            }

        }
    });
}


$("#entry_team").click(function () {
    var comName = GetQueryString("comName");
    // alert(comName);
    var entryType = "TEAM"
    var workState = "KEEP"
    var state = "1"

    var condition = {
        comName:comName,
        entryType:entryType,
        workState:workState,
        state:state
    }
    addEntireTeam(condition)
});
var addEntireTeam = function (condition) {
    // alert(condition)
    $.ajax({
        url: "/entire/addEntire",
        type: 'POST',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                // alert(result);
                // location.href = 'a.asp?d_id=' + d + '&d_name=' + name;
                window.location.href = "/teamCreate?entireId=" + result+"&comName="+comName;
                // comId = result;
            }

        }
    });
}

