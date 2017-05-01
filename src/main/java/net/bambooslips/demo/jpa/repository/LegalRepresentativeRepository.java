package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.LegalRepresentative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface LegalRepresentativeRepository extends JpaRepository<LegalRepresentative, Long> {

    /**
     * 查询
     * @param entireId
     * @return
     */
    @Query(
            "Select lr FROM LegalRepresentative lr WHERE lr.entireId=:entireId"
    )
    public LegalRepresentative findByEntireId(@Param("entireId") Long entireId);
}
