package cn.happy.hibernate0701duoduiyi;

/**
 * Created by linlin on 2017/9/24.
 */
public class Dept {
    private Integer deptno;
    private String deptname;

    public Dept() {
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
