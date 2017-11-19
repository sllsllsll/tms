package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by linlin on 2017/10/14.
 */
public interface Action {
    public static final String SUCCESS="success";
    public static final String LOGIN="login";
    public String excute(HttpServletRequest request, HttpServletResponse response);
}
