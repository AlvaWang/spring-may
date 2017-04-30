package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CompetitionAccountNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
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

    private static final Logger LOG = LoggerFactory.getLogger(CompetitionAccountServiceImpl.class);
    @Resource
    private CompetitionAccountRepository competitionAccountRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CompetitionAccount> search(String comAccName, String comAccPwd,String comAccType) {
        LOG.debug("Searching post by title: " + comAccName+","+comAccPwd+","+comAccType);
        List<CompetitionAccount> list = competitionAccountRepository.searchByName(comAccName,comAccPwd,comAccType);
        if(list!= null){
//            Long id = CompetitionAccount.getId();
        }
        return list;
    }

    @Transactional
    @Override
    public Long create(CompetitionAccount competitionAccount) {
        LOG.debug("Creating a new post with information: " + competitionAccount);
        CompetitionAccount result = competitionAccountRepository.save(competitionAccount);
        if(result != null){
            return competitionAccount.getId();
        }
        return null;
    }

    @Transactional(rollbackFor = CompetitionAccountNotFoundException.class)
    @Override
    public CompetitionAccount update(CompetitionAccount updated) throws CompetitionAccountNotFoundException {
        LOG.debug("Updating CompetitionAccount with information: " + updated);

        CompetitionAccount competitionAccount = competitionAccountRepository.findOne(updated.getId());

        if (competitionAccount == null) {
            LOG.debug("No post found with id: " + updated.getId());
            throw new PostNotFoundException("Post "+updated.getComState()+" not found.");
        }
        competitionAccount.update(updated);

        return competitionAccount;
    }

    @Transactional(rollbackFor = PostNotFoundException.class)
    @Override
    public CompetitionAccount delete(Long id) throws CompetitionAccountNotFoundException {
        LOG.debug("Deleting CompetitionAccount with id: " + id);

        CompetitionAccount deleted = competitionAccountRepository.findOne(id);

        if (deleted == null) {
            LOG.debug("No CompetitionAccount found with id: " + id);
            throw new PostNotFoundException("No CompetitionAccount found with id: " + id);
        }

        competitionAccountRepository.delete(deleted);
        return deleted;
    }

}
