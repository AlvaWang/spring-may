package net.bambooslips.demo.jpa.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/4/21.
 */
@Entity
@Table(name = "competition_account")
public class CompetitionAccount extends BaseModel{

//    @Column(name = "com_acc_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long comAccId;

    @Column(name = "com_acc_name")
    private String comAccName;

    @Column(name = "com_acc_pwd")
    private String comAccPwd;

    @Column(name = "com_acc_email")
    private String comAccEmail;

    @Column(name = "com_acc_type")
    private String comAccType;


    public CompetitionAccount(){

    }
    public CompetitionAccount(String comAccName, String comAccPwd,String comAccType){
        super();
        this.comAccName = comAccName;
        this.comAccPwd = comAccPwd;
        this.comAccType = comAccType;

    }

    public CompetitionAccount(String comAccName,String comAccPwd,String comAccEmail,String comAccType){
        this.comAccName = comAccName;
        this.comAccPwd = comAccPwd;
        this.comAccEmail = comAccEmail;
        this.comAccType = comAccType;
    }

//    public Long getComAccId(){
//        return comAccId;
//    }
//    public void setComAccId(Long comAccId){
//        this.comAccId = comAccId;
//    }

    public String getComAccName(){
        return comAccName;
    }
    public void setComAccName(String comAccName){
        this.comAccName = comAccName;
    }

    public String getComAccEmail(){
        return comAccEmail;
    }
    public void setComAccEmail(String comAccEmail){
       this.comAccEmail =comAccEmail;
    }

    public String getComAccType(){
        return comAccType;
    }
    public void setComAccType(String comAccType){
        this.comAccType = comAccType;
    }

    public String getComAccPwd(){
        return comAccPwd;
    }
    public void setComAccPwd(String comAccPwd){
        this.comAccPwd = comAccPwd;
    }

}

