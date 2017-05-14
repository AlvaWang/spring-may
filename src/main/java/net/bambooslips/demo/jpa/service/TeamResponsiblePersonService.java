package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.ContactsNotFoundException;
import net.bambooslips.demo.exception.TeamResponsiblePersonNotFoundException;
import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.TeamResponsiblePerson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface TeamResponsiblePersonService {

    Long create(TeamResponsiblePerson teamResponsiblePerson);

    @Transactional(rollbackFor = TeamResponsiblePersonNotFoundException.class)
    /**
     * 更新法定联系人
     */
    TeamResponsiblePerson update(TeamResponsiblePerson update);


    TeamResponsiblePerson delete(Long id);

    Long findByEntireId(Long entireId);

    TeamResponsiblePerson findListByEntireId(Long entireId);
}
