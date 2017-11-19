package cn.happy.hibernate0928;

/**
 * Created by linlin on 2017/9/28.
 */
public class Resume1 {
    private Integer resid;
    private String resname;
    private String rescardno;
    private Users1 users1;

    public Integer getResid() {
        return resid;
    }

    public Resume1(String resname, String rescardno) {
        this.resname = resname;
        this.rescardno = rescardno;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public String getRescardno() {
        return rescardno;
    }

    public void setRescardno(String rescardno) {
        this.rescardno = rescardno;
    }

    public Users1 getUsers1() {
        return users1;
    }

    public void setUsers1(Users1 users1) {
        this.users1 = users1;
    }
}
