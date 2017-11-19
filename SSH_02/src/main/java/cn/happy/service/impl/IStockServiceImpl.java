package cn.happy.service.impl;

import cn.happy.dao.IStock;
import cn.happy.dao.impl.IStockImpl;
import cn.happy.pojo.Stock;
import cn.happy.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
@Transactional
@Service("service")
public class IStockServiceImpl implements IStockService {
    private IStockImpl dao;


    @Resource
    public void setDao(IStockImpl dao) {
        this.dao = dao;
    }

    public IStockImpl getDao() {
        return dao;
    }
/////方法
    public void addStock(Stock stock) {
       dao.addStock(stock);
    }

    public List<Stock> stocklist() {
        return dao.stocklist();
    }


}
