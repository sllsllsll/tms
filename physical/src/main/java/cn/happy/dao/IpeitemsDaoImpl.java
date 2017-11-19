package cn.happy.dao;

import cn.happy.beans.itemtypes;
import cn.happy.beans.peitems;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/18.
 */
@Transactional
@Repository("IpeitemsDao")
public class IpeitemsDaoImpl implements IpeitemsDao {
    @Resource
    private SessionFactory sessionFactory;

    public List<peitems> selectName() {
        return sessionFactory.getCurrentSession().createQuery("from peitems").list();
    }

    public List<peitems> peiList(Integer typeid) {
        return sessionFactory.getCurrentSession().
                createQuery("select itemid,itemname,necessary,ref,price,info  from peitems p,itemtypes i where p.typeid=i.typeid and p.typeid=?")
                .setParameter(0,typeid)
                .list();
    }

    public List<peitems> peiList(String typename) {
        return sessionFactory.getCurrentSession().
                createQuery("from peitems where typename=?")
                .setParameter(0,typename)
                .list();
    }

    public peitems findOne(Integer id) {
        peitems driverSchool = sessionFactory.getCurrentSession().get(peitems.class, id);
        return driverSchool;
    }

    public void updateDept(String itemname, Integer typeid, Integer necessary, String ref, Integer price, String info,Integer itemid) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(itemname+"===");
        session.createQuery("update peitems d set d.itemname=:itemname,d.typeid=:typeid,d.necessary=:necessary,d.ref=:ref,d.price=:price,d.info=:info where d.itemid=:itemid")
                .setParameter("itemname", itemname)
                .setParameter("typeid",typeid)
                .setParameter("necessary",necessary)
                .setParameter("ref",ref)
                .setParameter("price", price)
                .setParameter("info",info)
                .setParameter("itemid", itemid)
                .executeUpdate();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
