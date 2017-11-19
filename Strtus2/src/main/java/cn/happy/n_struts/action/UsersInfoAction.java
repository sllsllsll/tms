package cn.happy.n_struts.action;

import cn.happy.n_struts.entity.UsersInfo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by linlin on 2017/10/13.
 */
public class UsersInfoAction extends ActionSupport {
private UsersInfo users;

    public UsersInfo getUsers() {
        return users;
    }

    public void setUsers(UsersInfo users) {
        this.users = users;
    }
}
