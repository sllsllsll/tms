package cn.happy.struts02;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by linlin on 2017/10/22.
 */
public class UserAction implements Action,ModelDriven<UserInfo> {
    private UserInfo user=new UserInfo();

    public String execute() throws Exception {

        if(user.getName().equals("admin")&&user.getPwd().equals("1")){
            return SUCCESS;
        }
       return INPUT;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public UserInfo getModel() {
        return user;
    }
}
