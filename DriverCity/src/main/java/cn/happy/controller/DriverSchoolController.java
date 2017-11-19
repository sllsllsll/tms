package cn.happy.controller;

import cn.happy.beans.CityArea;
import cn.happy.beans.DriverSchool;
import cn.happy.service.ICityAreaService;
import cn.happy.service.IDriverSchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
@Controller
public class DriverSchoolController {
    @Resource(name="IDriverSchoolService")
    private IDriverSchoolService service;


    @RequestMapping("/Drlist")
    public String DrList(HttpServletRequest request){
        List<DriverSchool> driverSchools = service.DriverSchoolList();
        request.setAttribute("listDr",driverSchools);
        return "DriverSchoolList";
    }
    //根据id查询 指定驾校
    @RequestMapping("/listfind")
    public String listfind(Integer id,HttpServletRequest request) {
        DriverSchool one =service.findOne(id);
        request.setAttribute("listone",one);

        List<DriverSchool> driverSchools = service.DriverSchoolList();
        request.setAttribute("listDr",driverSchools);
        return "DriverSchoolList";
    }

    @RequestMapping("/listfindBy")
    public String listfinds(Integer id,HttpServletRequest request) {
        DriverSchool one =service.findOne(id);
        request.setAttribute("listone",one);
        return "/update";
    }

    //根据id进行修改
    @RequestMapping("/updates")
    public String updateDept(String name, Integer cityAreaId, String address, String phone, Integer id,HttpServletRequest request) {
        System.out.println("================================================");
        System.out.println(name);
        service.updateDept(name,cityAreaId,address,phone,id);
        return "redirect:/Drlist";

    }
    public IDriverSchoolService getService() {
        return service;
    }

    public void setService(IDriverSchoolService service) {
        this.service = service;
    }
}
