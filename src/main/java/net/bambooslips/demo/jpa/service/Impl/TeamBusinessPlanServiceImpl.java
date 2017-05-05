package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.exception.TeamBusinessPlanNotFoundException;
import net.bambooslips.demo.exception.UnitBusinessPlanNotFoundException;
import net.bambooslips.demo.jpa.model.TeamBusinessPlan;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import net.bambooslips.demo.jpa.repository.TeamBusinessPlanRepository;
import net.bambooslips.demo.jpa.repository.UnitBusinessPlanRepository;
import net.bambooslips.demo.jpa.service.TeamBusinessPlanService;
import net.bambooslips.demo.jpa.service.UnitBusinessPlanService;
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
public class TeamBusinessPlanServiceImpl implements TeamBusinessPlanService{

    private static final Logger LOG = LoggerFactory.getLogger(TeamBusinessPlanServiceImpl.class);
    @Resource
    private TeamBusinessPlanRepository teamBusinessPlanRepository;

    @Transactional
    @Override
    public Long create(TeamBusinessPlan teamBusinessPlan) {
        LOG.debug("Creating a new UnitBusinessPlan with information: " + teamBusinessPlan);
        TeamBusinessPlan result = teamBusinessPlanRepository.save(teamBusinessPlan);
        if(result != null){
            return teamBusinessPlan.getTbusId();
        }
        return null;
    }

    /**
     * 更新商业计划书
     * @param updated
     * @return
     * @throws net.bambooslips.demo.exception.TeamBusinessPlanNotFoundException
     */
    @Transactional(rollbackFor = TeamBusinessPlanNotFoundException.class)
    @Override
    public TeamBusinessPlan update(TeamBusinessPlan updated) throws TeamBusinessPlanNotFoundException {
        LOG.debug("Updating TeamBusinessPlan with information: " + updated);

        TeamBusinessPlan teamBusinessPlan = teamBusinessPlanRepository.findOne(updated.getTbusId());

        if (teamBusinessPlan == null) {
            LOG.debug("No post found with id: " + updated.getTbusId());
            throw new PostNotFoundException("Post "+updated.getTbusId()+" not found.");
        }
        teamBusinessPlan.update(updated);

        return teamBusinessPlan;
    }

    @Transactional(readOnly = true)
    @Override
    public Long findByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        TeamBusinessPlan teamBusinessPlan =  teamBusinessPlanRepository.findByEntireId(entireId);
        if (teamBusinessPlan != null){
            Long tbusId = teamBusinessPlan.getTbusId();
            return tbusId;
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TeamBusinessPlan> findEntireProName(Long entireId){
        List<TeamBusinessPlan> list =teamBusinessPlanRepository.findEntireProName(entireId);
        return list;
    }


}
