package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.TeamEssentialNotFoundException;
import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.TeamEssential;
import net.bambooslips.demo.jpa.model.UnitEssential;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface TeamEssentialService {

    Long create(TeamEssential teamEssential);

    @Transactional(rollbackFor = TeamEssentialNotFoundException.class)
    /**
     * 更新基本信息
     */
    TeamEssential update(TeamEssential update);


    TeamEssential delete(Long id);

    Long findByEntireId(Long entireId);

//    Page<UnitEssential> findByComName(String comName);
}
