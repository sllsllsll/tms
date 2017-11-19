package cn.happy.m_datevalidation;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by linlin on 2017/10/13.
 */
public class UserAction extends ActionSupport{
    private UsersInfo users;
    @Override
    public void validate() {
        if(users.getUname().length()==0){
            addFieldError("uname","用户名为空");
        }
        if(users.getUpwd().length()==0){
            addFieldError("upwd","密码为空");
        }
    }

    public void validateRegist(){
//限定用户名密码长度
        if(users.getUname().length()<6||users.getUname().length()>15){
            addFieldError("uname","用户名长度必须在6~15之间");

        }
        if(users.getUpwd().length()<6||users.getUpwd().length()>12){
            addFieldError("upwd","密码长度必须在6~12之间");

        }

    }

    public String regist(){
        return SUCCESS;
    }


    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public UsersInfo getUsers() {
        return users;
    }

    public void setUsers(UsersInfo users) {
        this.users = users;
    }
}
