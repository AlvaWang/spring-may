package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.model.TeamBusinessPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface CompetitionEntireRepository extends JpaRepository<CompetitionEntire, Long>{

    @Query(
            "SELECT ce.entireId,ce.entryType from CompetitionEntire ce where ce.comName=:comName and ce.workState = :workState"
    )
    List<CompetitionEntire> findByComName(@Param("comName") String comName,@Param("workState") String workState);

    @Query(
            "Select ce FROM CompetitionEntire ce WHERE ce.entireId=:entireId"
    )
    public CompetitionEntire findByEntireId(@Param("entireId") Long entireId);
}
