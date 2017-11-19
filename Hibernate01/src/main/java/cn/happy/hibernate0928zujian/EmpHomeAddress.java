package cn.happy.hibernate0928zujian;

/**
 * Created by linlin on 2017/9/28.
 */
public class EmpHomeAddress {
    private String ehomestreet;
    private String ehomecity;
    private String ehomeprovince;
    private String ehomezipcode;
    private EmpInfo empinfo;

    public String getEhomestreet() {
        return ehomestreet;
    }

    public void setEhomestreet(String ehomestreet) {
        this.ehomestreet = ehomestreet;
    }

    public String getEhomecity() {
        return ehomecity;
    }

    public void setEhomecity(String ehomecity) {
        this.ehomecity = ehomecity;
    }

    public String getEhomeprovince() {
        return ehomeprovince;
    }

    public void setEhomeprovince(String ehomeprovince) {
        this.ehomeprovince = ehomeprovince;
    }

    public String getEhomezipcode() {
        return ehomezipcode;
    }

    public void setEhomezipcode(String ehomezipcode) {
        this.ehomezipcode = ehomezipcode;
    }

    public EmpInfo getEmpinfo() {
        return empinfo;
    }

    public void setEmpinfo(EmpInfo empinfo) {
        this.empinfo = empinfo;
    }
}
