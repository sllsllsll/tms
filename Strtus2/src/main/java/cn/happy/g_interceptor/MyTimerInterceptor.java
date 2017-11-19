package cn.happy.g_interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Created by linlin on 2017/10/7.
 */
public class MyTimerInterceptor extends AbstractInterceptor {


    public String intercept(ActionInvocation invocation) throws Exception {
        //具备Action执行权
        long startTime = System.currentTimeMillis();

        //如何放行
        String viewname = invocation.invoke();//放行，控制权交给Action
        System.out.println("viewName:"+viewname+"========");
        long endTime=System.currentTimeMillis();
        long time=endTime-startTime;
        System.out.println(time);
        return viewname;
    }
}
