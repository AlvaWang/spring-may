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

    @Column(name = "com_id")
    private Long comId;

    @Column(name = "entry_type")
    private String entryType;

    @Column(name = "work_state")
    private String workState;



    public CompetitionEntire(){

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

    public Long getEntireId(){
        return entireId;
    }
    public void setEntireId(Long entireId){
        this.entireId = entireId;
    }
    public Long getComId(){
        return comId;
    }
    public void setComId(Long comId){
        this.comId = comId;
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

//    @Override
//    public int compareTo(BaseModel o) {
//        return this.getComId().compareTo(o.getId());
//    }
}

