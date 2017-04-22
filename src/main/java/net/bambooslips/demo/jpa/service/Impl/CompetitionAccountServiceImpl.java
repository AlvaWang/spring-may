package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.Post;
import net.bambooslips.demo.jpa.repository.CompetitionAccountRepository;
import net.bambooslips.demo.jpa.service.CompetitionAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class CompetitionAccountServiceImpl implements CompetitionAccountService{

    private static final Logger LOG = LoggerFactory.getLogger(PostServiceImpl.class);
    @Resource
    private CompetitionAccountRepository competitionAccountRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CompetitionAccount> search(String comAccName, String comAccPwd,String comAccType) {
        LOG.debug("Searching post by title: " + comAccName+","+comAccPwd+","+comAccType);
        List<CompetitionAccount> list = competitionAccountRepository.searchByName(comAccName,comAccPwd,comAccType);
        return list;
    }

    @Transactional
    @Override
    public CompetitionAccount create(CompetitionAccount competitionAccount) {
        LOG.debug("Creating a new post with information: " + competitionAccount);
        return competitionAccountRepository.save(competitionAccount);
    }

}
