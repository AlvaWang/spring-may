package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.EconomicRiskCounterNotFoundException;
import net.bambooslips.demo.exception.EquityFinancingNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.EconomicRiskCounter;
import net.bambooslips.demo.jpa.model.EquityFinancing;
import net.bambooslips.demo.jpa.repository.EconomicRiskCounterRepository;
import net.bambooslips.demo.jpa.service.EconomicRiskCounterService;
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
public class EconomicRiskCounterServiceImpl implements EconomicRiskCounterService{

    private static final Logger LOG = LoggerFactory.getLogger(EconomicRiskCounterServiceImpl.class);
    @Resource
    private EconomicRiskCounterRepository economicRiskCounterRepository;

    @Transactional
    @Override
    public Long create(EconomicRiskCounter economicRiskCounter) {
        LOG.debug("Creating a new economicRiskCounter with information: " + economicRiskCounter);
        EconomicRiskCounter result = economicRiskCounterRepository.save(economicRiskCounter);
        if(result != null){
            return economicRiskCounter.getEconoId();
        }
        return null;
    }


    /**
     * 更新作品状态
     * @param updated
     * @return
     * @throws EconomicRiskCounterNotFoundException
     */
    @Transactional(rollbackFor = EconomicRiskCounterNotFoundException.class)
    @Override
    public EconomicRiskCounter update(EconomicRiskCounter updated) throws EconomicRiskCounterNotFoundException {
        LOG.debug("Updating EconomicRiskCounter with information: " + updated);

        EconomicRiskCounter economicRiskCounter = economicRiskCounterRepository.findOne(updated.getTbusId());

        if (economicRiskCounter == null) {
            LOG.debug("No post found with id: " + updated.getTbusId());
            throw new PostNotFoundException("Post "+updated.getTbusId()+" not found.");
        }
        economicRiskCounter.update(updated);

        return economicRiskCounter;
    }


//    @Transactional(readOnly = true)
//    @Override
//    public Long findByEntireId(Long entireId) {
//        LOG.debug("Finding UnitEssential by id: " + entireId);
//        List<EconomicRiskCounter> economicRiskCounter =  economicRiskCounterRepository.findByEntireId(entireId);
//        if (economicRiskCounter != null){
//            Long econoId = economicRiskCounter.getEconoId();
//            return econoId;
//        } else {
//            return null;
//        }
//    }



    @Override
    public List<EconomicRiskCounter> findListByEntireId(Long id) {

        LOG.debug("Deleting EconomicRiskCounter with id: " + id);


        List<EconomicRiskCounter> deleted = economicRiskCounterRepository.findByEntireId(id);

        return deleted;

    }


    @Override
    public List<EconomicRiskCounter> delete(Long id) {

        LOG.debug("Deleting EconomicRiskCounter with id: " + id);


        List<EconomicRiskCounter> deleted = economicRiskCounterRepository.findByEntireId(id);

        if (deleted == null) {
            LOG.debug("No EconomicRiskCounter found with id: " + id);
            throw new EconomicRiskCounterNotFoundException("No EconomicRiskCounter found with id: " + id);
        }else {
            economicRiskCounterRepository.deleteByEntireId(id);

            return deleted;
        }

    }


}
