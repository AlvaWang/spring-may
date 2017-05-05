package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * entire 录入参赛作品id及更新参赛作品状态实体
 */
@Entity
@Table(name = "economic_risk_counter")
public class EconomicRiskCounter implements  Serializable {

    @Id
    @Column(name = "econo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long econoId;

    @Column(name = "tbus_id")
    private Long tbusId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "econo_litigation_content")
    private String econoLitigationContent;

    @Column(name = "litigation_reason")
    private String litigationReason;



    public EconomicRiskCounter(){

    }
    public EconomicRiskCounter(Long entireId, Long tbusId, String econoLitigationContent, String litigationReason){
        this.entireId = entireId;
        this.tbusId = tbusId;
        this.econoLitigationContent = econoLitigationContent;
        this.litigationReason = litigationReason;

    }

    /**
     * 更新联系人
     * @param updated
     * @return
     */
    public EconomicRiskCounter update(EconomicRiskCounter updated) {
        if(updated.getEntireId() != null)this.setEntireId(updated.getEntireId());
        if(updated.getTbusId() != null)this.setTbusId(updated.getTbusId());
        if(updated.getEconoLitigationContent() != null)this.setEconoLitigationContent(updated.getEconoLitigationContent());
        if(updated.getLitigationReason() != null)this.setLitigationReason(updated.getLitigationReason());

        return this;
    }

    public Long getEconoId(){
        return econoId;
    }
    public void setEconoId(Long econoId){
        this.econoId = econoId;
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
    public String getEconoLitigationContent(){
        return econoLitigationContent;
    }
    public void setEconoLitigationContent(String econoLitigationContent){
        this.econoLitigationContent = econoLitigationContent;
    }

    public String getLitigationReason(){
        return litigationReason;
    }
    public void setLitigationReason(String litigationReason){
       this.litigationReason =litigationReason;
    }

}

