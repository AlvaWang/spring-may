package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.FinancialHistorical;
import net.bambooslips.demo.jpa.model.PatentList;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface FinancialHistoricalRepository extends JpaRepository<FinancialHistorical, Long> {

    /**
     * 查询
     * @return
     */
    @Query(
            "Select fh.hfinId,fh.hfinYear FROM FinancialHistorical fh WHERE fh.entireId=:entireId "
    )
    List<FinancialHistorical> findByEntireId(@Param("entireId") Long entireId);

    @Query(
            "Select fh FROM FinancialHistorical fh WHERE fh.entireId=:entireId "
    )
    List<FinancialHistorical> findListByEntireId(@Param("entireId") Long entireId);

}
