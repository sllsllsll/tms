package cn.happy.service;

import cn.happy.beans.CityArea;
import cn.happy.beans.DriverSchool;

import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
public interface ICityAreaService {
    public List<CityArea>  CityList();
    //查询指定城区的驾校
    public List<DriverSchool> CityByDriverSchool(String cname);
}
