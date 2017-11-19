package cn.happy.service;

import cn.happy.beans.DriverSchool;
import cn.happy.dao.IDriverSchoolDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
@Transactional
@Repository("IDriverSchoolService")
public class IDriverSchoolServiceImpl implements IDriverSchoolService{
    @Resource(name="IDriverSchoolDao")
    private IDriverSchoolDao dao;

    @Resource
    private SessionFactory sessionFactory;
    public List<DriverSchool> DriverSchoolList() {
        return  dao.DriverSchoolList();
    }

    public DriverSchool findOne(Integer id) {
        return dao.findOne(id);
    }

    public void updateDept(String name, Integer cityAreaId, String address, String phone, Integer id) {
        dao.updateDept(name,cityAreaId,address,phone,id);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
