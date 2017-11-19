package demo1;

import cn.happy.hibernate0930zujie.Dept;
import cn.happy.hibernate1001zujie.Emp;
import cn.happy.hibernate1001zujie.Idcard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by linlin on 2017/9/30.
 */
public class Test1001 {
    Configuration cfg;
    Transaction tx;
    Session session;
    SessionFactory factory;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("Hibernate1.cfg.xml");
        //根据配置对象创建SessionFactory
        factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

    @Test
    public void Test01() {
        Emp emp = new Emp();
        Idcard idcard = new Idcard();
        emp.setEname("123456789");
        idcard.setInum("987654321");
        idcard.setEmp(emp);
        emp.setIdcard(idcard);
        session.save(idcard);
        tx.commit();

    }
}
