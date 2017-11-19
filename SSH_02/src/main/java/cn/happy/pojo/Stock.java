package cn.happy.pojo;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/10.
 */
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    private int sid;
    @Column
    private String sname;
    @Column(name = "count")
    private int scount;

    public Stock() {
    }

    public Stock(String sname, int scount) {
        this.sname = sname;
        this.scount = scount;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getScount() {
        return scount;
    }

    public void setScount(int scount) {
        this.scount = scount;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", scount=" + scount +
                '}';
    }
}
