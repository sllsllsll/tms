package cn.happy.i_ognl_entity;

import java.util.Date;

/**
 * Created by linlin on 2017/10/7.
 */
public class UseInfo {
    private String uname;
    private Address addresss=new Address();
    private Date mydate;

    public Date getMydate() {
        return mydate;
    }

    public void setMydate(Date mydate) {
        this.mydate = mydate;
    }

    public Address getAddresss() {
        return addresss;
    }

    public void setAddresss(Address addresss) {
        this.addresss = addresss;
    }

    public String getUname() {

        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public UseInfo(String uname, Address addresss) {
        this.uname = uname;
        this.addresss = addresss;
    }

    public UseInfo() {
    }
}
