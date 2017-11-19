package cn.happy.hibernate10opensessioninview.filter;

import cn.happy.hibernate10opensessioninview.util.HibernateUtil;
import org.hibernate.Transaction;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by linlin on 2017/10/9.
 */
public class OpenSessionInView implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 请求到达时，打开Session并启动事务
        Transaction tx = null;
        try {
            tx = HibernateUtil.getSession().beginTransaction();
            // 执行请求处理链
            chain.doFilter(request, response);
            // 返回响应时，提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            // 关闭session
        HibernateUtil.closeSession();
        }
    }

    public void destroy() {

    }


}
