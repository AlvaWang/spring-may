package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * entire 录入参赛作品id及更新参赛作品状态实体
 */
@Entity
@Table(name = "education_experionce")
public class EducationExperionce implements  Serializable {

    @Id
    @Column(name = "edu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eduId;

    @Column(name = "ct_id")
    private Long ctId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "edu_background")
    private String eduBackground;

    @Column(name = "edu_graduate_school")
    private String eduGraduateSchool;

    @Column(name = "edu_major")
    private String eduMajor;

    public EducationExperionce(){

    }
    public EducationExperionce(Long entireId, Long ctId, String eduBackground, String eduGraduateSchool,String eduMajor){
        this.entireId = entireId;
        this.ctId = ctId;
        this.eduBackground = eduBackground;
        this.eduGraduateSchool = eduGraduateSchool;
        this.eduMajor = eduMajor;

    }

    /**
     * 更新联系人
     * @param updated
     * @return
     */
    public EducationExperionce update(EducationExperionce updated) {
        if(updated.getEntireId() != null)this.setEntireId(updated.getEntireId());
        if(updated.getCtId() != null)this.setCtId(updated.getCtId());
        if(updated.getEduBackground() != null)this.setEduBackground(updated.getEduBackground());
        if(updated.getEduGraduateSchool() != null)this.setEduGraduateSchool(updated.getEduGraduateSchool());
        if(updated.getEduMajor() != null)this.setEduMajor(updated.getEduMajor());
        return this;
    }

    public Long getEduId(){
        return eduId;
    }
    public void setEduId(Long eduId){
        this.eduId = eduId;
    }
    public Long getCtId(){
        return ctId;
    }
    public void setCtId(Long tbusId){
        this.ctId = ctId;
    }
    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }
    public String getEduBackground(){
        return eduBackground;
    }
    public void setEduBackground(String eduBackground){
        this.eduBackground = eduBackground;
    }

    public String getEduGraduateSchool(){
        return eduGraduateSchool;
    }
    public void setEduGraduateSchool(String eduGraduateSchool){
       this.eduGraduateSchool =eduGraduateSchool;
    }

    public String getEduMajor(){
        return eduMajor;
    }
    public void setEduMajor(String eduMajor){
        this.eduMajor =eduMajor;
    }
}

