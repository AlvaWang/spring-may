package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * e专利
 */
@Entity
@Table(name = "debt_financing")
public class DebtFinancing implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "debt_id")
    private Long debtId;

    @Column(name = "ubus_id")
    private Long ubusId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "debt_leader")
    private String debtLeader;

    @Column(name = "debt_money")
    private Long debtMoney;

    @Column(name = "debt_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debtStartTime;

    @Column(name = "debt_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debtEndTime;



    public DebtFinancing(){
        super();

    }
    public DebtFinancing(Long ubusId, Long entireId,
                         String debtLeader, Long debtMoney,
                         Date debtStartTime,Date debtEndTime){
        this.ubusId = ubusId;
        this.entireId = entireId;
        this.debtLeader = debtLeader;
        this.debtMoney = debtMoney;
        this.debtStartTime = debtStartTime;
        this.debtEndTime = debtEndTime;
    }


    /**
     * 更新股权融资信息
     * @param updated
     * @return
     */
    public DebtFinancing update(DebtFinancing updated) {
        if(updated.getDebtLeader() != null)this.setDebtLeader(updated.getDebtLeader());
        if(updated.getDebtMoney() !=null && updated.getDebtMoney()>0)this.setDebtMoney(updated.getDebtMoney());
        if(updated.getDebtStartTime() != null)this.setDebtStartTime(updated.getDebtStartTime());
        if(updated.getDebtEndTime() != null)this.setDebtEndTime(updated.getDebtEndTime());

        return this;
    }

    public Long getDebtId(){
        return debtId;
    }
    public void setDebtId(Long debtId){
        this.debtId = debtId;
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

    public String getDebtLeader(){
        return debtLeader;
    }
    public void setDebtLeader(String debtLeader){
        this.debtLeader = debtLeader;
    }

    public Long getDebtMoney(){
        return debtMoney;
    }
    public void setDebtMoney(Long debtMoney){
       this.debtMoney =debtMoney;
    }

    public Date getDebtStartTime() {
        return debtStartTime;
    }

    public void setDebtStartTime(Date debtStartTime) {
        this.debtStartTime = debtStartTime;
    }

    public Date getDebtEndTime() {
        return debtEndTime;
    }

    public void setDebtEndTime(Date debtEndTime) {
        this.debtEndTime = debtEndTime;
    }

}

