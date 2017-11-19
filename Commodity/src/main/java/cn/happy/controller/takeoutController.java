
package cn.happy.controller;

import cn.happy.beans.product;
import cn.happy.beans.takeout;
import cn.happy.service.IproductService;
import cn.happy.service.ItakeoutSevice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by linlin on 2017/10/19.
 */
@Controller
public class takeoutController {
    @Resource(name="ItakeoutSevice")
    private ItakeoutSevice service;

    @RequestMapping("/toadd")
    public String add(String handler,Integer quantity,Integer productid){
        takeout to=new takeout();
        to.setHandler(handler);
        to.setOutdate(new Date());
        to.setProductid(productid);
        to.setQuantity(quantity);
        //先添加商品出库记录
        service.addtake(to);
        //修改库存

        service.updatetake(to.getQuantity(),to.getProductid());
        return "index";
    }


    public ItakeoutSevice getService() {
        return service;
    }

    public void setService(ItakeoutSevice service) {
        this.service = service;
    }
}
