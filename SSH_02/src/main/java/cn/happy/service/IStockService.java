package cn.happy.service;


import cn.happy.pojo.Stock;

import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
public interface IStockService {
    public void addStock(Stock stock);
    public List<Stock> stocklist();
}

