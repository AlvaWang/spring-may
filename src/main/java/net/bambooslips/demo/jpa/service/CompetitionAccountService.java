package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.jpa.model.CompetitionAccount;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface CompetitionAccountService {

    List<CompetitionAccount> search(String comAccName, String comAccPwd,String comAccType);
    CompetitionAccount create(CompetitionAccount competitionAccount);
}
