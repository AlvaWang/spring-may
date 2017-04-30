package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface UnitBusinessPlanRepository extends JpaRepository<UnitBusinessPlan, Long> {

    /**
     * 查询
     * @param comAccName
     * @param comAccPwd
     * @return
     */
//    @Query(
//            "Select ca FROM CompetitionAccount ca WHERE ca.comAccName=:comAccName and ca.comAccPwd=:comAccPwd and ca.comAccType=:comAccType"
//    )
//    public List<CompetitionAccount> searchByName(@Param("comAccName") String comAccName,
//                                                 @Param("comAccPwd") String comAccPwd,
//                                                 @Param("comAccType") String comAccType);

}
