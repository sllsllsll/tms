package cn.happy.service;

import cn.happy.beans.CityArea;
import cn.happy.beans.DriverSchool;
import cn.happy.dao.ICityAreaDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
@Transactional
@Repository("ICityAreaService")
public class ICityAreaServiceImpl implements ICityAreaService {
    @Resource(name="ICityAreaDao")
    private ICityAreaDao dao;
    @Resource
    private SessionFactory sessionFactory;

    public List<CityArea> CityList() {
        return dao.CityList();
    }

    public List<DriverSchool> CityByDriverSchool(String name) {
        return dao.CityByDriverSchool(name);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
