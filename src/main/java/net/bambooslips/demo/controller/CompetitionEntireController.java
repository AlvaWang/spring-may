package net.bambooslips.demo.controller;

import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.service.CompetitionAccountService;
import net.bambooslips.demo.jpa.service.CompetitionEntireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
public class CompetitionEntireController {
    private static final Logger LOG = LoggerFactory.getLogger(CustomErrorController.class);

    @Autowired
    private CompetitionEntireService competitionEntireService;


    /**
     * 创建作品
     */
    @RequestMapping(value = "entire/addEntire",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestParam(required = false) String comName,
                       @RequestParam(required = false) String entryType,
                       @RequestParam(required = false) String workState,
                       @RequestParam(required = false) String state) {
        CompetitionEntire competitionEntire = new CompetitionEntire(comName,entryType,workState,state);
        Long result =  competitionEntireService.create(competitionEntire);

        return result;
    }


    /**
     * 修改作品状态
     * @param id
     * @param workState
     * @return
     */
    @RequestMapping(value = "updateWorkState/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public CompetitionEntire updateWorkState(@PathVariable Long id, String workState) {
        CompetitionEntire competitionEntire = new CompetitionEntire();
        competitionEntire.setEntireId(id);
        competitionEntire.setWorkState(workState);

        return competitionEntireService.updateWorkState(competitionEntire);
    }

    /**
     * 删除账号
     * @param id
     * @return
     */
    @RequestMapping(value = "updateState/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CompetitionEntire delete(@PathVariable Long id,String state) {
        CompetitionEntire competitionEntire = new CompetitionEntire();
        competitionEntire.setEntireId(id);
        competitionEntire.setState(state);

        return competitionEntireService.updateState(competitionEntire);
    }
}
