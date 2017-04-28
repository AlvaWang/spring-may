package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

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
    private Double ubusProIncomed;

    @Column(name = "ubus_pro_type")
    private String ubusProType;

    @Column(name = "ubus_isLead_internal")
    private String ubusLeadInternal;

    @Column(name = "ubus_isLead_international")
    private String ubusLeadInternational;

    @Column(name = "ubus_isResearch_institute")
    private String ubusResearchInstitute;

    @Column(name = "institute_name")
    private String instituteName;

    @Column(name = "ubus_isPro_picture")
    private String ubusProPicture;

    @Column(name = "ubus_major_describe")
    private String ubusMajorDescribe;

    @Column(name = "ubus_pro_market")
    private String ubusProMarket;

    @Column(name = "ubus_model")
    private String ubusModel;

    @Column(name = "ubus_main")
    private String ubusMain;

    public UnitBusinessPlan(){

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

    public Double getUbusProIncomed(){
        return ubusProIncomed;
    }
    public void setUbusProIncomed(Double ubusProIncomed){
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
    public void setUeCorporationSummary(String ubusMain){
        this.ubusMain = ubusMain;
    }

//    @Override
//    public int compareTo(BaseModel o) {
//        return 0;
//    }
}

