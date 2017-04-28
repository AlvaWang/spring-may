package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * entire 录入参赛作品id及更新参赛作品状态实体
 */
@Entity
@Table(name = "contacts")
public class Contacts implements  Serializable {

    @Id
    @Column(name = "contacts_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactsId;

    @Column(name = "ue_id")
    private Long ueId;

    @Column(name = "contacts_name")
    private String contactsName;

    @Column(name = "contacts_job")
    private String contactsJob;

    @Column(name = "contacts_office_tel")
    private String contactsOfficeTel;

    @Column(name = "contacts__mobile_tel")
    private String contactsMobileTel;

    @Column(name = "contacts__email")
    private String contactsEmail;



    public Contacts(){

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

    public Long getContactsId(){
        return contactsId;
    }
    public void setContactsId(Long contactsId){
        this.contactsId = contactsId;
    }
    public Long getUeId(){
        return ueId;
    }
    public void setUeId(Long ueId){
        this.ueId = ueId;
    }

    public String getContactsName(){
        return contactsName;
    }
    public void setContactsName(String contactsName){
        this.contactsName = contactsName;
    }

    public String getContactsJob(){
        return contactsJob;
    }
    public void setContactsJob(String contactsJob){
       this.contactsJob =contactsJob;
    }

    public String getContactsOfficeTel(){
        return contactsOfficeTel;
    }
    public void setContactsOfficeTel(String contactsOfficeTel){
        this.contactsOfficeTel = contactsOfficeTel;
    }

    public String getContactsMobileTel(){
        return contactsMobileTel;
    }
    public void setContactsMobileTel(String contactsMobileTel){
        this.contactsMobileTel =contactsMobileTel;
    }

    public String getContactsEmail(){
        return contactsEmail;
    }
    public void setContactsEmail(String contactsEmail){
        this.contactsEmail =contactsEmail;
    }

//    @Override
//    public int compareTo(BaseModel o) {
//        return this.getContactsId().compareTo(o.getId());
//    }
}

