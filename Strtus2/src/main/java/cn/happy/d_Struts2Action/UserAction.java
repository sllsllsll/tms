package cn.happy.d_Struts2Action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by linlin on 2017/10/3.
 */
public class UserAction extends ActionSupport{
    public String del(){

        return "del";
    }
    public String list(){

        return "list";
    }
    public String add(){

        return "add";
    }
}
