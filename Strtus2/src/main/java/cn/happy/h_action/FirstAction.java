package cn.happy.h_action;

import cn.happy.i_ognl_entity.Address;
import cn.happy.i_ognl_entity.UseInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by linlin on 2017/10/7.
 */
public class FirstAction extends ActionSupport implements ModelDriven<UseInfo>{
    private UseInfo info=new UseInfo();

// private List<UseInfo> list=new ArrayList<UseInfo>();
    @Override
    public String execute() throws Exception {
        info.setUname("哈哈");
        info.getAddresss().setStreet("诚信路");

        List<UseInfo> list=new ArrayList<UseInfo>();

        UseInfo info2=new UseInfo("Userinfo2===",new Address());
       info2.setMydate(new Date());
        list.add(new UseInfo("你的名字",new Address()));
        list.add(new UseInfo("摔跤吧 爸爸",new Address()));
       // 将list放入到哪里？
      //  值栈中
      //  CompoundRoot root=ActionContext.getContext().getValueStack().getRoot();
     //   root.add(list);


     /*   ActionContext context = ActionContext.getContext();
       Map<String,Object> map=(Map<String,Object>)context.get("request");
       map.put("list",list);*/

        //将集合放入值栈
    /*    ValueStack valueStack =ActionContext.getContext().getValueStack();
      valueStack.getRoot().add(info2);*/
        return SUCCESS;
    }



    public UseInfo getInfo() {
        return info;
    }

    public void setInfo(UseInfo info) {
        this.info = info;
    }

    public UseInfo getModel() {
        return info;
    }
}
