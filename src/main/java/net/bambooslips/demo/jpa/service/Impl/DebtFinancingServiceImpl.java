package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.DebtFinancingNotFoundException;
import net.bambooslips.demo.exception.EquityFinancingNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.DebtFinancing;
import net.bambooslips.demo.jpa.model.EquityFinancing;
import net.bambooslips.demo.jpa.repository.DebtFinancingRepository;
import net.bambooslips.demo.jpa.repository.EquityFinancingRepository;
import net.bambooslips.demo.jpa.service.DebtFinancingService;
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
public class DebtFinancingServiceImpl implements DebtFinancingService{

    private static final Logger LOG = LoggerFactory.getLogger(DebtFinancingServiceImpl.class);
    @Resource
    private DebtFinancingRepository debtFinancingRepository;

    @Transactional
    @Override
    public Long create(DebtFinancing debtFinancing) {
        LOG.debug("Creating a new debtFinancing with information: " + debtFinancing);
        DebtFinancing result = debtFinancingRepository.save(debtFinancing);
        if(result != null){
            return debtFinancing.getDebtId();
        }
        return null;
    }

    /**
     * 更新债权融资信息
     * @param updated
     * @return
     * @throws DebtFinancingNotFoundException
     */
    @Transactional(rollbackFor = DebtFinancingNotFoundException.class)
    @Override
    public DebtFinancing update(DebtFinancing updated) throws DebtFinancingNotFoundException {
        LOG.debug("Updating DebtFinancing with information: " + updated);

        DebtFinancing debtFinancing = debtFinancingRepository.findOne(updated.getDebtId());

        if (debtFinancing == null) {
            LOG.debug("No post found with id: " + updated.getDebtId());
            throw new PostNotFoundException("Post "+updated.getDebtId()+" not found.");
        }
        debtFinancing.update(updated);

        return debtFinancing;
    }


    /**
     * 删除融资信息
     * @param id
     * @return
     * @throws DebtFinancingNotFoundException
     */
    @Transactional(rollbackFor = DebtFinancingNotFoundException.class)
    @Override
    public DebtFinancing delete(Long id) throws DebtFinancingNotFoundException {
        LOG.debug("Deleting DebtFinancing with id: " + id);

        DebtFinancing deleted = debtFinancingRepository.findOne(id);

        if (deleted == null) {
            LOG.debug("No CompetitionAccount found with id: " + id);
            throw new PostNotFoundException("No CompetitionAccount found with id: " + id);
        }

        debtFinancingRepository.delete(deleted);
        return deleted;
    }


}
