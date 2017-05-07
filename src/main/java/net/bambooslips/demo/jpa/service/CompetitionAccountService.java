package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.CompetitionAccountNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface CompetitionAccountService {

    List<CompetitionAccount> search(String comAccName, String comAccPwd,String comAccType);
    Long create(CompetitionAccount competitionAccount);

    @Transactional(rollbackFor = CompetitionAccountNotFoundException.class)
    CompetitionAccount update(CompetitionAccount update);

    CompetitionAccount delete(Long id);

    List<CompetitionAccount> searchByComName(String comAccName);
}
