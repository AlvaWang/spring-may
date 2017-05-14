/**
 * Created by Administrator on 2017/4/30.
 */
var entireId = GetQueryString("entireId");
var comName = GetQueryString("comName");

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

    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").attr("disabled", "disabled");
    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").css("background","#dbdbdb");
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").attr("disabled", "disabled");
    $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").css("background","#dbdbdb");

    getTeamEssentialList(entireId);
    getResponsibleListByEntireId(entireId)
    getPatentListByEntireId(entireId);
    getCoreTeamListByEntireId(entireId);
    getTeamBusinessPlanConditionByEntireId(entireId)

    getForecastingListByEntireId(entireId);

    getDemandListByEntireId(entireId)
});

var getTeamEssentialList = function (entireId) {
    $.ajax({
        url: "/getTeamEssentialListByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result);
            if (result != null) {
                $("#teId").val(result.teId);
                $("#team_name").val(result.teamName);
                $("#te_pro_name").val(result.teProName);
                $(":radio[name='goal'][value='" + result.teCompatitionGoal + "']").prop("checked", "checked");//根据value值选中vidio
                $(":radio[name='field'][value='" + result.teIndustryFild + "']").prop("checked", "checked");
                $(":radio[name='stage'][value='" + result.teProStage + "']").prop("checked", "checked");
                var area = result.teAdminStrativeArea.split("省")
                console.log(area);
                $("#admin_area_province").val(area[0]);
                var city = area[1].split("市")
                $("#admin_area_city").val(city[0]);
                $("#win_num").val(result.ueWinNum);
                $("#te_address").val(result.teAddress);
                $("#te_postalcode").val(result.tePostalcode);
                $("#te_pro_outline").val(result.teProOutline);
                $("#te_key_word").val(result.teKeyWord);
                var timeCompany = new Date(result.companyFundTime);
                var cyear = timeCompany.getFullYear()
                var cmonth = timeCompany.getMonth()+1
                var cday = timeCompany.getDate()
                $("#company_year").val(cyear)
                $("#company_month").val(cmonth)
                $("#company_day").val(cday)

                var timeTeam = new Date(result.teamFundTime);
                var tyear = timeTeam.getFullYear()
                var tmonth = timeTeam.getMonth()+1
                var tday = timeTeam.getDate()
                $("#team_year").val(tyear)
                $("#team_month").val(tmonth)
                $("#team_day").val(tday)

                $(":radio[name='code'][value='" + result.tePowerType + "']").prop("checked", "checked");
                $(":radio[name='source'][value='" + result.teTechnicalSource + "']").prop("checked", "checked");

                if($("#post_code input:checked").val() == ""){
                    $(":radio[name='code'][value='其它']").prop("checked", "checked");
                    $("#powerType").val(result.tePowerType)
                }
                if($("#te_compatition_goal input:checked").val() == ""){
                    $(":radio[name='code'][value='其它']").prop("checked", "checked");
                    $("#teGoal").val(result.teCompatitionGoal)
                }


            }

        }
    });
}

var getResponsibleListByEntireId = function (entireId) {
    $.ajax({
        url: "/getResponsibleListByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result);
            if (result != null) {
                $("#teamId").val(result.resId);
                $("#res_name").val(result.resName);
                $("#res_job").val(result.resJob);
                $("#document_num").val(result.documentNum);
                $("#res_office_tel").val(result.resOfficeTel);
                $("#res_email").val(result.resEmail);
                $("#res_mobile_tel").val(result.resMobileTel);
                $("#res_document_type").val(result.resDocumentType)


                // alert($("#contactsId").val()+"contacts")
            }

        }
    });
}

var patent=0;
var num =0;
var getPatentListByEntireId = function (entireId) {
    $.ajax({
        url: "/getPatentListByEntireId/"+entireId,
        type: 'post',
        async: true,
        data: entireId,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result.data.data);
           if(result.data.data.length>0){
               $(":checkbox[name='patent'][value='专利']").prop("checked", "checked");
               $("#patent_table").find("tr,td,input,div,button,textarea,select").removeAttr("disabled");
               $("#patent_table").find("tr,td").css("background","#ecf7fd");
               $("#patent_table").find(".img_tr td,div").css("background","#a8daf3");
               $("#patent_table").find("input,textarea,select").css("background","#ffffff");
               $("#patent_table").css("background","#ecf7fd");

               for(var i=0;i<result.data.data.length;i++){
                   patent=patent+1;
                   num = num+3;
                   var patentList = result.data.data;
                   var html_tr = "<tr id='patent_"+(num-2)+"'><td>专利名称</td><td>专利类型*</td><td>专利号</td> <td>获得时间选择</td><td>核验</td></tr>"+
                       "<tr id='patent_"+(num-1)+"'><td><input type='text' id='patent_name_"+patent+"' value='"+patentList[i].patentName+"'/></td>"+
                       "<td>" +
                       "<select id='patent_type_"+patent+"'>" +
                       "<option value='1'>发明专利</option>"+
                       "<option value='2'>实用新型专利</option>"+
                       "<option value='3'>外观设计</option>"+
                       "</select>"+
                       "</td>"+
                       "<td><input type='text' id='patent_num_"+patent+"' value='"+patentList[i].patentId+"'/></td>"+
                       "<td><input type='text' id='patent_date_"+patent+"' value='"+stampToStandard(patentList[i].patentDate)+"'/></td>" +
                       "<td><input type='text' id='patent_verification_"+patent+"' value='"+patentList[i].patentVerification+"'/></td>" +
                       "</tr>"+
                       "<tr hidden='hidden' id='patent_"+num+"'><td><input id='patentId_"+patent+"' value='"+patentList[i].id+"'/></td></tr>";
                   $("#patent_table table").append(html_tr);

                   $("#patent_type_").val(patentList[i].patentType)

               }
           }

        }
    });
}

