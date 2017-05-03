package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.exception.UnitBusinessPlanNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import net.bambooslips.demo.jpa.repository.UnitBusinessPlanRepository;
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
public class UnitBusinessPlanServiceImpl implements UnitBusinessPlanService{

    private static final Logger LOG = LoggerFactory.getLogger(UnitBusinessPlanServiceImpl.class);
    @Resource
    private UnitBusinessPlanRepository unitBusinessPlanRepository;

    @Transactional
    @Override
    public Long create(UnitBusinessPlan unitBusinessPlan) {
        LOG.debug("Creating a new UnitBusinessPlan with information: " + unitBusinessPlan);
        UnitBusinessPlan result = unitBusinessPlanRepository.save(unitBusinessPlan);
        if(result != null){
            return unitBusinessPlan.getUbusId();
        }
        return null;
    }

    /**
     * 更新商业计划书
     * @param updated
     * @return
     * @throws UnitBusinessPlanNotFoundException
     */
    @Transactional(rollbackFor = UnitBusinessPlanNotFoundException.class)
    @Override
    public UnitBusinessPlan update(UnitBusinessPlan updated) throws UnitBusinessPlanNotFoundException {
        LOG.debug("Updating UnitBusinessPlan with information: " + updated);

        UnitBusinessPlan unitBusinessPlan = unitBusinessPlanRepository.findOne(updated.getUbusId());

        if (unitBusinessPlan == null) {
            LOG.debug("No post found with id: " + updated.getUbusId());
            throw new PostNotFoundException("Post "+updated.getUbusId()+" not found.");
        }
        unitBusinessPlan.update(updated);

        return unitBusinessPlan;
    }

    @Transactional(readOnly = true)
    @Override
    public Long findByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        UnitBusinessPlan unitBusinessPlan =  unitBusinessPlanRepository.findByEntireId(entireId);
        if (unitBusinessPlan != null){
            Long ueId = unitBusinessPlan.getUbusId();
            return ueId;
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<UnitBusinessPlan> findEntireProName(Long entireId){
        List<UnitBusinessPlan> list =unitBusinessPlanRepository.findEntireProName(entireId);
        return list;
    }


}
