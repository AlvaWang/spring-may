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
var  add0 = function(m){
    return m<10?'0'+m:m
}
var stampToStandard = function(resultDate){
    var time = new Date(resultDate);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();

    var date = y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);

    return date;

}