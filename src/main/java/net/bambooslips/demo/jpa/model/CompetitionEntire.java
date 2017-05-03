package net.bambooslips.demo.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/21.
 * entire 录入参赛作品id及更新参赛作品状态实体
 */
@Entity
@Table(name = "competition_entire")
public class CompetitionEntire implements  Serializable {

    @Id
    @Column(name = "entire_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entireId;

    @Column(name = "com_name")
    private String comName;

    @Column(name = "entry_type")
    private String entryType;

    @Column(name = "work_state")
    private String workState;

    @Column(name = "state")
    private String state;

    @Column(name = "ubus_pro_name")
    private String ubusProName;






    public CompetitionEntire(){

    }
    public CompetitionEntire(String comName,String entryType,String workState,String state){
        this.comName = comName;
        this.entryType = entryType;
        this.workState = workState;
        this.state = state;

    }

    /**
     * 更新作品状态 作品提交状态（保存KEEP，已提交SUBMIT，审核EXMINE,END
     * @param updated
     * @return
     */
    public CompetitionEntire update(CompetitionEntire updated) {
        if(updated.getWorkState() != null)this.setWorkState(updated.getWorkState());

        return this;
    }

    public CompetitionEntire updateState(CompetitionEntire updated) {
        if(updated.getState() != null)this.setState(updated.getState());

        return this;
    }

    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }
    public String getComName(){
        return comName;
    }
    public void setComName(String comName){
        this.comName = comName;
    }

    public String getEntryType(){
        return entryType;
    }
    public void setEntryType(String entryType){
        this.entryType = entryType;
    }

    public String getWorkState(){
        return workState;
    }
    public void setWorkState(String workState){
       this.workState =workState;
    }

    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state =state;
    }

    public String getUbusProName(){
        return ubusProName;
    }
    public void setUbusProName(String ubusProName){
        this.ubusProName = ubusProName;
    }

}

