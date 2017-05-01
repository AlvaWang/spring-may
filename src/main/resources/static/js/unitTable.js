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
                var data = conditionEssential();
                // alert(data);
                addUnitEssential(data);

            }

        }
    });

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

var updateUnitEssential = function (condition) {

    $.ajax({
        url: "/getUnitEssentialByEntireId/"+condition,
        type: 'get',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
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
                // var data;
                // updateUnitEssential(data)
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
                alert(result+"contacts");
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
    conditionHistorical();
    conditionFore()
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
        var hfin_year = "201"+i
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