var team = 0;
var core = 0;
var edu=0;
var getCoreTeamListByEntireId = function (entireId) {
    $.ajax({
        url: "/getCoreTeamListByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result.data.data);
            var coreTeamList = result.data.data;
            if(coreTeamList.length>0){
                for(var i = 0;i<coreTeamList.length;i++){

                    team = team+1;
                    core =core+6;
                    edu = edu+1;
                    getEducationListByCtId(coreTeamList[i].ctId);
                    var html_tr ="<tr id='core_"+(core-5)+"'><td><input type='text' id='ctId_"+team+"' value='"+coreTeamList[i].ctId+"'/></td></tr>"+
                        "<tr id='core_"+(core-4)+"'><td>姓名</td><td>性别</td> <td>年龄</td><td>职位</td>" +
                        "<td>最高学历</td> <td>留学经历</td> <td>入选国家千人计划</td><td>入选时间</td><td>大学生创业</td>"+
                        "</tr >"+
                        "<tr id='core_"+(core-3)+"'>" +
                        "<td><input type='text' id='core_name_"+team+"' value='"+coreTeamList[i].ctName+"'/></td>"+
                        "<td>" +
                        "<select  id='core_sex_"+team+"'>" +
                        "<option value='男'>男</option>" +
                        "<option value='女'>女</option>" +
                        "</select>" +
                        "</td>"+
                        "<td><input type='number' id='core_age_"+team+"' value='"+coreTeamList[i].ctAge+"'/></td>"+
                        "<td><input type='text' id='core_job_"+team+"'  value='"+coreTeamList[i].ctJob+"'/></td>"+
                        "<td><select id='core_education_"+team+"'><option value='学士'>学士</option><option value='硕士'>硕士</option><option value='博士'>博士</option></select></td>"+
                        "<td><input type='text' id='core_experience_"+team+"' value='"+coreTeamList[i].ctStudyExperience+"'/></td>"+
                        "<td>" +
                        "<select  id='core_millennium_"+team+"'>" +
                        "<option value='是'>是</option>" +
                        "<option value='否'>否</option>" +
                        "</select>" +
                        "</td>"+
                        "<td id='millennium_date_"+team+"'><input type='text' id='core_millennium_date_"+team+"' id='core_millennium_date_"+team+"'/></td>"+
                        "<td><select id='ct_university_business_"+team+"'><option value='是'>是</option><option value='否'>否</option></select></td>"+

                        "</tr>"+
                        "<tr id='core_"+(core-2)+"'>" +
                        "<td  colspan='9'>" +
                        "<table id='append_education_"+team+"'>" +
                        "<tr><td colspan='3'>教育经历可增加</td></tr>" +
                        "<tr class='img_tr'>" +
                        "<td colspan='3'>" +
                        "<div><img src=\"img/zengjia.png\"  id='addEducationImg"+(core-2)+"'/>增加</div>"+
                        "<div><img src=\"img/shanchu.png\"  id='reduceEducationImg"+(core-2)+"'/>减少</div>"+
                        "</td>" +
                        "</tr>"+
                        "<tr><td>学历</td><td>毕业学校</td><td>专业</td></tr>"+

                        "</table>"+
                        "</td>" +
                        "</tr>"+

                        "<tr id='core_"+(core-1)+"'><td colspan='9'>主要工作经历/主要成就</td></tr>"+
                        "<tr id='core_"+core+"'><td colspan='9'><textarea id='main_achive_"+team+"' value='"+coreTeamList[i].ctMainAchive+"'>"+coreTeamList[i].ctMainAchive+"</textarea></td></tr>";
                    // alert(html_tr);
                    $("#core_team_table").append(html_tr);

                    $("#core_sex_"+team).val(coreTeamList[i].ctSex);
                    $("#core_education_"+team).val(coreTeamList[i].ctHigbestEducation);
                    $("#core_millennium_"+team).val(coreTeamList[i].ctNationalMillennium);
                    $("#ct_university_business_"+team).val(coreTeamList[i].ctUniversityBusiness);


                    if(coreTeamList[i].ctNationalMillennium == "是"){
                        $("#core_millennium_date_"+team).val(stampToStandard(coreTeamList[i].nationalMilleDate));
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
            }

        }
    });
}
var getEducationListByCtId = function (ctId) {
    $.ajax({
        url: "/getEducationListByCtId/"+ctId,
        type: 'get',
        async: true,
        data:ctId,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result.data.data);
            var educationList = result.data.data;
            if(educationList.length>0){
                for(var i = 0;i<educationList.length;i++){
                    var html_tr =
                        "<tr id='education_"+(core-2)+"_"+team+"_1' value='"+educationList[i].eduId+"'>" +
                        "<td><input type='text' id='edu_background_"+(core-2)+"_"+team+"_"+edu+"' value='"+educationList[i].eduBackground+"'/></td>"+
                        "<td><input type='text' id='edu_graduate_school_"+(core-2)+"_"+team+"_"+edu+"' value='"+educationList[i].eduGraduateSchool+"'/></td>"+
                        "<td><input type='text' id='edu_major_"+(core-2)+"_"+team+"_"+edu+"' value='"+educationList[i].eduMajor+"'/></td>"+
                        "</tr>";
                    // alert(html_tr);
                    $("#append_education_"+team).append(html_tr);
                }


            }

        }
    });
}

var getTeamBusinessPlanConditionByEntireId = function (entireId) {
    $.ajax({
        url: "/getUnitBusinessPlanConditionByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result);
            if (result != null) {
                $("#ubusId").val(result.ubusId);
                $("#pro_name").val(result.ubusProName);
                $("#pro_incomed").val(result.ubusProIncomed);
                $(":radio[name='type'][value='" + result.ubusProType + "']").prop("checked", "checked");//根据value值选中vidio
                $(":radio[name='internal'][value='" + result.ubusLeadInternal + "']").prop("checked", "checked");
                $(":radio[name='international'][value='" + result.ubusLeadInternational + "']").prop("checked", "checked");
                $(":radio[name='research'][value='" + result.ubusResearchInstitute + "']").prop("checked", "checked");
                if(result.ubusResearchInstitute == "有"){
                    $("#institute_name").val(result.instituteName);
                }
                $(":radio[name='picture'][value='" + result.ubusProPicture + "']").prop("checked", "checked");
                $("#major_describe").text(result.ubusMajorDescribe);
                $("#pro_market").text(result.ubusProMarket);
                $("#bus_model").text(result.ubusModel);
                $("#ubus_main").text(result.ubusMain);
                
            }

        }
    });
}



var getForecastingListByEntireId = function (entireId) {
    $.ajax({
        url: "/getForecastingListByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result.data.data);
            var foreData = result.data.data;
            if(result.data.data.length>0){
                for(var i =0;i<foreData.length;i++){
                    var year = result.data.data[i].foreYear.substring(3);
                    $("#foreId_"+year).val(foreData[i].foreId);
                    $("#fore_income_"+year).val(foreData[i].foreIncome);
                    $("#fore_cost_"+year).val(foreData[i].foreCost);
                    $("#tax_expense_"+year).val(foreData[i].foreTaxExpense);
                    $("#fore_profit_"+year).val(foreData[i].foreProfit);
                    $("#profit_rate_"+year).val(foreData[i].foreProfitRate);
                    $("#net_margin_"+year).val(foreData[i].foreNetMargin);
                }

            }

        }
    });
}

