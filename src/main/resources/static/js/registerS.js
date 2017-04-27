/**
 * Created by Administrator on 2017/4/27.
 */

function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

var comId = GetQueryString("id");
// alert(comId);

$("#agree_div").click(function () {
    // alert("a");
    var condition = {
        comState: '1'
    }
    registerStateCondition(condition)
});

var registerStateCondition = function (condition) {
    $.ajax({
        url: "/updateState/"+comId,
        type: 'PUT',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                // alert(result);
                window.location.href = "/registerSuccess?id=" + comId + "";
                // comId = result;
            }

        }
    });
}
$("#cancel_div").click(function () {

});