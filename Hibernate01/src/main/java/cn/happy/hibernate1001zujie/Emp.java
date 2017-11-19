package cn.happy.hibernate1001zujie;
import javax.persistence.*;

/**
 * Created by linlin on 2017/10/1.
 */
@Entity(name="Emp2")
public class Emp {
    @Id
    @GeneratedValue
    private Integer eid;
    private String ename;
    @OneToOne
    private Idcard idcard;

    public Idcard getIdcard() {
        return idcard;
    }

    public void setIdcard(Idcard idcard) {
        this.idcard = idcard;
    }

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
}
