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

    @Column(name = "df_is_equity")
    private String dfEquity;

    @Column(name = "df_equity_money")
    private Long dfEquityMoney;

    @Column(name = "df_equity_shares")
    private Long dfEquityShares;

    @Column(name = "df_equity_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfEquityDate;

    @Column(name = "df_equity_fund_plan",length = 1500)
    private String equityFundPlan;

    @Column(name = "df_is_equity_recom")
    private String dfEquityRecom;

    @Column(name = "df_isDebt")
    private String dfDebt;

    @Column(name = "df_debt_money")
    private Long dfDebtMoney;

    @Column(name = "df_debt_max_annual")
    private Long debtMaxAnnual;

    @Column(name = "df_debt_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfDebtDate;

    @Column(name = "df_debt_fund_plan",length = 1500)
    private String debtFundPlan;

    @Column(name = "df_is_debt_recom")
    private String dfDebtRecom;


    @Column(name = "df_is_crowd_funding")
    private String dfCrowdFunding;

    @Column(name = "crows_fund_type")
    private String crowsFundType;
    @Column(name = "df_is_merge")
    private String dfMerge;

    @Column(name = "df_is_listed_share_reform")
    private String dfListedShareReform;
    @Column(name = "df_is_financing_guarantee")
    private String dfFinancingGuarantee;

    @Column(name = "df_is_petty_loan")
    private String dfPettyLoan;

    @Column(name = "petty_loan_money")
    private Long pettyLoanMoney;

    @Column(name = "df_company_is_debt")
    private String dfCompanyDebt;

    @Column(name = "df_minorEnterprises_is_debt")
    private String minorEnterprisesDebt;
    @Column(name = "df_technical_import")
    private String dfTechnicalImport;

    @Column(name = "technical_import_international")
    private String technicalImportInternational;

    @Column(name = "technical_desc_international")
    private String technicalDescInternational;
    @Column(name = "technical_import_internal")

    private String technicalImportInternal;
    @Column(name = "technical_desc_internal")
    private String technicalDescInternatl;

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

    @Column(name = "df_branch_chong_check")
    private String branchChongCheck;

    @Column(name = "df_political_consult")
    private String dfPoliticalConsult;

    @Column(name = "df_technology_consult")
    private String dfTechnologyConsult;
    @Column(name = "df_intermediary_consult")
    private String dfIntermediaryConsult;

    @Column(name = "intermediary_law")
    private String intermediaryLaw;

    @Column(name = "intermediary_finance")
    private String intermediaryFinance;
    @Column(name = "intermediary_Financing")
    private String intermediaryFinancing;
    @Column(name = "intermediary_manage")
    private String intermediaryManage;

    @Column(name = "intermediary_law_desc")
    private String intermediaryLawDesc;
    @Column(name = "intermediary_finance_desc")
    private String intermediaryFinanceDesc;
    @Column(name = "intermediary_financing_desc")
    private String intermediaryFinancingDesc;
    @Column(name = "intermediary_manage_desc")
    private String intermediaryManageDesc;

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
    public DemandFinancial(Long entireId, Long ubusId, Long tbusId, String dfEquity, Long dfEquityShares,
                           Long dfEquityMoney, Date dfEquityDate, String equityFundPlan, String dfEquityRecom,
                           String dfDebt, Long dfDebtMoney, Long debtMaxAnnual, Date dfDebtDate,
                           String debtFundPlan, String dfDebtRecom, String dfCrowdFunding, String crowsFundType,
                           String dfMerge, String dfListedShareReform, String dfFinancingGuarantee, String dfPettyLoan,
                           Long pettyLoanMoney, String dfCompanyDebt, String minorEnterprisesDebt,
                           String dfTechnicalImport, String technicalImportInternational, String technicalDescInternational,
                           String technicalImportInternal, String technicalDescInternatl,
                           String dfTechnicalTransfer, String technicalTransferRange, String dfPropertyAssign,
                           String dfFinaceLease, String dfTechnologyInsurance, String dfAssetManage,
                           String branchChongCheck, String dfPoliticalConsult, String dfTechnologyConsult,
                           String dfIntermediaryConsult, String intermediaryLaw, String intermediaryLawDesc,
                           String intermediaryFinance, String intermediaryFinanceDesc,String intermediaryFinancing, String intermediaryFinancingDesc,
                           String intermediaryManage, String intermediaryManageDesc,
                           String dfOtherService, String otherServiceDesc, String dfAcceptTrain, String dfNo){
        this.ubusId = ubusId;
        this.entireId = entireId;
        this.tbusId = tbusId;this.dfEquity = dfEquity;this.dfEquityShares = dfEquityShares;this.dfEquityMoney = dfEquityMoney;
        if(dfEquityDate == null){
            this.dfEquityDate = null;
        }else {
            this.dfEquityDate = dfEquityDate;
        }
        this.equityFundPlan = equityFundPlan;this.dfEquityRecom = dfEquityRecom;
        this.dfDebt = dfDebt;this.dfDebtMoney = dfDebtMoney;this.debtMaxAnnual = debtMaxAnnual;
        if(dfDebtDate == null){
            this.dfDebtDate = null;
        }else {
            this.dfDebtDate = dfDebtDate;
        }
        this.debtFundPlan = debtFundPlan;this.dfDebtRecom = dfDebtRecom;this.dfCrowdFunding = dfCrowdFunding;this.crowsFundType = crowsFundType;
        this.dfMerge = dfMerge;this.dfListedShareReform = dfListedShareReform;this.dfFinancingGuarantee = dfFinancingGuarantee;
        this.dfPettyLoan = dfPettyLoan;this.pettyLoanMoney = pettyLoanMoney;this.dfCompanyDebt = dfCompanyDebt;
        this.minorEnterprisesDebt = minorEnterprisesDebt;
        this.dfTechnicalImport = dfTechnicalImport;
        this.technicalImportInternational = technicalImportInternational;

        this.technicalDescInternational = technicalDescInternational;
        this.technicalImportInternal = technicalImportInternal;

        this.technicalDescInternatl = technicalDescInternatl;this.dfTechnicalTransfer = dfTechnicalTransfer;this.technicalTransferRange = technicalTransferRange;
        this.dfPropertyAssign = dfPropertyAssign;this.dfFinaceLease = dfFinaceLease;this.dfTechnologyInsurance = dfTechnologyInsurance;
        this.dfAssetManage = dfAssetManage;
        this.branchChongCheck = branchChongCheck;
        this.dfPoliticalConsult = dfPoliticalConsult;

        this.dfTechnologyConsult = dfTechnologyConsult;this.dfIntermediaryConsult = dfIntermediaryConsult;
        this.intermediaryLaw = intermediaryLaw;this.intermediaryLawDesc = intermediaryLawDesc;
        this.intermediaryFinance = intermediaryFinance;this.intermediaryFinanceDesc = intermediaryFinanceDesc;
        this.intermediaryFinancing = intermediaryFinancing;this.intermediaryFinancingDesc = intermediaryFinancingDesc;
        this.intermediaryManage= intermediaryManage;this.intermediaryManageDesc = intermediaryManageDesc;
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
       this.setDfEquity(updated.getDfEquity());
        this.setDfEquityMoney(updated.getDfEquityMoney());
        this.setDfEquityShares(updated.getDfEquityShares());
        this.setDfEquityDate(updated.getDfEquityDate());
        this.setEquityFundPlan(updated.getEquityFundPlan());
        this.setDfEquityRecom(updated.getDfEquityRecom());
        this.setDfDebt(updated.getDfDebt());
        this.setDfDebtMoney(updated.getDfDebtMoney());
        this.setDebtMaxAnnual(updated.getDebtMaxAnnual());
        this.setDfDebtDate(updated.getDfDebtDate());
        this.setDebtFundPlan(updated.getDebtFundPlan());
        this.setDfDebtRecom(updated.getDfDebtRecom());
        this.setDfCrowdFunding(updated.getDfCrowdFunding());
        this.setCrowsFundType(updated.getCrowsFundType());
        this.setDfMerge(updated.getDfMerge());
        this.setDfListedShareReform(updated.getDfListedShareReform());
        this.setDfFinancingGuarantee(updated.getDfFinancingGuarantee());
        this.setDfPettyLoan(updated.getDfPettyLoan());
        this.setPettyLoanMoney(updated.getPettyLoanMoney());
        this.setDfCompanyDebt(updated.getDfCompanyDebt());
        this.setMinorEnterprisesDebt(updated.getMinorEnterprisesDebt());
        this.setDfTechnicalImport(updated.getDfTechnicalImport());
        this.setTechnicalImportInternational(updated.getTechnicalImportInternational());
        this.setTechnicalDescInternational(updated.getTechnicalDescInternational());
        this.setTechnicalImportInternal(updated.getTechnicalImportInternal());
        this.setTechnicalDescInternatl(updated.getTechnicalDescInternatl());
        this.setDfTechnicalTransfer(updated.getDfTechnicalTransfer());
        this.setTechnicalTransferRange(updated.getTechnicalTransferRange());
        this.setDfPropertyAssign(updated.getDfPropertyAssign());
        this.setDfFinaceLease(updated.getDfFinaceLease());
        this.setDfTechnologyInsurance(updated.getDfTechnologyInsurance());
        this.setDfAssetManage(updated.getDfAssetManage());
        this.setBranchChongCheck(updated.getBranchChongCheck());
        this.setDfPoliticalConsult(updated.getDfPoliticalConsult());
        this.setDfTechnologyConsult(updated.getDfTechnologyConsult());
        this.setDfIntermediaryConsult(updated.getDfIntermediaryConsult());
        this.setIntermediaryLaw(updated.getIntermediaryLaw());
        this.setIntermediaryFinance(updated.getIntermediaryFinance());
        this.setIntermediaryFinancing(updated.getIntermediaryFinancing());
        this.setIntermediaryManage(updated.getIntermediaryManage());
        this.setDfOtherService(updated.getDfOtherService());
        this.setOtherServiceDesc(updated.getOtherServiceDesc());
        this.setDfAcceptTrain(updated.getDfAcceptTrain());
        this.setDfNo(updated.getDfNo());

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

    public Long getDfEquityMoney(){
        return dfEquityMoney;
    }
    public void setDfEquityMoney(Long dfEquityMoney){
       this.dfEquityMoney =dfEquityMoney;
    }
    public Long getDfEquityShares(){
        return dfEquityShares;
    }
    public void setDfEquityShares(Long dfEquityShares){
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

    public Long getDfDebtMoney(){
        return dfDebtMoney;
    }
    public void setDfDebtMoney(Long dfDebtMoney){
        this.dfDebtMoney =dfDebtMoney;
    }
    public Long getDebtMaxAnnual(){
        return debtMaxAnnual;
    }
    public void setDebtMaxAnnual(Long debtMaxAnnual){
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
    public void setDfListedShareReform(String dfListedShareReform){
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
    public Long getPettyLoanMoney(){
        return pettyLoanMoney;
    }
    public void setPettyLoanMoney(Long pettyLoanMoney){
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



    public String getTechnicalImportInternational(){
        return technicalImportInternational;
    }
    public void setTechnicalImportInternational(String technicalImportInternational){
        this.technicalImportInternational = technicalImportInternational;
    }
    public String getTechnicalDescInternational(){
        return technicalDescInternational;
    }
    public void setTechnicalDescInternational(String technicalDescInternational){
        this.technicalDescInternational = technicalDescInternational;
    }

    public String getTechnicalImportInternal(){
        return technicalImportInternal;
    }
    public void setTechnicalImportInternal(String technicalImportInternal){
        this.technicalImportInternal = technicalImportInternal;
    }
    public String getTechnicalDescInternatl(){
        return technicalDescInternatl;
    }
    public void setTechnicalDescInternatl(String technicalDescInternatl){
        this.technicalDescInternatl = technicalDescInternatl;
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
    public String getIntermediaryLaw(){
        return intermediaryLaw;
    }
    public void setIntermediaryLaw(String intermediaryLaw){
        this.intermediaryLaw = intermediaryLaw;
    }
    public String getIntermediaryFinance(){
        return intermediaryFinance;
    }
    public void setIntermediaryFinance(String intermediaryFinance){
        this.intermediaryFinance = intermediaryFinance;
    }
    public String getIntermediaryFinancing(){
        return intermediaryFinancing;
    }
    public void setIntermediaryFinancing(String intermediaryFinancing){
        this.intermediaryFinancing = intermediaryFinancing;
    }
    public String getIntermediaryManage(){
        return intermediaryManage;
    }
    public void setIntermediaryManage(String intermediaryManage){
        this.intermediaryManage = intermediaryManage;
    }

    public String getIntermediaryLawDesc(){
        return intermediaryLawDesc;
    }
    public void setIntermediaryLawDesc(String intermediaryLawDesc){
        this.intermediaryLawDesc = intermediaryLawDesc;
    }
    public String getIntermediaryFinanceDesc(){
        return intermediaryFinanceDesc;
    }
    public void setIntermediaryFinanceDesc(String intermediaryFinanceDesc){
        this.intermediaryFinanceDesc = intermediaryFinanceDesc;
    }
    public String getIntermediaryFinancingDesc(){
        return intermediaryFinancingDesc;
    }
    public void setIntermediaryFinancingDesc(String intermediaryFinancingDesc){
        this.intermediaryFinancingDesc = intermediaryFinancingDesc;
    }
    public String getIntermediaryManageDesc(){
        return intermediaryManageDesc;
    }
    public void setIntermediaryManageDesc(String intermediaryManageDesc){
        this.intermediaryManageDesc = intermediaryManageDesc;
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

