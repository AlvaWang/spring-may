/**
 * Created by Administrator on 2017/4/30.
 */

$(function () {
    $("#first_table").show();
    $("#second_table").hide();
    $("#third_table").hide();

    $(".streamer_jbxx").show();
    $(".streamer_hxtd").hide();
    $(".streamer_syjhs").hide();

    $("#jbxx_conservation").show();
    $("#hxtd_conservation").hide();
    $("#syjhs_conservation").hide();

    $("#patent_table").find("input,div,button,textarea,select").attr("disabled", "disabled");
    $("#patent_table").find("input,div,button,textarea,select").css("background","#dbdbdb")
    $("#patent_table").css("background","#dbdbdb")
});
$("#first_btn").click(function () {
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
    $("#second_table").show();
    $("#first_table").hide();
    $("#third_table").hide();

    $(".streamer_hxtd").show();
    $(".streamer_jbxx").hide();
    $(".streamer_syjhs").hide();

    $("#hxtd_conservation").show();
    $("#jbxx_conservation").hide();
    $("#syjhs_conservation").hide();
})
$("#third_btn").click(function () {
    $("#third_table").show();
    $("#second_table").hide();
    $("#first_table").hide();

    $(".streamer_syjhs").show();
    $(".streamer_jbxx").hide();
    $(".streamer_hxtd").hide();

    $("#syjhs_conservation").show();
    $("#jbxx_conservation").hide();
    $("#hxtd_conservation").hide();
})


var change_patent_table = function () {
    var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
    if(patent_choose == true){
        $("#patent_table").find("input,div,button,textarea,select").removeAttr("disabled");
        $("#patent_table").find("input,div,button,textarea,select").css("background","#ffffff")
        $("#patent_table").css("background","#ffffff")
    }else {
        $("#patent_table").find("input,div,button,textarea,select").attr("disabled", "disabled");
        $("#patent_table").find("input,div,button,textarea,select").css("background","#dbdbdb")
        $("#patent_table").css("background","#dbdbdb")
    }
};


var entireId = GetQueryString("entireId");
// alert(entireId);

/***********************************************************************************************************************
 * 基本信息第一步
 */


$("#jbxx_conservation").click(function () {
    // alert(entireId)
    getUnitEssentialByEntireId(entireId);
    getLegalRepresentativeByEntireId(entireId);
    getContactsByEntireId(entireId);
    var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
    if(patent_choose == true){
        for(var i=1;i<=patent;i++){

            var patentNum = $("#patent_num_"+i).val();
            var patentType =$("#patent_type_"+i).val();
            // alert(patentType);
            var patentName = $("#patent_name_"+i).val();
            var patentDate = $("#patent_date_"+i).val();
            if(patentNum == "" || patentType == "" || patentNum ==""
                || patentDate == ""){
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
                    patentDate:patentDate
                }
                getPatentListByPatentId(condition,data);
            }

        }
    }
});
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
 * 查询对应作品ID是否被创建基本信息
 */
var getUnitEssentialByEntireId = function (condition) {

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
                alert(result+"essential");
                /**
                 * 存在ID更新
                 */
                var data = updateUnitEssential_data();
                updateUnitEssential(data,result)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                var data = conditionEssential();
                // alert(data);
                addUnitEssential(data);

            }

        }
    });

}

var updateUnitEssential_data = function () {
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
}
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
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });

}

