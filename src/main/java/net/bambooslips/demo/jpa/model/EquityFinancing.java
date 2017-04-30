package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * e专利
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
    private double equityMoney;

    @Column(name = "equity_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date equityDate;




    public EquityFinancing(){
        super();

    }
    public EquityFinancing(Long ubusId,Long entireId,
                           String equityInvestor,double equityMoney,
                           Date equityDate){
        this.ubusId = ubusId;
        this.entireId = entireId;
        this.equityInvestor = equityInvestor;
        this.equityMoney = equityMoney;
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

    public double getEquityMoney(){
        return equityMoney;
    }
    public void setEquityMoney(double equityMoney){
       this.equityMoney =equityMoney;
    }

    public Date getEquityDate() {
        return equityDate;
    }

    public void setEquityDate(Date equityDate) {
        this.equityDate = equityDate;
    }
}

