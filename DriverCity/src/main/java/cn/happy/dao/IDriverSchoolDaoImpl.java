package cn.happy.dao;

import cn.happy.beans.DriverSchool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
@Transactional
@Repository("IDriverSchoolDao")
public class IDriverSchoolDaoImpl implements IDriverSchoolDao{

    @Resource
    private SessionFactory sessionFactory;
    public List<DriverSchool> DriverSchoolList() {
        return  sessionFactory.getCurrentSession().createQuery("from DriverSchool").list();
    }

    public DriverSchool findOne(Integer id) {
        DriverSchool driverSchool = sessionFactory.getCurrentSession().get(DriverSchool.class, id);
        return driverSchool;
    }

    public void updateDept(String name, Integer cityAreaId, String address, String phone,Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update DriverSchool d set d.name=:name,d.cityAreaId=:cityAreaId,d.address=:address,d.phone=:phone where d.id=:id")
                .setParameter("name", name)
                .setParameter("cityAreaId",cityAreaId)
                .setParameter("address",address)
                .setParameter("phone",phone)
                .setParameter("id", id)
                .executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
