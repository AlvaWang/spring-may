package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.exception.EducationExperionceNotFoundException;
import net.bambooslips.demo.exception.UnitEssentialNotFoundException;
import net.bambooslips.demo.jpa.model.EducationExperionce;
import net.bambooslips.demo.jpa.model.TeamEssential;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public interface EducationExperionceService {

    Long create(EducationExperionce educationExperionce);

    @Transactional(rollbackFor = EducationExperionceNotFoundException.class)
    /**
     * 更新基本信息
     */
//    TeamEssential update(TeamEssential update);


    EducationExperionce delete(Long id);

    List<EducationExperionce> findListByEntireId(Long ctId);

    EducationExperionce update(EducationExperionce updated);

//    Long findByEntireId(Long entireId);

//    Page<UnitEssential> findByComName(String comName);
}
