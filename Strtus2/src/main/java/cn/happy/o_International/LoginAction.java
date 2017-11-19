package cn.happy.o_International;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by linlin on 2017/10/14.
 */
public class LoginAction extends ActionSupport {
    private String uname;
    private String upwd;

    @Override
    public void validate() {
        if(uname.length()==0){
            addFieldError("uname",getText("name.null"));
        }
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
