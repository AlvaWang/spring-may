/**
 * Created by Administrator on 2017/4/30.
 */

$(function () {
    $("#first_table").show();
    $("#first_btn").css("background","#8fc320");
    $("#first_btn").find("p").css("color","#ffffff");

    $("#second_table").hide();
    $("#third_table").hide();
    $("#four_table").hide();

    $(".streamer_jbxx_team").show();
    $(".streamer_hxtd_team").hide();
    $(".streamer_syjhs_team").hide();
    $(".streamer_kjjr_team").hide();


    $("#patent_table").find("tr,td,input,div,button,textarea,select").attr("disabled", "disabled");
    $("#patent_table").find("tr,td,input,div,button,textarea,select").css("background","#dbdbdb")
    $("#patent_table").css("background","#dbdbdb")

    $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").attr("disabled", "disabled");
    $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").css("background","#dbdbdb")

    $(".pettyMoney,.pettyMoney input").attr("disabled", "disabled");
    $(".pettyMoney,.pettyMoney input").css("background","#dbdbdb")

    $("#importTechnical,#technical_import_range").attr("disabled", "disabled");
    $("#importTechnical,#technical_import_range").css("background","#dbdbdb")
    $("#technical_import_range").find("tr, td ,input").attr("disabled", "disabled");
    $("#technical_import_range").find("tr ,td ,input").css("background","#dbdbdb")

    $(".transferTechnical,.transferTechnical input").attr("disabled", "disabled");
    $(".transferTechnical,.transferTechnical input").css("background","#dbdbdb")

    $("#intermediary,#intermediary_consult_type").attr("disabled", "disabled");
    $("#intermediary,#intermediary_consult_type").css("background","#dbdbdb")
    $("#intermediary_consult_type").find("tr td input").attr("disabled", "disabled");
    $("#intermediary_consult_type").find("tr td input").css("background","#dbdbdb")
    $("#intermediary").find("tr td").css("background","#dbdbdb")

    $("#otherDesc,#otherDesc input").attr("disabled", "disabled");
    $("#otherDesc,#otherDesc input").css("background","#dbdbdb")

    $("#reason1,#reason1 td,#reason1 td input").removeAttr("disabled");
    $("#reason1,#reason1 td,#reason1 td input").css("background","#ffffff");

    $(".reason3,.reason3 td,.reason3 td input,.reason3 div").attr("disabled", "disabled");
    $(".reason3,.reason3 td,.reason3 td input,.reason3 div").css("background", "#dbdbdb");

    $("#reason2,#reason2 td,#reason2 td input").removeAttr("disabled");
    $("#reason2,#reason2 td,#reason2 td input").css("background","#ffffff");
});
$("#first_btn").click(function () {
    $("#first_table").show();
    $(this).css("background","#8fc320");
    $(this).find("p").css("color","#ffffff");
    $("#second_btn").css("background","#ffffff");
    $("#second_btn").find("p").css("color","#a8daf3");
    $("#third_btn").css("background","#ffffff");
    $("#third_btn").find("p").css("color","#a8daf3");
    $("#four_btn").css("background","#ffffff");
    $("#four_btn").find("p").css("color","#a8daf3");

    $("#second_table").hide();
    $("#third_table").hide();
    $("#four_table").hide();

    $(".streamer_jbxx_team").show();
    $(".streamer_hxtd_team").hide();
    $(".streamer_syjhs_team").hide();
    $(".streamer_kjjr_team").hide();

})

$("#second_btn").click(function () {
    $(this).css("background","#8fc320");
    $(this).find("p").css("color","#ffffff");
    $("#first_btn").css("background","#ffffff");
    $("#first_btn").find("p").css("color","#a8daf3");
    $("#third_btn").css("background","#ffffff");
    $("#third_btn").find("p").css("color","#a8daf3");
    $("#four_btn").css("background","#ffffff");
    $("#four_btn").find("p").css("color","#a8daf3");

    $("#second_table").show();
    $("#first_table").hide();
    $("#third_table").hide();
    $("#four_table").hide();

    $(".streamer_hxtd_team").show();
    $(".streamer_jbxx_team").hide();
    $(".streamer_kjjr_team").hide();
    $(".streamer_syjhs_team").hide();

})
$("#third_btn").click(function () {
    $(this).css("background","#8fc320");
    $(this).find("p").css("color","#ffffff");
    $("#first_btn").css("background","#ffffff");
    $("#first_btn").find("p").css("color","#a8daf3");
    $("#second_btn").css("background","#ffffff");
    $("#second_btn").find("p").css("color","#a8daf3");
    $("#four_btn").css("background","#ffffff");
    $("#four_btn").find("p").css("color","#a8daf3");

    $("#third_table").show();
    $("#second_table").hide();
    $("#first_table").hide();
    $("#four_table").hide();

    $(".streamer_syjhs_team").show();
    $(".streamer_jbxx_team").hide();
    $(".streamer_hxtd_team").hide();
    $(".streamer_kjjr_team").hide();

})
$("#four_btn").click(function () {
    $(this).css("background","#8fc320");
    $(this).find("p").css("color","#ffffff");
    $("#first_btn").css("background","#ffffff");
    $("#first_btn").find("p").css("color","#a8daf3");
    $("#second_btn").css("background","#ffffff");
    $("#second_btn").find("p").css("color","#a8daf3");
    $("#third_btn").css("background","#ffffff");
    $("#third_btn").find("p").css("color","#a8daf3");

    $("#four_table").show();
    $("#second_table").hide();
    $("#first_table").hide();
    $("#third_table").hide();

    $(".streamer_kjjr_team").show();
    $(".streamer_jbxx_team").hide();
    $(".streamer_hxtd_team").hide();
    $(".streamer_syjhs_team").hide();

})


var change_patent_table = function () {
    var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
    if(patent_choose == true){
        $("#patent_table").find("tr,td,input,div,button,textarea,select").removeAttr("disabled");
        $("#patent_table").find("tr,td").css("background","#ecf7fd");
        $("#patent_table").find(".img_tr td,div").css("background","#a8daf3");
        $("#patent_table").find("input,textarea,select").css("background","#ffffff");
        $("#patent_table").css("background","#ecf7fd")
    }else {
        $("#patent_table").find("tr,td,input,div,button,textarea,select").attr("disabled", "disabled");
        $("#patent_table").find("tr,td,input,div,button,textarea,select").css("background","#dbdbdb")
        $("#patent_table").css("background","#dbdbdb")
    }
};

var change_institute_name = function () {
    $("#institute").find(".instituteName,.instituteName input").removeAttr("disabled");
    $("#institute").find(".instituteName input").css("background","#ffffff");
    $("#institute").find(".instituteName").css("background","#ecf7fd");

}
var change_instituteName = function () {
    $("#institute").find(".instituteName,.instituteName input").attr("disabled", "disabled");
    $("#institute").find(".instituteName,.instituteName input").css("background","#dbdbdb");
}

