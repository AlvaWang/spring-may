package net.bambooslips.demo.controller;

import com.alibaba.fastjson.JSON;
import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.Post;
import net.bambooslips.demo.jpa.model.PostType;
import net.bambooslips.demo.jpa.service.CompetitionAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
public class CompetitionAccountController {
    private static final Logger LOG = LoggerFactory.getLogger(CustomErrorController.class);

    @Autowired
    private CompetitionAccountService competitionAccountService;


    /**
     * 登录
     * @param comAccName
     * @param comAccPwd
     * @param comAccType
     * @return
     */
    @RequestMapping(value = "loginAction",method = RequestMethod.POST,
            produces = {"text/html;charset=UTF-8;", "application/json", "*/*"})
    public @ResponseBody String loginMethod(@RequestParam(required = false) String comAccName,
                                         @RequestParam(required = false) String comAccPwd,
                                         @RequestParam(required = false) String comAccType) {
        String message = "这个是要传递的数据";
//        comAccName = "wp";comAccPwd = "123456";
        comAccType = "COMPETITION";
        String result;
        BaseResult baseResult = null;
        if(comAccName =="" || comAccPwd == ""){
            baseResult = new BaseResult(false, "信息未填写完全");
            baseResult.setData("acc_null");
            result = JSON.toJSONString(baseResult);
            return result;
        }else {
            List<CompetitionAccount> list = competitionAccountService.search(comAccName, comAccPwd, comAccType);
            if (list != null && list.size() > 0) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(comAccName);
                result = JSON.toJSONString(baseResult);
                return result;
//                return new ModelAndView("redirect:success.html?comName=" + comAccName);
            } else {
                baseResult = new BaseResult(false, "账号或密码错误");
                baseResult.setData("acc_login_null");
                result = JSON.toJSONString(baseResult);
                return result;
            }
        }

    }
    @RequestMapping(value = "loginActionWork",method = RequestMethod.POST,
            produces = {"text/html;charset=UTF-8;", "application/json", "*/*"})
    public @ResponseBody String loginWorkMethod(@RequestParam(required = false) String comAccName,
                             @RequestParam(required = false) String comAccPwd,
                             @RequestParam(required = false) String comAccType){
        String message = "这个是要传递的数据";
//        comAccName = "wp";comAccPwd = "123456";
        comAccType = "EXPERT";
        String result;
        BaseResult baseResult = null;
        if(comAccName =="" || comAccPwd == ""){
            baseResult = new BaseResult(false, "信息未填写完全");
            baseResult.setData("accWork_null");
            result = JSON.toJSONString(baseResult);
            return result;
        }else {
            List<CompetitionAccount> list = competitionAccountService.search(comAccName,comAccPwd,comAccType);
            if (list != null && list.size()>0){
                baseResult = new BaseResult(true, "");
                baseResult.setData(comAccName);
                result = JSON.toJSONString(baseResult);
                return result;
//                return new ModelAndView("redirect:success.html?comName="+comAccName);
            }else {
                baseResult = new BaseResult(false, "账号或密码错误");
                baseResult.setData("accWork_login_null");
                result = JSON.toJSONString(baseResult);
                return result;
//                return new ModelAndView("redirect:login.html");
            }
        }

    }

    /*
    注册账号
     */
    @RequestMapping(value = "registerMethod",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestParam(required = true) String comAccName,
                       @RequestParam(required = true) String comAccPwd,
                       @RequestParam(required = true) String comAccEmail,
                       @RequestParam(required = false) String accAgainPwd,
                       @RequestParam(required = true) String comAccType) {
        String result;
        BaseResult baseResult = null;
        if(comAccName == "" || comAccPwd == "" ||comAccType == ""||comAccEmail == "" || accAgainPwd ==""){
            baseResult = new BaseResult(false, "信息未填写完全");
            baseResult.setData("acc_null");
            result = JSON.toJSONString(baseResult);
            return result;
        }else {
            List<CompetitionAccount> list = competitionAccountService.searchByComName(comAccName);
            if(list != null && list.size()>0) {
                baseResult = new BaseResult(false, "该账号已存在");
                baseResult.setData("acc_exist");
                result = JSON.toJSONString(baseResult);
                return result;
            }else {
                if (comAccPwd.equals(accAgainPwd)){
                    CompetitionAccount competitionAccount = new CompetitionAccount(comAccName, comAccPwd, comAccEmail,comAccType);
                    Long comId =  competitionAccountService.create(competitionAccount);
                    if (comId != null){
                        baseResult = new BaseResult(true, "");
                        baseResult.setData(comId);
                        result = JSON.toJSONString(baseResult);
                        return result;
                    }else {
                        baseResult = new BaseResult(false, "创建账户失败");
                        baseResult.setData("acc_found_fail");
                        result = JSON.toJSONString(baseResult);
                        return result;
                    }

                }else {
                    baseResult = new BaseResult(false, "两次密码不匹配");
                    baseResult.setData("acc_pwd_notSame");
                    result = JSON.toJSONString(baseResult);
                    return result;
                }
            }
        }
    }


    /**
     * 修改声明
     * @param id
     * @param comState
     * @return
     */
    @RequestMapping(value = "/updateState/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public CompetitionAccount updateByForm(@PathVariable Long id, String comState) {
        CompetitionAccount competitionAccount = new CompetitionAccount();
        competitionAccount.setId(id);
        competitionAccount.setComState(comState);

        return competitionAccountService.update(competitionAccount);
    }

    /**
     * 删除账号
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CompetitionAccount delete(@PathVariable Long id) {
        return competitionAccountService.delete(id);
    }
}
