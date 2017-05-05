package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * 商业计划书
 */
@Entity
@Table(name = "team_business_plan")
public class TeamBusinessPlan implements Serializable {

    @Id
    @Column(name = "tbus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tbusId;

    @Column(name = "te_id")
    private Long teId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "tbus_pro_name")
    private String tbusProName;

    @Column(name = "tbus_pro_incomed")
    private Long tbusProIncomed;

    @Column(name = "tbus_new_chips")
    private String tbusNewChips;

    @Column(name = "tbus_hive")
    private String tbusHive;

    @Column(name = "tbus_pro_core")
    private String tbusProCore;
    @Column(name = "tbus_major_desc")
    private String tbusMajorDesc;

    @Column(name = "tbus_technology_maturity")
    private String tbusTechnologyMaturity;
    @Column(name = "tbus_manufactur_matutity")
    private String tbusManufacturMatutity;
    @Column(name = "tbus_market_matutity")
    private String tbusMarketMatutity;
    @Column(name = "tbus_industry_main")
    private String tbusIndustryMain;

    @Column(name = "tbus_is_lead_internal")
    private String tbusLeadInternal;

    @Column(name = "tbus_is_lead_international")
    private String tbusLeadInternational;

    @Column(name = "tbus_research_institute")
    private String tbusResearchInstitute;

    @Column(name = "institute_name")
    private String instituteName;

    @Column(name = "tbus_pro_picture")
    private String tbusProPicture;

    @Column(name = "tbus_market_analysis")
    private String tbusMarketAnalysis;


    @Column(name = "tbus_model")
    private String tbusModel;

    @Column(name = "tbus_development_plan")
    private String tbusDevelopmentPlan;

    public TeamBusinessPlan(){

    }
    public TeamBusinessPlan(Long teId, Long entireId, String tbusProName, Long tbusProIncomed, String tbusNewChips,
                            String tbusHive, String tbusProCore, String tbusMajorDesc,
                            String tbusTechnologyMaturity, String tbusManufacturMatutity, String tbusMarketMatutity, String tbusIndustryMain,
                            String tbusLeadInternal, String tbusLeadInternational,String tbusResearchInstitute,String instituteName,String tbusProPicture,String tbusMarketAnalysis,
                            String tbusModel,String tbusDevelopmentPlan){
        this.teId = teId;
        this.entireId = entireId;
        this.tbusProName = tbusProName;
        this.tbusProIncomed = tbusProIncomed;
        this.tbusNewChips = tbusNewChips;
        this.tbusHive = tbusHive;
        this.tbusProCore = tbusProCore;
        this.tbusMajorDesc = tbusMajorDesc;
        this.tbusTechnologyMaturity = tbusTechnologyMaturity;
        this.tbusManufacturMatutity = tbusManufacturMatutity;
        this.tbusMarketMatutity = tbusMarketMatutity;
        this.tbusIndustryMain = tbusIndustryMain;
        this.tbusLeadInternal = tbusLeadInternal;
        this.tbusLeadInternational = tbusLeadInternational;
        this.tbusResearchInstitute = tbusResearchInstitute;
        this.instituteName = instituteName;
        this.tbusProPicture = tbusProPicture;
        this.tbusMarketAnalysis = tbusMarketAnalysis;
        this.tbusModel = tbusModel;
        this.tbusDevelopmentPlan = tbusDevelopmentPlan;

    }

    /**
     * 更新基本信息
     * @param updated
     * @return
     */
    public TeamBusinessPlan update(TeamBusinessPlan updated) {
        if(updated.getTbusProName() != null)this.setTbusProName(updated.getTbusProName());
        if(updated.getTbusProIncomed() != null)this.setTbusProIncomed(updated.getTbusProIncomed());
        if(updated.getTbusNewChips() != null)this.setTbusNewChips(updated.getTbusNewChips());
        if(updated.getTbusHive() != null)this.setTbusHive(updated.getTbusHive());
        if(updated.getTbusProCore() != null)this.setTbusProCore(updated.getTbusProCore());
        if(updated.getTbusMajorDesc() != null)this.setTbusMajorDesc(updated.getTbusMajorDesc());
        if(updated.getTbusTechnologyMaturity() != null)this.setTbusTechnologyMaturity(updated.getTbusTechnologyMaturity());
        if(updated.getTbusManufacturMatutity() != null)this.setTbusManufacturMatutity(updated.getTbusManufacturMatutity());
        if(updated.getTbusMarketMatutity() != null)this.setTbusMarketMatutity(updated.getTbusMarketMatutity());
        if(updated.getTbusIndustryMain() != null)this.setInstituteName(updated.getTbusIndustryMain());

        if(updated.getTbusLeadInternal() != null)this.setTbusLeadInternal(updated.getTbusLeadInternal());
        if(updated.getTbusLeadInternational() != null)this.setTbusLeadInternational(updated.getTbusLeadInternational());
        if(updated.getTbusResearchInstitute() != null)this.setTbusResearchInstitute(updated.getTbusResearchInstitute());
        if(updated.getInstituteName() != null)this.setInstituteName(updated.getInstituteName());
        if(updated.getTbusProPicture() != null)this.setTbusProPicture(updated.getTbusProPicture());
        if(updated.getTbusMarketAnalysis() != null)this.setTbusMarketAnalysis(updated.getTbusMarketAnalysis());
        if(updated.getTbusModel() != null)this.setTbusModel(updated.getTbusModel());
        if(updated.getTbusDevelopmentPlan() != null)this.setTbusDevelopmentPlan(updated.getTbusDevelopmentPlan());


        return this;
    }

