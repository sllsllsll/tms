package cn.happy.controller;

import cn.happy.beans.CityArea;
import cn.happy.beans.DriverSchool;
import cn.happy.service.ICityAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
@Controller
public class CityAreaController {
    @Resource(name="ICityAreaService")
    private ICityAreaService service;


    @RequestMapping("/Cilist")
    public String cityList(HttpServletRequest request){
        List<CityArea> cityAreas = service.CityList();
        request.setAttribute("list",cityAreas);
        return "CityList";
    }

    @RequestMapping("/listByName")
    public String cityByselect(String name,HttpServletRequest request){
        List<DriverSchool> driverSchools = service.CityByDriverSchool(name);
        request.setAttribute("listByName",driverSchools);
//================================
        List<CityArea> cityAreas = service.CityList();
        request.setAttribute("list",cityAreas);
        return "CityList";
    }

    public ICityAreaService getService() {
        return service;
    }

    public void setService(ICityAreaService service) {
        this.service = service;
    }
}
