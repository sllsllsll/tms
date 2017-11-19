package cn.happy.dao;

import cn.happy.beans.Stock;

import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
public interface IStock {
    //xml版的添加
    public int addStock(Stock stock);
    //xml版的显示列表
/*    public List<Stock> stocklist();*/
    public void delstock(Integer sid);

}

