package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.EconomicRiskCounter;
import net.bambooslips.demo.jpa.model.EducationExperionce;
import net.bambooslips.demo.jpa.model.UnitEssential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface EconomicRiskCounterRepository extends JpaRepository<EconomicRiskCounter, Long> {

    /**
     * 查询
     * @return
     */
    @Query(
            "Select erc FROM EconomicRiskCounter erc WHERE erc.entireId=:entireId "
    )
    EconomicRiskCounter findByEntireId(@Param("entireId") Long entireId);


}
