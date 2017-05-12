package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CompetitionAccountNotFoundException;
import net.bambooslips.demo.exception.CompetitionEntireNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.model.UnitEssential;
import net.bambooslips.demo.jpa.repository.CompetitionAccountRepository;
import net.bambooslips.demo.jpa.repository.CompetitionEntireRepository;
import net.bambooslips.demo.jpa.repository.UnitEssentialRepository;
import net.bambooslips.demo.jpa.service.CompetitionAccountService;
import net.bambooslips.demo.jpa.service.CompetitionEntireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class CompetitionEntireServiceImpl implements CompetitionEntireService{

    private static final Logger LOG = LoggerFactory.getLogger(CompetitionEntireServiceImpl.class);
    @Resource
    private CompetitionEntireRepository competitionEntireRepository;

    @Transactional
    @Override
    public Long create(CompetitionEntire competitionEntire) {
        LOG.debug("Creating a new competitionEntire with information: " + competitionEntire);
        CompetitionEntire result = competitionEntireRepository.save(competitionEntire);
        if(result != null){
            return competitionEntire.getEntireId();
        }
        return null;
    }

    /**
     * 更新作品状态
     * @param updated
     * @return
     * @throws CompetitionEntireNotFoundException
     */
    @Transactional(rollbackFor = CompetitionEntireNotFoundException.class)
    @Override
    public CompetitionEntire updateWorkState(CompetitionEntire updated) throws CompetitionEntireNotFoundException {
        LOG.debug("Updating CompetitionEntire with information: " + updated);

        CompetitionEntire competitionEntire = competitionEntireRepository.findOne(updated.getEntireId());

        if (competitionEntire == null) {
            LOG.debug("No post found with id: " + updated.getEntireId());
            throw new PostNotFoundException("Post "+updated.getWorkState()+" not found.");
        }
        competitionEntire.update(updated);

        return competitionEntire;
    }

    /**
     * 删除作品
     * @param updated
     * @return
     * @throws CompetitionEntireNotFoundException
     */
    @Transactional(rollbackFor = CompetitionEntireNotFoundException.class)
    @Override
    public CompetitionEntire updateState(CompetitionEntire updated) throws CompetitionEntireNotFoundException {
        LOG.debug("Updating CompetitionEntire with information: " + updated);

        CompetitionEntire competitionEntire = competitionEntireRepository.findOne(updated.getEntireId());

        if (competitionEntire == null) {
            LOG.debug("No post found with id: " + updated.getEntireId());
            throw new PostNotFoundException("Post "+updated.getState()+" not found.");
        }
        competitionEntire.updateState(updated);

        return competitionEntire;
    }
    @Override
    public CompetitionEntire delete(Long id) {
        return null;
    }

    @Override
    public List<CompetitionEntire> findAllEntireList(String comName,String workState) {
        List<CompetitionEntire> list =competitionEntireRepository.findByComName(comName,workState);
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public String findByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        CompetitionEntire competitionEntire =  competitionEntireRepository.findByEntireId(entireId);
        if (competitionEntire != null){
            String tbusId = competitionEntire.getWorkState();
            return tbusId;
        } else {
            return null;
        }
    }

}
