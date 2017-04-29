package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CompetitionEntireNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.model.UnitEssential;
import net.bambooslips.demo.jpa.repository.CompetitionEntireRepository;
import net.bambooslips.demo.jpa.repository.UnitEssentialRepository;
import net.bambooslips.demo.jpa.service.CompetitionEntireService;
import net.bambooslips.demo.jpa.service.UnitEssentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class UnitEssentialServiceImpl implements UnitEssentialService{

    private static final Logger LOG = LoggerFactory.getLogger(PostServiceImpl.class);
    @Resource
    private UnitEssentialRepository unitEssentialRepository;

    @Transactional
    @Override
    public Long create(UnitEssential unitEssential) {
        LOG.debug("Creating a new unitEssential with information: " + unitEssential);
        UnitEssential result = unitEssentialRepository.save(unitEssential);
        if(result != null){
            return unitEssential.getUeId();
        }
        return null;
    }

    /**
     * 更新作品状态
     * @param updated
     * @return
     * @throws UnitEssentialNotFoundException
     */
    @Transactional(rollbackFor = UnitEssentialNotFoundException.class)
    @Override
    public UnitEssential update(UnitEssential updated) throws UnitEssentialNotFoundException {
        LOG.debug("Updating UnitEssential with information: " + updated);

        UnitEssential unitEssential = unitEssentialRepository.findOne(updated.getUeId());

        if (unitEssential == null) {
            LOG.debug("No post found with id: " + updated.getUeId());
            throw new PostNotFoundException("Post "+updated.getUeId()+" not found.");
        }
        unitEssential.update(updated);

        return unitEssential;
    }


    @Override
    public UnitEssential delete(Long id) {
        return null;
    }

}
