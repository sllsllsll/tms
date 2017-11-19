package cn.happy.dao;

import cn.happy.beans.takeout;

import java.util.Date;

/**
 * Created by linlin on 2017/10/19.
 */
public interface ItakeoutDao {
    //添加出库商品的同时 把库存修改一下
    //添加
  public int addtake(takeout to);

    //修改库存
    public void updatetake(Integer quantity,Integer id);
}
