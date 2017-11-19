package cn.happy.hibernate14onetoone;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/11.
 */
@Entity
@Table(name="Humen")
public class Humen {
    @Id
    @GeneratedValue
    private Integer hid;
    private String hname;
    @OneToOne(mappedBy = "humen")
    private Card card;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
