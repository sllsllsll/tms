package cn.happy.hibernate17;

import java.util.Date;

/**
 * Created by linlin on 2017/9/24.
 */
public class Emp {
    private Integer empno;
    private String enmae;
private Integer deptno;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getEnmae() {
        return enmae;
    }

    public void setEnmae(String enmae) {
        this.enmae = enmae;
    }

    public Integer getEmpno() {

        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    private Dept dept;

    public Dept getDept() {
        return dept;
    }



    public void setDept(Dept dept) {
        this.dept = dept;
    }



   }