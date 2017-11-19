package cn.happy.struts03;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by linlin on 2017/10/22.
 */
public class LoginAction implements Action ,ServletRequestAware,ServletContextAware{
    private HttpServletRequest request;
    private ServletContext servletContext;
    public String execute() throws Exception {
        System.out.println("==============");
       //  HttpSession session=request.getSession();

     //   HttpSession session = ServletActionContext.getRequest().getSession();
           // session.setAttribute("username","张三");

       ActionContext context = ActionContext.getContext();
        Map<String, Object> map = context.getSession();
        map.put("uname","hhh99");
//
      /*  HttpServletRequest request = ServletActionContext.getRequest();
        ValueStack vs= (ValueStack)request.getAttribute("struts.valueStack");
        vs.push(map);*/

        //放入值栈
/*        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.push(map);*/

        //servlet  Context
        ServletContext servletContext = ServletActionContext.getServletContext();
       // session.setAttribute("unsame","admin");
        servletContext.setAttribute("userna","Servlet Context 00000000");

            return SUCCESS;

    }

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletContext(ServletContext servletContext111) {
        this.servletContext = servletContext111;
    }
}
