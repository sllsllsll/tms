package cn.happy.hibernate0929left;

import java.util.Date;

/**
 * Created by linlin on 2017/9/29.
 */
public class Employee {
    private Long empno;
    private String enmae;
    private String job;
    private Long mgr;
    private Date hiredate;
    private Long sal;
    private Long comm;
    private Integer deptno;

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

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}
