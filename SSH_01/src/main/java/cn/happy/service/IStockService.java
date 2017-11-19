package cn.happy.service;

import cn.happy.beans.Stock;

import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
public interface IStockService{
    public int addStock(Stock stock);
    public void delstock(Integer sid);
}

