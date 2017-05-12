package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.FinancialHistoricalNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.exception.UnitBusinessPlanNotFoundException;
import net.bambooslips.demo.jpa.model.FinancialHistorical;
import net.bambooslips.demo.jpa.model.PatentList;
import net.bambooslips.demo.jpa.model.UnitBusinessPlan;
import net.bambooslips.demo.jpa.repository.FinancialHistoricalRepository;
import net.bambooslips.demo.jpa.repository.UnitBusinessPlanRepository;
import net.bambooslips.demo.jpa.service.FinancialHistoricalService;
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
public class FinancialHistoricalServiceImpl implements FinancialHistoricalService{

    private static final Logger LOG = LoggerFactory.getLogger(FinancialHistoricalServiceImpl.class);
    @Resource
    private FinancialHistoricalRepository financialHistoricalRepository;

    @Transactional
    @Override
    public Long create(FinancialHistorical financialHistorical) {
        LOG.debug("Creating a new financialHistorical with information: " + financialHistorical);
        FinancialHistorical result = financialHistoricalRepository.save(financialHistorical);
        if(result != null){
            return financialHistorical.getHfinId();
        }
        return null;
    }

    /**
     * 更新历史财务数据
     * @param updated
     * @return
     * @throws FinancialHistoricalNotFoundException
     */
    @Transactional(rollbackFor = FinancialHistoricalNotFoundException.class)
    @Override
    public FinancialHistorical update(FinancialHistorical updated) throws FinancialHistoricalNotFoundException {
        LOG.debug("Updating FinancialHistorical with information: " + updated);

        FinancialHistorical financialHistorical = financialHistoricalRepository.findOne(updated.getHfinId());

        if (financialHistorical == null) {
            LOG.debug("No post found with id: " + updated.getHfinId());
            throw new PostNotFoundException("Post "+updated.getHfinId()+" not found.");
        }
        financialHistorical.update(updated);

        return financialHistorical;
    }

    @Transactional(readOnly = true)
    @Override
    public  List<FinancialHistorical> findByEntireId(Long entireId) {
        LOG.debug("Finding patentList by id: " + entireId);
        List<FinancialHistorical> list =  financialHistoricalRepository.findByEntireId(entireId);
        if (list != null && list.size()>0){
            return list;
        } else {
            return null;
        }
    }

}
