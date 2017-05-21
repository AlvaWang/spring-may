package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * e专利
 */
@Entity
@Table(name = "core_team_information")
public class CoreTeam implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
    private Long ctId;

    @Column(name = "ue_id")
    private Long ueId;

    @Column(name = "te_id")
    private Long teId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "ct_name")
    private String ctName;

    @Column(name = "ct_sex")
    private String ctSex;

    @Column(name = "ct_age")
    private Long ctAge;

    @Column(name = "ct_job")
    private String ctJob;

    @Column(name = "ct_higbest_education")
    private String ctHigbestEducation;

    @Column(name = "ct_study_experience")
    private String ctStudyExperience;

    @Column(name = "ct_main_achive",length = 1500)
    private String ctMainAchive;

    @Column(name = "ct_national_millennium")
    private String ctNationalMillennium;

    @Column(name = "national_mille_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nationalMilleDate;

    @Column(name = "ct_university_business")
    private String ctUniversityBusiness;



    public CoreTeam(){

    }
    public CoreTeam(Long ueId,
                    Long teId,
                    Long entireId,
                    String ctName,
                    String ctSex,
                    Long ctAge,
                    String ctJob,
                    String ctHigbestEducation,
                    String ctStudyExperience,
                    String ctMainAchive,
                    String ctNationalMillennium,
                    Date nationalMilleDate,
                    String ctUniversityBusiness){
        this.ueId = ueId;
        this.teId = teId;
        this.entireId = entireId;
        this.ctName = ctName;
        this.ctSex = ctSex;
        this.ctAge = ctAge;
        this.ctJob = ctJob;
        this.ctHigbestEducation = ctHigbestEducation;
        this.ctStudyExperience = ctStudyExperience;
        this.ctMainAchive = ctMainAchive;
        this.ctNationalMillennium = ctNationalMillennium;
        this.nationalMilleDate = nationalMilleDate;
        this.ctUniversityBusiness = ctUniversityBusiness;

    }


    /**
     * 更新核心团队信息
     * @param updated
     * @return
     */
    public CoreTeam update(CoreTeam updated) {
        if(updated.getCtName() != null)this.setCtName(updated.getCtName());
        if(updated.getCtJob() != null)this.setCtJob(updated.getCtJob());
        if(updated.getCtSex() != null)this.setCtSex(updated.getCtSex());
        if(updated.getCtAge() != null)this.setCtAge(updated.getCtAge());
        if(updated.getCtHigbestEducation() != null)this.setCtHigbestEducation(updated.getCtHigbestEducation());
        if(updated.getCtStudyExperience() != null)this.setCtStudyExperience(updated.getCtStudyExperience());
        if(updated.getCtMainAchive() != null)this.setCtMainAchive(updated.getCtMainAchive());
        if(updated.getCtNationalMillennium() != null)this.setCtNationalMillennium(updated.getCtNationalMillennium());
        if(updated.getNationalMilleDate() != null)this.setNationalMilleDate(updated.getNationalMilleDate());
        if(updated.getCtUniversityBusiness() != null)this.setCtUniversityBusiness(updated.getCtUniversityBusiness());

        return this;
    }

    public Long getCtId(){
        return ctId;
    }
    public void setCtId(Long ctId){
        this.ctId = ctId;
    }
    public Long getUeId(){
        return ueId;
    }
    public void setUeId(Long ueId){
        this.ueId = ueId;
    }

    public Long getTeId(){
        return teId;
    }
    public void setTeId(Long teId){
        this.teId = teId;
    }

    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }

    public String getCtName(){
        return ctName;
    }
    public void setCtName(String ctName){
        this.ctName = ctName;
    }

    public String getCtSex(){
        return ctSex;
    }
    public void setCtSex(String ctSex){
       this.ctSex =ctSex;
    }

    public Long getCtAge(){
        return ctAge;
    }
    public void setCtAge(Long ctAge){
        this.ctAge =ctAge;
    }

    public String getCtJob(){
        return ctJob;
    }
    public void setCtJob(String ctJob){
        this.ctJob = ctJob;
    }

    public String getCtHigbestEducation(){
        return ctHigbestEducation;
    }
    public void setCtHigbestEducation(String ctHigbestEducation){
        this.ctHigbestEducation =ctHigbestEducation;
    }

    public String getCtStudyExperience(){
        return ctStudyExperience;
    }
    public void setCtStudyExperience(String ctStudyExperience){
        this.ctStudyExperience = ctStudyExperience;
    }

    public String getCtMainAchive(){
        return ctMainAchive;
    }
    public void setCtMainAchive(String ctMainAchive){
        this.ctMainAchive =ctMainAchive;
    }

    public String getCtNationalMillennium(){
        return ctNationalMillennium;
    }
    public void setCtNationalMillennium(String ctNationalMillennium){
        this.ctNationalMillennium =ctNationalMillennium;
    }

    public Date getNationalMilleDate() {
        return nationalMilleDate;
    }

    public void setNationalMilleDate(Date nationalMilleDate) {
        this.nationalMilleDate = nationalMilleDate;
    }

    public String getCtUniversityBusiness(){
        return ctUniversityBusiness;
    }
    public void setCtUniversityBusiness(String ctHigbestEducation){
        this.ctHigbestEducation =ctHigbestEducation;
    }

//    @Override
//    public int compareTo(BaseModel o) {
//        return this.getCtId().compareTo(o.getId());
//    }
}

