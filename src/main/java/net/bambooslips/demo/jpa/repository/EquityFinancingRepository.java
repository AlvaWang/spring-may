package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.DebtFinancing;
import net.bambooslips.demo.jpa.model.EquityFinancing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface EquityFinancingRepository extends JpaRepository<EquityFinancing, Long> {

    @Query(
            "Select ef FROM EquityFinancing ef WHERE ef.entireId=:entireId"
    )
    public EquityFinancing findByEntireId(@Param("entireId") Long entireId);

}