var updateUnitEssential = function (condition,ueId) {

    $.ajax({
        url: "/updateEssential/"+ueId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
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

/**
 * 查询对应作品ID是否被法定代表人
 */
var getLegalRepresentativeByEntireId = function (condition) {

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
                alert(result+"legal");
                /**
                 * 不存在ID创建
                 */
                var data = conditionLegal_update();
                updateLegalRepresentative(data,result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                var data = conditionLegal();
                // alert(data);
                addLegalRepresentative(data);

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
var conditionLegal_update = function () {
    var legalName = $("#legal_name").val();
    var legalJob = $("#legal_job").val();
    var legalOfficeTel = $("#legal_office_tel").val();
    var legalMobileTel = $("#legal_mobile_tel").val();
    var legalEmail = $("#legal_email").val();
    var legal_data = {
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
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}
var updateLegalRepresentative = function (condition,legalId) {

    $.ajax({
        url: "/updateLegalRepresentative/"+legalId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
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

/**
 * 查询对应作品ID是否有联系人
 */
var getContactsByEntireId = function (condition) {

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
                // alert(result+"contacts");
                /**
                 * 不存在ID创建
                 */
                var data = conditionContacts_data();
                updateContacts(data,result)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                var data = conditionContacts();
                // alert(data);
                addContacts(data);

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
var conditionContacts_data = function () {
    var contactsName = $("#contacts_name").val();
    var contactsJob = $("#contacts_job").val();
    var contactsOfficeTel = $("#contacts_office_tel").val();
    var contactsMobileTel = $("#contacts_mobile_tel").val();
    var contactsEmail = $("#contacts_email").val();
    var contacts_data = {
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
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}
var updateContacts = function (condition,contactsId) {

    $.ajax({
        url: "/updateContacts/"+contactsId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
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

/**
 查询专利号看是否增加*/
var getPatentListByPatentId=function (condition,data) {
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
                alert(result+"patentList");
                /**
                 * 存在ID更新
                 */
                // var data;
                // updateUnitEssential(data)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 不存在创建
                 */
                // conditionPatent(patentNum);
                // alert(data);
                addPatentList(data);
            }

        }
    });
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
            alert("增加联系人失败！")
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
                "<td><input type='text' id='core_education_"+team+"'/></td>"+
                "<td><input type='text' id='core_experience_"+team+"'/></td>"+
                "<td><select  id='core_millennium_"+team+"'><option value='是'>是</option>" +
            "<option value='否'>否</option>" + "</select></td>"+
                "<td><input type='text' id='core_millennium_date_"+team+"'/></td>"+
            "</tr>"+
            "<tr id='core_"+(core-1)+"'><td colspan='8'>主要工作经历/主要成就</td></tr>"+
                "<tr id='core_"+core+"'><td colspan='8'><textarea id='main_achive_"+team+"'></textarea></td></tr>";
        // alert(html_tr);
        $("#core_team_table").append(html_tr);
    }
   var reduceCoreImg = function () {
    // alert("#patent_"+(num+1));
    $("#core_"+(core+1)).remove();
    $("#core_"+(core+2)).remove();
    $("#core_"+(core+3)).remove();
    $("#core_"+(core+4)).remove();
}

$("#hxtd_conservation").click(function () {
    for(var i=1;i<=team;i++){
        var coreName = $("#core_name_"+i).val();
        var coreSex = $("#core_sex_"+i).val();
        var coreAge = $("#core_age_"+i).val();
        var coreJob = $("#core_job_"+i).val();
        var coreEducation = $("#core_education_"+i).val();
        var coreExperience = $("#core_experience_"+i).val();
        var coreMillennium = $("#core_millennium_"+i).val();
        var coreMillenniumDate = $("#core_millennium_date"+i).val();
        var mainAchive = $("#main_achive_"+i).val();

        // alert(coreSex);
        if(coreName == "" || coreSex == "" || coreAge == "" || coreJob == "" ||
            coreEducation == "" || coreExperience == "" || coreMillennium == "" || coreMillenniumDate == "" ||
            mainAchive == "" ){
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
            addCoreTeam(condition);

        }

    }
});
var addCoreTeam=function (condition) {
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
                alert(result);
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }

        }
    });
}



/******************************************************************************************************
 *第三步，填写商业计划书
 */



$("#syjhs_conservation").click(function () {
    getUnitBusinessPlanByEntireId(entireId);
    getFinancialHistoricalByEntireId(entireId);
    getFinancialForecastingByEntireId(entireId);
    getEquityEntireId(entireId);
    getDebtEntireId(entireId);
    geDemandEntireId(entireId);
});

/**
* 查询对应作品ID是否被商业计划书
*/
var getUnitBusinessPlanByEntireId = function (condition) {

    $.ajax({
        url: "/getUnitBusinessPlanByEntireId/"+condition,
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
                alert(result+"unitBus");
                /**
                 * 不存在ID创建
                 */
                // var data;
                // updateUnitEssential(data)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                var data = conditionUnitBusinessPlan();
                // alert(data);
                addUnitBusinessPlan(data);

            }

        }
    });

}

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

var getFinancialHistoricalByEntireId = function (data) {

    $.ajax({
        url: "/getHistoricalByEntireId/"+data,
        type: 'get',
        async: true,
        data: data,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            // alert(result);
            if (result>0) {
                alert(result+"historical");
                /**
                 * 不存在ID创建
                 */
                // var data;
                // updateUnitEssential(data)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                // alert(data);
                conditionHistorical()

            }

        }
    });

}
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
        var fore_income=$("fore_income_"+i).val();
        var fore_cost=$("fore_cost_"+i).val();
        var tax_expense=$("tax_expense_"+i).val();
        var fore_profit=$("fore_profit_"+i).val();
        var profit_rate=$("profit_rate_"+i).val();
        var net_margin=$("net_margin_"+i).val();
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
var getFinancialForecastingByEntireId = function (data) {

    $.ajax({
        url: "/getForecastingByEntireId/"+data,
        type: 'get',
        async: true,
        data: data,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            // alert(result);
            if (result>0) {
                alert(result+"forecasting");
                /**
                 * 不存在ID创建
                 */
                // var data;
                // updateUnitEssential(data)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                // alert(data);
                conditionFore();

            }

        }
    });

}
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
var getEquityEntireId = function (condition) {

    $.ajax({
        url: "/getEquityFinancingByEntireId/"+condition,
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
                alert(result+"equity");
                /**
                 * 不存在ID创建
                 */
                // var data;
                // updateUnitEssential(data)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                var data = conditionEquity();
                // alert(data);
                addEquity(data);

            }

        }
    });

}

