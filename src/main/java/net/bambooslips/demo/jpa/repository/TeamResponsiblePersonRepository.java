package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.TeamResponsiblePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface TeamResponsiblePersonRepository extends JpaRepository<TeamResponsiblePerson, Long> {

    /**
     * 查询
     * @param entireId
     * @return
     */
    @Query(
            "Select trp FROM TeamResponsiblePerson trp WHERE trp.entireId=:entireId"
    )
    public TeamResponsiblePerson findByEntireId(@Param("entireId") Long entireId);

}
