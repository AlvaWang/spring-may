package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.FinancialHistoricalNotFoundException;
import net.bambooslips.demo.jpa.model.FinancialForecasting;
import net.bambooslips.demo.jpa.model.FinancialHistorical;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface FinancialForecastingService {

    Long create(FinancialForecasting financialForecasting);

    @Transactional(rollbackFor = FinancialHistoricalNotFoundException.class)
    /**
     * 更新法定联系人
     */
    FinancialForecasting update(FinancialForecasting update);

    List<FinancialForecasting> findByEntireId(Long entireId);

    List<FinancialForecasting> findListByEntireId(Long entireId);


//    UnitBusinessPlan delete(Long id);
}
