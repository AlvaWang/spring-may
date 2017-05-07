/**
 * Created by Administrator on 2017/4/22.
 */

$('#hidden_frame').load(function(){
    var text=$(this).contents().find("body").text();
    // 根据后台返回值处理结果

    var result=$.parseJSON(text);
    // alert(result.success);
    console.log(result);
    if(result != null) {
        if (result.success == false){
            if (result.data == "acc_null"){
                alert("注册信息未填写完整，请补充！");
            }
            if(result.data == "acc_exist"){
                alert("该账号已存在，请更换用户名！");
            }
            if(result.data == "acc_found_fail"){
                alert("用户创建失败！")
            }
            if(result.data == "acc_pwd_notSame"){
                alert("两次密码不一致，请确认")
            }
        }else {
            window.location.href = "/registerSuccess?id=" + result.data + "";
        }
    }
});

$(".suc_login").click(function () {
    window.location.href = "/login";
});
