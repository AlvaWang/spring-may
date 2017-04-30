package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.ContactsNotFoundException;
import net.bambooslips.demo.exception.PatentListNotFoundException;
import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.PatentList;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface PatentListService {

    Long create(PatentList patentList);

    @Transactional(rollbackFor = PatentListNotFoundException.class)
    /**
     * 更新法定联系人
     */
    PatentList update(PatentList update);


    PatentList delete(Long id);
}