var change_picture_yes = function () {
    $("#picture").find(".picture_upload,.picture_upload input,.picture_upload div").removeAttr("disabled");
    $("#picture").find(".picture_upload input,.picture_upload div").css("background","#ffffff");
    $("#picture").find(".picture_upload").css("background","#ecf7fd");
}
var change_picture_No = function () {
    $("#picture").find(".picture_upload,.picture_upload input,.picture_upload div").attr("disabled", "disabled");
    $("#picture").find(".picture_upload,.picture_upload input,.picture_upload div").css("background","#dbdbdb");
}

var change_litigation1_yes = function () {
   $("#reason1,#reason1 td,#reason1 td input").removeAttr("disabled");
    $("#reason1,#reason1 td,#reason1 td input").css("background","#ffffff");
}
var change_litigation1_No = function () {
    $("#reason1,#reason1 td,#reason1 td input").attr("disabled", "disabled");
    $("#reason1,#reason1 td,#reason1 td input").css("background","#dbdbdb");
}

var change_litigation2_yes = function () {
    $("#reason2,#reason2 td,#reason2 td input").removeAttr("disabled");
    $("#reason2,#reason2 td,#reason2 td input").css("background","#ffffff");
}
var change_litigation2_No = function () {
    $("#reason2,#reason2 td,#reason2 td input").attr("disabled", "disabled");
    $("#reason2,#reason2 td,#reason2 td input").css("background", "#dbdbdb");
}



var df_equity_yes = function () {
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input").removeAttr("disabled");
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input").css("background","#ffffff");
}
var df_equity_no = function () {
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input").attr("disabled", "disabled");
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input").css("background","#dbdbdb");
}

var df_debt_yes = function () {
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input").removeAttr("disabled");
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input").css("background","#ffffff");
}
var df_debt_no = function () {
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input").attr("disabled", "disabled");
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input").css("background","#dbdbdb");
}

var change_crowd = function () {
    var change_crowd=$("#choose_crowd input[type='checkbox']").is(':checked');
    // alert(change_crowd)
    if(change_crowd == true){
        $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").removeAttr("disabled");
        $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr,#crows_fund_type td").css("background","#ecf7fd")
        $("#crows_fund_type tr td input").css("background","#fff")
    }else {
        $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").attr("disabled", "disabled");
        $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").css("background","#dbdbdb")
    }
};
var change_petty = function () {
    var change_petty=$("#change_petty input[type='checkbox']").is(':checked');
    // alert(change_crowd)
    if(change_petty == true){
        $(".pettyMoney,.pettyMoney input").removeAttr("disabled");
        $(".pettyMoney input").css("background","#ffffff")
        $(".pettyMoney").css("background","#ecf7fd")
    }else {
        $(".pettyMoney,.pettyMoney input").attr("disabled", "disabled");
        $(".pettyMoney,.pettyMoney input").css("background","#dbdbdb")
    }
};

var change_import_technical = function () {
    var change_import_technical=$("#change_import_technical input[type='checkbox']").is(':checked');
    // alert(change_crowd)
    if(change_import_technical == true){
        $("#importTechnical,#technical_import_range").removeAttr("disabled");
        $("#technical_import_range").find("tr td input").removeAttr("disabled");
        $("#technical_import_range").find("tr td input").css("background","#ffffff")
        $("#importTechnical,#technical_import_range,#technical_import_international,#technical_import_internal").css("background","#ecf7fd")
        $("#technical_import_range").find("tr,td").css("background","#ecf7fd")
    }else {
        $("#importTechnical,#technical_import_range").attr("disabled", "disabled");
        $("#importTechnical,#technical_import_range").css("background","#dbdbdb")
        $("#technical_import_range").find("tr, td ,input").attr("disabled", "disabled");
        $("#technical_import_range").find("tr ,td ,input").css("background","#dbdbdb")
    }
};

var change_transfer = function () {
    var change_transfer=$("#change_transfer input[type='checkbox']").is(':checked');
    // alert(change_crowd)
    if(change_transfer == true){
        $(".transferTechnical,.transferTechnical input").removeAttr("disabled");
        $(".transferTechnical,.transferTechnical input").css("background","#ffffff")
    }else {
        $(".transferTechnical,.transferTechnical input").attr("disabled", "disabled");
        $(".transferTechnical,.transferTechnical input").css("background","#dbdbdb")
    }
};

var change_intermediary = function () {
    var change_intermediary=$("#change_intermediary input[type='checkbox']").is(':checked');
    // alert(change_crowd)
    if(change_intermediary == true){
        $("#intermediary,#intermediary_consult_type").removeAttr("disabled");
        $("#intermediary_consult_type").find("tr td input").removeAttr("disabled");
        $("#intermediary_consult_type").find("tr td input").css("background","#ffffff")
        $("#intermediary,#intermediary_consult_type").css("background","#ffffff")
        $("#intermediary").find("tr td").css("background","#ecf7fd")
    }else {
        $("#intermediary,#intermediary_consult_type").attr("disabled", "disabled");
        $("#intermediary,#intermediary_consult_type").css("background","#dbdbdb")
        $("#intermediary_consult_type").find("tr td input").attr("disabled", "disabled");
        $("#intermediary_consult_type").find("tr td input").css("background","#dbdbdb")
        $("#intermediary").find("tr td").css("background","#dbdbdb")
    }
};

var change_other = function () {
    var change_other=$("#change_other input[type='checkbox']").is(':checked');
    // alert(change_crowd)
    if(change_other == true){
        $("#otherDesc,#otherDesc input").removeAttr("disabled");
        $("#otherDesc,#otherDesc input").css("background","#ffffff")
    }else {
        $("#otherDesc,#otherDesc input").attr("disabled", "disabled");
        $("#otherDesc,#otherDesc input").css("background","#dbdbdb")
    }
};

var entireId = GetQueryString("entireId");
// alert(entireId);

/***********************************************************************************************************************
 * 基本信息第一步
 */


