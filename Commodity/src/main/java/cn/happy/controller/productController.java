package cn.happy.controller;

import cn.happy.beans.product;
import cn.happy.service.IproductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/19.
 */
@Controller
public class productController {
    @Resource(name="IproductService")
    private IproductService service;

    @RequestMapping("/prolist")
    public String prolist(HttpServletRequest request){
        System.out.println("===========================");
        List<product> pro= service.productList();
        request.setAttribute("prolist",pro);
        return "Commodity";
    }





    public IproductService getService() {
        return service;
    }

    public void setService(IproductService service) {
        this.service = service;
    }
}
