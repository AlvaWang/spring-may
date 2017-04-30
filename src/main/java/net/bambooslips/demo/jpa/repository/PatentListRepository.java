package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.PatentList;
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
     * @param patentId
     * @return
     */
//    @Modifying//注解实现修改

//    @Query(
//            "update PatentList set  where patentId = :patentId"
//    )
//    PatentList findByPatentId(@Param("patentId") String patentId);


}
