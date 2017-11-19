package cn.happy.hibernate0928;

/**
 * Created by linlin on 2017/9/28.
 */
public class Users1 {
    private Integer userid;
    private String username;
    private String userpass;
    private Resume1 resume1;

    public Users1(String username, String userpass) {
        this.username = username;
        this.userpass = userpass;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public Resume1 getResume1() {
        return resume1;
    }

    public void setResume1(Resume1 resume1) {
        this.resume1 = resume1;
    }
}
