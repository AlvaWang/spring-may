package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.EducationExperionce;
import net.bambooslips.demo.jpa.model.TeamEssential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface EducationExperionceRepository extends JpaRepository<EducationExperionce, Long> {

    /**
     * 查询
     * @return
     */
//    @Query(
//            "Select te FROM TeamEssential te WHERE te.entireId=:entireId "
//    )
//    TeamEssential findByEntireId(@Param("entireId") Long entireId);


}
