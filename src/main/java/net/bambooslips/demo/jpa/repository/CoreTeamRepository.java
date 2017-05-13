package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.PatentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface CoreTeamRepository extends JpaRepository<CoreTeam, Long> {

    /**
     * 查询
     * @return
     */
    @Query(
            "Select count(ct.entireId) FROM CoreTeam ct WHERE ct.entireId=:entireId "
    )
    int findByEntireId(@Param("entireId") Long entireId);

    @Query(
            "Select ct FROM CoreTeam ct WHERE ct.entireId=:entireId "
    )
    List<CoreTeam> findListByEntireId(@Param("entireId") Long entireId);


}
