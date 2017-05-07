/**
 * Created by Administrator on 2017/4/30.
 */

$(function () {
    $("#first_btn").css("background","#8fc320");
    $("#first_btn").find("p").css("color","#ffffff");

    $("#first_table").show();
    $("#second_table").hide();
    $("#third_table").hide();

    $(".streamer_jbxx").show();
    $(".streamer_hxtd").hide();
    $(".streamer_syjhs").hide();

    $("#jbxx_conservation").show();
    $("#hxtd_conservation").hide();
    $("#syjhs_conservation").hide();

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

    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").attr("disabled", "disabled");
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").css("background","#dbdbdb");
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").attr("disabled", "disabled");
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").css("background","#dbdbdb");

    $("#equity").find(".equity_tr,.equity_tr td,.equity_tr td input").attr("disabled", "disabled");
    $("#equity").find(".equity_tr,.equity_tr td,.equity_tr td input").css("background","#dbdbdb");
    $("#equity").find(".debt_tr,.debt_tr td,.debt_tr td input").attr("disabled", "disabled");
    $("#equity").find(".debt_tr,.debt_tr td,.debt_tr td input").css("background","#dbdbdb");

});
$("#first_btn").click(function () {
    $(this).css("background","#8fc320");
    $(this).find("p").css("color","#ffffff");
    $("#second_btn").css("background","#ffffff");
    $("#second_btn").find("p").css("color","#a8daf3");
    $("#third_btn").css("background","#ffffff");
    $("#third_btn").find("p").css("color","#a8daf3");

    $("#first_table").show();
    $("#second_table").hide();
    $("#third_table").hide();

    $(".streamer_jbxx").show();
    $(".streamer_hxtd").hide();
    $(".streamer_syjhs").hide();

    $("#jbxx_conservation").show();
    $("#hxtd_conservation").hide();
    $("#syjhs_conservation").hide();
})

$("#second_btn").click(function () {
    getUnitEssentialByEntireId(entireId,"second");

})
$("#third_btn").click(function () {
    getCoreTeamByEntireId(entireId,"third");
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
    $("#institute").find(".instituteName,.instituteName input").css("background","#ffffff");

}
var change_instituteName = function () {
    $("#institute").find(".instituteName,.instituteName input").attr("disabled", "disabled");
    $("#institute").find(".instituteName,.instituteName input").css("background","#dbdbdb");
}

var change_picture_yes = function () {
    $("#picture").find(".picture_upload,.picture_upload input,.picture_upload div").removeAttr("disabled");
    $("#picture").find(".picture_upload,.picture_upload input,.picture_upload div").css("background","#ffffff");
}
var change_picture_No = function () {
    $("#picture").find(".picture_upload,.picture_upload input,.picture_upload div").attr("disabled", "disabled");
    $("#picture").find(".picture_upload,.picture_upload input,.picture_upload div").css("background","#dbdbdb");
}

var change_equity_yes = function () {
    $("#equity").find(".equity_tr,.equity_tr td,.equity_tr td input").removeAttr("disabled");
    $("#equity").find(".equity_tr td input").css("background","#ffffff");
    $("#equity").find(".equity_tr,.equity_tr td").css("background","#ecf7fd");
}
var change_equity_no = function () {
    $("#equity").find(".equity_tr,.equity_tr td,.equity_tr td input").attr("disabled", "disabled");
    $("#equity").find(".equity_tr,.equity_tr td,.equity_tr td input").css("background","#dbdbdb");
}

var change_debt_yes = function () {
    $("#equity").find(".debt_tr,.debt_tr td,.debt_tr td input").removeAttr("disabled");
    $("#equity").find(".debt_tr td input").css("background","#ffffff");
    $("#equity").find(".debt_tr,.debt_tr td").css("background","#ecf7fd");
}
var change_debt_no = function () {
    $("#equity").find(".debt_tr,.debt_tr td,.debt_tr td input").attr("disabled", "disabled");
    $("#equity").find(".debt_tr,.debt_tr td,.debt_tr td input").css("background","#dbdbdb");
}

var df_equity_yes = function () {
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").removeAttr("disabled");
    $("#technology").find(".df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").css("background","#ffffff");
    $("#technology").find(".df_equity_yes,.df_equity_yes td").css("background","#ecf7fd");
}
var df_equity_no = function () {
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").attr("disabled", "disabled");
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").css("background","#dbdbdb");
}

var df_debt_yes = function () {
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").removeAttr("disabled");
    $("#technology").find(".df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").css("background","#ffffff");
    $("#technology").find(".df_debt_yes,.df_debt_yes td").css("background","#ecf7fd");
}
var df_debt_no = function () {
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").attr("disabled", "disabled");
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").css("background","#dbdbdb");
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


var getCoreTeamByEntireId = function (condition,i) {

    $.ajax({
        url: "/getCoreTeamByEntireId/"+condition,
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
                if(i == "third"){
                    $(this).css("background","#8fc320");
                    $(this).find("p").css("color","#ffffff");
                    $("#first_btn").css("background","#ffffff");
                    $("#first_btn").find("p").css("color","#a8daf3");
                    $("#second_btn").css("background","#ffffff");
                    $("#second_btn").find("p").css("color","#a8daf3");


                    $("#third_table").show();
                    $("#second_table").hide();
                    $("#first_table").hide();

                    $(".streamer_syjhs").show();
                    $(".streamer_jbxx").hide();
                    $(".streamer_hxtd").hide();

                    $("#syjhs_conservation").show();
                    $("#jbxx_conservation").hide();
                    $("#hxtd_conservation").hide();
                }
            }else {
                if(i == "third"){
                    alert("团队报名第二步：核心团队成员信息还未完成填写，请先填写！");
                }
            }

        }
    });

}
/***********************************************************************************************************************
 * 基本信息第一步
 */


