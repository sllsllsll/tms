package cn.happy.m_datevalidation;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by linlin on 2017/10/13.
 */
public class ExecunteAction extends ActionSupport{
    private UsersInfo users;
    @Override
    public String execute() throws Exception {
        if(users.getUname().length()==0){
            addFieldError("uname","用户名为空");
        }
        if(users.getUpwd().length()==0){
            addFieldError("upwd","密码为空");
        }
        if(this.hasFieldErrors()){
            return INPUT;
        }
        return SUCCESS;
    }

    public UsersInfo getUsers() {
        return users;
    }

    public void setUsers(UsersInfo users) {
        this.users = users;
    }
}