var conditionEquity=function () {
    /**
     * 增加基本信息
     * @type {any}
     */
    var equity_investor = $("#equity_investor").val();
    var equity_money = $("#equity_money").val();
    var equity_rate = $("#equity_rate").val();
    var equity_date = $("#equity_date").val();

    var unitEquity_data = {
        ubusId:null,
        entireId:entireId,
        equityInvestor:equity_investor,
        equityMoney:equity_money,
        equityRate:equity_rate,
        equityDate:comTime(equity_date)

    }
    return unitEquity_data;
};
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



var getDebtEntireId = function (condition) {

    $.ajax({
        url: "/getDebtFinancingByEntireId/"+condition,
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
                alert(result+"equity");
                /**
                 * 不存在ID创建
                 */
                // var data;
                // updateUnitEssential(data)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                var data = conditionDebt();
                // alert(data);
                addDebt(data);

            }

        }
    });

}

var conditionDebt=function () {
    /**
     * 增加基本信息
     * @type {any}
     */
    var debt_leader = $("#debt_leader").val();
    var debt_money = $("#debt_money").val();
    var debt_start_time = $("#debt_start_time").val();
    var debt_end_time = $("#debt_end_time").val();

    var unitDebt_data = {
        ubusId:null,
        entireId:entireId,
        debtLeader:debt_leader,
        debtMoney:debt_money,
        debtStartTime:comTime(debt_start_time),
        debtEndTime:comTime(debt_end_time)

    }
    return unitDebt_data;
};
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
var geDemandEntireId = function (condition) {

    $.ajax({
        url: "/getDemandByEntireId/"+condition,
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
                alert(result+"demand");
                /**
                 * 不存在ID创建
                 */
                // var data;
                // updateUnitEssential(data)
                // window.location.href = "/registerSuccess?id=" + result + "";
                // comId = result;
            }else {
                /**
                 * 存在ID，更新
                 */
                var data = conditionDemand();
                // alert(data);
                addDemand(data);

            }

        }
    });

}

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


    var df_isCrowd_funding = $("#df_isCrowd_funding  input:checked").val();
    var crows_fund_type = $("#crows_fund_type tr td input:checked").val();
    // alert(crows_fund_type);
    var df_isMerge = $("#df_isMerge input:checked").val();
    var df_isListed_shareReform = $("#df_isListed_shareReform input:checked").val();
    var df_isFinancing_guarantee = $("#df_isFinancing_guarantee input:checked").val();
    var df_isPetty_loan = $("#df_isPetty_loan input:checked").val();
    var petty_loan_money = $("#petty_loan_money").val();
    var df_company_isDebt = $("#df_company_isDebt input:checked").val();

    var df_minorEnterprises_isDebt = $("#df_minorEnterprises_isDebt input:checked").val();
    var df_technical_import = $("#df_technical_import input:checked").val();
    var technical_import_international = $("#technical_import_international input:checked").val();
    var technical_desc_international = $("#technical_desc_international").val();
    var technical_import_internal = $("#technical_import_internal input:checked").val();
    var technical_desc_internal = $("#technical_desc_internal").val();
    var df_technical_transfer = $("#df_technical_transfer input:checked").val();
    var technical_transfer_range = $("#technical_transfer_range").val();

    var df_property_assign = $("#df_property_assign input:checked").val();
    var df_finace_lease = $("#df_finace_lease input:checked").val();
    var df_technology_insurance = $("#df_technology_insurance input:checked").val();
    var df_asset_manage = $("#df_asset_manage input:checked").val();
    var df_branchChong_check = $("#df_branchChong_check input:checked").val();
    var df_political_consult = $("#df_political_consult input:checked").val();
    var df_technology_consult = $("#df_technology_consult input:checked").val();
    var df_intermediary_consult = $("#df_intermediary_consult input:checked").val();

    var intermediary_law = $("#intermediary_law input:checked").val();
    var intermediary_law_desc = $("#intermediary_law_desc").val();
    var intermediary_finance = $("#intermediary_finance input:checked").val();
    var intermediary_finance_desc = $("#intermediary_finance_desc").val();
    var intermediary_Financing = $("#intermediary_Financing input:checked").val();
    var intermediary_financing_desc = $("#intermediary_financing_desc").val();
    var intermediary_manage = $("#intermediary_manage input:checked").val();
    var intermediary_manage_desc = $("#intermediary_manage_desc").val();
    var df_other_service = $("#df_other_service input:checked").val();

    var other_service_desc = $("#other_service_desc").val();
    var df_accept_train = $("#df_accept_train  input:checked").val();
    var df_no = $("#df_no  input:checked").val();
    alert(df_equity_date)
    var unitDemand_data = {
        ubusId:null,
        tbusId:null,
        dfEquity:entireId,
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
    return unitDemand_data;
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
            }

        }
    });

}