package cn.happy.b_Struts2po;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by linlin on 2017/10/2.
 */
public class login extends ActionSupport implements Action {

    private String uname;
    private String password;
    public String execute() throws Exception {
        if("jason".equals(uname)&&"2017".equals(password)){
            Map<String,Object> session=null;
            session= ActionContext.getContext().getSession();
            session.put("CURRENT_USER",uname);
            return Action.SUCCESS;
        }else{
            return Action.ERROR;
        }
    }

    public void validate(){

        if(this.getUname()==null||this.getUname().length()==0){
            addFieldError("name","用户名不能为空");
        }

        if(this.getPassword()==null||this.getPassword().length()==0){
            addFieldError("pwd","密码不能为空");
        }
    }
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