$("#jbxx_conservation_team").bind('click',function () {
    // alert(entireId)
    if($("#team_name").val() == "" || $("#te_pro_name").val() == "" ||
    $("#te_compatition_goal input:checked").val() == "" ||   $("#te_industry_field input:checked").val() == ""
    ||  $("#te_pro_stage input:checked").val() == "" || $("#admin_area_province").val() == "" ||
        $("#admin_area_city").val() == "" || $("#team_year").val() == ""
    || $("#team_month").val() == "" || $("#team_day").val() == "" ||
        $("#company_year").val() == ""
        || $("#company_month").val() == "" || $("#company_day").val() == "" ||
        $("#te_address").val() == "" || $("#te_postalcode").val() == "" ||
        $("#post_code input:checkbox:checked").val() == "" || $("#technical_sources input:checkbox:checked") == "" ||
        $("#te_pro_outline").val() == "" ||  $("#te_key_word").val() == ""){
        alert("请将基本信息填写完整！")
    }else{

        if($("#res_name").val() =="" || $("#res_job").val() =="" || $("#res_document_type").val() =="" ||
            $("#document_num").val() =="" || $("#res_office_tel").val() =="" || $("#res_mobile_tel").val() =="" || $("#res_email").val() ==""){
            alert("请将团队负责人信息填写完整")
        }else {
            var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
            // alert(patent_choose);
            if(patent_choose == true){
                for(var i=1;i<=patent;i++){

                    var patentNum = $("#patent_num_"+i).val();
                    var patentType =$("#patent_type_"+i).val();
                    // alert(patentType);
                    var patentName = $("#patent_name_"+i).val();
                    var patentDate = $("#patent_date_"+i).val();
                    var patentVerification = $("#patent_verification_"+i).val();
                    if(patentNum == "" || patentType == "" || patentNum ==""
                        || patentDate == "" || patentVerification ==""
                    ){
                        alert("请将专利相关信息补充完整")
                    }else {
                        var condition = {
                            patentId:patentNum
                        }
                        var data = {
                            ueId:null,
                            patentId:patentNum,
                            entireId:entireId,
                            teId:null,
                            patentName:patentName,
                            patentType:patentType,
                            patentDate:comTime(patentDate),
                            patentVerification:patentVerification
                        }
                        // addPatentList(data);
                        getPatentListByPatentId(condition,data,patentNum,i);
                        // for(var j=1;j<=patent;j++){
                            // if(i=patent){
                                getTeamEssentialByEntireId(entireId,i);
                                getPersonByEntireId(entireId,i);
                                // return true;
                            // }
                        $(this).unbind('click');
                        $(this).css("background","#dbdbdb");
                        $(this).find("p").html("已保存");
                        // }

                    }

                }

            }else {
                var teamEssencialData = conditionEssential();
                // alert(data);
                addTeamEssential(teamEssencialData);

                var person_data = conditionPerson();
                // alert(data);
                addPerson(person_data);
                $(this).unbind('click');
                $(this).css("background","#dbdbdb");
                $(this).find("p").html("已保存");
            }
        }


    }
});

var getTeamEssentialByEntireId = function (condition,i) {

    $.ajax({
        url: "/getTeamEssentialByEntireId/"+condition,
        type: 'get',
        async: true,
        data: condition,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            // alert(result);
            if (result != null && result>0) {
                // alert(result+"teamEssensial");
                if(i == patent){
                    var teamEssencialData = conditionEssential();
                    // alert(data);
                    addTeamEssential(teamEssencialData);
                }
            }else {
                if(i == patent){
                    var teamEssencialData = conditionEssential();
                    // alert(data);
                    addTeamEssential(teamEssencialData);
                }
            }

        }
    });

}
var getPersonByEntireId = function (condition,i) {

    $.ajax({
        url: "/getPersonByEntireId/"+condition,
        type: 'get',
        async: true,
        data: condition,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null && result>0) {
                alert(result)
                if(i == patent){
                    var person_data = conditionPerson();
                    // alert(data);
                    addPerson(person_data);
                }
            }else {
                if(i == patent){
                    var person_data = conditionPerson();
                    // alert(data);
                    addPerson(person_data);
                }

            }

        }
    });

}
var conditionEssential=function () {
    /**
     * 增加基本信息
     * @type {any}
     */
    var team_name = $("#team_name").val();
    var te_pro_name = $("#te_pro_name").val();
    var Goal = $("#te_compatition_goal input:radio:checked").val();
    var te_pro_stage = $("#te_pro_stage input:radio:checked").val();
    var te_industry_field = $("#te_industry_field input:radio:checked").val();
    var admin_area_province = $("#admin_area_province").val();
    var admin_area_city = $("#admin_area_city").val();
    var admin_area = admin_area_province+"省"+admin_area_city+"市";
    var team_year = $("#team_year").val();
    if ($("#team_month").val()<10){
        var team_month = "0"+$("#team_month").val();
    }else {
        var team_month = $("#team_month").val();
    }
    if ($("#team_day").val()<10){
        var team_day = "0"+$("#team_day").val();
    }else {
        var team_day = $("#team_day").val();
    }
    var team_fund_time = team_year+"-"+team_month+"-"+team_day;
    // alert(team_fund_time);
    var company_year = $("#company_year").val();
    if ($("#company_month").val()<10){
        var company_month = "0"+$("#company_month").val();
    }else {
        var company_month = $("#company_month").val();
    }
    if ($("#company_day").val()<10){
        var company_day = "0"+$("#company_day").val();
    }else {
        var company_day = $("#company_day").val();
    }
    var company_fund_time = company_year+"-"+company_month+"-"+company_day;


    var te_address = $("#te_address").val();
    var te_postalcode = $("#te_postalcode").val();
    var Type = $("#post_code").val();
    var technical_sources = $("#technical_sources input:checked").val();
    var te_pro_outline = $("#te_pro_outline").val();
    var te_key_word = $("#te_key_word").val();


    if(Goal == "其他"){
        var te_compatition_goal = $("#teGoal").val();
        if(Type == "其他"){
            var te_power_type = $("#powerType").val();
            var Essential_data = {
                entireId:entireId,
                teamName:team_name,
                teProName:te_pro_name,
                teCompatitionGoal:te_compatition_goal,
                teIndustryFild:te_industry_field,
                teProStage:te_pro_stage,
                teAdminStrativeArea:admin_area,
                teamFundTime:comTime(team_fund_time),
                companyFundTime:comTime(company_fund_time),
                teAddress:te_address,
                tePostalcode:te_postalcode,
                tePowerType:te_power_type,
                teTechnicalSource:technical_sources,
                teProOutline:te_pro_outline,
                teKeyWord:te_key_word
            }
            return Essential_data;
        }else {
            var Essential_data = {
                entireId:entireId,
                teamName:team_name,
                teProName:te_pro_name,
                teCompatitionGoal:te_compatition_goal,
                teIndustryFild:te_industry_field,
                teProStage:te_pro_stage,
                teAdminStrativeArea:admin_area,
                teamFundTime:comTime(team_fund_time),
                companyFundTime:comTime(company_fund_time),
                teAddress:te_address,
                tePostalcode:te_postalcode,
                tePowerType:Type,
                teTechnicalSource:technical_sources,
                teProOutline:te_pro_outline,
                teKeyWord:te_key_word
            }
            return Essential_data;
        }
    }else {
        if(Type == "其他"){
            var te_power_type = $("#powerType").val();
            var Essential_data = {
                entireId:entireId,
                teamName:team_name,
                teProName:te_pro_name,
                teCompatitionGoal:Goal,
                teIndustryFild:te_industry_field,
                teProStage:te_pro_stage,
                teAdminStrativeArea:admin_area,
                teamFundTime:comTime(team_fund_time),
                companyFundTime:comTime(company_fund_time),
                teAddress:te_address,
                tePostalcode:te_postalcode,
                tePowerType:te_power_type,
                teTechnicalSource:technical_sources,
                teProOutline:te_pro_outline,
                teKeyWord:te_key_word
            }
            return Essential_data;
        }else {
            var Essential_data = {
                entireId:entireId,
                teamName:team_name,
                teProName:te_pro_name,
                teCompatitionGoal:Goal,
                teIndustryFild:te_industry_field,
                teProStage:te_pro_stage,
                teAdminStrativeArea:admin_area,
                teamFundTime:comTime(team_fund_time),
                companyFundTime:comTime(company_fund_time),
                teAddress:te_address,
                tePostalcode:te_postalcode,
                tePowerType:Type,
                teTechnicalSource:technical_sources,
                teProOutline:te_pro_outline,
                teKeyWord:te_key_word
            }
            return Essential_data;
        }
    }
};

