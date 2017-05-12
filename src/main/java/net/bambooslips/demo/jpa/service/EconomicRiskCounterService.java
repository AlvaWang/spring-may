package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.EconomicRiskCounterNotFoundException;
import net.bambooslips.demo.exception.TeamEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.EconomicRiskCounter;
import net.bambooslips.demo.jpa.model.TeamEssential;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface EconomicRiskCounterService {

    Long create(EconomicRiskCounter economicRiskCounter);

    @Transactional(rollbackFor = EconomicRiskCounterNotFoundException.class)
    /**
     * 更新基本信息
     */
    EconomicRiskCounter update(EconomicRiskCounter update);


    List<EconomicRiskCounter> delete(Long id);

//    Long findByEntireId(Long entireId);

//    Page<UnitEssential> findByComName(String comName);
}
