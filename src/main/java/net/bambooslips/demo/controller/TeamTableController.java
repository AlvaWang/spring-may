package net.bambooslips.demo.controller;

import com.alibaba.fastjson.JSON;
import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.*;
import net.bambooslips.demo.jpa.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
public class TeamTableController {
    private static final Logger LOG = LoggerFactory.getLogger(UnitEssentialNotFoundException.class);
    SimpleDateFormat timeF =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );

    @Autowired
    private TeamEssentialService teamEssentialService;
    @Autowired
    private TeamResponsiblePersonService teamResponsiblePersonService;
    @Autowired
    private TeamBusinessPlanService teamBusinessPlanService ;
    @Autowired
    private EconomicRiskCounterService economicRiskCounterService ;
    @Autowired
    private EducationExperionceService educationExperionceService ;





    /**
     * 查看对应作品的基本信息
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getTeamEssentialListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public TeamEssential getUnitEssentialListByEntireId(@PathVariable Long entireId) {
        TeamEssential result = teamEssentialService.findListByEntireId(entireId);
        return result;
    }



    /**
     * 查看对应团队联系人
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getResponsibleListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public TeamResponsiblePerson getResponsibleListByEntireId(@PathVariable Long entireId) {
        TeamResponsiblePerson result = teamResponsiblePersonService.findListByEntireId(entireId);
        return result;
    }


    /**
     * 查看商业计划书
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getTeamBusinessPlanConditionByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public TeamBusinessPlan getTeamBusinessPlanConditionByEntireId(@PathVariable Long entireId) {
        TeamBusinessPlan result = teamBusinessPlanService.findListByEntireId(entireId);
        return result;
    }


    /**
     * 查看经济风险
     * @param entireId
     * @return
     */
    @RequestMapping(value = "getRiskListByEntireId/{entireId}", method = RequestMethod.GET)
    @ResponseBody
    public String getRiskListByEntireId(@PathVariable Long entireId) {
        String result;
        BaseResult baseResult = null;
        List<EconomicRiskCounter> list = economicRiskCounterService.findListByEntireId(entireId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<EconomicRiskCounter>(list);
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
     * 查看核心团队成员教育经历
     * @param ctId
     * @return
     */
    @RequestMapping(value = "getEducationListByCtId/{ctId}", method = RequestMethod.GET)
    @ResponseBody
    public String getEducationListByCtId(@PathVariable Long ctId) {
        String result;
        BaseResult baseResult = null;
        List<EducationExperionce> list = educationExperionceService.findListByEntireId(ctId);
        if (list != null && list.size()>0){
            BootStrapTableResult tableResult = new BootStrapTableResult<EducationExperionce>(list);
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
