package cn.happy.struts04;

        import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by linlin on 2017/10/23.
 */
public class FirstAction  extends ActionSupport{

    public String list(){
        System.out.println("list");
        return "list";
    }
    public String del(){
        System.out.println("del");
        return "del";
    }
}
