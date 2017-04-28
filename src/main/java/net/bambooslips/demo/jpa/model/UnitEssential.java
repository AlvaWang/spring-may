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
    private Double ueRegisterCapital;

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

    @Column(name = "ue_power_type")
    private String uePowerType;

    @Column(name = "ue_corporation_summary")
    private String ueCorporationSummary;

    public UnitEssential(){

    }

//    /**
//     * 更新基本信息
//     * @param updated
//     * @return
//     */
//    public UnitEssential update(UnitEssential updated) {
//        if(updated.getComState() != null)this.setComState(updated.getComState());
//
//        return this;
//    }

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

    public Double getUeRegisterCapital(){
        return ueRegisterCapital;
    }
    public void setUeRegisterCapital(Double ueRegisterCapital){
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

    public String getUePowerType(){
        return uePowerType;
    }
    public void setUePowerType(String uePowerType){
        this.uePowerType = uePowerType;
    }

    public String getUeCorporationSummary(){
        return ueCorporationSummary;
    }
    public void setUeCorporationSummary(String ueCorporationSummary){
        this.ueCorporationSummary = ueCorporationSummary;
    }

//    @Override
//    public int compareTo(BaseModel o) {
//        return 0;
//    }
}

