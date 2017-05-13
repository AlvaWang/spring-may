package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CoreTeamNotFoundException;
import net.bambooslips.demo.exception.PatentListNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.CoreTeam;
import net.bambooslips.demo.jpa.model.PatentList;
import net.bambooslips.demo.jpa.repository.CoreTeamRepository;
import net.bambooslips.demo.jpa.repository.PatentListRepository;
import net.bambooslips.demo.jpa.service.CoreTeamService;
import net.bambooslips.demo.jpa.service.PatentListService;
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
public class CoreTeamServiceImpl implements CoreTeamService{

    private static final Logger LOG = LoggerFactory.getLogger(CoreTeamServiceImpl.class);
    @Resource
    private CoreTeamRepository coreTeamRepository;

    @Transactional
    @Override
    public Long create(CoreTeam coreTeam) {
        LOG.debug("Creating a new coreTeam with information: " + coreTeam);
        CoreTeam result = coreTeamRepository.save(coreTeam);
        if(result != null){
            return coreTeam.getCtId();
        }
        return null;
    }

    /**
     * 更新核心团队信息
     * @param updated
     * @return
     * @throws CoreTeamNotFoundException
     */
    @Transactional(rollbackFor = CoreTeamNotFoundException.class)
    @Override
    public CoreTeam update(CoreTeam updated) throws CoreTeamNotFoundException {
        LOG.debug("Updating CoreTeam with information: " + updated);

        CoreTeam coreTeam = coreTeamRepository.findOne(updated.getCtId());

        if (coreTeam == null) {
            LOG.debug("No post found with id: " + updated.getCtId());
            throw new PostNotFoundException("Post "+updated.getCtId()+" not found.");
        }
        coreTeam.update(updated);

        return coreTeam;
    }


    /**
     * 根据核心团队ID删除核心成员信息
     * @param id
     * @return
     * @throws CoreTeamNotFoundException
     */
    @Transactional(rollbackFor = CoreTeamNotFoundException.class)
    @Override
    public CoreTeam delete(Long id) throws CoreTeamNotFoundException {
        LOG.debug("Deleting CoreTeam with id: " + id);

        CoreTeam deleted = coreTeamRepository.findOne(id);

        if (deleted == null) {
            LOG.debug("No CompetitionAccount found with id: " + id);
            throw new PostNotFoundException("No CompetitionAccount found with id: " + id);
        }

        coreTeamRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public int findByEntireId(Long entireId) {
        LOG.debug("Finding patentList by id: " + entireId);
        int count =  coreTeamRepository.findByEntireId(entireId);
        if (count > 0){
            return count;
        } else {
            return 0;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<CoreTeam> findListByEntireId(Long entireId) {
        LOG.debug("Finding patentList by id: " + entireId);
        List<CoreTeam> list =  coreTeamRepository.findListByEntireId(entireId);
        return list;
    }


}
