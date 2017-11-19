package cn.happy.controller;

import cn.happy.beans.Dept;
import cn.happy.service.IDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by linlin on 2017/10/13.
 */
@Controller
public class DeptController {
    @Resource(name="deptService")
    private IDeptService deptService;
    //添加数据

    @RequestMapping("/adds")
    public String add(Dept dept){
        deptService.addDept(dept);
        return "index";
    }

    //显示数据
    @RequestMapping("/listadd")
    public String list(HttpServletRequest request,HttpServletResponse response){
        System.out.println("==============================");
        List<Dept> listdept = deptService.listdept();
        request.setAttribute("listdept",listdept);
        for (Dept item:listdept){
            System.out.println(item.getDeptname());
        }
        return "add";
    }
    //根据id查询   赋值
    @RequestMapping("/listfind")
    public String listfind(Integer deptno,HttpServletRequest request) {
        Dept one = deptService.findOne(deptno);
      request.setAttribute("listone",one);
        System.out.println(one.getDeptname());
        return "/update";
    }

    //删除数据

    @RequestMapping("/listdel")
    public String list(Integer deptno,HttpServletRequest request) {
        deptService.dellist(deptno);
        return "redirect:/listadd";

    }
    //修改数据

    @RequestMapping("/updates")
    public String updatlist(String deptname,Integer deptno,HttpServletRequest request) {
        System.out.println("================================================");
        System.out.println(deptname);
        deptService.updateDept(deptname,deptno);
        return "redirect:/listadd";

    }
    public IDeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(IDeptService deptService) {
        this.deptService = deptService;
    }
}