var getDemandListByEntireId = function (entireId) {
    $.ajax({
        url: "/getDemandListByEntireId/"+entireId,
        type: 'get',
        async: true,
        data: entireId,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            console.log(result);
            if (result != null && result != "") {
                $("#demandId").val(result.dfId);
               if (result.dfEquity == "是"){
                   $(":radio[name='df_equity'][value='是']").prop("checked", "checked");
                   $("#df_equity_money").val(result.dfEquityMoney)
                   $("#df_equity_shares").val(result.dfEquityShares)
                   $("#df_equity_date").val(stampToStandard(result.dfEquityDate))
                   $("#df_equityFund_plan").text(result.equityFundPlan)
                   $(":radio[name='equity_recom'][value='"+result.dfEquityRecom+"']").prop("checked", "checked");
                   $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").removeAttr("disabled");
                   $("#technology").find(".df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").css("background","#ffffff");
                   $("#technology").find(".df_equity_yes,.df_equity_yes td").css("background","#ecf7fd");
                }else {
                   $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").attr("disabled", "disabled");
                   $("#technology").find(".df_equity_yes,.df_equity_yes td,.df_equity_yes td input,.df_equity_yes td div input,#df_equityFund_plan").css("background","#dbdbdb");
               }
                if (result.dfDebt == "是"){
                    $(":radio[name='df_debt'][value='是']").prop("checked", "checked");
                    $("#df_debt_money").val(result.dfDebtMoney)
                    $("#df_debt_maxAnnual").val(result.debtMaxAnnual)
                    $("#df_debt_date").val(stampToStandard(result.dfDebtDate))
                    $("#df_equityFund_plan").text(result.debtFundPlan)
                    $(":radio[name='debt_recom'][value='"+result.dfDebtRecom+"']").prop("checked", "checked");

                    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").removeAttr("disabled");
                    $("#technology").find(".df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").css("background","#ffffff");
                    $("#technology").find(".df_debt_yes,.df_debt_yes td").css("background","#ecf7fd");
                }else {
                    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").attr("disabled", "disabled");
                    $("#technology").find(".df_debt_yes,.df_debt_yes td,.df_debt_yes td input,.df_debt_yes td div input,#df_debtFund_plan").css("background","#dbdbdb");
                }
                if(result.dfCrowdFunding == "1"){
                    $(":checkbox[name='crowd_title'][value='众筹']").prop("checked", "checked");
                    $(":checkbox[name='crowd'][value='"+result.crowsFundType+"']").prop("checked", "checked");

                    $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").removeAttr("disabled");
                    $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr,#crows_fund_type td").css("background","#ecf7fd")
                    $("#crows_fund_type tr td input").css("background","#fff")
                }else {
                    $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").attr("disabled", "disabled");
                    $(".crowd_td,.crowd_td #crows_fund_type,#crows_fund_type tr td input,#crows_fund_type tr,#crows_fund_type td").css("background","#dbdbdb")
                }

                if(result.dfMerge == "1"){
                    $(":checkbox[name='marge'][value='并购']").prop("checked", "checked");
                }

                if(result.dfListedShareReform == "1"){
                    $(":checkbox[name='reform'][value='上市股改']").prop("checked", "checked");
                }

                if(result.dfFinancingGuarantee == "1"){
                    $(":checkbox[name='guarantee'][value='融资担保']").prop("checked", "checked");
                }

                if(result.dfPettyLoan == "1"){
                    $(":checkbox[name='petty'][value='小额贷款']").prop("checked", "checked");
                    $("#petty_loan_money").val(result.pettyLoanMoney);

                    $(".pettyMoney,.pettyMoney input").removeAttr("disabled");
                    $(".pettyMoney input").css("background","#ffffff")
                    $(".pettyMoney").css("background","#ecf7fd")
                }else {
                    $(".pettyMoney,.pettyMoney input").attr("disabled", "disabled");
                    $(".pettyMoney,.pettyMoney input").css("background","#dbdbdb")
                }

                if(result.dfCompanyDebt == "1"){
                    $(":checkbox[name='companyDebt'][value='企业债券发行']").prop("checked", "checked");
                }

                if(result.minorEnterprisesDebt == "1"){
                    $(":checkbox[name='minorEnterprisesDebt'][value='中小企业集合债券发行']").prop("checked", "checked");
                }

                if(result.dfTechnicalImport == "1"){
                    $(":checkbox[name='technicalImport'][value='技术引进']").prop("checked", "checked");
                    $("#importTechnical,#technical_import_range").removeAttr("disabled");
                    $("#technical_import_range").find("tr td input").removeAttr("disabled");
                    $("#technical_import_range").find("tr td input").css("background","#ffffff")
                    $("#importTechnical,#technical_import_range,#technical_import_international,#technical_import_internal").css("background","#ecf7fd")
                    $("#technical_import_range").find("tr,td").css("background","#ecf7fd")

                    if(result.technicalDescInternational == "国际技术范围"){
                        $(":checkbox[name='tecInternational'][value='国际技术范围']").prop("checked", "checked");
                        $("#technical_desc_international").val(result.technicalDescInternational);
                    }
                    if(result.technicalDescInternal == "国际技术范围"){
                        $(":checkbox[name='tecInternal'][value='国内技术范围']").prop("checked", "checked");
                        $("#technical_desc_internal").val(result.technicalDescInternal);
                    }
                }else {
                    $("#importTechnical,#technical_import_range").attr("disabled", "disabled");
                    $("#importTechnical,#technical_import_range").css("background","#dbdbdb")
                    $("#technical_import_range").find("tr, td ,input").attr("disabled", "disabled");
                    $("#technical_import_range").find("tr ,td ,input").css("background","#dbdbdb")
                }

                if(result.dfTechnicalTransfer == "1"){
                    $(":checkbox[name='transfer'][value='技术转让']").prop("checked", "checked");
                    $("#technical_transfer_range").val(result.technicalTransferRange)
                    $(".transferTechnical,.transferTechnical input").removeAttr("disabled");
                    $(".transferTechnical,.transferTechnical input").css("background","#ffffff")
                }else {
                    $(".transferTechnical,.transferTechnical input").attr("disabled", "disabled");
                    $(".transferTechnical,.transferTechnical input").css("background","#dbdbdb")
                }

                if(result.dfPropertyAssign == "1"){
                    $(":checkbox[name='assign'][value='产权转让']").prop("checked", "checked");
                }
                if(result.dfFinaceLease == "1"){
                    $(":checkbox[name='lease'][value='金融租赁']").prop("checked", "checked");
                }
                if(result.dfTechnologyInsurance == "1"){
                    $(":checkbox[name='insurance'][value='科技保险']").prop("checked", "checked");
                }
                if(result.dfAssetManage == "1"){
                    $(":checkbox[name='assetManage'][value='资产管理']").prop("checked", "checked");
                }
                if(result.branchChongCheck == "1"){
                    $(":checkbox[name='branch'][value='入住科创园区']").prop("checked", "checked");
                }
                if(result.dfPoliticalConsult == "1"){
                    $(":checkbox[name='political'][value='政策咨询']").prop("checked", "checked");
                }
                if(result.dfTechnologyConsult == "1"){
                    $(":checkbox[name='technologyConsult'][value='科技咨询']").prop("checked", "checked");
                }
                if(result.dfIntermediaryConsult == "1"){
                    $(":checkbox[name='intermediary'][value='中介咨询']").prop("checked", "checked");
                    $("#intermediary,#intermediary_consult_type").removeAttr("disabled");
                    $("#intermediary_consult_type").find("tr td input").removeAttr("disabled");
                    $("#intermediary_consult_type").find("tr td input").css("background","#ffffff")
                    $("#intermediary,#intermediary_consult_type").css("background","#ffffff")
                    $("#intermediary").find("tr td").css("background","#ecf7fd")

                    if(result.intermediaryLaw == "1"){
                        $(":checkbox[name='law'][value='法律']").prop("checked", "checked");
                        $("#intermediary_law_desc").val(result.intermediaryLawDesc)
                    }
                    if(result.intermediaryFinance == "1"){
                        $(":checkbox[name='finance'][value='财务']").prop("checked", "checked");
                        $("#intermediary_law_desc").val(result.intermediaryFinanceDesc)
                    }
                    if(result.intermediaryFinancing == "1"){
                        $(":checkbox[name='financing'][value='融资']").prop("checked", "checked");
                        $("#intermediary_law_desc").val(result.intermediaryFinancingDesc)
                    }
                    if(result.intermediaryManage == "1"){
                        $(":checkbox[name='manage'][value='管理']").prop("checked", "checked");
                        $("#intermediary_law_desc").val(result.intermediaryManageDesc)
                    }
                }else {
                    $("#intermediary,#intermediary_consult_type").attr("disabled", "disabled");
                    $("#intermediary,#intermediary_consult_type").css("background","#dbdbdb")
                    $("#intermediary_consult_type").find("tr td input").attr("disabled", "disabled");
                    $("#intermediary_consult_type").find("tr td input").css("background","#dbdbdb")
                    $("#intermediary").find("tr td").css("background","#dbdbdb")
                }

                if(result.dfOtherService == "1"){
                    $(":checkbox[name='other'][value='其他服务需求']").prop("checked", "checked");
                    $("#other_service_desc").val(result.otherServiceDesc);
                    $("#otherDesc,#otherDesc input").removeAttr("disabled");
                    $("#otherDesc,#otherDesc input").css("background","#ffffff")

                }else {
                    $("#otherDesc,#otherDesc input").attr("disabled", "disabled");
                    $("#otherDesc,#otherDesc input").css("background","#dbdbdb")
                }

                if(result.dfAcceptTrain == "1"){
                    $(":checkbox[name='train'][value='愿意接受专业培训和创业教育学位进修机会']").prop("checked", "checked");
                }
                if(result.dfNo == "1"){
                    $(":checkbox[name='no'][value='无']").prop("checked", "checked");
                }

            }

        }
    });
}

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
    $("#second_btn").css("background","#8fc320");
    $("#second_btn").find("p").css("color","#ffffff");
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
});
$("#third_btn").click(function () {
    $("#third_btn").css("background","#8fc320");
    $("#third_btn").find("p").css("color","#ffffff");
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
    $("#four_btn").css("background","#8fc320");
    $("#four_btn").find("p").css("color","#ffffff");
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




/***********************************************************************************************************************
 * 基本信息第一步
 */


$("#jbxx_conservation").click(function () {
    // alert($("#technical_sources input:checked").val())
    //修改基本信息
    if($("#company_name").val() == "" ||
        $("#ue_goal input:checked").val() == "" ||   $("#ue_filed input:checked").val() == ""
        || $("#register_capital").val() == "" ||
        $("#win_num").val() == "" || $("#staff_num").val() == ""
        || $("#research_num").val() == "" || $("#deputy_num").val() == "" ||
        $("#office_address").val() == "" || $("#power_type").val() == "" || $("#corporation_summary").val() == "" ||
        $("#post_code input:checked").val() == "" || $("#technical_sources input:checked").val() == ""){

        alert("请将基本信息填写完整！")
    }
    else {

        if($("#ue_goal input:checked").val() == "其它") {
            // alert($("#ue_goal input:checked").val());
            if ($("#ueGoal").val() == "") {
                alert("请填写参赛目的")
            }else {
                if($("#post_code input:checked").val() == "其它"){
                    if($("#powerType").val() == ""){
                        alert("请填写其他核心技术内容!")
                    }else {
                        if($("#legal_name").val() =="" || $("#legal_job").val() =="" || $("#legal_office_tel").val() =="" ||
                            $("#legal_mobile_tel").val() =="" || $("#legal_email").val() =="" ){
                            alert("请将法定代表人信息填写完整")
                        }
                        else {
                            if($("#contacts_name").val() =="" || $("#contacts_job").val() =="" || $("#contacts_office_tel").val() =="" ||
                                $("#contacts_mobile_tel").val() =="" || $("#contacts_email").val() =="" ){
                                alert("请将联系人信息填写完整")
                            }else {
                                var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
                                // alert(patent_choose);
                                if(patent_choose == true){
                                    for(var i=1;i<=patent;i++){
                                        var id = $("#patentId_"+i);
                                        var patentNum = $("#patent_num_"+i).val();
                                        var patentType =$("#patent_type_"+i).val();
                                        // alert(patentType);
                                        var patentName = $("#patent_name_"+i).val();
                                        var patentDate = $("#patent_date_"+i).val();
                                        if(patentNum == "" || patentType == "" || patentNum ==""
                                            || patentDate == ""){
                                            alert("请将专利相关信息补充完整")
                                        } else {
                                            // alert(id);
                                            //更新已有专利 创建未有专利
                                            if(id == ""){
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
                                                    patentDate:comTime(patentDate)
                                                }
                                                getPatentListByPatentId(condition,data);

                                            }
                                            else {
                                                var data = {
                                                    patentId:patentNum,
                                                    patentName:patentName,
                                                    patentType:patentType,
                                                    patentDate:comTime(patentDate)
                                                }
                                                updatePatentList(data,id);
                                            }
                                            var ueId  = $("#ueId").val();
                                            // alert(ueId+"ueId");
                                            var essentialData = updateUnitEssential_data();
                                            updateUnitEssential(essentialData,ueId)

                                            //修改法定联系人
                                            var legalId = $("#legalId").val();
                                            var legalData = conditionLegal_update();
                                            updateLegalRepresentative(legalData,legalId);

                                            //
                                            var contactsId = $("#contactsId").val();
                                            var contactsData = conditionContacts_data();
                                            updateContacts(contactsData,contactsId)
                                        }

                                    }
                                }
                                else {
                                    //删除已有专利
                                    for(var i=1;i<=patent;i++){
                                        var id = $("#patentId_"+i);

                                        deletePatentList(id);
                                    }

                                    var ueId  = $("#ueId").val();
                                    var essentialData = updateUnitEssential_data();
                                    updateUnitEssential(essentialData,ueId)

                                    //修改法定联系人
                                    var legalId = $("#legalId").val();
                                    var legalData = conditionLegal_update();
                                    updateLegalRepresentative(legalData,legalId);

                                    //
                                    var contactsId = $("#contactsId").val();
                                    var contactsData = conditionContacts_data();
                                    updateContacts(contactsData,contactsId)
                                }
                            }
                        }
                    }
                }
                else {
                    if($("#legal_name").val() =="" || $("#legal_job").val() =="" || $("#legal_office_tel").val() =="" ||
                        $("#legal_mobile_tel").val() =="" || $("#legal_email").val() =="" ){
                        alert("请将法定代表人信息填写完整")
                    }
                    else {
                        if($("#contacts_name").val() =="" || $("#contacts_job").val() =="" || $("#contacts_office_tel").val() =="" ||
                            $("#contacts_mobile_tel").val() =="" || $("#contacts_email").val() =="" ){
                            alert("请将联系人信息填写完整")
                        }else {
                            var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
                            // alert(patent_choose);
                            if(patent_choose == true){
                                for(var i=1;i<=patent;i++){
                                    var id = $("#patentId_"+i).val();
                                    var patentNum = $("#patent_num_"+i).val();
                                    var patentType =$("#patent_type_"+i).val();
                                    // alert(patentType);
                                    var patentName = $("#patent_name_"+i).val();
                                    var patentDate = $("#patent_date_"+i).val();
                                    if(patentNum == "" || patentType == "" || patentNum ==""
                                        || patentDate == ""){
                                        alert("请将专利相关信息补充完整")
                                    } else {
                                        // alert(id);
                                        //更新已有专利 创建未有专利
                                        if(id == ""){
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
                                                patentDate:comTime(patentDate)
                                            }
                                            getPatentListByPatentId(condition,data);

                                        }
                                        else {
                                            var data = {
                                                patentId:patentNum,
                                                patentName:patentName,
                                                patentType:patentType,
                                                patentDate:comTime(patentDate)
                                            }
                                            updatePatentList(data,id);
                                        }
                                        var ueId  = $("#ueId").val();
                                        // alert(ueId+"ueId");
                                        var essentialData = updateUnitEssential_data();
                                        updateUnitEssential(essentialData,ueId)

                                        //修改法定联系人
                                        var legalId = $("#legalId").val();
                                        var legalData = conditionLegal_update();
                                        updateLegalRepresentative(legalData,legalId);

                                        //
                                        var contactsId = $("#contactsId").val();
                                        var contactsData = conditionContacts_data();
                                        updateContacts(contactsData,contactsId)
                                    }

                                }
                            }
                            else {
                                //删除已有专利
                                for(var i=1;i<=patent;i++){
                                    var id = $("#patentId_"+i).val();

                                    deletePatentList(id);
                                }

                                var ueId  = $("#ueId").val();
                                var essentialData = updateUnitEssential_data();
                                updateUnitEssential(essentialData,ueId)

                                //修改法定联系人
                                var legalId = $("#legalId").val();
                                var legalData = conditionLegal_update();
                                updateLegalRepresentative(legalData,legalId);

                                //
                                var contactsId = $("#contactsId").val();
                                var contactsData = conditionContacts_data();
                                updateContacts(contactsData,contactsId)
                            }
                        }
                    }
                }
            }
        }else {
            if($("#post_code input:checked").val() == "其它"){
                if($("#powerType").val() == ""){
                    alert("请填写其他核心技术内容!")
                }else {
                    if($("#legal_name").val() =="" || $("#legal_job").val() =="" || $("#legal_office_tel").val() =="" ||
                        $("#legal_mobile_tel").val() =="" || $("#legal_email").val() =="" ){
                        alert("请将法定代表人信息填写完整")
                    }
                    else {
                        if($("#contacts_name").val() =="" || $("#contacts_job").val() =="" || $("#contacts_office_tel").val() =="" ||
                            $("#contacts_mobile_tel").val() =="" || $("#contacts_email").val() =="" ){
                            alert("请将联系人信息填写完整")
                        }else {
                            var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
                            // alert(patent_choose);
                            if(patent_choose == true){
                                for(var i=1;i<=patent;i++){
                                    var id = $("#patentId_"+i).val();
                                    var patentNum = $("#patent_num_"+i).val();
                                    var patentType =$("#patent_type_"+i).val();
                                    // alert(patentType);
                                    var patentName = $("#patent_name_"+i).val();
                                    var patentDate = $("#patent_date_"+i).val();
                                    if(patentNum == "" || patentType == "" || patentNum ==""
                                        || patentDate == ""){
                                        alert("请将专利相关信息补充完整")
                                    } else {
                                        // alert(id);
                                        //更新已有专利 创建未有专利
                                        if(id == ""){
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
                                                patentDate:comTime(patentDate)
                                            }
                                            getPatentListByPatentId(condition,data);

                                        }
                                        else {
                                            var data = {
                                                patentId:patentNum,
                                                patentName:patentName,
                                                patentType:patentType,
                                                patentDate:comTime(patentDate)
                                            }
                                            updatePatentList(data,id);
                                        }
                                        var ueId  = $("#ueId").val();
                                        // alert(ueId+"ueId");
                                        var essentialData = updateUnitEssential_data();
                                        updateUnitEssential(essentialData,ueId)

                                        //修改法定联系人
                                        var legalId = $("#legalId").val();
                                        var legalData = conditionLegal_update();
                                        updateLegalRepresentative(legalData,legalId);

                                        //
                                        var contactsId = $("#contactsId").val();
                                        var contactsData = conditionContacts_data();
                                        updateContacts(contactsData,contactsId)
                                    }

                                }
                            }
                            else {
                                //删除已有专利
                                for(var i=1;i<=patent;i++){
                                    var id = $("#patentId_"+i).val();

                                    deletePatentList(id);
                                }

                                var ueId  = $("#ueId").val();
                                var essentialData = updateUnitEssential_data();
                                updateUnitEssential(essentialData,ueId)

                                //修改法定联系人
                                var legalId = $("#legalId").val();
                                var legalData = conditionLegal_update();
                                updateLegalRepresentative(legalData,legalId);

                                //
                                var contactsId = $("#contactsId").val();
                                var contactsData = conditionContacts_data();
                                updateContacts(contactsData,contactsId)
                            }
                        }
                    }
                }
            }
            else {
                if($("#legal_name").val() =="" || $("#legal_job").val() =="" || $("#legal_office_tel").val() =="" ||
                    $("#legal_mobile_tel").val() =="" || $("#legal_email").val() =="" ){
                    alert("请将法定代表人信息填写完整")
                }
                else {
                    if($("#contacts_name").val() =="" || $("#contacts_job").val() =="" || $("#contacts_office_tel").val() =="" ||
                        $("#contacts_mobile_tel").val() =="" || $("#contacts_email").val() =="" ){
                        alert("请将联系人信息填写完整")
                    }else {
                        var patent_choose=$("#patent_choose input[type='checkbox']").is(':checked');
                        // alert(patent_choose);
                        if(patent_choose == true){
                            for(var i=1;i<=patent;i++){
                                var id = $("#patentId_"+i).val();
                                var patentNum = $("#patent_num_"+i).val();
                                var patentType =$("#patent_type_"+i).val();
                                // alert(patentType);
                                var patentName = $("#patent_name_"+i).val();
                                var patentDate = $("#patent_date_"+i).val();
                                if(patentNum == "" || patentType == "" || patentNum ==""
                                    || patentDate == ""){
                                    alert("请将专利相关信息补充完整")
                                } else {
                                    // alert(id);
                                    //更新已有专利 创建未有专利
                                    if(id == ""){
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
                                            patentDate:comTime(patentDate)
                                        }
                                        getPatentListByPatentId(condition,data);

                                    }
                                    else {
                                        var data = {
                                            patentId:patentNum,
                                            patentName:patentName,
                                            patentType:patentType,
                                            patentDate:comTime(patentDate)
                                        }
                                        updatePatentList(data,id);
                                    }
                                    var ueId  = $("#ueId").val();
                                    // alert(ueId+"ueId");
                                    var essentialData = updateUnitEssential_data();
                                    updateUnitEssential(essentialData,ueId)

                                    //修改法定联系人
                                    var legalId = $("#legalId").val();
                                    var legalData = conditionLegal_update();
                                    updateLegalRepresentative(legalData,legalId);

                                    //
                                    var contactsId = $("#contactsId").val();
                                    var contactsData = conditionContacts_data();
                                    updateContacts(contactsData,contactsId)
                                }

                            }
                        }
                        else {
                            //删除已有专利
                            for(var i=1;i<=patent;i++){
                                var id = $("#patentId_"+i).val();

                                deletePatentList(id);
                            }

                            var ueId  = $("#ueId").val();
                            var essentialData = updateUnitEssential_data();
                            updateUnitEssential(essentialData,ueId)

                            //修改法定联系人
                            var legalId = $("#legalId").val();
                            var legalData = conditionLegal_update();
                            updateLegalRepresentative(legalData,legalId);

                            //
                            var contactsId = $("#contactsId").val();
                            var contactsData = conditionContacts_data();
                            updateContacts(contactsData,contactsId)
                        }
                    }
                }
            }
        }
    }
});



