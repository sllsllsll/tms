package cn.happy.hibernate10opensessioninview.biz;

import cn.happy.hibernate10opensessioninview.dao.HibernateDAO;


import java.io.Serializable;

/**
 * Created by linlin on 2017/10/9.
 */
public class HibernateBiz {

    HibernateDAO dao=new HibernateDAO();
    public Object get(Class clazz, Serializable id) {
       /* Transaction tx = HibernateUtil.currentSession().beginTransaction();*/
        Object obj= dao.get(clazz, id);
       /* Emp emp=(Emp)obj;
        emp.getEname();*/
      /* if(!Hibernate.isInitialized(obj)){
           Hibernate.initialize(obj);
       }
        System.out.println("==============================================");
        tx.commit();*/
/*        HibernateUtil.closeSession();*/
        return obj;
    }
}
