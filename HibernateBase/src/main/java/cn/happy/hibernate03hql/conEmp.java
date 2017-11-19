package cn.happy.hibernate03hql;

import java.util.Date;

/**
 * Created by linlin on 2017/9/25.
 */
public class conEmp {
    private Date hiredateEnd;
    private Date hiredateStart;
    private String job;
    private Long sal;


    public conEmp(Date hiredateEnd, Date hiredateStart, String job, Long sal) {
        this.hiredateEnd = hiredateEnd;
        this.hiredateStart = hiredateStart;
        this.job = job;
        this.sal = sal;
    }

    public conEmp() {
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public Long getSal() {
        return sal;
    }

    public void setSal(Long sal) {
        this.sal = sal;
    }

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

}
