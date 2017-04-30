package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.FinancialForecasting;
import net.bambooslips.demo.jpa.model.FinancialHistorical;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface FinancialForecastingRepository extends JpaRepository<FinancialForecasting, Long> {

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
