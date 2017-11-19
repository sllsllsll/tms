package cn.happy.struts07.action;

import cn.happy.struts07.entity.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * Created by linlin on 2017/10/25.
 */
public class LoginAction implements Action{

    private UserInfo user;
    public String execute() throws Exception {

        Map<String,Object> session= ActionContext.getContext().getSession();
       if(user!=null){
           if(user.getUsername().equals("1")&&user.getPassword().equals("1")){
               session.put("uname",user.getUsername());
                       return SUCCESS;
           }else{
               return LOGIN;
           }
       }else{
           if(session!=null&&session.get("uname")!=null){
               return "success";
           }else{
               System.out.println("action中的自定义代码");
               return "login";
           }
       }
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
