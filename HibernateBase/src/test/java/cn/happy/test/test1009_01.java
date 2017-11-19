package cn.happy.test;



import cn.happy.hibernate12nosession.Emp;
import cn.happy.hibernate12nosession.biz.HibernateBiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * Created by linlin on 2017/9/22.
 */
public class test1009_01 {
    Configuration cfg;
    Transaction tx;
    Session session;
    SessionFactory factory;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("Hibernate.cfg.xml");
        //根据配置对象创建SessionFactory
        factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }



    //no-session
    @Test
    public void loadGetTest() {
        HibernateBiz biz = new HibernateBiz();
       Emp emp = (Emp) biz.get(Emp.class, 1);
        System.out.println(emp.getEname());
    }
}

