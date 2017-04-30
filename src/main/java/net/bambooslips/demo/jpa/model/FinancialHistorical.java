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
    private Double hfinIncome;

    @Column(name = "hfin_cost")
    private Double hfinCost;

    @Column(name = "hfin_profit")
    private Double hfinProfit;

    @Column(name = "hfin_profit_rate")
    private Double hfinProfitRate;

    @Column(name = "hfin_expenses")
    private Double hfinExpenses;

    @Column(name = "hfin_operating_profit")
    private Double hfinOperatingProfit;

    @Column(name = "operating_profit_rate")
    private Double operatingProfitRate;

    @Column(name = "hfin_beforeTax_profit")
    private Double hfinBeforeTaxProfit;

    @Column(name = "hfin_net_margin")
    private Double hfinNetMargin;

    @Column(name = "hfin_fixed_netValue")
    private Double fixedNetValue;

    @Column(name = "hfin_assets_total")
    private Double hfinAssetsTotal;

    @Column(name = "hfin_liabilites_total")
    private Double hfinLialilitesTotal;

    @Column(name = "hfin_net_asset")
    private Double hfinNetAsset;

    @Column(name = "hfin_year")
    private String hfinYear;



    public FinancialHistorical(){
        super();

    }
    public FinancialHistorical(Long entireId,Long ubusId,double hfinIncome,double hfinCost,double hfinProfit,
                               double hfinProfitRate,double hfinExpenses,double hfinOperatingProfit,double operatingProfitRate,
                               double hfinBeforeTaxProfit,double hfinNetMargin,double fixedNetValue,double hfinAssetsTotal,
                               double hfinLialilitesTotal,double hfinNetAsset,String hfinYear){
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

    public Double getHfinIncome(){
        return hfinIncome;
    }
    public void setHfinIncome(Double hfinIncome){
        this.hfinIncome = hfinIncome;
    }

    public Double getHfinCost(){
        return hfinCost;
    }
    public void setHfinCost(Double hfinCost){
       this.hfinCost =hfinCost;
    }

    public Double getHfinProfit(){
        return hfinProfit;
    }
    public void setHfinProfit(Double hfinProfit){
        this.hfinProfit = hfinProfit;
    }

    public Double getHfinProfitRate(){
        return hfinProfitRate;
    }
    public void setHfinProfitRate(Double hfinProfitRate){
        this.hfinProfitRate =hfinProfitRate;
    }

    public Double getHfinExpenses(){
        return hfinExpenses;
    }
    public void setHfinExpenses(Double hfinExpenses){
        this.hfinExpenses = hfinExpenses;
    }

    public Double getHfinOperatingProfit(){
        return hfinOperatingProfit;
    }
    public void setHfinOperatingProfit(Double hfinOperatingProfit){
        this.hfinOperatingProfit =hfinOperatingProfit;
    }

    public Double getOperatingProfitRate(){
        return operatingProfitRate;
    }
    public void setOperatingProfitRate(Double operatingProfitRate){
        this.operatingProfitRate =operatingProfitRate;
    }

    public Double getHfinBeforeTaxProfit(){
        return hfinBeforeTaxProfit;
    }
    public void setHfinBeforeTaxProfit(Double hfinBeforeTaxProfit){
        this.hfinBeforeTaxProfit = hfinBeforeTaxProfit;
    }

    public Double getHfinNetMargin(){
        return hfinNetMargin;
    }
    public void setHfinNetMargin(Double hfinNetMargin){
        this.hfinNetMargin =hfinNetMargin;
    }

    public Double getFixedNetValue(){
        return fixedNetValue;
    }
    public void setFixedNetValue(Double fixedNetValue){
        this.fixedNetValue = fixedNetValue;
    }

    public Double getHfinAssetsTotal(){
        return hfinAssetsTotal;
    }
    public void setHfinAssetsTotal(Double hfinAssetsTotal){
        this.hfinAssetsTotal =hfinAssetsTotal;
    }

    public Double getHfinLialilitesTotal(){
        return hfinLialilitesTotal;
    }
    public void setHfinLialilitesTotal(Double hfinLialilitesTotal){
        this.hfinLialilitesTotal = hfinLialilitesTotal;
    }

    public Double getHfinNetAsset(){
        return hfinNetAsset;
    }
    public void setHfinNetAsset(Double hfinNetAsset){
        this.hfinNetAsset =hfinNetAsset;
    }


    public String getHfinYear(){
        return hfinYear;
    }
    public void setHfinYear(String hfinYear){
        this.hfinYear =hfinYear;
    }

}

