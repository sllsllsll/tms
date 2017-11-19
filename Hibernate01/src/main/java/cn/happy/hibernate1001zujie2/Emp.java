package cn.happy.hibernate1001zujie2;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/1.
 */
@Entity(name="Emp02")
public class Emp {
    @Id
    @GeneratedValue
    private Integer eid;
    @Column
    private String ename;
    @ManyToOne
    private Dept dept;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
