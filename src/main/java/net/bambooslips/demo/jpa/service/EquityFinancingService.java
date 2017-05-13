package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CoreTeamNotFoundException;
import net.bambooslips.demo.exception.EquityFinancingNotFoundException;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.EquityFinancing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface EquityFinancingService {

    Long create(EquityFinancing equityFinancing);

    @Transactional(rollbackFor = EquityFinancingNotFoundException.class)
    /**
     * 更新法定联系人
     */
    EquityFinancing update(EquityFinancing update);


    EquityFinancing delete(Long entireId);

    Long findByEntireId(Long entireId);

    EquityFinancing findListByEntireId(Long entireId);
}
