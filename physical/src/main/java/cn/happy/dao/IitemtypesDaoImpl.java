package cn.happy.dao;

import cn.happy.beans.itemtypes;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/18.
 */
@Transactional
@Repository("IitemtypesDao")
public class IitemtypesDaoImpl implements IitemtypesDao{
    @Resource
    private SessionFactory sessionFactory;
    public List<itemtypes> selectitem() {
        return sessionFactory.getCurrentSession().createQuery("from itemtypes").list();
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
