package cn.happy.hibernate1001zujie;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/1.
 */
@Entity(name="Idcard2")
public class Idcard {
    @Id
    @GeneratedValue
    private Integer iid;
    private String inum;
    @OneToOne(mappedBy = "idcard",cascade = CascadeType.ALL)
    private Emp emp;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getInum() {
        return inum;
    }

    public void setInum(String inum) {
        this.inum = inum;
    }
}
