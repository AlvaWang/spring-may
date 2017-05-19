package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.EducationExperionce;
import net.bambooslips.demo.jpa.model.TeamEssential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface EducationExperionceRepository extends JpaRepository<EducationExperionce, Long> {

    /**
     * 查询
     * @return
     */
    @Query(
            "Select ee FROM EducationExperionce ee WHERE ee.ctId=:ctId "
    )
    List<EducationExperionce> findListByEntireId(@Param("ctId") Long ctId);

    @Modifying
    @Query("delete from EducationExperionce ee where ee.ctId in (:ctId)")
    public int deleteByEntireId(@Param("ctId")Long ctId);


}
