package cn.happy.dao;


import cn.happy.pojo.Stock;

import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */


public interface IStock {
    public void addStock(Stock stock);
    public List<Stock> stocklist();
}

