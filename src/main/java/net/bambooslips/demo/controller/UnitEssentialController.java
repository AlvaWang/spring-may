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
    @Autowired
    private EquityFinancingService equityFinancingService ;
    @Autowired
    private DebtFinancingService debtFinancingService ;
    @Autowired
    private DemandFinancialService demandFinancialService ;
    @Autowired
    private CompetitionEntireService competitionEntireService;


    /**
     * 查寻entire_id列表
     * @param comName
     * @return
     */
    @RequestMapping(value = "getEntireListByComName/{comName}", method = RequestMethod.GET)
    @ResponseBody
    public String getEntireListByComName(@PathVariable String comName,String workState) {
        String result;
        BaseResult baseResult = null;
        List<CompetitionEntire> list = competitionEntireService.findAllEntireList(comName,workState);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<CompetitionEntire>(list);
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
     * 查询项目名称
     */
    @RequestMapping(value = "getEntireProNameByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String getEntireProNameByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<UnitBusinessPlan> list = unitBusinessPlanService.findEntireProName(entireId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<UnitBusinessPlan>(list);
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


    @RequestMapping(value = "getEntireWorkStateById/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String getEntireWorkStateById(@PathVariable Long entireId) {
        String result = competitionEntireService.findByEntireId(entireId);
        if (result != null && result.length()>0){
            return result;
        }else {
            return null;
        }
    }

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
     * 查看专利是否增加
     * @param id
     * @return
     */
    @RequestMapping(value = "getEntireIdByPatentId", method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public Long getEntireIdByPatentId(@RequestParam(required = false) Long id) {
        Long result = patentListService.findById(id);
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
     * 查看历史财务数据
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getHistoricalByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String getHistoricalByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<FinancialHistorical> list = financialHistoricalService.findByEntireId(entireId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<FinancialHistorical>(list);
            baseResult = new BaseResult(true, "");
            baseResult.setData(tableResult);
            result = JSON.toJSONString(baseResult);

            return result;
        }else {
            baseResult = new BaseResult(true,"查询信息为空");
            result = JSON.toJSONString(baseResult);
            return result;
        }
    }
    /**
     * 查看财务数据
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getForecastingByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String  getForecastingByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<FinancialForecasting>  list = financialForecastingService.findByEntireId(entireId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<FinancialForecasting>(list);
            baseResult = new BaseResult(true, "");
            baseResult.setData(tableResult);
            result = JSON.toJSONString(baseResult);

           return result;
        }else {
            baseResult = new BaseResult(true,"查询信息为空");
            result = JSON.toJSONString(baseResult);
            return result;
        }
    }
    /**
     * 查看是否已填写融资信息
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getEquityFinancingByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getEquityFinancingByEntireId(@PathVariable Long entireId) {
        Long result = equityFinancingService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }
    /**
     * 查看是否已填写债权融资信息
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getDebtFinancingByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getDebtFinancingByEntireId(@PathVariable Long entireId) {
        Long result = debtFinancingService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }
    /**
     * 查看是否已填写科技金融服务需求
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getDemandByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Long getDemandByEntireId(@PathVariable Long entireId) {
        Long result = demandFinancialService.findByEntireId(entireId);
        if (result != null && result>0){
            return result;
        }else {
            return null;
        }
    }

    /**
     * 查看历史财务数据
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getCoreTeamByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public int getCoreTeamByEntireId(@PathVariable Long entireId) {
        int result = coreTeamService.findByEntireId(entireId);
        if (result >0){
            return result;
        }else {
            return 0;
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
    public Long create(@RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String ueProjectName,
                       @RequestParam(required = false) String ueCompanyName,
                       @RequestParam(required = false) String ueGoal,
                       @RequestParam(required = false) String ueField,
                       @RequestParam(required = false) Long ueRegisterCapital,
                       @RequestParam(required = false) Long ueWinNum,
                       @RequestParam(required = false) Long ueStaffNum,
                       @RequestParam(required = false) Long ueResearchNum,
                       @RequestParam(required = false) Long ueDeputyNum,
                       @RequestParam(required = false) String ueOfficeAddress,
                       @RequestParam(required = false) String uePostCode,
                       @RequestParam(required = false) String uePowerType,
                       @RequestParam(required = false) String ueCorporationSummary,
                       @RequestParam(required = false) String ueTechnicalSources,
                       @RequestParam(required = false) String status) {
        UnitEssential unitEssential = new UnitEssential(entireId,ueProjectName, ueCompanyName, ueGoal,ueField,ueRegisterCapital,
                ueWinNum,ueStaffNum,ueResearchNum,ueDeputyNum,ueOfficeAddress,uePostCode,uePowerType,ueCorporationSummary,ueTechnicalSources,status);

        Long result =  unitEssentialService.create(unitEssential);

        return result;
    }

    /**
     * 增加法定联系人
     */
    @RequestMapping(value = "addLegalRepresentative",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestParam(required = false) Long ueId,
                       @RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String legalName,
                       @RequestParam(required = false) String legalJob,
                       @RequestParam(required = false) String legalOfficeTel,
                       @RequestParam(required = false) String legalMobileTel,
                       @RequestParam(required = false) String legalEmail) {
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
    public Long addContacts(@RequestParam(required = false) Long ueId,
                       @RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String contactsName,
                       @RequestParam(required = false) String contactsJob,
                       @RequestParam(required = false) String contactsOfficeTel,
                       @RequestParam(required = false) String contactsMobileTel,
                       @RequestParam(required = false) String contactsEmail) {
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
                            @RequestParam(required = false) Date patentDate,
                            @RequestParam(required = false) String patentVerification){

//        Date date = timeF.parse(patentDate);

        PatentList patentList = new PatentList(patentId,entireId, ueId, teId,
                patentName,patentType, patentDate, patentVerification);

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
                            @RequestParam(required = false) Date nationalMilleDate,
                            @RequestParam(required = false) String ctUniversityBusiness){

//        Date date = timeF.parse(patentDate);

        if(ctAge != null && ctName != null && ctSex != null && ctJob != null && ctHigbestEducation != null && ctStudyExperience != null
                && ctMainAchive != null && ctNationalMillennium != null){
            CoreTeam coreTeam = new CoreTeam(ueId,teId, entireId,ctName,ctSex,ctAge,ctJob,
                    ctHigbestEducation,ctStudyExperience,ctMainAchive,ctNationalMillennium,
                    nationalMilleDate, ctUniversityBusiness);

            Long result =  coreTeamService.create(coreTeam);

            return result;
        }else {
            return null;
        }

    }

    @RequestMapping(value = "addUnitBusinessPlan",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addUnitBusinessPlan(@RequestParam(required = false) Long ueId,
                       @RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String ubusProName,
                       @RequestParam(required = false) Long ubusProIncomed,
                       @RequestParam(required = false) String ubusProType,
                       @RequestParam(required = false) String ubusLeadInternal,
                       @RequestParam(required = false) String ubusLeadInternational,
                       @RequestParam(required = false) String ubusResearchInstitute,
                       @RequestParam(required = false) String instituteName,
                       @RequestParam(required = false) String ubusProPicture,
                       @RequestParam(required = false) String ubusMajorDescribe,
                       @RequestParam(required = false) String ubusProMarket,
                       @RequestParam(required = false) String ubusModel,
                       @RequestParam(required = false) String ubusMain,
                                    @RequestParam(required = false) String status) {
        UnitBusinessPlan unitBusinessPlan = new UnitBusinessPlan(ueId, entireId, ubusProName,ubusProIncomed,ubusProType,
                ubusLeadInternal,ubusLeadInternational,ubusResearchInstitute,instituteName,ubusProPicture,ubusMajorDescribe,ubusProMarket,ubusModel,ubusMain,status);

        Long result =  unitBusinessPlanService.create(unitBusinessPlan);

        return result;
    }

    @RequestMapping(value = "addFinancialHistorical",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addFinancialHistorical(@RequestParam(required = false) Long ubusId,
                                    @RequestParam(required = false) Long entireId,
                                    @RequestParam(required = false) Long hfinIncome,
                                    @RequestParam(required = false) Long hfinCost,
                                    @RequestParam(required = false) Long hfinProfit,
                                    @RequestParam(required = false) Long hfinBeforeTaxProfit,
                                    @RequestParam(required = false) Long hfinExpenses,
                                    @RequestParam(required = false) Long hfinProfitRate,
                                    @RequestParam(required = false) Long hfinOperatingProfit,
                                    @RequestParam(required = false) Long operatingProfitRate,
                                    @RequestParam(required = false) Long hfinNetMargin,
                                    @RequestParam(required = false) Long fixedNetValue,
                                    @RequestParam(required = false) Long hfinAssetsTotal,
                                       @RequestParam(required = false) Long hfinLialilitesTotal,
                                       @RequestParam(required = false) Long hfinNetAsset,
                                    @RequestParam(required = false) String hfinYear) {
        FinancialHistorical financialHistorical = new FinancialHistorical(entireId, ubusId, hfinIncome,hfinCost,hfinProfit, hfinProfitRate,hfinExpenses,hfinOperatingProfit,operatingProfitRate,
                hfinBeforeTaxProfit,hfinNetMargin,fixedNetValue,hfinAssetsTotal,hfinLialilitesTotal,hfinNetAsset,hfinYear);

        Long result =  financialHistoricalService.create(financialHistorical);

        return result;
    }

    @RequestMapping(value = "addFinancialForecasting",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addFinancialForecasting(@RequestParam(required = false) Long ubusId,
                                       @RequestParam(required = false) Long entireId,
                                       @RequestParam(required = false) Long tbusId,
                                       @RequestParam(required = false) Long foreIncome,
                                       @RequestParam(required = false) Long foreCost,
                                       @RequestParam(required = false) Long foreTaxExpense,
                                       @RequestParam(required = false) Long foreProfit,
                                       @RequestParam(required = false) Long foreProfitRate,
                                       @RequestParam(required = false) Long foreNetMargin,
                                       @RequestParam(required = false) String foreYear) {
        FinancialForecasting financialForecasting = new FinancialForecasting(entireId, ubusId, tbusId,foreIncome,
                foreCost, foreTaxExpense,foreProfit,foreProfitRate,foreNetMargin, foreYear);

        Long result =  financialForecastingService.create(financialForecasting);

        return result;
    }

    /**
     * 增加融资信息
     */
    @RequestMapping(value = "addEquityFinancing",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addEquityFinancing(@RequestParam(required = false) Long ubusId,
                       @RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String equityInvestor,
                       @RequestParam(required = false) Long equityMoney,
                       @RequestParam(required = false) Long equityRate,
                       @RequestParam(required = false) Date equityDate) {
        EquityFinancing equityFinancing = new EquityFinancing(ubusId, entireId, equityInvestor,equityMoney,equityRate,equityDate);
        Long result =  equityFinancingService.create(equityFinancing);

        return result;
    }

    @RequestMapping(value = "addDebtFinancing",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addDebtFinancing(@RequestParam(required = false) Long ubusId,
                       @RequestParam(required = false) Long entireId,
                       @RequestParam(required = false) String debtLeader,
                       @RequestParam(required = false) Long debtMoney,
                       @RequestParam(required = false) Date debtStartTime,
                       @RequestParam(required = false) Date debtEndTime) {
        DebtFinancing debtFinancing = new DebtFinancing(ubusId, entireId, debtLeader,debtMoney,debtStartTime, debtEndTime);

        Long result =  debtFinancingService.create(debtFinancing);

        return result;
    }

    /**
     * 增加科技金融服务需求信息
     */

    @RequestMapping(value = "addDemandFinancial",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long addDemandFinancial(@RequestParam(required = false) Long entireId,
                                   @RequestParam(required = false) Long ubusId,
                                   @RequestParam(required = false) Long tbusId,
                       @RequestParam(required = false) String dfEquity,
                       @RequestParam(required = false) Long dfEquityShares,
                       @RequestParam(required = false) Long dfEquityMoney,
                       @RequestParam(required = false) Date dfEquityDate,
                       @RequestParam(required = false) String equityFundPlan,
                                   @RequestParam(required = false) String dfEquityRecom,

                                   @RequestParam(required = false) String dfDebt,
                                   @RequestParam(required = false) Long dfDebtMoney,
                                   @RequestParam(required = false) Long debtMaxAnnual,
                                   @RequestParam(required = false) Date dfDebtDate,
                                   @RequestParam(required = false) String debtFundPlan,
                                   @RequestParam(required = false) String dfDebtRecom,
                       @RequestParam(required = false) String dfCrowdFunding,
                       @RequestParam(required = false) String crowsFundType,
                       @RequestParam(required = false) String dfMerge,
                       @RequestParam(required = false ) String dfListedShareReform,
                       @RequestParam(required = false) String dfFinancingGuarantee,
                       @RequestParam(required = false) String dfPettyLoan,
                       @RequestParam(required = false) Long pettyLoanMoney,
                       @RequestParam(required = false) String dfCompanyDebt,
                                   @RequestParam(required = false) String minorEnterprisesDebt,

                                   @RequestParam(required = false) String dfTechnicalImport,
                                   @RequestParam(required = false) String  technicalImportInternational,
                                   @RequestParam(required = false) String technicalDescInternational,
                                   @RequestParam(required = false) String technicalImportInternal,
                                   @RequestParam(required = false) String technicalDescInternal,
                                   @RequestParam(required = false) String dfTechnicalTransfer,
                                   @RequestParam(required = false) String technicalTransferRange,
                                   @RequestParam(required = false) String dfPropertyAssign,
                                   @RequestParam(required = false) String dfFinaceLease,
                                   @RequestParam(required = false) String dfTechnologyInsurance,
                                   @RequestParam(required = false) String dfAssetManage,
                                   @RequestParam(required = false) String branchChongCheck,
                                   @RequestParam(required = false) String dfPoliticalConsult,
                                   @RequestParam(required = false) String dfTechnologyConsult,

                                   @RequestParam(required = false) String dfIntermediaryConsult,
                                   @RequestParam(required = false) String  intermediaryLaw,
                                   @RequestParam(required = false) String intermediaryLawDesc,
                                   @RequestParam(required = false) String intermediaryFinance,
                                   @RequestParam(required = false) String intermediaryFinanceDesc,
                                   @RequestParam(required = false) String intermediaryFinancing,
                                   @RequestParam(required = false) String intermediaryFinancingDesc,
                                   @RequestParam(required = false) String intermediaryManage,
                                   @RequestParam(required = false) String intermediaryManageDesc,
                                   @RequestParam(required = false) String dfOtherService,
                                   @RequestParam(required = false) String otherServiceDesc,
                                   @RequestParam(required = false) String dfAcceptTrain,
                                   @RequestParam(required = false) String dfNo) {

        DemandFinancial demandFinancial = new DemandFinancial(entireId, ubusId, tbusId,dfEquity,dfEquityShares,dfEquityMoney,
                dfEquityDate,equityFundPlan,dfEquityRecom,dfDebt,dfDebtMoney,debtMaxAnnual,dfDebtDate,debtFundPlan,dfDebtRecom,dfCrowdFunding,crowsFundType,
                dfMerge,dfListedShareReform,dfFinancingGuarantee,dfPettyLoan,pettyLoanMoney,dfCompanyDebt,minorEnterprisesDebt,dfTechnicalImport,
                technicalImportInternational,technicalDescInternational,technicalImportInternal,technicalDescInternal,dfTechnicalTransfer,
                technicalTransferRange,dfPropertyAssign,dfFinaceLease,dfTechnologyInsurance,dfAssetManage,branchChongCheck,dfPoliticalConsult,
                dfTechnologyConsult,dfIntermediaryConsult,intermediaryLaw,intermediaryLawDesc,intermediaryFinance,intermediaryFinanceDesc,intermediaryFinancing,
                intermediaryFinancingDesc,intermediaryManage,intermediaryManageDesc,dfOtherService,otherServiceDesc,dfAcceptTrain,dfNo);

        Long result =  demandFinancialService.create(demandFinancial);

        return result;
    }

    /**
     * 修改基本信息
     * @return
     */
    @RequestMapping(value = "/updateEssential/{ueId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public UnitEssential updateByForm(@PathVariable Long ueId, String ueProjectName,String ueGoal,String ueField,Long ueRegisterCapital,
                                      Long ueWinNum,Long ueStaffNum,Long ueResearhNum,Long ueDeputyNum,
                                      String ueOfficeAddress,String uePostCode,String uePowerType,String ueCorporationSummary,String technicalSources ) {
        UnitEssential unitEssential = new UnitEssential();
        unitEssential.setUeId(ueId);
        unitEssential.setUeProjectName(ueProjectName);
        unitEssential.setUeGoal(ueGoal);

        unitEssential.setUeField(ueField);
        unitEssential.setUeRegisterCapital(ueRegisterCapital);
        unitEssential.setUeWinNum(ueWinNum);
        unitEssential.setUeStaffNum(ueStaffNum);
        unitEssential.setUeResearchNum(ueResearhNum);
        unitEssential.setUeDeputyNum(ueDeputyNum);
        unitEssential.setUeOfficeAddress(ueOfficeAddress);
        unitEssential.setUePostCode(uePostCode);
        unitEssential.setUePowerType(uePowerType);
        unitEssential.setUeCorporationSummary(ueCorporationSummary);
        unitEssential.setUeTechnicalSources(technicalSources);

        return unitEssentialService.update(unitEssential);
    }

    /**
     * 修改法定代表人
     * @return
     */
    @RequestMapping(value = "/updateLegalRepresentative/{legalId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public LegalRepresentative updateLegalRepresentative(@PathVariable Long legalId, String legalName,
                                                   String legalJob,String legalMobileTel, String legalOfficeTel,String legalEmail ) {
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        legalRepresentative.setLegalId(legalId);
        legalRepresentative.setLegalName(legalName);

        legalRepresentative.setLegalJob(legalJob);
        legalRepresentative.setLegalMobileTel(legalMobileTel);
        legalRepresentative.setLegalOfficeTel(legalOfficeTel);
        legalRepresentative.setLegalEmail(legalEmail);

        return legalRepresentativeService.update(legalRepresentative);
    }

    /**
     * 修改联系人
     * @return
     */
    @RequestMapping(value = "/updateContacts/{contactsId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public Contacts updateContacts(@PathVariable Long contactsId, String contactsName,
                                                         String contactsJob,String contactsOfficeTel, String contactsMobileTel,String contactsEmail ) {
        Contacts contacts = new Contacts();
        contacts.setContactsId(contactsId);
        contacts.setContactsName(contactsName);

        contacts.setContactsJob(contactsJob);
        contacts.setContactsOfficeTel(contactsOfficeTel);
        contacts.setContactsMobileTel(contactsMobileTel);
        contacts.setContactsEmail(contactsEmail);

        return contactsService.update(contacts);
    }


    @RequestMapping(value = "/updateBusinessPlan/{ubusId}",method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public UnitBusinessPlan updateBusinessPlan(@PathVariable Long ubusId, String ubusProName, Long ubusProIncomed, String ubusProType, String ubusLeadInternal,
                                     String ubusLeadInternational, String ubusResearchInstitute, String instituteName, String ubusProPicture, String ubusMajorDescribe,
                                     String ubusProMarket, String ubusModel, String ubusMain, String status) {
        UnitBusinessPlan unitBusinessPlan = new UnitBusinessPlan();
        unitBusinessPlan.setUbusId(ubusId);
        unitBusinessPlan.setUbusProName(ubusProName);
        unitBusinessPlan.setUbusProIncomed(ubusProIncomed);

        unitBusinessPlan.setUbusProType(ubusProType);
        unitBusinessPlan.setUbusLeadInternal(ubusLeadInternal);
        unitBusinessPlan.setUbusLeadInternational(ubusLeadInternational);
        unitBusinessPlan.setInstituteName(instituteName);

        unitBusinessPlan.setUbusResearchInstitute(ubusResearchInstitute);
        unitBusinessPlan.setUbusProPicture(ubusProPicture);
        unitBusinessPlan.setUbusMajorDescribe(ubusMajorDescribe);
        unitBusinessPlan.setUbusProMarket(ubusProMarket);
        unitBusinessPlan.setUbusModel(ubusModel);
        unitBusinessPlan.setUbusMain(ubusMain);
        unitBusinessPlan.setStatus(status);


        return unitBusinessPlanService.update(unitBusinessPlan);
    }

    /**
     * gengxin科技金融服务需求信息
     */

    @RequestMapping(value = "/updateDemandFinancial/{dfId}",method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public DemandFinancial updateDemandFinancial( @PathVariable Long dfId, String dfEquity, Long dfEquityShares,
                                    Long dfEquityMoney, Date dfEquityDate, String equityFundPlan, String dfEquityRecom,
                                       String dfDebt, Long dfDebtMoney, Long debtMaxAnnual, Date dfDebtDate, String debtFundPlan, String dfDebtRecom, String dfCrowdFunding,
                                    String crowsFundType, String dfMerge, String dfListedShareReform, String dfFinancingGuarantee, String dfPettyLoan,
                                   Long pettyLoanMoney, String dfCompanyDebt, String minorEnterprisesDebt,
                                       String dfTechnicalImport, String  technicalImportInternational, String technicalDescInternational, String technicalImportInternal,
                                    String technicalDescInternal, String dfTechnicalTransfer, String technicalTransferRange, String dfPropertyAssign, String dfFinaceLease,
                                   String dfTechnologyInsurance, String dfAssetManage, String branchChongCheck, String dfPoliticalConsult,
                                  String dfTechnologyConsult, String dfIntermediaryConsult, String  intermediaryLaw, String intermediaryLawDesc,
                                   String intermediaryFinance, String intermediaryFinanceDesc, String intermediaryFinancing, String intermediaryFinancingDesc,
                                    String intermediaryManage, String intermediaryManageDesc, String dfOtherService, String otherServiceDesc, String dfAcceptTrain,
                                  String dfNo) {
        DemandFinancial demandFinancial = new DemandFinancial();
        demandFinancial.setDfId(dfId);
        demandFinancial.setDfEquity(dfEquity);
        demandFinancial.setDfEquityMoney(dfEquityMoney);

        demandFinancial.setDfEquityShares(dfEquityShares);
        demandFinancial.setDfEquityDate(dfEquityDate);
        demandFinancial.setEquityFundPlan(equityFundPlan);
        demandFinancial.setDfEquityRecom(dfEquityRecom);

        demandFinancial.setDfDebt(dfDebt);
        demandFinancial.setDfDebtMoney(dfDebtMoney);

        demandFinancial.setDebtMaxAnnual(debtMaxAnnual);
        demandFinancial.setDfDebtDate(dfDebtDate);
        demandFinancial.setDebtFundPlan(debtFundPlan);
        demandFinancial.setDfDebtRecom(dfEquityRecom);

        demandFinancial.setDfCrowdFunding(dfCrowdFunding);
        demandFinancial.setCrowsFundType(crowsFundType);
        demandFinancial.setDfMerge(dfMerge);
        demandFinancial.setDfListedShareReform(dfListedShareReform);
        demandFinancial.setDfFinancingGuarantee(dfFinancingGuarantee);
        demandFinancial.setDfPettyLoan(dfPettyLoan);
        demandFinancial.setPettyLoanMoney(pettyLoanMoney);

        demandFinancial.setDfCompanyDebt(dfCompanyDebt);
        demandFinancial.setMinorEnterprisesDebt(minorEnterprisesDebt);
        demandFinancial.setDfTechnicalImport(dfTechnicalImport);
        demandFinancial.setTechnicalImportInternational(technicalImportInternational);
        demandFinancial.setTechnicalDescInternational(technicalDescInternational);
        demandFinancial.setTechnicalImportInternal(technicalImportInternal);
        demandFinancial.setTechnicalDescInternatl(technicalDescInternal);
        demandFinancial.setDfTechnicalTransfer(dfTechnicalTransfer);

        demandFinancial.setTechnicalTransferRange(technicalTransferRange);
        demandFinancial.setDfPropertyAssign(dfPropertyAssign);
        demandFinancial.setDfFinaceLease(dfFinaceLease);
        demandFinancial.setDfTechnologyInsurance(dfTechnologyInsurance);
        demandFinancial.setDfAssetManage(dfAssetManage);
        demandFinancial.setBranchChongCheck(branchChongCheck);
        demandFinancial.setDfPoliticalConsult(dfPoliticalConsult);
        demandFinancial.setDfTechnologyConsult(dfTechnologyConsult);

        demandFinancial.setDfIntermediaryConsult(dfIntermediaryConsult);
        demandFinancial.setIntermediaryLaw(intermediaryLaw);
        demandFinancial.setIntermediaryLawDesc(intermediaryLawDesc);
        demandFinancial.setIntermediaryFinance(intermediaryFinance);
        demandFinancial.setIntermediaryFinanceDesc(intermediaryFinanceDesc);
        demandFinancial.setIntermediaryFinancing(intermediaryFinancing);
        demandFinancial.setIntermediaryFinancingDesc(intermediaryFinancingDesc);
        demandFinancial.setIntermediaryManage(intermediaryManage);
        demandFinancial.setIntermediaryManageDesc(intermediaryManageDesc);
        demandFinancial.setDfOtherService(dfOtherService);
        demandFinancial.setOtherServiceDesc(otherServiceDesc);
        demandFinancial.setDfAcceptTrain(dfAcceptTrain);
        demandFinancial.setDfNo(dfNo);

        return demandFinancialService.update(demandFinancial);
    }


    @RequestMapping(value = "/updateFinancialHistorical/{hfinId}",method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public FinancialHistorical updateFinancialHistorical(@PathVariable Long hfinId, Long hfinIncome, Long hfinCost, Long hfinProfit, Long hfinProfitRate,
                                                         Long hfinExpenses, Long hfinOperatingProfit, Long operatingProfitRate, Long hfinBeforeTaxProfit,
                                                         Long hfinNetMargin, Long fixedNetValue, Long hfinAssetsTotal, Long hfinLialilitesTotal, Long hfinNetAsset,String hfinYear) {
        FinancialHistorical financialHistorical = new FinancialHistorical();
        financialHistorical.setHfinId(hfinId);
        financialHistorical.setHfinIncome(hfinIncome);
        financialHistorical.setHfinCost(hfinCost);

        financialHistorical.setHfinProfit(hfinProfit);
        financialHistorical.setHfinProfitRate(hfinProfitRate);
        financialHistorical.setHfinExpenses(hfinExpenses);
        financialHistorical.setHfinOperatingProfit(hfinOperatingProfit);

        financialHistorical.setOperatingProfitRate(operatingProfitRate);
        financialHistorical.setHfinBeforeTaxProfit(hfinBeforeTaxProfit);
        financialHistorical.setHfinNetMargin(hfinNetMargin);
        financialHistorical.setFixedNetValue(fixedNetValue);
        financialHistorical.setHfinAssetsTotal(hfinAssetsTotal);
        financialHistorical.setHfinLialilitesTotal(hfinLialilitesTotal);
        financialHistorical.setHfinNetAsset(hfinNetAsset);
        financialHistorical.setHfinYear(hfinYear);


        return financialHistoricalService.update(financialHistorical);
    }



    @RequestMapping(value = "/updateFinancialForecasting/{foreId}",method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public FinancialForecasting updateFinancialForecasting(@PathVariable Long foreId, Long foreIncome, Long foreCost, Long foreTaxExpense, Long foreProfit,
                                                         Long foreProfitRate, Long foreNetMargin,String foreYear) {
        FinancialForecasting financialForecasting = new FinancialForecasting();
        financialForecasting.setForeId(foreId);
        financialForecasting.setForeCost(foreCost);
        financialForecasting.setForeIncome(foreIncome);

        financialForecasting.setForeTaxExpense(foreTaxExpense);
        financialForecasting.setForeProfit(foreProfit);
        financialForecasting.setForeProfitRate(foreProfitRate);
        financialForecasting.setForeNetMargin(foreNetMargin);

        financialForecasting.setForeYear(foreYear);


        return financialForecastingService.update(financialForecasting);
    }
    /**
     * 股权融资信息
     * @return
     */
    @RequestMapping(value = "/updateEquity/{equityId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public EquityFinancing updateEquity(@PathVariable Long equityId, String equityInvestor,
                                                         Long equityMoney,Long equityRate, Date equityDate) {
        EquityFinancing equityFinancing = new EquityFinancing();
        equityFinancing.setEquityId(equityId);
        equityFinancing.setEquityInvestor(equityInvestor);

        equityFinancing.setEquityMoney(equityMoney);
        equityFinancing.setEquityRate(equityRate);
        equityFinancing.setEquityDate(equityDate);

        return equityFinancingService.update(equityFinancing);
    }


    /**
     * 股权融资信息
     * @return
     */
    @RequestMapping(value = "/updateDebt/{debtId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public DebtFinancing updateDebt(@PathVariable Long debtId, String debtLeader,
                                        Long debtMoney,Date debtStartTime, Date debtEndTime) {
        DebtFinancing debtFinancing = new DebtFinancing();
        debtFinancing.setDebtId(debtId);
        debtFinancing.setDebtLeader(debtLeader);

        debtFinancing.setDebtMoney(debtMoney);
        debtFinancing.setDebtStartTime(debtStartTime);
        debtFinancing.setDebtEndTime(debtEndTime);

        return debtFinancingService.update(debtFinancing);
    }

    /**
     * 股权作品状态
     * @return
     */
    @RequestMapping(value = "/updateEntireWorkState/{entireId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public CompetitionEntire updateEntireWorkState(@PathVariable Long entireId, String workState) {
        CompetitionEntire competitionEntire = new CompetitionEntire();
        competitionEntire.setEntireId(entireId);
        competitionEntire.setWorkState(workState);

        return competitionEntireService.updateWorkState(competitionEntire);
    }

    /**
     * 修改专利信息
     * @return
     */
    @RequestMapping(value = "/updatePatentList/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public PatentList updatePatentList(@PathVariable Long id, String patentId,
                                   String patentName,String patentType, Date patentDate,String patentVerification) {
        PatentList patentList = new PatentList();
        patentList.setId(id);
        patentList.setPatentName(patentName);

        patentList.setPatentType(patentType);
        patentList.setPatentDate(patentDate);
        patentList.setPatentId(patentId);
        patentList.setPatentVerification(patentVerification);

        return patentListService.update(patentList);
    }

    /**
     * 修改专利信息
     * @return
     */
    @RequestMapping(value = "/updateCoreTeam/{ctId}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public CoreTeam updateCoreTeam(@PathVariable Long ctId, String ctName,
                                       String ctSex,Long ctAge, String ctJob,String ctHigbestEducation,String ctStudyExperience,String ctMainAchive,
                                     String ctNationalMillennium, Date nationalMilleDate,String ctUniversityBusiness) {
        CoreTeam coreTeam = new CoreTeam();
        coreTeam.setCtId(ctId);
        coreTeam.setCtName(ctName);

        coreTeam.setCtJob(ctJob);
        coreTeam.setCtSex(ctSex);
        coreTeam.setCtAge(ctAge);
        coreTeam.setCtHigbestEducation(ctHigbestEducation);

        coreTeam.setCtStudyExperience(ctStudyExperience);
        coreTeam.setCtMainAchive(ctMainAchive);
        coreTeam.setCtNationalMillennium(ctNationalMillennium);
        coreTeam.setNationalMilleDate(nationalMilleDate);
        coreTeam.setCtUniversityBusiness(ctUniversityBusiness);

        return coreTeamService.update(coreTeam);
    }

    @RequestMapping(value = "/deleteEquityByEntireId/{entireId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public EquityFinancing deleteEquityByEntireId(@PathVariable Long entireId) {
        return equityFinancingService.delete(entireId);
    }

    @RequestMapping(value = "/deleteDebtByEntireId/{dfId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public DebtFinancing deleteDebtByEntireId(@PathVariable Long dfId) {
        return debtFinancingService.delete(dfId);
    }

    @RequestMapping(value = "/deletePatentById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PatentList deletePatentById(@PathVariable Long id) {
        return patentListService.delete(id);
    }

    @RequestMapping(value = "/deleteCoreTeamByEntireId/{entireId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CoreTeam> deleteCoreTeamByEntireId(@PathVariable Long entireId) {
        return coreTeamService.deleteByEntireId(entireId);
    }

    @RequestMapping(value = "/deleteCoreTeamById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CoreTeam deleteCoreTeamById(@PathVariable Long id) {
        return coreTeamService.delete(id);
    }

}