var updateUnitEssential_data = function () {
    var Goal = $("#ue_goal input:radio:checked").val();
    var ueFiled = $("#ue_filed input:radio:checked").val();
    var registerCapital = $("#register_capital").val();
    var staffNum = $("#staff_num").val();
    var winNum = $("#win_num").val();
    var researchNum = $("#research_num").val();
    var deputyNum = $("#deputy_num").val();
    var officeAddress = $("#office_address").val();
    var Code = $("#post_code input:radio:checked").val();
    var Type = $("#power_type").val();
    var corporationSummary = $("#corporation_summary").val();
    var technicalSources = $("#post_code input:radio:checked").val();
    if(Goal == "其它"){
        var ueGoal = $("#ueGoal").val();
        if(Code == "其它"){
            var postCode = $("#powerType").val();
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
                uePostCode:Code,
                uePowerType:Type,
                ueCorporationSummary:corporationSummary,
                ueTechnicalSources:technicalSources
            }
            return Essential_data;
        }
    }else {
        if(Code == "其它"){
            var postCode = $("#powerType").val();
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
                uePostCode:Code,
                uePowerType:Type,
                ueCorporationSummary:corporationSummary,
                ueTechnicalSources:technicalSources
            }
            return Essential_data;
        }
    }
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

var addImg =function () {
    // alert(patent);
    var html_tr = "<tr id='patent_"+(num-2)+"'><td>专利名称</td><td>专利类型*</td><td>专利号</td> <td>获得时间选择</td></tr>"+
        "<tr id='patent_"+(num-1)+"'><td><input type='text' id='patent_name_"+patent+"'/></td>"+
        "<td>" +
        "<select id='patent_type_"+patent+"'>" +
        "<option value='1'>发明专利</option>"+
        "<option value='2'>实用新型专利</option>"+
        "<option value='3'>外观设计</option>"+
        "</select>"+
        "</td>"+
        "<td><input type='text' id='patent_num_"+patent+"'/></td>"+
        "<td><input type='text' id='patent_date_"+patent+"'/></td></tr>"+
        "<tr hidden='hidden' id='patent_"+num+"'><td><input id='patentId_"+patent+"' value=''/></td></tr>";
    // alert(html_tr);
    $("#patent_table table").append(html_tr);
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
            // alert(result);
            if (result != null && result>0) {
               alert("该专利号"+condition+"已存在,请核实！")
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
            alert("增加注射哪里信息失败！")
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
var updatePatentList = function (condition,id) {

    $.ajax({
        url: "/updatePatentList/"+id,
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
var reduceImg = function () {
    // alert("#patent_"+(num+1));
    $("#patent_"+(num+1)).remove();
    $("#patent_"+(num+2)).remove();
    $("#patent_"+(num+3)).remove();
}





    /********************************************************************************************************************************
     * 核心团队成员信息-第二步
     */



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
            "<tr class='img_tr'>" +
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
var reduceCoreImg = function () {
    // alert("#patent_"+(num+1));
    $("#core_"+(core+1)).remove();
    $("#core_"+(core+2)).remove();
    $("#core_"+(core+3)).remove();
    $("#core_"+(core+4)).remove();
    $("#core_"+(core+5)).remove();
    $("#core_"+(core+6)).remove();
}

$("#hxtd_conservation").click(function () {
    //更新已有成员信息 创建未有成员信息
    for(var i=1;i<=team;i++){
        var　ctId = $("#ctId_"+i).val();
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
            coreEducation == "" || coreExperience == "" || coreMillennium == "" ||
            mainAchive == "" ){
            alert("请将核心成员信息填写完整！")
        }else {
            if(coreMillennium == "是"){
                if(coreMillenniumDate == ""){
                    alert("请填写入选国家千人计划时间！")
                }else {
                    if(ctId == ""){
                        if(coreMillennium == "是"){
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
                                nationalMilleDate:comTime(coreMillenniumDate)
                            }
                            addCoreTeam(condition);
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
                            addCoreTeam(condition);
                        }

                    }
                    else {
                        if(coreMillennium == "是"){
                            var condition={
                                ctName:coreName,
                                ctSex:coreSex,
                                ctAge:coreAge,
                                ctJob:coreJob,
                                ctHigbestEducation:coreEducation,
                                ctStudyExperience:coreExperience,
                                ctMainAchive:mainAchive,
                                ctNationalMillennium:coreMillennium,
                                nationalMilleDate:comTime(coreMillenniumDate)
                            }
                            updateCoreTeam(condition,ctId);
                        }else {
                            var condition={
                                ctName:coreName,
                                ctSex:coreSex,
                                ctAge:coreAge,
                                ctJob:coreJob,
                                ctHigbestEducation:coreEducation,
                                ctStudyExperience:coreExperience,
                                ctMainAchive:mainAchive,
                                ctNationalMillennium:coreMillennium
                            }
                            updateCoreTeam(condition,ctId);
                        }

                    }
                }
            }else {
                if(ctId == ""){
                    if(coreMillennium == "是"){
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
                            nationalMilleDate:comTime(coreMillenniumDate)
                        }
                        addCoreTeam(condition);
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
                        addCoreTeam(condition);
                    }

                }
                else {
                    if(coreMillennium == "是"){
                        var condition={
                            ctName:coreName,
                            ctSex:coreSex,
                            ctAge:coreAge,
                            ctJob:coreJob,
                            ctHigbestEducation:coreEducation,
                            ctStudyExperience:coreExperience,
                            ctMainAchive:mainAchive,
                            ctNationalMillennium:coreMillennium,
                            nationalMilleDate:comTime(coreMillenniumDate)
                        }
                        updateCoreTeam(condition,ctId);
                    }else {
                        var condition={
                            ctName:coreName,
                            ctSex:coreSex,
                            ctAge:coreAge,
                            ctJob:coreJob,
                            ctHigbestEducation:coreEducation,
                            ctStudyExperience:coreExperience,
                            ctMainAchive:mainAchive,
                            ctNationalMillennium:coreMillennium
                        }
                        updateCoreTeam(condition,ctId);
                    }

                }
            }
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
var updateCoreTeam = function (condition,ctId) {
    $.ajax({
        url: "/updateCoreTeam/"+ctId,
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


/******************************************************************************************************
 *第三步，填写商业计划书
 */



$("#syjhs_conservation").click(function () {
    var ubusId = $("#ubusId").val();
    var data = conditionUnitBusinessPlan_update();
    updateUnitBusinessPlan(data,ubusId);

    conditionHistorical_update();
    conditionForeUpdate()

    if($("#isEquity input:checked").val() == "是"){
        var equityId = $("#equityId").val();
        var equity_investor = $("#equity_investor").val();
        var equity_money = $("#equity_money").val();
        var equity_rate = $("#equity_rate").val();
        var equity_date = $("#equity_date").val();
        // alert(equityId);

        if(equity_investor == "" || equity_money == "" || equity_rate == "" || equity_date =="") {
            alert("请将股权融资信息补充完整！")
        } else {
            if(equityId == ""){
                var unitEquity_data = {
                    ubusId:null,
                    entireId:entireId,
                    equityInvestor:equity_investor,
                    equityMoney:equity_money,
                    equityRate:equity_rate,
                    equityDate:comTime(equity_date)

                }
                addEquity(unitEquity_data);
            }else {
                var unitEquity_data = {
                    equityInvestor:equity_investor,
                    equityMoney:equity_money,
                    equityRate:equity_rate,
                    equityDate:comTime(equity_date)

                }
                updateEquity(unitEquity_data,equityId);
            }

        }
    }
    else {
        var equityId = $("#equityId").val();
        if(equityId != ""){
            deleteEquityByEntireId(entireId)
        }
    }

    if($("#isDebt input:checked").val() == "是"){
        var debtId = $("#debtId").val();
        var debt_leader = $("#debt_leader").val();
        var debt_money = $("#debt_money").val();
        var debt_start_time = $("#debt_start_time").val();
        var debt_end_time = $("#debt_end_time").val();
        // alert(debtId);
        if(debt_leader == "" || debt_money == "" || debt_start_time == "" || debt_end_time == ""){
            alert("请将债权融资信息补充完整！")
        } else {

            if(debtId == ""){
                var unitDebt_data = {
                    ubusId:null,
                    entireId:entireId,
                    debtLeader:debt_leader,
                    debtMoney:debt_money,
                    debtStartTime:comTime(debt_start_time),
                    debtEndTime:comTime(debt_end_time)

                }
                addDebt(unitDebt_data);
            }else {
                var unitDebt_data = {
                    debtLeader:debt_leader,
                    debtMoney:debt_money,
                    debtStartTime:comTime(debt_start_time),
                    debtEndTime:comTime(debt_end_time)

                }
                updateDebt(unitDebt_data,debtId);
            }
        }
    }
    else {
        var debtId = $("#debtId").val();
        if(debtId != ""){
            deleteDebtByEntireId(debtId)
        }
    }

    var demandId = $("#demandId").val();
    // alert(demandId)

    conditionDemand_update(demandId);

});







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

var conditionUnitBusinessPlan_update=function () {
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
    var status = "SUBMIT";

    var unitBusinessPlan_data = {
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
        ubusMain:ubus_main,
        status:status
    }
    return unitBusinessPlan_data;
};
var updateUnitBusinessPlan = function (condition,ubusId) {
    $.ajax({
        url: "/updateBusinessPlan/"+ubusId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                console.log(result);
                getUnitBusinessPlanConditionByEntireId(entireId)
            }

        }
    });

}

var conditionHistorical_update = function () {
    for(var i=2;i<=4;i++){
        var hfinId = $("#hfinId_"+i).val();
        var hfin_income=$("#hfin_income_"+i).val();
        var hfin_cost=$("#hfin_cost_"+i).val();
        var hfin_profit=$("#hfin_profit_"+i).val();
        var hfin_profit_rate=$("#hfin_profit_rate_"+i).val();
        var hfin_expenses=$("#hfin_expenses_"+i).val();
        var operating_profit=$("#operating_profit_"+i).val();
        var operating_profit_rate=$("#operating_profit_rate_"+i).val();
        var beforeTax_profit=$("#beforeTax_profit_"+i).val();
        var net_margin=$("#net_margin_"+i).val();
        var fixed_netValue=$("#fixed_netValue_"+i).val();
        var assets_total=$("#assets_total_"+i).val();
        var liabilites_total=$("#liabilites_total_"+i).val();
        var net_asset=$("#net_asset_"+i).val();
        var hfin_year = "201"+i;

        var condition = {
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

        updateFinancialHistorical(condition,hfinId);

    }



};
var updateFinancialHistorical = function (condition,hfinId) {
    $.ajax({
        url: "/updateFinancialHistorical/"+hfinId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("修改财务预测信息失败！")
        },
        success: function (result) {
            if (result != null) {
                console.log(result);

              getHistoricalListByEntireId(entireId);
            }

        }
    });
}

var conditionForeUpdate = function () {
    for(var i=5;i<=7;i++){
        var foreId = $("#foreId_"+i).val()
        var fore_income=$("#fore_income_"+i).val();
        var fore_cost=$("#fore_cost_"+i).val();
        var tax_expense=$("#tax_expense_"+i).val();
        var fore_profit=$("#fore_profit_"+i).val();
        var profit_rate=$("#profit_rate_"+i).val();
        var net_margin=$("#net_margin_"+i).val();
        var fore_year = "201"+i
        var condition = {
            foreIncome:fore_income,
            foreCost:fore_cost,
            foreTaxExpense:tax_expense,
            foreProfit:fore_profit,
            foreProfitRate:profit_rate,
            foreNetMargin:net_margin,
            foreYear:fore_year

        }

        updateFinancialForecasting(condition,foreId);
    }



};
var updateFinancialForecasting =  function (condition,foreId) {
    $.ajax({
        url: "/updateFinancialForecasting/"+foreId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("更新财务预测信息失败！")
        },
        success: function (result) {
            console.log(result)
            if (result != null) {
                getForecastingListByEntireId(entireId)
            }

        }
    });
}

var updateEquity=function (condition,equityId) {
    $.ajax({
        url: "/updateEquity/"+equityId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                console.log(result);
                getEquityFinancingListByEntireId(entireId)
            }

        }
    });
}
var updateDebt = function (condition,debtId) {
    $.ajax({
        url: "/updateDebt/"+debtId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                console.log(result);

               getDebtFinancingListByEntireId(entireId)
            }

        }
    });
}

var deleteEquityByEntireId = function (condition) {
    $.ajax({
        url: "/deleteEquityByEntireId/"+condition,
        type: 'DELETE',
        async: true,
        data: condition,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            // alert(result);
          getEquityFinancingListByEntireId(entireId)

        }
    });
}
var deleteDebtByEntireId = function (condition) {
    $.ajax({
        url: "/deleteDebtByEntireId/"+condition,
        type: 'DELETE',
        async: true,
        data: condition,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            // alert(result);
            getDebtFinancingListByEntireId(entireId);
        }
    });
}