$("#jbxx_conservation").click(function () {
    // alert(entireId)
    if($("#company_name").val() == "" ||
        $("#ue_goal input:checked").val() == "" ||   $("#ue_filed input:checked").val() == ""
         || $("#register_capital").val() == "" ||
        $("#win_num").val() == "" || $("#staff_num").val() == ""
        || $("#research_num").val() == "" || $("#deputy_num").val() == "" ||
        $("#office_address").val() == ""
        || $("#power_type").val() == "" || $("#corporation_summary").text() == "" ||
        $("#te_address").val() == "" || $("#te_postalcode").val() == "" ||
        $("#post_code input:checked").val() == "" || $("#technical_sources input:checked") == ""){

        alert("请将基本信息填写完整！")
    }else {
        if($("#legal_name").val() =="" || $("#legal_job").val() =="" || $("#legal_office_tel").val() =="" ||
            $("#legal_mobile_tel").val() =="" || $("#legal_email").val() =="" ){
            alert("请将法定代表人信息填写完整")
        }else {
            if($("#contacts_name").val() =="" || $("#contacts_job").val() =="" || $("#contacts_office_tel").val() =="" ||
                $("#contacts_mobile_tel").val() =="" || $("#contacts_email").val() =="" ){
                alert("请将联系人信息填写完整")
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
                        if(patentNum == "" || patentType == "" || patentNum ==""
                            || patentDate == ""
                        ){
                            alert("请将专利相关信息补充完整")
                        }else {
                            var data = {
                                ueId:null,
                                patentId:patentNum,
                                entireId:entireId,
                                teId:null,
                                patentName:patentName,
                                patentType:patentType,
                                patentDate:comTime(patentDate)
                            }
                            addPatentList(data);
                            getUnitEssentialByEntireId(entireId,i);
                            getLegalRepresentativeByEntireId(entireId,i);
                            getContactsByEntireId(entireId,i);
                            $(this).unbind('click');
                            $(this).css("background","gray");
                            $(this).find("p").html("已保存");
                        }

                    }
                }else {
                    var unitEssencialData = conditionEssential();
                    // alert(data);
                    addUnitEssential(unitEssencialData);

                    var legal_data = conditionLegal();
                    // alert(data);
                    addLegalRepresentative(legal_data);

                    var contacts_data = conditionContacts();
                    // alert(data);
                    addContacts(contacts_data);

                    $(this).unbind('click');
                    $(this).css("background","gray");
                    $(this).find("p").html("已保存");
                }
            }
        }
    }

});
/**
 * 查询对应作品ID是否被创建基本信息
 */
