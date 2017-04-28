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

    @Column(name = "ct_job")
    private String ctJob;

    @Column(name = "ct_higbest_education")
    private String ctHigbestEducation;

    @Column(name = "ct_study_experience")
    private String ctStudyExperience;

    @Column(name = "ct_main_achive")
    private String ctMainAchive;

    @Column(name = "ct_national_millennium")
    private String ctNationalMillennium;

    @Column(name = "national_mille_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nationalMilleDate;

    @Column(name = "ct_university_business")
    private String ctUniversityBusiness;



    public CoreTeam(){
        super();

    }

//    /**
//     * 更新联系人
//     * @param updated
//     * @return
//     */
//    public LegalRepresentative update(LegalRepresentative updated) {
//        if(updated.getWorkState() != null)this.setWorkState(updated.getWorkState());
//
//        return this;
//    }

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

