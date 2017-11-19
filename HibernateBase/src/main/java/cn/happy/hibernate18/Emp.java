package cn.happy.hibernate18;

import cn.happy.hibernate03hql.conEmp;

import java.util.Date;

/**
 * Created by linlin on 2017/9/25.
 */
public class Emp {
    private Long empno;
    private String enmae;
    private String job;
    private Long mgr;
    private Date hiredate;
    private Long sal;
    private Long comm;
    private Byte deptno;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }



    public void setDept(Dept dept) {
        this.dept = dept;
    }



    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public String getEnmae() {
        return enmae;
    }

    public void setEnmae(String enmae) {
        this.enmae = enmae;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getMgr() {
        return mgr;
    }

    public void setMgr(Long mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Long getSal() {
        return sal;
    }

    public void setSal(Long sal) {
        this.sal = sal;
    }

    public Long getComm() {
        return comm;
    }

    public void setComm(Long comm) {
        this.comm = comm;
    }

    public Byte getDeptno() {
        return deptno;
    }

    public void setDeptno(Byte deptno) {
        this.deptno = deptno;
    }
}
