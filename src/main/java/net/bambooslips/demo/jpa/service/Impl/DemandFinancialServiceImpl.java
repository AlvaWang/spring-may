package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CoreTeamNotFoundException;
import net.bambooslips.demo.exception.DebtFinancingNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.DebtFinancing;
import net.bambooslips.demo.jpa.model.DemandFinancial;
import net.bambooslips.demo.jpa.repository.CoreTeamRepository;
import net.bambooslips.demo.jpa.repository.DemandFinancialRepository;
import net.bambooslips.demo.jpa.service.CoreTeamService;
import net.bambooslips.demo.jpa.service.DemandFinancialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class DemandFinancialServiceImpl implements DemandFinancialService{

    private static final Logger LOG = LoggerFactory.getLogger(DemandFinancialServiceImpl.class);
    @Resource
    private DemandFinancialRepository demandFinancialRepository;

    @Transactional
    @Override
    public Long create(DemandFinancial demandFinancial) {
        LOG.debug("Creating a new demandFinancial with information: " + demandFinancial);
        DemandFinancial result = demandFinancialRepository.save(demandFinancial);
        if(result != null){
            return demandFinancial.getDfId();
        }
        return null;
    }

    /**
     * 更新
     * @param updated
     * @return
     * @throws DebtFinancingNotFoundException
     */
    @Transactional(rollbackFor = DebtFinancingNotFoundException.class)
    @Override
    public DemandFinancial update(DemandFinancial updated) throws DebtFinancingNotFoundException {
        LOG.debug("Updating DemandFinancial with information: " + updated);

        DemandFinancial demandFinancial = demandFinancialRepository.findOne(updated.getDfId());

        if (demandFinancial == null) {
            LOG.debug("No post found with id: " + updated.getDfId());
            throw new PostNotFoundException("Post "+updated.getDfId()+" not found.");
        }
        demandFinancial.update(updated);

        return demandFinancial;
    }


    /**
     * 根据核心团队ID删除核心成员信息
     * @param id
     * @return
     * @throws DebtFinancingNotFoundException
     */
    @Transactional(rollbackFor = DebtFinancingNotFoundException.class)
    @Override
    public DemandFinancial delete(Long id) throws DebtFinancingNotFoundException {
        LOG.debug("Deleting CoreTeam with id: " + id);

        DemandFinancial deleted = demandFinancialRepository.findOne(id);

        if (deleted == null) {
            LOG.debug("No CompetitionAccount found with id: " + id);
            throw new PostNotFoundException("No CompetitionAccount found with id: " + id);
        }

        demandFinancialRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public Long findByEntireId(Long entireId) {
        LOG.debug("Finding demandFinancial by id: " + entireId);
        DemandFinancial demandFinancial =  demandFinancialRepository.findByEntireId(entireId);
        if (demandFinancial != null){
            Long ueId = demandFinancial.getDfId();
            return ueId;
        } else {
            return null;
        }
    }



    @Transactional(readOnly = true)
    @Override
    public DemandFinancial findListByEntireId(Long entireId) {
        LOG.debug("Finding demandFinancial by id: " + entireId);
        DemandFinancial demandFinancial =  demandFinancialRepository.findByEntireId(entireId);
        return demandFinancial;
    }
}
