package cn.happy.hibernate0926yiduiduo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/9/24.
 */
public class Dept {
    private Integer deptno;
    private String deptname;
//部门记忆员工集合

    private Set<Emp> emps=new HashSet<Emp>();
    public Dept() {
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
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