/**
 * 创建基本信息
 * @param condition
 */
var addTeamEssential = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/addTeamEssential",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建基本信息失败！")
        },
        success: function (result) {
            if (result != null) {
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });

}


var conditionPerson = function () {
    var res_name = $("#res_name").val();
    var res_job = $("#res_job").val();
    var res_document_type = $("#res_document_type").val();
    var document_num = $("#document_num").val();
    var res_office_tel = $("#res_office_tel").val();
    var res_mobile_tel = $("#res_mobile_tel").val();
    var res_email = $("#res_email").val();
    var contacts_data = {
        entireId:entireId,
        teId:null,
        resName:res_name,
        resJob:res_job,
        resDocumentType:res_document_type,
        documentNum:document_num,
        resOfficeTel:res_office_tel,
        resMobileTel:res_mobile_tel,
        resEmail:res_email
    }

    return contacts_data;
}

var addPerson = function (condition) {
    // alert(condition+"condition")
    $.ajax({
        url: "/addPerson",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("增加团队联系人失败！")
        },
        success: function (result) {
            if (result != null) {
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}



/**
 * 点击增加变量值传送
 * @type {number}
 */
var patent=2;
var num =4;
var addImg =function () {
    // alert(patent);
    var html_tr = "<tr id='patent_"+(num-1)+"'><td>专利名称</td><td>专利类型*</td><td>专利号</td> <td>获得时间选择</td><td>核验</td></tr>"+
        "<tr id='patent_"+num+"'><td><input type='text' id='patent_name_"+patent+"'/></td>"+
        "<td>" +
            "<select id='patent_type_"+patent+"'>" +
            "<option value='1'>发明专利</option>"+
            "<option value='2'>实用新型专利</option>"+
            "<option value='3'>外观设计</option>"+
        "</select>"+
        "</td>"+
        "<td><input type='text' id='patent_num_"+patent+"'/></td>"+
        "<td><input type='text' id='patent_date_"+patent+"'/></td>" +
        "<td><input type='text' id='patent_verification_"+patent+"'/></td>" +
        "</tr>";
    // alert(html_tr);
    $("#patent_table").append(html_tr);
};

var addPatentList = function (condition) {
    // alert(condition+"condition")
    $.ajax({
        url: "/addPatentList",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            // alert("增加专利信息失败！")
        },
        success: function (result) {
            if (result != null) {
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}
/**
 查询专利号看是否增加*/
var getPatentListByPatentId=function (condition,data,patentId,i) {
    // alert(condition)
    $.ajax({
        url: "/getPatentListByPatentId",
        type: 'post',
        async: true,
        data: condition,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            alert(result);
            if (result != null && result>0) {
                alert("专利号"+patentId+"已被增加！请核实！！！");
            }else {
                addPatentList(data);

            }

        }
    });
};

var reduceImg = function () {
    // alert("#patent_"+(num+1));
    $("#patent_"+(num+1)).remove();
    $("#patent_"+(num+2)).remove();
}





    /********************************************************************************************************************************
     * 核心团队成员信息-第二步
     */
    var team=3;
    var core=15;
var edu = 1;
   var addCoreTeamImg= function () {
        var html_tr =
            "<tr id='core_"+(core-4)+"'><td>姓名</td><td>性别</td> <td>年龄</td><td>职位</td>" +
                "<td>最高学历</td> <td>留学经历</td> <td>入选国家千人计划</td><td>入选时间</td><td>大学生创业</td>"+
            "</tr >"+
            "<tr id='core_"+(core-3)+"'>" +
                "<td><input type='text' id='core_name_"+team+"'/></td>"+
                "<td>" +
                    "<select  id='core_sex_"+team+"'>" +
                        "<option value='男'>男</option>" +
                        "<option value='女'>女</option>" +
                    "</select>" +
                "</td>"+
                "<td><input type='number' id='core_age_"+team+"'/></td>"+
                "<td><input type='text' id='core_job_"+team+"'/></td>"+
                "<td><select id='core_education_"+team+"'><option value='学士'>学士</option><option value='硕士'>硕士</option><option value='博士'>博士</option></select></td>"+
                "<td><input type='text' id='core_experience_"+team+"'/></td>"+
                "<td>" +
                    "<select  id='core_millennium_"+team+"'>" +
                        "<option value='是'>是</option>" +
                        "<option value='否'>否</option>" +
                    "</select>" +
                "</td>"+
                "<td id='millennium_date_"+team+"'><input type='text' id='core_millennium_date_"+team+"'/></td>"+
                "<td><select id='ct_university_business_"+team+"'><option value='是'>是</option><option value='否'>否</option></select></td>"+
            "</tr>"+
            "<tr id='core_"+(core-2)+"'>" +
                "<td  colspan='9'>" +
                "<table id='append_education_"+team+"'>" +
                    "<tr><td colspan='3'>教育经历可增加</td></tr>" +
                    "<tr>" +
                        "<td colspan='3'>" +
                        "<div><img src=\"img/zengjia.png\"  id='addEducationImg"+(core-2)+"'/>增加</div>"+
                        "<div><img src=\"img/shanchu.png\"  id='reduceEducationImg"+(core-2)+"'/>减少</div>"+
                        "</td>" +
                    "</tr>"+
                    "<tr><td>学历</td><td>毕业学校</td><td>专业</td></tr>"+
                    "<tr id='education_"+(core-2)+"_"+team+"_1'>" +
                        "<td><input type='text' id='edu_background_"+(core-2)+"_"+team+"_1'/></td>"+
                        "<td><input type='text' id='edu_graduate_school_"+(core-2)+"_"+team+"_1'/></td>"+
                        "<td><input type='text' id='edu_major_"+(core-2)+"_"+team+"_1'/></td>"+
                    "</tr>"+
                "</td>" +
                "</table>"+
            "</tr>"+

            "<tr id='core_"+(core-1)+"'><td colspan='9'>主要工作经历/主要成就</td></tr>"+
            "<tr id='core_"+core+"'><td colspan='9'><textarea id='main_achive_"+team+"'></textarea></td></tr>";
        // alert(html_tr);
        $("#core_team_table").append(html_tr);

       var addEducationImgFun = "addEducationImg" +(core-2);
       // alert(addEducationImgFun);
       $("#addEducationImg"+(core-2)).click(function () {
           edu+=1;
               var html_edu = "<tr id='education_"+(core-2)+"_"+team+"_"+edu+"'>" +
                   "<td><input type='text' id='edu_background_"+(core-2)+"_"+team+"_"+edu+"'/></td>"+
                   "<td><input type='text' id='edu_graduate_school_"+(core-2)+"_"+team+"_"+edu+"'/></td>"+
                   "<td><input type='text' id='edu_major_"+(core-2)+"_"+team+"_"+edu+"'/></td>"+
                   "</tr>";
           // alert(html_edu)
               $("#append_education_"+team).append(html_edu);
       })

       $("#reduceEducationImg"+(core-2)).click(function () {
           $("#education_"+(core-2)+"_"+team+"_"+edu).remove();
           edu=edu-1;
       })

       $("#core_millennium_"+team).click(function () {
           if($("#core_millennium_"+team).val() == "是"){
               $("#millennium_date_"+team).removeAttr("disabled");
               $("#millennium_date_"+team).css("background","#ffffff");
               $("#millennium_date_"+team).find("input").removeAttr("disabled");
               $("#millennium_date_"+team).find("input").css("background","#ffffff");
           }else {
               $("#millennium_date_"+team).attr("disabled", "disabled");
               $("#millennium_date_"+team).css("background","#dbdbdb");
               $("#millennium_date_"+team).find("input").attr("disabled", "disabled");
               $("#millennium_date_"+team).find("input").css("background","#dbdbdb");
           }
       })
    }
$("#addEducationImg3").click(function () {
    edu+= 1;
        var html_edu = "<tr id='education_3_1_"+edu+"'>" +
            "<td><input type='text' id='edu_background_3_1_"+edu+"'/></td>"+
            "<td><input type='text' id='edu_graduate_school_3_1_"+edu+"'/></td>"+
            "<td><input type='text' id='edu_major_3_1_"+edu+"'/></td>"+
            "</tr>";
    $("#append_education_1").append(html_edu);
})

$("#addEducationImg8").click(function () {
    edu+= 1;
    var html_edu = "<tr id='education_8_2_"+edu+"'>" +
        "<td><input type='text' id='edu_background_8_2_"+edu+"'/></td>"+
        "<td><input type='text' id='edu_graduate_school_8_2_"+edu+"'/></td>"+
        "<td><input type='text' id='edu_major_8_2_"+edu+"'/></td>"+
        "</tr>";
    $("#append_education_2").append(html_edu);
})
$("#addEducationImg13").click(function () {
    edu+= 1;
    var html_edu = "<tr id='education_13_3_"+edu+"'>" +
        "<td><input type='text' id='edu_background_13_3_"+edu+"'/></td>"+
        "<td><input type='text' id='edu_graduate_school_13_3_"+edu+"'/></td>"+
        "<td><input type='text' id='edu_major_13_3_"+edu+"'/></td>"+
        "</tr>";
    $("#append_education_3").append(html_edu);
})
var reduceEducationImg3 = function (choose) {
    if (choose == 1){
        $("#education_3_1_"+edu).remove();
        edu=edu-1;
    }
    if (choose ==2){
        $("#education_8_2_"+edu).remove();
        edu=edu-1;
    }
    if (choose == 3){
        $("#education_13_3_"+edu).remove();
        edu=edu-1;
    }
}

   var reduceCoreImg = function () {
    // alert("#patent_"+(num+1));
           $("#core_"+(core+1)).remove();
           $("#core_"+(core+2)).remove();
           $("#core_"+(core+3)).remove();
           $("#core_"+(core+4)).remove();
           $("#core_"+(core+5)).remove();
}
var change_millen = function (choose) {
    if (choose == 1){
        if($("#core_millennium_"+choose).val() == "是"){
            $("#millennium_date_"+choose).removeAttr("disabled");
            $("#millennium_date_"+choose).css("background","#ffffff");
            $("#millennium_date_"+choose).find("input").removeAttr("disabled");
            $("#millennium_date_"+choose).find("input").css("background","#ffffff");
        }else {
            $("#millennium_date_"+choose).attr("disabled", "disabled");
            $("#millennium_date_"+choose).css("background","#dbdbdb");
            $("#millennium_date_"+choose).find("input").attr("disabled", "disabled");
            $("#millennium_date_"+choose).find("input").css("background","#dbdbdb");
        }
    }
    if (choose == 2){
        if($("#core_millennium_"+choose).val() == "是"){
            $("#millennium_date_"+choose).removeAttr("disabled");
            $("#millennium_date_"+choose).css("background","#ffffff");
            $("#millennium_date_"+choose).find("input").removeAttr("disabled");
            $("#millennium_date_"+choose).find("input").css("background","#ffffff");
        }else {
            $("#millennium_date_"+choose).attr("disabled", "disabled");
            $("#millennium_date_"+choose).css("background","#dbdbdb");
            $("#millennium_date_"+choose).find("input").attr("disabled", "disabled");
            $("#millennium_date_"+choose).find("input").css("background","#dbdbdb");
        }
    }
    if (choose == 3){
        if($("#core_millennium_"+choose).val() == "是"){
            $("#millennium_date_"+choose).removeAttr("disabled");
            $("#millennium_date_"+choose).css("background","#ffffff");
            $("#millennium_date_"+choose).find("input").removeAttr("disabled");
            $("#millennium_date_"+choose).find("input").css("background","#ffffff");
        }else {
            $("#millennium_date_"+choose).attr("disabled", "disabled");
            $("#millennium_date_"+choose).css("background","#dbdbdb");
            $("#millennium_date_"+choose).find("input").attr("disabled", "disabled");
            $("#millennium_date_"+choose).find("input").css("background","#dbdbdb");
        }
    }
}
$("#hxtd_conservation_team").bind('click',function () {
    for(var i=1;i<=team;i++){
        var coreName = $("#core_name_"+i).val();
        var coreSex = $("#core_sex_"+i).val();
        var coreAge = $("#core_age_"+i).val();
        var coreJob = $("#core_job_"+i).val();
        var coreEducation = $("#core_education_"+i).val();
        var coreExperience = $("#core_experience_"+i).val();
        var coreMillennium = $("#core_millennium_"+i).val();
        var coreMillenniumDate = $("#core_millennium_date_"+i).val();
        var mainAchive = $("#main_achive_"+i).val();
        var ct_university_business = $("#ct_university_business_"+i).val();

        // alert(coreMillenniumDate);
        if(coreName == "" || coreSex == "" || coreAge == "" || coreJob == "" ||
            coreEducation == "" || coreExperience == "" || coreMillennium == "" || mainAchive == "" ){
            alert("请将核心成员信息填写完整！");
        }else {
            if (coreMillenniumDate == ""){
                var condition={
                    ueId:null,
                    teId:null,
                    entireId:entireId,
                    ctName:coreName,
                    ctSex:coreSex,
                    ctAge:coreAge,
                    ctJob:coreJob,
                    ctHigbestEducation:coreEducation,
                    ctStudyExperience:coreExperience,
                    ctMainAchive:mainAchive,
                    ctNationalMillennium:coreMillennium,
                    ctUniversityBusiness:ct_university_business
                }
                addCoreTeam(condition,i);

            }else {
                var condition={
                    ueId:null,
                    teId:null,
                    entireId:entireId,
                    ctName:coreName,
                    ctSex:coreSex,
                    ctAge:coreAge,
                    ctJob:coreJob,
                    ctHigbestEducation:coreEducation,
                    ctStudyExperience:coreExperience,
                    ctMainAchive:mainAchive,
                    ctNationalMillennium:coreMillennium,
                    nationalMilleDate:comTime(coreMillenniumDate),
                    ctUniversityBusiness:ct_university_business
                }
                addCoreTeam(condition,i);

            }

        }
    }
});
var addCoreTeam=function (condition,t_i) {
    $.ajax({
        url: "/addCoreTeam",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            // alert("增加核心团队人员信息失败！")
        },
        success: function (result) {
            if (result != null) {
                // alert(result);
                addEducationExperionce(result,t_i);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
                $("#hxtd_conservation_team").unbind('click');
                $("#hxtd_conservation_team").css("background","#dbdbdb");
                $("#hxtd_conservation_team").find("p").html("已保存");
            }

        }
    });
}

var addEducationExperionce = function (coreTeamId,t_i) {
    var core_edu=3;
    var edu_length = $("#append_education_"+t_i).find("tr").length-3;
    // alert(edu_length);
    core_edu = core_edu+(t_i-1)*5;
        for(var i=1;i<=edu_length;i++){
            // alert(core_edu+","+team_edu);
            var edu_background = $("#edu_background_"+core_edu+"_"+t_i+"_"+i).val();
            // alert("#edu_background_"+core_edu+"_"+t_i+"_"+i);
            var edu_graduate_school = $("#edu_graduate_school_"+core_edu+"_"+t_i+"_"+i).val();
            var edu_major = $("#edu_major_"+core_edu+"_"+t_i+"_"+i).val();
            var condition = {
                entireId:entireId,
                ctId:coreTeamId,
                eduBackground:edu_background,
                eduGraduateSchool:edu_graduate_school,
                eduMajor:edu_major
            }
            addEducationExpeionceCondition(condition);
        }
    team=team+1;

    // }

}
var addEducationExpeionceCondition = function (condition) {

    $.ajax({
        url: "/addEducationExperionce",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("增加教育经历失败！")
        },
        success: function (result) {
            if (result != null) {
                alert("增加核心成员信息成功！");
            }

        }
    });
}






/******************************************************************************************************
 *第三步，填写商业计划书
 */
var litigation = 3;var liti=2;

var change_litigation3_yes = function () {
    $(".reason3,.reason3 td,.reason3 td input,.reason3 div").removeAttr("disabled");
    $(".reason3,.reason3 td,.reason3 td input,.reason3 div").css("background","#ffffff");
}
var change_litigation3_No = function () {
    $(".reason3,.reason3 td,.reason3 td input,.reason3 div").attr("disabled", "disabled");
    $(".reason3,.reason3 td,.reason3 td input,.reason3 div").css("background", "#dbdbdb");
    // $("#litigation_table").unbind('click');
    // $("#reduceLitigationImg").unbind('click');
}

var addLitigationImg = function () {
    var html_tr = "<tr id='liti_"+(liti-1)+"'><td>诉讼内容</td><td><input type='text' id='litigation_content_"+litigation+"'/></td></tr>"+
        "<tr id='liti_"+liti+"'><td>诉讼原因</td><td><input type='text' id='litigation_reason_"+litigation+"'/></td></tr>";

    $("#litigation_table").append(html_tr);
}
var reduceLitigationImg = function () {
    $("#liti_"+(liti+2)).remove();
    $("#liti_"+(liti+1)).remove();
}




$("#syjhs_conservation_team").click(function () {

    var plan_data = conditionTeamBusinessPlan();
    // alert(data);
    addTeamBusinessPlan(plan_data);
    conditionFore();
    conditionTeamRisk();

    $(this).unbind('click');
    $(this).css("background","#dbdbdb");
    $(this).find("p").html("已保存");
});



var conditionTeamBusinessPlan=function () {
    /**
     * 增加基本信息
     * @type {any}
     */
    var pro_name = $("#pro_name").val();
    var pro_incomed = $("#pro_incomed").val();
    var tbus_new_chips = $("#tbus_new_chips input:radio:checked").val();
    var tbus_hive = $("#tbus_hive input:radio:checked").val();
    var tbus_pro_core = $("#tbus_pro_core input:radio:checked").val();
    var tbus_technology_maturity = $("#tbus_technology_maturity").val();

    var tbus_manufactur_matutity = $("#tbus_manufactur_matutity").val();
    var tbusMarketMatutity = $("#tbusMarketMatutity").val();
    var tbus_industry_main = $("#tbus_industry_main input:radio:checked").val();
    var tbus_is_lead_internal = $("#tbus_is_lead_internal input:radio:checked").val();
    var tbus_is_lead_international = $("#tbus_is_lead_international input:radio:checked").val();
    var research_institute = $("#research_institute input:radio:checked").val();

    var institute_name = $("#institute_name").val();

    var pro_picture = $("#pro_picture input:radio:checked").val();
    var major_describe = $("#major_describe").val();
    var pro_market = $("#pro_market").val();
    var bus_model = $("#bus_model").val();
    var tbus_development_plan = $("#tbus_development_plan").val();

    var teamBusinessPlan_data = {
        teId:null,
        entireId:entireId,
        tbusProName:pro_name,
        tbusProIncomed:pro_incomed,
        tbusNewChips:tbus_new_chips,
        tbusHive:tbus_hive,
        tbusProCore:tbus_pro_core,
        tbusMajorDesc:major_describe,
        tbusTechnologyMaturity:tbus_technology_maturity,
        tbusManufacturMatutity:tbus_manufactur_matutity,
        tbusMarketMatutity:tbusMarketMatutity,
        tbusIndustryMain:tbus_industry_main,
        tbusLeadInternal:tbus_is_lead_internal,
        tbusLeadInternational:tbus_is_lead_international,

        tbusResearchInstitute:research_institute,
        instituteName:institute_name,
        tbusProPicture:pro_picture,
        tbusMarketAnalysis:pro_market,
        tbusModel:bus_model,
        tbusDevelopmentPlan:tbus_development_plan
    }
    return teamBusinessPlan_data;
};
/**
 * 创建商业计划书
 * @param condition
 */
var addTeamBusinessPlan = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/addTeamBusinessPlan",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建团队商业计划书失败！")
        },
        success: function (result) {
            if (result != null) {
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });

}

