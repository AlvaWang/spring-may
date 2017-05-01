package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.ContactsNotFoundException;
import net.bambooslips.demo.exception.LegalRepresentativeNotFoundException;
import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.LegalRepresentative;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface ContactsService {

    Long create(Contacts contacts);

    @Transactional(rollbackFor = ContactsNotFoundException.class)
    /**
     * 更新法定联系人
     */
    Contacts update(Contacts update);


    Contacts delete(Long id);

    Long findByEntireId(Long entireId);
}
