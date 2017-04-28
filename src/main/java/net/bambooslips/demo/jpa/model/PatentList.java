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
    @Column(name = "patent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String patentId;

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

//    /**
//     * 更新联系人
//     * @param updated
//     * @return
//     */
//    public LegalRepresentative update(LegalRepresentative updated) {
//        if(updated.getWorkState() != null)this.setWorkState(updated.getWorkState());
//
//        return this;
//    }

    public String getPatentId(){
        return patentId;
    }
    public void setPatentId(String patentId){
        this.patentId = patentId;
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

