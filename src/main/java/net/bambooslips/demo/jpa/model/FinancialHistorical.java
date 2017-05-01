package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/21.
 * 历史财务数据
 */
@Entity
@Table(name = "financial_historical_data")
public class FinancialHistorical implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hfin_id")
    private Long hfinId;

    @Column(name = "ubus_id")
    private Long ubusId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "hfin_income")
    private Long hfinIncome;

    @Column(name = "hfin_cost")
    private Long hfinCost;

    @Column(name = "hfin_profit")
    private Long hfinProfit;

    @Column(name = "hfin_profit_rate")
    private Long hfinProfitRate;

    @Column(name = "hfin_expenses")
    private Long hfinExpenses;

    @Column(name = "hfin_operating_profit")
    private Long hfinOperatingProfit;

    @Column(name = "operating_profit_rate")
    private Long operatingProfitRate;

    @Column(name = "hfin_beforeTax_profit")
    private Long hfinBeforeTaxProfit;

    @Column(name = "hfin_net_margin")
    private Long hfinNetMargin;

    @Column(name = "hfin_fixed_netValue")
    private Long fixedNetValue;

    @Column(name = "hfin_assets_total")
    private Long hfinAssetsTotal;

    @Column(name = "hfin_liabilites_total")
    private Long hfinLialilitesTotal;

    @Column(name = "hfin_net_asset")
    private Long hfinNetAsset;

    @Column(name = "hfin_year")
    private String hfinYear;



    public FinancialHistorical(){
        super();

    }
    public FinancialHistorical(Long entireId,Long ubusId,Long hfinIncome,Long hfinCost,Long hfinProfit,
                               Long hfinProfitRate,Long hfinExpenses,Long hfinOperatingProfit,Long operatingProfitRate,
                               Long hfinBeforeTaxProfit,Long hfinNetMargin,Long fixedNetValue,Long hfinAssetsTotal,
                               Long hfinLialilitesTotal,Long hfinNetAsset,String hfinYear){
        this.ubusId = ubusId;
        this.hfinIncome = hfinIncome;
        this.entireId = entireId;
        this.hfinCost = hfinCost;
        this.hfinProfit = hfinProfit;
        this.hfinBeforeTaxProfit = hfinBeforeTaxProfit;
        this.hfinExpenses = hfinExpenses;
        this.hfinProfitRate = hfinProfitRate;
        this.hfinOperatingProfit = hfinOperatingProfit;
        this.operatingProfitRate = operatingProfitRate;
        this.hfinNetMargin = hfinNetMargin;
        this.fixedNetValue = fixedNetValue;

        this.hfinAssetsTotal = hfinAssetsTotal;
        this.hfinLialilitesTotal = hfinLialilitesTotal;
        this.hfinNetAsset = hfinNetAsset;
        this.hfinYear = hfinYear;

    }


    /**
     * 更新核心团队信息
     * @param updated
     * @return
     */
    public FinancialHistorical update(FinancialHistorical updated) {
        if(updated.getHfinIncome() != null)this.setHfinIncome(updated.getHfinIncome());
        if(updated.getHfinCost() != null)this.setHfinCost(updated.getHfinCost());
        if(updated.getHfinProfit() != null)this.setHfinProfit(updated.getHfinProfit());
        if(updated.getHfinProfitRate() != null)this.setHfinProfitRate(updated.getHfinProfitRate());
        if(updated.getHfinExpenses() != null)this.setHfinExpenses(updated.getHfinExpenses());
        if(updated.getHfinOperatingProfit() != null)this.setHfinOperatingProfit(updated.getHfinOperatingProfit());
        if(updated.getOperatingProfitRate() != null)this.setOperatingProfitRate(updated.getOperatingProfitRate());
        if(updated.getHfinBeforeTaxProfit() != null)this.setHfinBeforeTaxProfit(updated.getHfinBeforeTaxProfit());
        if(updated.getHfinNetMargin() != null)this.setHfinNetMargin(updated.getHfinNetMargin());

        if(updated.getFixedNetValue() != null)this.setFixedNetValue(updated.getFixedNetValue());
        if(updated.getHfinAssetsTotal() != null)this.setHfinAssetsTotal(updated.getHfinAssetsTotal());
        if(updated.getHfinLialilitesTotal() != null)this.setHfinLialilitesTotal(updated.getHfinLialilitesTotal());
        if(updated.getHfinNetAsset() != null)this.setHfinNetMargin(updated.getHfinNetAsset());
        if(updated.getHfinYear() != null)this.setHfinYear(updated.getHfinYear());

        return this;
    }

    public Long getHfinId(){
        return hfinId;
    }
    public void setHfinId(Long hfinId){
        this.hfinId = hfinId;
    }
    public Long getUbusId(){
        return ubusId;
    }
    public void setUbusId(Long ubusId){
        this.ubusId = ubusId;
    }

    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }

    public Long getHfinIncome(){
        return hfinIncome;
    }
    public void setHfinIncome(Long hfinIncome){
        this.hfinIncome = hfinIncome;
    }

    public Long getHfinCost(){
        return hfinCost;
    }
    public void setHfinCost(Long hfinCost){
       this.hfinCost =hfinCost;
    }

    public Long getHfinProfit(){
        return hfinProfit;
    }
    public void setHfinProfit(Long hfinProfit){
        this.hfinProfit = hfinProfit;
    }

    public Long getHfinProfitRate(){
        return hfinProfitRate;
    }
    public void setHfinProfitRate(Long hfinProfitRate){
        this.hfinProfitRate =hfinProfitRate;
    }

    public Long getHfinExpenses(){
        return hfinExpenses;
    }
    public void setHfinExpenses(Long hfinExpenses){
        this.hfinExpenses = hfinExpenses;
    }

    public Long getHfinOperatingProfit(){
        return hfinOperatingProfit;
    }
    public void setHfinOperatingProfit(Long hfinOperatingProfit){
        this.hfinOperatingProfit =hfinOperatingProfit;
    }

    public Long getOperatingProfitRate(){
        return operatingProfitRate;
    }
    public void setOperatingProfitRate(Long operatingProfitRate){
        this.operatingProfitRate =operatingProfitRate;
    }

    public Long getHfinBeforeTaxProfit(){
        return hfinBeforeTaxProfit;
    }
    public void setHfinBeforeTaxProfit(Long hfinBeforeTaxProfit){
        this.hfinBeforeTaxProfit = hfinBeforeTaxProfit;
    }

    public Long getHfinNetMargin(){
        return hfinNetMargin;
    }
    public void setHfinNetMargin(Long hfinNetMargin){
        this.hfinNetMargin =hfinNetMargin;
    }

    public Long getFixedNetValue(){
        return fixedNetValue;
    }
    public void setFixedNetValue(Long fixedNetValue){
        this.fixedNetValue = fixedNetValue;
    }

    public Long getHfinAssetsTotal(){
        return hfinAssetsTotal;
    }
    public void setHfinAssetsTotal(Long hfinAssetsTotal){
        this.hfinAssetsTotal =hfinAssetsTotal;
    }

    public Long getHfinLialilitesTotal(){
        return hfinLialilitesTotal;
    }
    public void setHfinLialilitesTotal(Long hfinLialilitesTotal){
        this.hfinLialilitesTotal = hfinLialilitesTotal;
    }

    public Long getHfinNetAsset(){
        return hfinNetAsset;
    }
    public void setHfinNetAsset(Long hfinNetAsset){
        this.hfinNetAsset =hfinNetAsset;
    }


    public String getHfinYear(){
        return hfinYear;
    }
    public void setHfinYear(String hfinYear){
        this.hfinYear =hfinYear;
    }

}

