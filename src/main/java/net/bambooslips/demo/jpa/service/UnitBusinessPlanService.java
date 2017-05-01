package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CoreTeamNotFoundException;
import net.bambooslips.demo.exception.UnitBusinessPlanNotFoundException;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface UnitBusinessPlanService {

    Long create(UnitBusinessPlan unitBusinessPlan);

    @Transactional(rollbackFor = UnitBusinessPlanNotFoundException.class)
    /**
     * 更新法定联系人
     */
    UnitBusinessPlan update(UnitBusinessPlan update);

    Long findByEntireId(Long entireId);


//    UnitBusinessPlan delete(Long id);
}
