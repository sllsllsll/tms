package cn.happy.a_Struts2HelloWorld;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by linlin on 2017/10/2.
 */
public class HelloWorldAction implements Action {

    private String uname;

   private String message;
    public String execute() throws Exception {
        this.setMessage("Hello,"+this.getUname()+"!");
        return "success";

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
