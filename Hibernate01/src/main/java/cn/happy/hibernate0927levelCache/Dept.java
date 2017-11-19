package cn.happy.hibernate0927levelCache;

/**
 * Created by linlin on 2017/9/25.
 */
public class Dept {
    private Integer deptno;
    private String deptname;

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
