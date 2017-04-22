package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.CompetitionAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface CompetitionAccountRepository extends JpaRepository<CompetitionAccount, Long> {

    /**
     * 查询
     * @param comAccName
     * @param comAccPwd
     * @return
     */
    @Query(
            "Select ca FROM CompetitionAccount ca WHERE ca.comAccName=:comAccName and ca.comAccPwd=:comAccPwd and ca.comAccType=:comAccType"
    )
    public List<CompetitionAccount> searchByName(@Param("comAccName") String comAccName,
                                                 @Param("comAccPwd") String comAccPwd,
                                                 @Param("comAccType") String comAccType);

}
