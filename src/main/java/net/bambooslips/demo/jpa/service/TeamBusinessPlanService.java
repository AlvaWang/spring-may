package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.TeamBusinessPlanNotFoundException;
import net.bambooslips.demo.exception.UnitBusinessPlanNotFoundException;
import net.bambooslips.demo.jpa.model.TeamBusinessPlan;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface TeamBusinessPlanService {

    Long create(TeamBusinessPlan teamBusinessPlan);

    @Transactional(rollbackFor = TeamBusinessPlanNotFoundException.class)
    /**
     * 更新法定联系人
     */
    TeamBusinessPlan update(TeamBusinessPlan update);

    String findByEntireId(Long entireId);

    List<TeamBusinessPlan> findEntireProName(Long entireId);


//    UnitBusinessPlan delete(Long id);
}
