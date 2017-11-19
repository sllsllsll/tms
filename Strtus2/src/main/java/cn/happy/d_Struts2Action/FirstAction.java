package cn.happy.d_Struts2Action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by linlin on 2017/10/3.
 */
public class FirstAction extends ActionSupport {
    public String list(){
        System.out.println("list==============================================");
        return "list";
    }
    public String del(){
        System.out.println("list==============================================");
        return "del";
    }
}
