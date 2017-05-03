package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.DebtFinancing;
import net.bambooslips.demo.jpa.model.DemandFinancial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface DemandFinancialRepository extends JpaRepository<DemandFinancial, Long> {

    @Query(
            "Select df FROM DemandFinancial df WHERE df.entireId=:entireId"
    )
    public DemandFinancial findByEntireId(@Param("entireId") Long entireId);

}