    public Long getTbusId(){
        return tbusId;
    }
    public void setTbusId(Long tbusId){
        this.tbusId = tbusId;
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

    public String getTbusProName(){
        return tbusProName;
    }
    public void setTbusProName(String tbusProName){
        this.tbusProName = tbusProName;
    }

    public Long getTbusProIncomed(){
        return tbusProIncomed;
    }
    public void setTbusProIncomed(Long tbusProIncomed){
       this.tbusProIncomed =tbusProIncomed;
    }

    public String  getTbusNewChips(){
        return tbusNewChips;
    }
    public void setTbusNewChips(String tbusNewChips){
        this.tbusNewChips = tbusNewChips;
    }

    public String getTbusHive(){
        return tbusHive;
    }
    public void setTbusHive(String tbusHive){
        this.tbusHive = tbusHive;
    }

    public String getTbusProCore(){
        return tbusProCore;
    }
    public void setTbusProCore(String tbusProCore){
        this.tbusProCore = tbusProCore;
    }

    public String getTbusMajorDesc(){
        return tbusMajorDesc;
    }
    public void setTbusMajorDesc(String tbusMajorDesc){
        this.tbusMajorDesc =tbusMajorDesc;
    }
    public String getTbusTechnologyMaturity(){
        return tbusTechnologyMaturity;
    }
    public void setTbusTechnologyMaturity(String tbusTechnologyMaturity){
        this.tbusTechnologyMaturity =tbusTechnologyMaturity;
    }

    public String getTbusManufacturMatutity(){
        return tbusManufacturMatutity;
    }
    public void setTbusManufacturMatutity(String tbusManufacturMatutity){
        this.tbusManufacturMatutity = tbusManufacturMatutity;
    }

    public String getTbusMarketMatutity(){
        return tbusMarketMatutity;
    }
    public void setTbusMarketMatutity(String tbusMarketMatutity){
        this.tbusMarketMatutity = tbusMarketMatutity;
    }

    public String getTbusIndustryMain(){
        return tbusIndustryMain;
    }
    public void setTbusIndustryMain(String tbusIndustryMain){
        this.tbusIndustryMain = tbusIndustryMain;
    }

    public String getTbusLeadInternal(){
        return tbusLeadInternal;
    }
    public void setTbusLeadInternal(String tbusLeadInternal){
        this.tbusLeadInternal = tbusLeadInternal;
    }

    public String getTbusLeadInternational(){
        return tbusLeadInternational;
    }
    public void setTbusLeadInternational(String tbusLeadInternational){
        this.tbusLeadInternational = tbusLeadInternational;
    }

    public String getTbusResearchInstitute(){
        return tbusResearchInstitute;
    }
    public void setTbusResearchInstitute(String tbusResearchInstitute){
        this.tbusResearchInstitute = tbusResearchInstitute;
    }


    public String getInstituteName(){
        return instituteName;
    }
    public void setInstituteName(String instituteName){
        this.instituteName = instituteName;
    }
    public String getTbusProPicture(){
        return tbusProPicture;
    }
    public void setTbusProPicture(String tbusProPicture){
        this.tbusProPicture = tbusProPicture;
    }
    public String getTbusMarketAnalysis(){
        return tbusMarketAnalysis;
    }
    public void setTbusMarketAnalysis(String tbusMarketAnalysis){
        this.tbusMarketAnalysis = tbusMarketAnalysis;
    }
    public String getTbusModel(){
        return tbusModel;
    }
    public void setTbusModel(String tbusModel){
        this.tbusModel = tbusModel;
    }

    public String getTbusDevelopmentPlan(){
        return tbusDevelopmentPlan;
    }
    public void setTbusDevelopmentPlan(String tbusDevelopmentPlan){
        this.tbusDevelopmentPlan = tbusDevelopmentPlan;
    }
}

