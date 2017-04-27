/**
 * Created by Administrator on 2017/4/22.
 */

    $("#register_btn").click(function () {
        var comAccName = $("#acc_name").val()
        var accPwd = $("#acc_pwd").val();
        var accPwd_again = $("#acc_again_pwd").val();
        var comAccEmail = $("#acc_email").val();
        var comAccType = $("#acc_type").val();
        var comAccPwd;
        if (accPwd = accPwd_again) {
            comAccPwd = accPwd;
            var condition = {
                comAccName: comAccName,
                comAccPwd: comAccPwd,
                comAccEmail: comAccEmail,
                comAccType: comAccType
            }
            registerCondition(condition);
        }

    });
    var registerCondition = function (condition) {

        $.ajax({
            url: "/registerMethod",
            type: 'post',
            async: true,
            data: condition,
            dataType: 'json',
            error: function (obj, msg) {
                alert("服务器异常！")
            },
            success: function (result) {
                if (result != null) {
                    // alert(result);
                    window.location.href = "/registerState?id=" + result + "";
                    // comId = result;
                }

            }
        });
    }


