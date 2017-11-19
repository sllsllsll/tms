package cn.happy.struts07.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * Created by linlin on 2017/10/25.
 */
public class MyInterceptor implements Interceptor {
    public void destroy() {

    }

    public void init() {
        System.out.println("拦截器已经初始化成功了。。。。");
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("对象" + invocation);
        Object action = invocation.getAction();
        String value;
        Map<String, Object> session = ActionContext.getContext().getSession();
        Object name = session.get("uname");
        String actionName = invocation.getProxy().getActionName();
        invocation.getProxy().getNamespace();
        if (actionName.equals("login")) {
            value = invocation.invoke();
        } else if (name != null) {
            value = invocation.invoke();
            String method = invocation.getProxy().getMethod();
            System.out.println("方法：" + method);
        } else {

            value = "login";
        }
        System.out.println("逻辑视图名" + value);
        return value;
    }
}
