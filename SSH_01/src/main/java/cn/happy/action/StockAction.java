package cn.happy.action;

import cn.happy.beans.Stock;
import cn.happy.dao.IStock;
import cn.happy.service.IStockService;
import cn.happy.service.impl.IStockServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
public class StockAction extends ActionSupport implements ModelDriven<Stock> {
    private Stock stock;

    private IStockService service;

    public StockAction() {
    stock=new Stock();
    }

    public Stock getModel() {
        return stock;
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

    public void setService(IStockService service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {
        int count=service.addStock(stock);
        return SUCCESS;
    }
    public String del() throws Exception {
        service.delstock(7);
        return SUCCESS;
    }
}
