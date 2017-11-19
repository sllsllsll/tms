package cn.happy.beans;

/**
 * Created by linlin on 2017/10/10.
 */
public class Stock {

    private Integer sid;
    private String sname;
    private Integer scount;

    public Stock() {
    }

    public Stock(String sname, Integer scount) {
        this.sname = sname;
        this.scount = scount;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }
}
