package cn.happy.hibernate15onetomany;

import cn.happy.hibernate07onttomany.*;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/11.
 */
@Entity
@Table(name="EmpNew")
public class Emp {
    @Id
    @GeneratedValue
    private Integer eid;
    @Column
    private String ename;
    @ManyToOne
    @JoinColumn(name="did")
    private Dept dept;

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
