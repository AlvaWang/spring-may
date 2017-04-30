package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * e专利
 */
@Entity
@Table(name = "demand_financial_service")
public class DemandFinancial implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "df_id")
    private Long dfId;

    @Column(name = "ubus_id")
    private Long ubusId;
    @Column(name = "tbus_id")
    private Long tbusId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "df_isEquity")
    private String dfEquity;

    @Column(name = "df_equity_money")
    private double dfEquityMoney;

    @Column(name = "df_equity_shares")
    private double dfEquityShares;

    @Column(name = "df_equity_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfEquityDate;

    @Column(name = "df_equityFund_plan")
    private String equityFundPlan;

    @Column(name = "df_isEquity_recom")
    private String dfEquityRecom;

    @Column(name = "df_isDebt")
    private String dfDebt;

    @Column(name = "df_debt_money")
    private double dfDebtMoney;

    @Column(name = "df_debt_maxAnnual")
    private double debtMaxAnnual;

    @Column(name = "df_debt_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfDebtDate;

    @Column(name = "df_debtFund_plan")
    private String debtFundPlan;

    @Column(name = "df_isDebt_recom")
    private String dfDebtRecom;


    @Column(name = "df_isCrowd_funding")
    private String dfCrowdFunding;

    @Column(name = "crows_fund_type")
    private String crowsFundType;
    @Column(name = "df_isMerge")
    private String dfMerge;

    @Column(name = "df_isListed_shareReform")
    private String dfListedShareReform;
    @Column(name = "df_isFinancing_guarantee")
    private String dfFinancingGuarantee;

    @Column(name = "df_isPetty_loan")
    private String dfPettyLoan;

    @Column(name = "petty_loan_money")
    private double pettyLoanMoney;

    @Column(name = "df_company_isDebt")
    private String dfCompanyDebt;

    @Column(name = "df_minorEnterprises_isDebt")
    private String minorEnterprisesDebt;
    @Column(name = "df_technical_import")
    private String dfTechnicalImport;

    @Column(name = "technical_import_range")
    private String technicalImportRange;

    @Column(name = "technical_desc")
    private String technicalDesc;

    @Column(name = "df_technical_transfer")
    private String dfTechnicalTransfer;

    @Column(name = "technical_transfer_range")
    private String technicalTransferRange;

    @Column(name = "df_property_assign")
    private String dfPropertyAssign;
    @Column(name = "df_finace_lease")
    private String dfFinaceLease;

    @Column(name = "df_technology_insurance")
    private String dfTechnologyInsurance;

    @Column(name = "df_asset_manage")
    private String dfAssetManage;

    @Column(name = "df_branchChong_check")
    private String branchChongCheck;

    @Column(name = "df_political_consult")
    private String dfPoliticalConsult;

    @Column(name = "df_technology_consult")
    private String dfTechnologyConsult;
    @Column(name = "df_intermediary_consult")
    private String dfIntermediaryConsult;

    @Column(name = "intermediary_consult_type")
    private String intermediaryConsultType;

    @Column(name = "intermediary_consult_desc")
    private String intermediaryConsultDesc;

    @Column(name = "df_other_service")
    private String dfOtherService;
    @Column(name = "other_service_desc")
    private String otherServiceDesc;

    @Column(name = "df_accept_train")
    private String dfAcceptTrain;


    @Column(name = "df_no")
    private String dfNo;



    public DemandFinancial(){
        super();

    }
    public DemandFinancial(Long entireId, Long ubusId, Long tbusId, String dfEquity, double dfEquityShares,
                           double dfEquityMoney, Date dfEquityDate, String equityFundPlan, String dfEquityRecom,
                           String dfDebt, double dfDebtMoney, double debtMaxAnnual, Date dfDebtDate,
                           String debtFundPlan, String dfDebtRecom, String dfCrowdFunding, String crowsFundType,
                           String dfMerge, String dfListedShareReform, String dfFinancingGuarantee, String dfPettyLoan,
                           double pettyLoanMoney, String dfCompanyDebt, String minorEnterprisesDebt,
                           String dfTechnicalImport, String technicalImportRange, String technicalDesc,
                           String dfTechnicalTransfer, String technicalTransferRange, String dfPropertyAssign,
                           String dfFinaceLease, String dfTechnologyInsurance, String dfAssetManage,
                           String branchChongCheck, String dfPoliticalConsult, String dfTechnologyConsult,
                           String dfIntermediaryConsult, String intermediaryConsultType, String intermediaryConsultDesc,
                           String dfOtherService, String otherServiceDesc, String dfAcceptTrain, String dfNo){
        this.ubusId = ubusId;
        this.entireId = entireId;
        this.tbusId = tbusId;this.dfEquity = dfEquity;this.dfEquityShares = dfEquityShares;this.dfEquityMoney = dfEquityMoney;
        this.dfEquityDate = dfEquityDate;this.equityFundPlan = equityFundPlan;this.dfEquityRecom = dfEquityRecom;
        this.dfDebt = dfDebt;this.dfDebtMoney = dfDebtMoney;this.debtMaxAnnual = debtMaxAnnual;this.dfDebtDate = dfDebtDate;
        this.debtFundPlan = debtFundPlan;this.dfDebtRecom = dfDebtRecom;this.dfCrowdFunding = dfCrowdFunding;this.crowsFundType = crowsFundType;
        this.dfMerge = dfMerge;this.dfListedShareReform = dfListedShareReform;this.dfFinancingGuarantee = dfFinancingGuarantee;
        this.dfPettyLoan = dfPettyLoan;this.pettyLoanMoney = pettyLoanMoney;this.dfCompanyDebt = dfCompanyDebt;
        this.minorEnterprisesDebt = minorEnterprisesDebt;
        this.dfTechnicalImport = dfTechnicalImport;
        this.technicalImportRange = technicalImportRange;

        this.technicalDesc = technicalDesc;this.dfTechnicalTransfer = dfTechnicalTransfer;this.technicalTransferRange = technicalTransferRange;
        this.dfPropertyAssign = dfPropertyAssign;this.dfFinaceLease = dfFinaceLease;this.dfTechnologyInsurance = dfTechnologyInsurance;
        this.dfAssetManage = dfAssetManage;
        this.branchChongCheck = branchChongCheck;
        this.dfPoliticalConsult = dfPoliticalConsult;

        this.dfTechnologyConsult = dfTechnologyConsult;this.dfIntermediaryConsult = dfIntermediaryConsult;
        this.intermediaryConsultType = intermediaryConsultType;this.intermediaryConsultDesc = intermediaryConsultDesc;
        this.dfOtherService = dfOtherService;
        this.otherServiceDesc = otherServiceDesc;
        this.dfAcceptTrain = dfAcceptTrain;
        this.dfNo = dfNo;



    }


    /**
     * 更新股权融资信息
     * @param updated
     * @return
     */
    public DemandFinancial update(DemandFinancial updated) {
        if(updated.getDfEquity() != null)this.setDfEquity(updated.getDfEquity());
        if(updated.getDfEquityMoney() <= 0)this.setDfEquityMoney(updated.getDfEquityMoney());
        if(updated.getDfEquityShares() <= 0)this.setDfEquityShares(updated.getDfEquityShares());
        if(updated.getDfEquityDate() != null)this.setDfEquityDate(updated.getDfEquityDate());
        if(updated.getEquityFundPlan() != null)this.setEquityFundPlan(updated.getEquityFundPlan());
        if(updated.getDfEquityRecom() != null)this.setDfEquityRecom(updated.getDfEquityRecom());
        if(updated.getDfDebt() != null)this.setDfDebt(updated.getDfDebt());
        if(updated.getDfDebtMoney() <= 0)this.setDfDebtMoney(updated.getDfDebtMoney());
        if(updated.getDebtMaxAnnual() <= 0)this.setDebtMaxAnnual(updated.getDebtMaxAnnual());
        if(updated.getDfDebtDate() != null)this.setDfDebtDate(updated.getDfDebtDate());
        if(updated.getDebtFundPlan() != null)this.setDebtFundPlan(updated.getDebtFundPlan());
        if(updated.getDfDebtRecom() != null)this.setDfDebtRecom(updated.getDfDebtRecom());
        if(updated.getDfCrowdFunding() != null)this.setDfCrowdFunding(updated.getDfCrowdFunding());
        if(updated.getCrowsFundType() != null)this.setCrowsFundType(updated.getCrowsFundType());
        if(updated.getDfMerge() != null)this.setDfMerge(updated.getDfMerge());
        if(updated.getDfListedShareReform() != null)this.setDfListedShareReform(updated.getDfListedShareReform());
        if(updated.getDfFinancingGuarantee() != null)this.setDfFinancingGuarantee(updated.getDfFinancingGuarantee());
        if(updated.getDfPettyLoan() != null)this.setDfPettyLoan(updated.getDfPettyLoan());
        if(updated.getPettyLoanMoney() <= 0)this.setPettyLoanMoney(updated.getPettyLoanMoney());
        if(updated.getDfCompanyDebt() != null)this.setDfCompanyDebt(updated.getDfCompanyDebt());
        if(updated.getMinorEnterprisesDebt() != null)this.setMinorEnterprisesDebt(updated.getMinorEnterprisesDebt());
        if(updated.getDfTechnicalImport() != null)this.setDfTechnicalImport(updated.getDfTechnicalImport());
        if(updated.getTechnicalImportRange() != null)this.setTechnicalImportRange(updated.getTechnicalImportRange());
        if(updated.getTechnicalDesc() != null)this.setTechnicalDesc(updated.getTechnicalDesc());
        if(updated.getDfTechnicalTransfer() != null)this.setDfTechnicalTransfer(updated.getDfTechnicalTransfer());
        if(updated.getTechnicalTransferRange() != null)this.setTechnicalTransferRange(updated.getTechnicalTransferRange());
        if(updated.getDfPropertyAssign() != null)this.setDfPropertyAssign(updated.getDfPropertyAssign());
        if(updated.getDfFinaceLease() != null)this.setDfFinaceLease(updated.getDfFinaceLease());
        if(updated.getDfTechnologyInsurance() != null)this.setDfTechnologyInsurance(updated.getDfTechnologyInsurance());
        if(updated.getDfAssetManage()!=null)this.setDfAssetManage(updated.getDfAssetManage());
        if(updated.getBranchChongCheck() != null)this.setBranchChongCheck(updated.getBranchChongCheck());
        if(updated.getDfPoliticalConsult() != null)this.setDfPoliticalConsult(updated.getDfPoliticalConsult());
        if(updated.getDfTechnologyConsult() != null)this.setDfTechnologyConsult(updated.getDfTechnologyConsult());
        if(updated.getDfIntermediaryConsult() != null)this.setDfIntermediaryConsult(updated.getDfIntermediaryConsult());
        if(updated.getIntermediaryConsultType() != null)this.setIntermediaryConsultType(updated.getIntermediaryConsultType());
        if(updated.getIntermediaryConsultDesc() != null)this.setIntermediaryConsultDesc(updated.getIntermediaryConsultDesc());
        if(updated.getDfOtherService() != null)this.setDfOtherService(updated.getDfOtherService());
        if(updated.getOtherServiceDesc() != null)this.setOtherServiceDesc(updated.getOtherServiceDesc());
        if(updated.getDfAcceptTrain() != null)this.setDfAcceptTrain(updated.getDfAcceptTrain());
        if(updated.getDfNo() != null)this.setDfNo(updated.getDfNo());

        return this;
    }

    public Long getDfId(){
        return dfId;
    }
    public void setDfId(Long dfId){
        this.dfId = dfId;
    }
    public Long getUbusId(){
        return ubusId;
    }
    public void setUbusId(Long ubusId){
        this.ubusId = ubusId;
    }
    public Long getTbusId(){
        return tbusId;
    }
    public void setTbusId(Long tbusId){
        this.tbusId = tbusId;
    }
    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }

    public String getDfEquity(){
        return dfEquity;
    }
    public void setDfEquity(String dfEquity){
        this.dfEquity = dfEquity;
    }

    public double getDfEquityMoney(){
        return dfEquityMoney;
    }
    public void setDfEquityMoney(double dfEquityMoney){
       this.dfEquityMoney =dfEquityMoney;
    }
    public double getDfEquityShares(){
        return dfEquityShares;
    }
    public void setDfEquityShares(double dfEquityShares){
        this.dfEquityShares =dfEquityShares;
    }
    public Date getDfEquityDate() {
        return dfEquityDate;
    }
    public void setDfEquityDate(Date dfEquityDate) {
        this.dfEquityDate = dfEquityDate;
    }
    public String getEquityFundPlan(){
        return equityFundPlan;
    }
    public void setEquityFundPlan(String equityFundPlan){
        this.equityFundPlan = equityFundPlan;
    }
    public String getDfEquityRecom(){
        return dfEquityRecom;
    }
    public void setDfEquityRecom(String dfEquityRecom){
        this.dfEquityRecom = dfEquityRecom;
    }


    public String getDfDebt(){
        return dfDebt;
    }
    public void setDfDebt(String dfDebt){
        this.dfDebt = dfDebt;
    }

    public double getDfDebtMoney(){
        return dfDebtMoney;
    }
    public void setDfDebtMoney(double dfDebtMoney){
        this.dfDebtMoney =dfDebtMoney;
    }
    public double getDebtMaxAnnual(){
        return debtMaxAnnual;
    }
    public void setDebtMaxAnnual(double debtMaxAnnual){
        this.debtMaxAnnual =debtMaxAnnual;
    }
    public Date getDfDebtDate() {
        return dfDebtDate;
    }
    public void setDfDebtDate(Date dfDebtDate) {
        this.dfDebtDate = dfDebtDate;
    }
    public String getDebtFundPlan(){
        return debtFundPlan;
    }
    public void setDebtFundPlan(String debtFundPlan){
        this.debtFundPlan = debtFundPlan;
    }
    public String getDfDebtRecom(){
        return dfDebtRecom;
    }
    public void setDfDebtRecom(String dfDebtRecom){
        this.dfDebtRecom = dfDebtRecom;
    }


    public String getDfCrowdFunding(){
        return dfCrowdFunding;
    }
    public void setDfCrowdFunding(String dfCrowdFunding){
        this.dfCrowdFunding = dfCrowdFunding;
    }
    public String getCrowsFundType(){
        return crowsFundType;
    }
    public void setCrowsFundType(String crowsFundType){
        this.crowsFundType = crowsFundType;
    }
    public String getDfMerge(){
        return dfMerge;
    }
    public void setDfMerge(String dfMerge){
        this.dfMerge = dfMerge;
    }
    public String getDfListedShareReform(){
        return dfListedShareReform;
    }
    public void setDfListedShareReform(String ddfListedShareReformfDebtRecom){
        this.dfListedShareReform = dfListedShareReform;
    }
    public String getDfFinancingGuarantee(){
        return dfFinancingGuarantee;
    }
    public void setDfFinancingGuarantee(String dfFinancingGuarantee){
        this.dfFinancingGuarantee = dfFinancingGuarantee;
    }
    public String getDfPettyLoan(){
        return dfPettyLoan;
    }
    public void setDfPettyLoan(String dfPettyLoan){
        this.dfPettyLoan = dfPettyLoan;
    }
    public double getPettyLoanMoney(){
        return pettyLoanMoney;
    }
    public void setPettyLoanMoney(double pettyLoanMoney){
        this.pettyLoanMoney = pettyLoanMoney;
    }
    public String getDfCompanyDebt(){
        return dfCompanyDebt;
    }
    public void setDfCompanyDebt(String dfCompanyDebt){
        this.dfCompanyDebt = dfCompanyDebt;
    }
    public String getMinorEnterprisesDebt(){
        return minorEnterprisesDebt;
    }
    public void setMinorEnterprisesDebt(String minorEnterprisesDebt){
        this.minorEnterprisesDebt = minorEnterprisesDebt;
    }
    public String getDfTechnicalImport(){
        return dfTechnicalImport;
    }
    public void setDfTechnicalImport(String dfTechnicalImport){
        this.dfTechnicalImport = dfTechnicalImport;
    }



    public String getTechnicalImportRange(){
        return technicalImportRange;
    }
    public void setTechnicalImportRange(String technicalImportRange){
        this.technicalImportRange = technicalImportRange;
    }
    public String getTechnicalDesc(){
        return technicalDesc;
    }
    public void setTechnicalDesc(String technicalDesc){
        this.technicalDesc = technicalDesc;
    }
    public String getDfTechnicalTransfer(){
        return dfTechnicalTransfer;
    }
    public void setDfTechnicalTransfer(String dfTechnicalTransfer){
        this.dfTechnicalTransfer = dfTechnicalTransfer;
    }
    public String getTechnicalTransferRange(){
        return technicalTransferRange;
    }
    public void setTechnicalTransferRange(String technicalTransferRange){
        this.technicalTransferRange = technicalTransferRange;
    }
    public String getDfPropertyAssign(){
        return dfPropertyAssign;
    }
    public void setDfPropertyAssign(String dfPropertyAssign){
        this.dfPropertyAssign = dfPropertyAssign;
    }
    public String getDfFinaceLease(){
        return dfFinaceLease;
    }
    public void setDfFinaceLease(String dfFinaceLease){
        this.dfFinaceLease = dfFinaceLease;
    }
    public String getDfTechnologyInsurance(){
        return dfTechnologyInsurance;
    }
    public void setDfTechnologyInsurance(String dfTechnologyInsurance){
        this.dfTechnologyInsurance = dfTechnologyInsurance;
    }
    public String getDfAssetManage(){
        return dfAssetManage;
    }
    public void setDfAssetManage(String dfAssetManage){
        this.dfAssetManage = dfAssetManage;
    }

    public String getBranchChongCheck(){
        return branchChongCheck;
    }
    public void setBranchChongCheck(String branchChongCheck){
        this.branchChongCheck = branchChongCheck;
    }
    public String getDfPoliticalConsult(){
        return dfPoliticalConsult;
    }
    public void setDfPoliticalConsult(String dfPoliticalConsult){
        this.dfPoliticalConsult = dfPoliticalConsult;
    }




    public String getDfTechnologyConsult(){
        return dfTechnologyConsult;
    }
    public void setDfTechnologyConsult(String dfTechnologyConsult){
        this.dfTechnologyConsult = dfTechnologyConsult;
    }
    public String getDfIntermediaryConsult(){
        return dfIntermediaryConsult;
    }
    public void setDfIntermediaryConsult(String dfIntermediaryConsult){
        this.dfIntermediaryConsult = dfIntermediaryConsult;
    }
    public String getIntermediaryConsultType(){
        return intermediaryConsultType;
    }
    public void setIntermediaryConsultType(String intermediaryConsultType){
        this.intermediaryConsultType = intermediaryConsultType;
    }
    public String getIntermediaryConsultDesc(){
        return intermediaryConsultDesc;
    }
    public void setIntermediaryConsultDesc(String intermediaryConsultDesc){
        this.intermediaryConsultDesc = intermediaryConsultDesc;
    }
    public String getDfOtherService(){
        return dfOtherService;
    }
    public void setDfOtherService(String dfOtherService){
        this.dfOtherService = dfOtherService;
    }

    public String getOtherServiceDesc(){
        return otherServiceDesc;
    }
    public void setOtherServiceDesc(String otherServiceDesc){
        this.otherServiceDesc = otherServiceDesc;
    }
    public String getDfAcceptTrain(){
        return dfAcceptTrain;
    }
    public void setDfAcceptTrain(String dfAcceptTrain){
        this.dfAcceptTrain = dfAcceptTrain;
    }

    public String getDfNo(){
        return dfNo;
    }
    public void setDfNo(String dfNo){
        this.dfNo = dfNo;
    }

}

