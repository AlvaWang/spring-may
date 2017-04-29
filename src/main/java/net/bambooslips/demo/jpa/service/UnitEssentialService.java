package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CompetitionEntireNotFoundException;
import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.model.UnitEssential;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface UnitEssentialService {

    Long create(UnitEssential unitEssential);

    @Transactional(rollbackFor = UnitEssentialNotFoundException.class)
    /**
     * 更新基本信息
     */
    UnitEssential update(UnitEssential update);


    UnitEssential delete(Long id);
}
