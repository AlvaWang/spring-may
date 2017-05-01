package net.bambooslips.demo.controller;

import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.*;
import net.bambooslips.demo.jpa.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
public class UnitEssentialController {
    private static final Logger LOG = LoggerFactory.getLogger(UnitEssentialNotFoundException.class);
    SimpleDateFormat timeF =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );

    @Autowired
    private UnitEssentialService unitEssentialService;
    @Autowired
    private LegalRepresentativeService legalRepresentativeService;
    @Autowired
    private ContactsService contactsService;
    @Autowired
    private PatentListService patentListService;
    @Autowired
    private CoreTeamService coreTeamService ;
    @Autowired
    private UnitBusinessPlanService unitBusinessPlanService ;
    @Autowired
    private FinancialHistoricalService financialHistoricalService ;
    @Autowired
    private FinancialForecastingService financialForecastingService ;
    /**
     * 查看对应作品的基本信息录入表是否插入
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getUnitEssentialByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getUnitEssentialByEntireId(@PathVariable Long entireId) {
        Long result = unitEssentialService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }

    /**
     * 查看对应作品法定代表人
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getLegalRepresentativeByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getLegalRepresentativeByEntireId(@PathVariable Long entireId) {
        Long result = legalRepresentativeService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }
        else {
            return null;
        }
    }

    /**
     * 查看对应作品联系人
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getContactsByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getContactsByEntireId(@PathVariable Long entireId) {
        Long result = contactsService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }
        else {
            return null;
        }
    }

    /**
     * 查看专利是否增加
     * @param patentId
     * @return
     */
    @RequestMapping(value = "getPatentListByPatentId", method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public Long getPatentListByPatentId(@RequestParam(required = false) String patentId) {
        Long result = patentListService.findByPatentId(patentId);
        if (result != null && result>0){
            return result;
        }
        else {
            return null;
        }
    }

    /**
     * 查看对应作品的基本信息录入表是否插入
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getUnitBusinessPlanByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getUnitBusinessPlanByEntireId(@PathVariable Long entireId) {
        Long result = unitBusinessPlanService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }

    /**
     * 新增基本信息
     * @param entireId
     * @param ueCompanyName
     * @param ueGoal
     * @param ueField
     * @param ueRegisterCapital
     * @param ueWinNum
     * @param ueStaffNum
     * @param ueResearchNum
     * @param ueDeputyNum
     * @param ueOfficeAddress
     * @param uePowerType
     * @param ueCorporationSummary
     * @return
     */
    @RequestMapping(value = "addUnitEssential",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestParam(required = true) Long entireId,
                       @RequestParam(required = true) String ueCompanyName,
                       @RequestParam(required = true) String ueGoal,
                       @RequestParam(required = true) String ueField,
                       @RequestParam(required = true) double ueRegisterCapital,
                       @RequestParam(required = true) Long ueWinNum,
                       @RequestParam(required = true) Long ueStaffNum,
                       @RequestParam(required = true) Long ueResearchNum,
                       @RequestParam(required = true) Long ueDeputyNum,
                       @RequestParam(required = true) String ueOfficeAddress,
                       @RequestParam(required = true) String uePostCode,
                       @RequestParam(required = true) String uePowerType,
                       @RequestParam(required = true) String ueCorporationSummary,
                       @RequestParam(required = true) String ueTechnicalSources) {
        UnitEssential unitEssential = new UnitEssential(entireId, ueCompanyName, ueGoal,ueField,ueRegisterCapital,
                ueWinNum,ueStaffNum,ueResearchNum,ueDeputyNum,ueOfficeAddress,uePostCode,uePowerType,ueCorporationSummary,ueTechnicalSources);

        Long result =  unitEssentialService.create(unitEssential);

        return result;
    }

    /**
     * 增加法定联系人
     */
    @RequestMapping(value = "addLegalRepresentative",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestParam(required = true) Long ueId,
                       @RequestParam(required = true) Long entireId,
                       @RequestParam(required = true) String legalName,
                       @RequestParam(required = true) String legalJob,
                       @RequestParam(required = true) String legalOfficeTel,
                       @RequestParam(required = true) String legalMobileTel,
                       @RequestParam(required = true) String legalEmail) {
        LegalRepresentative legalRepresentative = new LegalRepresentative(entireId, ueId, legalName,legalJob,legalOfficeTel, legalMobileTel,legalEmail);

        Long result =  legalRepresentativeService.create(legalRepresentative);

        return result;
    }
    /**
     * 增加联系人
     */
    @RequestMapping(value = "addContacts",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addContacts(@RequestParam(required = true) Long ueId,
                       @RequestParam(required = true) Long entireId,
                       @RequestParam(required = true) String contactsName,
                       @RequestParam(required = true) String contactsJob,
                       @RequestParam(required = true) String contactsOfficeTel,
                       @RequestParam(required = true) String contactsMobileTel,
                       @RequestParam(required = true) String contactsEmail) {
        Contacts contacts = new Contacts(entireId, ueId, contactsName,
                contactsJob,contactsOfficeTel, contactsMobileTel,contactsEmail);

        Long result =  contactsService.create(contacts);

        return result;
    }

    /**
     * 增加专利
     */
    @RequestMapping(value = "addPatentList",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addPatentList(@RequestParam(required = false) Long ueId,
                              @RequestParam(required = false) String patentId,
                            @RequestParam(required = false)   Long entireId,
                              @RequestParam(required = false) Long teId,
                            @RequestParam(required = false) String patentName,
                            @RequestParam(required = false) String patentType,
//                            @RequestParam(required = false) String patentDate,
                            @RequestParam(required = false) String patentVerification) throws ParseException {

//        Date date = timeF.parse(patentDate);

        PatentList patentList = new PatentList(patentId,entireId, ueId, teId,
                patentName,patentType,
//                date,
                patentVerification);

        Long result =  patentListService.create(patentList);

        return result;
    }

    /**
     * 增加核心团队信息
     */
    @RequestMapping(value = "addCoreTeam",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addCoreTeam(@RequestParam(required = false) Long ueId,
                            @RequestParam(required = false) Long teId,
                            @RequestParam(required = false) Long entireId,
                            @RequestParam(required = false) String ctName,
                            @RequestParam(required = false) String ctSex,
                            @RequestParam(required = false) Long ctAge,
                            @RequestParam(required = false) String ctJob,
                            @RequestParam(required = false) String ctHigbestEducation,
                            @RequestParam(required = false) String ctStudyExperience,
                            @RequestParam(required = false) String ctMainAchive,
                            @RequestParam(required = false) String ctNationalMillennium,
//                            @RequestParam(required = false) String nationalMilleDate,
                            @RequestParam(required = false) String ctUniversityBusiness) throws ParseException {

//        Date date = timeF.parse(patentDate);

        CoreTeam coreTeam = new CoreTeam(ueId,teId, entireId,ctName,ctSex,ctAge,ctJob,
                ctHigbestEducation,ctStudyExperience,ctMainAchive,ctNationalMillennium,
//                nationalMilleDate,
                ctUniversityBusiness);

        Long result =  coreTeamService.create(coreTeam);

        return result;
    }

    @RequestMapping(value = "addUnitBusinessPlan",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addUnitBusinessPlan(@RequestParam(required = true) Long ueId,
                       @RequestParam(required = true) Long entireId,
                       @RequestParam(required = true) String ubusProName,
                       @RequestParam(required = true) Long ubusProIncomed,
                       @RequestParam(required = true) String ubusProType,
                       @RequestParam(required = true) String ubusLeadInternal,
                       @RequestParam(required = true) String ubusLeadInternational,
                       @RequestParam(required = true) String ubusResearchInstitute,
                       @RequestParam(required = true) String instituteName,
                       @RequestParam(required = true) String ubusProPicture,
                       @RequestParam(required = true) String ubusMajorDescribe,
                       @RequestParam(required = true) String ubusProMarket,
                       @RequestParam(required = true) String ubusModel,
                       @RequestParam(required = true) String ubusMain) {
        UnitBusinessPlan unitBusinessPlan = new UnitBusinessPlan(ueId, entireId, ubusProName,ubusProIncomed,ubusProType,
                ubusLeadInternal,ubusLeadInternational,ubusResearchInstitute,instituteName,ubusProPicture,ubusMajorDescribe,ubusProMarket,ubusModel,ubusMain);

        Long result =  unitBusinessPlanService.create(unitBusinessPlan);

        return result;
    }

    @RequestMapping(value = "addFinancialHistorical",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addFinancialHistorical(@RequestParam(required = true) Long ubusId,
                                    @RequestParam(required = true) Long entireId,
                                    @RequestParam(required = true) Long hfinIncome,
                                    @RequestParam(required = true) Long hfinCost,
                                    @RequestParam(required = true) Long hfinProfit,
                                    @RequestParam(required = true) Long hfinBeforeTaxProfit,
                                    @RequestParam(required = true) Long hfinExpenses,
                                    @RequestParam(required = true) Long hfinProfitRate,
                                    @RequestParam(required = true) Long hfinOperatingProfit,
                                    @RequestParam(required = true) Long operatingProfitRate,
                                    @RequestParam(required = true) Long hfinNetMargin,
                                    @RequestParam(required = true) Long fixedNetValue,
                                    @RequestParam(required = true) Long hfinAssetsTotal,
                                       @RequestParam(required = true) Long hfinLialilitesTotal,
                                       @RequestParam(required = true) Long hfinNetAsset,
                                    @RequestParam(required = true) String hfinYear) {
        FinancialHistorical financialHistorical = new FinancialHistorical(entireId, ubusId, hfinIncome,hfinCost,hfinProfit, hfinProfitRate,hfinExpenses,hfinOperatingProfit,operatingProfitRate,
                hfinBeforeTaxProfit,hfinNetMargin,fixedNetValue,hfinAssetsTotal,hfinLialilitesTotal,hfinNetAsset,hfinYear);

        Long result =  financialHistoricalService.create(financialHistorical);

        return result;
    }

    @RequestMapping(value = "addFinancialForecasting",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addFinancialForecasting(@RequestParam(required = true) Long ubusId,
                                       @RequestParam(required = true) Long entireId,
                                       @RequestParam(required = true) Long tbusId,
                                       @RequestParam(required = true) Long foreIncome,
                                       @RequestParam(required = true) Long foreCost,
                                       @RequestParam(required = true) Long foreTaxExpense,
                                       @RequestParam(required = true) Long foreProfit,
                                       @RequestParam(required = true) Long foreProfitRate,
                                       @RequestParam(required = true) Long foreNetMargin,
                                       @RequestParam(required = true) String foreYear) {
        FinancialForecasting financialForecasting = new FinancialForecasting(entireId, ubusId, tbusId,foreIncome,
                foreCost, foreTaxExpense,foreProfit,foreProfitRate,foreNetMargin, foreYear);

        Long result =  financialForecastingService.create(financialForecasting);

        return result;
    }
    /**
     * 修改基本信息
     * @return
     */
    @RequestMapping(value = "/updateEssential/{ueId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public UnitEssential updateByForm(@PathVariable Long ueId, String ueGoal,String ueField,double ueRegisterCapital,
                                      Long ueWinNum,Long ueStaffNum,Long ueResearhNum,Long ueDeputyNum,
                                      String ueOfficeAddress,String uePowerType,String ueCorporationSummary) {
        UnitEssential unitEssential = new UnitEssential();
        unitEssential.setUeId(ueId);
        unitEssential.setUeGoal(ueGoal);

        unitEssential.setUeField(ueField);
        unitEssential.setUeRegisterCapital(ueRegisterCapital);
        unitEssential.setUeWinNum(ueWinNum);
        unitEssential.setUeStaffNum(ueStaffNum);
        unitEssential.setUeResearchNum(ueResearhNum);
        unitEssential.setUeDeputyNum(ueDeputyNum);
        unitEssential.setUeOfficeAddress(ueOfficeAddress);
        unitEssential.setUePowerType(uePowerType);
        unitEssential.setUeCorporationSummary(ueCorporationSummary);

        return unitEssentialService.update(unitEssential);
    }


}
