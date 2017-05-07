package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * 单位入口 基本信息实体表
 */
@Entity
@Table(name = "team_essential_information")
public class TeamEssential implements  Serializable {

    /**
     * 主键注解必须有接口Serializable
     */
    @Id
    @Column(name = "te_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "te_pro_name")
    private String teProName;

    @Column(name = "te_compatition_goal")
    private String teCompatitionGoal;

    @Column(name = "te_industry_field")
    private String teIndustryFild;

    @Column(name = "te_pro_stage")
    private String teProStage;

    @Column(name = "te_adminstrative_area")
    private String teAdminStrativeArea;

    @Column(name = "team_fund_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date teamFundTime;

    @Column(name = "company_fund_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date companyFundTime;

    @Column(name = "te_address")
    private String teAddress;

    @Column(name = "te_postalcode")
    private String tePostalcode;

    @Column(name = "te_power_type")
    private String tePowerType;

    @Column(name = "te_techinical_source")
    private String teTechnicalSource;

    @Column(name = "te_pro_outline")
    private String teProOutline;

    @Column(name = "te_key_word")
    private String teKeyWord;

    @Column(name = "status")
    private String status;

    public TeamEssential(){

    }
    public TeamEssential(Long entireId, String teamName, String teProName,
                         String teCompatitionGoal, String teIndustryFild, String teProStage, String teAdminStrativeArea,
                         Date teamFundTime, Date companyFundTime, String teAddress, String tePostalcode,
                         String tePowerType, String teTechnicalSource, String teProOutline,String teKeyWord,String status){
        this.entireId = entireId;
        this.teamName = teamName;
        this.teProName = teProName;
        this.teCompatitionGoal = teCompatitionGoal;
        this.teIndustryFild = teIndustryFild;
        this.teProStage = teProStage;
        this.teAdminStrativeArea = teAdminStrativeArea;
        this.teamFundTime = teamFundTime;
        this.companyFundTime = companyFundTime;
        this.teAddress = teAddress;
        this.tePostalcode = tePostalcode;
        this.tePowerType = tePowerType;
        this.teTechnicalSource = teTechnicalSource;
        this.teProOutline = teProOutline;
        this.teKeyWord = teKeyWord;
        this.status = status;

    }

    /**
     * 更新基本信息
     * @param updated
     * @return
     */
    public TeamEssential update(TeamEssential updated) {
        if(updated.getTeamName() != null)this.setTeamName(updated.getTeamName());
        if(updated.getTeProName() != null)this.setTeProName(updated.getTeProName());
        if(updated.getTeCompatitionGoal() != null)this.setTeCompatitionGoal(updated.getTeCompatitionGoal());
        if(updated.getTeIndustryFild() != null)this.setTeIndustryFild(updated.getTeIndustryFild());
        if(updated.getTeProStage() != null)this.setTeProStage(updated.getTeProStage());
        if(updated.getTeAdminStrativeArea() != null)this.setTeAdminStrativeArea(updated.getTeAdminStrativeArea());
        if(updated.getTeamFundTime() != null)this.setTeamFundTime(updated.getTeamFundTime());
        if(updated.getCompanyFundTime() != null)this.setCompanyFundTime(updated.getCompanyFundTime());
        if(updated.getTeAddress() != null)this.setTeAddress(updated.getTeAddress());
        if(updated.getTePostalcode() != null)this.setTePostalcode(updated.getTePostalcode());
        if(updated.getTePowerType() != null)this.setTePowerType(updated.getTePowerType());
        if(updated.getTeTechnicalSource() != null)this.setTeTechnicalSource(updated.getTeTechnicalSource());
        if(updated.getTeProOutline() != null)this.setTeProOutline(updated.getTeProOutline());
        if(updated.getTeKeyWord() != null)this.setTeKeyWord(updated.getTeKeyWord());
        if(updated.getStatus() != null)this.setStatus(updated.getStatus());

        return this;
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

    public String getTeamName(){
        return teamName;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public String getTeProName(){
        return teProName;
    }
    public void setTeProName(String teProName){
       this.teProName =teProName;
    }

    public String getTeCompatitionGoal(){
        return teCompatitionGoal;
    }
    public void setTeCompatitionGoal(String teCompatitionGoal){
        this.teCompatitionGoal = teCompatitionGoal;
    }

    public String getTeIndustryFild(){
        return teIndustryFild;
    }
    public void setTeIndustryFild(String teIndustryFild){
        this.teIndustryFild = teIndustryFild;
    }

    public String getTeProStage(){
        return teProStage;
    }
    public void setTeProStage(String teProStage){
        this.teProStage = teProStage;
    }

    public String getTeAdminStrativeArea(){
        return teAdminStrativeArea;
    }
    public void setTeAdminStrativeArea(String teAdminStrativeArea){
        this.teAdminStrativeArea =teAdminStrativeArea;
    }

    public String getTeAddress(){
        return teAddress;
    }
    public void setTeAddress(String teAddress){
        this.teAddress = teAddress;
    }

    public Date getTeamFundTime(){
        return teamFundTime;
    }
    public void setTeamFundTime(Date teamFundTime){
        this.teamFundTime = teamFundTime;
    }

    public Date getCompanyFundTime(){
        return companyFundTime;
    }
    public void setCompanyFundTime(Date companyFundTime){
        this.companyFundTime = companyFundTime;
    }

    public String getTePostalcode(){
        return tePostalcode;
    }
    public void setTePostalcode(String tePostalcode){
        this.tePostalcode = tePostalcode;
    }

    public String getTePowerType(){
        return tePowerType;
    }
    public void setTePowerType(String tePowerType){
        this.tePowerType = tePowerType;
    }

    public String getTeTechnicalSource(){
        return teTechnicalSource;
    }
    public void setTeTechnicalSource(String teTechnicalSource){
        this.teTechnicalSource = teTechnicalSource;
    }

    public String getTeProOutline(){
        return teProOutline;
    }
    public void setTeProOutline(String teProOutline){
        this.teProOutline = teProOutline;
    }

    public String getTeKeyWord(){
        return teKeyWord;
    }
    public void setTeKeyWord(String teKeyWord){
        this.teKeyWord = teKeyWord;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}

