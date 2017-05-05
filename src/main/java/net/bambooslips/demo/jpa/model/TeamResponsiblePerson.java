package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * entire 录入参赛作品id及更新参赛作品状态实体
 */
@Entity
@Table(name = "team_responsible_person")
public class TeamResponsiblePerson implements  Serializable {

    @Id
    @Column(name = "res_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;

    @Column(name = "te_id")
    private Long teId;

    @Column(name = "entire_id")
    private Long entireId;

    @Column(name = "res_name")
    private String resName;

    @Column(name = "res_job")
    private String resJob;

    @Column(name = "res_document_type")
    private String resDocumentType;

    @Column(name = "document_num")
    private String documentNum;

    @Column(name = "res_office_tel")
    private String resOfficeTel;

    @Column(name = "res_mobile_tel")
    private String resMobileTel;

    @Column(name = "res_email")
    private String resEmail;

    public TeamResponsiblePerson(){

    }
    public TeamResponsiblePerson(Long entireId, Long teId, String resName, String resJob, String resDocumentType,
                                 String documentNum, String resOfficeTel,String resMobileTel,String resEmail){
        this.entireId = entireId;
        this.teId = teId;
        this.resName = resName;
        this.resJob = resJob;
        this.resDocumentType = resDocumentType;
        this.documentNum = documentNum;
        this.resOfficeTel = resOfficeTel;
        this.resMobileTel = resMobileTel;
        this.resEmail = resEmail;

    }

    /**
     * 更新联系人
     * @param updated
     * @return
     */
    public TeamResponsiblePerson update(TeamResponsiblePerson updated) {
        if(updated.getEntireId() != null)this.setEntireId(updated.getEntireId());
        if(updated.getTeId() != null)this.setTeId(updated.getTeId());
        if(updated.getResName() != null)this.setResName(updated.getResName());
        if(updated.getResJob() != null)this.setResJob(updated.getResJob());
        if(updated.getResDocumentType() != null)this.setResDocumentType(updated.getResDocumentType());
        if(updated.getDocumentNum() != null)this.setDocumentNum(updated.getDocumentNum());
        if(updated.getResOfficeTel() != null)this.setResOfficeTel(updated.getResOfficeTel());
        if(updated.getResMobileTel() != null)this.setResMobileTel(updated.getResMobileTel());
        if(updated.getResEmail() != null)this.setResEmail(updated.getResEmail());
        return this;
    }

    public Long getResId(){
        return resId;
    }
    public void setResId(Long resId){
        this.resId = resId;
    }
    public Long getTeId(){
        return teId;
    }
    public void setTeId(Long teId){
        this.teId = teId;
    }
    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }
    public String getResName(){
        return resName;
    }
    public void setResName(String resName){
        this.resName = resName;
    }

    public String getResJob(){
        return resJob;
    }
    public void setResJob(String resJob){
       this.resJob =resJob;
    }

    public String getResDocumentType(){
        return resDocumentType;
    }
    public void setResDocumentType(String resDocumentType){
        this.resDocumentType = resDocumentType;
    }

    public String getDocumentNum(){
        return documentNum;
    }
    public void setDocumentNum(String documentNum){
        this.documentNum =documentNum;
    }

    public String getResOfficeTel(){
        return resOfficeTel;
    }
    public void setResOfficeTel(String resOfficeTel){
        this.resOfficeTel =resOfficeTel;
    }

    public String getResMobileTel(){
        return resMobileTel;
    }
    public void setResMobileTel(String resMobileTel){
        this.resMobileTel =resMobileTel;
    }

    public String getResEmail(){
        return resEmail;
    }
    public void setResEmail(String resEmail){
        this.resEmail =resEmail;
    }

}

