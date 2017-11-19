package cn.happy.c_Strurs2iterator;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlin on 2017/10/2.
 */
public class IteratorAction extends ActionSupport{

    private List<String> list;
    public String execute() throws Exception {
        list=new ArrayList<String>();
        list.add("jack");
        list.add("Mark");
        list.add("Bob");
        list.add("susu");
       return Action.SUCCESS;

    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
