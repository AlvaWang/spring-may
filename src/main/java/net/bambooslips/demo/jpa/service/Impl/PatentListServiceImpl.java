package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CompetitionAccountNotFoundException;
import net.bambooslips.demo.exception.ContactsNotFoundException;
import net.bambooslips.demo.exception.PatentListNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.PatentList;
import net.bambooslips.demo.jpa.model.UnitEssential;
import net.bambooslips.demo.jpa.repository.ContactsRepository;
import net.bambooslips.demo.jpa.repository.PatentListRepository;
import net.bambooslips.demo.jpa.service.ContactsService;
import net.bambooslips.demo.jpa.service.PatentListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class PatentListServiceImpl implements PatentListService{

    private static final Logger LOG = LoggerFactory.getLogger(PatentListServiceImpl.class);
    @Resource
    private PatentListRepository patentListRepository;

    @Transactional
    @Override
    public Long create(PatentList patentList) {
        LOG.debug("Creating a new patentList with information: " + patentList);
        PatentList result = patentListRepository.save(patentList);
        if(result != null){
            return patentList.getId();
        }
        return null;
    }

    /**
     * 更新专利
     * @param updated
     * @return
     * @throws PatentListNotFoundException
     */
    @Transactional(rollbackFor = PatentListNotFoundException.class)
    @Override
    public PatentList update(PatentList updated) throws PatentListNotFoundException {
        LOG.debug("Updating PatentList with information: " + updated);

        PatentList patentList = patentListRepository.findOne(updated.getId());

        if (patentList == null) {
            LOG.debug("No post found with id: " + updated.getId());
            throw new PostNotFoundException("Post "+updated.getId()+" not found.");
        }
        patentList.update(updated);

        return patentList;
    }


    /**
     * 根据专利号删除专利
     * @param id
     * @return
     * @throws PatentListNotFoundException
     */
    @Transactional(rollbackFor = PatentListNotFoundException.class)
    @Override
    public PatentList delete(Long id) throws PatentListNotFoundException {
        LOG.debug("Deleting PatentList with id: " + id);

        PatentList deleted = patentListRepository.findOne(id);

        if (deleted == null) {
            LOG.debug("No CompetitionAccount found with id: " + id);
            throw new PostNotFoundException("No CompetitionAccount found with id: " + id);
        }

        patentListRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public Long findByPatentId(String patentId) {
        LOG.debug("Finding patentList by id: " + patentId);
        PatentList patentList =  patentListRepository.findByPatentId(patentId);
        if (patentList != null){
            Long id = patentList.getId();
            return id;
        } else {
            return null;
        }
    }


    @Transactional(readOnly = true)
    @Override
    public List<PatentList> findListByEntireId(Long entireId) {
        LOG.debug("Finding patentList by id: " + entireId);
        List<PatentList> patentList =  patentListRepository.findListByEntireId(entireId);
        return patentList;
    }


    @Transactional(readOnly = true)
    @Override
    public Long findById(Long id) {
        LOG.debug("Finding patentList by id: " + id);
        PatentList patentList =  patentListRepository.findById(id);
        if (patentList != null){
            Long entireId = patentList.getEntireId();
            return entireId;
        } else {
            return null;
        }
    }


}
