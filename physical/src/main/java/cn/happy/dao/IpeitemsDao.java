package cn.happy.dao;

import cn.happy.beans.peitems;

import java.util.List;

/**
 * Created by linlin on 2017/10/18.
 */
public interface IpeitemsDao {

    public List<peitems> selectName();
    public List<peitems> peiList(Integer typeid);
    public List<peitems> peiList(String typename);
    //根据id获取数据
    public peitems findOne(Integer itemid);
    //修改
    public void updateDept(String itemname,Integer typeid,Integer necessary,String ref,Integer price,String info,Integer itemid);
}
