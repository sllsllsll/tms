package cn.happy.hibernate0929left;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/9/25.
 */
public class Dept2 {
    private Integer deptno;
    private String DNAME;
    private String loc;


    private Set<Emp> emps=new HashSet<Emp>();

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

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