var getUnitEssentialByEntireId = function (condition,i) {

    $.ajax({
        url: "/getUnitEssentialByEntireId/"+condition,
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
                if (i == "second"){
                    $("#second_btn").css("background","#8fc320");
                    $("#second_btn").find("p").css("color","#ffffff");
                    $("#first_btn").css("background","#ffffff");
                    $("#first_btn").find("p").css("color","#a8daf3");
                    $("#third_btn").css("background","#ffffff");
                    $("#third_btn").find("p").css("color","#a8daf3");


                    $("#second_table").show();
                    $("#first_table").hide();
                    $("#third_table").hide();

                    $(".streamer_hxtd").show();
                    $(".streamer_jbxx").hide();
                    $(".streamer_syjhs").hide();

                    $("#hxtd_conservation").show();
                    $("#jbxx_conservation").hide();
                    $("#syjhs_conservation").hide();
                }
            }else {

                if(i == patent){
                    var data = conditionEssential();
                    // alert(data);
                    addUnitEssential(data);
                }
                if(i == "second"){
                    alert("团队报名第一步：基本信息填写还未完成填写，请先填写！");
                }

            }

        }
    });

}
/**
 * 查询对应作品ID是否被法定代表人
 */
var getLegalRepresentativeByEntireId = function (condition,i) {

    $.ajax({
        url: "/getLegalRepresentativeByEntireId/"+condition,
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
                if(i == patent){
                    /**
                     * 存在ID，更新
                     */
                    var data = conditionLegal();
                    // alert(data);
                    addLegalRepresentative(data);
                }
            }else {

                if(i == patent){
                    /**
                     * 存在ID，更新
                     */
                    var data = conditionLegal();
                    // alert(data);
                    addLegalRepresentative(data);
                }


            }

        }
    });

}
var getContactsByEntireId = function (condition,i) {

    $.ajax({
        url: "/getContactsByEntireId/"+condition,
        type: 'get',
        async: true,
        data: condition,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            alert(result);
            if (result != null && result>0) {
                if(i == patent){
                    /**
                     * 存在ID，更新
                     */
                    var data = conditionContacts();
                    // alert(data);
                    addContacts(data);
                }
            }else {
                if(i == patent){
                    /**
                     * 存在ID，更新
                     */
                    var data = conditionContacts();
                    // alert(data);
                    addContacts(data);
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
    var companyName = $("#company_name").val();
    var Goal = $("#ue_goal input:radio:checked").val();
    var ueFiled = $("#ue_filed input:radio:checked").val();
    var registerCapital = $("#register_capital").val();
    var staffNum = $("#staff_num").val();
    var winNum = $("#win_num").val();
    var researchNum = $("#research_num").val();
    var deputyNum = $("#deputy_num").val();
    var officeAddress = $("#office_address").val();
    var postCode = $("#post_code input:radio:checked").val();
    var Type = $("#power_type").val();
    var corporationSummary = $("#corporation_summary").val();
    var technicalSources = $("#post_code input:radio:checked").val();
    if(Goal == "其他"){
        var ueGoal = $("#ueGoal").val();
        if(Type == "其他"){
            var powerType = $("#powerType").val();
            var Essential_data = {
                entireId:entireId,
                ueCompanyName:companyName,
                ueGoal:ueGoal,
                ueField:ueFiled,
                ueRegisterCapital:registerCapital,
                ueWinNum:winNum,
                ueStaffNum:staffNum,
                ueResearchNum:researchNum,
                ueDeputyNum:deputyNum,
                ueOfficeAddress:officeAddress,
                uePostCode:postCode,
                uePowerType:powerType,
                ueCorporationSummary:corporationSummary,
                ueTechnicalSources:technicalSources
            }
            return Essential_data;
        }else {
            var Essential_data = {
                entireId:entireId,
                ueCompanyName:companyName,
                ueGoal:ueGoal,
                ueField:ueFiled,
                ueRegisterCapital:registerCapital,
                ueWinNum:winNum,
                ueStaffNum:staffNum,
                ueResearchNum:researchNum,
                ueDeputyNum:deputyNum,
                ueOfficeAddress:officeAddress,
                uePostCode:postCode,
                uePowerType:Type,
                ueCorporationSummary:corporationSummary,
                ueTechnicalSources:technicalSources
            }
            return Essential_data;
        }
    }else {
        if(Type == "其他"){
            var powerType = $("#powerType").val();
            var Essential_data = {
                entireId:entireId,
                ueCompanyName:companyName,
                ueGoal:Goal,
                ueField:ueFiled,
                ueRegisterCapital:registerCapital,
                ueWinNum:winNum,
                ueStaffNum:staffNum,
                ueResearchNum:researchNum,
                ueDeputyNum:deputyNum,
                ueOfficeAddress:officeAddress,
                uePostCode:postCode,
                uePowerType:powerType,
                ueCorporationSummary:corporationSummary,
                ueTechnicalSources:technicalSources
            }
            return Essential_data;
        }else {
            var Essential_data = {
                entireId:entireId,
                ueCompanyName:companyName,
                ueGoal:Goal,
                ueField:ueFiled,
                ueRegisterCapital:registerCapital,
                ueWinNum:winNum,
                ueStaffNum:staffNum,
                ueResearchNum:researchNum,
                ueDeputyNum:deputyNum,
                ueOfficeAddress:officeAddress,
                uePostCode:postCode,
                uePowerType:Type,
                ueCorporationSummary:corporationSummary,
                ueTechnicalSources:technicalSources
            }
            return Essential_data;
        }
    }
};

/**
 * 创建基本信息
 * @param condition
 */
var addUnitEssential = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/addUnitEssential",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建基本信息失败！")
        },
        success: function (result) {
            if (result != null) {
                // alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });

}



var conditionLegal = function () {
    var legalName = $("#legal_name").val();
    var legalJob = $("#legal_job").val();
    var legalOfficeTel = $("#legal_office_tel").val();
    var legalMobileTel = $("#legal_mobile_tel").val();
    var legalEmail = $("#legal_email").val();
    var legal_data = {
        entireId:entireId,
        ueId:null,
        legalName:legalName,
        legalJob:legalJob,
        legalOfficeTel:legalOfficeTel,
        legalMobileTel:legalMobileTel,
        legalEmail:legalEmail
    }

    return legal_data;
}
var addLegalRepresentative = function (condition) {
    // alert(condition+"condition")
    $.ajax({
        url: "/addLegalRepresentative",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("增加法定联系人失败！")
        },
        success: function (result) {
            if (result != null) {
                // alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}


var conditionContacts = function () {
    var contactsName = $("#contacts_name").val();
    var contactsJob = $("#contacts_job").val();
    var contactsOfficeTel = $("#contacts_office_tel").val();
    var contactsMobileTel = $("#contacts_mobile_tel").val();
    var contactsEmail = $("#contacts_email").val();
    var contacts_data = {
        entireId:entireId,
        ueId:null,
        contactsName:contactsName,
        contactsOfficeTel:contactsOfficeTel,
        contactsMobileTel:contactsMobileTel,
        contactsEmail:contactsEmail,
        contactsJob:contactsJob
    }

    return contacts_data;
}

var addContacts = function (condition) {
    // alert(condition+"condition")
    $.ajax({
        url: "/addContacts",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("增加联系人失败！")
        },
        success: function (result) {
            if (result != null) {
                alert("基本信息已保存");
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
    var html_tr = "<tr id='patent_"+(num-1)+"'><td>专利名称</td><td>专利类型*</td><td>专利号</td> <td>获得时间选择</td></tr>"+
        "<tr id='patent_"+num+"'><td><input type='text' id='patent_name_"+patent+"'/></td>"+
        "<td>" +
            "<select id='patent_type_"+patent+"'>" +
            "<option value='1'>发明专利</option>"+
            "<option value='2'>实用新型专利</option>"+
            "<option value='3'>外观设计</option>"+
        "</select>"+
        "</td>"+
        "<td><input type='text' id='patent_num_"+patent+"'/></td>"+
        "<td><input type='text' id='patent_date_"+patent+"'/></td></tr>";
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

var reduceImg = function () {
    // alert("#patent_"+(num+1));
    $("#patent_"+(num+1)).remove();
    $("#patent_"+(num+2)).remove();
}





    /********************************************************************************************************************************
     * 核心团队成员信息-第二步
     */
    var team=2;
    var core=8;
   var addCoreTeamImg= function () {
        var html_tr ="<tr id='core_"+(core-3)+"'><td>姓名</td><td>性别</td> <td>年龄</td><td>职位</td>" +
                "<td>最高学历</td> <td>留学经历</td> <td>入选国家千人计划</td><td>入选时间</td>"+
            "</tr >"+
            "<tr id='core_"+(core-2)+"'>" +
                "<td><input type='text' id='core_name_"+team+"'/></td>"+
                "<td><select  id='core_sex_"+team+"'><option value='男'>男</option>" +
                "<option value='女'>女</option>" + "</select></td>"+
                "<td><input type='text' id='core_age_"+team+"'/></td>"+
                "<td><input type='text' id='core_job_"+team+"'/></td>"+
                "<td><select id='core_education_"+team+"'><option value='学士'>学士</option><option value='硕士'>硕士</option><option value='博士'>博士</option></select></td>"+
                "<td><input type='text' id='core_experience_"+team+"'/></td>"+
                "<td><select  id='core_millennium_"+team+"'><option value='是'>是</option>" +
            "<option value='否'>否</option>" + "</select></td>"+
                "<td id='millennium_date_"+team+"'><input type='text' id='core_millennium_date_"+team+"'/></td>"+
            "</tr>"+
            "<tr id='core_"+(core-1)+"'><td colspan='8'>主要工作经历/主要成就</td></tr>"+
                "<tr id='core_"+core+"'><td colspan='8'><textarea id='main_achive_"+team+"'></textarea></td></tr>";
        // alert(html_tr);
        $("#core_team_table").append(html_tr);

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
   var reduceCoreImg = function () {
    // alert("#patent_"+(num+1));
    $("#core_"+(core+1)).remove();
    $("#core_"+(core+2)).remove();
    $("#core_"+(core+3)).remove();
    $("#core_"+(core+4)).remove();
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

}
$("#hxtd_conservation").click(function () {
    var team_lenfth =  $("#core_team_table").find("tr").length/4;
    alert(team_lenfth);
    for(var i=1;i<=team_lenfth;i++){
        var coreName = $("#core_name_"+i).val();
        var coreSex = $("#core_sex_"+i).val();
        var coreAge = $("#core_age_"+i).val();
        var coreJob = $("#core_job_"+i).val();
        var coreEducation = $("#core_education_"+i).val();
        var coreExperience = $("#core_experience_"+i).val();
        var coreMillennium = $("#core_millennium_"+i).val();
        var coreMillenniumDate = $("#core_millennium_date_"+i).val();
        var mainAchive = $("#main_achive_"+i).val();

        // alert(coreSex);
        if(coreName == "" || coreSex == "" || coreAge == "" || coreJob == "" ||
            coreEducation == "" || coreExperience == "" || mainAchive == "" || coreMillennium == ""){
            alert("请将核心成员信息填写完整！")
        }else {
            if (coreMillennium == "是"){
                if (coreMillenniumDate == ""){
                    alert("请将核心成员信息填写完整！")
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
                        nationalMilleDate:coreMillenniumDate,
                    }
                    addCoreTeam(condition,i);

                }

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
                    ctNationalMillennium:coreMillennium
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
            alert("增加联系人失败！")
        },
        success: function (result) {
            if (result != null) {
                // alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
                $("#hxtd_conservation").unbind('click');
                $("#hxtd_conservation").css("background","#dbdbdb");
                $("#hxtd_conservation").find("p").html("已保存");
            }

        }
    });
}



/******************************************************************************************************
 *第三步，填写商业计划书
 */



$("#syjhs_conservation").click(function () {

    var isEquity = $("#isEquity input:checked").val();
    var equity_investor = $("#equity_investor").val();
    var equity_money = $("#equity_money").val();
    var equity_rate = $("#equity_rate").val();
    var equity_date = $("#equity_date").val();

    var isDebt = $("#isDebt input:checked").val();
    var debt_leader = $("#debt_leader").val();
    var debt_money = $("#debt_money").val();
    var debt_start_time = $("#debt_start_time").val();
    var debt_end_time = $("#debt_end_time").val();



    if($("#pro_name").val() == ""){
        alert("请填写参赛项目名称！")
    }else {
        if(isDebt == "否" && isEquity == "否"){
            var plan_data = conditionUnitBusinessPlan();
            // alert(data);
            addUnitBusinessPlan(plan_data);
            conditionHistorical();
            conditionFore();

            conditionDemand();
        }
        if(isDebt == "是" && isEquity == "否"){
            if(debt_leader == "" || debt_money == "" || debt_start_time == "" || debt_end_time == ""){
                alert("请将债权融资信息补充完整！")
            } else {
                var plan_data = conditionUnitBusinessPlan();
                // alert(data);
                addUnitBusinessPlan(plan_data);
                conditionHistorical();
                conditionFore();

                conditionDemand();

                var unitDebt_data = {
                    ubusId:null,
                    entireId:entireId,
                    debtLeader:debt_leader,
                    debtMoney:debt_money,
                    debtStartTime:comTime(debt_start_time),
                    debtEndTime:comTime(debt_end_time)

                }
                addDebt(unitDebt_data);


            }
        }
        if(isDebt == "否" && isEquity == "是"){
            if(equity_investor == "" || equity_money == "" || equity_rate == "" || equity_date =="") {
                alert("请将股权融资信息补充完整！")
            } else {
                var plan_data = conditionUnitBusinessPlan();
                // alert(data);
                addUnitBusinessPlan(plan_data);
                conditionHistorical();
                conditionFore();

                conditionDemand();

                var unitEquity_data = {
                    ubusId:null,
                    entireId:entireId,
                    equityInvestor:equity_investor,
                    equityMoney:equity_money,
                    equityRate:equity_rate,
                    equityDate:comTime(equity_date)

                }
                addEquity(unitEquity_data);
            }

        }
        if(isDebt == "是" && isEquity == "是"){
            var plan_data = conditionUnitBusinessPlan();
            // alert(data);
            addUnitBusinessPlan(plan_data);
            conditionHistorical();
            conditionFore();

            conditionDemand();

            if(equity_investor == "" || equity_money == "" || equity_rate == "" || equity_date =="" || debt_leader == "" || debt_money == "" || debt_start_time == "" || debt_end_time == "") {
                alert("请将融资信息补充完整！")
            }else {

                var unitEquity_data = {
                    ubusId:null,
                    entireId:entireId,
                    equityInvestor:equity_investor,
                    equityMoney:equity_money,
                    equityRate:equity_rate,
                    equityDate:comTime(equity_date)

                }
                addEquity(unitEquity_data);

                var unitDebt_data = {
                    ubusId:null,
                    entireId:entireId,
                    debtLeader:debt_leader,
                    debtMoney:debt_money,
                    debtStartTime:comTime(debt_start_time),
                    debtEndTime:comTime(debt_end_time)

                }
                addDebt(unitDebt_data);
            }
        }
    }

});



var conditionUnitBusinessPlan=function () {
    /**
     * 增加基本信息
     * @type {any}
     */
    var pro_name = $("#pro_name").val();
    var pro_incomed = $("#pro_incomed").val();
    var pro_type = $("#pro_type input:radio:checked").val();
    var lead_internal = $("#lead_internal input:radio:checked").val();
    var lead_international = $("#lead_international input:radio:checked").val();
    var research_institute = $("#research_institute input:radio:checked").val();

    var institute_name = $("#institute_name").val();
    var pro_picture = $("#pro_picture input:radio:checked").val();
    var major_describe = $("#major_describe").val();
    var pro_market = $("#pro_market").val();
    var bus_model = $("#bus_model").val();
    var ubus_main = $("#ubus_main").val();

    var unitBusinessPlan_data = {
        ueId:null,
        entireId:entireId,
        ubusProName:pro_name,
        ubusProIncomed:pro_incomed,
        ubusProType:pro_type,
        ubusLeadInternal:lead_internal,
        ubusLeadInternational:lead_international,
        ubusResearchInstitute:research_institute,
        instituteName:institute_name,
        ubusProPicture:pro_picture,
        ubusMajorDescribe:major_describe,
        ubusProMarket:pro_market,
        ubusModel:bus_model,
        ubusMain:ubus_main
    }
    return unitBusinessPlan_data;
};
/**
 * 创建商业计划书
 * @param condition
 */
var addUnitBusinessPlan = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/addUnitBusinessPlan",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建商业计划书失败！")
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
 *历史财务数据*/
var conditionHistorical = function () {
    for(var i=2;i<=4;i++){
        var hfin_income=$("hfin_income_"+i).val();
        var hfin_cost=$("hfin_cost_"+i).val();
        var hfin_profit=$("hfin_profit_"+i).val();
        var hfin_profit_rate=$("hfin_profit_rate_"+i).val();
        var hfin_expenses=$("hfin_expenses_"+i).val();
        var operating_profit=$("operating_profit_"+i).val();
        var operating_profit_rate=$("operating_profit_rate_"+i).val();
        var beforeTax_profit=$("beforeTax_profit_"+i).val();
        var net_margin=$("net_margin_"+i).val();
        var fixed_netValue=$("fixed_netValue_"+i).val();
        var assets_total=$("assets_total_"+i).val();
        var liabilites_total=$("liabilites_total_"+i).val();
        var net_asset=$("net_asset_"+i).val();
        var hfin_year = "201"+i;

        var condition = {
            ubusId:null,
            entireId:entireId,
            hfinIncome:hfin_income,
            hfinCost:hfin_cost,
            hfinProfit:hfin_profit,
            hfinBeforeTaxProfit:beforeTax_profit,
            hfinExpenses:hfin_expenses,
            hfinProfitRate:hfin_profit_rate,
            hfinOperatingProfit:operating_profit,
            operatingProfitRate:operating_profit_rate,
            hfinNetMargin:net_margin,
            fixedNetValue:fixed_netValue,
            hfinAssetsTotal:assets_total,
            hfinLialilitesTotal:liabilites_total,
            hfinNetAsset:net_asset,
            hfinYear:hfin_year

        }

        addFinancialHistorical(condition);

    }


};

var addFinancialHistorical = function (condition) {
    $.ajax({
        url: "/addFinancialHistorical",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建历史财务数据失败！")
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
        var fore_cost=$("#fore_cost_"+i).val();
        var tax_expense=$("#tax_expense_"+i).val();
        var fore_profit=$("#fore_profit_"+i).val();
        var profit_rate=$("#profit_rate_"+i).val();
        var net_margin=$("#net_margin_"+i).val();
        var fore_year = "201"+i
        var condition = {
            ubusId:null,
            tbusId:null,
            entireId:entireId,
            foreIncome:fore_income,
            foreCost:fore_cost,
            foreTaxExpense:tax_expense,
            foreProfit:fore_profit,
            foreProfitRate:profit_rate,
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

/*********融资经历**/

var addEquity = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/addEquityFinancing",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建商业计划书失败！")
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



var addDebt = function (condition) {
    // alert(condition);
    $.ajax({
        url: "/addDebtFinancing",
        type: 'post',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("创建债权融资信息失败！")
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

var conditionDemand=function () {
    /**
     * 增加基本信息
     * @type {any}
     */
    var df_isEquity = $("#df_isEquity input:checked").val();

        var df_equity_money = $("#df_equity_money").val();
        var df_equity_shares = $("#df_equity_shares").val();
        var df_equity_date = $("#df_equity_date").val();
        var df_equityFund_plan = $("#df_equityFund_plan").text();
        var df_isEquity_recom = $("#df_isEquity_recom input:checked").val();

    var df_isDebt = $("#df_isDebt input:checked").val();

        var df_debt_money = $("#df_debt_money").val();
        var df_debt_maxAnnual = $("#df_debt_maxAnnual").val();
        var df_debt_date = $("#df_debt_date").val();
        var df_debtFund_plan = $("#df_debtFund_plan").text();
        var df_isDebt_recom = $("#df_isDebt_recom input:checked").val();


   if( $("#choose_crowd input[type='checkbox']").is(':checked') == true) {
       var df_isCrowd_funding = "1";
   }else {
       var df_isCrowd_funding = "0";
   }
   // alert(df_isCrowd_funding+"df_isCrowd_funding");
    var crows_fund_type = $("#crows_fund_type tr td input:checked").val();
    // alert(crows_fund_type);
    if( $("#df_isMerge input[type='checkbox']").is(':checked') == true) {
        var df_isMerge = "1";
    }else {
        var df_isMerge = "0";
    }
    if( $("#df_isListed_shareReform input[type='checkbox']").is(':checked') == true) {
        var df_isListed_shareReform = "1";
    }else {
        var df_isListed_shareReform = "0";
    }

    if( $("#df_isFinancing_guarantee input[type='checkbox']").is(':checked') == true) {
        var df_isFinancing_guarantee = "1";
    }else {
        var df_isFinancing_guarantee = "0";
    }

    if( $("#change_petty input[type='checkbox']").is(':checked') == true) {
        var df_isPetty_loan = "1";
    }else {
        var df_isPetty_loan = "0";
    }
    var petty_loan_money = $("#petty_loan_money").val();

    if( $("#df_company_isDebt input[type='checkbox']").is(':checked') == true) {
        var df_company_isDebt = "1";
    }else {
        var df_company_isDebt = "0";
    }

    if( $("#df_minorEnterprises_isDebt input[type='checkbox']").is(':checked') == true) {
        var df_minorEnterprises_isDebt = "1";
    }else {
        var df_minorEnterprises_isDebt = "0";
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


    if( $("#df_property_assign input[type='checkbox']").is(':checked') == true) {
        var df_property_assign = "1";
    }else {
        var df_property_assign = "0";
    }

    if( $("#df_finace_lease input[type='checkbox']").is(':checked') == true) {
        var df_finace_lease = "1";
    }else {
        var df_finace_lease = "0";
    }

    if( $("#df_technology_insurance input[type='checkbox']").is(':checked') == true) {
        var df_technology_insurance = "1";
    }else {
        var df_technology_insurance = "0";
    }

    if( $("#df_asset_manage input[type='checkbox']").is(':checked') == true) {
        var df_asset_manage = "1";
    }else {
        var df_asset_manage = "0";
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
            dfListedShareReform:df_isListed_shareReform,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfCompanyDebt:df_company_isDebt,
            minorEnterprisesDebt:df_minorEnterprises_isDebt,
            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            dfPropertyAssign:df_property_assign,
            dfFinaceLease:df_finace_lease,
            dfTechnologyInsurance:df_technology_insurance,
            dfAssetManage:df_asset_manage,
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
            dfListedShareReform:df_isListed_shareReform,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfCompanyDebt:df_company_isDebt,
            minorEnterprisesDebt:df_minorEnterprises_isDebt,
            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            dfPropertyAssign:df_property_assign,
            dfFinaceLease:df_finace_lease,
            dfTechnologyInsurance:df_technology_insurance,
            dfAssetManage:df_asset_manage,
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
            dfListedShareReform:df_isListed_shareReform,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfCompanyDebt:df_company_isDebt,
            minorEnterprisesDebt:df_minorEnterprises_isDebt,
            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            dfPropertyAssign:df_property_assign,
            dfFinaceLease:df_finace_lease,
            dfTechnologyInsurance:df_technology_insurance,
            dfAssetManage:df_asset_manage,
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
            dfEquity:df_isEquity,

            dfDebt:df_isDebt,
            dfDebtMoney:df_debt_money,
            debtMaxAnnual:df_debt_maxAnnual,
            dfDebtDate:comTime(df_debt_date),
            debtFundPlan:df_debtFund_plan,
            dfDebtRecom:df_isDebt_recom,
            dfCrowdFunding:df_isCrowd_funding,
            crowsFundType:crows_fund_type,
            dfMerge:df_isMerge,
            dfListedShareReform:df_isListed_shareReform,
            dfFinancingGuarantee:df_isFinancing_guarantee,
            dfPettyLoan:df_isPetty_loan,
            pettyLoanMoney:petty_loan_money,

            dfCompanyDebt:df_company_isDebt,
            minorEnterprisesDebt:df_minorEnterprises_isDebt,
            dfTechnicalImport:df_technical_import,
            technicalImportInternational:technical_import_international,
            technicalDescInternational:technical_desc_international,
            technicalImportInternal:technical_import_internal,
            technicalDescInternal:technical_desc_internal,
            dfTechnicalTransfer:df_technical_transfer,
            technicalTransferRange:technical_transfer_range,
            dfPropertyAssign:df_property_assign,
            dfFinaceLease:df_finace_lease,
            dfTechnologyInsurance:df_technology_insurance,
            dfAssetManage:df_asset_manage,
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
                // alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
                $("#syjhs_conservation").unbind('click');
                $("#syjhs_conservation").css("background","#dbdbdb");
                $("#syjhs_conservation").find("p").html("已保存");
            }

        }
    });

}