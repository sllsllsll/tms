package cn.happy.service.impl;

import cn.happy.beans.Stock;
import cn.happy.dao.IStock;
import cn.happy.service.IStockService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
@Transactional
public class IStockServiceImpl implements IStockService {
    private IStock dao;


    public int addStock(Stock stock) {

        return dao.addStock(stock);
    }

    public void delstock(Integer sid) {
        dao.delstock(sid);
    }


    public IStock getDao() {
        return dao;
    }

    public void setDao(IStock dao) {
        this.dao = dao;
    }
}
