package cn.happy.hibernate0929left;


/**
 * Created by linlin on 2017/9/24.
 */
public class Emp {
    private Integer empno;
    private String ename;
private Dept dept;

    public Emp(Integer empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
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