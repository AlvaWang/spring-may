package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface UnitBusinessPlanRepository extends JpaRepository<UnitBusinessPlan, Long> {

    @Query(
            "Select ubp FROM UnitBusinessPlan ubp WHERE ubp.entireId=:entireId"
    )
    public UnitBusinessPlan findByEntireId(@Param("entireId") Long entireId);

}
