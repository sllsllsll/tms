package cn.happy.hibernate0928zujian;

/**
 * Created by linlin on 2017/9/28.
 */
public class EmpInfo {

    private Integer eid;
    private String ename;
    private EmpHomeAddress ehome;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public EmpHomeAddress getEhome() {
        return ehome;
    }

    public void setEhome(EmpHomeAddress ehome) {
        this.ehome = ehome;
    }
}
