package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.UnitEssential;
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
public interface UnitEssentialRepository extends JpaRepository<UnitEssential, Long> {

    /**
     * 查询
     * @return
     */
    @Query(
            "Select ue FROM UnitEssential ue WHERE ue.entireId=:entireId "
    )
    UnitEssential findByEntireId(@Param("entireId") Long entireId);


}
