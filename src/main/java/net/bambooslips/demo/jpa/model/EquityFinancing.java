package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * 股权融资
 */
@Entity
@Table(name = "equity_financing")
public class EquityFinancing implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equity_id")
    private Long equityId;

    @Column(name = "ubus_id")
    private Long ubusId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "equity_investor")
    private String equityInvestor;

    @Column(name = "equity_money")
    private Long equityMoney;

    @Column(name = "equity_rate")
    private Long equityRate;

    @Column(name = "equity_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date equityDate;




    public EquityFinancing(){
        super();

    }
    public EquityFinancing(Long ubusId,Long entireId,
                           String equityInvestor,Long equityMoney,Long equityRate,
                           Date equityDate){
        this.ubusId = ubusId;
        this.entireId = entireId;
        this.equityInvestor = equityInvestor;
        this.equityMoney = equityMoney;
        this.equityRate = equityRate;
        this.equityDate = equityDate;

    }


    /**
     * 更新股权融资信息
     * @param updated
     * @return
     */
    public EquityFinancing update(EquityFinancing updated) {
        if(updated.getEquityInvestor() != null)this.setEquityInvestor(updated.getEquityInvestor());
        if(updated.getEquityMoney() <= 0)this.setEquityMoney(updated.getEquityMoney());
        if(updated.getEquityRate() <= 0)this.setEquityRate(updated.getEquityRate());
        if(updated.getEquityDate() != null)this.setEquityDate(updated.getEquityDate());

        return this;
    }

    public Long getEquityId(){
        return equityId;
    }
    public void setEquityId(Long equityId){
        this.equityId = equityId;
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

    public String getEquityInvestor(){
        return equityInvestor;
    }
    public void setEquityInvestor(String equityInvestor){
        this.equityInvestor = equityInvestor;
    }

    public Long getEquityMoney(){
        return equityMoney;
    }
    public void setEquityMoney(Long equityMoney){
       this.equityMoney =equityMoney;
    }

    public Long getEquityRate(){
        return equityRate;
    }
    public void setEquityRate(Long equityRate){
        this.equityRate =equityRate;
    }

    public Date getEquityDate() {
        return equityDate;
    }

    public void setEquityDate(Date equityDate) {
        this.equityDate = equityDate;
    }
}

