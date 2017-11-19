package cn.happy.g_interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by linlin on 2017/10/7.
 */
public class FirstAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
//解耦
     //  Map<String,Object> session= ActionContext.getContext().getSession();
     //  Map<String,Object> request= (Map<String,Object>)ActionContext.getContext().get("request");

     //  request.put();
        //耦合
      // HttpServletRequest request = ServletActionContext.getRequest();
      //  HttpSession session = ServletActionContext.getRequest().getSession();
     //  request.setAttribute();

        Thread.sleep(2000);
        return SUCCESS;
    }
}
