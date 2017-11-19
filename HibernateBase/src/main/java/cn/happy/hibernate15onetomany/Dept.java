package cn.happy.hibernate15onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/11.
 */
@Entity
@Table(name="DeptNew")
public class Dept {
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "abc")
    @SequenceGenerator(name="abc",sequenceName = "SEQ_SLL",allocationSize = 1)
    private Integer deptno;
    @Column
    private String deptname;
@OneToMany(mappedBy ="dept",cascade = CascadeType.ALL)
    private Set<Emp> emps=new HashSet<Emp>();

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
