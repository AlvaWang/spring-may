package net.bambooslips.demo.controller;

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
import java.util.List;

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
    public @ResponseBody
    ModelAndView loginMethod(@RequestParam(required = false) String comAccName,
                                         @RequestParam(required = false) String comAccPwd,
                                         @RequestParam(required = false) String comAccType){
        String message = "这个是要传递的数据";
//        comAccName = "wp";comAccPwd = "123456";
        comAccType = "COMPETITION";
        List<CompetitionAccount> list = competitionAccountService.search(comAccName,comAccPwd,comAccType);
        if (list != null && list.size()>0){
            return new ModelAndView("redirect:success.html?comName="+comAccName);
        }else {
            return new ModelAndView("redirect:login.html");
        }
    }
    @RequestMapping(value = "loginActionWork",method = RequestMethod.POST,
            produces = {"text/html;charset=UTF-8;", "application/json", "*/*"})
    public @ResponseBody
    ModelAndView loginWorkMethod(@RequestParam(required = false) String comAccName,
                             @RequestParam(required = false) String comAccPwd,
                             @RequestParam(required = false) String comAccType){
        String message = "这个是要传递的数据";
//        comAccName = "wp";comAccPwd = "123456";
        comAccType = "EXPERT";
        List<CompetitionAccount> list = competitionAccountService.search(comAccName,comAccPwd,comAccType);
        if (list != null && list.size()>0){
            return new ModelAndView("redirect:success.html?comName="+comAccName);
        }else {
            return new ModelAndView("redirect:login.html");
        }
    }

    /*
    注册账号
     */
    @RequestMapping(value = "registerMethod",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestParam(required = true) String comAccName,
                       @RequestParam(required = true) String comAccPwd,
                       @RequestParam(required = true) String comAccEmail,
                       @RequestParam(required = true) String comAccType) {
        CompetitionAccount competitionAccount = new CompetitionAccount(comAccName, comAccPwd, comAccEmail,comAccType);
        Long result =  competitionAccountService.create(competitionAccount);

        return result;
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
