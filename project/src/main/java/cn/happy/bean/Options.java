package cn.happy.bean;

import javax.persistence.*;

/**
 * Created by 张晓宇 on 2017/10/13.
 */
@Entity
@Table
public class Options {
    //id,optcontent,vote,sid
    @Id
    @GeneratedValue
    private Integer id;
    private String optcontent;
    private Integer vote;

    @ManyToOne(targetEntity=Subjects.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="sid")
    private Subjects subjects;

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptcontent() {
        return optcontent;
    }

    public void setOptcontent(String optcontent) {
        this.optcontent = optcontent;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

}
