package net.bambooslips.demo.jpa.model;

import org.springframework.security.access.method.P;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 * e专利
 */
@Entity
@Table(name = "patent_list")
public class PatentList implements  Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patent_id")
    private String patentId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "ue_id")
    private Long ueId;

    @Column(name = "te_id")
    private Long teId;

    @Column(name = "patent_name")
    private String patentName;

    @Column(name = "patent_type")
    private String patentType;

    @Column(name = "patent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patentDate;

    @Column(name = "patent_verification")
    private String patentVerification;



    public PatentList(){

    }
    public PatentList(String patentId,Long entireId,Long ueId,Long teId,String patentName,String patentType,
                      Date patentDate, String patentVerification){
        this.patentId = patentId;
        this.ueId = ueId;
        this.entireId = entireId;
        this.teId = teId;
        this.patentName = patentName;
        this.patentType = patentType;
        this.patentDate = patentDate;
        this.patentVerification = patentVerification;

    }

    /**
     * 更新联系人
     * @param updated
     * @return
     */
    public PatentList update(PatentList updated) {
        if(updated.getUeId() != null)this.setUeId(updated.getUeId());
        if(updated.getPatentId() != null)this.setPatentId(updated.getPatentId());
        if(updated.getPatentName() != null)this.setPatentName(updated.getPatentName());
        if(updated.getPatentType() != null)this.setPatentType(updated.getPatentType());
        if(updated.getPatentDate() != null)this.setPatentDate(updated.getPatentDate());
        if(updated.getPatentVerification() != null)this.setPatentVerification(updated.getPatentVerification());

        return this;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getPatentId(){
        return patentId;
    }
    public void setPatentId(String patentId){
        this.patentId = patentId;
    }
    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }
    public Long getUeId(){
        return ueId;
    }
    public void setUeId(Long ueId){
        this.ueId = ueId;
    }

    public Long getTeId(){
        return teId;
    }
    public void setTeId(Long teId){
        this.teId = teId;
    }

    public String getPatentName(){
        return patentName;
    }
    public void setPatentName(String patentName){
        this.patentName = patentName;
    }

    public String getPatentType(){
        return patentType;
    }
    public void setPatentType(String patentType){
       this.patentType =patentType;
    }

    public Date getPatentDate() {
        return patentDate;
    }

    public void setPatentDate(Date patentDate) {
        this.patentDate = patentDate;
    }

    public String getPatentVerification(){
        return patentVerification;
    }
    public void setPatentVerification(String patentVerification){
        this.patentVerification =patentVerification;
    }
}

