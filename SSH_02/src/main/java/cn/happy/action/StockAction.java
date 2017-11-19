package cn.happy.action;

import cn.happy.pojo.Stock;
import cn.happy.service.IStockService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */

@Namespace("/")
@Controller
@Scope("prototype")
@Results( {
        @Result(name = "addStockAction", location = "/index.jsp"),
        @Result(name = "regist",location = "/success.jsp"),
})
public class StockAction extends ActionSupport implements ModelDriven<Stock>{
    private Stock stock=new Stock();


    private IStockService service;
    @Resource
    public void setService(IStockService service) {
        this.service = service;
    }

    @Action("addStockAction")
    public String add(){
        service.addStock(stock);
        return "addStockAction";
    }

    @Action("ListStockAction")
    public String list(HttpServletRequest request){
        System.out.println("===========================");
        List<Stock> stocklist = service.stocklist();
        request.setAttribute("list",stocklist);
        for (Stock item:stocklist) {
            System.out.println(item.getSname());
        }
        return "ListStockAction";
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public IStockService getService() {
        return service;
    }

    public Stock getModel() {
        return stock;
    }
}
