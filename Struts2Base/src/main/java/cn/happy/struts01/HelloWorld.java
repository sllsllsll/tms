package cn.happy.struts01;

import com.opensymphony.xwork2.Action;

/**
 * Created by linlin on 2017/10/21.
 */
public class HelloWorld implements Action {
    private String name="";
    private String message="";
    public String execute() throws Exception {
        this.setMessage("Hello,"+this.getName());
        return "helloworld";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
