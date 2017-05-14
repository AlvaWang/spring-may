package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.exception.TeamEssentialNotFoundException;
import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.TeamEssential;
import net.bambooslips.demo.jpa.model.UnitEssential;
import net.bambooslips.demo.jpa.repository.TeamEssentialRepository;
import net.bambooslips.demo.jpa.repository.UnitEssentialRepository;
import net.bambooslips.demo.jpa.service.TeamEssentialService;
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
public class TeamEssentialServiceImpl implements TeamEssentialService{

    private static final Logger LOG = LoggerFactory.getLogger(TeamEssentialServiceImpl.class);
    @Resource
    private TeamEssentialRepository teamEssentialRepository;

    @Transactional
    @Override
    public Long create(TeamEssential teamEssential) {
        LOG.debug("Creating a new teamEssential with information: " + teamEssential);
        TeamEssential result = teamEssentialRepository.save(teamEssential);
        if(result != null){
            return teamEssential.getTeId();
        }
        return null;
    }

    /**
     * 更新作品状态
     * @param updated
     * @return
     * @throws TeamEssentialNotFoundException
     */
    @Transactional(rollbackFor = TeamEssentialNotFoundException.class)
    @Override
    public TeamEssential update(TeamEssential updated) throws TeamEssentialNotFoundException {
        LOG.debug("Updating TeamEssential with information: " + updated);

        TeamEssential teamEssential = teamEssentialRepository.findOne(updated.getTeId());

        if (teamEssential == null) {
            LOG.debug("No post found with id: " + updated.getTeId());
            throw new PostNotFoundException("Post "+updated.getTeId()+" not found.");
        }
        teamEssential.update(updated);

        return teamEssential;
    }

    @Transactional(readOnly = true)
    @Override
    public Long findByEntireId(Long entireId) {
        LOG.debug("Finding teamEssential by id: " + entireId);
        TeamEssential teamEssential=  teamEssentialRepository.findByEntireId(entireId);
        if (teamEssential != null){
            Long teId = teamEssential.getTeId();
            return teId;
        } else {
            return null;
        }
    }


    @Transactional(readOnly = true)
    @Override
    public TeamEssential findListByEntireId(Long entireId) {
        LOG.debug("Finding teamEssential by id: " + entireId);
        TeamEssential teamEssential=  teamEssentialRepository.findByEntireId(entireId);
        return teamEssential;
    }

    @Override
    public TeamEssential delete(Long id) {
        return null;
    }


}
