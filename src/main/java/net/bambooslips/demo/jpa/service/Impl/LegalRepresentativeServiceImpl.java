package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.CompetitionEntireNotFoundException;
import net.bambooslips.demo.exception.LegalRepresentativeNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.CompetitionEntire;
import net.bambooslips.demo.jpa.model.LegalRepresentative;
import net.bambooslips.demo.jpa.repository.CompetitionEntireRepository;
import net.bambooslips.demo.jpa.repository.LegalRepresentativeRepository;
import net.bambooslips.demo.jpa.service.CompetitionEntireService;
import net.bambooslips.demo.jpa.service.LegalRepresentativeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class LegalRepresentativeServiceImpl implements LegalRepresentativeService{

    private static final Logger LOG = LoggerFactory.getLogger(PostServiceImpl.class);
    @Resource
    private LegalRepresentativeRepository legalRepresentativeRepository;

    @Transactional
    @Override
    public Long create(LegalRepresentative legalRepresentative) {
        LOG.debug("Creating a new legalRepresentative with information: " + legalRepresentative);
        LegalRepresentative result = legalRepresentativeRepository.save(legalRepresentative);
        if(result != null){
            return legalRepresentative.getLegalId();
        }
        return null;
    }

    /**
     * 更新作品状态
     * @param updated
     * @return
     * @throws LegalRepresentativeNotFoundException
     */
    @Transactional(rollbackFor = LegalRepresentativeNotFoundException.class)
    @Override
    public LegalRepresentative update(LegalRepresentative updated) throws LegalRepresentativeNotFoundException {
        LOG.debug("Updating LegalRepresentative with information: " + updated);

        LegalRepresentative legalRepresentative = legalRepresentativeRepository.findOne(updated.getLegalId());

        if (legalRepresentative == null) {
            LOG.debug("No post found with id: " + updated.getLegalId());
            throw new PostNotFoundException("Post "+updated.getLegalId()+" not found.");
        }
        legalRepresentative.update(updated);

        return legalRepresentative;
    }


    @Override
    public LegalRepresentative delete(Long id) {
        return null;
    }

}
