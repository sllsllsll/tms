package cn.happy.struts08ognl.entity;

/**
 * Created by linlin on 2017/10/27.
 */
public class UserInfo {
    private String name;
    private String pwd;
    private Address address=new Address();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