/**
 * 创建经营封信与对策信息
 */
var conditionTeamRisk = function () {
    for(var i = 1;i<=3;i++){
        if(i != 3){
            if($("#litigation_"+i+" input:checked").val() == "有"){
                var litigation_content = $("#litigation_content_"+i).text();
                var litigation_reason = $("#litigation_reason_"+i).val()
            }

            var condition = {
                entireId:entireId,
                tbusId:null,
                econoLitigationContent:litigation_content,
                litigationReason:litigation_reason
            }
            addRisk(condition);
        }else {
            if($("#other_litigation input:checked").val() == "有"){
                for(var i=3;i<=litigation;i++){
                    var litigation_content = $("#litigation_content_"+i).val();
                    var litigation_reason = $("#litigation_reason_"+i).val();

                    var condition = {
                        entireId:entireId,
                        tbusId:null,
                        econoLitigationContent:litigation_content,
                        litigationReason:litigation_reason
                    }
                    addRisk(condition);
                }
            }
        }

    }

}

var addRisk = function (condition) {
    $.ajax({
        url: "/addRiskCondition",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建经营能够与风险信息失败！")
        },
        success: function (result) {
            if (result != null) {
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}


/**财务预测*/

var conditionFore = function () {
    for(var i=5;i<=7;i++){
        var fore_income=$("#fore_income_"+i).val();
        alert()
        var fore_cost=$("#fore_cost_"+i).val();
        var fore_profit=$("#fore_profit_"+i).val();
        var net_margin=$("#net_margin_"+i).val();
        var fore_year = "201"+i;
        var condition = {
            ubusId:null,
            tbusId:null,
            entireId:entireId,
            foreIncome:fore_income,
            foreCost:fore_cost,
            foreProfit:fore_profit,
            foreNetMargin:net_margin,
            foreYear:fore_year

        }

        addFinancialForecasting(condition);

    }


};
var addFinancialForecasting = function (condition) {
    $.ajax({
        url: "/addFinancialForecasting",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建财务预测数据失败！")
        },
        success: function (result) {
            if (result != null) {
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}



/****************************************科技金融服务需求*/

$("#kjjr_conservation_team").bind('click',function () {
    conditionDemand();
})

var conditionDemand=function () {
    /**
     * 增加基本信息
     * @type {any}
     */
    var df_isEquity = $("#df_isEquity input:checked").val();

        var df_equity_money = $("#df_equity_money").val();
        var df_equity_shares = $("#df_equity_shares").val();
        var df_equity_date = $("#df_equity_date").val();
        var df_equityFund_plan = $("#df_equityFund_plan").val();
        var df_isEquity_recom = $("#df_isEquity_recom input:checked").val();
    var df_isDebt = $("#df_isDebt input:checked").val();

        var df_debt_money = $("#df_debt_money").val();
        var df_debt_maxAnnual = $("#df_debt_maxAnnual").val();
        var df_debt_date = $("#df_debt_date").val();
        var df_debtFund_plan = $("#df_debtFund_plan").val();
        var df_isDebt_recom = $("#df_isDebt_recom input:checked").val();

   if( $("#choose_crowd input[type='checkbox']").is(':checked') == true) {
       var df_isCrowd_funding = "1";
   }else {
       var df_isCrowd_funding = "0";
   }
   alert(df_isCrowd_funding+"df_isCrowd_funding");
    var crows_fund_type = $("#crows_fund_type tr td input:checked").val();
    // alert(crows_fund_type);
    if( $("#df_isMerge input[type='checkbox']").is(':checked') == true) {
        var df_isMerge = "1";
    }else {
        var df_isMerge = "0";
    }

    if( $("#df_isFinancing_guarantee input[type='checkbox']").is(':checked') == true) {
        var df_isFinancing_guarantee = "1";
    }else {
        var df_isFinancing_guarantee = "0";
    }

    if( $("#change_petty input[type='checkbox']").is(':checked') == true) {
        var df_isPetty_loan = "1";
        var petty_loan_money = $("#petty_loan_money").val();
    }else {
        var df_isPetty_loan = "0";
        var petty_loan_money = null;
    }


    if( $("#change_import_technical input[type='checkbox']").is(':checked') == true) {
        var df_technical_import = "1";
        if( $("#technical_import_international input[type='checkbox']").is(':checked') == true) {
            var technical_import_international = "国际技术范围";
            var technical_desc_international = $("#technical_desc_international").val();
        }else {
            var technical_import_international = null;
            var technical_desc_international =null;
        }
        if( $("#technical_import_internal input[type='checkbox']").is(':checked') == true) {
            var technical_import_internal = "国内技术范围";
            var technical_desc_internal = $("#technical_desc_internal").val();
        }else {
            var technical_import_internal = null;
            var technical_desc_internal = null
        }
    }else {
        var df_technical_import = "0";
        var technical_import_internal = null;
        var technical_desc_internal = null;
        var technical_import_international = null;
        var technical_desc_international =null;
    }


    if( $("#change_transfer input[type='checkbox']").is(':checked') == true) {
        var df_technical_transfer = "1";
        var technical_transfer_range = $("#technical_transfer_range").val();
    }else {
        var df_technical_transfer = "0";
        var technical_transfer_range = null;
    }


    if( $("#df_branchChong_check input[type='checkbox']").is(':checked') == true) {
        var df_branchChong_check = "1";
    }else {
        var df_branchChong_check = "0";
    }

    if( $("#df_political_consult input[type='checkbox']").is(':checked') == true) {
        var df_political_consult = "1";
    }else {
        var df_political_consult = "0";
    }

    if( $("#df_technology_consult input[type='checkbox']").is(':checked') == true) {
        var df_technology_consult = "1";
    }else {
        var df_technology_consult = "0";
    }

    if( $("#change_intermediary input[type='checkbox']").is(':checked') == true) {
        var df_intermediary_consult = "1";
        if( $("#intermediary_law input[type='checkbox']").is(':checked') == true) {
            var intermediary_law = "1";
            var intermediary_law_desc = $("#intermediary_law_desc").val();
        }else {
            var intermediary_law = "0";
            var intermediary_law_desc = null
        }
        if( $("#intermediary_finance input[type='checkbox']").is(':checked') == true) {
            var intermediary_finance = "1";
            var intermediary_finance_desc = $("#intermediary_finance_desc").val();
        }else {
            var intermediary_finance = "0";
            var intermediary_finance_desc = null
        }
        if( $("#intermediary_Financing input[type='checkbox']").is(':checked') == true) {
            var intermediary_Financing = "1";
            var intermediary_financing_desc = $("#intermediary_financing_desc").val();
        }else {
            var intermediary_Financing = "0";
            var intermediary_financing_desc = null
        }
        if( $("#intermediary_manage input[type='checkbox']").is(':checked') == true) {
            var intermediary_manage = "1";
            var intermediary_manage_desc = $("#intermediary_manage_desc").val();
        }else {
            var intermediary_manage = "0";
            var intermediary_manage_desc = null
        }
    }else {
        var df_intermediary_consult = "0";
        var intermediary_law = null;
        var intermediary_law_desc = null
        var intermediary_finance = null;
        var intermediary_finance_desc = null;
        var intermediary_Financing =null;
        var intermediary_financing_desc = null
        var intermediary_manage = null;
        var intermediary_manage_desc = null

    }


    var df_other_service = $("#df_other_service").val();
    if( $("#change_other input[type='checkbox']").is(':checked') == true) {
        var df_other_service = "1";
        var other_service_desc = $("#other_service_desc").val();
    }else {
        var df_other_service = "0";
        var other_service_desc = null
    }

    var df_accept_train = $("#df_accept_train").val();
    if( $("#df_accept_train input[type='checkbox']").is(':checked') == true) {
        var df_accept_train = "1";
    }else {
        var df_accept_train = "0";
    }
    var df_no = $("#df_no").val();
    if( $("#df_no input[type='checkbox']").is(':checked') == true) {
        var df_no = "1";
    }else {
        var df_no = "0";
    }
    // alert(df_equity_date)
    if(df_isEquity == "是" && df_isDebt == "是"){
        var unitDemand_data = {
            ubusId:null,
            tbusId:null,
            entireId:entireId,
            dfEquity:df_isEquity,
            dfEquityShares:df_equity_shares,
            dfEquityMoney:df_equity_money,
            dfEquityDate:comTime(df_equity_date),
            equityFundPlan:df_equityFund_plan,

            dfEquityRecom:df_isEquity_recom,
            dfDebt:df_isDebt,
            dfDebtMoney:df_debt_money,
            debtMaxAnnual:df_debt_maxAnnual,
            dfDebtDate:comTime(df_debt_date),
            debtFundPlan:df_debtFund_plan,
            dfDebtRecom:df_isDebt_recom,

            dfCrowdFunding:df_isCrowd_funding,
            crowsFundType:crows_fund_type,
            dfMerge:df_isMerge,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            branchChongCheck:df_branchChong_check,

            dfPoliticalConsult:df_political_consult,
            dfTechnologyConsult:df_technology_consult,
            dfIntermediaryConsult:df_intermediary_consult,
            intermediaryLaw:intermediary_law,
            intermediaryLawDesc:intermediary_law_desc,
            intermediaryFinance:intermediary_finance,
            intermediaryFinanceDesc:intermediary_finance_desc,
            intermediaryFinancing:intermediary_Financing,
            intermediaryFinancingDesc:intermediary_financing_desc,
            intermediaryManage:intermediary_manage,
            intermediaryManageDesc:intermediary_manage_desc,
            dfOtherService:df_other_service,
            otherServiceDesc:other_service_desc,
            dfAcceptTrain:df_accept_train,
            dfNo:df_no
        }

        addDemand(unitDemand_data);
    }
    if(df_isEquity == "否" && df_isDebt == "否"){
        var unitDemand_data = {
            ubusId:null,
            tbusId:null,
            entireId:entireId,
            dfEquity:df_isEquity,

            dfDebt:df_isDebt,

            dfCrowdFunding:df_isCrowd_funding,
            crowsFundType:crows_fund_type,
            dfMerge:df_isMerge,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            branchChongCheck:df_branchChong_check,

            dfPoliticalConsult:df_political_consult,
            dfTechnologyConsult:df_technology_consult,
            dfIntermediaryConsult:df_intermediary_consult,
            intermediaryLaw:intermediary_law,
            intermediaryLawDesc:intermediary_law_desc,
            intermediaryFinance:intermediary_finance,
            intermediaryFinanceDesc:intermediary_finance_desc,
            intermediaryFinancing:intermediary_Financing,
            intermediaryFinancingDesc:intermediary_financing_desc,
            intermediaryManage:intermediary_manage,
            intermediaryManageDesc:intermediary_manage_desc,
            dfOtherService:df_other_service,
            otherServiceDesc:other_service_desc,
            dfAcceptTrain:df_accept_train,
            dfNo:df_no
        }

        addDemand(unitDemand_data);
    }
    if(df_isEquity == "是" && df_isDebt == "否"){
        var unitDemand_data = {
            ubusId:null,
            tbusId:null,
            entireId:entireId,
            dfEquity:df_isEquity,
            dfEquityShares:df_equity_shares,
            dfEquityMoney:df_equity_money,
            dfEquityDate:comTime(df_equity_date),
            equityFundPlan:df_equityFund_plan,

            dfEquityRecom:df_isEquity_recom,
            dfDebt:df_isDebt,

            dfCrowdFunding:df_isCrowd_funding,
            crowsFundType:crows_fund_type,
            dfMerge:df_isMerge,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            branchChongCheck:df_branchChong_check,

            dfPoliticalConsult:df_political_consult,
            dfTechnologyConsult:df_technology_consult,
            dfIntermediaryConsult:df_intermediary_consult,
            intermediaryLaw:intermediary_law,
            intermediaryLawDesc:intermediary_law_desc,
            intermediaryFinance:intermediary_finance,
            intermediaryFinanceDesc:intermediary_finance_desc,
            intermediaryFinancing:intermediary_Financing,
            intermediaryFinancingDesc:intermediary_financing_desc,
            intermediaryManage:intermediary_manage,
            intermediaryManageDesc:intermediary_manage_desc,
            dfOtherService:df_other_service,
            otherServiceDesc:other_service_desc,
            dfAcceptTrain:df_accept_train,
            dfNo:df_no
        }

        addDemand(unitDemand_data);
    }
    if(df_isEquity == "否" && df_isDebt == "是"){
        var unitDemand_data = {
            ubusId:null,
            tbusId:null,
            entireId:entireId,
            dfDebt:df_isDebt,
            dfDebtMoney:df_debt_money,
            debtMaxAnnual:df_debt_maxAnnual,
            dfDebtDate:comTime(df_debt_date),
            debtFundPlan:df_debtFund_plan,
            dfDebtRecom:df_isDebt_recom,
            dfCrowdFunding:df_isCrowd_funding,
            crowsFundType:crows_fund_type,
            dfMerge:df_isMerge,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            branchChongCheck:df_branchChong_check,

            dfPoliticalConsult:df_political_consult,
            dfTechnologyConsult:df_technology_consult,
            dfIntermediaryConsult:df_intermediary_consult,
            intermediaryLaw:intermediary_law,
            intermediaryLawDesc:intermediary_law_desc,
            intermediaryFinance:intermediary_finance,
            intermediaryFinanceDesc:intermediary_finance_desc,
            intermediaryFinancing:intermediary_Financing,
            intermediaryFinancingDesc:intermediary_financing_desc,
            intermediaryManage:intermediary_manage,
            intermediaryManageDesc:intermediary_manage_desc,
            dfOtherService:df_other_service,
            otherServiceDesc:other_service_desc,
            dfAcceptTrain:df_accept_train,
            dfNo:df_no
        }

        addDemand(unitDemand_data);
    }

    // return unitDemand_data;
};
var addDemand = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/addDemandFinancial",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建科技服务信息失败！")
        },
        success: function (result) {
            if (result != null) {
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
                $("#kjjr_conservation_team").unbind('click');
                $("#kjjr_conservation_team").css("background","#dbdbdb");
                $("#kjjr_conservation_team").find("p").html("已保存");
            }

        }
    });

}

$("#submit_competition").click(function () {
    $("#lightboxOverlay").show();
    $("#submit_pop").show();
    $("#body").css("overflow-y","hidden");
})