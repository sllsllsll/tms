package cn.ssh.action;

import cn.ssh.beans.Dept;
import cn.ssh.service.DeptService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/29.
 */
@Controller("deptAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class DeptAction extends ActionSupport {

    private Dept dept;

    @Resource(name = "DeptService")
    private DeptService deptService;

    @Action(value = "add", results = {@Result(name = "success", location = "/index.jsp")})
    public String add() {
        System.out.println(dept);
        deptService.addDept(dept);
        return SUCCESS;
    }


    @Action(value = "del", results = {@Result(name = "success", location = "/index.jsp")})
    public String del(Integer deptno) {
        System.out.println("===============del");
        System.out.println(dept);
        deptService.delDept(deptno);
        return SUCCESS;
    }

    @Action(value = "list", results = {@Result(name = "success", location = "/addDept.jsp")})
    public String list(HttpServletRequest request) {
        List<Dept> depts = deptService.DeptList();
        request.setAttribute("Deptlist",depts);
        for (Dept item:depts) {
            System.out.println(item.getDeptname()+"============================");
        }
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
