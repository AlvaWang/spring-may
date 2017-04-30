package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * 历史财务数据
 */
@Entity
@Table(name = "financial_forecasting")
public class FinancialForecasting implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fore_id")
    private Long foreId;

    @Column(name = "ubus_id")
    private Long ubusId;
    @Column(name = "tbus_id")
    private Long tbusId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "fore_income")
    private Double foreIncome;

    @Column(name = "fore_cost")
    private Double foreCost;

    @Column(name = "fore_tax_expense")
    private Double foreTaxExpense;

    @Column(name = "fore_profit")
    private Double foreProfit;

    @Column(name = "fore_profit_rate")
    private Double foreProfitRate;

    @Column(name = "fore_net_margin")
    private Double foreNetMargin;

    @Column(name = "fore_year")
    private String foreYear;



    public FinancialForecasting(){
        super();

    }
    public FinancialForecasting(Long entireId, Long ubusId, Long tbusId,double foreIncome, double foreCost, double foreTaxExpense,
                                double foreProfit, double foreProfitRate, double foreNetMargin, String foreYear){
        this.ubusId = ubusId;
        this.tbusId = tbusId;
        this.foreIncome = foreIncome;
        this.entireId = entireId;
        this.foreCost = foreCost;
        this.foreTaxExpense = foreTaxExpense;
        this.foreProfit = foreProfit;
        this.foreProfitRate = foreProfitRate;
        this.foreNetMargin = foreNetMargin;
        this.foreYear = foreYear;

    }


    /**
     * 更新核心团队信息
     * @param updated
     * @return
     */
    public FinancialForecasting update(FinancialForecasting updated) {
        if(updated.getForeCost() != null)this.setForeCost(updated.getForeCost());
        if(updated.getForeIncome() != null)this.setForeIncome(updated.getForeIncome());
        if(updated.getForeTaxExpense() != null)this.setForeTaxExpense(updated.getForeTaxExpense());
        if(updated.getForeProfit() != null)this.setForeProfit(updated.getForeProfit());
        if(updated.getForeProfitRate() != null)this.setForeProfitRate(updated.getForeProfitRate());
        if(updated.getForeNetMargin() != null)this.setForeNetMargin(updated.getForeNetMargin());
        if(updated.getForeYear() != null)this.setForeYear(updated.getForeYear());

        return this;
    }

    public Long getForeId(){
        return foreId;
    }
    public void setForeId(Long foreId){
        this.foreId = foreId;
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

    public Double getForeIncome(){
        return foreIncome;
    }
    public void setForeIncome(Double foreIncome){
        this.foreIncome = foreIncome;
    }

    public Double getForeCost(){
        return foreCost;
    }
    public void setForeCost(Double foreCost){
       this.foreCost =foreCost;
    }

    public Double getForeTaxExpense(){
        return foreTaxExpense;
    }
    public void setForeTaxExpense(Double foreTaxExpense){
        this.foreTaxExpense = foreTaxExpense;
    }

    public Double getForeProfit(){
        return foreProfit;
    }
    public void setForeProfit(Double foreProfit){
        this.foreProfit =foreProfit;
    }

    public Double getForeProfitRate(){
        return foreProfitRate;
    }
    public void setForeProfitRate(Double foreProfitRate){
        this.foreProfitRate = foreProfitRate;
    }

    public Double getForeNetMargin(){
        return foreNetMargin;
    }
    public void setForeNetMargin(Double foreNetMargin){
        this.foreNetMargin =foreNetMargin;
    }

    public String getForeYear(){
        return foreYear;
    }
    public void setForeYear(String foreYear){
        this.foreYear =foreYear;
    }

}

