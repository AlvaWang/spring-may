package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.DebtFinancingNotFoundException;
import net.bambooslips.demo.exception.EquityFinancingNotFoundException;
import net.bambooslips.demo.jpa.model.DebtFinancing;
import net.bambooslips.demo.jpa.model.EquityFinancing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface DebtFinancingService {

    Long create(DebtFinancing debtFinancing);

    @Transactional(rollbackFor = DebtFinancingNotFoundException.class)
    /**
     * 更新法定联系人
     */
    DebtFinancing update(DebtFinancing update);


    DebtFinancing delete(Long id);
}
