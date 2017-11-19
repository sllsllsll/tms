package servlet;

import action.Action;
import action.ActionManager;
import action.ActionMapping;
import action.ActionMappingManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by linlin on 2017/10/14.
 */
public class LoginServlet extends HttpServlet {
    ActionMappingManager manager = null;

    private String getClassName(HttpServletRequest request) {
        String uri = request.getRequestURI();//获得uri
        String content = request.getContextPath();
        String result = uri.substring(content.length());
        return result.substring(1, result.lastIndexOf("."));
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doPost(httpServletRequest, httpServletResponse);
        String result = getClassName(httpServletRequest);
        System.out.println(result+"=================");
        ActionMapping actionMapping = manager.getValue(result);
        System.out.println(actionMapping);
        System.out.println(actionMapping+"===");
        String className = actionMapping.getClassName();

        try {
            Action action = ActionManager.getActionClass(className);
            String excute = action.excute(httpServletRequest, httpServletResponse);
            String path= actionMapping.getValue(excute);
            httpServletRequest.getRequestDispatcher(path).forward(httpServletRequest,httpServletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doGet(httpServletRequest, httpServletResponse);

        doPost(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String urls = config.getInitParameter("config");
        String[] files = null;
        if (urls == null) {
            files = new String[]{"myframe.xml"};

        } else {
            files = urls.split(",");
        }
        try {
            manager = new ActionMappingManager(files);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
