package cn.happy.dao;

import cn.happy.beans.product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/19.
 */
@Transactional
@Repository("IproductDao")
public class productDaoImpl implements IproductDao {
    @Resource
    private SessionFactory sessionFactory;

    public List<product> productList() {
        return  sessionFactory.getCurrentSession().createQuery("from product").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
