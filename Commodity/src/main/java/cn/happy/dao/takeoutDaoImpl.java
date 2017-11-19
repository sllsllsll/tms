package cn.happy.dao;

import cn.happy.beans.takeout;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by linlin on 2017/10/19.
 */
@Transactional
@Repository("ItakeoutDao")
public class takeoutDaoImpl implements ItakeoutDao {

    @Resource
    private SessionFactory sessionFactory;
    public int addtake(takeout to) {
        Serializable count = sessionFactory.getCurrentSession().save(to);
        return (Integer) count;
    }

    public void updatetake(Integer quantity, Integer productid) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update product d set d.quantity=d.quantity-?  where d.id=?")
                .setParameter(0, quantity)
                .setParameter(1,productid)
                .executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
