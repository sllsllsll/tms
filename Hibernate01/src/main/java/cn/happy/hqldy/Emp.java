package cn.happy.hqldy;

import java.util.Date;

/**
 * Created by linlin on 2017/9/24.
 */
public class Emp {
    private Long empno;
    private String enmae;
    private String job;
    private Long mgr;
    private Date hiredate;
    private Long sal;
    private Long comm;
private Date hiredateStart;
private Date hiredateEnd;

    public Date getHiredateStart() {
        return hiredateStart;
    }

    public void setHiredateStart(Date hiredateStart) {
        this.hiredateStart = hiredateStart;
    }

    public Date getHiredateEnd() {
        return hiredateEnd;
    }

    public void setHiredateEnd(Date hiredateEnd) {
        this.hiredateEnd = hiredateEnd;
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
}
