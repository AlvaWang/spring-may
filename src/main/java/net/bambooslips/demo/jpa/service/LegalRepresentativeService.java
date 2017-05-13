package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CompetitionEntireNotFoundException;
import net.bambooslips.demo.exception.LegalRepresentativeNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.model.LegalRepresentative;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface LegalRepresentativeService {

    Long create(LegalRepresentative legalRepresentative);

    @Transactional(rollbackFor = LegalRepresentativeNotFoundException.class)
    /**
     * 更新法定联系人
     */
    LegalRepresentative update(LegalRepresentative update);


    Long findByEntireId(Long entireId);

    LegalRepresentative delete(Long id);

    LegalRepresentative findListByEntireId(Long entireId);
}
