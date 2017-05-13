package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CoreTeamNotFoundException;
import net.bambooslips.demo.exception.EquityFinancingNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.EquityFinancing;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import net.bambooslips.demo.jpa.repository.CoreTeamRepository;
import net.bambooslips.demo.jpa.repository.EquityFinancingRepository;
import net.bambooslips.demo.jpa.service.CoreTeamService;
import net.bambooslips.demo.jpa.service.EquityFinancingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class EquityFinancingServiceImpl implements EquityFinancingService{

    private static final Logger LOG = LoggerFactory.getLogger(EquityFinancingServiceImpl.class);
    @Resource
    private EquityFinancingRepository equityFinancingRepository;

    @Transactional
    @Override
    public Long create(EquityFinancing equityFinancing) {
        LOG.debug("Creating a new equityFinancing with information: " + equityFinancing);
        EquityFinancing result = equityFinancingRepository.save(equityFinancing);
        if(result != null){
            return equityFinancing.getEquityId();
        }
        return null;
    }

    /**
     * 更新股权融资信息
     * @param updated
     * @return
     * @throws EquityFinancingNotFoundException
     */
    @Transactional(rollbackFor = EquityFinancingNotFoundException.class)
    @Override
    public EquityFinancing update(EquityFinancing updated) throws EquityFinancingNotFoundException {
        LOG.debug("Updating CoreTeam with information: " + updated);

        EquityFinancing equityFinancing = equityFinancingRepository.findOne(updated.getEquityId());

        if (equityFinancing == null) {
            LOG.debug("No post found with id: " + updated.getEquityId());
            throw new PostNotFoundException("Post "+updated.getEquityId()+" not found.");
        }
        equityFinancing.update(updated);

        return equityFinancing;
    }


    /**
     * 删除融资信息
     * @param entireId
     * @return
     * @throws EquityFinancingNotFoundException
     */
    @Transactional(rollbackFor = EquityFinancingNotFoundException.class)
    @Override
    public EquityFinancing delete(Long entireId) throws EquityFinancingNotFoundException {
        LOG.debug("Deleting EquityFinancing with id: " + entireId);

        EquityFinancing deleted = equityFinancingRepository.findByEntireId(entireId);

        if (deleted == null) {
            LOG.debug("No CompetitionAccount found with id: " + entireId);
            throw new EquityFinancingNotFoundException("No CompetitionAccount found with id: " + entireId);
        }else {
            Long efId = deleted.getEquityId();
            equityFinancingRepository.delete(efId);

            return deleted;
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Long findByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        EquityFinancing equityFinancing =  equityFinancingRepository.findByEntireId(entireId);
        if (equityFinancing != null){
            Long ueId = equityFinancing.getEquityId();
            return ueId;
        } else {
            return null;
        }
    }


    @Transactional(readOnly = true)
    @Override
    public EquityFinancing findListByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        EquityFinancing equityFinancing =  equityFinancingRepository.findByEntireId(entireId);
       return equityFinancing;
    }



}
