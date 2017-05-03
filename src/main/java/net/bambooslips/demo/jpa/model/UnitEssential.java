package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * 单位入口 基本信息实体表
 */
@Entity
@Table(name = "unit_essential_information")
public class UnitEssential implements  Serializable {

    /**
     * 主键注解必须有接口Serializable
     */
    @Id
    @Column(name = "ue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ueId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "ue_company_name")
    private String ueCompanyName;

    @Column(name = "ue_goal")
    private String ueGoal;

    @Column(name = "ue_field")
    private String ueField;

    @Column(name = "ue_register_capital")
    private Long ueRegisterCapital;

    @Column(name = "ue_win_num")
    private Long ueWinNum;

    @Column(name = "ue_staff_num")
    private Long ueStaffNum;

    @Column(name = "ue_research_num")
    private Long ueResearchNum;

    @Column(name = "ue_deputySenior_num")
    private Long ueDeputyNum;

    @Column(name = "ue_office_address")
    private String ueOfficeAddress;

    @Column(name = "ue_post_code")
    private String uePostCode;

    @Column(name = "ue_power_type")
    private String uePowerType;

    @Column(name = "ue_technical_sources")
    private String ueTechnicalSources;

    @Column(name = "ue_corporation_summary")
    private String ueCorporationSummary;

    public UnitEssential(){

    }
    public UnitEssential(Long entireId,String ueCompanyName,String ueGoal,
                         String ueField,Long ueRegisterCapital,Long ueWinNum, Long ueStaffNum,
                         Long ueResearchNum,Long ueDeputyNum,String ueOfficeAddress,String uePostCode,
                         String uePowerType,String ueCorporationSummary,String ueTechnicalSources){
        this.entireId = entireId;
        this.ueCompanyName = ueCompanyName;
        this.ueGoal = ueGoal;
        this.ueField = ueField;
        this.ueRegisterCapital = ueRegisterCapital;
        this.ueWinNum = ueWinNum;
        this.ueStaffNum = ueStaffNum;
        this.ueResearchNum = ueResearchNum;
        this.ueDeputyNum = ueDeputyNum;
        this.ueOfficeAddress = ueOfficeAddress;
        this.uePostCode = uePostCode;
        this.uePowerType = uePowerType;
        this.ueCorporationSummary = ueCorporationSummary;
        this.ueTechnicalSources = ueTechnicalSources;

    }

    /**
     * 更新基本信息
     * @param updated
     * @return
     */
    public UnitEssential update(UnitEssential updated) {
        if(updated.getUeGoal() != null)this.setUeGoal(updated.getUeGoal());
        if(updated.getUeField() != null)this.setUeField(updated.getUeField());
        if(updated.getUeRegisterCapital() != null)this.setUeRegisterCapital(updated.getUeRegisterCapital());
        if(updated.getUeWinNum() != null)this.setUeWinNum(updated.getUeWinNum());
        if(updated.getUeStaffNum() != null)this.setUeStaffNum(updated.getUeStaffNum());
        if(updated.getUeResearchNum() != null)this.setUeResearchNum(updated.getUeResearchNum());
        if(updated.getUeDeputyNum() != null)this.setUeDeputyNum(updated.getUeDeputyNum());
        if(updated.getUeOfficeAddress() != null)this.setUeOfficeAddress(updated.getUeOfficeAddress());
        if(updated.getUePostCode() != null)this.setUePostCode(updated.getUePostCode());
        if(updated.getUePowerType() != null)this.setUePowerType(updated.getUePowerType());
        if(updated.getUeTechnicalSources() != null)this.setUeTechnicalSources(updated.getUeTechnicalSources());
        if(updated.getUeCorporationSummary() != null)this.setUeCorporationSummary(updated.getUeCorporationSummary());

        return this;
    }

    public Long getUeId(){
        return ueId;
    }
    public void setUeId(Long ueId){
        this.ueId = ueId;
    }
    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }

    public String getUeCompanyName(){
        return ueCompanyName;
    }
    public void setUeCompanyName(String ueCompanyName){
        this.ueCompanyName = ueCompanyName;
    }

    public String getUeGoal(){
        return ueGoal;
    }
    public void setUeGoal(String ueGoal){
       this.ueGoal =ueGoal;
    }

    public String getUeField(){
        return ueField;
    }
    public void setUeField(String ueField){
        this.ueField = ueField;
    }

    public Long getUeRegisterCapital(){
        return ueRegisterCapital;
    }
    public void setUeRegisterCapital(Long ueRegisterCapital){
        this.ueRegisterCapital = ueRegisterCapital;
    }

    public Long getUeWinNum(){
        return ueWinNum;
    }
    public void setUeWinNum(Long ueWinNum){
        this.ueWinNum = ueWinNum;
    }

    public Long getUeStaffNum(){
        return ueStaffNum;
    }
    public void setUeStaffNum(Long ueStaffNum){
        this.ueStaffNum =ueStaffNum;
    }

    public Long getUeResearchNum(){
        return ueResearchNum;
    }
    public void setUeResearchNum(Long ueResearchNum){
        this.ueResearchNum = ueResearchNum;
    }

    public Long getUeDeputyNum(){
        return ueDeputyNum;
    }
    public void setUeDeputyNum(Long ueDeputyNum){
        this.ueDeputyNum = ueDeputyNum;
    }

    public String getUeOfficeAddress(){
        return ueOfficeAddress;
    }
    public void setUeOfficeAddress(String ueOfficeAddress){
        this.ueOfficeAddress = ueOfficeAddress;
    }

    public String getUePostCode(){
        return uePostCode;
    }
    public void setUePostCode(String uePostCode){
        this.uePostCode = uePostCode;
    }

    public String getUePowerType(){
        return uePowerType;
    }
    public void setUePowerType(String uePowerType){
        this.uePowerType = uePowerType;
    }

    public String getUeTechnicalSources(){
        return ueTechnicalSources;
    }
    public void setUeTechnicalSources(String ueTechnicalSources){
        this.ueTechnicalSources = ueTechnicalSources;
    }

    public String getUeCorporationSummary(){
        return ueCorporationSummary;
    }
    public void setUeCorporationSummary(String ueCorporationSummary){
        this.ueCorporationSummary = ueCorporationSummary;
    }

}

