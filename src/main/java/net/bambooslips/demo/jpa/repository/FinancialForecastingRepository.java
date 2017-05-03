package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.FinancialForecasting;
import net.bambooslips.demo.jpa.model.FinancialHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface FinancialForecastingRepository extends JpaRepository<FinancialForecasting, Long> {

    /**
     * 查询
     * @return
     */
    @Query(
            "Select count(ff.entireId) FROM FinancialForecasting ff WHERE ff.entireId=:entireId "
    )
    int findByEntireId(@Param("entireId") Long entireId);

}
