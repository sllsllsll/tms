package cn.happy.service;

import cn.happy.beans.DriverSchool;

import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
public interface IDriverSchoolService {
    public List<DriverSchool>  DriverSchoolList();
    //根据id获取数据
    public DriverSchool findOne(Integer id);
    //修改
    public void updateDept(String name,Integer cityAreaId,String address,String phone,Integer id);
}
