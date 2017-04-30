package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CoreTeamNotFoundException;
import net.bambooslips.demo.exception.PatentListNotFoundException;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.PatentList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface CoreTeamService {

    Long create(CoreTeam coreTeam);

    @Transactional(rollbackFor = CoreTeamNotFoundException.class)
    /**
     * 更新法定联系人
     */
    CoreTeam update(CoreTeam update);


    CoreTeam delete(Long id);
}
