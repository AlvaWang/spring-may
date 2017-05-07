package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * 商业计划书
 */
@Entity
@Table(name = "unit_business_plan")
public class UnitBusinessPlan  implements Serializable {

    @Id
    @Column(name = "ubus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ubusId;

    @Column(name = "ue_id")
    private Long ueId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "ubus_pro_name")
    private String ubusProName;

    @Column(name = "ubus_pro_incomed")
    private Long ubusProIncomed;

    @Column(name = "ubus_pro_type")
    private String ubusProType;

    @Column(name = "ubus_is_lead_internal")
    private String ubusLeadInternal;

    @Column(name = "ubus_is_lead_international")
    private String ubusLeadInternational;

    @Column(name = "ubus_is_research_institute")
    private String ubusResearchInstitute;

    @Column(name = "institute_name")
    private String instituteName;

    @Column(name = "ubus_is_pro_picture")
    private String ubusProPicture;

    @Column(name = "ubus_major_describe")
    private String ubusMajorDescribe;

    @Column(name = "ubus_pro_market")
    private String ubusProMarket;

    @Column(name = "ubus_model")
    private String ubusModel;

    @Column(name = "ubus_main")
    private String ubusMain;

    @Column(name = "status")
    private String status;

    public UnitBusinessPlan(){

    }
    public UnitBusinessPlan(Long ueId, Long entireId, String ubusProName, Long ubusProIncomed,String ubusProType,
                            String ubusLeadInternal,String ubusLeadInternational,String ubusResearchInstitute,
                            String instituteName,String ubusProPicture,String ubusMajorDescribe,String ubusProMarket,
                            String ubusModel,String ubusMain,String status){
        this.ueId = ueId;
        this.entireId = entireId;
        this.ubusProName = ubusProName;
        this.ubusProIncomed = ubusProIncomed;
        this.ubusProType = ubusProType;
        this.ubusLeadInternal = ubusLeadInternal;
        this.ubusLeadInternational = ubusLeadInternational;
        this.ubusResearchInstitute = ubusResearchInstitute;
        this.instituteName = instituteName;
        this.ubusProPicture = ubusProPicture;
        this.ubusMajorDescribe = ubusMajorDescribe;
        this.ubusProMarket = ubusProMarket;
        this.ubusModel = ubusModel;
        this.ubusMain = ubusMain;
        this.status = status;
    }

    /**
     * 更新基本信息
     * @param updated
     * @return
     */
    public UnitBusinessPlan update(UnitBusinessPlan updated) {
        if(updated.getUbusProName() != null)this.setUbusProName(updated.getUbusProName());
        if(updated.getUbusProIncomed() != null)this.setUbusProIncomed(updated.getUbusProIncomed());
        if(updated.getUbusProType() != null)this.setUbusProType(updated.getUbusProType());
        if(updated.getUbusLeadInternal() != null)this.setUbusLeadInternal(updated.getUbusLeadInternal());
        if(updated.getUbusLeadInternational() != null)this.setUbusLeadInternational(updated.getUbusLeadInternational());
        if(updated.getUbusResearchInstitute() != null)this.setUbusResearchInstitute(updated.getUbusResearchInstitute());
        if(updated.getInstituteName() != null)this.setInstituteName(updated.getInstituteName());
        if(updated.getUbusProPicture() != null)this.setUbusProPicture(updated.getUbusProPicture());
        if(updated.getUbusMajorDescribe() != null)this.setUbusMajorDescribe(updated.getUbusMajorDescribe());
        if(updated.getUbusProMarket() != null)this.setUbusProMarket(updated.getUbusProMarket());

        if(updated.getUbusModel() != null)this.setUbusModel(updated.getUbusModel());
        if(updated.getUbusMain() != null)this.setUbusMain(updated.getInstituteName());
        if(updated.getStatus() != null)this.setStatus(updated.getStatus());

        return this;
    }

    public Long getUbusId(){
        return ubusId;
    }
    public void setUbusId(Long ubusId){
        this.ubusId = ubusId;
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

    public String getUbusProName(){
        return ubusProName;
    }
    public void setUbusProName(String ubusProName){
        this.ubusProName = ubusProName;
    }

    public String getUbusProType(){
        return ubusProType;
    }
    public void setUbusProType(String ubusProType){
       this.ubusProType =ubusProType;
    }

    public Long getUbusProIncomed(){
        return ubusProIncomed;
    }
    public void setUbusProIncomed(Long ubusProIncomed){
        this.ubusProIncomed = ubusProIncomed;
    }

    public String getUbusLeadInternal(){
        return ubusLeadInternal;
    }
    public void setUbusLeadInternal(String ubusLeadInternal){
        this.ubusLeadInternal = ubusLeadInternal;
    }

    public String getUbusLeadInternational(){
        return ubusLeadInternational;
    }
    public void setUbusLeadInternational(String ubusLeadInternational){
        this.ubusLeadInternational = ubusLeadInternational;
    }

    public String getUbusResearchInstitute(){
        return ubusResearchInstitute;
    }
    public void setUbusResearchInstitute(String ubusResearchInstitute){
        this.ubusResearchInstitute =ubusResearchInstitute;
    }
    public String getInstituteName(){
        return instituteName;
    }
    public void setInstituteName(String instituteName){
        this.instituteName =instituteName;
    }

    public String getUbusProPicture(){
        return ubusProPicture;
    }
    public void setUbusProPicture(String ubusProPicture){
        this.ubusProPicture = ubusProPicture;
    }

    public String getUbusMajorDescribe(){
        return ubusMajorDescribe;
    }
    public void setUbusMajorDescribe(String ubusMajorDescribe){
        this.ubusMajorDescribe = ubusMajorDescribe;
    }

    public String getUbusProMarket(){
        return ubusProMarket;
    }
    public void setUbusProMarket(String ubusProMarket){
        this.ubusProMarket = ubusProMarket;
    }

    public String getUbusModel(){
        return ubusModel;
    }
    public void setUbusModel(String ubusModel){
        this.ubusModel = ubusModel;
    }

    public String getUbusMain(){
        return ubusMain;
    }
    public void setUbusMain(String ubusMain){
        this.ubusMain = ubusMain;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}

