package cn.happy.dao;

import cn.happy.beans.CityArea;
import cn.happy.beans.DriverSchool;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/17.
 */
@Transactional
@Repository("ICityAreaDao")
public class ICityAreaDaoImpl implements ICityAreaDao {
    @Resource
    private SessionFactory sessionFactory;

    public List<CityArea> CityList() {
        return sessionFactory.getCurrentSession().createQuery("from CityArea").list();
    }

    public List<DriverSchool> CityByDriverSchool(String name) {
        String hql=" select d.name from DriverSchool d inner join fetch c.CityArea where c.name=?";
        System.out.println(hql+"=========hql");
        Query query1=sessionFactory.getCurrentSession().createQuery(hql);
        System.out.println(query1);
         query1.setParameter(0, name);
        return query1.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
