package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.LegalRepresentative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Transactional
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

    /**
     * 查询
     * @param entireId
     * @return
     */
    @Query(
            "Select c FROM Contacts c WHERE c.entireId=:entireId"
    )
    public Contacts findByEntireId(@Param("entireId") Long entireId);

}
