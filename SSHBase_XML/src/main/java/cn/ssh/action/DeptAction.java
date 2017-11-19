package cn.ssh.action;

import cn.ssh.beans.Dept;
import cn.ssh.service.DeptService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/29.
 */
public class DeptAction extends ActionSupport{

    private Dept dept;
     private  DeptService  deptService;

    public String add(){
        deptService.addDept(dept);
        return SUCCESS;
    }


    public String list(HttpServletRequest request){
        System.out.println("=========list");
        List<Dept> depts = deptService.DeptList();
        System.out.println(depts.size()+"======da小");
        for(Dept item:depts){
            System.out.println(item.getDeptname());
    }


     ActionContext ac = ActionContext.getContext();

         ac.put("depts", depts);

        return SUCCESS;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public DeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }
}
