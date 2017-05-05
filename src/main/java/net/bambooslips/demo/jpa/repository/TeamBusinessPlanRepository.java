package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.TeamBusinessPlan;
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
public interface TeamBusinessPlanRepository extends JpaRepository<TeamBusinessPlan, Long> {

    @Query(
            "Select tbp FROM TeamBusinessPlan tbp WHERE tbp.entireId=:entireId"
    )
    public TeamBusinessPlan findByEntireId(@Param("entireId") Long entireId);


    @Query(
            "Select tbp.tbusProName FROM TeamBusinessPlan tbp WHERE tbp.entireId=:entireId"
    )
    List<TeamBusinessPlan> findEntireProName(@Param("entireId") Long entireId);
}
