package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CoreTeamNotFoundException;
import net.bambooslips.demo.exception.DemandFinancialNotFoundException;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.DemandFinancial;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface DemandFinancialService {

    Long create(DemandFinancial demandFinancial);

    @Transactional(rollbackFor = DemandFinancialNotFoundException.class)
    /**
     * 更新法定联系人
     */
    DemandFinancial update(DemandFinancial update);


    DemandFinancial delete(Long id);

    Long findByEntireId(Long entireId);

    DemandFinancial findListByEntireId(Long entireId);
}
