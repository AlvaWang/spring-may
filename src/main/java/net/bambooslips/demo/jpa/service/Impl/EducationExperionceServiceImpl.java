package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.EducationExperionceNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.exception.TeamEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionAccount;
import net.bambooslips.demo.jpa.model.EducationExperionce;
import net.bambooslips.demo.jpa.model.TeamEssential;
import net.bambooslips.demo.jpa.repository.EducationExperionceRepository;
import net.bambooslips.demo.jpa.repository.TeamEssentialRepository;
import net.bambooslips.demo.jpa.service.EducationExperionceService;
import net.bambooslips.demo.jpa.service.TeamEssentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class EducationExperionceServiceImpl implements EducationExperionceService{

    private static final Logger LOG = LoggerFactory.getLogger(EducationExperionceServiceImpl.class);
    @Resource
    private EducationExperionceRepository educationExperionceRepository;

    @Transactional
    @Override
    public Long create(EducationExperionce educationExperionce) {
        LOG.debug("Creating a new educationExperionce with information: " + educationExperionce);
        EducationExperionce result = educationExperionceRepository.save(educationExperionce);
        if(result != null){
            return educationExperionce.getEduId();
        }
        return null;
    }

    @Override
    public EducationExperionce delete(Long id) {

        LOG.debug("Deleting CompetitionAccount with id: " + id);

        EducationExperionce deleted = educationExperionceRepository.findOne(id);

        if (deleted == null) {
            LOG.debug("No CompetitionAccount found with id: " + id);
            throw new EducationExperionceNotFoundException("No CompetitionAccount found with id: " + id);
        }

        educationExperionceRepository.delete(deleted);
        return deleted;
    }


}
