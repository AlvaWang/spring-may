package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * 法定代表人
 */
@Entity
@Table(name = "legal_representative")
public class LegalRepresentative implements  Serializable {

    @Id
    @Column(name = "legal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long legalId;

    @Column(name = "ue_id")
    private Long ueId;

    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "legal_job")
    private String legalJob;

    @Column(name = "legal_office_tel")
    private String legalOfficeTel;

    @Column(name = "legal_mobile_tel")
    private String legalMobileTel;

    @Column(name = "legal_email")
    private String legalEmail;



    public LegalRepresentative(){

    }

//    /**
//     * 更新法定联系人
//     * @param updated
//     * @return
//     */
//    public LegalRepresentative update(LegalRepresentative updated) {
//        if(updated.getWorkState() != null)this.setWorkState(updated.getWorkState());
//
//        return this;
//    }

    public Long getLegalId(){
        return legalId;
    }
    public void setLegalId(Long legalId){
        this.legalId = legalId;
    }
    public Long getUeId(){
        return ueId;
    }
    public void setUeId(Long ueId){
        this.ueId = ueId;
    }

    public String getLegalName(){
        return legalName;
    }
    public void setLegalName(String legalName){
        this.legalName = legalName;
    }

    public String getLegalJob(){
        return legalJob;
    }
    public void setLegalJob(String legalJob){
       this.legalJob =legalJob;
    }

    public String getLegalOfficeTel(){
        return legalOfficeTel;
    }
    public void setLegalOfficeTel(String legalOfficeTel){
        this.legalOfficeTel = legalOfficeTel;
    }

    public String getLegalMobileTel(){
        return legalMobileTel;
    }
    public void setLegalMobileTel(String legalMobileTel){
        this.legalMobileTel =legalMobileTel;
    }

    public String getLegalEmail(){
        return legalEmail;
    }
    public void setLegalEmail(String legalEmail){
        this.legalEmail =legalEmail;
    }
//
//    @Override
//    public int compareTo(BaseModel o) {
//        return this.getLegalId().compareTo(o.getId());
//    }
}

