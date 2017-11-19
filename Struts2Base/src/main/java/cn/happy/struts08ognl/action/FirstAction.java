package cn.happy.struts08ognl.action;

import cn.happy.struts08ognl.entity.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlin on 2017/10/27.
 */
public class FirstAction implements Action{
    public String execute() throws Exception {
        UserInfo info=new UserInfo();
        info.setName("素素");

        UserInfo info2=new UserInfo();
        info.setName("素素2");

        //将info队形推入值栈

        //获取到值栈
        ValueStack valueStack = ActionContext.getContext().getValueStack();
      //  valueStack.getRoot().push(info);
      //  valueStack.push(info);

       /* List<UserInfo> list=new ArrayList<UserInfo>();
        list.add(info);
        list.add(info2);
        valueStack.getContext().put("list",list);*/

        ServletActionContext.getRequest().setAttribute("info",info);
        return SUCCESS;
    }
}
