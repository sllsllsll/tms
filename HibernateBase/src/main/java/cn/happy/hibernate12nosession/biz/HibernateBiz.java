package cn.happy.hibernate12nosession.biz;

import cn.happy.hibernate12nosession.Emp;
import cn.happy.hibernate12nosession.dao.HibernateDAO;
import cn.happy.hibernate12nosession.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by linlin on 2017/10/9.
 */
public class HibernateBiz {

    HibernateDAO dao=new HibernateDAO();
    public Object get(Class clazz, Serializable id) {
        Transaction tx = HibernateUtil.currentSession().beginTransaction();
        Object obj= dao.get(clazz, id);
       /* Emp emp=(Emp)obj;
        emp.getEname();*/
       if(!Hibernate.isInitialized(obj)){
           Hibernate.initialize(obj);
       }
        System.out.println("==============================================");
        tx.commit();
        HibernateUtil.closeSession();
        return obj;
    }
}
