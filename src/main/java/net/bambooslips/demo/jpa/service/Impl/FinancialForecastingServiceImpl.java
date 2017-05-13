package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.FinancialForecastingNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.FinancialForecasting;
import net.bambooslips.demo.jpa.repository.FinancialForecastingRepository;
import net.bambooslips.demo.jpa.service.FinancialForecastingService;
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
public class FinancialForecastingServiceImpl implements FinancialForecastingService {

    private static final Logger LOG = LoggerFactory.getLogger(FinancialForecastingServiceImpl.class);
    @Resource
    private FinancialForecastingRepository financialForecastingRepository;

    @Transactional
    @Override
    public Long create(FinancialForecasting financialForecasting) {
        LOG.debug("Creating a new financialForecasting with information: " + financialForecasting);
        FinancialForecasting result = financialForecastingRepository.save(financialForecasting);
        if(result != null){
            return financialForecasting.getForeId();
        }
        return null;
    }

    /**
     * 更新财务预测数据
     * @param updated
     * @return
     * @throws FinancialForecastingNotFoundException
     */
    @Transactional(rollbackFor = FinancialForecastingNotFoundException.class)
    @Override
    public FinancialForecasting update(FinancialForecasting updated) throws FinancialForecastingNotFoundException {
        LOG.debug("Updating FinancialForecasting with information: " + updated);

        FinancialForecasting financialForecasting = financialForecastingRepository.findOne(updated.getForeId());

        if (financialForecasting == null) {
            LOG.debug("No post found with id: " + updated.getForeId());
            throw new PostNotFoundException("Post "+updated.getForeId()+" not found.");
        }
        financialForecasting.update(updated);

        return financialForecasting;
    }

    @Transactional(readOnly = true)
    @Override
    public  List<FinancialForecasting>  findByEntireId(Long entireId) {
        LOG.debug("Finding patentList by id: " + entireId);
        List<FinancialForecasting> list =  financialForecastingRepository.findByEntireId(entireId);
        if (list != null && list.size()>0){
            return list;
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public  List<FinancialForecasting>  findListByEntireId(Long entireId) {
        LOG.debug("Finding patentList by id: " + entireId);
        List<FinancialForecasting> list =  financialForecastingRepository.findListByEntireId(entireId);
        if (list != null && list.size()>0){
            return list;
        } else {
            return null;
        }
    }

}
