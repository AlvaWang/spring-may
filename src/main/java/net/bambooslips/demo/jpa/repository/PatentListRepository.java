package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.PatentList;
import net.bambooslips.demo.jpa.model.UnitEssential;
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
public interface PatentListRepository extends JpaRepository<PatentList, Long> {

    /**
     * 查询
     * @return
     */
    @Query(
            "Select pl FROM PatentList pl WHERE pl.patentId=:patentId "
    )
    PatentList findByPatentId(@Param("patentId") String patentId);

    @Query(
            "Select pl FROM PatentList pl WHERE pl.id=:id "
    )
    PatentList findById(@Param("id") Long id);


    @Query(
            "Select pl FROM PatentList pl WHERE pl.entireId=:entireId "
    )
    List<PatentList> findListByEntireId(@Param("entireId") Long entireId);


}
