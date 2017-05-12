package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.FinancialForecasting;
import net.bambooslips.demo.jpa.model.FinancialHistorical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

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
            "Select ff.foreId,ff.foreYear FROM FinancialForecasting ff WHERE ff.entireId=:entireId "
    )
    List<FinancialForecasting> findByEntireId(@Param("entireId") Long entireId);

}
