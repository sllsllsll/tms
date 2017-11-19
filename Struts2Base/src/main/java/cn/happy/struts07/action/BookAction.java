package cn.happy.struts07.action;

import com.opensymphony.xwork2.Action;

/**
 * Created by Happy on 2017-10-25.
 */
public class BookAction implements Action {
    public String execute() throws Exception {
        System.out.println("bookaction");
        return SUCCESS;
    }
}
