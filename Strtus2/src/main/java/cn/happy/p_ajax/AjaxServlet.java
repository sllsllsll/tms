package cn.happy.p_ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by linlin on 2017/10/24.
 */
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("===============");
        String uname = request.getParameter("name");
        if ("admin".equals(uname)) {
            response.getWriter().write("已经存在");
        } else {
            response.getWriter().write("可以注册");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
