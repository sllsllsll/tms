package cn.happy.hibernate0928zujian;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/9/25.
 */
public class Dept {
    private Integer deptno;
    private String deptname;

    private Set<Emp> emps=new HashSet<Emp>();

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

    public Dept() {
    }

    public Dept(Integer deptno, String deptname) {
        this.deptno = deptno;
        this.deptname = deptname;
    }

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
}
