/**
 * Created by Administrator on 2017/5/2.
 */
var comTime = function (comTime) {
    if(comTime == null || comTime == ""){
        return null;
    }else {
        // var strTime="2011-04-16"; //字符串日期格式
        var date= new Date(Date.parse(comTime.replace(/-/g,   "/"))); //转换成Data();

        return date;
    }
}