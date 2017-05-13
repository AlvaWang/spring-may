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
public class UnitTableController {
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
     * 查看对应作品的基本信息
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getUnitEssentialListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public UnitEssential getUnitEssentialListByEntireId(@PathVariable Long entireId) {
        UnitEssential result = unitEssentialService.findListByEntireId(entireId);
        return result;
    }

    /**
     * 查看对应作品法定代表人
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getLegalRepresentativeListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public LegalRepresentative getLegalRepresentativeListByEntireId(@PathVariable Long entireId) {
        LegalRepresentative result = legalRepresentativeService.findListByEntireId(entireId);
        return result;
    }

    /**
     * 查看对应作品联系人
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getContactsListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public Contacts getContactsListByEntireId(@PathVariable Long entireId) {
        Contacts result = contactsService.findListByEntireId(entireId);
        return result;
    }

    /**
     * 查看专利列表
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getPatentListByEntireId/{entireId}", method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public String getPatentListByEntireId(@PathVariable  Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<PatentList> list = patentListService.findListByEntireId(entireId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<PatentList>(list);
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
     * 查看商业计划书
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getUnitBusinessPlanConditionByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public UnitBusinessPlan getUnitBusinessPlanConditionByEntireId(@PathVariable Long entireId) {
        UnitBusinessPlan result = unitBusinessPlanService.findListByEntireId(entireId);
        return result;
    }

    /**
     * 查看历史财务数据
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getHistoricalListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String getHistoricalListByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<FinancialHistorical> list = financialHistoricalService.findListByEntireId(entireId);
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
    @RequestMapping(value = "getForecastingListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String  getForecastingListByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<FinancialForecasting>  list = financialForecastingService.findListByEntireId(entireId);
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
    @RequestMapping(value = "getEquityFinancingListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public EquityFinancing getEquityFinancingListByEntireId(@PathVariable Long entireId) {
        EquityFinancing result = equityFinancingService.findListByEntireId(entireId);
        return result;
    }
    /**
     * 查看债权融资信息
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getDebtFinancingListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public DebtFinancing getDebtFinancingListByEntireId(@PathVariable Long entireId) {
        DebtFinancing result = debtFinancingService.findListByEntireId(entireId);
       return  result;
    }
    /**
     * 查看科技金融服务需求
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getDemandListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public DemandFinancial getDemandListByEntireId(@PathVariable Long entireId) {
        DemandFinancial result = demandFinancialService.findListByEntireId(entireId);
       return result;
    }

    /**
     * 查看核心团队成员
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getCoreTeamListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String getCoreTeamListByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<CoreTeam> list = coreTeamService.findListByEntireId(entireId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<CoreTeam>(list);
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


}
