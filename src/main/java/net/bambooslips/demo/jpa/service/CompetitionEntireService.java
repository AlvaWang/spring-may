package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CompetitionAccountNotFoundException;
import net.bambooslips.demo.exception.CompetitionEntireNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface CompetitionEntireService {

    Long create(CompetitionEntire competitionEntire);

    @Transactional(rollbackFor = CompetitionEntireNotFoundException.class)
    /**
     * 更新作品状态
     */
    CompetitionEntire updateWorkState(CompetitionEntire update);

    /**
     * 删除作品
     * @param update
     * @return
     */
    CompetitionEntire updateState(CompetitionEntire update);

    CompetitionEntire delete(Long id);

    List<CompetitionEntire> findAllEntireList(String comName,String workState);

    String findByEntireId(Long entireId);

//    Page<CompetitionEntire> findByComName(String comName);
}
