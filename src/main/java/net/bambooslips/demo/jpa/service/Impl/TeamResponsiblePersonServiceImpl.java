package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.ContactsNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.exception.TeamResponsiblePersonNotFoundException;
import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.TeamResponsiblePerson;
import net.bambooslips.demo.jpa.repository.ContactsRepository;
import net.bambooslips.demo.jpa.repository.TeamResponsiblePersonRepository;
import net.bambooslips.demo.jpa.service.ContactsService;
import net.bambooslips.demo.jpa.service.TeamResponsiblePersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class TeamResponsiblePersonServiceImpl implements TeamResponsiblePersonService{

    private static final Logger LOG = LoggerFactory.getLogger(TeamResponsiblePersonNotFoundException.class);
    @Resource
    private TeamResponsiblePersonRepository teamResponsiblePersonRepository;

    @Transactional
    @Override
    public Long create(TeamResponsiblePerson teamResponsiblePerson) {
        LOG.debug("Creating a new contacts with information: " + teamResponsiblePerson);
        TeamResponsiblePerson result = teamResponsiblePersonRepository.save(teamResponsiblePerson);
        if(result != null){
            return teamResponsiblePerson.getResId();
        }
        return null;
    }

    /**
     * 更新作品状态
     * @param updated
     * @return
     * @throws TeamResponsiblePersonNotFoundException
     */
    @Transactional(rollbackFor = TeamResponsiblePersonNotFoundException.class)
    @Override
    public TeamResponsiblePerson update(TeamResponsiblePerson updated) throws TeamResponsiblePersonNotFoundException {
        LOG.debug("Updating TeamResponsiblePerson with information: " + updated);

        TeamResponsiblePerson teamResponsiblePerson = teamResponsiblePersonRepository.findOne(updated.getResId());

        if (teamResponsiblePerson == null) {
            LOG.debug("No teamResponsiblePerson found with id: " + updated.getResId());
            throw new PostNotFoundException("Post "+updated.getResId()+" not found.");
        }
        teamResponsiblePerson.update(updated);

        return teamResponsiblePerson;
    }

    @Transactional(readOnly = true)
    @Override
    public Long findByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        TeamResponsiblePerson teamResponsiblePerson =  teamResponsiblePersonRepository.findByEntireId(entireId);
        if (teamResponsiblePerson != null){
            Long resId = teamResponsiblePerson.getResId();
            return resId;
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public TeamResponsiblePerson findListByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        TeamResponsiblePerson teamResponsiblePerson =  teamResponsiblePersonRepository.findByEntireId(entireId);
        return teamResponsiblePerson;
    }

    @Override
    public TeamResponsiblePerson delete(Long id) {
        return null;
    }

}
