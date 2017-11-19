package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by linlin on 2017/10/14.
 */
public class LoginAction implements Action{

    public String excute(HttpServletRequest request, HttpServletResponse response) {
     String name=request.getParameter("name");
     if(name.equals("sa")){
         return SUCCESS;
     }else{
         return LOGIN;
     }
    }
}
