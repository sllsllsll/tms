package cn.tms.controller;
import cn.tms.service.ICm_columnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by linlin on 2017/11/6.
 */
@Controller
@RequestMapping("/cm")
public class Cm_columnController {
    @Resource(name="cm_columnservice")
    private ICm_columnService service;



/*    @RequestMapping("cmList")
    public Object cmList(){

    }*/
    public ICm_columnService getService() {
        return service;
    }

    public void setService(ICm_columnService service) {
        this.service = service;
    }
}
