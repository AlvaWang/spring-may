package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
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
            "SELECT ce.entireId from CompetitionEntire ce where ce.comName=:comName  "
    )
    List<CompetitionEntire> findByComName(@Param("comName") String comName);
}
