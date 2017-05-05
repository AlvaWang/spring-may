package net.bambooslips.demo.controller;

import com.alibaba.fastjson.JSON;
import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.*;
import net.bambooslips.demo.jpa.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
public class TeamController {
    private static final Logger LOG = LoggerFactory.getLogger(UnitEssentialNotFoundException.class);
    SimpleDateFormat timeF =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );

    @Autowired
    private TeamEssentialService teamEssentialService;
    @Autowired
    private EducationExperionceService educationExperionceService;
    @Autowired
    private TeamResponsiblePersonService teamResponsiblePersonService ;
    @Autowired
    private TeamBusinessPlanService teamBusinessPlanService ;
    @Autowired
    private EconomicRiskCounterService economicRiskCounterService ;
    @Autowired
    private EquityFinancingService equityFinancingService ;
    @Autowired
    private DebtFinancingService debtFinancingService ;
    @Autowired
    private DemandFinancialService demandFinancialService ;
    @Autowired
    private CompetitionEntireService competitionEntireService;


    /**
     * 查询项目名称
     */
    @RequestMapping(value = "getEntireTeamProNameByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String getEntireTeamProNameByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<TeamBusinessPlan> list =  teamBusinessPlanService.findEntireProName(entireId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<TeamBusinessPlan>(list);
            baseResult = new BaseResult(true, "");
            baseResult.setData(tableResult);
            result = JSON.toJSONString(baseResult);
            return result;
        }else {
            baseResult = new BaseResult(true, "没有查询到相关信息！");
            result = JSON.toJSONString(baseResult);
            return result;
        }
    }

    /**
     * 查看对应作品的基本信息录入表是否插入
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getTeamEssentialByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getTeamEssentialByEntireId(@PathVariable Long entireId) {
        Long result = teamEssentialService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }
    /**
     * 查看对应团队联系人
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getPersonByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getPersonByEntireId(@PathVariable Long entireId) {
        Long result = teamResponsiblePersonService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }

    /**
     * 查看商业计划书
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getTeamBusinessPlanByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getTeamBusinessPlanByEntireId(@PathVariable Long entireId) {
        Long result = teamBusinessPlanService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }

    @RequestMapping(value = "addTeamEssential",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String teamName,
                       @RequestParam(required = false) String teProName,
                       @RequestParam(required = false) String teCompatitionGoal,
                       @RequestParam(required = false) String teIndustryFild,
                       @RequestParam(required = false) String teProStage,
                       @RequestParam(required = false) String teAdminStrativeArea,
                       @RequestParam(required = false) Date teamFundTime,
                       @RequestParam(required = false) Date companyFundTime,
                       @RequestParam(required = false) String teAddress,
                       @RequestParam(required = false) String tePostalcode,
                       @RequestParam(required = false) String tePowerType,
                       @RequestParam(required = false) String teTechnicalSource,
                       @RequestParam(required = false) String teProOutline,
                       @RequestParam(required = false) String teKeyWord
                       ) {
        try {
            TeamEssential teamEssential = new TeamEssential(entireId, teamName, teProName,teCompatitionGoal,teIndustryFild,
                    teProStage,teAdminStrativeArea,teamFundTime,companyFundTime,teAddress,tePostalcode,tePowerType,teTechnicalSource,teProOutline,teKeyWord);

            Long result =  teamEssentialService.create(teamEssential);

            return result;
        }catch (Exception e){
            teamFundTime = null;
            companyFundTime = null;
            TeamEssential teamEssential = new TeamEssential(entireId, teamName, teProName,teCompatitionGoal,teIndustryFild,
                    teProStage,teAdminStrativeArea,teamFundTime,companyFundTime,teAddress,tePostalcode,tePowerType,teTechnicalSource,teProOutline,teKeyWord);

            Long result =  teamEssentialService.create(teamEssential);

            return result;
        }

    }

    @RequestMapping(value = "addTeamBusinessPlan",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addUnitBusinessPlan(@RequestParam(required = false) Long teId,
                       @RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String tbusProName,
                       @RequestParam(required = false) Long tbusProIncomed,
                       @RequestParam(required = false) String tbusNewChips,
                       @RequestParam(required = false) String tbusHive,
                       @RequestParam(required = false) String tbusProCore,
                       @RequestParam(required = false) String tbusMajorDesc,
                       @RequestParam(required = false) String tbusTechnologyMaturity,
                       @RequestParam(required = false) String tbusManufacturMatutity,
                       @RequestParam(required = false) String tbusMarketMatutity,
                       @RequestParam(required = false) String tbusIndustryMain,
                       @RequestParam(required = false) String tbusLeadInternal,
                       @RequestParam(required = false) String tbusLeadInternational,
                                    @RequestParam(required = false) String tbusResearchInstitute,
                                    @RequestParam(required = false) String instituteName,
                                    @RequestParam(required = false) String tbusProPicture,
                                    @RequestParam(required = false) String tbusMarketAnalysis,
                                    @RequestParam(required = false) String tbusModel,
                                    @RequestParam(required = false) String tbusDevelopmentPlan
                                    ) {
        TeamBusinessPlan teamBusinessPlan = new TeamBusinessPlan(teId, entireId, tbusProName,tbusProIncomed,tbusNewChips,tbusHive,tbusProCore,
                tbusMajorDesc,tbusTechnologyMaturity,tbusManufacturMatutity,tbusMarketMatutity,tbusIndustryMain,tbusLeadInternal,tbusLeadInternational,tbusResearchInstitute,
                instituteName,tbusProPicture,tbusMarketAnalysis,tbusModel,tbusDevelopmentPlan);

        Long result =  teamBusinessPlanService.create(teamBusinessPlan);

        return result;
    }

    @RequestMapping(value = "addEducationExperionce",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addEducationExperionce(@RequestParam(required = false) Long entireId,
                                    @RequestParam(required = false) Long ctId,
                                    @RequestParam(required = false) String eduBackground,
                                    @RequestParam(required = false) String eduGraduateSchool,
                                    @RequestParam(required = false) String eduMajor
    ) {
       EducationExperionce educationExperionce = new EducationExperionce(entireId,ctId,eduBackground,eduGraduateSchool,eduMajor);

        Long result =  educationExperionceService.create(educationExperionce);

        return result;
    }

    @RequestMapping(value = "addPerson",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addPerson(@RequestParam(required = false) Long entireId,
                                       @RequestParam(required = false) Long teId,
                                       @RequestParam(required = false) String resName,
                                       @RequestParam(required = false) String resJob,
                                       @RequestParam(required = false) String resDocumentType,
                          @RequestParam(required = false) String documentNum,
                          @RequestParam(required = false) String resOfficeTel,
                          @RequestParam(required = false) String resMobileTel,
                          @RequestParam(required = false) String resEmail
    ) {
        TeamResponsiblePerson teamResponsiblePerson = new TeamResponsiblePerson(entireId,teId,resName,resJob,resDocumentType,documentNum,resOfficeTel,
                resMobileTel,resEmail);

        Long result =  teamResponsiblePersonService.create(teamResponsiblePerson);

        return result;
    }

    @RequestMapping(value = "addRiskCondition",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addRiskCondition(@RequestParam(required = false) Long entireId,
                                       @RequestParam(required = false) Long tbusId,
                                       @RequestParam(required = false) String econoLitigationContent,
                                       @RequestParam(required = false) String litigationReason
    ) {
        EconomicRiskCounter economicRiskCounter = new EconomicRiskCounter(entireId,tbusId,econoLitigationContent,litigationReason);

        Long result =  economicRiskCounterService.create(economicRiskCounter);

        return result;
    }

    /**
     * 修改基本信息
     * @return
     */
    @RequestMapping(value = "/updateTeamEssential/{teId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public TeamBusinessPlan updateTeamEssential(@PathVariable Long teId, String tbusProName,Long tbusProIncomed,String tbusNewChips,
                                      String tbusHive,String tbusProCore,String tbusMajorDesc,String tbusTechnologyMaturity,
                                      String tbusManufacturMatutity,String tbusMarketMatutity,String tbusIndustryMain,String tbusLeadInternal,String tbusLeadInternational,
                                             String tbusResearchInstitute,String instituteName,String tbusProPicture,String tbusMarketAnalysis,String tbusModel,String tbusDevelopmentPlan ) {
        TeamBusinessPlan teamBusinessPlan = new TeamBusinessPlan();
        teamBusinessPlan.setTeId(teId);
        teamBusinessPlan.setTbusProName(tbusProName);

        teamBusinessPlan.setTbusProIncomed(tbusProIncomed);
        teamBusinessPlan.setTbusNewChips(tbusNewChips);
        teamBusinessPlan.setTbusHive(tbusHive);
        teamBusinessPlan.setTbusProCore(tbusProCore);
        teamBusinessPlan.setTbusMajorDesc(tbusMajorDesc);
        teamBusinessPlan.setTbusTechnologyMaturity(tbusTechnologyMaturity);
        teamBusinessPlan.setTbusManufacturMatutity(tbusManufacturMatutity);
        teamBusinessPlan.setTbusMarketMatutity(tbusMarketMatutity);
        teamBusinessPlan.setTbusIndustryMain(tbusIndustryMain);
        teamBusinessPlan.setTbusLeadInternal(tbusLeadInternal);
        teamBusinessPlan.setTbusLeadInternational(tbusLeadInternational);

        teamBusinessPlan.setTbusResearchInstitute(tbusResearchInstitute);
        teamBusinessPlan.setInstituteName(instituteName);
        teamBusinessPlan.setTbusProPicture(tbusProPicture);
        teamBusinessPlan.setTbusMarketAnalysis(tbusMarketAnalysis);
        teamBusinessPlan.setTbusModel(tbusModel);
        teamBusinessPlan.setTbusDevelopmentPlan(tbusDevelopmentPlan);

        return teamBusinessPlan.update(teamBusinessPlan);
    }

}
