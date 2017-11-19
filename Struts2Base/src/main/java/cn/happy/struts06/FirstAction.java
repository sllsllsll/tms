package cn.happy.struts06;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.xml.soap.SAAJResult;
import java.util.Map;

/**
 * Created by linlin on 2017/10/23.
 */
public class FirstAction extends ActionSupport{

    public String list(){
      Map<String,Object> request= (Map<String,Object>)ActionContext.getContext().get("request");
       request.put("uname","张三");
        System.out.println("list");
    return "list";
    }
    public String del(){
        System.out.println("del");
        return "del";
    }
    public String add(){
     Map<String,Object> request= (Map<String,Object>)ActionContext.getContext().get("request");
    Object uname=request.get("uname");
      System.out.println(uname);
    request.put("info","数据");
        System.out.println("add");
        return "add";
    }
}
