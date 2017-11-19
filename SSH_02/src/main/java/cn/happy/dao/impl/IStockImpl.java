package cn.happy.dao.impl;

import cn.happy.dao.IStock;
import cn.happy.pojo.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by linlin on 2017/10/10.
 */
@Repository
public class IStockImpl extends HibernateDaoSupport implements IStock {
    private SessionFactory sessionFactory;
    @Resource
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void addStock(Stock stock) {
        this.getHibernateTemplate().save(stock);
    }
//遍历所有
    public List<Stock> stocklist() {
        return  (List<Stock>)getHibernateTemplate()
                .find("from stock");
    }


}
