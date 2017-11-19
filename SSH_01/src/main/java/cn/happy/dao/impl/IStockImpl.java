package cn.happy.dao.impl;

import cn.happy.beans.Stock;
import cn.happy.dao.IStock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
@Transactional
public class IStockImpl implements IStock {
    //植入一个工厂对象
    private SessionFactory sessionFactory;

    public int addStock(Stock stock) {
        Session currentSession = sessionFactory.getCurrentSession();
        Serializable count = currentSession.save(stock);
        return (Integer) count;
    }

    public void delstock(Integer sid) {
        System.out.println(sid);
      sessionFactory.getCurrentSession().delete(sid);
    }
    //遍历所有
 /*   public List<Stock> stocklist() {
        return  (List<Stock>)getHibernateTemplate()
                .find("from stock");
    }*/



    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