var conditionDemand_update=function (demandId) {
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
        if($("#df_isEquity input:checked").val() == "是") {
            if ($("#df_equity_money").val() == "" || $("#df_equity_shares").val() == "" ||
                $("#df_equity_date").val() == "" || $("#df_equityFund_plan").val() == "") {
                alert("请将融资信息填写完整")
            }
            else {
                if ($("#df_isDebt input:checked").val() == "是") {
                    if ($("#df_debt_money").val() == "" || $("#df_debt_maxAnnual").val() == "" ||
                        $("#df_debt_date").val() == "" || $("#df_debtFund_plan").val() == "") {
                        alert("请将融资信息填写完整")
                    }else {
                        var unitDemand_data = {
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

                        updateDemand(unitDemand_data,demandId,"");
                    }
                }
            }
        }

    }
    if(df_isEquity == "否" && df_isDebt == "否"){
        var unitDemand_data = {
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

        updateDemand(unitDemand_data,demandId,"");
    }
    if(df_isEquity == "是" && df_isDebt == "否"){
        if($("#df_isEquity input:checked").val() == "是") {
            if ($("#df_equity_money").val() == "" || $("#df_equity_shares").val() == "" ||
                $("#df_equity_date").val() == "" || $("#df_equityFund_plan").val() == "") {
                alert("请将融资信息填写完整")
            }else {
                var unitDemand_data = {
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

                updateDemand(unitDemand_data,demandId,"");
            }
        }

    }
    if(df_isEquity == "否" && df_isDebt == "是"){
        if ($("#df_isDebt input:checked").val() == "是") {
            if ($("#df_debt_money").val() == "" || $("#df_debt_maxAnnual").val() == "" ||
                $("#df_debt_date").val() == "" || $("#df_debtFund_plan").val() == "") {
                alert("请将融资信息填写完整")
            }else {
                var unitDemand_data = {
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

                updateDemand(unitDemand_data,demandId,"");
            }
        }

    }
};
var conditionDemand_update_submit=function (demandId) {
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
        if($("#df_isEquity input:checked").val() == "是") {
            if ($("#df_equity_money").val() == "" || $("#df_equity_shares").val() == "" ||
                $("#df_equity_date").val() == "" || $("#df_equityFund_plan").val() == "") {
                alert("请将融资信息填写完整")
            }
            else {
                if ($("#df_isDebt input:checked").val() == "是") {
                    if ($("#df_debt_money").val() == "" || $("#df_debt_maxAnnual").val() == "" ||
                        $("#df_debt_date").val() == "" || $("#df_debtFund_plan").val() == "") {
                        alert("请将融资信息填写完整")
                    }else {
                        var unitDemand_data = {
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

                        updateDemand(unitDemand_data,demandId,"submit");
                    }
                }
            }
        }

    }
    if(df_isEquity == "否" && df_isDebt == "否"){
        var unitDemand_data = {
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

        updateDemand(unitDemand_data,demandId,"submit");
    }
    if(df_isEquity == "是" && df_isDebt == "否"){
        if($("#df_isEquity input:checked").val() == "是") {
            if ($("#df_equity_money").val() == "" || $("#df_equity_shares").val() == "" ||
                $("#df_equity_date").val() == "" || $("#df_equityFund_plan").val() == "") {
                alert("请将融资信息填写完整")
            }else {
                var unitDemand_data = {
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

                updateDemand(unitDemand_data,demandId,"submit");
            }
        }

    }
    if(df_isEquity == "否" && df_isDebt == "是"){
        if ($("#df_isDebt input:checked").val() == "是") {
            if ($("#df_debt_money").val() == "" || $("#df_debt_maxAnnual").val() == "" ||
                $("#df_debt_date").val() == "" || $("#df_debtFund_plan").val() == "") {
                alert("请将融资信息填写完整")
            }else {
                var unitDemand_data = {
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

                updateDemand(unitDemand_data,demandId,"submit");
            }
        }

    }
};
var updateDemand = function (condition,demandId,type) {
    $.ajax({
        url: "/updateDemandFinancial/"+demandId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                console.log(result);
                if(type = "submit"){
                    var data = {
                        workState:"SUBMIT"
                    }
                    updateEntireWorkState(data,entireId)
                }else {
                    getDemandListByEntireId(entireId);
                }

            }

        }
    });
}

var deletePatentList = function (id) {
    $.ajax({
        url: "/deletePatentById/"+id,
        type: 'get',
        async: true,
        data: id,
        // dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            // alert(result);
            if (result != null && result>0) {
                alert("删除成功！")
            }

        }
    });
}
var updateEntireWorkState = function (condition,entireId) {
    $.ajax({
        url: "/updateEntireWorkState/"+entireId,
        type: 'put',
        async: true,
        data: condition,
        dataType: 'json',
        error: function (obj, msg) {
            alert("服务器异常！")
        },
        success: function (result) {
            if (result != null) {
                console.log(result);
                alert("提交报名成功！")
                $("#submit_competition_syjhs").unbind('click');
                $("#submit_competition_syjhs").css("background","#dbdbdb");
                $("#submit_competition_syjhs").find("p").html("已提交报名");

                $("#jbxx_conservation").unbind('click');
                $("#jbxx_conservation").css("background","#dbdbdb");
                $("#jbxx_conservation").find("p").html("修改");
                $("#hxtd_conservation").unbind('click');
                $("#hxtd_conservation").css("background","#dbdbdb");
                $("#hxtd_conservation").find("p").html("修改");
                $("#syjhs_conservation").unbind('click');
                $("#syjhs_conservation").css("background","#dbdbdb");
                $("#syjhs_conservation").find("p").html("修改");
            }

        }
    });
}