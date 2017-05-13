package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.FinancialForecastingNotFoundException;
import net.bambooslips.demo.exception.FinancialHistoricalNotFoundException;
import net.bambooslips.demo.exception.UnitBusinessPlanNotFoundException;
import net.bambooslips.demo.jpa.model.FinancialForecasting;
import net.bambooslips.demo.jpa.model.FinancialHistorical;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface FinancialHistoricalService {

    Long create(FinancialHistorical financialHistorical);

    @Transactional(rollbackFor = FinancialForecastingNotFoundException.class)
    /**
     * 更新法定联系人
     */
    FinancialHistorical update(FinancialHistorical update);

    List<FinancialHistorical> findByEntireId(Long entireId);

    List<FinancialHistorical> findListByEntireId(Long entireId);

//    UnitBusinessPlan delete(Long id);
}
