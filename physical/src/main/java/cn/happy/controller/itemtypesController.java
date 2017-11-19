package cn.happy.controller;

import cn.happy.beans.itemtypes;
import cn.happy.service.IitemtypesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/18.
 */
@Controller
public class itemtypesController {
    @Resource(name="IitemtypesService")
    private IitemtypesService service;

    @RequestMapping("/itemlist")
    public String selectList(HttpServletRequest request){
        List<itemtypes> selectitem = service.selectitem();
        request.setAttribute("list1",selectitem);
        return "List1";
    }

    public IitemtypesService getService() {
        return service;
    }

    public void setService(IitemtypesService service) {
        this.service = service;
    }
}
