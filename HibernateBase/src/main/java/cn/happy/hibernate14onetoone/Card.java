package cn.happy.hibernate14onetoone;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/11.
 */
@Entity
@Table(name="Card")
public class Card {
    @Id
    @GeneratedValue
    private Integer cid;
    private  String cname;
    @OneToOne()
    @JoinColumn(name="hid2")
    private Humen humen;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Humen getHumen() {
        return humen;
    }

    public void setHumen(Humen humen) {
        this.humen = humen;
    }
}
