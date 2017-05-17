/**
 * Created by Administrator on 2017/4/22.
 */

$('#loginAction_frame').load(function(){
    var text=$(this).contents().find("body").text();
    // 根据后台返回值处理结果

    var result=$.parseJSON(text);
    // alert(result.success);
    console.log(result);
    if(result != null) {
        if (result.success == false){
            if (result.data == "acc_null"){
                alert("登录信息不能为空");
            }
            if(result.data == "acc_login_null"){
                alert("登录名或密码错误！");
            }
        }else {
            window.location.href = "/success.html?comName=" + result.data + "";
        }
    }
});

$(".suc_login").click(function () {
    window.location.href = "/login";
});
$('#loginActionWork_frame').load(function(){
    var text=$(this).contents().find("body").text();
    // 根据后台返回值处理结果

    var result=$.parseJSON(text);
    // alert(result.success);
    console.log(result);
    if(result != null) {
        if (result.success == false){
            if (result.data == "accWork_null"){
                alert("登录信息不能为空");
            }
            if(result.data == "accWork_login_null"){
                alert("登录名或密码错误！");
            }
        }else {
            window.location.href = "/success.html?comName=" + result.data + "";
        }
    }
});