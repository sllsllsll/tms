package cn.happy.service;

import cn.happy.beans.takeout;

/**
 * Created by linlin on 2017/10/19.
 */
public interface ItakeoutSevice {
    //添加出库商品的同时 把库存修改一下
    //添加
    public int addtake(takeout to);
    //修改库存
    public void updatetake(Integer quantity, Integer id);
}
