package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.DebtFinancing;
import net.bambooslips.demo.jpa.model.EquityFinancing;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface DebtFinancingRepository extends JpaRepository<DebtFinancing, Long> {

    @Query(
            "Select df FROM DebtFinancing df WHERE df.entireId=:entireId"
    )
    public DebtFinancing findByEntireId(@Param("entireId") Long entireId);

    @Modifying
    @Query("delete from DebtFinancing df where df.entireId in (:entireId)")
    public DebtFinancing deleteByEntireId(@Param("entireId")Long entireId);
}
